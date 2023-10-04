package com.dmiranda.restapiphotos_m6c4.retrofit

import com.dmiranda.restapiphotos_m6c4.model.Photo
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("/photos")
    suspend fun getAllPhotos(): Response<ArrayList<Photo>>
}