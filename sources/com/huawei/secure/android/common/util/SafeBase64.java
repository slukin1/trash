package com.huawei.secure.android.common.util;

import android.util.Base64;
import android.util.Log;

public class SafeBase64 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38667a = "SafeBase64";

    public static byte[] decode(byte[] bArr, int i11) {
        try {
            return Base64.decode(bArr, i11);
        } catch (Exception e11) {
            String str = f38667a;
            Log.e(str, e11.getClass().getSimpleName() + " , message0 : " + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i11) {
        try {
            return Base64.encode(bArr, i11);
        } catch (Exception e11) {
            String str = f38667a;
            Log.e(str, e11.getClass().getSimpleName() + " , message3 : " + e11.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i11) {
        try {
            return Base64.encodeToString(bArr, i11);
        } catch (Exception e11) {
            String str = f38667a;
            Log.e(str, e11.getClass().getSimpleName() + " , message5 : " + e11.getMessage());
            return "";
        }
    }

    public static byte[] decode(byte[] bArr, int i11, int i12, int i13) {
        try {
            return Base64.decode(bArr, i11, i12, i13);
        } catch (Exception e11) {
            String str = f38667a;
            Log.e(str, e11.getClass().getSimpleName() + " , message1 : " + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encode(byte[] bArr, int i11, int i12, int i13) {
        try {
            return Base64.encode(bArr, i11, i12, i13);
        } catch (Exception e11) {
            String str = f38667a;
            Log.e(str, e11.getClass().getSimpleName() + " , message4 : " + e11.getMessage());
            return new byte[0];
        }
    }

    public static String encodeToString(byte[] bArr, int i11, int i12, int i13) {
        try {
            return Base64.encodeToString(bArr, i11, i12, i13);
        } catch (Exception e11) {
            String str = f38667a;
            Log.e(str, e11.getClass().getSimpleName() + " , message6 : " + e11.getMessage());
            return "";
        }
    }

    public static byte[] decode(String str, int i11) {
        try {
            return Base64.decode(str, i11);
        } catch (Exception e11) {
            String str2 = f38667a;
            Log.e(str2, e11.getClass().getSimpleName() + " , message2 : " + e11.getMessage());
            return new byte[0];
        }
    }
}
