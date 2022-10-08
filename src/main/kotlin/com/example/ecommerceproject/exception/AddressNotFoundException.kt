package com.example.ecommerceproject.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class AddressNotFoundException(message: String): RuntimeException(message) {}