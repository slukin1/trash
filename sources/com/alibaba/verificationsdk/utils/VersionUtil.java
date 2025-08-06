package com.alibaba.verificationsdk.utils;

import android.text.TextUtils;

public class VersionUtil {
    private static int compareVersion(String str, String str2) {
        int parseVersionValue = parseVersionValue(str);
        int parseVersionValue2 = parseVersionValue(str2);
        if (parseVersionValue > parseVersionValue2) {
            return 1;
        }
        return parseVersionValue < parseVersionValue2 ? -1 : 0;
    }

    public static boolean isVersionUpdate(String str, String str2) {
        return -1 != compareVersion(str, str2);
    }

    private static int parseVersionValue(String str) {
        int i11 = 0;
        try {
            String[] split = str.split("\\.");
            if (split.length <= 0) {
                return 0;
            }
            int length = split.length;
            int[] iArr = new int[length];
            for (int i12 = 0; i12 < split.length; i12++) {
                if (!TextUtils.isEmpty(split[i12])) {
                    iArr[i12] = Integer.parseInt(split[i12]);
                } else {
                    iArr[i12] = 0;
                }
            }
            int i13 = 1000000;
            int i14 = 0;
            while (i11 < length) {
                try {
                    i14 += iArr[i11] * i13;
                    i13 /= 100;
                    i11++;
                } catch (Exception unused) {
                }
            }
            return i14;
        } catch (Exception unused2) {
            return 0;
        }
    }
}
