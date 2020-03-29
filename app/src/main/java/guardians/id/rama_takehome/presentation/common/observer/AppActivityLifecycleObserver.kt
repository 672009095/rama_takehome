package guardians.id.rama_takehome.presentation.common.observer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import guardians.id.rama_takehome.presentation.common.ActivityLifecycle
import guardians.id.rama_takehome.presentation.common.FragmentLifecycle

class AppActivityLifecycleObserver (
    private val fragmentManager: FragmentManager,
    private val activityLifecycle: ActivityLifecycle
) : LifecycleObserver {

    private val fragmentLifecycleCallback =
        MyLifecycleCallbacks()

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        activityLifecycle.onInitViews()
        activityLifecycle.onInitObservers()
        fragmentManager.registerFragmentLifecycleCallbacks(fragmentLifecycleCallback, true)
    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        fragmentManager.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallback)
    }

    class MyLifecycleCallbacks : FragmentManager.FragmentLifecycleCallbacks() {
        override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
            super.onFragmentResumed(fm, f)
            if (f is FragmentLifecycle) f.onResumeNav()
        }

        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)
            if (f is FragmentLifecycle) f.onInitViews()
        }

        override fun onFragmentActivityCreated(
            fm: FragmentManager,
            f: Fragment,
            savedInstanceState: Bundle?
        ) {
            super.onFragmentActivityCreated(fm, f, savedInstanceState)
            if (f is FragmentLifecycle) f.onInitObservers()
        }
    }
}