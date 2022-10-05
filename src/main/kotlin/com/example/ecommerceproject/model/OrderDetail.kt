package com.example.ecommerceproject.model

import javax.persistence.*

@Entity
@Table(name = "OrderDetail")
data class OrderDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    val order: Order?,
    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    val product: Product?,
    val price: Double?,
    val sku: String?,
    val quantity: Int?
)

