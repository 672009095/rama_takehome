package guardians.id.rama_takehome.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import guardians.id.rama_takehome.domain.common.UseCaseConstant
import guardians.id.rama_takehome.domain.common.entity.Either
import guardians.id.rama_takehome.domain.common.entity.Pagination
import guardians.id.rama_takehome.domain.search.Search
import guardians.id.rama_takehome.domain.search.usecase.GetListOfSearchUseCase
import guardians.id.rama_takehome.domain.search.usecase.GetListOfSearchWithPageUseCase
import guardians.id.rama_takehome.presentation.common.ResultData
import guardians.id.rama_takehome.presentation.common.base.BaseViewModel
import guardians.id.rama_takehome.presentation.common.widget.paged.PagedFactory
import guardians.id.rama_takehome.presentation.common.widget.paged.PagedState

class SearchActivityViewModel(
    private val q:String?,
    private val getListOfSearchUseCase: GetListOfSearchUseCase,
    private val getListOfSearchWithPageUseCase: GetListOfSearchWithPageUseCase
) : BaseViewModel(){

    private val itemsMutable = MutableLiveData<ResultData<List<Search>>>()
    val items: LiveData<ResultData<List<Search>>> = itemsMutable

    private val factory = PagedFactory(::getLisOfSearchWithPage)
    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(1)
        .setPageSize(10)
        .build()

    val searches = (LivePagedListBuilder(factory,pagedListConfig)).build()
    val searchesState: LiveData<PagedState> = factory.pagedState

    suspend fun getListOfSearch(q: String?){
        val params = mapOf(
            UseCaseConstant.q to q
        )
        getListOfSearchUseCase.addParams(params)
            .invoke()
            .toResult()
            .run(itemsMutable::postValue)
    }

    suspend fun getLisOfSearchWithPage(page: Int?):
        Either<Throwable, List<Search>>{
        val params = mapOf(
            UseCaseConstant.q to "pikachu",
            UseCaseConstant.PAGINATION to Pagination(10,page?:1)
        )
        return getListOfSearchWithPageUseCase.addParams(params)
            .invoke(viewModelScope.coroutineContext)
    }
}