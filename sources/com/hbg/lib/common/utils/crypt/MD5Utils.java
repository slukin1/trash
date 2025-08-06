package com.hbg.lib.common.utils.crypt;

import com.huochat.community.util.FileTool;
import java.security.MessageDigest;

public class MD5Utils {
    public static String a(String str) {
        return (str == null || str.length() < 1) ? "" : b(str.getBytes());
    }

    public static String b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.reset();
            instance.update(bArr);
            return e(instance.digest(), "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(String str) {
        try {
            return b((str + "hello, moto").getBytes());
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String d(String str) {
        try {
            return b((str + "otc, nono").getBytes());
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String e(byte[] bArr, String str) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            byte b12 = b11 & 255;
            if (Integer.toHexString(b12).length() == 1) {
                sb2.append("0");
                sb2.append(Integer.toHexString(b12));
            } else {
                sb2.append(Integer.toHexString(b12));
            }
        }
        return sb2.toString();
    }
}
