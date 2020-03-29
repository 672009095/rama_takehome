package guardians.id.rama_takehome.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import guardians.id.rama_takehome.presentation.common.base.BaseViewModel
import guardians.id.rama_takehome.presentation.search.SearchActivity
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

class MainActivityViewModel: BaseViewModel() {
    private val nextClassToLaunchMutable = MutableLiveData<Class<*>>()
    val nextClassToLaunch: LiveData<Class<*>> = nextClassToLaunchMutable

    suspend fun delayToNextScreen() {
        delay(TimeUnit.SECONDS.toMillis(1))
        toSearchPage()
    }

    private suspend fun toSearchPage() {
        nextClassToLaunchMutable.postValue(SearchActivity::class.java)
    }
}