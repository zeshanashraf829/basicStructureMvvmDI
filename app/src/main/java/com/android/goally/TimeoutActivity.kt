package com.android.goally

import android.os.Handler
import android.text.Editable
import android.text.TextWatcher


abstract class TimeoutActivity : BaseActivity() {

    protected var DISCONNECT_TIMEOUT = 30 * 1000L
    protected var IS_RESET_ON_USER_INTERACTION = true

    private val disconnectHandler = Handler()
    private val disconnectCallback = Runnable { // Perform any required operation on disconnect
        onActivityFinished()
        this.finish()
    }

    open fun onActivityFinished() {}


    fun resetDisconnectTimer() {
        disconnectHandler.removeCallbacks(disconnectCallback)
        disconnectHandler.postDelayed(disconnectCallback, DISCONNECT_TIMEOUT)
    }

    fun stopDisconnectTimer() {
        disconnectHandler.removeCallbacks(disconnectCallback)
    }

    override fun onUserInteraction() {
        super.onUserInteraction()

        if (IS_RESET_ON_USER_INTERACTION) {
            resetDisconnectTimer()
        }
    }

    override fun onResume() {
        super.onResume()
        resetDisconnectTimer()
    }

    override fun onStop() {
        super.onStop()
        stopDisconnectTimer()
    }


    inner class TextChangeListener : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            resetDisconnectTimer()
        }
    }
}
