package guardians.id.rama_takehome.presentation.common.widget.paged

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import guardians.id.rama_takehome.domain.common.entity.Either

class PagedFactory<T>(
    private val onRequest: suspend (Int?) -> Either<Throwable, List<T>>
) : DataSource.Factory<Int, T>() {

    private val pagedStateMutable = MutableLiveData<PagedState>()
    val pagedState: LiveData<PagedState> = pagedStateMutable

    override fun create() = PagedDataSource {
        val isInitial = it == null
        pagedStateMutable.postValue(PagedState.Loading(isInitial))
        handleRequest(isInitial, onRequest(it))
    }

    private fun handleRequest(isInitial: Boolean, data: Either<Throwable, List<T>>) = when (data) {
        is Either.Value -> {
            pagedStateMutable.postValue(PagedState.Success(isInitial))
            data.value
        }
        is Either.Error -> {
            pagedStateMutable.postValue(PagedState.Failure(isInitial, data.error))
            emptyList()
        }
    }
}
