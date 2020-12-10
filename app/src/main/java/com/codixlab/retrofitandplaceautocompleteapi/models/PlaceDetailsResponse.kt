package com.codixlab.retrofitandplaceautocompleteapi.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class PlaceDetailsResponse {
    @SerializedName("html_attributions")
    @Expose
    val htmlAttributions: List<Any>? = null

    @SerializedName("result")
    @Expose
    val result: Result? = null

    @SerializedName("status")
    @Expose
    val status: String? = null

    class Geometry {
        @SerializedName("location")
        @Expose
        var location: Location? = null

        @SerializedName("viewport")
        @Expose
        var viewport: Viewport? = null

    }

    class AddressComponent {
        @SerializedName("long_name")
        @Expose
        var longName: String? = null

        @SerializedName("short_name")
        @Expose
        var shortName: String? = null

        @SerializedName("types")
        @Expose
        var types: List<String>? = null

    }

    class Location {
        @SerializedName("lat")
        @Expose
        var lat: Double? = null

        @SerializedName("lng")
        @Expose
        var lng: Double? = null

    }

    class Northeast {
        @SerializedName("lat")
        @Expose
        var lat: Double? = null

        @SerializedName("lng")
        @Expose
        var lng: Double? = null

    }

    class Result {
        @SerializedName("address_components")
        @Expose
        var addressComponents: List<AddressComponent>? = null

        @SerializedName("adr_address")
        @Expose
        var adrAddress: String? = null

        @SerializedName("formatted_address")
        @Expose
        var formattedAddress: String? = null

        @SerializedName("formatted_phone_number")
        @Expose
        var formattedPhoneNumber: String? = null

        @SerializedName("geometry")
        @Expose
        var geometry: Geometry? = null

        @SerializedName("icon")
        @Expose
        var icon: String? = null

        @SerializedName("id")
        @Expose
        var id: String? = null

        @SerializedName("international_phone_number")
        @Expose
        var internationalPhoneNumber: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("place_id")
        @Expose
        var placeId: String? = null

        @SerializedName("rating")
        @Expose
        var rating: Double? = null

        @SerializedName("reference")
        @Expose
        var reference: String? = null

        @SerializedName("reviews")
        @Expose
        var reviews: List<Review>? = null

        @SerializedName("types")
        @Expose
        var types: List<String>? = null

        @SerializedName("url")
        @Expose
        var url: String? = null

        @SerializedName("utc_offset")
        @Expose
        var utcOffset: Int? = null

        @SerializedName("vicinity")
        @Expose
        var vicinity: String? = null

        @SerializedName("website")
        @Expose
        var website: String? = null

    }

    class Review {
        @SerializedName("author_name")
        @Expose
        var authorName: String? = null

        @SerializedName("author_url")
        @Expose
        var authorUrl: String? = null

        @SerializedName("language")
        @Expose
        var language: String? = null

        @SerializedName("profile_photo_url")
        @Expose
        var profilePhotoUrl: String? = null

        @SerializedName("rating")
        @Expose
        var rating: Int? = null

        @SerializedName("relative_time_description")
        @Expose
        var relativeTimeDescription: String? = null

        @SerializedName("text")
        @Expose
        var text: String? = null

        @SerializedName("time")
        @Expose
        var time: Int? = null

    }

    class Southwest {
        @SerializedName("lat")
        @Expose
        var lat: Double? = null

        @SerializedName("lng")
        @Expose
        var lng: Double? = null

    }

    class Viewport {
        @SerializedName("northeast")
        @Expose
        var northeast: Northeast? = null

        @SerializedName("southwest")
        @Expose
        var southwest: Southwest? = null

    }
}