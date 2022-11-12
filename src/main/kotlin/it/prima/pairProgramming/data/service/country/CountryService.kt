package it.prima.pairProgramming.data.service.country


import it.prima.pairProgramming.data.network.model.CountryApiModel
import it.prima.pairProgramming.data.network.model.CountryApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface CountryService {
    //@GET
    suspend fun getInfoCountry(name: String): CountryApiModel

    @GET("name/{name}")
    suspend fun getInfoCounty(@Path("name") pathName: String): CountryApiResponse
}