package demo.zxhua.daggerdemo.ui.refreshedit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseActivity;
import demo.zxhua.daggerdemo.core.dagger.activity.ActivityComponent;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

/**
 * Created by Zxhua on 2017/9/22 0022.
 */

public class EditRefreshActivity extends BaseActivity {
    @Inject
    ActivityUtils activityUtils;
    @Inject
    FragmentManager fragmentManager;

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUtils.addFragmentToActivity(fragmentManager, new EditRefreshFragment(), R.id.fragmentLayout);
    }
}


