package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.TypedValue;
import com.tencent.android.tpush.logging.TLogger;

public class SizeUtil {
    public static final int TEXT_SIZE_0 = 20;
    public static final int TEXT_SIZE_0_1 = 18;
    public static final int TEXT_SIZE_0_2 = 16;
    public static final int TEXT_SIZE_1 = 22;
    public static final int TEXT_SIZE_2 = 24;

    /* renamed from: a  reason: collision with root package name */
    private static boolean f69337a = false;
    public static int dp10;
    public static int dp100;
    public static int dp14;
    public static int dp16;
    public static int dp18;
    public static int dp180;
    public static int dp2;
    public static int dp20;
    public static int dp200;
    public static int dp250;
    public static int dp30;
    public static int dp48;
    public static int dp5;
    public static int dp50;
    public static int dp606;
    public static int dp7;
    public static int dp846;
    public static int dp96;

    public static int dipTopx(Context context, float f11) {
        return (int) TypedValue.applyDimension(1, Float.valueOf(f11).floatValue(), context.getResources().getDisplayMetrics());
    }

    public static int dpToPx(Context context, int i11) {
        init(context);
        return Math.round(((float) i11) * (context.getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public static Point getDisplaySize(Activity activity) {
        Point point = new Point();
        if (activity == null) {
            return point;
        }
        try {
            activity.getWindowManager().getDefaultDisplay().getSize(point);
        } catch (Throwable th2) {
            TLogger.e("SizeUtil", "", th2);
        }
        return point;
    }

    public static int getStatusBarHeight(Activity activity) {
        int identifier;
        init(activity);
        if (!((activity.getWindow().getAttributes().flags & 1024) == 1024) && (identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void init(Context context) {
        if (!f69337a) {
            f69337a = true;
            dp96 = dpToPx(context, 96);
            dp48 = dpToPx(context, 48);
            dp30 = dpToPx(context, 30);
            dp5 = dpToPx(context, 5);
            dp20 = dpToPx(context, 20);
            dp10 = dpToPx(context, 10);
            dp7 = dpToPx(context, 7);
            dp18 = dpToPx(context, 18);
            dp16 = dpToPx(context, 16);
            dp14 = dpToPx(context, 14);
            dp100 = dpToPx(context, 100);
            dp200 = dpToPx(context, 200);
            dp250 = dpToPx(context, 250);
            dp2 = dpToPx(context, 2);
            dp50 = dpToPx(context, 50);
            dp180 = dpToPx(context, 180);
            dp606 = dpToPx(context, 606);
            dp846 = dpToPx(context, 846);
        }
    }

    public static int pxToDp(Context context, int i11) {
        init(context);
        return Math.round(((float) i11) / (context.getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public static int pxToSp(Context context, int i11) {
        init(context);
        return (int) (((float) i11) / context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static int spToPx(Context context, int i11) {
        init(context);
        return (int) (((float) i11) * context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static int getStatusBarHeight(Context context) {
        init(context);
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th2) {
            TLogger.e("SizeUtil", "", th2);
            return 0;
        }
    }
}
