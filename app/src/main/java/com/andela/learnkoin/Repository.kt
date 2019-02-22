package com.andela.learnkoin

interface Repository {

    fun giveHello() : String
}

class RepositoryImpl(): Repository {
    override fun giveHello(): String = "Hello Koin"
}