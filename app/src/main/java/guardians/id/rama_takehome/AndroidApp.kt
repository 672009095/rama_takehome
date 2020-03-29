package guardians.id.rama_takehome

import androidx.multidex.MultiDexApplication
import guardians.id.rama_takehome.data.module.apiModule
import guardians.id.rama_takehome.data.module.networkModule
import guardians.id.rama_takehome.data.module.repositoryDataModule
import guardians.id.rama_takehome.domain.module.useCaseModule
import guardians.id.rama_takehome.presentation.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class AndroidApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@AndroidApp)
            modules(
                listOf(
                    apiModule,
                    useCaseModule,
                    networkModule,
                    repositoryDataModule,
                    viewModelModule
                )
            )
        }
    }
}