package com.example.androidunittesting.utils

import java.lang.IllegalArgumentException

class Helper {

    fun isPallindrome(input: String): Boolean{
        var i = 0;
        var j = input.length - 1
        while (i<j){
            if(input[i] != input[j]){
                return false
            }
            i++
            j--
        }
        return true
    }

    fun validatePassword(input: String) = when {
        input.isBlank() -> {
            "Password is required field"
        }
        input.length < 6 -> {
            "Length of the password should be greater than 6"
        }
        input.length >  15 -> {
            "Length of the password should be less than 15"
        }
        else -> {
            "Valid"
        }
     }

    //Let make our input nullable for testing purpose
    fun reverseString(input: String?): String{
        if(input == null) throw IllegalArgumentException("Input string is Required")
        var chars = input.toCharArray()
        var i = 0
        var j = chars.size - 1

        while(i<j){
            var temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }
        return chars.joinToString("")
    }
}