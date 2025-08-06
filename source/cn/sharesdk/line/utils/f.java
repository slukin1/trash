package cn.sharesdk.line.utils;

import android.util.Base64;
import java.security.SecureRandom;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final SecureRandom f13672a = new SecureRandom();

    public static String a(int i11) {
        byte[] bArr = new byte[i11];
        f13672a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
