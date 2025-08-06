package com.huobi.edgeengine.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class ViewUtils {
    public static int a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}
