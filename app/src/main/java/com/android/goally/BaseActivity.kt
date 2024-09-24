package com.android.goally

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.goally.ui.viewmodels.GeneralViewModel
import com.android.goally.util.PreferenceUtil
import com.google.gson.Gson
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    protected val generalViewModel: GeneralViewModel by viewModels()

    @Inject
    lateinit var preferenceUtil: PreferenceUtil

    @Inject
    lateinit var gson: Gson

}