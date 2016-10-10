package com.nobrain.databindsample.api

import android.support.annotation.Nullable
import com.google.auto.value.AutoValue
import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory


@AutoValue
abstract class RecentPhoto {

    @Nullable
    abstract fun photos(): Photos

    companion object {

        @JvmStatic fun typeAdapter(gson: Gson): TypeAdapter<RecentPhoto> {
            return AutoValue_RecentPhoto.GsonTypeAdapter(gson)
        }
    }
}

@AutoValue
abstract class Photos {

    abstract fun page(): Int

    abstract fun pages(): Int

    abstract fun perpage(): Int

    abstract fun total(): Int

    @Nullable
    abstract fun photo(): List<FlickrPhoto>

    companion object {
        @JvmStatic fun typeAdapter(gson: Gson): TypeAdapter<Photos> {
            return AutoValue_Photos.GsonTypeAdapter(gson)
        }
    }
}

@AutoValue
abstract class FlickrPhoto {


    abstract fun id(): String

    @Nullable
    abstract fun owner(): String

    @Nullable
    abstract fun secret(): String

    @Nullable
    abstract fun server(): String

    abstract fun farm(): Long

    @Nullable
    abstract fun title(): String

    abstract fun ispublic(): Long

    abstract fun isfriend(): Long

    abstract fun isfamily(): Long

    companion object {
        @JvmStatic
        fun typeAdapter(gson: Gson): TypeAdapter<FlickrPhoto> {
            return AutoValue_FlickrPhoto.GsonTypeAdapter(gson)
        }
    }
}


@GsonTypeAdapterFactory
abstract class MyAdapterFactory : TypeAdapterFactory {
    companion object {
        @JvmStatic
        fun create(): TypeAdapterFactory {
            return AutoValueGson_MyAdapterFactory()
        }
    }

}