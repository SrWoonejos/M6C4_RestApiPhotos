package com.dmiranda.restapiphotos_m6c4.model

data class Photo (
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)