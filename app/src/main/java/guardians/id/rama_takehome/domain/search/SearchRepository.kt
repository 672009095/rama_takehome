package guardians.id.rama_takehome.domain.search

import guardians.id.rama_takehome.domain.common.entity.Pagination

interface SearchRepository {
    suspend fun getListOfSearch(q: String?): List<Search>
    suspend fun getListOfSearchWithPage(q: String?, pagination: Pagination): List<Search>
}