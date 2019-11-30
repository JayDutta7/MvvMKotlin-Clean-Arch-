package com.jdhome.mvvmkotlin.database.localDatabase.dao.video

import androidx.room.*
import com.jdhome.mvvmkotlin.database.localDatabase.model.video.VideoTbl
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface VideoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(appSettings: VideoTbl): Completable

    @Query("SELECT * FROM VideoTbl WHERE")
    fun get(): Single<VideoTbl>

    @Update
    fun update(appSettings: VideoTbl): Completable
}