package com.myapplication

import Greeting

class GreetPresenter(val greeting: Greeting) {
    fun print() = greeting.greeting()
}