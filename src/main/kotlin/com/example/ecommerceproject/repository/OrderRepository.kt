package com.example.ecommerceproject.repository

import com.example.ecommerceproject.model.Order
import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long>