package com.tencent.wxop.stat.b;

import java.io.File;

final class p {
    private static int aI = -1;

    public static boolean a() {
        int i11 = aI;
        if (i11 == 1) {
            return true;
        }
        if (i11 == 0) {
            return false;
        }
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i12 = 0;
        while (i12 < 6) {
            try {
                if (new File(strArr[i12] + "su").exists()) {
                    aI = 1;
                    return true;
                }
                i12++;
            } catch (Exception unused) {
            }
        }
        aI = 0;
        return false;
    }
}
