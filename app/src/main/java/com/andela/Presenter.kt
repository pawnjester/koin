package com.andela

import com.andela.learnkoin.Repository

class Presenter(val repository: Repository) {
    fun sayHello() = "${repository.giveHello()} from $this"
}