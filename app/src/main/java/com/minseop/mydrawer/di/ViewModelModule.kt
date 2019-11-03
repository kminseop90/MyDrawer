package com.minseop.mydrawer.di

import com.minseop.mydrawer.viewmodel.ClipboardViewModel
import com.minseop.mydrawer.viewmodel.DashBoardViewModel
import com.minseop.mydrawer.viewmodel.HomeViewModel
import com.minseop.mydrawer.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { MainActivityViewModel() }
    viewModel { DashBoardViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ClipboardViewModel() }

}