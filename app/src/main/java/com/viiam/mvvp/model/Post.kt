package com.viiam.mvvp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Class which provides a model for post
 * @constructor Sets all properties of the post
 * @property userId the unique identifier of the author of the post
 * @property id the unique identifier of the post
 * @property title the title of the post
 * @property body the content of the post
 */

@Entity(tableName = "post_table")
data class Post(@PrimaryKey val id: Int){

    @ColumnInfo(name = "user_id")
    var userId: String = ""

    @ColumnInfo(name = "title")
    var title: String = ""

    @ColumnInfo(name = "body_content")
    var body: String = ""
}