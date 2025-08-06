package com.huochat.community.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ScreemTool {
    private ScreemTool() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeightSize(Context context) {
        return getScreenSize(context)[1];
    }

    public static int getScreenResolution(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels * displayMetrics.heightPixels;
    }

    public static int[] getScreenSize(Context context) {
        int[] iArr = new int[2];
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i11 = displayMetrics.widthPixels;
        int i12 = displayMetrics.heightPixels;
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 14 && i13 < 17) {
            try {
                i11 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                i12 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
                i11 = point.x;
                i12 = point.y;
            } catch (Exception unused2) {
            }
        }
        iArr[0] = i11;
        iArr[1] = i12;
        return iArr;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenWidthSize(Context context) {
        return getScreenSize(context)[0];
    }

    public static int getStatusHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    public static void setWindowBrightness(Activity activity, float f11) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f11;
        window.setAttributes(attributes);
    }

    public static Bitmap snapShotWithStatusBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(decorView.getDrawingCache(), 0, 0, getScreenWidth(activity), getScreenHeight(activity));
        decorView.destroyDrawingCache();
        return createBitmap;
    }

    public static Bitmap snapShotWithoutStatusBar(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i11 = rect.top;
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, i11, getScreenWidth(activity), getScreenHeight(activity) - i11);
        decorView.destroyDrawingCache();
        return createBitmap;
    }
}
