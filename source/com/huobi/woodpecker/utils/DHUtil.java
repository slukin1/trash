package com.huobi.woodpecker.utils;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;
import kv.e;

public class DHUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f21164a = Charset.forName("UTF-8");

    public static byte[] a(String str) {
        return b(str, "UTF-8");
    }

    public static byte[] b(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(str2));
            gZIPOutputStream.close();
        } catch (IOException e11) {
            e.p("DHUtil", "gzip compress error.", e11);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String c(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : Base64.encodeToString(bArr, 2).trim();
    }
}
