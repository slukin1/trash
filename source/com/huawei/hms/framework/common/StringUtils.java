package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.secure.android.common.util.SafeString;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Locale;

public class StringUtils {
    private static final int INIT_CAPACITY = 1024;
    private static final String SAFE_STRING_PATH = "com.huawei.secure.android.common.util.SafeString";
    private static final String TAG = "StringUtils";
    private static boolean isAegisStringLibraryLoaded = false;

    public static String anonymizeMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (i11 % 2 != 0) {
                charArray[i11] = '*';
            }
        }
        return new String(charArray);
    }

    public static String byte2Str(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            Logger.w("StringUtils.byte2str error: UnsupportedEncodingException", anonymizeMessage(e11.getMessage()));
            return "";
        }
    }

    private static boolean checkCompatible(String str) {
        ClassLoader classLoader = SecurityBase64Utils.class.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        try {
            classLoader.loadClass(str);
            synchronized (StringUtils.class) {
                isAegisStringLibraryLoaded = true;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static String collection2String(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String append : collection) {
            sb2.append(append);
            sb2.append(";");
        }
        return sb2.toString().substring(0, sb2.length() - 1);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    public static byte[] getBytes(long j11) {
        return getBytes(String.valueOf(j11));
    }

    public static String getTraceInfo(Throwable th2) {
        StackTraceElement[] stackTrace = th2.getStackTrace();
        StringBuilder sb2 = new StringBuilder(1024);
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb2.append("at ");
            sb2.append(stackTraceElement.toString());
            sb2.append(";");
        }
        return sb2.toString();
    }

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (isAegisStringLibraryLoaded || checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.replace(str, charSequence, charSequence2);
            } catch (Throwable unused) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(charSequence)) {
            return str;
        }
        try {
            return str.replace(charSequence, charSequence2);
        } catch (Exception unused2) {
            return str;
        }
    }

    public static byte[] str2Byte(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            Logger.w("StringUtils.str2Byte error: UnsupportedEncodingException", anonymizeMessage(e11.getMessage()));
            return new byte[0];
        }
    }

    public static boolean strEquals(String str, String str2) {
        return str == str2 || (str != null && str.equals(str2));
    }

    public static boolean stringToBoolean(String str, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            return z11;
        }
        try {
            return Boolean.valueOf(str).booleanValue();
        } catch (NumberFormatException e11) {
            Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e11.getMessage()));
            return z11;
        }
    }

    public static int stringToInteger(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e11) {
            Logger.w(TAG, "String to Integer catch NumberFormatException." + anonymizeMessage(e11.getMessage()));
            return i11;
        }
    }

    public static long stringToLong(String str, long j11) {
        if (TextUtils.isEmpty(str)) {
            return j11;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e11) {
            Logger.w(TAG, "String to Long catch NumberFormatException." + anonymizeMessage(e11.getMessage()));
            return j11;
        }
    }

    public static String substring(String str, int i11) {
        if (checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.substring(str, i11);
            } catch (Throwable unused) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (!TextUtils.isEmpty(str) && str.length() >= i11 && i11 >= 0) {
            try {
                return str.substring(i11);
            } catch (Exception unused2) {
            }
        }
        return "";
    }

    public static String toLowerCase(String str) {
        return str == null ? "" : str.toLowerCase(Locale.ROOT);
    }

    public static byte[] getBytes(String str) {
        byte[] bArr = new byte[0];
        if (str == null) {
            return bArr;
        }
        try {
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Logger.w(TAG, "the content has error while it is converted to bytes");
            return bArr;
        }
    }

    public static String substring(String str, int i11, int i12) {
        if (isAegisStringLibraryLoaded || checkCompatible(SAFE_STRING_PATH)) {
            try {
                return SafeString.substring(str, i11, i12);
            } catch (Throwable unused) {
                Logger.w(TAG, "SafeString.substring error");
            }
        }
        if (!TextUtils.isEmpty(str) && i11 >= 0 && i12 <= str.length() && i12 >= i11) {
            try {
                return str.substring(i11, i12);
            } catch (Exception unused2) {
            }
        }
        return "";
    }
}
