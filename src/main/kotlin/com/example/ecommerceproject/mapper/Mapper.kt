package com.example.ecommerceproject.mapper

interface Mapper<D, E> {
    fun fromEntity(entity: E): D
}