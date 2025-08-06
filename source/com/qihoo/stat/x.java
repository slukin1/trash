package com.qihoo.stat;

import com.huochat.community.util.FileTool;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f28858a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (bytes == null || bytes.length <= 0) {
                return str;
            }
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(bytes);
            return b(instance.digest());
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return str;
        } catch (UnsupportedEncodingException e12) {
            e12.printStackTrace();
            return str;
        } catch (Exception e13) {
            e13.printStackTrace();
            return str;
        }
    }

    public static String b(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            char[] cArr = f28858a;
            sb2.append(cArr[(b11 & 240) >> 4]);
            sb2.append(cArr[b11 & 15]);
        }
        return sb2.toString();
    }
}
