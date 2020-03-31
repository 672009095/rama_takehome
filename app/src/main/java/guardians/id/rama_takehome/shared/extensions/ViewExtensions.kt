package guardians.id.rama_takehome.shared.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import com.facebook.shimmer.ShimmerFrameLayout

fun ViewGroup.inflate(@LayoutRes resourceId: Int) =
    LayoutInflater.from(context).inflate(resourceId, this, false)
        ?: throw IllegalStateException("Failed to inflate resource")

fun ShimmerFrameLayout.onLoading(loading: Boolean) {
    isVisible = loading
    if (loading) startShimmer() else stopShimmer()
}