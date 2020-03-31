package guardians.id.rama_takehome.data.search

import guardians.id.rama_takehome.data.search.cloud.response.SearchResponse
import guardians.id.rama_takehome.domain.search.Search

/**
 * transform mapper u can sorting wich u wont to use from response model
 * and use the only what u want to use
 */
fun transform (value: SearchResponse) = Search(
    value.login ?:throw NoSuchElementException("Require value login"),
    value.id ?:throw NoSuchElementException("Require value id"),
    value.avatar_url ?:throw NoSuchElementException("Require value avatar_url")
)