package com.hfad.dailyquotes.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.hfad.dailyquotes.model.Quotedataclass
import com.hfad.dailyquotes.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: QuoteRepository
): ViewModel() {

    private val _quoteIndex = MutableLiveData(-1)

    private val category = MutableLiveData("")

    val quotes: LiveData<List<Quotedataclass>> = category.switchMap {
            categoryName ->
        repository.getQuotesByCategory(categoryName)
    }

    val currentQuote: LiveData<Quotedataclass?> = _quoteIndex.switchMap { index ->
        if (!quotes.value.isNullOrEmpty()) {
            val myQuote = quotes.value!![index]
            MutableLiveData(myQuote)
        } else {
            MutableLiveData(null)
        }
    }

    fun updateQuoteIndex() {
        if (_quoteIndex.value == -1) _quoteIndex.value = 0
    }

    fun updateQuoteIsFavorite(isFavorite: Boolean){
        viewModelScope.launch {
            currentQuote.value?.let {
                    quote ->
                repository.updateQuote(quote.copy(isFavorite = isFavorite))
            }
        }
    }


    fun addQuote(quote: Quotedataclass) =
        viewModelScope.launch {
            repository.insertQuote(quote)
        }
    fun editQuote(quote: Quotedataclass) =
        viewModelScope.launch {
            repository.updateQuote(quote)
        }

    fun removeQuoteFromFavorite(quote: Quotedataclass) =
        viewModelScope.launch {
            repository.updateQuote(quote)
        }

    fun removeQuote(quote: Quotedataclass) =
        viewModelScope.launch {
            repository.deleteQuote(quote)
        }


    fun getQuotesByCategory(categoryText: String){
        category.value = categoryText
    }

    fun previousQuote(){
        _quoteIndex.value?.let {
            index ->
            if (index > 0){
                _quoteIndex.value = index - 1
            }
        }
    }

    fun nextQuote(){
        _quoteIndex.value?.let {
                index ->
            val quotesListSize = quotes.value?.size ?: 0
            if (index < (quotesListSize - 1)){
                _quoteIndex.value = index + 1
            }
        }
    }


    val getAllQuote = repository.getAllFavoriteQuotes()

    val userQuotes = repository.userQuotes()


}