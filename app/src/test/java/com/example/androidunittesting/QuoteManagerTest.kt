package com.example.androidunittesting

import android.content.Context
import android.content.res.AssetManager
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations

class QuoteManagerTest {

    @Mock
    lateinit var context:Context

    @Mock
    lateinit var assetManager: AssetManager
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

    }

    @Test
    fun test() {
        //Our test stream directly generated
        val testStream =  QuoteManagerTest::class.java.getResourceAsStream("/quotes.json")
        //I state that when context call andy assets property then just return assetManager
        doReturn(assetManager).`when`(context).assets
        //Defining Behaviour
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        val sut = QuoteManager()
        sut.populateQuoteFromAssets(context,"")
         val quote = sut.getCurrentQuote()
        Assert.assertEquals("first test",quote.text)
    }

    @Test
    fun populateQuoteFromAssets() {

    }
}