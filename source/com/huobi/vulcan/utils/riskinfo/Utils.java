package com.huobi.vulcan.utils.riskinfo;

import java.util.List;

public class Utils {
    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString().toLowerCase();
    }

    public static String b(List<String> list, String str) {
        StringBuilder sb2 = new StringBuilder();
        if (list == null || list.isEmpty()) {
            return "";
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb2.append(list.get(i11));
            if (i11 < list.size() - 1) {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    public static boolean c(String str) {
        try {
            ClassLoader.getSystemClassLoader().loadClass(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
