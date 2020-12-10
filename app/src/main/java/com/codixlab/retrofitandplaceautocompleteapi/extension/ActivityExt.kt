package com.codixlab.retrofitandplaceautocompleteapi.extension

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.codixlab.retrofitandplaceautocompleteapi.factory.ViewModelFactory

/**
 * created by Mustufa Ansari on 18,August,2020
 * Email : mustufaayub82@gmail.com
 */

fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>) =
    ViewModelProviders.of(this, ViewModelFactory.getInstance()).get(viewModelClass)

fun <T : AppCompatActivity> AppCompatActivity.gotoActivity(targetActivityClass: Class<T>) {
    val intent = Intent(this, targetActivityClass)
    startActivity(intent)
}

fun AppCompatActivity.gotoActivityWithNoHistory(targetActivityClass: Class<*>) {
    val i = Intent(this, targetActivityClass)
    i.flags =
        Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    startActivity(i)
}