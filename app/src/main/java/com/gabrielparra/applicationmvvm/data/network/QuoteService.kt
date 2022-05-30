package com.gabrielparra.applicationmvvm.data.network


import com.gabrielparra.applicationmvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


//En esta clase estan todas las llamadas a servicios
class QuoteService @Inject constructor(private val api:QuoteApiClient)  {

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {  //-> se ejecuta el llamado en un hilo aparte de principal
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}