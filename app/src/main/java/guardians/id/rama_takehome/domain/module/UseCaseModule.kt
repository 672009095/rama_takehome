package guardians.id.rama_takehome.domain.module

import guardians.id.rama_takehome.domain.search.usecase.GetListOfSearchUseCase
import org.koin.dsl.module
import org.koin.experimental.builder.factory

val useCaseModule = module {
    factory<GetListOfSearchUseCase>()
}