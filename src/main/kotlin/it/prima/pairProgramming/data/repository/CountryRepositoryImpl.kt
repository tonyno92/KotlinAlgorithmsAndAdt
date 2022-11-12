package it.prima.pairProgramming.data.repository


import it.prima.pairProgramming.data.di.ServiceBuilder
import it.prima.pairProgramming.data.service.country.CountryService
import it.prima.pairProgramming.data.service.country.CountryServiceMocked
import it.prima.pairProgramming.domain.entities.Country
import it.prima.pairProgramming.domain.fpCountryApiModelToDomain
import it.prima.pairProgramming.domain.repository.CountryRepository


internal class CountryRepositoryImpl :
    CountryRepository {

    private val remote: CountryService = CountryServiceMocked()

    private val service: CountryService? by lazy { ServiceBuilder.createService(CountryService::class.java) }

    override suspend fun getCountryByName(name: String): Country =
        fpCountryApiModelToDomain.apply(
            service?.getInfoCounty(pathName = name)?.first() ?: remote.getInfoCountry(name)
        )
}