package com.example.ecommerceproject.service

import com.example.ecommerceproject.dto.CustomerResponseDto
import com.example.ecommerceproject.mapper.CustomerMapper
import com.example.ecommerceproject.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerMapper: CustomerMapper
) {

    fun findCustomerById(customerId: Long): CustomerResponseDto {
        return customerMapper
            .fromEntity(customerRepository
                .findById(customerId)
                .orElseThrow {
                    IllegalArgumentException("Customer(id=$customerId) could not be found!")
                })
    }



}