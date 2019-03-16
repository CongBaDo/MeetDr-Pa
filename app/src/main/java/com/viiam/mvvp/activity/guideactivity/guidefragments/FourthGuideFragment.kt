package com.viiam.mvvp.activity.guideactivity.guidefragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viiam.mvvp.R
import com.viiam.mvvp.activity.guideactivity.GuideActivity
import kotlinx.android.synthetic.main.fragment_fourth_guide.*

class FourthGuideFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            buttonStart -> (activity as GuideActivity).startLogInActivity()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonStart.setOnClickListener(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_fourth_guide, container, false)
    }
}