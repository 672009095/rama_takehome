package guardians.id.rama_takehome.domain.common.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val image: String?,
    val image100x100: String?,
    val image400x300: String?,
    val image1024x768: String?
) : Parcelable