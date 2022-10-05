package com.example.ecommerceproject.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "Product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String?,
    val description: String?,
    val weight: Double?,
    val price: Double?,
    @Column(nullable = false)
    val createdAt: LocalDateTime?,
    val sku: String?,
    val stock: String?,
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    val orderDetail: List<OrderDetail>?
)
