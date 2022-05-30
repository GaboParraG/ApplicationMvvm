package com.gabrielparra.applicationmvvm.data


import com.gabrielparra.applicationmvvm.data.model.QuoteModel
import com.gabrielparra.applicationmvvm.data.model.QuoteProvider
import com.gabrielparra.applicationmvvm.data.network.QuoteService
import javax.inject.Inject

//Clase encargada de gestionar de donde trae la data si de local o de network
class QuoteRepository @Inject constructor(private val api: QuoteService, private  val quoteProvider: QuoteProvider) {

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response

    }
}