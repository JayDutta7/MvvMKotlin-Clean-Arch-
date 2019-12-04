package com.jdhome.mvvmkotlin.ui.activity.splash

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jdhome.mvvmkotlin.R
import com.jdhome.mvvmkotlin.ui.activity.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        setContentView(R.layout.activity_splash)

        val splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)

        splashViewModel.liveData.observe(this, Observer {
            when (it) {
                is SplashViewModel.SplashState.HomeActivity -> {
                    goToMainActivity()
                }
            }
        })

    }//end of oncreate

    private fun goToMainActivity() {
        finish()
        startActivity(Intent(this, HomeActivity::class.java))
    }

}
