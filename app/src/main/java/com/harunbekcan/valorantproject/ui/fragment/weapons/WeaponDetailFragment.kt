package com.harunbekcan.valorantproject.ui.fragment.weapons

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.harunbekcan.valorantproject.R
import com.harunbekcan.valorantproject.base.BaseFragment
import com.harunbekcan.valorantproject.data.uimodel.weapons.WeaponDetailItem
import com.harunbekcan.valorantproject.databinding.FragmentWeaponDetailBinding
import com.harunbekcan.valorantproject.ui.adapter.weapons.SkinsAdapter
import com.harunbekcan.valorantproject.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeaponDetailFragment : BaseFragment<FragmentWeaponDetailBinding>() {

    private val viewModel : WeaponDetailViewModel by viewModels()
    private val navArgs : WeaponDetailFragmentArgs by navArgs()
    private lateinit var skinsAdapter: SkinsAdapter

    override fun getLayoutId(): Int = R.layout.fragment_weapon_detail

    override fun prepareView(savedInstanceState: Bundle?) {
        viewModel.weaponDetailRequest(navArgs.uuid)
        initWeaponDetailItemObserve()
        initBackButton()
    }

    private fun initBackButton(){
        binding.weaponDetailLayout.backButtonImageView.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initUi(weaponDetailItem: WeaponDetailItem){
        binding.weaponDetailLayout.apply {
            weaponDetailItem.let { item->
                weaponIconImageView.loadImage(item.weaponIcon)
                weaponNameTextView.text = item.weaponName
                weaponCategoryTextView.text = item.weaponCategory
                setProgressBar(item)
                initSkinsAdapter(item)
            }
        }
    }

    private fun setProgressBar(weaponDetailItem: WeaponDetailItem){
        binding.weaponDetailLayout.apply {
            weaponDetailItem.let { item->
                item.damageRangeList?.get(0).let {
                    it?.headDamage?.let { headDamage->
                        headProgressBar.progress = headDamage.toInt()
                        headDamageTextView.text = getString(R.string.head_damage,it.headDamage)
                    }

                    it?.bodyDamage?.let { bodyDamage->
                        bodyProgressBar.progress = bodyDamage
                        bodyDamageTextView.text = getString(R.string.body_damage,it.bodyDamage)
                    }

                    it?.legDamage?.let { legDamage->
                        legProgressBar.progress = legDamage.toInt()
                        legDamageTextView.text = getString(R.string.leg_damage,it.legDamage)
                    }
                }
            }
        }
    }

    private fun initSkinsAdapter(weaponDetailItem: WeaponDetailItem){
        weaponDetailItem.skinList?.let {
            skinsAdapter = SkinsAdapter(it)
            binding.weaponDetailLayout.skinsRecyclerView.adapter = skinsAdapter
        }
    }

    private fun initWeaponDetailItemObserve() {
        viewModel.weaponDetailItem.observe(viewLifecycleOwner){
            initUi(it)
        }
    }
}