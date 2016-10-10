package com.nobrain.databindsample.viewmodel

import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.view.View
import android.widget.ImageView
import com.nobrain.databindsample.api.FlickrApi
import com.nobrain.databindsample.api.FlickrPhoto
import com.nobrain.databindsample.api.RecentPhoto
import com.squareup.picasso.Picasso
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel @Inject constructor(private val api: FlickrApi) {

    var recentPhoto: ObservableField<RecentPhoto> = ObservableField()

    fun loadPhotos(view: View) {
        api.getRecentPhoto(1, 20)
                .subscribeOn(Schedulers.io())
                .subscribe({ recentPhoto.set(it) },
                        { it -> it.printStackTrace() })
    }

    companion object {
        @JvmStatic
        @BindingAdapter("app:bind")
        fun bindImage(view: ImageView, x: FlickrPhoto?) {

            x?.apply {
                Picasso.with(view.context).load("https://farm${farm()}.staticflickr.com/${server()}/${id()}_${secret()}.jpg").into(view)
            }
        }
    }

}