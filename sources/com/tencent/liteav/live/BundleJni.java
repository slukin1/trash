package com.tencent.liteav.live;

import android.os.Bundle;

public class BundleJni {
    public static Bundle appendBoolean(Bundle bundle, String str, boolean z11) {
        bundle.putBoolean(str, z11);
        return bundle;
    }

    public static Bundle appendBundle(Bundle bundle, String str, Bundle bundle2) {
        bundle.putBundle(str, bundle2);
        return bundle;
    }

    public static Bundle appendByteArray(Bundle bundle, String str, byte[] bArr) {
        bundle.putByteArray(str, bArr);
        return bundle;
    }

    public static Bundle appendDouble(Bundle bundle, String str, double d11) {
        bundle.putDouble(str, d11);
        return bundle;
    }

    public static Bundle appendFloat(Bundle bundle, String str, float f11) {
        bundle.putFloat(str, f11);
        return bundle;
    }

    public static Bundle appendInt(Bundle bundle, String str, int i11) {
        bundle.putInt(str, i11);
        return bundle;
    }

    public static Bundle appendLong(Bundle bundle, String str, long j11) {
        bundle.putLong(str, j11);
        return bundle;
    }

    public static Bundle appendString(Bundle bundle, String str, String str2) {
        bundle.putString(str, str2);
        return bundle;
    }

    public static Bundle getBundle() {
        return new Bundle();
    }
}
