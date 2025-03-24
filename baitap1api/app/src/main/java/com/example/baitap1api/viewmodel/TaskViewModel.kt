package com.example.baitap1api.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baitap1api.data.model.Task
import com.example.baitap1api.data.network.ApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = _tasks

    private val _currentTask = MutableLiveData<Task?>()
    val currentTask: LiveData<Task?> get() = _currentTask

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    private val apiService: ApiService

    init {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://amock.io/api/researchUTH/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        apiService = retrofit.create(ApiService::class.java)
        fetchTasks()
    }

    fun fetchTasks() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                val response = apiService.getTasks()
                Log.d("TaskViewModel", "Response URL: ${response.raw().request.url}")
                Log.d("TaskViewModel", "Response Code: ${response.code()}")
                Log.d("TaskViewModel", "Response Body: ${response.body()}")
                
                if (response.isSuccessful) {
                    val taskResponse = response.body()
                    if (taskResponse?.isSuccess == true) {
                        _tasks.value = taskResponse.data
                        Log.d("TaskViewModel", "Tasks loaded successfully: ${taskResponse.data.size} tasks")
                    } else {
                        val errorMsg = "API Error: ${taskResponse?.message ?: "Unknown error"}"
                        _error.value = errorMsg
                        Log.e("TaskViewModel", errorMsg)
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    val errorMsg = "HTTP Error ${response.code()}: $errorBody"
                    _error.value = errorMsg
                    Log.e("TaskViewModel", errorMsg)
                }
            } catch (e: Exception) {
                val errorMsg = buildString {
                    append("Network Error: ${e.message}\n")
                    append("Type: ${e.javaClass.simpleName}\n")
                    append("Stack Trace:\n")
                    e.stackTrace.take(5).forEach { append("at $it\n") }
                }
                _error.value = errorMsg
                Log.e("TaskViewModel", errorMsg, e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchTaskById(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            try {
                Log.d("TaskViewModel", "Fetching task with ID: $id")
                
                // Tìm trong cache trước
                val cachedTask = _tasks.value?.find { it.id == id }
                if (cachedTask != null) {
                    Log.d("TaskViewModel", "Found task in cache: $cachedTask")
                    _currentTask.value = cachedTask
                    _isLoading.value = false
                    return@launch
                }
                
                Log.d("TaskViewModel", "Task not found in cache, fetching from API...")
                val response = apiService.getTaskById(id)
                Log.d("TaskViewModel", "API Response URL: ${response.raw().request.url}")
                Log.d("TaskViewModel", "API Response Code: ${response.code()}")
                Log.d("TaskViewModel", "API Response Body: ${response.body()}")
                
                if (response.isSuccessful) {
                    val task = response.body()
                    if (task != null) {
                        _currentTask.value = task
                        Log.d("TaskViewModel", "Task loaded from API: $task")
                    } else {
                        val errorMsg = "API returned null task for ID: $id"
                        _error.value = errorMsg
                        Log.e("TaskViewModel", errorMsg)
                        _currentTask.value = null
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    val errorMsg = buildString {
                        append("Failed to load task $id\n")
                        append("HTTP Error ${response.code()}\n")
                        append("Error Body: $errorBody\n")
                        append("URL: ${response.raw().request.url}")
                    }
                    _error.value = errorMsg
                    Log.e("TaskViewModel", errorMsg)
                    _currentTask.value = null
                }
            } catch (e: Exception) {
                val errorMsg = buildString {
                    append("Error fetching task $id\n")
                    append("Type: ${e.javaClass.simpleName}\n")
                    append("Message: ${e.message}\n")
                    append("Stack Trace:\n")
                    e.stackTrace.take(5).forEach { append("at $it\n") }
                }
                _error.value = errorMsg
                Log.e("TaskViewModel", errorMsg, e)
                _currentTask.value = null
            } finally {
                _isLoading.value = false
            }
        }
    }
}