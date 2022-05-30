
package com.gabrielparra.applicationmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.gabrielparra.applicationmvvm.databinding.ActivityMainBinding
import com.gabrielparra.applicationmvvm.ui.viewmodel.QuoteViewModel
import com.gabrielparra.applicationmvvm.utils.toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel:QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { dataQuote ->
            binding.tvQuote.text = dataQuote.quote
            binding.tvAutor.text = dataQuote.author
        })
        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
        //ejemplo de una extension funtion
        toast("se muestra la data a la vista")
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}