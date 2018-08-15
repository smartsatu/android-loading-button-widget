package com.smartsatu.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.smartsatu.android.databinding.ActivityLoadingButtonWidgetDemoBinding
import kotlinx.android.synthetic.main.activity_loading_button_widget_demo.*

class LoadingButtonWidgetDemoActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(LoadingButtonWidgetViewModel::class.java)
    }

    private lateinit var binding: ActivityLoadingButtonWidgetDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_loading_button_widget_demo)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        loadingButtonWidget.apply {
            setOnClickListener {
                viewModel.progress.value = true

            }
        }.postDelayed({ viewModel.progress.value = false }, 2000)
    }
}
