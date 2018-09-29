package jjuni.kotlin.mvvmsample.ui.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Jo on 2018. 8. 1.
 */

abstract class ArchitectureActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {

    protected abstract val viewModel: VM
    protected lateinit var viewDataBinding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutResId())
    }

    override fun onDestroy() {
        super.onDestroy()
        viewDataBinding.unbind()
    }
}