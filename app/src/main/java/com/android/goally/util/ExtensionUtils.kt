package com.android.goally.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.android.goally.listener.SafeClickListener

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}


fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}

fun View.disableForTwoSeconds() {
    isEnabled = false
    postDelayed({
        isEnabled = true
    }, 2000)
}