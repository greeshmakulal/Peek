package com.greeshma.peek.data.response

import com.greeshma.peek.data.model.News

data class NewsResponse(
    val available: Int,
    val news: List<News>,
    val number: Int,
    val offset: Int
)