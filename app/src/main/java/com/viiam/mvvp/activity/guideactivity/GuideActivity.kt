package com.viiam.mvvp.activity.guideactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.view.Window
import com.viiam.mvvp.R
import com.xgc1986.parallaxPagerTransformer.ParallaxPagerTransformer
import kotlinx.android.synthetic.main.activity_guide.*

class GuideActivity : AppCompatActivity(), View.OnClickListener{
    override fun onClick(v: View?) {
        when(v){
            prevGuideBtn -> viewPagerGuide.currentItem -= if (viewPagerGuide.currentItem > 0) 1 else 0
            nextGuideBtn -> viewPagerGuide.currentItem += if (viewPagerGuide.currentItem < viewPagerGuide.adapter?.count!!-1) 1 else 0
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        supportActionBar?.hide()
        setContentView(R.layout.activity_guide)
        prevGuideBtn.bringToFront()
        nextGuideBtn.bringToFront()

        prevGuideBtn.setOnClickListener(this)
        nextGuideBtn.setOnClickListener(this)

        addControl()
    }

    private fun addControl() {
        viewPagerGuide.setPageTransformer(false, ParallaxPagerTransformer(R.id.firstGuideImg))
        viewPagerGuide.adapter = GuidePagerAdapter(supportFragmentManager, this).apply {
            registerDataSetObserver(circleIndicatorGuide.dataSetObserver)
        }
        viewPagerGuide.addOnPageChangeListener(viewPagerGuide.adapter as ViewPager.OnPageChangeListener)

        circleIndicatorGuide.setViewPager(viewPagerGuide)
    }
}