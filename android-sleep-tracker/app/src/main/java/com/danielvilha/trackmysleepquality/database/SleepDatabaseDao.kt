package com.danielvilha.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by danielvilha on 15/04/21
 * https://github.com/danielvilha
 */
@Dao
interface SleepDatabaseDao {

    @Insert
    fun insert(night: SleepNight)

    @Update
    fun update(night: SleepNight)

    @Query("SELECT * FROM daily_sleep_quality_table WHERE nightId = :key")
    fun get(key: Long): SleepNight

    @Delete
    fun delete(night: SleepNight)

    @Delete
    fun deleteAllNight(nights: List<SleepNight>): Int

    @Query("DELETE FROM daily_sleep_quality_table")
    fun clear()

    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>

    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
    fun getTonight(): SleepNight?
}