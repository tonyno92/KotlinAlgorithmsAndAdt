package it.prima.pairProgramming.domain

import it.prima.pairProgramming.data.network.model.CountryApiModel
import it.prima.pairProgramming.data.network.model.UserApiModel
import it.prima.pairProgramming.domain.entities.Country
import it.prima.pairProgramming.domain.entities.User


internal val fpUserApiToDomain = java.util.function.Function<UserApiModel, User> {
    User(username = it.nickname)
}

internal val fpListUserApiToDomain =
    java.util.function.Function<List<UserApiModel>, List<User>> { usersApi ->
        usersApi.map { fpUserApiToDomain.apply(it) }
    }

internal val fpCountryApiModelToDomain = java.util.function.Function<CountryApiModel, Country> {
    Country(it.name.official)
}