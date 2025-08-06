package com.tencent.qcloud.tuikit.timcommon.component.activities;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;

public class BaseMinimalistLightActivity extends AppCompatActivity {
    public void finish() {
        hideSoftInput();
        super.finish();
    }

    public void hideSoftInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        Window window = getWindow();
        if (window != null) {
            inputMethodManager.hideSoftInputFromWindow(window.getDecorView().getWindowToken(), 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(134217728);
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(-1);
            getWindow().setNavigationBarColor(-1);
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192 | 16);
        }
    }
}
