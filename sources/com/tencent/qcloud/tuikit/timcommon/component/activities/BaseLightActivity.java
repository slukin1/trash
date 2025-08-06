package com.tencent.qcloud.tuikit.timcommon.component.activities;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIThemeManager;

public class BaseLightActivity extends AppCompatActivity {
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
            getWindow().setStatusBarColor(getResources().getColor(TUIThemeManager.getAttrResId(this, R.attr.core_header_start_color)));
            getWindow().setNavigationBarColor(getResources().getColor(com.tencent.qcloud.tuikit.timcommon.R.color.navigation_bar_color));
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192 | 16);
        }
    }
}
