package demo.zxhua.daggerdemo.core.dagger.fragment;

import demo.zxhua.daggerdemo.ui.login.LoginFragment;
import demo.zxhua.daggerdemo.ui.refreshedit.EditRefreshFragment;

/**
 * Created by Zxhua on 2017/9/8 0008.
 */

public interface FragmentComponentInject {
    void inject(LoginFragment loginFragment);

    void inject(EditRefreshFragment editRefreshFragment);

}
