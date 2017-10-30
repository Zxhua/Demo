package demo.zxhua.daggerdemo.core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import demo.zxhua.daggerdemo.core.dagger.fragment.DaggerFragment;
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.ViewModel;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public abstract class BaseFragment<T extends ViewModel> extends DaggerFragment {

    protected T mViewModel;

    protected View mRootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = View.inflate(getContext(), getLayoutId(), null);
        }
        ButterKnife.bind(this, mRootView);
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }

        return mRootView;
    }

    protected abstract int getLayoutId();
}
