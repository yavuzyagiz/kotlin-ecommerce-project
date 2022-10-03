package com.example.ecommerceproject.repository

import com.example.ecommerceproject.model.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepository : CrudRepository<Address, Long>