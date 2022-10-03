package com.example.ecommerceproject.controller

import com.example.ecommerceproject.dto.CustomerResponseDto
import com.example.ecommerceproject.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customer")
class CustomerController(private val customerService: CustomerService) {

    // GET http://localhost:8090/api/v1/customer/1
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerResponseDto> {
        return ResponseEntity.ok(this.customerService.findCustomerById(id))
    }
}