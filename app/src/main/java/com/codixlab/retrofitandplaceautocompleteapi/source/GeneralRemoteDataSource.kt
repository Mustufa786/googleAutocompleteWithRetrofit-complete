package com.codixlab.retrofitandplaceautocompleteapi.source

import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceAutoCompleteResponse
import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceDetailsResponse
import com.codixlab.retrofitandplaceautocompleteapi.utils.InjectUtils

/**
 * created by Mustufa Ansari on 18,August,2020
 * Email : mustufaayub82@gmail.com
 */
class GeneralRemoteDataSource : GeneralDataSource {
    override suspend fun getAutocompletePlaces(
        input: String
    ): PlaceAutoCompleteResponse {
        return InjectUtils.getRetrofit.getAutoCompletePlaces(input = input)
    }

    override suspend fun getPlaceDetails(placeId: String): PlaceDetailsResponse {
        return InjectUtils.getRetrofit.getPlaceDetails(placeId)
    }
}