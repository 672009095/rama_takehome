package guardians.id.rama_takehome.data.search.cloud.response

import com.google.gson.annotations.SerializedName

/**
 * define value return from data (response model)
 */
data class SearchResponse (
    @SerializedName("login") val login: String?,
    @SerializedName("id") val id: Long?,
    @SerializedName("avatar_url") val avatar_url: String?
)
