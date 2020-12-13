package com.codixlab.retrofitandplaceautocompleteapi.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.codixlab.retrofitandplaceautocompleteapi.R
import com.codixlab.retrofitandplaceautocompleteapi.extension.gotoActivity

class SplashActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        
        Handler().postDelayed({
            gotoActivity(MainActivity::class.java)
        },2000)

    }





}