package com.example.ecommerceproject.service

import com.example.ecommerceproject.dto.CustomerRequestDto
import com.example.ecommerceproject.dto.CustomerResponseDto
import com.example.ecommerceproject.mapper.CustomerMapper
import com.example.ecommerceproject.model.Customer
import com.example.ecommerceproject.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

/**
 * @author yz
 * */

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val customerMapper: CustomerMapper
) {

    fun deleteCustomerById(customerId: Long) {
        customerRepository.deleteById(customerId)
    }

    fun createCustomer(customerRequestDto: CustomerRequestDto): CustomerResponseDto {
        return customerMapper.fromEntity(
            customerRepository.save(
                Customer(
                    firstName = customerRequestDto.firstName,
                    lastName = customerRequestDto.lastName,
                    email = customerRequestDto.email,
                    createdAt = LocalDateTime.now(),
                    updatedAt = LocalDateTime.now()
                )
            )
        )
    }

    fun getCustomerById(customerId: Long): CustomerResponseDto {
        return customerMapper.fromEntity(
            customerRepository.findById(customerId)
                .orElseThrow {
                    IllegalArgumentException("Customer(id=$customerId) could not be found!")
                })
    }

    fun findCustomerById(customerId: Long): Customer {
        return customerRepository.findById(customerId).orElseThrow {
            IllegalArgumentException("Customer(id=$customerId) could not be found!")
        }
    }
}