package demo.zxhua.daggerdemo.core.dagger.application

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.ViewModelFactory
import demo.zxhua.daggerdemo.utils.ActivityUtils
import demo.zxhua.daggerdemo.utils.ActivityUtilsImpl
import demo.zxhua.daggerdemo.utils.TransformUtils
import demo.zxhua.daggerdemo.utils.TransformUtilsImpl
import javax.inject.Singleton

/**
 * Created by Zxhua on 2017/10/30 0030.
 */
@Module
class ApplicationModule(private val daggerApplication: DaggerApplication) {

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return daggerApplication
    }

    @Provides
    @Singleton
    @ForApplication
    internal fun provideContext(): Context {
        return daggerApplication
    }

    @Provides
    @Singleton
    internal fun provideResources(): Resources {
        return provideApplication().resources
    }

    interface Exposes {

        fun provideApplication(): Application

        @ForApplication
        fun provideContext(): Context

        fun provideResources(): Resources
    }

}

@Module
class UtilsModule {
    @Provides
    @Singleton
    internal fun provideActivityUtils(): ActivityUtils {
        return ActivityUtilsImpl()
    }

    @Provides
    @Singleton
    internal fun provideTransformUtils(): TransformUtils {
        return TransformUtilsImpl()
    }

    interface Exposes {
        fun provideActivityUtils(): ActivityUtils

        fun provideTransformUtils(): TransformUtils

    }
}

@Module
class VMModule {


    val viewModelFactory: ViewModelFactory
        @Provides
        @Singleton
        @ForApplication
        get() = ViewModelFactory.getInstance()


    interface Exposes {
        @get:ForApplication
        val viewModelFactory: ViewModelFactory

    }

}
