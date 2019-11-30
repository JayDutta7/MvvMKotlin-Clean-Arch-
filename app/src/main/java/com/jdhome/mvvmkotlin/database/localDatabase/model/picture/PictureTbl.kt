package com.jdhome.mvvmkotlin.database.localDatabase.model.picture

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PictureTable")
data class PictureTbl(
    @PrimaryKey/*(autoGenerate = true) val deliveryProductTblId: Int = 0,*/
    @ColumnInfo(name = "headerColour") val headerColour: String,
    @ColumnInfo(name = "headerTxtColour") val headerTxtColour: String?,
    @ColumnInfo(name = "headerBtnColour") val headerBtnColour: String?,
    @ColumnInfo(name = "screenBkgColour") val screenBkgColour: String?
)