package com.luck.picture.lib.immersive;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.h0;
import com.luck.picture.lib.utils.DensityUtil;

public class ImmersiveManager {
    private static final String TAG_FAKE_STATUS_BAR_VIEW = "TAG_FAKE_STATUS_BAR_VIEW";
    private static final String TAG_MARGIN_ADDED = "TAG_MARGIN_ADDED";
    private static final String TAG_NAVIGATION_BAR_VIEW = "TAG_NAVIGATION_BAR_VIEW";

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, int i11, int i12, boolean z11) {
        immersiveAboveAPI23(appCompatActivity, false, false, i11, i12, z11);
    }

    private static void initBarBelowLOLLIPOP(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(67108864);
        setupStatusBarView(activity);
        if (DensityUtil.isNavBarVisible(activity)) {
            window.addFlags(134217728);
            setupNavBarView(activity);
        }
    }

    private static void setupNavBarView(Activity activity) {
        FrameLayout.LayoutParams layoutParams;
        Window window = activity.getWindow();
        View findViewWithTag = window.getDecorView().findViewWithTag(TAG_NAVIGATION_BAR_VIEW);
        if (findViewWithTag == null) {
            findViewWithTag = new View(activity);
            findViewWithTag.setTag(TAG_NAVIGATION_BAR_VIEW);
            ((ViewGroup) window.getDecorView()).addView(findViewWithTag);
        }
        if (DensityUtil.isNavigationAtBottom(activity)) {
            layoutParams = new FrameLayout.LayoutParams(-1, DensityUtil.getNavigationBarHeight(activity));
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(DensityUtil.getNavigationBarWidth(activity), -1);
            layoutParams.gravity = 8388613;
        }
        findViewWithTag.setLayoutParams(layoutParams);
        findViewWithTag.setBackgroundColor(0);
        findViewWithTag.setVisibility(0);
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

    public static void translucentStatusBar(Activity activity, boolean z11) {
        Window window = activity.getWindow();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            window.addFlags(Integer.MIN_VALUE);
        }
        window.clearFlags(67108864);
        if (i11 >= 21) {
            window.setStatusBarColor(0);
        }
        View decorView = window.getDecorView();
        if (i11 >= 23) {
            if (z11) {
                decorView.setSystemUiVisibility(9472);
            } else {
                window.getDecorView().setSystemUiVisibility(1280);
            }
        } else if (z11) {
            initBarBelowLOLLIPOP(activity);
        } else {
            window.getDecorView().setSystemUiVisibility(1280);
        }
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
            h0.u0(childAt);
        }
    }

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, boolean z11, boolean z12, int i11, int i12, boolean z13) {
        try {
            Window window = appCompatActivity.getWindow();
            int i13 = Build.VERSION.SDK_INT;
            if (i13 < 19 || i13 >= 21) {
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
                }
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
