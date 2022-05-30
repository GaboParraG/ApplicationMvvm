package com.gabrielparra.applicationmvvm.domain


import com.gabrielparra.applicationmvvm.data.QuoteRepository
import com.gabrielparra.applicationmvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    //invoke devuelve funcion especifica cuando se instancie la clase
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}