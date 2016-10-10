package com.nobrain.databindsample

import com.nobrain.databindsample.api.ApiModule
import dagger.Component


@Component(modules = arrayOf(ApiModule::class))
interface MainComponent {
    fun inject(target: MainActivity)
}
