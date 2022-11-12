package it.prima.pairProgramming.domain.repository

import it.prima.pairProgramming.domain.entities.User

internal interface UserRepository {
    suspend fun getUsers(): List<User>
}