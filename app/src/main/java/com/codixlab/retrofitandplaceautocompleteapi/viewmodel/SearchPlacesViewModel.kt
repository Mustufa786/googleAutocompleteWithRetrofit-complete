package com.codixlab.retrofitandplaceautocompleteapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceAutoCompleteResponse
import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceDetailsResponse
import com.codixlab.retrofitandplaceautocompleteapi.utils.InjectUtils
import com.codixlab.retrofitandplaceautocompleteapi.utils.ResponseStatusCallbacks
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * Created by Mustufa Ansari on 10/12/2020.
 * Email : mustufaayub82@gmail.com
 */
class SearchPlacesViewModel : ViewModel() {
    private val repository = InjectUtils.getGeneralRepository

    private var _autocompleteResult =
        MutableLiveData<ResponseStatusCallbacks<PlaceAutoCompleteResponse>>()
    val autocompleteResult: LiveData<ResponseStatusCallbacks<PlaceAutoCompleteResponse>>
        get() = _autocompleteResult

    private var _placeDetailsResponse =
        MutableLiveData<ResponseStatusCallbacks<PlaceDetailsResponse>>()
    val placeDetailsResponse: LiveData<ResponseStatusCallbacks<PlaceDetailsResponse>>
        get() = _placeDetailsResponse

    fun getPlacesFromAutocomplete(input: String) {
        _autocompleteResult.value = ResponseStatusCallbacks.loading(data = null)
        viewModelScope.launch {
            try {
                _autocompleteResult.value =
                    ResponseStatusCallbacks.success(repository.getAutocompletePlaces(input))
            } catch (e: Exception) {
                _autocompleteResult.value =
                    ResponseStatusCallbacks.error(data = null, message = "Something went wrong!")
            }
        }
    }


    fun getPlaceDetails(placeId: String) {
        _placeDetailsResponse.value = ResponseStatusCallbacks.loading(data = null)
        viewModelScope.launch {
            try {
                _placeDetailsResponse.value =
                    ResponseStatusCallbacks.success(repository.getPlaceDetails(placeId))
            } catch (e: Exception) {
                _placeDetailsResponse.value =
                    ResponseStatusCallbacks.error(data = null, message = "Something went wrong!")
            }
        }
    }
}