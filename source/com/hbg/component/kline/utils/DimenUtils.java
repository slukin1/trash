package com.hbg.component.kline.utils;

import com.hbg.lib.common.BaseApplication;

public class DimenUtils {
    public static int a(float f11) {
        return (int) ((f11 * BaseApplication.b().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
