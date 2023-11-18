package com.example.myapplicationlaba4.Controller


import com.example.myapplicationlaba4.Models.user

class MainController {

    fun getUserList(): List<user.User> {
        // В реальном приложении данные могли бы быть получены из репозитория или другого источника.
        return listOf(
            user.User(1, "John Doe", 25),
            user.User(2, "Jane Doe", 30),
            user.User(3, "Bob Smith", 22)
        )
    }
}