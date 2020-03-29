package guardians.id.rama_takehome.data.module

import android.os.Build
import com.google.gson.Gson
import com.readystatesoftware.chuck.ChuckInterceptor
import guardians.id.rama_takehome.BuildConfig
import guardians.id.rama_takehome.data.common.entity.RetrofitType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory {
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                val logInterceptor = HttpLoggingInterceptor()
                logInterceptor.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(logInterceptor)
            }
            addInterceptor(ChuckInterceptor(androidContext()))
        }
    }
    single { Gson() }

    factory {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            androidContext().resources.configuration.locales.get(0)
        } else {
            @Suppress("DEPRECATION")
            androidContext().resources.configuration.locale
        }
    }

    single(named(RetrofitType.DEFAULT.value)) {
        val okhttp = get<OkHttpClient.Builder>()
            .build()
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttp)
    }
}