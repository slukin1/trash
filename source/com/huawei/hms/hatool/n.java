package com.huawei.hms.hatool;

import android.util.Pair;
import gg.b;
import ig.a;
import java.nio.charset.Charset;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f38236a = Charset.forName("UTF-8");

    public static Pair<byte[], String> a(String str, int i11) {
        if (str == null || str.length() < i11) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, i11);
        return new Pair<>(a.b(substring), str.substring(i11));
    }

    public static String a(String str, String str2) {
        Pair<byte[], String> a11 = a(str, 32);
        return new String(gg.a.i(a.b((String) a11.second), a.b(str2), (byte[]) a11.first), f38236a);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] b11 = a.b(str);
            if (b11.length >= 16) {
                return a.a(b.b(bArr, b11));
            }
            str2 = "key length is not right";
        }
        v.b("AesCipher", str2);
        return "";
    }

    public static String b(String str, String str2) {
        return a.a(gg.a.l(str.getBytes(f38236a), a.b(str2)));
    }
}
