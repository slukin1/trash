package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ew;

class et {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f51750a = Log.isLoggable("BCompressed", 3);

    public static byte[] a(es esVar, byte[] bArr) {
        try {
            byte[] a11 = ew.a.a(bArr);
            if (f51750a) {
                b.a("BCompressed", "decompress " + bArr.length + " to " + a11.length + " for " + esVar);
                if (esVar.f2807a == 1) {
                    b.a("BCompressed", "decompress not support upStream");
                }
            }
            return a11;
        } catch (Exception e11) {
            b.a("BCompressed", "decompress error " + e11);
            return bArr;
        }
    }
}
