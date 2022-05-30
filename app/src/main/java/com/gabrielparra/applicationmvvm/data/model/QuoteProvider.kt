package com.gabrielparra.applicationmvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider @Inject constructor() {
    //Se almacena en memoria la respuesta de retrofit
    var quotes: List<QuoteModel> = emptyList()

}