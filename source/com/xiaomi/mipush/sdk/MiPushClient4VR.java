package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.hf;
import com.xiaomi.push.service.aj;

public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        hf hfVar = new hf();
        hfVar.c(gq.VRUpload.f2942a);
        hfVar.b(b.a(context).a());
        hfVar.d(context.getPackageName());
        hfVar.a("data", str);
        hfVar.a(aj.a());
        u.a(context).a(hfVar, gg.Notification, (gt) null);
    }
}
