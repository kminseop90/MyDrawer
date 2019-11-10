package com.minseop.mydrawer.util.extension

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minseop.mydrawer.model.local.entity.Content
import com.minseop.mydrawer.ui.dashboard.adapter.DashBoardAdapter


@BindingAdapter(value = ["items"])
fun setItems(view: RecyclerView, items: List<Content>?) {
    view.adapter?.let {
        val adapter = view.adapter as DashBoardAdapter
        adapter.setContent(items)
    } ?: run {
        DashBoardAdapter().apply {
            view.adapter = this
            setContent(items)
        }
    }
}