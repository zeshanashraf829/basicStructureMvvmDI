package com.android.goally.ui.splash

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.android.goally.BaseActivity
import com.android.goally.databinding.ActivitySplashBinding
import com.android.goally.ui.auth.AuthenticationActivity
import com.android.goally.ui.home.HomeActivity
import com.android.goally.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : BaseActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        setupObservers()
    }

    private fun setupObservers() {
        generalViewModel.checkServerHealth(onLoading = {
            binding.run {
                progressBar.isVisible = it
                tvProgressStatus.isVisible = it
            }
        }, onSuccess = {
            goToNextScreen()
        }, onError = {
            toast(it)
        })
    }

    private fun setupViews() {
        binding.run {
            hideAllViews()
            appLogo.setOnClickListener {
                toast("Please wait...")
            }
        }
    }


    private fun hideAllViews(){
        binding.run {
            progressBar.isVisible = false
            tvProgressStatus.isVisible = false
        }
    }

    private fun goToNextScreen() {
        lifecycleScope.launch {
            val authData = generalViewModel.getAuthentication()
            runOnUiThread {
                authData?.let {
                    if(it.token.isNullOrEmpty()) {
                        gotoAuthScreen()
                    }else{
                        startActivity(HomeActivity.getCallingIntent(this@SplashActivity))
                    }
                }?:run{
                    gotoAuthScreen()
                }
            }
        }
    }

    private fun gotoAuthScreen(){
        startActivity(AuthenticationActivity.getCallingIntent(this@SplashActivity))
    }
}