package com.gabrielparra.applicationmvvm.di


import com.gabrielparra.applicationmvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//Se definen las dependencias de libreria o de interfaces

@Module  //Se le dice a dagger que esto es un modulo
@InstallIn(SingletonComponent::class) //se define que alcance va a tener este es a nivel de toda la app
object NetworkModule {

    //se provee retrofit
    @Singleton //para que mantenga una unica instancia de retrifit
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }


}