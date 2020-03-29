package guardians.id.rama_takehome.presentation.common.widget.paged

sealed class PagedState(open val isInitial: Boolean) {
    data class Loading(override val isInitial: Boolean) : PagedState(isInitial)
    data class Success(override val isInitial: Boolean) : PagedState(isInitial)
    data class Failure(
        override val isInitial: Boolean,
        val error: Throwable
    ) : PagedState(isInitial)
}