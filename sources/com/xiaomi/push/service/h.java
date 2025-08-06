package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.es;
import com.xiaomi.push.fn;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.fr;
import com.xiaomi.push.j;
import com.xiaomi.push.service.am;
import java.util.Collection;
import java.util.Iterator;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private u f52556a = new u();

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.service_started");
            if (j.c()) {
                intent.addFlags(16777216);
            }
            b.a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
            intent.setPackage("com.android.mms");
            context.sendBroadcast(intent);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, am.b bVar, boolean z11, int i11, String str) {
        if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equalsIgnoreCase(bVar.f52470g)) {
            this.f52556a.a(context, bVar, z11, i11, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f3343a);
        intent.putExtra("ext_succeeded", z11);
        if (!z11) {
            intent.putExtra("ext_reason", i11);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f52470g);
        intent.putExtra(an.f52503t, bVar.f3346b);
        intent.putExtra(an.K, bVar.f52472i);
        b.a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", new Object[]{bVar.f52470g, bVar.f3343a, Boolean.valueOf(z11), Integer.valueOf(i11)}));
        a(context, intent, bVar);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, am.b bVar, int i11) {
        if (!BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equalsIgnoreCase(bVar.f52470g)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.f3343a);
            intent.putExtra(an.f52506w, bVar.f52470g);
            intent.putExtra("ext_reason", i11);
            intent.putExtra(an.f52503t, bVar.f3346b);
            intent.putExtra(an.K, bVar.f52472i);
            if (bVar.f3337a == null || !"9".equals(bVar.f52470g)) {
                b.a(String.format("[Bcst] notify channel closed. %s,%s,%d", new Object[]{bVar.f52470g, bVar.f3343a, Integer.valueOf(i11)}));
                a(context, intent, bVar);
                return;
            }
            try {
                bVar.f3337a.send(Message.obtain((Handler) null, 17, intent));
            } catch (RemoteException unused) {
                bVar.f3337a = null;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("peer may died: ");
                String str = bVar.f3346b;
                sb2.append(str.substring(str.lastIndexOf(64)));
                b.a(sb2.toString());
            }
        }
    }

    public void a(XMPushService xMPushService, String str, fp fpVar) {
        String str2;
        am.b a11 = a(fpVar);
        if (a11 == null) {
            b.d("error while notify channel closed! channel " + str + " not registered");
        } else if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equalsIgnoreCase(str)) {
            this.f52556a.a(xMPushService, fpVar, a11);
        } else {
            String str3 = a11.f3343a;
            if (fpVar instanceof fo) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (fpVar instanceof fn) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (fpVar instanceof fr) {
                str2 = "com.xiaomi.push.new_pres";
            } else {
                b.d("unknown packet type, drop it");
                return;
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", fpVar.a());
            intent.putExtra(an.K, a11.f52472i);
            intent.putExtra(an.C, a11.f52471h);
            b.a(String.format("[Bcst] notify packet arrival. %s,%s,%s", new Object[]{a11.f52470g, a11.f3343a, fpVar.j()}));
            if ("3".equalsIgnoreCase(str)) {
                intent.putExtra(an.f52507x, fpVar.f2874a);
                intent.putExtra(an.f52508y, System.currentTimeMillis());
            }
            a((Context) xMPushService, intent, a11);
        }
    }

    public void a(XMPushService xMPushService, String str, es esVar) {
        am.b a11 = a(esVar);
        if (a11 == null) {
            b.d("error while notify channel closed! channel " + str + " not registered");
        } else if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equalsIgnoreCase(str)) {
            this.f52556a.a(xMPushService, esVar, a11);
        } else {
            String str2 = a11.f3343a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", esVar.a(a11.f52471h));
            intent.putExtra(an.K, a11.f52472i);
            intent.putExtra(an.C, a11.f52471h);
            if (e.a(esVar)) {
                intent.putExtra("ext_downward_pkt_id", esVar.e());
            }
            if (a11.f3337a != null) {
                try {
                    a11.f3337a.send(Message.obtain((Handler) null, 17, intent));
                    b.a("message was sent by messenger for chid=" + str);
                    return;
                } catch (RemoteException unused) {
                    a11.f3337a = null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("peer may died: ");
                    String str3 = a11.f3346b;
                    sb2.append(str3.substring(str3.lastIndexOf(64)));
                    b.a(sb2.toString());
                }
            }
            if (!"com.xiaomi.xmsf".equals(str2)) {
                b.a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", new Object[]{a11.f52470g, a11.f3343a, esVar.e()}));
                if (e.a(esVar)) {
                    at.a().a(esVar.e(), SystemClock.elapsedRealtime());
                }
                a((Context) xMPushService, intent, a11);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xiaomi.push.service.am.b a(com.xiaomi.push.fp r6) {
        /*
            r5 = this;
            com.xiaomi.push.service.am r0 = com.xiaomi.push.service.am.a()
            java.lang.String r1 = r6.k()
            java.util.Collection r0 = r0.a((java.lang.String) r1)
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 == 0) goto L_0x0014
            return r2
        L_0x0014:
            java.util.Iterator r1 = r0.iterator()
            int r0 = r0.size()
            r3 = 1
            if (r0 != r3) goto L_0x0026
            java.lang.Object r6 = r1.next()
            com.xiaomi.push.service.am$b r6 = (com.xiaomi.push.service.am.b) r6
            return r6
        L_0x0026:
            java.lang.String r0 = r6.m()
            java.lang.String r6 = r6.l()
        L_0x002e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x004b
            java.lang.Object r3 = r1.next()
            com.xiaomi.push.service.am$b r3 = (com.xiaomi.push.service.am.b) r3
            java.lang.String r4 = r3.f3346b
            boolean r4 = android.text.TextUtils.equals(r0, r4)
            if (r4 != 0) goto L_0x004a
            java.lang.String r4 = r3.f3346b
            boolean r4 = android.text.TextUtils.equals(r6, r4)
            if (r4 == 0) goto L_0x002e
        L_0x004a:
            return r3
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.h.a(com.xiaomi.push.fp):com.xiaomi.push.service.am$b");
    }

    public am.b a(es esVar) {
        Collection a11 = am.a().a(Integer.toString(esVar.a()));
        if (a11.isEmpty()) {
            return null;
        }
        Iterator it2 = a11.iterator();
        if (a11.size() == 1) {
            return (am.b) it2.next();
        }
        String g11 = esVar.g();
        while (it2.hasNext()) {
            am.b bVar = (am.b) it2.next();
            if (TextUtils.equals(g11, bVar.f3346b)) {
                return bVar;
            }
        }
        return null;
    }

    public void a(Context context, am.b bVar, String str, String str2) {
        if (bVar == null) {
            b.d("error while notify kick by server!");
        } else if (BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC.equalsIgnoreCase(bVar.f52470g)) {
            b.d("mipush kicked by server");
        } else {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.kicked");
            intent.setPackage(bVar.f3343a);
            intent.putExtra("ext_kick_type", str);
            intent.putExtra("ext_kick_reason", str2);
            intent.putExtra("ext_chid", bVar.f52470g);
            intent.putExtra(an.f52503t, bVar.f3346b);
            intent.putExtra(an.K, bVar.f52472i);
            b.a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", new Object[]{bVar.f52470g, bVar.f3343a, str2}));
            a(context, intent, bVar);
        }
    }

    private static void a(Context context, Intent intent, am.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public static String a(am.b bVar) {
        if (!"9".equals(bVar.f52470g)) {
            return bVar.f3343a + ".permission.MIPUSH_RECEIVE";
        }
        return bVar.f3343a + ".permission.MIMC_RECEIVE";
    }
}
