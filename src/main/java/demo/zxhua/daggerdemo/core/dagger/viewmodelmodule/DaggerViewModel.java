package demo.zxhua.daggerdemo.core.dagger.viewmodelmodule;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Zxhua on 2017/9/8 0008.
 */

public class DaggerViewModel extends AndroidViewModel implements ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public DaggerViewModel(Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }


}
