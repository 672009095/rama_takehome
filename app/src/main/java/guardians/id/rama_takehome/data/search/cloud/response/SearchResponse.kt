package guardians.id.rama_takehome.data.search.cloud.response

import com.google.gson.annotations.SerializedName
import guardians.id.rama_takehome.data.common.entity.ImageResponse

data class SearchResponse (
    @SerializedName("login") val login: String?,
    @SerializedName("id") val id: Long?,
    @SerializedName("avatar_url") val avatar_url: String?
)
