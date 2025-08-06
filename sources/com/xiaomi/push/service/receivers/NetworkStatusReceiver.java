package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.p;
import com.xiaomi.mipush.sdk.u;
import com.xiaomi.mipush.sdk.v;
import com.xiaomi.push.av;
import com.xiaomi.push.ga;
import com.xiaomi.push.m;
import com.xiaomi.push.service.ServiceClient;

public class NetworkStatusReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f52588a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f52589b;

    public NetworkStatusReceiver() {
        this.f52589b = false;
        this.f52589b = true;
    }

    public void onReceive(final Context context, Intent intent) {
        if (!this.f52589b) {
            av.a();
            m.a().post(new Runnable() {
                public void run() {
                    NetworkStatusReceiver.this.a(context);
                }
            });
        }
    }

    public static boolean a() {
        return f52588a;
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        if (!u.a(context).a() && b.a(context).c() && !b.a(context).f()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                ServiceClient.getInstance(context).startServiceSafely(intent);
            } catch (Exception e11) {
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
            }
        }
        ga.a(context);
        if (av.a(context) && u.a(context).b()) {
            u.a(context).c();
        }
        if (av.a(context)) {
            if ("syncing".equals(p.a(context).a(v.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(p.a(context).a(v.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            p a11 = p.a(context);
            v vVar = v.UPLOAD_HUAWEI_TOKEN;
            if ("syncing".equals(a11.a(vVar))) {
                u.a(context).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            if ("syncing".equals(p.a(context).a(v.UPLOAD_FCM_TOKEN))) {
                u.a(context).a((String) null, vVar, d.ASSEMBLE_PUSH_HUAWEI, "net");
            }
            p a12 = p.a(context);
            v vVar2 = v.UPLOAD_COS_TOKEN;
            if ("syncing".equals(a12.a(vVar2))) {
                u.a(context).a((String) null, vVar2, d.ASSEMBLE_PUSH_COS, "net");
            }
            p a13 = p.a(context);
            v vVar3 = v.UPLOAD_FTOS_TOKEN;
            if ("syncing".equals(a13.a(vVar3))) {
                u.a(context).a((String) null, vVar3, d.ASSEMBLE_PUSH_FTOS, "net");
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }

    public NetworkStatusReceiver(Object obj) {
        this.f52589b = false;
        f52588a = true;
    }
}
