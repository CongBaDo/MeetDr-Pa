package com.viiam.mvvp.activity.guideactivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
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

    private var mCurrentPosition: Int = 0
    private var mScrollState: Int = 0
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
        handleScrollState(state)
        mScrollState = state
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        when (position) {
            count-1 -> guideActivity.setContinueButtonVisibility(View.INVISIBLE)
            else -> guideActivity.setContinueButtonVisibility(View.VISIBLE)
        }
    }

    override fun onPageSelected(position: Int) {
        mCurrentPosition = position
        when(position){
            0 -> guideActivity.viewPager.setPageTransformer(false, ParallaxPagerTransformer(R.id.imageView))
            1 -> guideActivity.viewPager.setPageTransformer(false, ParallaxPagerTransformer(R.id.imageView))
            2 -> guideActivity.viewPager.setPageTransformer(false, ParallaxPagerTransformer(R.id.imageView))
            3 -> guideActivity.viewPager.setPageTransformer(false, ParallaxPagerTransformer(R.id.imageView))
        }
    }

    private fun handleScrollState(state: Int) {
        if (state == ViewPager.SCROLL_STATE_IDLE && mScrollState == ViewPager.SCROLL_STATE_DRAGGING) {
            setNextItemIfNeeded()
        }
    }

    private fun setNextItemIfNeeded() {
        if (!isScrollStateSettling()) {
            handleSetNextItem()
        }
    }

    private fun isScrollStateSettling(): Boolean {
        return mScrollState == ViewPager.SCROLL_STATE_SETTLING
    }

    private fun handleSetNextItem() {
        val lastPosition = guideActivity.viewPager.adapter?.count!! - 1
        if (mCurrentPosition == 0) {
            guideActivity.viewPager.setCurrentItem(lastPosition, true)
        } else if (mCurrentPosition == lastPosition) {
            guideActivity.viewPager.setCurrentItem(0, true)
        }
    }

    fun increaseCurrentItemPosition(){
        if(mCurrentPosition < count-1)
            guideActivity.viewPager.setCurrentItem(++mCurrentPosition, true)
    }
}