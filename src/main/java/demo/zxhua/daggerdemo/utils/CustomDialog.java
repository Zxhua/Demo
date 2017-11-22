package demo.zxhua.daggerdemo.utils;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import demo.zxhua.daggerdemo.R;

/**
 * Created by Zxhua on 2017/11/11 0011.
 */

public class CustomDialog extends Dialog {

    private CloseSystemDialogsReceiver mCloseSystemDialogsReceiver;
    private Window mWindow;
    private Button closeBtn;

    public CustomDialog(Context context) {
        super(context);
        setContentView(R.layout.view_custom);
        closeBtn = findViewById(R.id.closeBtn);
        mWindow = this.getWindow();
        WindowManager.LayoutParams attributes = mWindow.getAttributes();
        attributes.width = mWindow.getWindowManager().getDefaultDisplay()
                .getWidth();
        attributes.height = WindowManager.LayoutParams.MATCH_PARENT;
        mWindow.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        IntentFilter filter = new IntentFilter(
                Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        mCloseSystemDialogsReceiver = new CloseSystemDialogsReceiver();
        mWindow.getContext().registerReceiver(mCloseSystemDialogsReceiver,
                filter);

        closeBtn.setOnClickListener(view -> dismiss());
    }

    private class CloseSystemDialogsReceiver extends BroadcastReceiver {
        final String SYSTEM_DIALOG_REASON_KEY = "reason";
        final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(intent.getAction())) {
                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                if (SYSTEM_DIALOG_REASON_HOME_KEY.equals(reason)) {
                    CustomDialog.this.dismiss();
                    mWindow.getContext().unregisterReceiver(mCloseSystemDialogsReceiver);
                }
            }

        }
    }
}