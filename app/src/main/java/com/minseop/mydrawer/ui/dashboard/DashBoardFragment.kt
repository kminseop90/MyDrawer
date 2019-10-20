package com.minseop.mydrawer.ui.dashboard

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minseop.mydrawer.R
import com.minseop.mydrawer.databinding.FragmentDashboardBinding
import com.minseop.mydrawer.model.local.entity.Video
import com.minseop.mydrawer.ui.base.BaseFragment
import com.minseop.mydrawer.ui.dashboard.adapter.DashBoardAdapter
import com.minseop.mydrawer.viewmodel.DashBoardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashBoardFragment : BaseFragment<FragmentDashboardBinding, DashBoardViewModel>() {

    override fun getViewModelCls(): Class<DashBoardViewModel> = DashBoardViewModel::class.java

    override fun getLayoutId(): Int = R.layout.fragment_dashboard

    override val viewModel by viewModel<DashBoardViewModel>()

    override fun initialize() {
    }

    fun addItem() {
        var video = Video()
        video.title = "Naver"
        video.description = "portal"
        video.url = "https://naver.com"

        viewModel.insert(video)
    }

    @BindingAdapter("viewModel")
    fun setViewModel(view: RecyclerView, vm: DashBoardViewModel) {
        view.adapter?.run {
            if (this is DashBoardAdapter)
                this.setViewModel(vm)
        } ?: run {
            DashBoardAdapter().apply {
                view.adapter = this
                this.setViewModel(vm)
            }
        }
    }
}