package guardians.id.rama_takehome.data.common.entity

import com.google.gson.annotations.SerializedName

data class SingleDataResponse <T>(
    @SerializedName("items") val items: T?
) {
    fun getOrThrow() = items ?: throw NoSuchElementException("Require value itemes")
}