package guardians.id.rama_takehome.domain.module

import guardians.id.rama_takehome.domain.search.usecase.GetListOfSearchUseCase
import guardians.id.rama_takehome.domain.search.usecase.GetListOfSearchWithPageUseCase
import org.koin.dsl.module
import org.koin.experimental.builder.factory

/**
 * modul for grouping use case
 */
val useCaseModule = module {
    factory<GetListOfSearchUseCase>()
    factory<GetListOfSearchWithPageUseCase>()
}