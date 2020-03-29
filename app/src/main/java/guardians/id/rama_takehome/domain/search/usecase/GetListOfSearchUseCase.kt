package guardians.id.rama_takehome.domain.search.usecase

import guardians.id.rama_takehome.domain.common.UseCaseConstant
import guardians.id.rama_takehome.domain.common.base.BaseUseCase
import guardians.id.rama_takehome.domain.search.Search
import guardians.id.rama_takehome.domain.search.SearchRepository

class GetListOfSearchUseCase(private val repository: SearchRepository) :
    BaseUseCase<List<Search>>(){

    override suspend fun build(params: Map<String, Any?>) = repository.getListOfSearch(
        params[UseCaseConstant.q] as String?
    )

}