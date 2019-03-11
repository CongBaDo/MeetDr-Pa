package com.viiam.mvvp.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.viiam.mvvp.R
import com.viiam.mvvp.adapter.NemoAdapter
import com.viiam.mvvp.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : BaseActivity() {

    private val TAG: String = "PostActivity"
    private lateinit var adapter: NemoAdapter;
    private lateinit var postViewModel: PostViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        progressBar.visibility = View.GONE

        adapter = NemoAdapter(emptyList()){

        }

        postViewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        postViewModel.getAllPost().observe(this, Observer {
            adapter.updatePost(it!!)
        })
        rcPost.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        rcPost.adapter = adapter

        butRequest.setOnClickListener(View.OnClickListener { postViewModel.getPostsFromApi() })
        butFetch.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}