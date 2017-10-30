package demo.zxhua.daggerdemo.ui.entity;

import android.arch.lifecycle.LiveData;
import android.support.annotation.Nullable;

/**
 * Created by Zxhua on 2017/9/20 0020.
 */

public class BaseLiveData<T> extends LiveData<T> {

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }

    @Override
    protected void postValue(T value) {
        super.postValue(value);
    }

    @Nullable
    @Override
    public T getValue() {
        return super.getValue();
    }


}
