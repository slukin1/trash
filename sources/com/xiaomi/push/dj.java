package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.xiaomi.push.service.ah;

public class dj {
    public static byte[] a(String str, byte[] bArr) {
        byte[] a11 = az.a(str);
        try {
            a(a11);
            return h.a(a11, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] a11 = az.a(str);
        try {
            a(a11);
            return h.b(a11, bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j11) {
        if (!ah.a(context).a(gl.DCJobMutualSwitch.a(), false)) {
            return false;
        }
        if ((Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ad.a(context, str, j11)) {
            return true;
        }
        return false;
    }
}
