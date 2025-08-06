package com.xiaomi.push;

import android.text.TextUtils;
import com.huochat.community.util.FileTool;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class bc {
    public static String a(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return a(objArr, str, 0, objArr.length);
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_SHA1);
            instance.update(a(str));
            return String.format("%1$032X", new Object[]{new BigInteger(1, instance.digest())});
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static String a(Object[] objArr, String str, int i11, int i12) {
        int i13;
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i14 = i12 - i11;
        if (i14 <= 0) {
            return "";
        }
        if (objArr[i11] == null) {
            i13 = 16;
        } else {
            i13 = objArr[i11].toString().length();
        }
        StringBuffer stringBuffer = new StringBuffer(i14 * (i13 + str.length()));
        for (int i15 = i11; i15 < i12; i15++) {
            if (i15 > i11) {
                stringBuffer.append(str);
            }
            if (objArr[i15] != null) {
                stringBuffer.append(objArr[i15]);
            }
        }
        return stringBuffer.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static String a(Iterator<?> it2, String str) {
        if (it2 == null) {
            return null;
        }
        if (!it2.hasNext()) {
            return "";
        }
        Object next = it2.next();
        if (!it2.hasNext()) {
            return next.toString();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it2.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            Object next2 = it2.next();
            if (next2 != null) {
                stringBuffer.append(next2);
            }
        }
        return stringBuffer.toString();
    }

    public static String a(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        return a(collection.iterator(), str);
    }

    public static String a(int i11) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < i11; i12++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(a(str));
            return String.format("%1$032X", new Object[]{new BigInteger(1, instance.digest())});
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(bArr);
            str = String.format("%1$032X", new Object[]{new BigInteger(1, instance.digest())});
        } catch (Exception unused) {
            str = "";
        }
        return str.toLowerCase();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m2434a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2433a(String str) {
        if (str == null) {
            return true;
        }
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt < 0 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    public static String a(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        if (i11 <= 0 || length < i11) {
            i11 = length / 3;
            if (i11 <= 1) {
                i11 = 1;
            }
            if (i11 > 3) {
                i11 = 3;
            }
        }
        int i12 = 0;
        while (i12 < length) {
            int i13 = i12 + 1;
            if (i13 % i11 == 0) {
                sb2.append("*");
            } else {
                sb2.append(str.charAt(i12));
            }
            i12 = i13;
        }
        return sb2.toString();
    }
}
