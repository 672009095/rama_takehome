package guardians.id.rama_takehome.data.common.entity

import com.google.gson.annotations.SerializedName

/**
 * this class is Base for return single data or items from json
 */
data class SingleDataResponse <T>(
    @SerializedName("items") val items: T?
) {
    fun getOrThrow() = items ?: throw NoSuchElementException("Require value itemes")
}