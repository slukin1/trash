package com.tencent.qcloud.tuicore.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qcloud.tuicore.TUIConfig;

public class ScreenUtil {
    private static final String TAG = "ScreenUtil";

    public static int dip2px(float f11) {
        return (int) ((f11 * TUIConfig.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float dp2px(float f11, DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f11, displayMetrics);
    }

    public static int getNavigationBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getPxByDp(float f11) {
        return (int) ((f11 * TUIConfig.getAppContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getRealScreenHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getRealScreenWidth(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return getPxByDp(1280.0f);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return getPxByDp(720.0f);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int[] scaledSize(int i11, int i12, int i13, int i14) {
        String str = TAG;
        Log.i(str, "scaledSize  containerWidth: " + i11 + " containerHeight: " + i12 + " realWidth: " + i13 + " realHeight: " + i14);
        float f11 = (float) i11;
        float f12 = (float) i12;
        float f13 = ((float) i13) / ((float) i14);
        if (f13 < f11 / f12) {
            i11 = (int) (f12 * f13);
        } else {
            i12 = (int) (f11 / f13);
        }
        return new int[]{i11, i12};
    }
}
