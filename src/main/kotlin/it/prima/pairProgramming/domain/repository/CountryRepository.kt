package it.prima.pairProgramming.domain.repository

import it.prima.pairProgramming.domain.entities.Country

internal interface CountryRepository {
    suspend fun getCountryByName(name: String): Country
}