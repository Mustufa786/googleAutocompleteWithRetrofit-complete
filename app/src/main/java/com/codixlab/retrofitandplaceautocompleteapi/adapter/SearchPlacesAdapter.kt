package com.codixlab.retrofitandplaceautocompleteapi.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codixlab.retrofitandplaceautocompleteapi.models.PlaceAutoCompleteResponse
import com.codixlab.retrofitandplaceautocompleteapi.viewholder.SearchPlaceViewHolder

/**
 * Created by Mustufa Ansari on 10/12/2020.
 * Email : mustufaayub82@gmail.com
 */
class SearchPlacesAdapter(private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<SearchPlaceViewHolder>() {

    var items: ArrayList<PlaceAutoCompleteResponse.Prediction> = ArrayList()
        set(value) {
            field = value
            val diffCallback = SearchPlaceViewHolder.SearchPlaceDiffUtils(itemsFiltered, items)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            if (itemsFiltered.size > 0)
                itemsFiltered.clear()
            itemsFiltered.addAll(value)
            diffResult.dispatchUpdatesTo(this)
        }

    var itemsFiltered: ArrayList<PlaceAutoCompleteResponse.Prediction> = ArrayList()
        set(value) {
            field = value
            val diffCallback = SearchPlaceViewHolder.SearchPlaceDiffUtils(itemsFiltered, items)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            diffResult.dispatchUpdatesTo(this)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPlaceViewHolder {
        return SearchPlaceViewHolder.create(parent)
    }

    override fun getItemCount(): Int = itemsFiltered.size

    override fun onBindViewHolder(holder: SearchPlaceViewHolder, position: Int) {
        val item = itemsFiltered[position]
        if (item != null) {
            holder.bind(item)
            holder.itemView.setOnClickListener { clickListener.onItemClick(item) }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: PlaceAutoCompleteResponse.Prediction)
    }
}