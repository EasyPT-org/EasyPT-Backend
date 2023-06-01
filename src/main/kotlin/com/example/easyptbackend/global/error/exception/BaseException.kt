package com.example.easyptbackend.global.error.exception

import com.example.easyptbackend.global.error.ErrorProperty

abstract class BaseException(
    val errorProperty: ErrorProperty
) : RuntimeException() {

    override fun fillInStackTrace() = this
}