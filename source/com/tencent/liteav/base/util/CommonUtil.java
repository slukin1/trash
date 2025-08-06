package com.tencent.liteav.base.util;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
public class CommonUtil {
    private static long mNativeNtpTimeManagerDelegate;
    private static a sCallback;

    public interface a {
        void a(int i11, String str);
    }

    static {
        r.a();
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String getFileExtension(String str) {
        int lastIndexOf;
        if (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static long getNetworkTimestamp() {
        if (nativeNtpTimeManagerDelegateHasBeenCreated()) {
            return nativeGetNetworkTimestamp(mNativeNtpTimeManagerDelegate);
        }
        return 0;
    }

    public static String getSDKVersionStr() {
        return nativeGetSDKVersion();
    }

    private static native long nativeCreate();

    private static native long nativeGetNetworkTimestamp(long j11);

    public static native String nativeGetSDKVersion();

    private static boolean nativeNtpTimeManagerDelegateHasBeenCreated() {
        return sCallback != null;
    }

    private static native int nativeSetGlobalEnv(String str);

    private static native boolean nativeSetSocks5Proxy(String str, int i11, String str2, String str3, boolean z11, boolean z12, boolean z13);

    private static native int nativeUpdateNetworkTime(long j11);

    public static void onUpdateNetworkTime(int i11, String str) {
        a aVar = sCallback;
        if (aVar != null) {
            aVar.a(i11, str);
        }
    }

    public static int setGlobalEnv(String str) {
        return nativeSetGlobalEnv(str);
    }

    public static boolean setSocks5Proxy(String str, int i11, String str2, String str3, boolean z11, boolean z12, boolean z13) {
        return nativeSetSocks5Proxy(str, i11, str2, str3, z11, z12, z13);
    }

    public static void setUpdateNetworkTimeCallback(a aVar) {
        if (!nativeNtpTimeManagerDelegateHasBeenCreated()) {
            mNativeNtpTimeManagerDelegate = nativeCreate();
            sCallback = aVar;
        }
    }

    public static int updateNetworkTime() {
        if (nativeNtpTimeManagerDelegateHasBeenCreated()) {
            return nativeUpdateNetworkTime(mNativeNtpTimeManagerDelegate);
        }
        return -1;
    }
}
