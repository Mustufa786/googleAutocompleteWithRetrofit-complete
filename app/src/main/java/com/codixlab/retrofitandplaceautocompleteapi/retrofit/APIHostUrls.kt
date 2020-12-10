package com.codixlab.retrofitandplaceautocompleteapi.retrofit

import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceAutoCompleteResponse
import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceDetailsResponse
import com.codixlab.retrofitandplaceautocompleteapi.utils.Constants.GoogleAPIs.PLACE_AUTOCOMPLETE_COMPONENT
import com.codixlab.retrofitandplaceautocompleteapi.utils.Constants.GoogleAPIs.PLACE_AUTOCOMPLETE_RADIUS
import com.codixlab.retrofitandplaceautocompleteapi.utils.Utils.getGoogleClientApiKey
import org.apache.commons.lang3.StringUtils
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by Mustufa Ansari on 12/10/2020.
 * Copyright (c) 2020 All rights reserved.
 */
interface APIHostUrls {

    @Headers(ApiFields.HEADER_ACCEPT_ENCODING)
    @GET(ApiRoutes.GOOGLE_PLACE_AUTOCOMPLETE)
    suspend fun getAutoCompletePlaces(
        @Query("input") input: String?,
        @Query("location") location: String = StringUtils.EMPTY,
        @Query("components") component: String = PLACE_AUTOCOMPLETE_COMPONENT,
        @Query("radius") radius: String = PLACE_AUTOCOMPLETE_RADIUS,
        @Query("key") googleMapApiKey: String = getGoogleClientApiKey()
    ): PlaceAutoCompleteResponse

    @Headers(ApiFields.HEADER_ACCEPT_ENCODING)
    @GET(ApiRoutes.GOOGLE_PLACE_DETAILS)
    suspend fun getPlaceDetails(
        @Query("place_id") placeID: String?,
        @Query("key") key: String = getGoogleClientApiKey()
    ): PlaceDetailsResponse

}