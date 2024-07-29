package br.com.app.test

import android.app.Application
import br.com.core.router.ui.Router
import br.com.core.router.ui.RouterImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class AppTest : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppTest)
            module {
                factory { RouterImpl() } bind Router::class
            }
        }
    }
}