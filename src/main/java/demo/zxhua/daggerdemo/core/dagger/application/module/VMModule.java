package demo.zxhua.daggerdemo.core.dagger.application.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.zxhua.daggerdemo.core.dagger.application.ForApplication;
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.ViewModelFactory;

/**
 * Created by Zxhua on 2017/9/9 0009.
 */
@Module
public class VMModule {


    @Provides
    @Singleton
    @ForApplication
    public ViewModelFactory getViewModelFactory() {
        return ViewModelFactory.getInstance();
    }


    public interface Exposes {
        @ForApplication
        ViewModelFactory getViewModelFactory();

    }

}
