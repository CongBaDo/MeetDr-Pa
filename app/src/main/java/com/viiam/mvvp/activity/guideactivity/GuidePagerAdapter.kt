package com.viiam.mvvp.activity.guideactivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
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
            count-1 -> guideActivity.setContinueButtonInvisible()
            else -> guideActivity.setContinueButtonVisible()
        }
    }

    override fun onPageSelected(position: Int) {
        mCurrentPosition = position
        when(position){
            0 -> guideActivity.viewPagerGuide.setPageTransformer(false, ParallaxPagerTransformer(R.id.firstGuideImg))
            1 -> guideActivity.viewPagerGuide.setPageTransformer(false, ParallaxPagerTransformer(R.id.secondGuideImg))
            2 -> guideActivity.viewPagerGuide.setPageTransformer(false, ParallaxPagerTransformer(R.id.thirdGuideImg))
            3 -> guideActivity.viewPagerGuide.setPageTransformer(false, ParallaxPagerTransformer(R.id.fourthGuideImg))
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
        val lastPosition = guideActivity.viewPagerGuide.adapter?.count!! - 1
        if (mCurrentPosition == 0) {
            guideActivity.viewPagerGuide.setCurrentItem(lastPosition, true)
        } else if (mCurrentPosition == lastPosition) {
            guideActivity.viewPagerGuide.setCurrentItem(0, true)
        }
    }

    fun increaseCurrentItemPosition(){
        guideActivity.viewPagerGuide.setCurrentItem(++mCurrentPosition, true)
    }
}