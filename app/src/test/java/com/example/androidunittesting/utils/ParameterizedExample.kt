package com.example.androidunittesting.utils

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(value = Parameterized::class)
class ParameterizedExample(val input: String, val expectedValue: Boolean) {

    @Test
    fun test(){
        //Arrange
        val helper = Helper()
        //Act
        val result = helper.isPallindrome(input)
        //Assert
        assertEquals(expectedValue, result)
    }

    companion object{

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is pallindrome - {1}")
        fun data(): List<Array<Any>>{
            return listOf(
                arrayOf("Hello",false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true)
            )
        }
    }
}