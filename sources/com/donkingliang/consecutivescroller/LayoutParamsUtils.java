package com.donkingliang.consecutivescroller;

import android.view.ViewGroup;

public class LayoutParamsUtils {
    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.bottomMargin = 0;
        }
    }
}
