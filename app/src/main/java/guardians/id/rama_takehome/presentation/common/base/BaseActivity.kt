package guardians.id.rama_takehome.presentation.common.base

import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import guardians.id.rama_takehome.presentation.common.ActivityLifecycle
import guardians.id.rama_takehome.presentation.common.observer.AppActivityLifecycleObserver

/**
 * reusable base for activity
 */
abstract class BaseActivity : AppCompatActivity(),
    ActivityLifecycle {
    abstract val resourceLayout: Int?

    private var onPermissionGranted: (() -> Unit)? = null
    private var onSettingsAccepted: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resourceLayout?.run(this::setContentView)
        lifecycle.addObserver(
            AppActivityLifecycleObserver(
                supportFragmentManager,
                this
            )
        )
    }
    override fun onInitViews() {}

    override fun onInitObservers() {}

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
}