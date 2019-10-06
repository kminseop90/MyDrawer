package com.minseop.mydrawer.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<ITEM>(open val adapter: RecyclerView.Adapter<*>, itemView: View)
    : RecyclerView.ViewHolder(itemView)  {

    constructor(@LayoutRes layoutRes: Int, parent: ViewGroup?, adapter: RecyclerView.Adapter<*>):
            this(adapter, LayoutInflater.from((adapter as? AbstractRecyclerAdapter<*, *>)?.context).inflate(layoutRes, parent, false))

    abstract fun onViewHolder(item: ITEM?, postion: Int)

    open protected val context: Context?
        get() = (adapter as? AbstractRecyclerAdapter<*, *>)?.context

}