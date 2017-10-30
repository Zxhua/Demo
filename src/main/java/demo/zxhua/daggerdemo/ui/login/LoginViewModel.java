package demo.zxhua.daggerdemo.ui.login;

import android.app.Application;

import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.DaggerViewModel;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public class LoginViewModel extends DaggerViewModel {
    public final LoginLiveData loginLiveData = new LoginLiveData();

    public LoginViewModel(Application application) {
        super(application);
    }


    public void login(String username, String pwd) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.username = username;
        loginEntity.pwd = pwd;

        loginLiveData.postValue(loginEntity);
    }
}
