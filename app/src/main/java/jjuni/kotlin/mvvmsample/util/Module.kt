package jjuni.kotlin.mvvmsample.util

import jjuni.kotlin.mvvmsample.data.MainRepository
import jjuni.kotlin.mvvmsample.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Created by Jo on 2018. 10. 3.
 */

val mainModule = module {
    viewModel<MainViewModel> { MainViewModel(get()) }
    single { MainRepository() }
}

val appModules = listOf(mainModule)