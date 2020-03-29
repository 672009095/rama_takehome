package guardians.id.rama_takehome.data.module

import guardians.id.rama_takehome.data.search.SearchDataRepository
import guardians.id.rama_takehome.domain.search.SearchRepository
import org.koin.dsl.module
import org.koin.experimental.builder.factoryBy

val repositoryDataModule = module {
    factoryBy<SearchRepository,SearchDataRepository>()
}