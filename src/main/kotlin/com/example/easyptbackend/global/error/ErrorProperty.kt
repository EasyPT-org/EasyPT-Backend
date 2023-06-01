package com.example.easyptbackend.global.error

interface ErrorProperty {
    fun status(): Int
    fun message(): String
}