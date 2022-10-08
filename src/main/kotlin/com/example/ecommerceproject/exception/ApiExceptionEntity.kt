package com.example.ecommerceproject.exception

data class ApiExceptionEntity(
    val message:String?,
    val throwable: Throwable? = null,
)