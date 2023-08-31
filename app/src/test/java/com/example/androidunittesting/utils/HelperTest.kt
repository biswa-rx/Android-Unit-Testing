package com.example.androidunittesting.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper
    @Before
    fun setUp() {
        println("Before Every Test Case")
        helper = Helper()
    }

    @After
    fun tearDown() {
        println("After Every Test Case")
    }
    @Test
    fun isPallindrome() {
        //Arrange
//        val helper = Helper()
        //Act
        val result = helper.isPallindrome("Hello")
        //Assert
        assertEquals(false,result)
    }

    @Test
    fun isPallindrome_inputString_level_expectedTrue() {
        //Arrange
        val helper = Helper()
        //Act
        val result = helper.isPallindrome("level")
        //Assert
        assertEquals(true,result)
    }
}