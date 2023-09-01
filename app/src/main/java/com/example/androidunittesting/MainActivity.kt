package com.example.androidunittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidunittesting.utils.NetworkResult
import com.example.androidunittesting.viewmodels.MainViewModel
import com.example.androidunittesting.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)

        val repository = (application as StoreApplication).productRepository
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getProducts()

        mainViewModel.products.observe(this, Observer {
            when(it) {
                is NetworkResult.Success -> {
                    textView.text = it.data!![0].toString()
                }
                is NetworkResult.Error -> { textView.text = it.message }
                is NetworkResult.Loading -> { textView.text = "Loading" }
            }
        })


    }
}