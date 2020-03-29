package guardians.id.rama_takehome.presentation.module

import guardians.id.rama_takehome.domain.common.UseCaseConstant.q
import guardians.id.rama_takehome.presentation.main.MainActivityViewModel
import guardians.id.rama_takehome.presentation.search.SearchActivityViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<MainActivityViewModel>()
    //viewModel<SearchActivityViewModel>()
    viewModel{(q:String) -> SearchActivityViewModel(q,get())}
}