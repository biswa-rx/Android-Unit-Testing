package com.example.androidunittesting.mock

class UserRepository {

    val users = listOf<User>(
        User(1,"John","john@gmail.com","sdfgq23r5"),
        User(2,"Wein","wein@gmail.com","5435trfvsed"),
        User(3,"Emily","emily@gmail.com","345teasfgdg"),
    )

    fun loginUser(email: String,password: String): LOGIN_STATUS {

        //Fetch user from DB
        val users = users.filter { user-> user.email == email }

        return if (users.size == 1) {
            if(users[0].password == password){
                LOGIN_STATUS.SUCCESS
            } else {
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }
}