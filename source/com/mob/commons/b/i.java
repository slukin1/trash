package com.mob.commons.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.mob.commons.a.l;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.ArrayList;

public class i extends h {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f27088c = new a(l.a("004Cel4eEejed"));

    /* renamed from: d  reason: collision with root package name */
    private BroadcastReceiver f27089d;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f27091a;

        /* renamed from: b  reason: collision with root package name */
        private long f27092b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f27093c;

        public a(String str) {
            this.f27091a = str;
        }

        public void a(long j11) {
            this.f27092b = j11;
        }

        public void a(String str) {
            this.f27093c = str;
        }

        public boolean a() {
            return this.f27092b > System.currentTimeMillis();
        }
    }

    public i(Context context) {
        super(context);
    }

    private void e() {
        try {
            if (this.f27089d == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(l.a("044d4elegemegHg^ejheehemfgWh+fdegMg]emelUkgf6ejedemgefegdffhifheihihmhjfheiffgmeifeglgefhjehj"));
                AnonymousClass1 r22 = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        String stringExtra;
                        ArrayList<String> stringArrayListExtra;
                        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                        if (context != null && intent != null) {
                            try {
                                boolean z11 = false;
                                if (intent.getIntExtra(l.a("016Qel]kgfDffedfhelWj[ejfgfdhd=he@fk"), 0) == 2 && (stringArrayListExtra = intent.getStringArrayListExtra(l.a("017+el^kgf;ffedhm_ed_fi e7fkRgZgfejgjJj"))) != null) {
                                    z11 = stringArrayListExtra.contains(context.getPackageName());
                                }
                                if (z11 && (stringExtra = intent.getStringExtra(l.a("0108el1kgfSffedgdfd1kg"))) != null && stringExtra.equals(l.a("004IelVeYejed"))) {
                                    i.this.f27088c.a(0);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                };
                this.f27089d = r22;
                if (Build.VERSION.SDK_INT < 33) {
                    this.f27079a.registerReceiver(r22, intentFilter, l.a("048d2elegemegHgIejheehemfgNh6fdeg+g2emel8kgf6ejedem(kgNekegejgjgjejelSfOemhihmhjfheiffgmeifeglgefhjehj"), (Handler) null);
                } else {
                    this.f27079a.registerReceiver(r22, intentFilter, l.a("048dSelegemeg1gCejheehemfg.hYfdeg>gVemelMkgf=ejedemNkgEekegejgjgjejelLfQemhihmhjfheiffgmeifeglgefhjehj"), (Handler) null, 4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String d() {
        Context context = this.f27079a;
        if (context == null) {
            return null;
        }
        return a(context.getApplicationContext(), this.f27088c, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007c, code lost:
        if (r9 != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008b, code lost:
        if (r9 != null) goto L_0x007e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(android.content.Context r9, com.mob.commons.b.i.a r10, boolean r11) {
        /*
            r8 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r11 != 0) goto L_0x0011
            boolean r1 = r10.a()
            if (r1 == 0) goto L_0x0011
            java.lang.String r9 = r10.f27093c
            return r9
        L_0x0011:
            java.lang.String r1 = "036d9elHfjgfjlmmdAelegemeg>g_ejheehemfg%h;fdeg(g;emelMkgf<ejedgjedfiEm"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)
            android.net.Uri r3 = android.net.Uri.parse(r1)
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch:{ all -> 0x0082 }
            r4 = 0
            r5 = 0
            r9 = 1
            java.lang.String[] r6 = new java.lang.String[r9]     // Catch:{ all -> 0x0082 }
            r9 = 0
            java.lang.String r1 = r10.f27091a     // Catch:{ all -> 0x0082 }
            r6[r9] = r1     // Catch:{ all -> 0x0082 }
            r7 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0082 }
            if (r9 == 0) goto L_0x007c
            r9.moveToFirst()     // Catch:{ all -> 0x007a }
            java.lang.String r1 = "005>eeHehTeh!g"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)     // Catch:{ all -> 0x007a }
            int r1 = r9.getColumnIndex(r1)     // Catch:{ all -> 0x007a }
            if (r1 < 0) goto L_0x0049
            java.lang.String r1 = r9.getString(r1)     // Catch:{ all -> 0x007a }
            r10.a((java.lang.String) r1)     // Catch:{ all -> 0x007a }
            goto L_0x004a
        L_0x0049:
            r1 = r0
        L_0x004a:
            if (r11 != 0) goto L_0x0076
            java.lang.String r11 = "007g(fjZkRejek*g ed"
            java.lang.String r11 = com.mob.commons.a.l.a((java.lang.String) r11)     // Catch:{ all -> 0x007a }
            int r11 = r9.getColumnIndex(r11)     // Catch:{ all -> 0x007a }
            if (r11 < 0) goto L_0x005f
            long r2 = r9.getLong(r11)     // Catch:{ all -> 0x007a }
            r10.a((long) r2)     // Catch:{ all -> 0x007a }
        L_0x005f:
            java.lang.String r10 = "004dVeled(g"
            java.lang.String r10 = com.mob.commons.a.l.a((java.lang.String) r10)     // Catch:{ all -> 0x007a }
            int r10 = r9.getColumnIndex(r10)     // Catch:{ all -> 0x007a }
            if (r10 < 0) goto L_0x0076
            int r10 = r9.getInt(r10)     // Catch:{ all -> 0x007a }
            r11 = 1000(0x3e8, float:1.401E-42)
            if (r10 == r11) goto L_0x0076
            r8.e()     // Catch:{ all -> 0x007a }
        L_0x0076:
            r9.close()     // Catch:{ all -> 0x0079 }
        L_0x0079:
            return r1
        L_0x007a:
            r10 = move-exception
            goto L_0x0084
        L_0x007c:
            if (r9 == 0) goto L_0x008e
        L_0x007e:
            r9.close()     // Catch:{ all -> 0x008e }
            goto L_0x008e
        L_0x0082:
            r10 = move-exception
            r9 = r0
        L_0x0084:
            com.mob.tools.log.NLog r11 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x008f }
            r11.d(r10)     // Catch:{ all -> 0x008f }
            if (r9 == 0) goto L_0x008e
            goto L_0x007e
        L_0x008e:
            return r0
        L_0x008f:
            r10 = move-exception
            if (r9 == 0) goto L_0x0095
            r9.close()     // Catch:{ all -> 0x0095 }
        L_0x0095:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.i.a(android.content.Context, com.mob.commons.b.i$a, boolean):java.lang.String");
    }
}
