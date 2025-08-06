package com.tencent.liteav.txcvodplayer.hlsencoder;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.base.util.LiteavLog;
import java.nio.charset.Charset;
import java.util.Random;

public class TXCHLSEncoder {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21978a = "com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder";

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f21979b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f21980c = "0123456789ABCDEF".toCharArray();

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return rsaEncrypt(str);
        }
        LiteavLog.w(f21978a, "encryptKey input exception!");
        return null;
    }

    private static native byte[] aesDecrypt(String str, byte[] bArr);

    private static native byte[] aesEncrypt(String str, byte[] bArr);

    public static String b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return new String(aesDecrypt(str, Base64.decode(str2, 2)), f21979b);
        }
        LiteavLog.w(f21978a, "decryptWithSecretKey input exception!");
        return null;
    }

    private static native String md5(int i11, String str, String str2, int i12);

    private static native String rsaEncrypt(String str);

    public static String a() {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < 32; i11++) {
            char[] cArr = f21980c;
            sb2.append(cArr[new Random().nextInt(cArr.length)]);
        }
        return sb2.toString();
    }

    public static String a(int i11, String str, String str2, int i12) {
        if (TextUtils.isEmpty(str)) {
            str = "default";
        }
        if (!TextUtils.isEmpty(str2)) {
            return md5(i11, str, str2, i12);
        }
        LiteavLog.w(f21978a, "genSecretKey input exception!");
        return null;
    }

    public static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return Base64.encodeToString(aesEncrypt(str, str2.getBytes(f21979b)), 2);
        }
        LiteavLog.w(f21978a, "encryptWithSecretKey input exception!");
        return null;
    }
}
