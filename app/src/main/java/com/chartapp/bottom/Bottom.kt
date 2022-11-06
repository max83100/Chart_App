package com.chartapp.bottom

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.annotation.SuppressLint
import android.os.Bundle
import com.chartapp.R
import androidx.appcompat.app.AppCompatDelegate
import com.chartapp.bottom.ChartFragment
import android.graphics.drawable.ColorDrawable
import androidx.core.content.ContextCompat
import com.chartapp.bottom.SoftFragment
import com.chartapp.bottom.OtherFragment
import com.google.firebase.messaging.FirebaseMessaging
import com.google.android.gms.tasks.OnCompleteListener
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class Bottom : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var bottom_nav: BottomNavigationView
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom2)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        bottom_nav = findViewById(R.id.bottomNavView)
        bottom_nav.setOnNavigationItemSelectedListener(navListener)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, ChartFragment()).commit()
        toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        toolbar.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.toolbar)))
        window.statusBarColor = ContextCompat.getColor(this, R.color.toolbar)
        fcm()
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.chart_menu -> selectedFragment = ChartFragment()
            R.id.soft_menu -> selectedFragment = SoftFragment()
            R.id.other_menu -> selectedFragment = OtherFragment()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, selectedFragment!!).commit()
        true
    }

    fun fcm() {
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Toast.makeText(
                        applicationContext,
                        "Fetching FCM registration token failed",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@OnCompleteListener
                }
                val token = task.result
            })
    }



    companion object {
        private const val TAG = "MyActivity"
    }
}