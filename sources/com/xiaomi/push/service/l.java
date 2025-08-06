package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;
import com.xiaomi.push.h;
import com.xiaomi.push.hc;
import com.xiaomi.push.hh;
import com.xiaomi.push.hq;
import com.xiaomi.push.hv;

public class l {
    public static void a(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
            String stringExtra2 = intent.getStringExtra("mipush_app_package");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                try {
                    byte[] b11 = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, (String) null));
                    if (b11 != null) {
                        x.a(context, u.a(b11), b11);
                    } else {
                        b.a("notify fcm notification error ：dencrypt failed");
                    }
                } catch (Throwable th2) {
                    b.a("notify fcm notification error ", th2);
                }
            }
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            b.a("secret is empty, return null");
            return null;
        }
        try {
            return h.a(az.a(str), bArr);
        } catch (Exception e11) {
            b.a("dencryption error. ", (Throwable) e11);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            b.a("secret is empty, return null");
            return null;
        }
        try {
            return h.b(az.a(str), bArr);
        } catch (Exception e11) {
            b.a("encryption error. ", (Throwable) e11);
            return null;
        }
    }

    public static hh a(hc hcVar) {
        byte[] a11 = hcVar.a();
        hh hhVar = new hh();
        try {
            hq.a(hhVar, a11);
            return hhVar;
        } catch (hv unused) {
            return null;
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
        }
    }
}
