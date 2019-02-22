package com.andela.learnkoin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.koin.core.Koin.Companion.logger
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
