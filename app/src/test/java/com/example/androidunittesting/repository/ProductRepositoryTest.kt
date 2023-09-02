package com.example.androidunittesting.repository

import com.example.androidunittesting.model.Product
import com.example.androidunittesting.remote.ProductApi
import com.example.androidunittesting.utils.NetworkResult
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class ProductRepositoryTest {

    @Mock
    lateinit var productApi: ProductApi
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

    }

    @Test
    fun testGetProducts_EmptyList() = runTest {
        Mockito.`when`(productApi.getProducts()).thenReturn(Response.success(emptyList()))

        val sut = ProductRepository(productApi)
        val result = sut.getProducts()

        Assert.assertEquals(true,result is NetworkResult.Success)
        Assert.assertEquals(0,result.data!!.size)
    }

    @Test
    fun testGetProducts_expectedProductList() = runTest {
        val productList = listOf<Product>(
            Product("","",1,"",45.2,"Product 1"),
            Product("","",2,"",27.2,"Product 2"),
        )
        Mockito.`when`(productApi.getProducts()).thenReturn(Response.success(productList))

        val sut = ProductRepository(productApi)
        val result = sut.getProducts()

        Assert.assertEquals(true,result is NetworkResult.Success)
        Assert.assertEquals(2,result.data!!.size)
        Assert.assertEquals("Product 1", result.data!![0].title)
    }

    @Test
    fun testGetProducts_expectedError() = runTest {
        Mockito.`when`(productApi.getProducts()).thenReturn(Response.error(401,"Unauthorized".toResponseBody()))

        val sut = ProductRepository(productApi)
        val result = sut.getProducts()

        Assert.assertEquals(true,result is NetworkResult.Error)
        Assert.assertEquals("Something went wrong",result.message)
    }
}