package com.example.easyptbackend.global.error

import org.springframework.http.HttpStatus

enum class GlobalErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    override fun status() = status.value()
    override fun message() = message
}