package com.smartsatu.android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingButtonWidgetViewModel : ViewModel() {

    private val progressInternal = MutableLiveData<Boolean>()
    val progress = Transformations.map(progressInternal) { it }

    fun showProgress(seconds: Int? = null) {
        progressInternal.value = true
        seconds?.let {
            viewModelScope.launch {
                delay(seconds * 1000L)
                progressInternal.value = false
            }
        }
    }
}