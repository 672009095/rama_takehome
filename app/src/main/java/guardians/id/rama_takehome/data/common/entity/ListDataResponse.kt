package guardians.id.rama_takehome.data.common.entity

import com.google.gson.annotations.SerializedName

/**
 *
 * this class is for base return data from list type json
 */
data class ListDataResponse <T>(
    @SerializedName("items") val items: List<T>?
){
    fun getOrThrow() = items ?: throw NoSuchElementException("Require value items")
}
