package trungtamgiasubaoanh.giasu.com.imusic;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Admin on 18-May-18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        initVariable(savedInstanceState);
        initData(savedInstanceState);
    }

    public abstract int getLayoutResource();

    public abstract void initVariable(Bundle savedInstanceState);

    public abstract void initData(Bundle savedInstanceState);
}
