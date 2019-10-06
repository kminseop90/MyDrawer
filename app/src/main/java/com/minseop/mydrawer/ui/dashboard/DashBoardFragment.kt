package com.minseop.mydrawer.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.minseop.mydrawer.R
import com.minseop.mydrawer.ui.dashboard.adapter.DashBoardAdapter
import com.minseop.mydrawer.viewmodel.DashBoardViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashBoardFragment: Fragment() {

    private lateinit var dashboardViewModel: DashBoardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }

    private fun initializeViews() {
        dashboard_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DashBoardAdapter()
            setHasFixedSize(true)
        }

        dashboardViewModel = ViewModelProviders.of(this).get(DashBoardViewModel::class.java)
        dashboardViewModel.getAll().observe(this, Observer {
            (dashboard_list.adapter as DashBoardAdapter).setVideos(it)
        })
    }
}