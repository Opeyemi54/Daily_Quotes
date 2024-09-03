package com.hfad.dailyquotes.model


class CategoriesClass(
    val title: String,
    val image: Int
) {
    fun getTitl(): String {
    return title
 }
    fun getImg(): Int {
        return image
    }
}