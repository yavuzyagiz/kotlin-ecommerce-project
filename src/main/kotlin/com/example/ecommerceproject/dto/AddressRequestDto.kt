package com.example.ecommerceproject.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero
import javax.validation.constraints.Size

data class AddressRequestDto(
    @field:NotBlank
    val city: String,
    @field:NotBlank
    val street: String?,
    @field:Size(min = 2, max = 16)
    val postalCode: String?,
    @field:NotBlank
    val detail: String?,
    @field:PositiveOrZero
    val customerId: Long?
)