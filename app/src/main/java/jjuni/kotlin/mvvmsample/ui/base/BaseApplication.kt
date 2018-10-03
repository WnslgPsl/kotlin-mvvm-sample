package jjuni.kotlin.mvvmsample.ui.base

import android.app.Application
import jjuni.kotlin.mvvmsample.util.appModules
import org.koin.android.ext.android.startKoin

/**
 * Created by Jo on 2018. 10. 3.
 */

class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, appModules)
    }
}