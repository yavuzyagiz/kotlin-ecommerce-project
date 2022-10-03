package com.example.ecommerceproject.dto

import com.example.ecommerceproject.model.Address


data class CustomerRequestDto(
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val addressId: Long?
)