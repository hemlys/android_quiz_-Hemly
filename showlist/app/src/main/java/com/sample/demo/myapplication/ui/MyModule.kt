package com.sample.demo.myapplication.ui

import com.sample.demo.myapplication.net.InfoRepository
import com.sample.demo.myapplication.net.InfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    viewModel { InfoViewModel(get()) }
}

val repoModule = module {
    single { InfoRepository() }
}