package guardians.id.rama_takehome.data.search.cloud

import guardians.id.rama_takehome.data.common.entity.ListDataResponse
import guardians.id.rama_takehome.data.search.cloud.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("search/users")
    suspend fun getListOfSearch(
        @Query("q") q:String?
    ):ListDataResponse<SearchResponse>
}