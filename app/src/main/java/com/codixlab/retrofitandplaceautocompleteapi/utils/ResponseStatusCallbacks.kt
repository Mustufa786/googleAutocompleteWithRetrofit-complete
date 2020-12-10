package com.codixlab.retrofitandplaceautocompleteapi.utils

/**
 * created by Mustufa Ansari on 18,August,2020
 * Email : mustufaayub82@gmail.com
 */
data class ResponseStatusCallbacks<out T>(
    val status: ResponseStatus,
    val data: T?,
    val message: String?
) {
    companion object {
        fun <T> success(data: T): ResponseStatusCallbacks<T> =
            ResponseStatusCallbacks(status = ResponseStatus.SUCCESS, data = data, message = null)

        fun <T> error(data: T?, message: String): ResponseStatusCallbacks<T> =
            ResponseStatusCallbacks(status = ResponseStatus.ERROR, data = data, message = message)

        fun <T> loading(data: T?): ResponseStatusCallbacks<T> =
            ResponseStatusCallbacks(status = ResponseStatus.LOADING, data = data, message = null)
    }
}