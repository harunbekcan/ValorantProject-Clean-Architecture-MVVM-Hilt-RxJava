package com.harunbekcan.valorantproject.ui.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseActivity
import com.harunbekcan.valorantproject.databinding.ActivityMainBinding
import com.harunbekcan.valorantproject.utils.setGone
import com.harunbekcan.valorantproject.utils.setVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun prepareView(savedInstanceState: Bundle?) {
        initNavController()
    }

    private fun initNavController(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigationView,navHostFragment.navController)
        onDestinationChanged(navHostFragment.navController)
    }

    private fun onDestinationChanged(navController: NavController){
        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.agentsFragment -> {
                    binding.bottomNavigationView.setVisible()
                }
                R.id.mapsFragment -> {
                    binding.bottomNavigationView.setVisible()
                }
                R.id.weaponsFragment -> {
                    binding.bottomNavigationView.setVisible()
                }
                R.id.tiersFragment -> {
                    binding.bottomNavigationView.setVisible()
                }
                else -> {
                    binding.bottomNavigationView.setGone()
                }
            }
        }
    }
}