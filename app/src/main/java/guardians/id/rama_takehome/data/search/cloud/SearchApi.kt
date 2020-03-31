package guardians.id.rama_takehome.data.search.cloud

import guardians.id.rama_takehome.data.common.entity.ListDataResponse
import guardians.id.rama_takehome.data.search.cloud.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * interface for grouping endpoint based on per feature
 */
interface SearchApi {
    @GET("search/users")
    suspend fun getListOfSearch(
        @Query("q") q:String?
    ):ListDataResponse<SearchResponse>

    @GET("search/users")
    suspend fun getListOfSearchWithPage(
        @Query("q") q:String?,
        @Query("page") page : Int,
        @Query("per_page") per_page : Int
    ):ListDataResponse<SearchResponse>
}