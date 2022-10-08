package com.example.ecommerceproject.controller

import com.example.ecommerceproject.dto.CustomerRequestDto
import com.example.ecommerceproject.dto.CustomerResponseDto
import com.example.ecommerceproject.exception.CustomerNotFoundException
import com.example.ecommerceproject.service.CustomerService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/customer")
class CustomerController(
    private val customerService: CustomerService
) {
    @GetMapping("/delete/{id}")
    fun deleteCustomer(@PathVariable id: Long) {
        customerService.deleteCustomerById(id)
    }

    @PostMapping
    fun addCustomer(@Valid @RequestBody customerRequestDto: CustomerRequestDto): ResponseEntity<CustomerResponseDto> {
        return ResponseEntity.ok(this.customerService.createCustomer(customerRequestDto))
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Long): ResponseEntity<CustomerResponseDto> {
        return ResponseEntity.ok(this.customerService.getCustomerById(id))
    }
}