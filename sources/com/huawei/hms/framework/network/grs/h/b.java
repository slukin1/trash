package com.huawei.hms.framework.network.grs.h;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38090a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f38091b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    public static String a(String str) {
        return a(str, "SHA-256");
    }

    private static String a(String str, String str2) {
        String str3;
        String str4;
        try {
            try {
                return a(MessageDigest.getInstance(str2).digest(str.getBytes("UTF-8")));
            } catch (NoSuchAlgorithmException unused) {
                str3 = f38090a;
                str4 = "encrypt NoSuchAlgorithmException";
                Logger.w(str3, str4);
                return null;
            }
        } catch (UnsupportedEncodingException unused2) {
            str3 = f38090a;
            str4 = "encrypt UnsupportedEncodingException";
            Logger.w(str3, str4);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            String hexString = Integer.toHexString(b11 & 255);
            if (hexString.length() == 1) {
                sb2.append("0");
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i11 = 1;
        if (str.length() == 1) {
            return "*";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < str.length(); i12++) {
            String str2 = str.charAt(i12) + "";
            if (f38091b.matcher(str2).matches()) {
                if (i11 % 2 == 0) {
                    str2 = "*";
                }
                i11++;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }
}
