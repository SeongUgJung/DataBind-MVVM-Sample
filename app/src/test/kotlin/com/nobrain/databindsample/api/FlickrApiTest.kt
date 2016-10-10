package com.nobrain.databindsample.api

import dagger.Component
import io.reactivex.observers.TestObserver
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class FlickrApiTest {

    @Inject @JvmField
    var api: FlickrApi? = null

    @Before
    fun setUp() {
        DaggerFlickrApiTest_TestComponent.create().inject(this)

    }

    @Test
    fun getRecentPhoto() {
        val testObserver = TestObserver.create<RecentPhoto>()
        api?.getRecentPhoto(1, 20)?.subscribe(testObserver)

        testObserver.awaitTerminalEvent()

        testObserver.assertValueCount(1)

        val recentPhoto = testObserver.values().get(0)

        assertThat(recentPhoto.photos()).isNotNull()
        assertThat(recentPhoto.photos().page()).isEqualTo(1)
        assertThat(recentPhoto.photos().perpage()).isEqualTo(20)
        assertThat(recentPhoto.photos().pages()).isGreaterThanOrEqualTo(1)
        assertThat(recentPhoto.photos().photo().size).isLessThanOrEqualTo(20)


    }

    @Component(modules = arrayOf(ApiModule::class))
    interface TestComponent {
        fun inject(test: FlickrApiTest)
    }
}