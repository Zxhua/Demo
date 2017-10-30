package demo.zxhua.daggerdemo.ui.login;

import android.arch.lifecycle.LiveData;
import android.support.annotation.Nullable;

/**
 * Created by Zxhua on 2017/9/14 0014.
 */

public class LoginLiveData extends LiveData<LoginEntity>{
    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }

    @Override
    protected void postValue(LoginEntity value) {
        super.postValue(value);
    }

    @Nullable
    @Override
    public LoginEntity getValue() {
        return super.getValue();
    }
}
