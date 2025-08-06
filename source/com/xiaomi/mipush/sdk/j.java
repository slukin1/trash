package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import java.util.HashMap;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static volatile j f51321a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f2469a;

    private j(Context context) {
        this.f2469a = context.getApplicationContext();
    }

    private static j a(Context context) {
        if (f51321a == null) {
            synchronized (j.class) {
                if (f51321a == null) {
                    f51321a = new j(context);
                }
            }
        }
        return f51321a;
    }

    public static void b(Context context, hc hcVar, Intent intent, boolean z11) {
        a(context).a(hcVar, intent, 2, z11);
    }

    public static void c(Context context, hc hcVar, Intent intent, boolean z11) {
        a(context).a(hcVar, intent, 3, z11);
    }

    public static void d(Context context, hc hcVar, Intent intent, boolean z11) {
        a(context).a(hcVar, intent, 4, z11);
    }

    public static void e(Context context, hc hcVar, Intent intent, boolean z11) {
        a(context).a(hcVar, intent, 8, z11);
    }

    public static void f(Context context, hc hcVar, Intent intent, boolean z11) {
        b a11 = b.a(context);
        if (TextUtils.isEmpty(a11.c()) || TextUtils.isEmpty(a11.d())) {
            a(context).a(hcVar, intent, 6, z11);
        } else if (a11.f()) {
            a(context).a(hcVar, intent, 7, z11);
        } else {
            a(context).a(hcVar, intent, 5, z11);
        }
    }

    public static void a(Context context, hc hcVar, Intent intent, boolean z11) {
        a(context).a(hcVar, intent, 1, z11);
    }

    public static void a(Context context, hc hcVar, Intent intent, long j11) {
        a(context).a(hcVar, intent, 0, true, j11);
    }

    private void a(hc hcVar, Intent intent, int i11, boolean z11) {
        a(hcVar, intent, i11, z11, System.currentTimeMillis());
    }

    private void a(hc hcVar, Intent intent, int i11, boolean z11, long j11) {
        hc hcVar2 = hcVar;
        Intent intent2 = intent;
        if (!com.xiaomi.push.j.a(this.f2469a) && com.xiaomi.push.j.a() && hcVar2 != null && hcVar2.f3062a == gg.SendMessage && hcVar.a() != null && z11) {
            b.a("click to start activity result:" + String.valueOf(i11));
            hf hfVar = new hf(hcVar.a().a(), false);
            hfVar.c(gq.SDK_START_ACTIVITY.f2942a);
            hfVar.b(hcVar.a());
            hfVar.d(hcVar2.f3069b);
            HashMap hashMap = new HashMap();
            hfVar.f3081a = hashMap;
            hashMap.put("result", String.valueOf(i11));
            hfVar.f3081a.put(CrashHianalyticsData.TIME, String.valueOf(j11));
            hfVar.f3081a.put("sdk_vc", String.valueOf(60001));
            if (intent2 != null) {
                long longExtra = intent2.getLongExtra("nca_create_time", 0);
                if (longExtra > 0) {
                    hfVar.f3081a.put("nca_create_time", String.valueOf(longExtra));
                }
                long longExtra2 = intent2.getLongExtra("nca_resume_time", 0);
                if (longExtra2 > 0) {
                    hfVar.f3081a.put("nca_resume_time", String.valueOf(longExtra2));
                }
                long longExtra3 = intent2.getLongExtra("pmh_handle_time", 0);
                if (longExtra3 > 0) {
                    hfVar.f3081a.put("pmh_handle_time", String.valueOf(longExtra3));
                }
            }
            u.a(this.f2469a).a(hfVar, gg.Notification, false, false, (gt) null, true, hcVar2.f3069b, hcVar2.f3065a, true, false);
        }
    }
}
