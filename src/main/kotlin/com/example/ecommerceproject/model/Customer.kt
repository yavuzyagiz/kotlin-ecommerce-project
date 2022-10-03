package com.example.ecommerceproject.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "Customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,
    val firstName: String?,
    val lastName: String?,
    @Column(nullable = false, unique = true)
    val email: String?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    val orders: Set<Order>?,
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id")
    val address: Address?
)