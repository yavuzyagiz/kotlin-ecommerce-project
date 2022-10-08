package com.example.ecommerceproject.controller

import com.example.ecommerceproject.dto.AddressRequestDto
import com.example.ecommerceproject.dto.AddressResponseDto
import com.example.ecommerceproject.dto.CustomerResponseDto
import com.example.ecommerceproject.service.AddressService
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
@RequestMapping("/api/v1/address")
class AddressController(
    private val addressService: AddressService
) {
    @PostMapping
    fun addAddress(@Valid @RequestBody address: AddressRequestDto): ResponseEntity<AddressResponseDto> {
        return ResponseEntity.ok(addressService.addAddress(address))
    }


    @GetMapping("/{id}")
    fun getCustomerByAddressId(@PathVariable id: Long): ResponseEntity<CustomerResponseDto> {
        return ResponseEntity.ok(addressService.getCustomerByAddressId(id))
    }

    @GetMapping
    fun getAllAddresses(): ResponseEntity<List<AddressResponseDto>> {
        return ResponseEntity.ok(addressService.getAllAddresses())
    }
}