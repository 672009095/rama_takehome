package guardians.id.rama_takehome.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import guardians.id.rama_takehome.domain.common.UseCaseConstant
import guardians.id.rama_takehome.domain.common.entity.Either
import guardians.id.rama_takehome.domain.search.Search
import guardians.id.rama_takehome.domain.search.usecase.GetListOfSearchUseCase
import guardians.id.rama_takehome.presentation.common.ResultData
import guardians.id.rama_takehome.presentation.common.base.BaseViewModel
import guardians.id.rama_takehome.presentation.common.widget.paged.PagedFactory
import guardians.id.rama_takehome.presentation.common.widget.paged.PagedState

class SearchActivityViewModel(
    private val q:String?,
    private val getListOfSearchUseCase: GetListOfSearchUseCase
) : BaseViewModel(){

    private val itemsMutable = MutableLiveData<ResultData<List<Search>>>()
    val items: LiveData<ResultData<List<Search>>> = itemsMutable

    suspend fun getListOfSearch(q: String?){
        val params = mapOf(
            UseCaseConstant.q to q
        )
        getListOfSearchUseCase.addParams(params)
            .invoke()
            .toResult()
            .run(itemsMutable::postValue)
    }
}