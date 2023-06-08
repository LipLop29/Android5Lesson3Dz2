package com.example.data.local.dtos

import com.example.domain.models.User

data class UserDto(
    val name : String,
    val surname : String,
    val age : Int
)

fun UserDto.toDomain() : User {
    return User(name, surname, age)
}