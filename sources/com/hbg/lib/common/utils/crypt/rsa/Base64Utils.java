package com.hbg.lib.common.utils.crypt.rsa;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class Base64Utils {
    public static byte[] a(String str) throws Exception {
        return Base64.decode(str, 0);
    }

    public static String b(byte[] bArr) throws Exception {
        return Base64.encodeToString(bArr, 0);
    }

    public static String c(byte[] bArr, int i11) throws Exception {
        return Base64.encodeToString(bArr, i11);
    }

    public static String d(String str) throws Exception {
        return c(e(str), 2);
    }

    public static byte[] e(String str) throws Exception {
        byte[] bArr = new byte[0];
        File file = new File(str);
        if (!file.exists()) {
            return bArr;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
                byteArrayOutputStream.flush();
            } else {
                byteArrayOutputStream.close();
                fileInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
