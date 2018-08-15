package com.smartsatu.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_loading_button_widget_demo.*

class LoadingButtonWidgetDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_button_widget_demo)

        loadingButtonWidget.apply {
            setOnClickListener {
                startProgress()
                postDelayed({ stopProgress() }, 2000)
            }
        }
    }
}
