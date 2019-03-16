package com.viiam.mvvp.activity.guideactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import android.view.Window
import com.viiam.mvvp.R
import com.viiam.mvvp.activity.LoginActivity
import com.xgc1986.parallaxPagerTransformer.ParallaxPagerTransformer
import kotlinx.android.synthetic.main.activity_guide.*

class GuideActivity : AppCompatActivity(), View.OnClickListener{
    override fun onClick(v: View?) {
        when (v) {
            buttonContinue -> (viewPager.adapter as GuidePagerAdapter).increaseCurrentItemPosition()
            buttonSkip -> startLogInActivity()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        supportActionBar?.hide()
        setContentView(R.layout.activity_guide)

        buttonContinue.setOnClickListener(this)
        buttonSkip.setOnClickListener(this)

        addControl()
    }

    private fun addControl() {
        viewPager.setPageTransformer(false, ParallaxPagerTransformer(R.id.imageView))
        viewPager.adapter = GuidePagerAdapter(supportFragmentManager, this).apply {
            registerDataSetObserver(circleIndicator.dataSetObserver)
        }
        viewPager.addOnPageChangeListener(viewPager.adapter as ViewPager.OnPageChangeListener)

        circleIndicator.setViewPager(viewPager)
    }

    fun setContinueButtonVisibility(visibility:Int){
        buttonContinue.visibility = visibility
    }

    fun startLogInActivity(){
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }

    companion object {
        const val SKIP_GUIDE = "SKIP_GUIDE"
    }
}