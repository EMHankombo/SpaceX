package com.example.android.spacex.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "article")
    val article: String,
    @Json(name = "patch")
    val patch: Patch,
    @Json(name = "webcast")
    val webcast: String,
    @Json(name = "wikipedia")
    val wikipedia: String,
    @Json(name = "youtube_id")
    val youtubeId: String
)