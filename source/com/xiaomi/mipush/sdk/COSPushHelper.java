package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;

public class COSPushHelper {

    /* renamed from: a  reason: collision with root package name */
    private static long f51277a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f2426a = false;

    public static void convertMessage(Intent intent) {
        f.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j11 = f51277a;
            if (j11 <= 0 || j11 + 300000 <= elapsedRealtime) {
                f51277a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f2426a;
    }

    public static boolean hasNetwork(Context context) {
        return f.a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager a11 = e.a(context).a(d.ASSEMBLE_PUSH_COS);
        if (a11 != null) {
            b.a("ASSEMBLE_PUSH :  register cos when network change!");
            a11.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z11) {
        synchronized (COSPushHelper.class) {
            f2426a = z11;
        }
    }

    public static void uploadToken(Context context, String str) {
        f.a(context, d.ASSEMBLE_PUSH_COS, str);
    }
}
