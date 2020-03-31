package guardians.id.rama_takehome.presentation.search.list

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

class SearchListViewModel(
private val q:String?,
private val getListOfSearchUseCase: GetListOfSearchUseCase,
private val getListOfSearchWithPageUseCase: GetListOfSearchWithPageUseCase
) : BaseViewModel(){

    private val factory = PagedFactory(::getLisOfSearchWithPage)
    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(10)
        .setPageSize(10)
        .build()

    val searches = (LivePagedListBuilder(factory,pagedListConfig)).build()
    val searchesState: LiveData<PagedState> = factory.pagedState

    private suspend fun getLisOfSearchWithPage(page: Int?):
            Either<Throwable, List<Search>> {
        val params = mapOf(
            UseCaseConstant.q to q,
            UseCaseConstant.PAGINATION to Pagination(pagedListConfig.pageSize,page?:1)
        )
        return getListOfSearchWithPageUseCase.addParams(params)
            .invoke(viewModelScope.coroutineContext)
    }

    fun retryLoadAtLast() {
        val lastKey = searches.value?.lastKey as? Int ?: return
        searches.value?.loadAround(lastKey)
    }
}