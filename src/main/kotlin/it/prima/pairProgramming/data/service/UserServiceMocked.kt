package it.prima.pairProgramming.data.service

import it.prima.pairProgramming.data.network.model.UserApiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal class UserServiceMocked(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) :
    UserService {

    override suspend fun getAllUsers() = withContext(dispatcher) {
        delay(1000) // Simulate Api call
        UserApiModel.users
    }
}