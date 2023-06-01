package com.example.easyptbackend.global.exception

import com.example.easyptbackend.global.error.GlobalErrorCode
import com.example.easyptbackend.global.error.exception.BaseException

object InternalServerErrorException : BaseException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
) {
    val EXCEPTION = InternalServerErrorException
}