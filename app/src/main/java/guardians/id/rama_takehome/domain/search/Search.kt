package guardians.id.rama_takehome.domain.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Search (
    val login: String,
    val id: Long,
    val avatar_url: String
):Parcelable