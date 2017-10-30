package demo.zxhua.daggerdemo.core.dagger.viewmodelmodule;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.core.dagger.application.DaggerApplication;
import demo.zxhua.daggerdemo.ui.login.LoginViewModel;
import demo.zxhua.daggerdemo.ui.refreshedit.RefreshEditViewModel;

/**
 * Created by Zxhua on 2017/9/8 0008.
 */
public class ViewModelFactory implements ViewModelProvider.Factory {
    private static ViewModelFactory INSTANCE;

    @Inject
    public DaggerApplication daggerApplication;
    @Inject
    public Context context;

    public static ViewModelFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ViewModelFactory();
        }
        return INSTANCE;
    }

    private ViewModelFactory() {
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(daggerApplication);
        }
        if (modelClass.isAssignableFrom(RefreshEditViewModel.class)) {
            return (T) new RefreshEditViewModel(daggerApplication);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
