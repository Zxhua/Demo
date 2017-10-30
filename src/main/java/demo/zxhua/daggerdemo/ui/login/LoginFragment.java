package demo.zxhua.daggerdemo.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;

import javax.inject.Inject;

import butterknife.BindView;
import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.core.dagger.application.ForApplication;
import demo.zxhua.daggerdemo.core.dagger.fragment.FragmentComonpent;
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.ViewModelFactory;
import demo.zxhua.daggerdemo.ui.refreshedit.EditRefreshActivity;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public class LoginFragment extends BaseFragment<LoginViewModel> {
    @BindView(R.id.userName)
    EditText userName;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.login)
    Button login;
    private LoginViewModel loginViewModel;

    @Inject
    @ForApplication
    ViewModelFactory viewModelFactory;


    @Override
    protected void inject(FragmentComonpent fragmentComonpent) {
        fragmentComonpent.inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loginViewModel = viewModelFactory.create(LoginViewModel.class);

        loginViewModel.loginLiveData.observe(this, loginEntity ->
                Toast.makeText(getContext(), "username:" + loginEntity.username + "\npwd:" + loginEntity.pwd, Toast.LENGTH_SHORT).show()
        );

        RxView.clicks(login)
                .subscribe(o -> {
                    loginViewModel.login("AA", "BBBB");
                    startActivity(new Intent(getContext(), EditRefreshActivity.class));
                });

    }

}
