package com.jdhome.mvvmkotlin.database.localDatabase.dao

import androidx.room.*
import com.jdhome.mvvmkotlin.database.localDatabase.model.SampleTbl
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(appSettings: SampleTbl): Completable

    @Query("SELECT * FROM AppSettings")
    fun get(): Single<SampleTbl>

    @Update
    fun update(appSettings: SampleTbl): Completable


}
