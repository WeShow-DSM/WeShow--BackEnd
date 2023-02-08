package com.example.weshowbackend.global.error.custom

interface ErrorProperty {
    fun status(): Int
    fun message(): String
}