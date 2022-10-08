package com.example.ecommerceproject.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.ZoneId
import java.time.ZonedDateTime


@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errors: MutableMap<String, String> = hashMapOf()
        ex.bindingResult.allErrors.forEach { objectError ->
            errors[(objectError as FieldError).field] = objectError.defaultMessage ?: "error"
        }

        return ResponseEntity(errors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [CustomerNotFoundException::class])
    fun handleCustomerNotFoundException(exception: CustomerNotFoundException): ResponseEntity<Any> {
        val httpStatus = HttpStatus.BAD_REQUEST

        return ResponseEntity.status(httpStatus).body(
            ApiExceptionEntity(
                message = exception.message ?: "CustomerNotFoundException"
            )
        )
    }

    @ExceptionHandler(value = [AddressNotFoundException::class])
    fun handleAddressNotFoundException(exception: AddressNotFoundException): ResponseEntity<Any> {
        val httpStatus = HttpStatus.BAD_REQUEST

        return ResponseEntity.status(httpStatus).body(
            ApiExceptionEntity(
                message = exception.message ?: "AddressNotFoundException"
            )
        )
    }

}
