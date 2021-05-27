package com.danielvilha.devbytes.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by danielvilha on 26/05/21
 * https://github.com/danielvilha
 *
 * Stores a collection of Database videos in a room database
 */

@Dao
interface VideoDao {
    @Query("SELECT * FROM databasevideo")
    fun getVideos(): LiveData<List<DatabaseVideo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg videos: DatabaseVideo)
}

@Database(entities = [DatabaseVideo::class], version = 1)
abstract class VideosDatabase: RoomDatabase() {
    abstract val videoDao: VideoDao
}

private lateinit var INSTANCE: VideosDatabase

fun getDatabase(context: Context): VideosDatabase {
    if (!::INSTANCE.isInitialized) {
        INSTANCE = Room.databaseBuilder(context.applicationContext,
                VideosDatabase::class.java,
                "videos").build()
    }

    return INSTANCE
}