package com.blankj.utilcode.util;

import android.os.Build;
import android.text.TextUtils;

public final class j {
    public static String[] a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        String str = Build.CPU_ABI2;
        if (!TextUtils.isEmpty(str)) {
            return new String[]{Build.CPU_ABI, str};
        }
        return new String[]{Build.CPU_ABI};
    }
}
