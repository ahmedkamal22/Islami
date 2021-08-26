package com.kamal.islamiproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.fragments.Mb3QuranFragment
import com.example.islami.fragments.QuranFragment
import com.kamal.islamiproject.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigation.setOnNavigationItemSelectedListener {
            if(it.itemId == R.id.navigation_quran)
            {
                createFragment(QuranFragment())
            }
            else if(it.itemId == R.id.navigation_Mb3_Quran)
            {
                createFragment(Mb3QuranFragment())
            }
            return@setOnNavigationItemSelectedListener true
        }
        navigation.selectedItemId = R.id.navigation_quran
    }
    private fun createFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
            .replace(R.id.fragment_container,fragment)
            .addToBackStack(null)
            .commit()
    }
}