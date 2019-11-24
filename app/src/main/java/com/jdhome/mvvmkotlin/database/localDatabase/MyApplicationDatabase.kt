package com.jdhome.mvvmkotlin.database.localDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jdhome.mvvmkotlin.database.localDatabase.dao.SampleDao
import com.jdhome.mvvmkotlin.database.localDatabase.model.SampleTbl

@Database(
    entities =
    [SampleTbl::class], version = 1, exportSchema = false
)
abstract class MyAppDataBase : RoomDatabase() {



    //For Color Code
    abstract fun appSettings(): SampleDao




    companion object {

        private var INSTANCE: MyAppDataBase? = null

        fun getDatabase(context: Context): MyAppDataBase {

            if (INSTANCE == null) {

                /*
                 inMemoryDatabaseBuilder():
                 /////////////////////////////////////
                 The database will be created in system memory,
                  If you kill the app (Killing your process),
                   database will be removed and data will not be persisted.
                    This can be used while Testing.

                databaseBuilder() :
                 /////////////////////////////////////
                 The database will be created in /data/data/com.your.app and will be persisted.
                  This you will be using it in production.

                  */

                synchronized(MyAppDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyAppDataBase::class.java,
                        "tracking_solution.db"
                    )     //.allowMainThreadQueries() //when publish no main thread call allowed
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }

    }

}