package guardians.id.rama_takehome.domain.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * model domain used for implemeent into view (interface)
 * based on data mapper on data module
 */
@Parcelize
data class Search (
    val login: String,
    val id: Long,
    val avatar_url: String
):Parcelable