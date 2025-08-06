package com.luck.picture.lib.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.luck.picture.lib.immersive.RomUtils;

public class DensityUtil {
    public static int dip2px(Context context, float f11) {
        return (int) ((f11 * context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int getInternalDimensionSize(Context context, String str) {
        try {
            int identifier = Resources.getSystem().getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f11 = (((float) dimensionPixelSize) * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f11 >= 0.0f ? f11 + 0.5f : f11 - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(Context context) {
        boolean z11 = true;
        if (context.getResources().getConfiguration().orientation != 1) {
            z11 = false;
        }
        if (!isNavBarVisible(context)) {
            return 0;
        }
        return getInternalDimensionSize(context, z11 ? "navigation_bar_height" : "navigation_bar_height_landscape");
    }

    @TargetApi(14)
    public static int getNavigationBarWidth(Context context) {
        if (Build.VERSION.SDK_INT < 14 || !isNavBarVisible(context)) {
            return 0;
        }
        return getInternalDimensionSize(context, "navigation_bar_width");
    }

    public static int getRealScreenHeight(Context context) {
        Point point = new Point();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static int getRealScreenWidth(Context context) {
        Point point = new Point();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    private static String getResNameById(Context context, int i11) {
        try {
            return context.getResources().getResourceEntryName(i11);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getScreenHeight(Context context) {
        return getRealScreenHeight(context) - getStatusNavigationBarHeight(context);
    }

    @SuppressLint({"NewApi"})
    private static float getSmallestWidthDp(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 16) {
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        float f11 = displayMetrics.density;
        return Math.min(((float) displayMetrics.widthPixels) / f11, ((float) displayMetrics.heightPixels) / f11);
    }

    public static int getStatusBarHeight(Context context) {
        int i11;
        int i12;
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                i12 = system.getDimensionPixelSize(identifier);
                if (i12 < dimensionPixelSize) {
                    float f11 = (((float) dimensionPixelSize) * system.getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                    i12 = (int) (f11 >= 0.0f ? f11 + 0.5f : f11 - 0.5f);
                }
            } catch (Exception unused) {
                i11 = getStatusBarHeight();
            }
        } else {
            i12 = 0;
        }
        i11 = i12;
        return i11 == 0 ? dip2px(context, 26.0f) : i11;
    }

    private static int getStatusNavigationBarHeight(Context context) {
        if (isNavBarVisible(context)) {
            return getStatusBarHeight(context) + getNavigationBarHeight(context);
        }
        return getStatusBarHeight(context);
    }

    public static boolean isNavBarVisible(Context context) {
        boolean z11;
        int i11;
        boolean z12 = false;
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        int childCount = viewGroup.getChildCount();
        int i12 = 0;
        while (true) {
            if (i12 >= childCount) {
                z11 = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i12);
            int id2 = childAt.getId();
            if (id2 != -1 && "navigationBarBackground".equals(getResNameById(activity, id2)) && childAt.getVisibility() == 0) {
                z11 = true;
                break;
            }
            i12++;
        }
        if (!z11) {
            return z11;
        }
        if (RomUtils.isSamsung() && (i11 = Build.VERSION.SDK_INT) >= 17 && i11 < 29) {
            try {
                if (Settings.Global.getInt(activity.getContentResolver(), "navigationbar_hide_bar_enabled") == 0) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
            }
        }
        if ((viewGroup.getSystemUiVisibility() & 2) == 0) {
            z12 = true;
        }
        return z12;
    }

    public static boolean isNavigationAtBottom(Activity activity) {
        boolean z11 = activity.getResources().getConfiguration().orientation == 1;
        if (getSmallestWidthDp(activity) >= 600.0f || z11) {
            return true;
        }
        return false;
    }

    public static int getStatusBarHeight() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }
}
