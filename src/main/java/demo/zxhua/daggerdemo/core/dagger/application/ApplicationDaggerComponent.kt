package demo.zxhua.daggerdemo.core.dagger.application

import dagger.Component
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * Created by Zxhua on 2017/10/30 0030.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
annotation class ForApplication

interface ApplicationComponentInject {

    fun inject(daggerApplication: DaggerApplication)
}

interface ApplicationComponentExposes : ApplicationModule.Exposes, VMModule.Exposes, UtilsModule.Exposes

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, VMModule::class, UtilsModule::class))
interface ApplicationComponent : ApplicationComponentInject, ApplicationModule.Exposes, VMModule.Exposes, UtilsModule.Exposes {
    object Initializer {
        @JvmStatic
        fun init(daggerApplication: DaggerApplication): ApplicationComponent? {
//            return DaggerApplicationComponent.builder()
//                    .applicationModule(ApplicationModule(daggerApplication))
//                    .vMModule(VMModule())
//                    .utilsModule(UtilsModule())
//                    .build()
            return null
        }

    }

}