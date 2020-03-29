package guardians.id.rama_takehome.presentation.main

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import guardians.id.rama_takehome.R
import guardians.id.rama_takehome.presentation.common.base.BaseActivity
import guardians.id.rama_takehome.shared.extensions.startActivityClearTask
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    override val resourceLayout: Int? =
        R.layout.activity_main
    private val viewModel: MainActivityViewModel by viewModel()

    init {
        lifecycleScope.launchWhenStarted {
            viewModel.delayToNextScreen()
        }
    }

    override fun onInitObservers() {
        viewModel.nextClassToLaunch.observe(this, Observer {
            startActivityClearTask(Intent(this, it))
        })
    }
}
