package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.af;
import com.xiaomi.push.gg;
import com.xiaomi.push.gm;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gy;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;

public class o extends af.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f51326a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f2473a = false;

    public o(Context context) {
        this.f51326a = context;
    }

    public String a() {
        return "2";
    }

    public void run() {
        ah a11 = ah.a(this.f51326a);
        gy gyVar = new gy();
        if (this.f2473a) {
            gyVar.a(0);
            gyVar.b(0);
        } else {
            gyVar.a(ai.a(a11, gm.MISC_CONFIG));
            gyVar.b(ai.a(a11, gm.PLUGIN_CONFIG));
        }
        hf hfVar = new hf("-1", false);
        hfVar.c(gq.DailyCheckClientConfig.f2942a);
        hfVar.a(hq.a(gyVar));
        b.b("OcVersionCheckJob", "-->check version: checkMessage=", gyVar);
        u.a(this.f51326a).a(hfVar, gg.Notification, (gt) null);
    }
}
