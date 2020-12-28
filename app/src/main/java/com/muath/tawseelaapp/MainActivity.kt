package com.muath.tawseelaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.muath.tawseelaapp.majed.AddRequestFragment
import com.muath.tawseelaapp.majed.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    fab.visibility = View.VISIBLE
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                        HomeFragment()
                    ).commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_mail -> {
                    fab.visibility = View.INVISIBLE


                }
                R.id.nav_notifications -> {
                    fab.visibility = View.INVISIBLE

                }
                R.id.nav_person -> {
                    fab.visibility = View.INVISIBLE
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottom_navigation.selectedItemId =R.id.nav_home

        fab.setOnClickListener {
            replaceFragment(AddRequestFragment())
        }



    }

    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
            fragment).commit()
    }
}