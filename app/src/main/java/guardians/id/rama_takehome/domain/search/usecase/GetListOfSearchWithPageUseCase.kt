package guardians.id.rama_takehome.domain.search.usecase

import guardians.id.rama_takehome.domain.common.UseCaseConstant
import guardians.id.rama_takehome.domain.common.base.BaseUseCase
import guardians.id.rama_takehome.domain.common.entity.Pagination
import guardians.id.rama_takehome.domain.search.Search
import guardians.id.rama_takehome.domain.search.SearchRepository

/**
 * use case with pagination
 */
class GetListOfSearchWithPageUseCase(private val repository: SearchRepository) :
    BaseUseCase<List<Search>>(){

    override suspend fun build(params: Map<String, Any?>) = repository.getListOfSearchWithPage(
        params[UseCaseConstant.q] as String?,
        params[UseCaseConstant.PAGINATION] as Pagination
    )

}