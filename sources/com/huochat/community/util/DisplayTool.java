package com.huochat.community.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.hbg.lib.common.BaseApplication;

public final class DisplayTool {
    private DisplayTool() {
    }

    public static boolean checkNavigationBarShow(Context context) {
        int i11;
        boolean z11 = true;
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z12 = identifier > 0 ? resources.getBoolean(identifier) : true;
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
                if (Build.VERSION.SDK_INT < 21) {
                    i11 = Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
                } else {
                    i11 = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
                }
                if (!"1".equals(str)) {
                    if (1 != i11) {
                        if ("0".equals(str)) {
                            return true;
                        }
                        return z12;
                    }
                }
                return false;
            } catch (Exception e11) {
                e = e11;
                z11 = z12;
                e.printStackTrace();
                return z11;
            }
        } catch (Exception e12) {
            e = e12;
            e.printStackTrace();
            return z11;
        }
    }

    public static int dp2px(Context context, float f11) {
        if (context == null) {
            return 0;
        }
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float getDensity(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return getDisplayMetrics(context).density;
    }

    public static int getDisplayFullHeight(Activity activity) {
        if (activity == null) {
            return 0;
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
            return displayMetrics.heightPixels;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int getRealHeight(Context context) {
        if (context == null) {
            return 0;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeightPixels(Activity activity) {
        if (activity == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int[] getScreenWH(Context context) {
        if (context == null) {
            return new int[]{0, 0};
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static int getScreenWidthPixels(Activity activity) {
        if (activity == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    public static boolean hasNavigationBarFun(Activity activity) {
        Resources resources = activity.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z11 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return z11;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isNavigationBarShow(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            if (point2.y != point.y) {
                return true;
            }
            return false;
        }
        boolean hasPermanentMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return false;
        }
        return true;
    }

    public static int px2dp(Context context, float f11) {
        if (context == null) {
            return 0;
        }
        return (int) ((f11 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(Context context, float f11) {
        if (context == null) {
            return 0;
        }
        return (int) ((f11 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(Context context, float f11) {
        if (context == null) {
            return 0;
        }
        return (int) ((f11 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int dp2px(float f11) {
        return (int) ((f11 * BaseApplication.b().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dp(float f11) {
        return (int) ((f11 / BaseApplication.b().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(float f11) {
        return (int) ((f11 / BaseApplication.b().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(float f11) {
        return (int) ((f11 * BaseApplication.b().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
