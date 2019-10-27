package com.minseop.mydrawer.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    lateinit var binding: B
    protected val viewModel : VM by viewModel(clazz = getViewModelCls().kotlin)

    abstract fun getLayoutId(): Int
    abstract fun getViewModelCls(): Class<VM>
    abstract fun initialize()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.setVariable(BR.vm, viewModel)
        binding.setVariable(BR.fragment, this)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }
}

