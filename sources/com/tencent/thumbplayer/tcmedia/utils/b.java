package com.tencent.thumbplayer.tcmedia.utils;

import android.text.TextUtils;
import com.huochat.community.util.FileTool;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public class b {
    public static int a(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e11) {
                TPLogUtil.e("TPCommonUtils", (Throwable) e11);
            }
        }
        return i11;
    }

    public static String a(String str) {
        String hexString;
        try {
            byte[] digest = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder(40);
            for (byte b11 : digest) {
                byte b12 = b11 & 255;
                if ((b12 >> 4) == 0) {
                    sb2.append("0");
                    hexString = Integer.toHexString(b12);
                } else {
                    hexString = Integer.toHexString(b12);
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (Exception e11) {
            TPLogUtil.e("TPCommonUtils", e11.toString());
            return null;
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            if (TextUtils.isEmpty(str)) {
                str = "this argument should not be null!";
            }
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean a(Collection<? extends Object> collection) {
        return collection == null || collection.size() <= 0;
    }

    public static boolean a(Map<? extends Object, ? extends Object> map) {
        return map == null || map.size() <= 0;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return str.split(":")[0].matches("^((https|http|ftp|rtsp|mms)?)");
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }
}
