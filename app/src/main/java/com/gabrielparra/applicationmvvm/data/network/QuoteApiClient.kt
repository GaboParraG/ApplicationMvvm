package com.gabrielparra.applicationmvvm.data.network

import com.gabrielparra.applicationmvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    //Se hace la llamada del servicio rest
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>> //->Funcion suspendida de courutinas

}