package it.prima.pairProgramming.data.service

import it.prima.pairProgramming.data.network.model.UserApiModel

internal interface UserService {
    //@GET
    suspend fun getAllUsers(): List<UserApiModel>
}

