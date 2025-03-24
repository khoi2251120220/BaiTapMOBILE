package com.example.baitap1api.data.network

import com.example.baitap1api.data.model.Task
import com.example.baitap1api.data.model.TaskResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("tasks")
    suspend fun getTasks(): Response<TaskResponse>

    @GET("task/{id}")
    suspend fun getTaskById(@Path("id") id: Int): Response<Task>
}