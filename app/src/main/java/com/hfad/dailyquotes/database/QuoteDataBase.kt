package com.hfad.dailyquotes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hfad.dailyquotes.dao.QuoteDao
import com.hfad.dailyquotes.model.Quotedataclass

@Database(entities = [Quotedataclass::class], version = 1, exportSchema = false)
abstract class QuoteDataBase: RoomDatabase() {
    abstract fun motDao(): QuoteDao

}