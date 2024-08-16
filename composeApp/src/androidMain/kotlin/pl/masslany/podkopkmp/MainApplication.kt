package pl.masslany.podkopkmp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module
import pl.masslany.podkopkmp.di.AppModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(AppModule().module)
        }
    }
}