package it.prima.pairProgramming.domain.usecase

import it.prima.pairProgramming.data.repository.CountryRepositoryImpl
import kotlinx.coroutines.runBlocking

class GetInfoCountryUseCase {

    private val repo: CountryRepositoryImpl by lazy { CountryRepositoryImpl() }

    operator fun invoke(): String {
        return runBlocking {
            repo.getCountryByName("Italy").name
        }
    }
}