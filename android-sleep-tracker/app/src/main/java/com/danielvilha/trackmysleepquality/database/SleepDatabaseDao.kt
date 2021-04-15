package com.danielvilha.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by danielvilha on 15/04/21
 * https://github.com/danielvilha
 *
 * Defines methods for using the SleepNight class with Room.
 */
@Dao
interface SleepDatabaseDao {

    @Insert
    suspend fun insert(night: SleepNight)

    /**
     * When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param night new value to write
     */
    @Update
    suspend fun update(night: SleepNight)

    /**
     * Selects and returns the row that matches the supplied start time, which is our key.
     *
     * @param key startTimeMilli to match
     */
    @Query("SELECT * from daily_sleep_quality_table WHERE nightId = :key")
    suspend fun get(key: Long): SleepNight?

    /**
     * Deletes all values from the table.
     *
     * This does not delete the table, only its contents.
     */
    @Delete
    suspend fun delete(night: SleepNight)

    @Delete
    suspend fun deleteAllNight(nights: List<SleepNight>): Int

    @Query("DELETE FROM daily_sleep_quality_table")
    suspend fun clear()

    /**
     * Selects and returns all rows in the table,
     *
     * sorted by start time in descending order.
     */
    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>

    /**
     * Selects and returns the latest night.
     */
    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
    suspend fun getTonight(): SleepNight?
}