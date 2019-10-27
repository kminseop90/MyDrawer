package com.minseop.mydrawer.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.minseop.mydrawer.BR
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseActivity<B : ViewDataBinding, VM: BaseViewModel> : AppCompatActivity() {

    lateinit var binding: B
    protected val viewModel by viewModel(clazz = getViewModelCls().kotlin)

    abstract fun getLayoutId() : Int
    abstract fun getViewModelCls() : Class<VM>
    abstract fun initialize()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(BR.activity, this)
        binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = this
        initialize()
    }
}