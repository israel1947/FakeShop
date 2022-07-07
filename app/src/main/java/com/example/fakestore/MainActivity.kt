package com.example.fakestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fakestore.fragments.Home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val homeFragment = HomeFragment();
    //val favoriteFragment = FavoriteFragment();
    //val profileFragment = ProfileFragment();
}