package com.viiam.mvvp.activity

import androidx.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.viiam.mvvp.BASE_URL
import com.viiam.mvvp.R
import com.viiam.mvvp.adapter.NemoAdapter
import com.viiam.mvvp.splashScreen.SplashActivity
import com.viiam.mvvp.viewmodel.PostViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_post.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class PostActivity : BaseActivity() {

    private val TAG: String = "PostActivity"
    private lateinit var adapter: NemoAdapter;
    private lateinit var postViewModel: PostViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        val pref=getSharedPreferences(SplashActivity.prefName,SplashActivity.prefMode)
        txtText.text=pref.getString(SplashActivity.prefName,"Not found")
//        progressBar.visibility = View.GONE
//
//        adapter = NemoAdapter(emptyList()){
//
//        }
//
//        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
//        postViewModel.getAllPost().observe(this, Observer {
//            adapter.updatePost(it!!)
//        })
//        rcPost.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
//        rcPost.adapter = adapter
//
//        butRequest.setOnClickListener(View.OnClickListener { postViewModel.getPostsFromApi() })
//        butFetch.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}