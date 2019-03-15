package com.viiam.mvvp

import com.viiam.mvvp.database.PostDao
import com.viiam.mvvp.module.ContextModule
import com.viiam.mvvp.module.NetworkModule
import com.viiam.mvvp.viewmodel.PostReposity
import com.viiam.mvvp.viewmodel.SplashReposity
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface NemoInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */
    fun inject(postReposity: PostReposity)

    fun inject(splashReposity: SplashReposity)

    @Component.Builder
    interface Builder {
        fun build(): NemoInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder
    }
}