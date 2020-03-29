package guardians.id.rama_takehome.presentation.common

sealed class ResultData<out T> {
    object Loading : ResultData<Nothing>()
    data class Success<out T>(val data: T) : ResultData<T>()
    data class Failure(val error: Throwable) : ResultData<Nothing>()
}

fun <T> ResultData<T>.isLoading() = this is ResultData.Loading