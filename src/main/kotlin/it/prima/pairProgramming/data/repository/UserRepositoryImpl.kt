package it.prima.pairProgramming.data.repository


import it.prima.pairProgramming.data.service.UserService
import it.prima.pairProgramming.data.service.UserServiceMocked
import it.prima.pairProgramming.domain.entities.User
import it.prima.pairProgramming.domain.fpListUserApiToDomain
import it.prima.pairProgramming.domain.repository.UserRepository

internal class UserRepositoryImpl : UserRepository {

    private val remote: UserService = UserServiceMocked()


    override suspend fun getUsers(): List<User> {
        return fpListUserApiToDomain.apply(remote.getAllUsers())
    }
}