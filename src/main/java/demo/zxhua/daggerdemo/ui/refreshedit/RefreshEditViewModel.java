package demo.zxhua.daggerdemo.ui.refreshedit;

import android.app.Application;
import android.databinding.ObservableField;
import android.view.View;

import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.DaggerViewModel;
import demo.zxhua.daggerdemo.utils.TransformUtilsImpl;

/**
 * Created by Zxhua on 2017/9/20 0020.
 */

public class RefreshEditViewModel extends DaggerViewModel {
    public ObservableField<String> value = new ObservableField<String>();

    private TransformUtilsImpl transformUtils;

    public RefreshEditViewModel(Application application) {
        super(application);
        transformUtils = new TransformUtilsImpl();
    }

    public void refresh(String value) {
        this.value.set(value);
    }

    public void enCode(View view) {
        String binstr = transformUtils.strToBinstr(value.get());
        refresh(binstr);
    }

    public void deCode(View view) {
        String s = transformUtils.binstrToStr(value.get());
        refresh(s);
    }


}


