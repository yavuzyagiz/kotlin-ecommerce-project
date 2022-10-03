package com.example.ecommerceproject.repository

import com.example.ecommerceproject.model.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long>