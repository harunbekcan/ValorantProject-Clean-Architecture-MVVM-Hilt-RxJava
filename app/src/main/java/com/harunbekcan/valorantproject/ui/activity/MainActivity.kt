package com.harunbekcan.valorantproject.ui.activity

import android.os.Bundle
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseActivity
import com.harunbekcan.valorantproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun prepareView(savedInstanceState: Bundle?) {}

}