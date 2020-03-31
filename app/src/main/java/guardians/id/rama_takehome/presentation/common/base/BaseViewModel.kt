package guardians.id.rama_takehome.presentation.common.base

import androidx.lifecycle.ViewModel
import guardians.id.rama_takehome.domain.common.entity.Either
import guardians.id.rama_takehome.presentation.common.ResultData
import org.koin.core.KoinComponent

/**
 * base for view model
 */
abstract class BaseViewModel : ViewModel(), KoinComponent {
    protected fun <T> Either<Throwable, T>.toResult() = when (this) {
        is Either.Error -> ResultData.Failure(this.error)
        is Either.Value -> ResultData.Success(this.value)
    }
}