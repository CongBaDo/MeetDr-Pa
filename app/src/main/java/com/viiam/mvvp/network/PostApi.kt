package com.viiam.mvvp.network

import com.viiam.mvvp.model.Post
import com.viiam.mvvp.model.metadata.MetadataResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface PostApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>

    @GET("/v1.0/commons/metadata")
    fun getMetadata():Observable<MetadataResponse>
}