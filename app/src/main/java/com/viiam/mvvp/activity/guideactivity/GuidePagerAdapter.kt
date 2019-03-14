package com.viiam.mvvp.activity.guideactivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import com.viiam.mvvp.R
import com.viiam.mvvp.activity.guideactivity.guidefragments.*
import com.xgc1986.parallaxPagerTransformer.ParallaxPagerTransformer
import kotlinx.android.synthetic.main.activity_guide.*

class GuidePagerAdapter(fragmentManager: FragmentManager, private val guideActivity:GuideActivity) : FragmentStatePagerAdapter(fragmentManager), ViewPager.OnPageChangeListener {
    private val firstGuideFragment = FirstGuideFragment()
    private val secondGuideFragment = SecondGuideFragment()
    private val thirdGuideFragment = ThirdGuideFragment()
    private val fourthGuideFragment = FourthGuideFragment()
    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> firstGuideFragment
            1 -> secondGuideFragment
            2 -> thirdGuideFragment
            else -> fourthGuideFragment
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun onPageScrollStateChanged(state: Int) {
        Log.d("GuidePagerAdapter", "onPageScrollStateChanged: $state")
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        Log.d("GuidePagerAdapter", "onPageScrolled: $position $positionOffset $positionOffsetPixels")
    }

    override fun onPageSelected(position: Int) {
        Log.d("GuidePagerAdapter", "onPageSelected: $position")
        when(position){
            0 -> guideActivity.viewPagerGuide.setPageTransformer(false, ParallaxPagerTransformer(R.id.firstGuideImg))
            1 -> guideActivity.viewPagerGuide.setPageTransformer(false, ParallaxPagerTransformer(R.id.secondGuideImg))
            2 -> guideActivity.viewPagerGuide.setPageTransformer(false, ParallaxPagerTransformer(R.id.thirdGuideImg))
            3 -> guideActivity.viewPagerGuide.setPageTransformer(false, ParallaxPagerTransformer(R.id.fourthGuideImg))
        }
    }
}