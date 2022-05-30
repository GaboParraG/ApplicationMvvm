package com.gabrielparra.applicationmvvm.domain


import com.gabrielparra.applicationmvvm.data.model.QuoteModel
import com.gabrielparra.applicationmvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase  @Inject constructor(private val quoteProvider: QuoteProvider) {

    // caso de uso para refrescar las citas
    operator fun invoke(): QuoteModel?{
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}