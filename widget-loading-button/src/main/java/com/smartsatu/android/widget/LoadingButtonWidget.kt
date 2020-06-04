package com.smartsatu.android.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ProgressBar
import com.google.android.material.button.MaterialButton

/**
 * Created by Sergei Kurikalov
 * on 10.04.18.
 */
open class LoadingButtonWidget : FrameLayout, View.OnClickListener {
    private lateinit var button: Button
    private lateinit var progress: ProgressBar
    private var text: CharSequence? = null
    private var onClickListener: OnClickListener? = null
    private var icon: Drawable? = null

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingButtonWidget, 0, 0)
        try {
            text = typedArray.getString(R.styleable.LoadingButtonWidget_text) ?: ""
        } finally {
            typedArray.recycle()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        button = findViewById(R.id.button)
                ?: throw IllegalStateException("${this::class.java.simpleName} must contain Button children with id=R.id.button")
        progress = findViewById(R.id.progress)
                ?: throw IllegalStateException("${this::class.java.simpleName} must contain ProgressBar children with id=R.id.progress")
        button.text = this.text?.takeIf { it.isNotBlank() } ?: button.text
        saveMaterialButtonIcon()
    }

    fun getButton(): Button {
        return button
    }

    fun setText(title: String) {
        this.text = title
        button.text = title
    }

    fun startProgress() {
        button.isEnabled = false
        button.text = ""
        progress.visibility = View.VISIBLE
        saveMaterialButtonIcon()
    }

    private fun saveMaterialButtonIcon() {
        if (button is MaterialButton) {
            with(button as MaterialButton) {
                this@LoadingButtonWidget.icon = icon
                icon = null
            }
        }
    }

    fun stopProgress() {
        button.isEnabled = true
        button.text = text
        progress.visibility = View.GONE
        if (button is MaterialButton) {
            (button as MaterialButton).icon = icon
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        onClickListener = l
        button.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        onClickListener?.onClick(this)
    }
}
