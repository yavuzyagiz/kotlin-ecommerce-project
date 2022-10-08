package com.example.ecommerceproject.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CustomerRequestDto(
    @field:NotBlank
    val firstName: String?,
    @field:NotBlank
    val lastName: String?,
    @field:Email
    val email: String?
)