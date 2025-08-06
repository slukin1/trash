package com.xiaomi.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hx;
import com.xiaomi.push.ih;
import com.xiaomi.push.service.af;

public class hq {
    public static <T extends hr<T, ?>> byte[] a(T t11) {
        if (t11 == null) {
            return null;
        }
        try {
            return new hw(new hx.a()).a(t11);
        } catch (hv e11) {
            b.a("convertThriftObjectToBytes catch TException.", (Throwable) e11);
            return null;
        }
    }

    public static <T extends hr<T, ?>> void a(T t11, byte[] bArr) {
        if (bArr != null) {
            new hu(new ih.a(true, true, bArr.length)).a(t11, bArr);
            return;
        }
        throw new hv("the message byte is empty.");
    }

    public static short a(Context context, hc hcVar) {
        gt a11 = hcVar.a();
        return a(context, hcVar.f3069b, (a11 == null || a11.a() == null) ? null : (String) a11.a().get(MessageKey.MSG_CHANNEL_ID));
    }

    public static short a(Context context, String str) {
        return a(context, str, (String) null);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static short m2859a(Context context, String str, String str2) {
        int i11 = 0;
        int a11 = g.a(context, str, false).a() + 0 + (ae.b(context) ? 4 : 0) + (ae.a(context) ? 8 : 0);
        if (af.a(context)) {
            i11 = 16;
        }
        return (short) (a11 + i11 + a(context, str, str2));
    }

    private static int a(Context context, String str, String str2) {
        af a11;
        NotificationChannel a12;
        if (Build.VERSION.SDK_INT < 26 || context == null || TextUtils.isEmpty(str) || (a11 = af.a(context, str)) == null || (a12 = a11.a(a11.a(str2))) == null) {
            return 0;
        }
        return a12.getImportance() != 0 ? 32 : 64;
    }
}
