package com.viiam.mvvp.viewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import android.util.Log
import com.viiam.mvvp.database.NemoDatabase
import com.viiam.mvvp.database.PostDao
import com.viiam.mvvp.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers.*
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PostReposity(application: Application) : BaseReposity(application) {

    private var TAG: String = "PostReposity"

    private var postDao: PostDao
    private var posts: LiveData<List<Post>>
    private var subscription: Disposable? = null

    init {
        postDao = NemoDatabase.getInstance(application)!!.postDao()
        posts = postDao.getAllPost()
    }

    fun getPostFromApi() {
        subscription = postApi
                .getPosts()
                .observeOn(mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate {Log.e(TAG, "onTerminate ") }
                .subscribe(
                        { postList ->
                            for(i in 0..postList.size-1){
                                insert(postList.get(i))
                            }
                        },
                        { error ->
                            error.message
                            Log.e(TAG, "Message Err " + error.message)
                        }
                )
    }

    fun getAllPost(): LiveData<List<Post>> {
        return posts
    }

    fun insert(post: Post) {
        InsertAsyncTask(postDao).execute(post)
    }

    private class InsertAsyncTask internal constructor(private val postDao: PostDao) : AsyncTask<Post, Void, Void>() {

        override fun doInBackground(vararg params: Post): Void? {
            postDao.insert(params[0])
            return null
        }
    }
}