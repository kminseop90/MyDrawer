package com.minseop.mydrawer.ui.home

import android.content.Intent
import android.os.Build
import android.view.View
import com.minseop.mydrawer.R
import com.minseop.mydrawer.databinding.FragmentHomeBinding
import com.minseop.mydrawer.service.clipboard.ClipboardService
import com.minseop.mydrawer.ui.base.BaseFragment
import com.minseop.mydrawer.viewmodel.HomeViewModel

class HomeFragment: BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getViewModelCls(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun initialize() {
    }


    fun onStartServiceClick(view: View) {
        val intent = Intent(context, ClipboardService::class.java)
        if(Build.VERSION.SDK_INT >= 26) {
            context?.startForegroundService(intent)
        } else {
            context?.startService(intent)
        }

    }

    fun onStopServiceClick(view: View) {
        val intent = Intent(context, ClipboardService::class.java)
        context?.stopService(intent)
    }
}