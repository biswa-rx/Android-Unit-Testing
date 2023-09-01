package com.example.androidunittesting.mock

class UserService(private val userRepository: UserRepository) {
    // Here we have to mock userRepository and make UserService as independent to test
    // Here we only evaluate test of UserService not UserRepository
    fun loginUser(email: String, password: String): String {
        val status = userRepository.loginUser(email,password)
        return when(status) {
            LOGIN_STATUS.INVALID_USER -> "User does not exist"
            LOGIN_STATUS.INVALID_PASSWORD -> "Password is invalidate"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown error occurred"
            LOGIN_STATUS.SUCCESS -> "Logged in successfully"
        }
    }
}