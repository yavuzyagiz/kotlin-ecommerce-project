package com.example.ecommerceproject.repository

import com.example.ecommerceproject.model.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Long>