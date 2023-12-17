package fardev.vergil.giftwisp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class GiftWispApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if(BuildConfig.DEBUG) {
            println("Planting Debug Tree")
            Timber.plant(Timber.DebugTree())
        }
    }
}