package demo.zxhua.daggerdemo.ui.login;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import java.util.List;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseActivity;
import demo.zxhua.daggerdemo.core.dagger.activity.ActivityComponent;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

public class LoginActivity extends BaseActivity {
    @Inject
    FragmentManager fragmentManager;

    @Inject
    ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUtils.addFragmentToActivity(fragmentManager,new LoginFragment(),R.id.fragmentLayout);
        List<PackageInfo> installedPackages = getPackageManager().getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
