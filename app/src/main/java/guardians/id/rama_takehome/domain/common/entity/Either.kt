package guardians.id.rama_takehome.domain.common.entity

import guardians.id.rama_takehome.BuildConfig

sealed class Either<out E, out V> {
    data class Error<out E>(val error: E) : Either<E, Nothing>()
    data class Value<out V>(val value: V) : Either<Nothing, V>()
}

suspend fun <V> either(block: suspend () -> V): Either<Throwable, V> = runCatching {
    Either.Value(block())
}.getOrElse {
    if (BuildConfig.DEBUG) {
        it.printStackTrace()
    }
    Either.Error(it)
}

fun <T> Either<Throwable, T>.getOrNull() = this.takeIf { it.isSuccess() }
    ?.let { it as Either.Value }
    ?.value

fun <T> Either<Throwable, T>.getOrThrow() = when (this) {
    is Either.Value -> this.value
    is Either.Error -> throw this.error
}

fun <T> Either<Throwable, T>.isSuccess() = this is Either.Value

fun <T> Either<Throwable, T>.onSuccess(onSuccess: (T) -> Unit) = apply {
    if (this is Either.Value) onSuccess(this.value)
}

fun <T> Either<Throwable, T>.onFailure(onFailure: (Throwable) -> Unit) = apply {
    if (this is Either.Error) onFailure(this.error)
}