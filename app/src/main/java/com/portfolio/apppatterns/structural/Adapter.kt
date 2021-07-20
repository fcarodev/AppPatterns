package com.portfolio.apppatterns.structural

import android.util.Log


/**
 * Converts the interface of a class into another interface the client expects
 *
 * Convert data from one format into another
 */

interface CurrencyConverter{
    fun convertCurrency(countryName: String)
}
class CurrencyToDollarConverter: CurrencyConverter{
    override fun convertCurrency(countryName: String) {
        Log.d("Log","Dollar Currency")
    }
}
class CurrencyToEuroConverter{
    fun convertCurrency(isoCode: String){
        Log.d("Log","Euro currency")
    }
}


class CurrencyConverterAdapter(private val currencyToEuroConverter: CurrencyToEuroConverter): CurrencyConverter{
    override fun convertCurrency(countryName: String) {
        val currencyIsoCode = getCurrencyIsoCode()
        currencyToEuroConverter.convertCurrency(currencyIsoCode)
    }

    private fun getCurrencyIsoCode(): String = "This is ISO code"
}

fun main() {
    val currencyToDollarConverter = CurrencyToDollarConverter()
    currencyToDollarConverter.convertCurrency("Country name")

    val currencyToEuroConverter = CurrencyToEuroConverter()
    val currencyConverterAdapter = CurrencyConverterAdapter(currencyToEuroConverter)
    currencyConverterAdapter.convertCurrency("Country name")
}