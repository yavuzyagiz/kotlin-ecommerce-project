package com.example.ecommerceproject.mapper

import com.example.ecommerceproject.dto.CustomerResponseDto
import com.example.ecommerceproject.model.Customer
import org.springframework.stereotype.Component

@Component
class CustomerMapper : Mapper<CustomerResponseDto, Customer> {

    override fun fromEntity(entity: Customer): CustomerResponseDto = CustomerResponseDto(
        entity.id,
        entity.firstName,
        entity.lastName,
        entity.email
    )
}