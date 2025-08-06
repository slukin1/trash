package com.tencent.qcloud.tuikit.tuicallkit.base;

import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.qcloud.tuikit.tuicallkit.R;
import com.tencent.qcloud.tuikit.tuicallkit.utils.DeviceUtils;
import com.tencent.qcloud.tuikit.tuicallkit.view.root.BaseCallView;

public class BaseCallActivity extends AppCompatActivity {
    private static AppCompatActivity mActivity;
    private static BaseCallView mBaseCallView;
    private static RelativeLayout mLayoutContainer;

    public static void finishActivity() {
        AppCompatActivity appCompatActivity = mActivity;
        if (appCompatActivity != null) {
            appCompatActivity.finish();
        }
        mActivity = null;
        BaseCallView baseCallView = mBaseCallView;
        if (!(baseCallView == null || baseCallView.getParent() == null)) {
            ((ViewGroup) mBaseCallView.getParent()).removeView(mBaseCallView);
        }
        mBaseCallView = null;
        mLayoutContainer = null;
    }

    private void initStatusBar() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(9216);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (i11 >= 19) {
            getWindow().addFlags(67108864);
        }
    }

    private void initView() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_container);
        mLayoutContainer = relativeLayout;
        relativeLayout.removeAllViews();
        BaseCallView baseCallView = mBaseCallView;
        if (baseCallView != null) {
            if (baseCallView.getParent() != null) {
                ((ViewGroup) mBaseCallView.getParent()).removeView(mBaseCallView);
            }
            mLayoutContainer.addView(mBaseCallView);
        }
    }

    public static void updateBaseView(BaseCallView baseCallView) {
        mBaseCallView = baseCallView;
        RelativeLayout relativeLayout = mLayoutContainer;
        if (relativeLayout != null && baseCallView != null) {
            relativeLayout.removeAllViews();
            if (mBaseCallView.getParent() != null) {
                ((ViewGroup) mBaseCallView.getParent()).removeView(mBaseCallView);
            }
            mLayoutContainer.addView(mBaseCallView);
        }
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DeviceUtils.setScreenLockParams(getWindow());
        mActivity = this;
        setContentView(R.layout.tuicalling_base_activity);
        initStatusBar();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        initView();
        ((NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION)).cancelAll();
    }
}
