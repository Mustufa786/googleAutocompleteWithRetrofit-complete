package com.codixlab.retrofitandplaceautocompleteapi.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import com.codixlab.retrofitandplaceautocompleteapi.R
import com.codixlab.retrofitandplaceautocompleteapi.adapter.SearchPlacesAdapter
import com.codixlab.retrofitandplaceautocompleteapi.extension.obtainViewModel
import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceAutoCompleteResponse
import com.codixlab.retrofitandplaceautocompleteapi.utils.ResponseStatus
import com.codixlab.retrofitandplaceautocompleteapi.viewmodel.SearchPlacesViewModel
import kotlinx.android.synthetic.main.activity_search_places.*

class SearchPlacesActivity : AppCompatActivity() {

    lateinit var viewModel: SearchPlacesViewModel
    lateinit var adapter: SearchPlacesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_places)
        viewModel = obtainViewModel(SearchPlacesViewModel::class.java)

        setupRecyclerView()


        viewModel.autocompleteResult.observe(this, Observer {
            it?.let {
                when (it.status) {
                    ResponseStatus.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        placesList.visibility = View.VISIBLE
                        adapter.items =
                            it.data?.predictions as ArrayList<PlaceAutoCompleteResponse.Prediction>
                    }
                    ResponseStatus.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                    ResponseStatus.ERROR -> {
                        progressBar.visibility = View.GONE
                    }
                }
            }
        })

        searchPlacesEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().length > 3) {
                    viewModel.getPlacesFromAutocomplete(s.toString())
                } else {
                    placesList.visibility = View.GONE
                }
            }
        })
    }

    private fun setupRecyclerView() {
        adapter = SearchPlacesAdapter(object : SearchPlacesAdapter.OnItemClickListener {
            override fun onItemClick(item: PlaceAutoCompleteResponse.Prediction) {
                val intent = Intent()
                intent.putExtra("placeId", item.placeId)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        })
        placesList.adapter = adapter
    }
}