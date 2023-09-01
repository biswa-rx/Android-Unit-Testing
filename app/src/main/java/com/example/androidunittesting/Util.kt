package com.example.androidunittesting

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Util(val dispatcher: CoroutineDispatcher) {

    suspend fun getUserName(): String {
        delay(10000)
        return "BiswaRanjan"
    }

    suspend fun getUser(): String {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "SovanBehera"
    }

    suspend fun getAddress(): String {
//        withContext(Dispatchers.IO) //Dispatchers.IO is hard coded dispatcher not valid in test environment
        //For this cause we have to create a dispatcher variable to inject dispatcher in it
        // When it is a testing environment then we have to pass testDispatcher in it
        withContext(dispatcher)
        {
            delay(5000)
        }
        return "Address"
    }


    //Below getAddressDetail not recommended it is only for demonstration purpose
    var globalArg = false
    fun getAddressDetail() {
        CoroutineScope(dispatcher).launch {
            globalArg = true
        }
    }
}