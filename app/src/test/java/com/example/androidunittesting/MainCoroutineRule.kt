package com.example.androidunittesting

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MainCoroutineRule : TestWatcher() {

    val testDispatcher = StandardTestDispatcher()
    //It is like before
    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    //It is like after
    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}