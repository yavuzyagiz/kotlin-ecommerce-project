package com.example.ecommerceproject.repository

import com.example.ecommerceproject.model.OrderDetail
import org.springframework.data.repository.CrudRepository

interface OrderDetailRepository : CrudRepository<OrderDetail, Long>