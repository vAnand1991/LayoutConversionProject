package com.naxtre.layoutconversionproject

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class VoicePagerAdapter(val fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager){
    private val tabTitles = arrayOf("GOOGLE", "ALEXA", "SOMETHING", "GOOGLESOMETHING")
    override fun getItem(position: Int): Fragment {
        when(position) {
            1 -> return WifiSettingsFragment()
            2-> return PlugImageEditFragment()
            3 -> return PlugNameEditFragment()
            else -> return VoiceCommandsFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles.get(position)
    }




}