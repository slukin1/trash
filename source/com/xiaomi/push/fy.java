package com.xiaomi.push;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Random;

public class fy {

    /* renamed from: a  reason: collision with root package name */
    private static Random f51875a = new Random();

    /* renamed from: a  reason: collision with other field name */
    private static final char[] f2886a = "&quot;".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f51876b = "&apos;".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f51877c = "&amp;".toCharArray();

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f51878d = "&lt;".toCharArray();

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f51879e = "&gt;".toCharArray();

    /* renamed from: f  reason: collision with root package name */
    private static char[] f51880f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb2 = new StringBuilder((int) (((double) length) * 1.3d));
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            char c11 = charArray[i11];
            if (c11 <= '>') {
                if (c11 == '<') {
                    if (i11 > i12) {
                        sb2.append(charArray, i12, i11 - i12);
                    }
                    i12 = i11 + 1;
                    sb2.append(f51878d);
                } else if (c11 == '>') {
                    if (i11 > i12) {
                        sb2.append(charArray, i12, i11 - i12);
                    }
                    i12 = i11 + 1;
                    sb2.append(f51879e);
                } else if (c11 == '&') {
                    if (i11 > i12) {
                        sb2.append(charArray, i12, i11 - i12);
                    }
                    int i13 = i11 + 5;
                    if (length <= i13 || charArray[i11 + 1] != '#' || !Character.isDigit(charArray[i11 + 2]) || !Character.isDigit(charArray[i11 + 3]) || !Character.isDigit(charArray[i11 + 4]) || charArray[i13] != ';') {
                        i12 = i11 + 1;
                        sb2.append(f51877c);
                    }
                } else if (c11 == '\"') {
                    if (i11 > i12) {
                        sb2.append(charArray, i12, i11 - i12);
                    }
                    i12 = i11 + 1;
                    sb2.append(f2886a);
                } else if (c11 == '\'') {
                    if (i11 > i12) {
                        sb2.append(charArray, i12, i11 - i12);
                    }
                    i12 = i11 + 1;
                    sb2.append(f51876b);
                }
            }
            i11++;
        }
        if (i12 == 0) {
            return str;
        }
        if (i11 > i12) {
            sb2.append(charArray, i12, i11 - i12);
        }
        return sb2.toString();
    }

    public static final String b(String str) {
        return a(a(a(a(a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", ContainerUtils.FIELD_DELIMITER);
    }

    public static final String a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb2 = new StringBuilder(charArray.length);
        sb2.append(charArray, 0, indexOf);
        sb2.append(charArray2);
        int i11 = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i11);
            if (indexOf2 > 0) {
                sb2.append(charArray, i11, indexOf2 - i11);
                sb2.append(charArray2);
                i11 = indexOf2 + length;
            } else {
                sb2.append(charArray, i11, charArray.length - i11);
                return sb2.toString();
            }
        }
    }

    public static String a(byte[] bArr) {
        return String.valueOf(az.a(bArr));
    }

    public static String a(int i11) {
        if (i11 < 1) {
            return null;
        }
        char[] cArr = new char[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            cArr[i12] = f51880f[f51875a.nextInt(71)];
        }
        return new String(cArr);
    }
}
