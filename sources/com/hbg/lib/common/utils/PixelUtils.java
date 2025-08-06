package com.hbg.lib.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.hbg.lib.common.BaseApplication;
import i6.d;

public class PixelUtils {
    public static int a(float f11) {
        return (int) ((f11 * BaseApplication.b().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float b(float f11) {
        return (f11 * BaseApplication.b().getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static Bitmap c(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static String d(Bitmap bitmap, int i11, int i12) {
        int pixel = bitmap.getPixel(i11, i12);
        int red = Color.red(pixel);
        int green = Color.green(pixel);
        int blue = Color.blue(pixel);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("#");
        String upperCase = Integer.toHexString(red).toUpperCase();
        if (upperCase.length() == 1) {
            sb2.append("0");
        }
        sb2.append(upperCase);
        String upperCase2 = Integer.toHexString(green).toUpperCase();
        if (upperCase2.length() == 1) {
            sb2.append("0");
        }
        sb2.append(upperCase2);
        String upperCase3 = Integer.toHexString(blue).toUpperCase();
        if (upperCase3.length() == 1) {
            sb2.append("0");
        }
        sb2.append(upperCase3);
        bitmap.recycle();
        return sb2.toString();
    }

    public static String e(Drawable drawable, int i11, int i12) {
        if (drawable != null) {
            return d(c(drawable), i11, i12);
        }
        d.c("wuxinrong", "drawable为NULL，返回色值#FFFFFF");
        return "#FFFFFF";
    }

    public static int f() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) BaseApplication.b().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int g() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) BaseApplication.b().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int h(float f11) {
        return (int) ((f11 / BaseApplication.b().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int i(float f11) {
        return (int) ((f11 / BaseApplication.b().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int j(float f11) {
        return (int) ((f11 * BaseApplication.b().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
