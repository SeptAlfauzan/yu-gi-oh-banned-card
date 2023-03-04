package com.example.yugioh25tcgcardsbanned

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_SCREEN_TIMEOUT = 1500L;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.navigationBarColor = ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_primary_variant)



        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN_TIMEOUT)
    }
}