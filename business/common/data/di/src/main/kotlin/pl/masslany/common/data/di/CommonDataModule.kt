package pl.masslany.common.data.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import pl.masslany.business.common.data.main.mapper.GenderMapper
import pl.masslany.business.common.data.main.mapper.GenderMapperImpl
import pl.masslany.business.common.data.main.mapper.NameColorMapper
import pl.masslany.business.common.data.main.mapper.NameColorMapperImpl
import pl.masslany.business.common.data.main.mapper.ResourceMapper
import pl.masslany.business.common.data.main.mapper.ResourceMapperImpl

@Module
@ComponentScan
object CommonDataModule {

    @Factory
    fun genderMapper(): GenderMapper {
        return GenderMapperImpl()
    }

    @Factory
    fun nameColorMapper(): NameColorMapper {
        return NameColorMapperImpl()
    }

    @Factory
    fun resourceMapper(): ResourceMapper {
        return ResourceMapperImpl()
    }
}
