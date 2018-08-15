package com.smartsatu.android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoadingButtonWidgetViewModel : ViewModel() {

    val progress = MutableLiveData<Boolean>()
            .apply { this.value = false }
}