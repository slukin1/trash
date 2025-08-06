package com.hbg.lib.common.utils;

import android.content.Context;
import com.hbg.lib.common.BaseApplication;

public class PackageManagerUtil {
    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean b(String[] strArr) {
        if (!(strArr == null || strArr.length == 0)) {
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                try {
                    if (a(BaseApplication.b(), strArr[i11])) {
                        return true;
                    }
                    i11++;
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }
}
