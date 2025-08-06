package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import com.sumsub.sentry.a;

public class u {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f38445c = {"url", a.f30241h, "cosa", "rp"};

    /* renamed from: a  reason: collision with root package name */
    private Context f38446a;

    /* renamed from: b  reason: collision with root package name */
    private o f38447b;

    public u(Context context, o oVar) {
        this.f38446a = context;
        this.f38447b = oVar;
    }

    public static boolean a(String str) {
        for (String equals : f38445c) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x008b, code lost:
        if (r3 != false) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00cb, code lost:
        if (com.huawei.hms.push.e.a(r6.f38446a, r6.f38447b.c(), r2).booleanValue() != false) goto L_0x00cd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d0 A[Catch:{ Exception -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d6 A[Catch:{ Exception -> 0x00f2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r6 = this;
            java.lang.String r0 = "PushSelfShowLog"
            java.lang.String r1 = "run into launchCosaApp"
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f2 }
            r1.<init>()     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = "enter launchExistApp cosa, appPackageName ="
            r1.append(r2)     // Catch:{ Exception -> 0x00f2 }
            com.huawei.hms.push.o r2 = r6.f38447b     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = r2.c()     // Catch:{ Exception -> 0x00f2 }
            r1.append(r2)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = ",and msg.intentUri is "
            r1.append(r2)     // Catch:{ Exception -> 0x00f2 }
            com.huawei.hms.push.o r2 = r6.f38447b     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = r2.m()     // Catch:{ Exception -> 0x00f2 }
            r1.append(r2)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00f2 }
            com.huawei.hms.support.log.HMSLog.i(r0, r1)     // Catch:{ Exception -> 0x00f2 }
            android.content.Context r1 = r6.f38446a     // Catch:{ Exception -> 0x00f2 }
            com.huawei.hms.push.o r2 = r6.f38447b     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = r2.c()     // Catch:{ Exception -> 0x00f2 }
            android.content.Intent r1 = com.huawei.hms.push.e.b(r1, r2)     // Catch:{ Exception -> 0x00f2 }
            com.huawei.hms.push.o r2 = r6.f38447b     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = r2.m()     // Catch:{ Exception -> 0x00f2 }
            r3 = 0
            if (r2 == 0) goto L_0x00a8
            com.huawei.hms.push.o r2 = r6.f38447b     // Catch:{ Exception -> 0x008e }
            java.lang.String r2 = r2.m()     // Catch:{ Exception -> 0x008e }
            android.content.Intent r2 = android.content.Intent.parseUri(r2, r3)     // Catch:{ Exception -> 0x008e }
            r4 = 0
            r2.setSelector(r4)     // Catch:{ Exception -> 0x008e }
            android.content.ClipData r4 = r2.getClipData()     // Catch:{ Exception -> 0x008e }
            if (r4 != 0) goto L_0x0063
            java.lang.String r4 = "avoid intent add read permission flags"
            java.lang.String r5 = "avoid"
            android.content.ClipData r4 = android.content.ClipData.newPlainText(r4, r5)     // Catch:{ Exception -> 0x008e }
            r2.setClipData(r4)     // Catch:{ Exception -> 0x008e }
        L_0x0063:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008e }
            r4.<init>()     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = "Intent.parseUri(msg.intentUri, 0), action:"
            r4.append(r5)     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = r2.getAction()     // Catch:{ Exception -> 0x008e }
            r4.append(r5)     // Catch:{ Exception -> 0x008e }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x008e }
            com.huawei.hms.support.log.HMSLog.i(r0, r4)     // Catch:{ Exception -> 0x008e }
            android.content.Context r4 = r6.f38446a     // Catch:{ Exception -> 0x008e }
            com.huawei.hms.push.o r5 = r6.f38447b     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = r5.c()     // Catch:{ Exception -> 0x008e }
            java.lang.Boolean r4 = com.huawei.hms.push.e.a(r4, r5, r2)     // Catch:{ Exception -> 0x008e }
            boolean r3 = r4.booleanValue()     // Catch:{ Exception -> 0x008e }
            if (r3 == 0) goto L_0x00ce
            goto L_0x00cd
        L_0x008e:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f2 }
            r4.<init>()     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r5 = "intentUri error."
            r4.append(r5)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00f2 }
            r4.append(r2)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x00f2 }
            com.huawei.hms.support.log.HMSLog.w(r0, r2)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x00ce
        L_0x00a8:
            com.huawei.hms.push.o r2 = r6.f38447b     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x00f2 }
            if (r2 == 0) goto L_0x00ce
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x00f2 }
            com.huawei.hms.push.o r4 = r6.f38447b     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r4 = r4.a()     // Catch:{ Exception -> 0x00f2 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x00f2 }
            android.content.Context r4 = r6.f38446a     // Catch:{ Exception -> 0x00f2 }
            com.huawei.hms.push.o r5 = r6.f38447b     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r5 = r5.c()     // Catch:{ Exception -> 0x00f2 }
            java.lang.Boolean r4 = com.huawei.hms.push.e.a(r4, r5, r2)     // Catch:{ Exception -> 0x00f2 }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x00f2 }
            if (r4 == 0) goto L_0x00ce
        L_0x00cd:
            r1 = r2
        L_0x00ce:
            if (r1 != 0) goto L_0x00d6
            java.lang.String r1 = "launchCosaApp,intent == null"
            com.huawei.hms.support.log.HMSLog.i(r0, r1)     // Catch:{ Exception -> 0x00f2 }
            return
        L_0x00d6:
            com.huawei.hms.push.o r2 = r6.f38447b     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r2 = r2.c()     // Catch:{ Exception -> 0x00f2 }
            r1.setPackage(r2)     // Catch:{ Exception -> 0x00f2 }
            if (r3 == 0) goto L_0x00e7
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r2)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x00ec
        L_0x00e7:
            r2 = 805437440(0x30020000, float:4.7293724E-10)
            r1.setFlags(r2)     // Catch:{ Exception -> 0x00f2 }
        L_0x00ec:
            android.content.Context r2 = r6.f38446a     // Catch:{ Exception -> 0x00f2 }
            r2.startActivity(r1)     // Catch:{ Exception -> 0x00f2 }
            goto L_0x010b
        L_0x00f2:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "launch Cosa App exception."
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r1)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.u.b():void");
    }

    public void c() {
        o oVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.f38446a == null || (oVar = this.f38447b) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
        } else if (a.f30241h.equals(oVar.h())) {
            a();
        } else if ("cosa".equals(this.f38447b.h())) {
            b();
        } else if ("rp".equals(this.f38447b.h())) {
            HMSLog.w("PushSelfShowLog", this.f38447b.h() + " not support rich message.");
        } else if ("url".equals(this.f38447b.h())) {
            HMSLog.w("PushSelfShowLog", this.f38447b.h() + " not support URL.");
        } else {
            HMSLog.d("PushSelfShowLog", this.f38447b.h() + " is not exist in hShowType");
        }
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f38447b.c());
            if (e.c(this.f38446a, this.f38447b.c())) {
                b();
            }
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e11.toString());
        }
    }
}
