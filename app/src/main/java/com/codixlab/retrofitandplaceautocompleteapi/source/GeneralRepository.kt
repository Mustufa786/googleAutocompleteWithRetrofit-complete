package com.codixlab.retrofitandplaceautocompleteapi.source

import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceAutoCompleteResponse
import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceDetailsResponse

/**
 * created by Mustufa Ansari on 18,August,2020
 * Email : mustufaayub82@gmail.com
 */
class GeneralRepository(
    private var generalRemoteDataSource: GeneralRemoteDataSource
) : GeneralDataSource {

    companion object {
        private var INSTANCE: GeneralRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.
         * @param generalRemoteDataSource the backend data source
         * *
         * @param generalLocalDataSource  the device storage data source
         * *
         * @return the [JobsRepository] instance
         */
        @JvmStatic
        fun get(
            generalRemoteDataSource: GeneralRemoteDataSource
        ) = INSTANCE ?: synchronized(GeneralRepository::class.java) {
            INSTANCE ?: GeneralRepository(generalRemoteDataSource).also {
                INSTANCE = it
            }
        }

        /**
         * Used to force [get] to create a new instance
         * next time it's called.
         */
        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override suspend fun getAutocompletePlaces(
        input: String
    ): PlaceAutoCompleteResponse {
        return generalRemoteDataSource.getAutocompletePlaces(input)
    }

    override suspend fun getPlaceDetails(placeId: String): PlaceDetailsResponse {
        return generalRemoteDataSource.getPlaceDetails(placeId)
    }

}