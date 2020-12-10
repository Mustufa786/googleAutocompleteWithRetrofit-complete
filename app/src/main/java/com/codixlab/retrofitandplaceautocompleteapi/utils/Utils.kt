package com.codixlab.retrofitandplaceautocompleteapi.utils

import com.codixlab.retrofitandplaceautocompleteapi.R

object Utils {
    fun getGoogleClientApiKey(): String =
        InjectUtils.resources.getString(R.string.google_api_client_key)
}