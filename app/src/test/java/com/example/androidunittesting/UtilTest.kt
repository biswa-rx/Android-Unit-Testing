package com.example.androidunittesting

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


//In testing environment we avoid different thread execution because we have to wait until another thread return some thing
// But rather that here we use StandardTestDispatcher to execute all code in a single dispatcher in a synchronous manner
class UtilTest {

    //this code always repeat init for each test case that's why we have to use TestWatcher() to define our Coroutine rule
//    private val testDispatcher = StandardTestDispatcher()
    @Before
    fun setUp() {
//        Dispatchers.setMain(testDispatcher)
    }

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun testGetUser() {
        val sut = Util(mainCoroutineRule.testDispatcher)
        //runBlocking hold the block
        //runBlocking doesn't avoid delay
        //not optimized for testing purpose because if there is a delay for 10 second then it wait for 10 second
//        runBlocking {
//            sut.getUserName()
//        }


        //runTest lunch a new coroutine which is design for testing
        runTest {
            sut.getUserName()
        }


        //This code give error because there is no main Dispatchers inside testing environment
        //For this cause we have to use StandardTestDispatcher() to Dispatchers.setMain()
        runTest {
            sut.getUser()
        }

        runTest {
            sut.getAddress()
        }

        runTest {
            sut.getAddressDetail()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle() // It ensure that all coroutine are run complete in testDispatcher
            //After that we can use Assert statement to check testcase, because if we do without advanceUntilIdle then all coroutine will added in a queue and our test case failed (globalArg == false) that case
            Assert.assertEquals(true,sut.globalArg)
        }

    }

    @After
    fun tearDown() {
//        Dispatchers.resetMain()
    }
}