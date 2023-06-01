package com.example.easyptbackend.global.exception

import com.example.easyptbackend.global.error.GlobalErrorCode
import com.example.easyptbackend.global.error.exception.BaseException

object BadRequestException : BaseException(
    GlobalErrorCode.BAD_REQUEST
) {
    val EXCEPTION = BadRequestException
}