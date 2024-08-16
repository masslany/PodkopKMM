package pl.masslany.podkop.di

import org.koin.core.annotation.Module
import pl.masslany.auth.domain.di.AuthDomainModule

@Module(includes = [AuthDomainModule::class])
class AppModule