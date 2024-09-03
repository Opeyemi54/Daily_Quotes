package com.hfad.dailyquotes.repository

import com.hfad.dailyquotes.dao.QuoteDao
import com.hfad.dailyquotes.model.Quotedataclass
import com.hfad.dailyquotes.database.QuoteDataBase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteRepository @Inject constructor(
    private val dao: QuoteDao
) {

    fun userQuotes() = dao.getAllUserQuote()


    suspend fun insertQuote(quote: Quotedataclass) = dao.inputQuote(quote)
    suspend fun updateQuote(quote: Quotedataclass) = dao.update(quote)
    suspend fun deleteQuote(quote: Quotedataclass) = dao.delete(quote)
    fun getAllFavoriteQuotes() = dao.getFavoriteQuotes()

    fun getQuotesByCategory(category: String) = dao.getQuotesByCategory(category)
}