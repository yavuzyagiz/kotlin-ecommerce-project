package com.example.ecommerceproject.model

import javax.persistence.*

@Entity
@Table(name = "Address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val city: String?,
    val street: String?,
    val postalCode: String?,
    val detail: String?,
    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    val customer: Customer?
)