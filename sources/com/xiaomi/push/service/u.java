package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.du;
import com.xiaomi.push.es;
import com.xiaomi.push.fj;
import com.xiaomi.push.fm;
import com.xiaomi.push.fo;
import com.xiaomi.push.fp;
import com.xiaomi.push.g;
import com.xiaomi.push.ga;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.hc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hq;
import com.xiaomi.push.j;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.x;
import e7.s;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class u {
    private static void b(Context context, hc hcVar, byte[] bArr) {
        if (!x.a(hcVar)) {
            String a11 = x.a(hcVar);
            if (!TextUtils.isEmpty(a11) && !a(context, a11, bArr)) {
                du.a(context).b(a11, x.b(hcVar), hcVar.a().a(), "1");
            }
        }
    }

    private static boolean c(hc hcVar) {
        if (hcVar.a() == null || hcVar.a().a() == null) {
            return false;
        }
        return "1".equals(hcVar.a().a().get("obslete_ads_message"));
    }

    private static void d(final XMPushService xMPushService, final hc hcVar) {
        xMPushService.a((XMPushService.j) new XMPushService.j(4) {
            public String a() {
                return "send ack message for unrecognized new miui message.";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3049a() {
                try {
                    hc a11 = u.a((Context) xMPushService, hcVar);
                    a11.a().a("miui_message_unrecognized", "1");
                    w.a(xMPushService, a11);
                } catch (fj e11) {
                    b.a((Throwable) e11);
                    xMPushService.a(10, (Exception) e11);
                }
            }
        });
    }

    public void a(Context context, am.b bVar, boolean z11, int i11, String str) {
        p a11;
        if (!z11 && (a11 = q.a(context)) != null && "token-expired".equals(str)) {
            q.a(context, a11.f52583f, a11.f52581d, a11.f52582e);
        }
    }

    private static void c(final XMPushService xMPushService, final hc hcVar) {
        xMPushService.a((XMPushService.j) new XMPushService.j(4) {
            public String a() {
                return "send ack message for obsleted message.";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3048a() {
                try {
                    hc a11 = u.a((Context) xMPushService, hcVar);
                    a11.a().a("message_obsleted", "1");
                    w.a(xMPushService, a11);
                } catch (fj e11) {
                    b.a((Throwable) e11);
                    xMPushService.a(10, (Exception) e11);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, fp fpVar, am.b bVar) {
        if (fpVar instanceof fo) {
            fo foVar = (fo) fpVar;
            fm a11 = foVar.a(s.f70071a);
            if (a11 != null) {
                try {
                    a(xMPushService, ar.a(ar.a(bVar.f52471h, foVar.j()), a11.c()), (long) ga.a(fpVar.a()));
                } catch (IllegalArgumentException e11) {
                    b.a((Throwable) e11);
                }
            }
        } else {
            b.a("not a mipush message");
        }
    }

    private static boolean b(hc hcVar) {
        Map a11 = hcVar.a().a();
        return a11 != null && a11.containsKey("notify_effect");
    }

    private static void b(final XMPushService xMPushService, final hc hcVar) {
        xMPushService.a((XMPushService.j) new XMPushService.j(4) {
            public String a() {
                return "send ack message for message.";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3047a() {
                Map<String, String> map = null;
                try {
                    if (j.a((Context) xMPushService)) {
                        try {
                            map = v.a((Context) xMPushService, hcVar);
                        } catch (Throwable th2) {
                            b.d("error creating params for ack message :" + th2);
                        }
                    }
                    w.a(xMPushService, u.a((Context) xMPushService, hcVar, map));
                } catch (fj e11) {
                    b.d("error sending ack message :" + e11);
                    xMPushService.a(10, (Exception) e11);
                }
            }
        });
    }

    public void a(XMPushService xMPushService, es esVar, am.b bVar) {
        try {
            byte[] a11 = esVar.a(bVar.f52471h);
            HashMap hashMap = null;
            if (e.b(esVar)) {
                hashMap = new HashMap();
                hashMap.put("t_im", String.valueOf(esVar.b()));
                hashMap.put("t_rt", String.valueOf(esVar.a()));
            }
            a(xMPushService, a11, (long) esVar.c(), (Map<String, String>) hashMap);
        } catch (IllegalArgumentException e11) {
            b.a((Throwable) e11);
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j11) {
        a(xMPushService, bArr, j11, (Map<String, String>) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.xiaomi.push.service.XMPushService r19, byte[] r20, long r21, java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
            r9 = r19
            com.xiaomi.push.hc r0 = a((byte[]) r20)
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = r0.f3069b
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0017
            java.lang.String r0 = "receive a mipush message without package name"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            return
        L_0x0017:
            com.xiaomi.push.gt r10 = r0.a()
            r11 = 1
            r12 = 0
            if (r10 == 0) goto L_0x006c
            if (r23 == 0) goto L_0x006c
            boolean r1 = r23.isEmpty()
            if (r1 != 0) goto L_0x006c
            java.util.Map r1 = r10.a()
            if (r1 == 0) goto L_0x006c
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x006c
            java.util.Set r2 = r23.entrySet()
            java.util.Iterator r2 = r2.iterator()
            r3 = r12
        L_0x003c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x005f
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            boolean r5 = r1.containsKey(r5)
            if (r5 == 0) goto L_0x003c
            java.lang.Object r3 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r1.put(r3, r4)
            r3 = r11
            goto L_0x003c
        L_0x005f:
            if (r3 == 0) goto L_0x006c
            byte[] r1 = com.xiaomi.push.hq.a(r0)
            if (r1 == 0) goto L_0x006c
            int r2 = r1.length
            if (r2 <= 0) goto L_0x006c
            r13 = r1
            goto L_0x006e
        L_0x006c:
            r13 = r20
        L_0x006e:
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r14 = java.lang.Long.valueOf(r1)
            long r1 = r14.longValue()
            android.content.Intent r15 = a((byte[]) r13, (long) r1)
            java.lang.String r7 = com.xiaomi.push.service.x.a((com.xiaomi.push.hc) r0)
            r5 = 1
            r6 = 1
            long r16 = java.lang.System.currentTimeMillis()
            r1 = r19
            r2 = r7
            r3 = r21
            r18 = r7
            r7 = r16
            com.xiaomi.push.ga.a(r1, r2, r3, r5, r6, r7)
            if (r10 == 0) goto L_0x00bf
            java.lang.String r1 = r10.a()
            if (r1 == 0) goto L_0x00bf
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r0.a()
            r1[r12] = r2
            java.lang.String r2 = r10.a()
            java.lang.String r2 = com.xiaomi.push.service.aj.a(r2)
            r1[r11] = r2
            r2 = 2
            com.xiaomi.push.gg r3 = r0.a()
            r1[r2] = r3
            java.lang.String r2 = "receive a message. appid=%1$s, msgid= %2$s, action=%3$s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            com.xiaomi.channel.commonutils.logger.b.e(r1)
        L_0x00bf:
            if (r10 == 0) goto L_0x00ce
            long r1 = r14.longValue()
            java.lang.String r1 = java.lang.Long.toString(r1)
            java.lang.String r2 = "mrt"
            r10.a(r2, r1)
        L_0x00ce:
            com.xiaomi.push.gg r1 = com.xiaomi.push.gg.SendMessage
            com.xiaomi.push.gg r2 = r0.a()
            java.lang.String r3 = ""
            if (r1 != r2) goto L_0x0125
            com.xiaomi.push.service.r r2 = com.xiaomi.push.service.r.a((android.content.Context) r19)
            java.lang.String r4 = r0.f3069b
            boolean r2 = r2.a((java.lang.String) r4)
            if (r2 == 0) goto L_0x0125
            boolean r2 = com.xiaomi.push.service.x.a((com.xiaomi.push.hc) r0)
            if (r2 != 0) goto L_0x0125
            if (r10 == 0) goto L_0x010b
            java.lang.String r3 = r10.a()
            boolean r1 = com.xiaomi.push.service.x.e(r0)
            if (r1 == 0) goto L_0x010b
            android.content.Context r1 = r19.getApplicationContext()
            com.xiaomi.push.du r1 = com.xiaomi.push.du.a((android.content.Context) r1)
            java.lang.String r2 = r0.b()
            java.lang.String r4 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r0)
            java.lang.String r5 = "1"
            r1.a((java.lang.String) r2, (java.lang.String) r4, (java.lang.String) r3, (java.lang.String) r5)
        L_0x010b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Drop a message for unregistered, msgid="
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)
            java.lang.String r1 = r0.f3069b
            a((com.xiaomi.push.service.XMPushService) r9, (com.xiaomi.push.hc) r0, (java.lang.String) r1)
            return
        L_0x0125:
            com.xiaomi.push.gg r2 = r0.a()
            if (r1 != r2) goto L_0x0178
            com.xiaomi.push.service.r r2 = com.xiaomi.push.service.r.a((android.content.Context) r19)
            java.lang.String r4 = r0.f3069b
            boolean r2 = r2.c((java.lang.String) r4)
            if (r2 == 0) goto L_0x0178
            boolean r2 = com.xiaomi.push.service.x.a((com.xiaomi.push.hc) r0)
            if (r2 != 0) goto L_0x0178
            if (r10 == 0) goto L_0x015e
            java.lang.String r3 = r10.a()
            boolean r1 = com.xiaomi.push.service.x.e(r0)
            if (r1 == 0) goto L_0x015e
            android.content.Context r1 = r19.getApplicationContext()
            com.xiaomi.push.du r1 = com.xiaomi.push.du.a((android.content.Context) r1)
            java.lang.String r2 = r0.b()
            java.lang.String r4 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r0)
            java.lang.String r5 = "2"
            r1.a((java.lang.String) r2, (java.lang.String) r4, (java.lang.String) r3, (java.lang.String) r5)
        L_0x015e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Drop a message for push closed, msgid="
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)
            java.lang.String r1 = r0.f3069b
            a((com.xiaomi.push.service.XMPushService) r9, (com.xiaomi.push.hc) r0, (java.lang.String) r1)
            return
        L_0x0178:
            com.xiaomi.push.gg r2 = r0.a()
            if (r1 != r2) goto L_0x01fe
            java.lang.String r2 = r19.getPackageName()
            java.lang.String r3 = "com.xiaomi.xmsf"
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 != 0) goto L_0x01fe
            java.lang.String r2 = r19.getPackageName()
            java.lang.String r3 = r0.f3069b
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 != 0) goto L_0x01fe
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Receive a message with wrong package name, expect "
            r1.append(r2)
            java.lang.String r2 = r19.getPackageName()
            r1.append(r2)
            java.lang.String r2 = ", received "
            r1.append(r2)
            java.lang.String r2 = r0.f3069b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "package should be "
            r1.append(r2)
            java.lang.String r2 = r19.getPackageName()
            r1.append(r2)
            java.lang.String r2 = ", but got "
            r1.append(r2)
            java.lang.String r2 = r0.f3069b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "unmatched_package"
            a((com.xiaomi.push.service.XMPushService) r9, (com.xiaomi.push.hc) r0, (java.lang.String) r2, (java.lang.String) r1)
            if (r10 == 0) goto L_0x01fd
            boolean r1 = com.xiaomi.push.service.x.e(r0)
            if (r1 == 0) goto L_0x01fd
            android.content.Context r1 = r19.getApplicationContext()
            com.xiaomi.push.du r1 = com.xiaomi.push.du.a((android.content.Context) r1)
            java.lang.String r2 = r0.b()
            java.lang.String r0 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r0)
            java.lang.String r3 = r10.a()
            java.lang.String r4 = "3"
            r1.a((java.lang.String) r2, (java.lang.String) r0, (java.lang.String) r3, (java.lang.String) r4)
        L_0x01fd:
            return
        L_0x01fe:
            com.xiaomi.push.gg r2 = r0.a()
            if (r1 != r2) goto L_0x0260
            int r1 = com.xiaomi.push.i.a()
            r2 = 999(0x3e7, float:1.4E-42)
            if (r1 != r2) goto L_0x0260
            r1 = r18
            boolean r2 = com.xiaomi.push.i.a((android.content.Context) r9, (java.lang.String) r1)
            if (r2 == 0) goto L_0x0262
            java.lang.String r2 = "Receive the uninstalled dual app message"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r2)
            java.lang.String r0 = r0.a()     // Catch:{ fj -> 0x023e }
            com.xiaomi.push.hc r0 = com.xiaomi.push.service.w.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ fj -> 0x023e }
            com.xiaomi.push.service.w.a((com.xiaomi.push.service.XMPushService) r9, (com.xiaomi.push.hc) r0)     // Catch:{ fj -> 0x023e }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ fj -> 0x023e }
            r0.<init>()     // Catch:{ fj -> 0x023e }
            java.lang.String r2 = "uninstall "
            r0.append(r2)     // Catch:{ fj -> 0x023e }
            r0.append(r1)     // Catch:{ fj -> 0x023e }
            java.lang.String r2 = " msg sent"
            r0.append(r2)     // Catch:{ fj -> 0x023e }
            java.lang.String r0 = r0.toString()     // Catch:{ fj -> 0x023e }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ fj -> 0x023e }
            goto L_0x025c
        L_0x023e:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Fail to send Message: "
            r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r2)
            r2 = 10
            r9.a((int) r2, (java.lang.Exception) r0)
        L_0x025c:
            com.xiaomi.push.service.x.a((android.content.Context) r9, (java.lang.String) r1)
            return
        L_0x0260:
            r1 = r18
        L_0x0262:
            if (r10 == 0) goto L_0x0284
            java.util.Map r2 = r10.a()
            if (r2 == 0) goto L_0x0284
            java.lang.String r3 = "hide"
            boolean r4 = r2.containsKey(r3)
            if (r4 == 0) goto L_0x0284
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "true"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0284
            b(r9, r0)
            return
        L_0x0284:
            a((com.xiaomi.push.service.XMPushService) r9, (java.lang.String) r1, (byte[]) r13, (android.content.Intent) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(com.xiaomi.push.service.XMPushService, byte[], long, java.util.Map):void");
    }

    public static Intent a(byte[] bArr, long j11) {
        hc a11 = a(bArr);
        if (a11 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j11));
        intent.setPackage(a11.f3069b);
        return intent;
    }

    public static hc a(byte[] bArr) {
        hc hcVar = new hc();
        try {
            hq.a(hcVar, bArr);
            return hcVar;
        } catch (Throwable th2) {
            b.a(th2);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [com.xiaomi.push.hr] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0448  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.xiaomi.push.service.XMPushService r19, java.lang.String r20, byte[] r21, android.content.Intent r22) {
        /*
            r1 = r19
            r0 = r21
            r2 = r22
            com.xiaomi.push.hc r3 = a((byte[]) r21)
            com.xiaomi.push.gt r4 = r3.a()
            r5 = 0
            if (r0 == 0) goto L_0x0021
            java.lang.String r6 = r3.b()
            android.content.Context r7 = r19.getApplicationContext()
            com.xiaomi.push.gg r8 = r3.a()
            int r9 = r0.length
            com.xiaomi.push.ct.a(r6, r7, r5, r8, r9)
        L_0x0021:
            boolean r6 = c(r3)
            if (r6 == 0) goto L_0x0051
            boolean r6 = a((android.content.Context) r19, (java.lang.String) r20)
            if (r6 == 0) goto L_0x0051
            boolean r0 = com.xiaomi.push.service.x.e(r3)
            if (r0 == 0) goto L_0x004c
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r2 = r3.b()
            java.lang.String r5 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r4 = r4.a()
            java.lang.String r6 = "5"
            r0.a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r4, (java.lang.String) r6)
        L_0x004c:
            c(r1, r3)
            goto L_0x04d5
        L_0x0051:
            boolean r6 = a((com.xiaomi.push.hc) r3)
            if (r6 == 0) goto L_0x0087
            boolean r6 = a((android.content.Context) r19, (java.lang.String) r20)
            if (r6 != 0) goto L_0x0087
            boolean r6 = b(r3)
            if (r6 != 0) goto L_0x0087
            boolean r0 = com.xiaomi.push.service.x.e(r3)
            if (r0 == 0) goto L_0x0082
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r2 = r3.b()
            java.lang.String r5 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r4 = r4.a()
            java.lang.String r6 = "6"
            r0.a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r4, (java.lang.String) r6)
        L_0x0082:
            d(r1, r3)
            goto L_0x04d5
        L_0x0087:
            boolean r6 = com.xiaomi.push.service.x.a((com.xiaomi.push.hc) r3)
            if (r6 == 0) goto L_0x0095
            java.lang.String r6 = r3.f3069b
            boolean r6 = com.xiaomi.push.g.c(r1, r6)
            if (r6 != 0) goto L_0x009b
        L_0x0095:
            boolean r6 = a((android.content.Context) r1, (android.content.Intent) r2)
            if (r6 == 0) goto L_0x0486
        L_0x009b:
            com.xiaomi.push.gg r6 = com.xiaomi.push.gg.Registration
            com.xiaomi.push.gg r7 = r3.a()
            java.lang.String r8 = "eventMessageType"
            java.lang.String r9 = "messageId"
            r10 = 0
            if (r6 != r7) goto L_0x011c
            java.lang.String r12 = r3.b()
            java.lang.String r6 = "pref_registered_pkg_names"
            android.content.SharedPreferences r6 = r1.getSharedPreferences(r6, r10)
            android.content.SharedPreferences$Editor r6 = r6.edit()
            java.lang.String r7 = r3.f3065a
            r6.putString(r12, r7)
            r6.commit()
            com.xiaomi.push.hh r6 = com.xiaomi.push.service.l.a(r3)
            long r13 = r6.a()
            r15 = 0
            int r7 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r7 != 0) goto L_0x00de
            java.lang.String r7 = r6.b()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00de
            java.lang.String r6 = r6.b()
            com.xiaomi.push.service.l.a(r1, r12, r6)
            goto L_0x00e3
        L_0x00de:
            java.lang.String r6 = "read regSecret failed"
            com.xiaomi.channel.commonutils.logger.b.d(r6)
        L_0x00e3:
            com.xiaomi.push.service.r r6 = com.xiaomi.push.service.r.a((android.content.Context) r19)
            r6.e(r12)
            com.xiaomi.push.service.r r6 = com.xiaomi.push.service.r.a((android.content.Context) r19)
            r6.f(r12)
            android.content.Context r6 = r19.getApplicationContext()
            com.xiaomi.push.du r11 = com.xiaomi.push.du.a((android.content.Context) r6)
            java.lang.String r14 = r4.a()
            r15 = 6003(0x1773, float:8.412E-42)
            r16 = 0
            java.lang.String r13 = "E100003"
            r11.a(r12, r13, r14, r15, r16)
            java.lang.String r6 = r4.a()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x011c
            java.lang.String r6 = r4.a()
            r2.putExtra(r9, r6)
            r6 = 6000(0x1770, float:8.408E-42)
            r2.putExtra(r8, r6)
        L_0x011c:
            boolean r6 = com.xiaomi.push.service.x.c((com.xiaomi.push.hc) r3)
            if (r6 == 0) goto L_0x0157
            android.content.Context r6 = r19.getApplicationContext()
            com.xiaomi.push.du r11 = com.xiaomi.push.du.a((android.content.Context) r6)
            java.lang.String r12 = r3.b()
            java.lang.String r13 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r14 = r4.a()
            r15 = 1001(0x3e9, float:1.403E-42)
            long r16 = java.lang.System.currentTimeMillis()
            r18 = 0
            r11.a(r12, r13, r14, r15, r16, r18)
            java.lang.String r6 = r4.a()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0157
            java.lang.String r6 = r4.a()
            r2.putExtra(r9, r6)
            r6 = 1000(0x3e8, float:1.401E-42)
            r2.putExtra(r8, r6)
        L_0x0157:
            boolean r6 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            if (r6 == 0) goto L_0x0192
            android.content.Context r6 = r19.getApplicationContext()
            com.xiaomi.push.du r11 = com.xiaomi.push.du.a((android.content.Context) r6)
            java.lang.String r12 = r3.b()
            java.lang.String r13 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r14 = r4.a()
            r15 = 2001(0x7d1, float:2.804E-42)
            long r16 = java.lang.System.currentTimeMillis()
            r18 = 0
            r11.a(r12, r13, r14, r15, r16, r18)
            java.lang.String r6 = r4.a()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0192
            java.lang.String r6 = r4.a()
            r2.putExtra(r9, r6)
            r6 = 2000(0x7d0, float:2.803E-42)
            r2.putExtra(r8, r6)
        L_0x0192:
            boolean r6 = com.xiaomi.push.service.x.a((com.xiaomi.push.hc) r3)
            if (r6 == 0) goto L_0x01cd
            android.content.Context r6 = r19.getApplicationContext()
            com.xiaomi.push.du r11 = com.xiaomi.push.du.a((android.content.Context) r6)
            java.lang.String r12 = r3.b()
            java.lang.String r13 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r14 = r4.a()
            r15 = 3001(0xbb9, float:4.205E-42)
            long r16 = java.lang.System.currentTimeMillis()
            r18 = 0
            r11.a(r12, r13, r14, r15, r16, r18)
            java.lang.String r6 = r4.a()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x01cd
            java.lang.String r6 = r4.a()
            r2.putExtra(r9, r6)
            r6 = 3000(0xbb8, float:4.204E-42)
            r2.putExtra(r8, r6)
        L_0x01cd:
            java.lang.String r6 = "com.xiaomi.xmsf"
            r7 = 1
            if (r4 == 0) goto L_0x0272
            java.lang.String r8 = r4.c()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0272
            java.lang.String r8 = r4.d()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0272
            int r8 = r4.f2979b
            if (r8 == r7) goto L_0x0272
            java.lang.String r8 = r3.f3069b
            java.util.Map r9 = r4.a()
            boolean r9 = com.xiaomi.push.service.x.a((java.util.Map<java.lang.String, java.lang.String>) r9)
            boolean r8 = com.xiaomi.push.service.x.a((android.content.Context) r1, (java.lang.String) r8, (boolean) r9)
            if (r8 == 0) goto L_0x01fc
            goto L_0x0272
        L_0x01fc:
            java.util.Map<java.lang.String, java.lang.String> r2 = r4.f2977a
            if (r2 == 0) goto L_0x0209
            java.lang.String r5 = "jobkey"
            java.lang.Object r2 = r2.get(r5)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
        L_0x0209:
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L_0x0213
            java.lang.String r5 = r4.a()
        L_0x0213:
            java.lang.String r2 = r3.f3069b
            boolean r2 = com.xiaomi.push.service.y.a(r1, r2, r5)
            if (r2 == 0) goto L_0x0258
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r2 = r3.b()
            java.lang.String r7 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r4 = r4.a()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "1:"
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            r0.c(r2, r7, r4, r8)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "drop a duplicate message, key="
            r0.append(r2)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            goto L_0x026d
        L_0x0258:
            boolean r2 = com.xiaomi.push.j.a((android.content.Context) r19)
            if (r2 == 0) goto L_0x026a
            boolean r2 = com.xiaomi.push.service.v.a((com.xiaomi.push.hc) r3)
            if (r2 == 0) goto L_0x026a
            java.lang.String r0 = "receive pull down message"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            goto L_0x026d
        L_0x026a:
            a((android.content.Context) r1, (com.xiaomi.push.hc) r3, (byte[]) r0)
        L_0x026d:
            b(r1, r3)
            goto L_0x0470
        L_0x0272:
            java.lang.String r0 = r3.f3069b
            boolean r0 = r6.contains(r0)
            if (r0 == 0) goto L_0x02b1
            boolean r0 = r3.b()
            if (r0 != 0) goto L_0x02b1
            if (r4 == 0) goto L_0x02b1
            java.util.Map r0 = r4.a()
            if (r0 == 0) goto L_0x02b1
            java.util.Map r0 = r4.a()
            java.lang.String r8 = "ab"
            boolean r0 = r0.containsKey(r8)
            if (r0 == 0) goto L_0x02b1
            b(r1, r3)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "receive abtest message. ack it."
            r0.append(r2)
            java.lang.String r2 = r4.a()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.c(r0)
            goto L_0x0470
        L_0x02b1:
            r0 = r20
            boolean r0 = a((com.xiaomi.push.service.XMPushService) r1, (java.lang.String) r0, (com.xiaomi.push.hc) r3, (com.xiaomi.push.gt) r4)
            if (r0 == 0) goto L_0x0457
            if (r4 == 0) goto L_0x0346
            java.lang.String r0 = r4.a()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0346
            boolean r0 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            if (r0 == 0) goto L_0x02e7
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r11 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r12 = r3.b()
            java.lang.String r13 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r14 = r4.a()
            r15 = 2002(0x7d2, float:2.805E-42)
            r16 = 0
            r11.a(r12, r13, r14, r15, r16)
            goto L_0x0346
        L_0x02e7:
            boolean r0 = com.xiaomi.push.service.x.a((com.xiaomi.push.hc) r3)
            if (r0 == 0) goto L_0x0307
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r8 = r3.b()
            java.lang.String r9 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r11 = r4.a()
            java.lang.String r12 = "7"
            r0.a((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r11, (java.lang.String) r12)
            goto L_0x0346
        L_0x0307:
            boolean r0 = com.xiaomi.push.service.x.c((com.xiaomi.push.hc) r3)
            if (r0 == 0) goto L_0x0327
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r8 = r3.b()
            java.lang.String r9 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r11 = r4.a()
            java.lang.String r12 = "8"
            r0.a((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r11, (java.lang.String) r12)
            goto L_0x0346
        L_0x0327:
            boolean r0 = com.xiaomi.push.service.x.d(r3)
            if (r0 == 0) goto L_0x0346
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r11 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r12 = r3.b()
            java.lang.String r14 = r4.a()
            r15 = 6004(0x1774, float:8.413E-42)
            r16 = 0
            java.lang.String r13 = "E100003"
            r11.a(r12, r13, r14, r15, r16)
        L_0x0346:
            com.xiaomi.push.gg r0 = com.xiaomi.push.gg.Notification
            com.xiaomi.push.gg r8 = r3.f3062a
            if (r0 != r8) goto L_0x0445
            com.xiaomi.push.hr r5 = com.xiaomi.push.service.bc.a((android.content.Context) r1, (com.xiaomi.push.hc) r3)     // Catch:{ hv -> 0x036b }
            if (r5 != 0) goto L_0x0369
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ hv -> 0x036b }
            r0.<init>()     // Catch:{ hv -> 0x036b }
            java.lang.String r8 = "receiving an un-recognized notification message. "
            r0.append(r8)     // Catch:{ hv -> 0x036b }
            com.xiaomi.push.gg r8 = r3.f3062a     // Catch:{ hv -> 0x036b }
            r0.append(r8)     // Catch:{ hv -> 0x036b }
            java.lang.String r0 = r0.toString()     // Catch:{ hv -> 0x036b }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ hv -> 0x036b }
            goto L_0x0380
        L_0x0369:
            r0 = r7
            goto L_0x0381
        L_0x036b:
            r0 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "receive a message which action string is not valid. "
            r8.append(r9)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
        L_0x0380:
            r0 = r10
        L_0x0381:
            if (r0 == 0) goto L_0x0445
            boolean r0 = r5 instanceof com.xiaomi.push.hf
            if (r0 == 0) goto L_0x0445
            com.xiaomi.push.hf r5 = (com.xiaomi.push.hf) r5
            com.xiaomi.push.gq r0 = com.xiaomi.push.gq.CancelPushMessage
            java.lang.String r0 = r0.f2942a
            java.lang.String r8 = r5.f3086d
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x042d
            java.util.Map r0 = r5.a()
            if (r0 == 0) goto L_0x042d
            java.util.Map r0 = r5.a()
            java.lang.String r7 = com.xiaomi.push.service.an.R
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            r8 = -2
            if (r7 != 0) goto L_0x03c9
            int r8 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x03b3 }
            goto L_0x03c9
        L_0x03b3:
            r0 = move-exception
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = "parse notifyId from STRING to INT failed: "
            r0.append(r9)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
        L_0x03c9:
            r0 = -1
            if (r8 < r0) goto L_0x03e6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r7 = "try to retract a message by notifyId="
            r0.append(r7)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            java.lang.String r0 = r3.f3069b
            com.xiaomi.push.service.x.a((android.content.Context) r1, (java.lang.String) r0, (int) r8)
            goto L_0x0408
        L_0x03e6:
            java.util.Map r0 = r5.a()
            java.lang.String r7 = com.xiaomi.push.service.an.P
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            java.util.Map r7 = r5.a()
            java.lang.String r8 = com.xiaomi.push.service.an.Q
            java.lang.Object r7 = r7.get(r8)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = "try to retract a message by title&description."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r8)
            java.lang.String r8 = r3.f3069b
            com.xiaomi.push.service.x.a((android.content.Context) r1, (java.lang.String) r8, (java.lang.String) r0, (java.lang.String) r7)
        L_0x0408:
            if (r4 == 0) goto L_0x0429
            java.util.Map r0 = r4.a()
            if (r0 == 0) goto L_0x0429
            boolean r0 = com.xiaomi.push.j.a((android.content.Context) r19)
            if (r0 == 0) goto L_0x0429
            java.util.Map r0 = r4.a()
            java.lang.String r0 = com.xiaomi.push.service.ag.a((java.lang.Object) r0)
            java.lang.String r4 = "pulldown"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0429
            com.xiaomi.push.service.v.a((com.xiaomi.push.hc) r3)
        L_0x0429:
            a((com.xiaomi.push.service.XMPushService) r1, (com.xiaomi.push.hc) r3, (com.xiaomi.push.hf) r5)
            goto L_0x0446
        L_0x042d:
            com.xiaomi.push.gq r0 = com.xiaomi.push.gq.SettingAppNotificationPermission
            java.lang.String r0 = r0.f2942a
            java.lang.String r4 = r5.c()
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0445
            boolean r0 = com.xiaomi.push.j.a((android.content.Context) r19)
            if (r0 == 0) goto L_0x0446
            com.xiaomi.push.service.v.a((android.content.Context) r1, (com.xiaomi.push.hc) r3, (com.xiaomi.push.hf) r5)
            goto L_0x0446
        L_0x0445:
            r10 = r7
        L_0x0446:
            if (r10 == 0) goto L_0x0470
            java.lang.String r0 = "broadcast passthrough message."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            java.lang.String r0 = r3.f3069b
            java.lang.String r0 = com.xiaomi.push.service.w.a((java.lang.String) r0)
            r1.sendBroadcast(r2, r0)
            goto L_0x0470
        L_0x0457:
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r2 = r3.b()
            java.lang.String r5 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r4 = r4.a()
            java.lang.String r7 = "9"
            r0.a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r4, (java.lang.String) r7)
        L_0x0470:
            com.xiaomi.push.gg r0 = r3.a()
            com.xiaomi.push.gg r2 = com.xiaomi.push.gg.UnRegistration
            if (r0 != r2) goto L_0x04d5
            java.lang.String r0 = r19.getPackageName()
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x04d5
            r19.stopSelf()
            goto L_0x04d5
        L_0x0486:
            java.lang.String r0 = r3.f3069b
            boolean r0 = com.xiaomi.push.g.c(r1, r0)
            if (r0 != 0) goto L_0x04b1
            boolean r0 = com.xiaomi.push.service.x.e(r3)
            if (r0 == 0) goto L_0x04ad
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r2 = r3.b()
            java.lang.String r5 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r4 = r4.a()
            java.lang.String r6 = "2"
            r0.b(r2, r5, r4, r6)
        L_0x04ad:
            a((com.xiaomi.push.service.XMPushService) r1, (com.xiaomi.push.hc) r3)
            goto L_0x04d5
        L_0x04b1:
            java.lang.String r0 = "receive a mipush message, we can see the app, but we can't see the receiver."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)
            boolean r0 = com.xiaomi.push.service.x.e(r3)
            if (r0 == 0) goto L_0x04d5
            android.content.Context r0 = r19.getApplicationContext()
            com.xiaomi.push.du r0 = com.xiaomi.push.du.a((android.content.Context) r0)
            java.lang.String r1 = r3.b()
            java.lang.String r2 = com.xiaomi.push.service.x.b((com.xiaomi.push.hc) r3)
            java.lang.String r3 = r4.a()
            java.lang.String r4 = "3"
            r0.b(r1, r2, r3, r4)
        L_0x04d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.u.a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent):void");
    }

    public static void a(Context context, hc hcVar, byte[] bArr) {
        try {
            x.c a11 = x.a(context, hcVar, bArr);
            if (a11.f52610a > 0 && !TextUtils.isEmpty(a11.f3440a)) {
                ga.a(context, a11.f3440a, a11.f52610a, true, false, System.currentTimeMillis());
            }
            if (!j.a(context) || !v.a(context, hcVar, a11.f3441a)) {
                b(context, hcVar, bArr);
                return;
            }
            v.a(context, hcVar);
            b.a("consume this broadcast by tts");
        } catch (Exception e11) {
            b.a("notify push msg error " + e11);
            e11.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, byte[] bArr) {
        if (!g.a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            b.a("broadcast message arrived.");
            context.sendBroadcast(intent, w.a(str));
            return true;
        } catch (Exception e11) {
            b.a("meet error when broadcast message arrived. " + e11);
            return false;
        }
    }

    private static boolean a(XMPushService xMPushService, String str, hc hcVar, gt gtVar) {
        boolean z11 = true;
        if (gtVar != null && gtVar.a() != null && gtVar.a().containsKey("__check_alive") && gtVar.a().containsKey("__awake")) {
            hf hfVar = new hf();
            hfVar.b(hcVar.a());
            hfVar.d(str);
            hfVar.c(gq.AwakeSystemApp.f2942a);
            hfVar.a(gtVar.a());
            hfVar.f3081a = new HashMap();
            boolean a11 = g.a(xMPushService.getApplicationContext(), str);
            hfVar.f3081a.put("app_running", Boolean.toString(a11));
            if (!a11) {
                boolean parseBoolean = Boolean.parseBoolean((String) gtVar.a().get("__awake"));
                hfVar.f3081a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z11 = false;
                }
            }
            try {
                w.a(xMPushService, w.a(hcVar.b(), hcVar.a(), hfVar, gg.Notification));
            } catch (fj e11) {
                b.a((Throwable) e11);
            }
        }
        return z11;
    }

    private static void a(final XMPushService xMPushService, final hc hcVar) {
        xMPushService.a((XMPushService.j) new XMPushService.j(4) {
            public String a() {
                return "send app absent message.";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3046a() {
                try {
                    w.a(xMPushService, w.a(hcVar.b(), hcVar.a()));
                } catch (fj e11) {
                    b.a((Throwable) e11);
                    xMPushService.a(10, (Exception) e11);
                }
            }
        });
    }

    private static boolean a(hc hcVar) {
        return "com.xiaomi.xmsf".equals(hcVar.f3069b) && hcVar.a() != null && hcVar.a().a() != null && hcVar.a().a().containsKey("miui_package_name");
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (!queryBroadcastReceivers.isEmpty() || !queryIntentServices.isEmpty()) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            b.a((Throwable) e11);
            return false;
        }
    }

    private static void a(final XMPushService xMPushService, final hc hcVar, final String str) {
        xMPushService.a((XMPushService.j) new XMPushService.j(4) {
            public String a() {
                return "send app absent ack message for message.";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3050a() {
                try {
                    hc a11 = u.a((Context) xMPushService, hcVar);
                    a11.a().a("absent_target_package", str);
                    w.a(xMPushService, a11);
                } catch (fj e11) {
                    b.a((Throwable) e11);
                    xMPushService.a(10, (Exception) e11);
                }
            }
        });
    }

    private static void a(XMPushService xMPushService, hc hcVar, String str, String str2) {
        final XMPushService xMPushService2 = xMPushService;
        final hc hcVar2 = hcVar;
        final String str3 = str;
        final String str4 = str2;
        xMPushService.a((XMPushService.j) new XMPushService.j(4) {
            public String a() {
                return "send wrong message ack for message.";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3051a() {
                try {
                    hc a11 = u.a((Context) xMPushService2, hcVar2);
                    a11.f3063a.a("error", str3);
                    a11.f3063a.a(Constants.REASON, str4);
                    w.a(xMPushService2, a11);
                } catch (fj e11) {
                    b.a((Throwable) e11);
                    xMPushService2.a(10, (Exception) e11);
                }
            }
        });
    }

    private static void a(final XMPushService xMPushService, final hc hcVar, final hf hfVar) {
        xMPushService.a((XMPushService.j) new XMPushService.j(4) {
            public String a() {
                return "send ack message for clear push message.";
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3052a() {
                try {
                    gx gxVar = new gx();
                    gxVar.c(gq.CancelPushMessageACK.f2942a);
                    gxVar.a(hfVar.a());
                    gxVar.a(hfVar.a());
                    gxVar.b(hfVar.b());
                    gxVar.e(hfVar.d());
                    gxVar.a(0);
                    gxVar.d("success clear push message.");
                    w.a(xMPushService, w.b(hcVar.b(), hcVar.a(), gxVar, gg.Notification));
                } catch (fj e11) {
                    b.d("clear push message. " + e11);
                    xMPushService.a(10, (Exception) e11);
                }
            }
        });
    }

    public static hc a(Context context, hc hcVar) {
        return a(context, hcVar, (Map<String, String>) null);
    }

    public static hc a(Context context, hc hcVar, Map<String, String> map) {
        gw gwVar = new gw();
        gwVar.b(hcVar.a());
        gt a11 = hcVar.a();
        if (a11 != null) {
            gwVar.a(a11.a());
            gwVar.a(a11.a());
            if (!TextUtils.isEmpty(a11.b())) {
                gwVar.c(a11.b());
            }
        }
        gwVar.a(hq.a(context, hcVar));
        hc a12 = w.a(hcVar.b(), hcVar.a(), gwVar, gg.AckMessage);
        gt a13 = hcVar.a();
        if (a13 != null) {
            a13 = au.a(a13.a());
            String str = null;
            Map a14 = a13.a();
            if (a14 != null) {
                str = (String) a14.get(MessageKey.MSG_CHANNEL_ID);
            }
            a13.a("mat", Long.toString(System.currentTimeMillis()));
            a13.a("cs", String.valueOf(f.a(context, hcVar.f3069b, str)));
        }
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String next : map.keySet()) {
                        a13.a(next, map.get(next));
                    }
                }
            } catch (Throwable th2) {
                b.d("error adding params to ack message :" + th2);
            }
        }
        a12.a(a13);
        return a12;
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }
}
