package com.amazonaws.util;

public class BinaryUtils {
    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte hexString : bArr) {
            String hexString2 = Integer.toHexString(hexString);
            if (hexString2.length() == 1) {
                sb2.append("0");
            } else if (hexString2.length() == 8) {
                hexString2 = hexString2.substring(6);
            }
            sb2.append(hexString2);
        }
        return StringUtils.b(sb2.toString());
    }
}
