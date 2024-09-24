package com.android.goally.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.android.goally.BaseActivity
import com.android.goally.databinding.ActivityHomeBinding
import com.android.goally.databinding.ActivitySplashBinding
import com.android.goally.util.setSafeOnClickListener
import com.android.goally.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        binding.run {
            llCopilot.setSafeOnClickListener {
                toast("Copilot clicked")
            }

            llRewards.setSafeOnClickListener {
                toast("Rewards clicked")
            }

        }
    }

    private fun setupObservers() {
        //observer goes here
        generalViewModel.getAuthenticationLive().observe(this) {
            it?.let {
                binding.tvEmail.text = "You are logged in as\n${it.name}"
            }
        }
    }


    companion object{
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
}