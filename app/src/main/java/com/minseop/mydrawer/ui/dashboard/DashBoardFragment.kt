package com.minseop.mydrawer.ui.dashboard

import androidx.lifecycle.Observer
import com.minseop.mydrawer.R
import com.minseop.mydrawer.databinding.FragmentDashboardBinding
import com.minseop.mydrawer.model.local.entity.Content
import com.minseop.mydrawer.ui.base.BaseFragment
import com.minseop.mydrawer.ui.dashboard.adapter.DashBoardAdapter
import com.minseop.mydrawer.viewmodel.DashBoardViewModel

class DashBoardFragment : BaseFragment<FragmentDashboardBinding, DashBoardViewModel>() {

    override fun getViewModelCls(): Class<DashBoardViewModel> = DashBoardViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_dashboard

    override fun initialize() {
        binding.dashboardList.adapter = DashBoardAdapter()

        viewModel.getAll().observe(this, Observer {
            (binding.dashboardList.adapter as DashBoardAdapter).setVideos(it)
        })
    }

    fun getDummyVideo(): Content = Content().apply {
        title = "Naver"
        description = "portal"
        url = "https://naver.com"
    }
}