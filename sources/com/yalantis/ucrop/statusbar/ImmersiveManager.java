package com.yalantis.ucrop.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.yalantis.ucrop.util.DensityUtil;

public class ImmersiveManager {
    private static final String TAG_FAKE_STATUS_BAR_VIEW = "TAG_FAKE_STATUS_BAR_VIEW";
    private static final String TAG_MARGIN_ADDED = "TAG_MARGIN_ADDED";

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, int i11, int i12, boolean z11) {
        immersiveAboveAPI23(appCompatActivity, false, false, i11, i12, z11);
    }

    private static void initBarBelowLOLLIPOP(Activity activity) {
        activity.getWindow().addFlags(67108864);
        setupStatusBarView(activity);
    }

    private static void setupStatusBarView(Activity activity) {
        Window window = activity.getWindow();
        View findViewWithTag = window.getDecorView().findViewWithTag(TAG_FAKE_STATUS_BAR_VIEW);
        if (findViewWithTag == null) {
            findViewWithTag = new View(activity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DensityUtil.getStatusBarHeight(activity));
            layoutParams.gravity = 48;
            findViewWithTag.setLayoutParams(layoutParams);
            findViewWithTag.setVisibility(0);
            findViewWithTag.setTag(TAG_MARGIN_ADDED);
            ((ViewGroup) window.getDecorView()).addView(findViewWithTag);
        }
        findViewWithTag.setBackgroundColor(0);
    }

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, boolean z11, boolean z12, int i11, int i12, boolean z13) {
        try {
            Window window = appCompatActivity.getWindow();
            int i13 = Build.VERSION.SDK_INT;
            if (i13 >= 21) {
                boolean z14 = false;
                boolean z15 = true;
                if (z11 && z12) {
                    window.clearFlags(201326592);
                    if (i11 == 0) {
                        z14 = true;
                    }
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, true, true, z14, z13);
                    window.addFlags(Integer.MIN_VALUE);
                } else if (z11 || z12) {
                    if (!z11) {
                        window.requestFeature(1);
                        window.clearFlags(201326592);
                        LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, true, i11 == 0, z13);
                        window.addFlags(Integer.MIN_VALUE);
                    } else {
                        return;
                    }
                } else if (i13 >= 23 || !z13) {
                    window.requestFeature(1);
                    window.clearFlags(201326592);
                    if (i11 != 0) {
                        z15 = false;
                    }
                    LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, false, z15, z13);
                    window.addFlags(Integer.MIN_VALUE);
                } else {
                    initBarBelowLOLLIPOP(appCompatActivity);
                }
                window.setStatusBarColor(i11);
                window.setNavigationBarColor(i12);
            } else if (z13) {
                initBarBelowLOLLIPOP(appCompatActivity);
            } else {
                window.setFlags(67108864, 67108864);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
