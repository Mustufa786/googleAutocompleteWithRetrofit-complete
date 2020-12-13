package com.codixlab.retrofitandplaceautocompleteapi.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.codixlab.retrofitandplaceautocompleteapi.R
import com.codixlab.retrofitandplaceautocompleteapi.databinding.ActivityMainBinding
import com.codixlab.retrofitandplaceautocompleteapi.extension.obtainViewModel
import com.codixlab.retrofitandplaceautocompleteapi.listener.GenericListeners
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_main.*
import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.math.NumberUtils

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var mGoogleMap: GoogleMap
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mapView.onCreate(savedInstanceState)
        MapsInitializer.initialize(this)
        mapView.getMapAsync(this)


        binding.listener = object : GenericListeners {
            override fun onTapGoToPlacesScreen() {
                val intent = Intent(this@MainActivity, SearchPlacesActivity::class.java)
                startActivityForResult(intent, NumberUtils.INTEGER_ONE)
            }

        }
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let {
            mGoogleMap = map
            mGoogleMap.clear()
            formatMap()
        }
    }

    /**
     * animating camera on location
     * @param lat latitude of location
     * @param lng longitude of location
     * @param placeName animateCamera method is optional. You can use this method without providing place name
     */
    private fun animateCamera(lat: Double?, lng: Double?, placeName: String = StringUtils.EMPTY) {
        mGoogleMap.clear()
        mGoogleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    lat!!,
                    lng!!
                ), 15f
            )
        )
        val markerOption =
            MarkerOptions().apply {
                title(placeName)
                position(LatLng(lat, lng))
            }
        mGoogleMap.addMarker(markerOption)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
        }
    }

    /**
     * Set Google Map according to the required format.
     */
    private fun formatMap() {
        mGoogleMap.apply {
            isBuildingsEnabled = false
            uiSettings.isMapToolbarEnabled = false
            uiSettings.isMyLocationButtonEnabled = false
            uiSettings.isCompassEnabled = false
        }
    }

    override fun onResume() {
        if (mapView != null) mapView.onResume()
        super.onResume()
    }

    override fun onPause() {
        if (mapView != null) mapView.onPause()
        super.onPause()
    }

    override fun onStop() {
        if (mapView != null) mapView.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        if (mapView != null) mapView.onDestroy()
        super.onDestroy()
    }

}