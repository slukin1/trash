package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.ao;
import com.xiaomi.push.ct;
import com.xiaomi.push.es;
import com.xiaomi.push.fb;
import com.xiaomi.push.fj;
import com.xiaomi.push.fp;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gv;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hv;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.ay;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

final class w {
    public static void a(XMPushService xMPushService) {
        p a11 = q.a(xMPushService.getApplicationContext());
        if (a11 != null) {
            am.b a12 = q.a(xMPushService.getApplicationContext()).a(xMPushService);
            b.a("prepare account. " + a12.f3343a);
            a(xMPushService, a12);
            am.a().a(a12);
            a(xMPushService, a11, 172800);
        }
    }

    public static <T extends hr<T, ?>> hc b(String str, String str2, T t11, gg ggVar) {
        return a(str, str2, t11, ggVar, false);
    }

    public static hc b(String str, String str2) {
        hf hfVar = new hf();
        hfVar.b(str2);
        hfVar.c(gq.AppDataCleared.f2942a);
        hfVar.a(aj.a());
        hfVar.a(false);
        return a(str, str2, hfVar, gg.Notification);
    }

    private static void a(XMPushService xMPushService, p pVar, int i11) {
        final XMPushService xMPushService2 = xMPushService;
        final p pVar2 = pVar;
        ay.a((Context) xMPushService).a((ay.a) new ay.a("MSAID", (long) i11) {
            public void a(ay ayVar) {
                ao a11 = ao.a((Context) xMPushService2);
                String a12 = ayVar.a("MSAID", "msaid");
                String a13 = a11.a();
                if (!TextUtils.isEmpty(a13) && !TextUtils.equals(a12, a13)) {
                    ayVar.a("MSAID", "msaid", a13);
                    hf hfVar = new hf();
                    hfVar.b(pVar2.f52581d);
                    hfVar.c(gq.ClientInfoUpdate.f2942a);
                    hfVar.a(aj.a());
                    hfVar.a((Map<String, String>) new HashMap());
                    a11.a((Map<String, String>) hfVar.a());
                    byte[] a14 = hq.a(w.a(xMPushService2.getPackageName(), pVar2.f52581d, hfVar, gg.Notification));
                    XMPushService xMPushService = xMPushService2;
                    xMPushService.a(xMPushService.getPackageName(), a14, true);
                }
            }
        });
    }

    private static String a(hc hcVar) {
        Map<String, String> map;
        gt gtVar = hcVar.f3063a;
        if (!(gtVar == null || (map = gtVar.f2981b) == null)) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hcVar.f3069b;
    }

    public static es a(p pVar, Context context, hc hcVar) {
        try {
            es esVar = new es();
            esVar.a(5);
            esVar.c(pVar.f3412a);
            esVar.b(a(hcVar));
            esVar.a("SECMSG", "message");
            String str = pVar.f3412a;
            hcVar.f3064a.f2991a = str.substring(0, str.indexOf(TIMMentionEditText.TIM_MENTION_TAG));
            hcVar.f3064a.f2995c = str.substring(str.indexOf("/") + 1);
            esVar.a(hq.a(hcVar), pVar.f52580c);
            esVar.a(1);
            b.a("try send mi push message. packagename:" + hcVar.f3069b + " action:" + hcVar.f3062a);
            return esVar;
        } catch (NullPointerException e11) {
            b.a((Throwable) e11);
            return null;
        }
    }

    public static es a(XMPushService xMPushService, byte[] bArr) {
        hc hcVar = new hc();
        try {
            hq.a(hcVar, bArr);
            return a(q.a((Context) xMPushService), (Context) xMPushService, hcVar);
        } catch (hv e11) {
            b.a((Throwable) e11);
            return null;
        }
    }

    public static <T extends hr<T, ?>> hc a(String str, String str2, T t11, gg ggVar) {
        return a(str, str2, t11, ggVar, true);
    }

    private static <T extends hr<T, ?>> hc a(String str, String str2, T t11, gg ggVar, boolean z11) {
        byte[] a11 = hq.a(t11);
        hc hcVar = new hc();
        gv gvVar = new gv();
        gvVar.f2990a = 5;
        gvVar.f2991a = "fakeid";
        hcVar.a(gvVar);
        hcVar.a(ByteBuffer.wrap(a11));
        hcVar.a(ggVar);
        hcVar.b(z11);
        hcVar.b(str);
        hcVar.a(false);
        hcVar.a(str2);
        return hcVar;
    }

    public static hc a(String str, String str2) {
        hf hfVar = new hf();
        hfVar.b(str2);
        hfVar.c("package uninstalled");
        hfVar.a(fp.i());
        hfVar.a(false);
        return a(str, str2, hfVar, gg.Notification);
    }

    public static void a(final XMPushService xMPushService, am.b bVar) {
        bVar.a((Messenger) null);
        bVar.a((am.b.a) new am.b.a() {
            public void a(am.c cVar, am.c cVar2, int i11) {
                if (cVar2 == am.c.binded) {
                    t.a(xMPushService, true);
                    t.a(xMPushService);
                } else if (cVar2 == am.c.unbind) {
                    b.a("onChange unbind");
                    t.a(xMPushService, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
                }
            }
        });
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        ct.a(str, xMPushService.getApplicationContext(), bArr);
        fb a11 = xMPushService.a();
        if (a11 == null) {
            throw new fj("try send msg while connection is null.");
        } else if (a11.a()) {
            es a12 = a(xMPushService, bArr);
            if (a12 != null) {
                a11.b(a12);
            } else {
                t.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
            }
        } else {
            throw new fj("Don't support XMPP connection.");
        }
    }

    public static void a(XMPushService xMPushService, hc hcVar) {
        ct.a(hcVar.b(), xMPushService.getApplicationContext(), hcVar, -1);
        fb a11 = xMPushService.a();
        if (a11 == null) {
            throw new fj("try send msg while connection is null.");
        } else if (a11.a()) {
            es a12 = a(q.a((Context) xMPushService), (Context) xMPushService, hcVar);
            if (a12 != null) {
                a11.b(a12);
            }
        } else {
            throw new fj("Don't support XMPP connection.");
        }
    }

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }
}
