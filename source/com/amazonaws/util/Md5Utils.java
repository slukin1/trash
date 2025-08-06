package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.huochat.community.util.FileTool;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    public static byte[] a(File file) throws IOException {
        return b(new FileInputStream(file));
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        Class<Md5Utils> cls = Md5Utils.class;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 16384);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            try {
                bufferedInputStream.close();
            } catch (Exception e11) {
                Log b11 = LogFactory.b(cls);
                b11.h("Unable to close input stream of hash candidate: " + e11);
            }
            return digest;
        } catch (NoSuchAlgorithmException e12) {
            throw new IllegalStateException(e12);
        } catch (Throwable th2) {
            try {
                bufferedInputStream.close();
            } catch (Exception e13) {
                Log b12 = LogFactory.b(cls);
                b12.h("Unable to close input stream of hash candidate: " + e13);
            }
            throw th2;
        }
    }

    public static byte[] c(byte[] bArr) {
        try {
            return MessageDigest.getInstance(FileTool.HASH_TYPE_MD5).digest(bArr);
        } catch (NoSuchAlgorithmException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static String d(File file) throws IOException {
        return Base64.encodeAsString(a(file));
    }

    public static String e(InputStream inputStream) throws IOException {
        return Base64.encodeAsString(b(inputStream));
    }

    public static String f(byte[] bArr) {
        return Base64.encodeAsString(c(bArr));
    }
}
