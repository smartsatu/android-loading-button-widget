package com.smartsatu.android.widget

import android.view.View
import androidx.databinding.BindingAdapter


/**
 * Created by Sergei Kurikalov
 * on 10.04.18.
 */

@BindingAdapter("onClick")
fun setOnClick(view: LoadingButtonWidget, clickListener: View.OnClickListener) {
    view.setOnClickListener(clickListener)
    view.isClickable = true
    view.isFocusable = true
}

@BindingAdapter("progress")
fun setProgress(view: LoadingButtonWidget, isProgress: Boolean) {
    if (isProgress) {
        view.startProgress()
    } else {
        view.stopProgress()
    }
}