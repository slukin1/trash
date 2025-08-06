package com.blankj.utilcode.util;

import android.os.Environment;

public final class s {
    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
