package com.example.ecommerceproject.service

import com.example.ecommerceproject.dto.AddressRequestDto
import com.example.ecommerceproject.dto.AddressResponseDto
import com.example.ecommerceproject.dto.CustomerResponseDto
import com.example.ecommerceproject.mapper.AddressMapper
import com.example.ecommerceproject.mapper.CustomerMapper
import com.example.ecommerceproject.model.Address
import com.example.ecommerceproject.model.Customer
import com.example.ecommerceproject.repository.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(
    val addressRepository: AddressRepository,
    val customerService: CustomerService,
    val addressMapper: AddressMapper,
    val customerMapper: CustomerMapper
) {

    fun addAddress(addressRequestDto: AddressRequestDto): AddressResponseDto {
        val customer: Customer =
            customerService.findCustomerById(
                addressRequestDto.customerId
                    ?: throw IllegalArgumentException("Address(id=${addressRequestDto.customerId}) could not be found!")
            )

        return addressMapper.fromEntity(
            addressRepository.save(
                Address(
                    city = addressRequestDto.city,
                    street = addressRequestDto.street,
                    postalCode = addressRequestDto.postalCode,
                    detail = addressRequestDto.detail,
                    customer = customer
                    )
            )
        )
    }

    fun getCustomerByAddressId(addressId: Long): CustomerResponseDto?{
        return findAddressById(addressId).customer?.let { customerMapper.fromEntity(it) }
    }

    fun getAddressById(addressId: Long): AddressResponseDto {
        return addressMapper.fromEntity(
            addressRepository.findById(addressId)
                .orElseThrow {
                    IllegalArgumentException("Address(id=$addressId) could not be found!")
                })
    }

    fun getAllAddresses(): List<AddressResponseDto> {
        return addressRepository.findAll()
            .map {
                addressMapper.fromEntity(it)
            }
    }

    fun findAddressById(addressId: Long): Address {
        return addressRepository.findById(addressId).orElseThrow {
            IllegalArgumentException("Address(id=$addressId) could not be found!")
        }
    }

}