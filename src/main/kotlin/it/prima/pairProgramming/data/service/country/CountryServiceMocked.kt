package it.prima.pairProgramming.data.service.country

import it.prima.pairProgramming.INFO_COUNTRY
import it.prima.pairProgramming.data.network.model.CountryApiModel
import it.prima.pairProgramming.data.network.model.CountryApiResponse
import it.prima.pairProgramming.data.network.model.Name
import com.google.gson.Gson
import com.google.gson.JsonParseException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

internal class CountryServiceMocked(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) :
    CountryService {

    private val parser by lazy { Gson() }

    override suspend fun getInfoCountry(name: String) = withContext(dispatcher) {
        try {
            val json = URL(INFO_COUNTRY + name).readText()
            parseJsonToCountry(json)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getInfoCounty(name: String): CountryApiResponse {
        TODO("Not yet implemented")
    }

    private fun parseJsonToCountry(json: String) =
        parser.fromJson(json, CountryApiResponse::class.java)
            ?.firstOrNull()
            ?.let { country ->
                CountryApiModel(
                    name = Name(
                        common = country.name.common,
                        official = country.name.official
                    )
                )
            } ?: throw JsonParseException("Invalid json")

}