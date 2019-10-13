package com.minseop.mydrawer.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.minseop.mydrawer.R
import com.minseop.mydrawer.databinding.FragmentDashboardBinding
import com.minseop.mydrawer.model.local.entity.Video
import com.minseop.mydrawer.ui.dashboard.adapter.DashBoardAdapter
import com.minseop.mydrawer.viewmodel.DashBoardViewModel

class DashBoardFragment: Fragment() {

    private lateinit var dashboardViewModel: DashBoardViewModel
    lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate<FragmentDashboardBinding>(inflater, R.layout.fragment_dashboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }

    private fun initializeViews() {
        binding.dashboardList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = DashBoardAdapter()
            setHasFixedSize(true)
        }

        dashboardViewModel = ViewModelProviders.of(this).get(DashBoardViewModel::class.java)
        dashboardViewModel.getAll().observe(this, Observer {
            (binding.dashboardList.adapter as DashBoardAdapter).setVideos(it)
        })

        binding.btnAddDashboard.setOnClickListener {
            addItem()
        }
    }

    fun addItem() {
        var video = Video()
        video.title = "Naver"
        video.description = "portal"
        video.url = "https://naver.com"
        dashboardViewModel.insert(video)
    }
//
//    @BindingAdapter("viewModel")
//    fun setViewModel(view: RecyclerView, vm: DashBoardViewModel) {
//        view.adapter?.run {
//            if(this is DashBoardAdapter)
//                this.setViewModel(vm)
//        } ?: run {
//            DashBoardAdapter().apply {
//                view.adapter = this
//                this.setViewModel(vm)
//            }
//        }
//    }

//    @BindingAdapter("repositories")
//    fun setRepositories(view: RecyclerView, items: List<Video>) {
//        view.adapter?.run {
//            if(this is DashBoardAdapter) {
//                this.setVideos(items)
//                this.notifyDataSetChanged()
//            }
//        } ?: run {
//            DashBoardAdapter().apply {
//                view.adapter = this
//                this.setVideos(items)
//            }
//        }
//    }
}