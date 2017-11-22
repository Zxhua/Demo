package demo.zxhua.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import demo.zxhua.daggerdemo.utils.CustomDialog;


public class MainActivity extends AppCompatActivity {
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomDialog dialog = new CustomDialog(this);
        dialog.show();
    }

//    @CacheLog(urlKey = "www", log = "aaaaaa")
    private void log(String key, String value) {

    }
}
