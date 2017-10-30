package demo.zxhua.daggerdemo.core.dagger.activity;

import demo.zxhua.daggerdemo.ui.login.LoginActivity;
import demo.zxhua.daggerdemo.ui.refreshedit.EditRefreshActivity;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */

public interface ActivityComponentInject {

    void inject(LoginActivity loginActivity);

    void inject(EditRefreshActivity editRefreshActivity);
}
