package com.example.androidunittesting.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class StringTest {

    @Test
    fun testStringReversal_EmptyString_expectedEmptyString() {
        val sut = Helper()
        val result = sut.reverseString("")
        assertEquals("",result)
    }

    @Test
    fun testStringReversal_SingleCharacter_expectedSingleCharacter() {
        val sut = Helper()
        val result = sut.reverseString("a")
        assertEquals("a",result)
    }

    @Test
    fun testStringReversal_ValidInput_expectedReverseString() {
        val sut = Helper()
        val result = sut.reverseString("Aeroplane")
        assertEquals("enalporeA",result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal_NullValue_expectedException() {
        val sut = Helper()
        val result = sut.reverseString(null)
    }
}