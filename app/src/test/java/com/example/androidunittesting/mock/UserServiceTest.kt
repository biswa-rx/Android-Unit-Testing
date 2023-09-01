package com.example.androidunittesting.mock

import org.junit.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository
    @Before
    fun setUp() {
        //It init our object in this class where we annotated @Mock
        MockitoAnnotations.openMocks(this)

    }

    @Test
    fun testUserService_forInvalidPassword() {
        //Behaviour
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
        //Arrange
        val sut = UserService(userRepository)
        //Act
        val status = sut.loginUser("abc@gmail.com","354645656")
        //Assert
        Assert.assertEquals("Password is invalidate",status)
    }

    @Test
    fun testUserService_forInvalidUser() {
        //Behaviour
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.INVALID_USER)
        //Arrange
        val sut = UserService(userRepository)
        //Act
        val status = sut.loginUser("abc@gmail.com","354645656")
        //Assert
        Assert.assertEquals("User does not exist",status)
    }

    @Test
    fun testUserService_forUser_Logged_in_Successfully() {
        //Behaviour
        Mockito.`when`(userRepository.loginUser(anyString(), anyString())).thenReturn(LOGIN_STATUS.SUCCESS)
        //Arrange
        val sut = UserService(userRepository)
        //Act
        val status = sut.loginUser("abc@gmail.com","354645656")
        //Assert
        Assert.assertEquals("Logged in successfully",status)
    }
}