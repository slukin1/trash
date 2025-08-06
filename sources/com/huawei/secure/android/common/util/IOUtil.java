package com.huawei.secure.android.common.util;

import android.util.Log;
import java.io.File;

public class IOUtil {
    public static void a(File file) {
        if (file != null && file.exists() && !file.delete()) {
            Log.e("IOUtil", "deleteSecure exception");
        }
    }
}
