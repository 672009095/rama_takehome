package guardians.id.rama_takehome.data.search

import guardians.id.rama_takehome.data.search.cloud.SearchApi
import guardians.id.rama_takehome.domain.common.entity.Pagination
import guardians.id.rama_takehome.domain.search.Search
import guardians.id.rama_takehome.domain.search.SearchRepository

class SearchDataRepository (private val searchApi: SearchApi) : SearchRepository {
    override suspend fun getListOfSearch(q:String?): List<Search> =
        searchApi.getListOfSearch(q).getOrThrow().map(::transform)

    override suspend fun getListOfSearchWithPage(
        q:String?,
        pagination: Pagination
    ):List<Search> = searchApi.getListOfSearchWithPage(
        q,
        pagination.page,
        pagination.per_page).getOrThrow().map (::transform)
}