package com.hfad.dailyquotes.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase.Callback
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hfad.dailyquotes.dao.QuoteDao
import com.hfad.dailyquotes.database.QuoteDataBase
import com.hfad.dailyquotes.database.getPrePopulatedData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideQuoteDataBase(@ApplicationContext context: Context): QuoteDataBase{
        return Room.databaseBuilder(context,
            QuoteDataBase::class.java, "quote_database")
            .addCallback(
                object : Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            provideQuoteDataBase(context).motDao().insert(getPrePopulatedData())
                        }
                    }
                })
            .build()
    }

    @Provides
    @Singleton
    fun provideDaoClassToDataBase(quoteDataBase: QuoteDataBase): QuoteDao{
        return quoteDataBase.motDao()
    }
}