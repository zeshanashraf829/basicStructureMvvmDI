package com.android.goally.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import com.android.goally.BaseActivity
import com.android.goally.databinding.ActivityUserAuthBinding
import com.android.goally.ui.home.HomeActivity
import com.android.goally.util.setSafeOnClickListener
import com.android.goally.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationActivity : BaseActivity() {
    private lateinit var binding: ActivityUserAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        setupObservers()
    }

    private fun setupViews() {
        binding.run {
            ivSubmit.setSafeOnClickListener {
                if (checkValidation()) {
                    generalViewModel.getTokenFor(emailEt.text.toString(), onLoading = {
                        progressBar.isVisible = it
                    }, onError = {
                        toast(it)
                    }, onSuccess = {
                        goToHomeScreen()
                    })
                }
            }
        }
    }

    private fun goToHomeScreen() {
        startActivity(HomeActivity.getCallingIntent(this@AuthenticationActivity))
    }

    private fun setupObservers() {
        //observer goes here
        generalViewModel.getAuthenticationLive().observe(this) {
            it?.let {
                goToHomeScreen()
            }
        }
    }

    private fun checkValidation(): Boolean {
        val email = binding.emailEt.text

        return if (email.isEmpty()) {
            toast("Please enter email.")
            false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            toast("Please enter valid email.")
            false
        } else true
    }


    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, AuthenticationActivity::class.java)
        }
    }
}