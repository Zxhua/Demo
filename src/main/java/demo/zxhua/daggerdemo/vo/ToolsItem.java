package demo.zxhua.daggerdemo.vo;

import android.arch.lifecycle.LiveData;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BindingAdapterItem;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class ToolsItem extends LiveData implements BindingAdapterItem {
    private ObservableField<String> toolsName;
    private ObservableField<String> toolsIconUrl;

    @Override
    public int getViewType() {
        return R.layout.item_tools;
    }

    @Bindable
    public String getToolsName() {
        return toolsName.get();
    }

    @Bindable
    public String getToolsIconUrl() {
        return toolsIconUrl.get();
    }

    public void setToolsName(String toolsName) {
        this.toolsName.set(toolsName);
    }

    public void setToolsIconUrl(String toolsIconUrl) {
        this.toolsIconUrl.set(toolsIconUrl);
    }
}
