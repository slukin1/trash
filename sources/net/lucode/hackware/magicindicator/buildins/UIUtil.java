package net.lucode.hackware.magicindicator.buildins;

import android.content.Context;

public final class UIUtil {
    public static int a(Context context, double d11) {
        return (int) ((d11 * ((double) context.getResources().getDisplayMetrics().density)) + 0.5d);
    }
}
