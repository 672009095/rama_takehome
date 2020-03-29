package guardians.id.rama_takehome.presentation.common

import guardians.id.rama_takehome.presentation.common.base.BaseViewModel

interface PresentationVM<VM : BaseViewModel> {
    val viewModel: VM
}