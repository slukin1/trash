package com.huobi.vulcan.utils;

import com.huochat.community.util.FileTool;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static MessageDigest a(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str);
    }

    public static byte[] b(String str) {
        return c(str.getBytes(Charset.forName("UTF-8")));
    }

    public static byte[] c(byte[] bArr) {
        try {
            MessageDigest a11 = a(FileTool.HASH_TYPE_MD5);
            a11.update(bArr);
            return a11.digest();
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
