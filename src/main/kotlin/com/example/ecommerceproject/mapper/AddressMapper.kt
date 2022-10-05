package com.example.ecommerceproject.mapper

import com.example.ecommerceproject.dto.AddressResponseDto
import com.example.ecommerceproject.model.Address
import org.springframework.stereotype.Component

@Component
class AddressMapper : Mapper<AddressResponseDto, Address> {

    override fun fromEntity(entity: Address): AddressResponseDto {
        return AddressResponseDto(
            id = entity.id,
            city = entity.city,
            street = entity.street,
            postalCode = entity.postalCode,
            detail = entity.detail
        )
    }
}