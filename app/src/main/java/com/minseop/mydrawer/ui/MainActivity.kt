package com.minseop.mydrawer.ui

import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.minseop.mydrawer.R
import com.minseop.mydrawer.databinding.ActivityMainBinding
import com.minseop.mydrawer.ui.base.BaseActivity
import com.minseop.mydrawer.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override fun getViewModelCls(): Class<MainActivityViewModel> = MainActivityViewModel::class.java

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initialize() {
        NavigationUI.setupWithNavController(binding.navView, Navigation.findNavController(this, R.id.nav_host_fragment))
    }
}
