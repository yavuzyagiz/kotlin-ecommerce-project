package com.example.ecommerceproject.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "OrderTable")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    @Column(nullable = false)
    val amount: Double?,
    @Column(nullable = false)
    val createdAt: LocalDateTime?,
    val status: String?,
    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer?,
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    val orderDetails: List<OrderDetail>? = listOf()
)