package guardians.id.rama_takehome.data.module

import guardians.id.rama_takehome.BuildConfig
import guardians.id.rama_takehome.data.common.entity.RetrofitType
import guardians.id.rama_takehome.data.search.cloud.SearchApi
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * this file is for grouping call API builder to retrofit
 * can use type based on retrofit type (use token or not use token)
 */
val apiModule = module{
    single{
        get<Retrofit.Builder>(named(RetrofitType.DEFAULT.value))
            .baseUrl(BuildConfig.BASE_URL)
            .build()
            .create(SearchApi::class.java)
    }
}