package com.blankj.utilcode.util;

import android.graphics.Point;
import android.view.WindowManager;

public final class u {
    public static int a() {
        WindowManager windowManager = (WindowManager) Utils.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static int b() {
        WindowManager windowManager = (WindowManager) Utils.a().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }
}
