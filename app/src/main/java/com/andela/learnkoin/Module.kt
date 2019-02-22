package com.andela.learnkoin

import com.andela.Presenter
import org.koin.dsl.module.module

val appModule = module {
    factory { Presenter(get()) }
}