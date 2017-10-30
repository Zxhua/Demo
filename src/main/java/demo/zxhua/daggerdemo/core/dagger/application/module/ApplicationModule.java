package demo.zxhua.daggerdemo.core.dagger.application.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.zxhua.daggerdemo.core.dagger.application.DaggerApplication;
import demo.zxhua.daggerdemo.core.dagger.application.ForApplication;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Module
public final class ApplicationModule {
    private final DaggerApplication daggerApplication;

    public ApplicationModule(final DaggerApplication daggerApplication) {
        this.daggerApplication = daggerApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return daggerApplication;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideContext() {
        return daggerApplication;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return provideApplication().getResources();
    }

    public interface Exposes {

        Application provideApplication();

        @ForApplication
        Context provideContext();

        Resources provideResources();
    }

}
