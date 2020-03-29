package guardians.id.rama_takehome.shared.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes resourceId: Int) =
    LayoutInflater.from(context).inflate(resourceId, this, false)
        ?: throw IllegalStateException("Failed to inflate resource")