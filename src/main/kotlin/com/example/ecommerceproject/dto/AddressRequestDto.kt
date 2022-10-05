package com.example.ecommerceproject.dto

data class AddressRequestDto(
    val city: String?,
    val street: String?,
    val postalCode: String?,
    val detail: String?,
    val customerId: Long?
)