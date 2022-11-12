package it.prima.pairProgramming.data.network.model


internal class CountryApiResponse : ArrayList<CountryApiModel>()

internal data class CountryApiModel(
    val name: Name,
)

internal data class Name(
    val common: String,
    val official: String
)