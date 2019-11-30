package com.jdhome.mvvmkotlin.database.localDatabase.dao.pic

import androidx.room.*
import com.jdhome.mvvmkotlin.database.localDatabase.model.picture.PictureTbl
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PictureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(appSettings: PictureTbl): Completable

    @Query("SELECT * FROM PictureTable")
    fun get(): Single<PictureTbl>

    @Update
    fun update(appSettings: PictureTbl): Completable


}
