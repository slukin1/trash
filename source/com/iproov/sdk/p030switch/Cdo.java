package com.iproov.sdk.p030switch;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.iproov.sdk.cameray.Orientation;
import java.util.Objects;

/* renamed from: com.iproov.sdk.switch.do  reason: invalid class name and invalid package */
public final class Cdo {
    /* renamed from: do  reason: not valid java name */
    public static final Orientation m1883do(Context context) {
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        return Orientation.findByDegrees((m1884if(context) ? (defaultDisplay.getRotation() + 1) % 4 : defaultDisplay.getRotation()) * 90);
    }

    /* renamed from: if  reason: not valid java name */
    public static final boolean m1884if(Context context) {
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if ((rotation == 0 || rotation == 2) && point.x > point.y) {
            return true;
        }
        if ((rotation == 1 || rotation == 3) && point.x < point.y) {
            return true;
        }
        return false;
    }
}
