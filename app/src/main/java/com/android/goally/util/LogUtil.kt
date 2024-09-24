package com.android.goally.util

import android.util.Log
import com.intuit.sdp.BuildConfig


object LogUtil {
    @JvmStatic
    fun i(message: String?) {
        if (BuildConfig.DEBUG) Log.i("Goally==>", message!!)
        checkAndAddLogging(message)
    }

    fun v(message: String?) {
        if (BuildConfig.DEBUG) Log.v("Goally==>", message!!)
        checkAndAddLogging(message)
    }

    @JvmStatic
    fun e(message: String?) {
        if (BuildConfig.DEBUG) Log.e("Goally==>", message!!)
        checkAndAddLogging(message)
    }

    fun d(message: String?) {
        if (BuildConfig.DEBUG) Log.d("Goally==>", message!!)
        checkAndAddLogging(message)
    }

    /*
    1. Create file in internal storage with according to parent date and keep putting logs for each day in same file
    2. Once date changed create new file and keep putting logs in new (updated date) created file
    3. Upload yesterday file as soon as new file created on s3
    4. Delete file after one week from internal storage or after 3 retries
    5. Delete files after 15 days from s3
     */
    private fun checkAndAddLogging(message: String?) {
//        try {
//            if (!BuildConfig.PLAY_STORE) {
//                val file =
//                    DownloadUtil.createFileForAppMedia(
//                        AppConstant.LOGS,
//                        "${DateTimeUtil.getTodayDate()}.txt"
//                    )
//
//                if (message == null) return
//                val textToAppend =
//                    DateTimeUtil.getParentTimeString() + message.trim().take(500) + "\n\n"
//                file.appendText(textToAppend, Charset.defaultCharset())
//            }
//        } catch (ex: Exception) {
//            ex.printStackTrace()
//        }
    }
}


