package demo.zxhua.daggerdemo.ui.refreshedit;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.core.dagger.application.ForApplication;
import demo.zxhua.daggerdemo.core.dagger.fragment.FragmentComonpent;
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.ViewModelFactory;
import demo.zxhua.daggerdemo.databinding.FragmentRefreshEditBinding;

/**
 * Created by Zxhua on 2017/9/22 0022.
 */

public class EditRefreshFragment extends BaseFragment<RefreshEditViewModel> {

    @Inject
    @ForApplication
    ViewModelFactory viewModelFactory;

    private FragmentRefreshEditBinding fragmentRefreshEditBinding;

    @Override
    protected void inject(FragmentComonpent fragmentComonpent) {
        fragmentComonpent.inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = viewModelFactory.create(RefreshEditViewModel.class);

        fragmentRefreshEditBinding = FragmentRefreshEditBinding.bind(mRootView);
        fragmentRefreshEditBinding.setViewmodel(mViewModel);

        ViewModelProviders.of(this, viewModelFactory);

        mViewModel.refresh("{\"state\":0,\"data\":{\"total\":\"1\",\"notification\":\"1\",\"activity\":\"0\"},\"showMessage\":\"成功\"}");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_refresh_edit;
    }
}
