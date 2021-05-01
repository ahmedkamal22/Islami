package com.kamal.islamiproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.islami.base.BaseActivity


class SplachActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach)
        Handler().postDelayed({
            MoveToHomeActivity()
        },2000)
    }

    private fun MoveToHomeActivity() {
        val intent = Intent(this@SplachActivity,
            HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}