package com.harunbekcan.valorantproject.ui.activity

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseActivity
import com.harunbekcan.valorantproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun prepareView(savedInstanceState: Bundle?) {
        initNavController()
    }

    private fun initNavController(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigationView,navHostFragment.navController)
    }

}