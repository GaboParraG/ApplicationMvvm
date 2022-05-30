package com.gabrielparra.applicationmvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    //Funcion con la configuracion de retrofit

    //en rama inyection esta clase muere ya que se inyecta desde el modulo
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
}