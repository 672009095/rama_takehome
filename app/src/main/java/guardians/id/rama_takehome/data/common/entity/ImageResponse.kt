package guardians.id.rama_takehome.data.common.entity


import com.google.gson.annotations.SerializedName
import guardians.id.rama_takehome.domain.common.entity.Image

data class ImageResponse(
    @SerializedName("default") val default: String?,
    @SerializedName("low_res") val low: String?,
    @SerializedName("medium_res") val medium: String?,
    @SerializedName("high_res") val high: String?
)

fun toImage(value: ImageResponse) = Image(
    value.default,
    value.low,
    value.medium,
    value.high
)