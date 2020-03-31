package guardians.id.rama_takehome.domain.common.base

import guardians.id.rama_takehome.domain.common.entity.either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * reusable base use case
 */
abstract class BaseUseCase <Entity> {
    private var params: Map<String, Any?> = emptyMap()

    abstract suspend fun build(params: Map<String, Any?> = emptyMap()): Entity

    fun addParams(params: Map<String, Any?>) = apply {
        this.params = params
    }

    suspend fun invoke(context: CoroutineContext = Dispatchers.IO) = withContext(context) {
        either { build(params) }
    }
}