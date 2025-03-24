package com.example.baitap1api.data.model

import com.google.gson.annotations.SerializedName

data class TaskResponse(
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    
    @SerializedName("message")
    val message: String,
    
    @SerializedName("data")
    val data: List<Task>
) 