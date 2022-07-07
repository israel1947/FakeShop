package com.example.fakestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fakestore.fragments.Favorite.FavoriteFragment
import com.example.fakestore.fragments.Home.HomeFragment
import com.example.fakestore.fragments.Profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment();
        val favoriteFragment = FavoriteFragment();
        val profileFragment = ProfileFragment();

        val bottomNavegation:BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavegation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.page_1->{
                    setCurrentFragment(homeFragment);
                    true;
                }
                R.id.page_2->{
                    setCurrentFragment(favoriteFragment);
                    true;
                }
                R.id.page_3->{
                    setCurrentFragment(profileFragment);
                    true;
                }
                else-> false;
            }
        }
    }

    private fun setCurrentFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerView, fragment)
            commit();
        }
    }


}