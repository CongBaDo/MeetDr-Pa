package com.viiam.mvvp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.viiam.mvvp.database.PostDao
import com.viiam.mvvp.model.Post

class PostViewModel(application: Application) : AndroidViewModel(application){

    private var postReposity: PostReposity
    private var posts : LiveData<List<Post>>;

    init {
        postReposity = PostReposity(application)
        posts = postReposity.getAllPost()
    }

    fun getPostsFromApi(){
        postReposity.getPostFromApi()
    }

    fun getAllPost(): LiveData<List<Post>>{
        return posts
    }

    fun insert(post: Post){
        postReposity.insert(post)
    }
}