package com.cpiz.android.bubbleview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;

public class Utils {
    public static float a(float f11, float f12, float f13) {
        return Math.min(Math.max(f12, f11), f13);
    }

    public static int b(int i11) {
        return (int) (((float) i11) * Resources.getSystem().getDisplayMetrics().density);
    }

    public static Activity c(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static int d(View view) {
        int i11;
        int i12;
        Activity c11 = c(view);
        if (c11 == null) {
            return 0;
        }
        Display defaultDisplay = c11.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point point2 = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point2);
        } else {
            try {
                point2.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point2.y = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception e11) {
                Log.w("Utils", "getNavigationBarHeight: error", e11);
            }
        }
        if (c11.getResources().getConfiguration().orientation == 2) {
            i11 = point.x;
            i12 = point2.x;
        } else {
            i11 = point.y;
            i12 = point2.y;
        }
        if (i12 > i11) {
            return i12 - i11;
        }
        return 0;
    }
}
