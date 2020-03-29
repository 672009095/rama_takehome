package guardians.id.rama_takehome.domain.search

interface SearchRepository {
    suspend fun getListOfSearch(q: String?): List<Search>
}