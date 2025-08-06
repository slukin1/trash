package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ag;
import com.xiaomi.push.au;
import com.xiaomi.push.c;
import com.xiaomi.push.cj;
import com.xiaomi.push.dp;
import com.xiaomi.push.dq;
import com.xiaomi.push.fz;
import com.xiaomi.push.i;
import com.xiaomi.push.s;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ax {

    /* renamed from: a  reason: collision with root package name */
    private static ax f52530a = new ax();

    /* renamed from: a  reason: collision with other field name */
    private static String f3360a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public ag.b f3361a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public dp.a f3362a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f3363a = new ArrayList();

    public static abstract class a {
        public void a(dp.a aVar) {
        }

        public void a(dq.b bVar) {
        }
    }

    private ax() {
    }

    private void b() {
        if (this.f3362a == null) {
            d();
        }
    }

    private void c() {
        if (this.f3361a == null) {
            AnonymousClass1 r02 = new ag.b() {

                /* renamed from: a  reason: collision with other field name */
                public boolean f3364a = false;

                public void b() {
                    try {
                        dp.a a11 = dp.a.a(Base64.decode(cj.a(s.a(), "https://resolver.msg.xiaomi.net/psc/?t=a", (List<au>) null), 10));
                        if (a11 != null) {
                            dp.a unused = ax.this.f3362a = a11;
                            this.f3364a = true;
                            ax.a(ax.this);
                        }
                    } catch (Exception e11) {
                        b.a("fetch config failure: " + e11.getMessage());
                    }
                }

                public void c() {
                    a[] aVarArr;
                    ag.b unused = ax.this.f3361a = null;
                    if (this.f3364a) {
                        synchronized (ax.this) {
                            aVarArr = (a[]) ax.a(ax.this).toArray(new a[ax.a(ax.this).size()]);
                        }
                        for (a a11 : aVarArr) {
                            a11.a(ax.a(ax.this));
                        }
                    }
                }
            };
            this.f3361a = r02;
            fz.a((ag.b) r02);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.push.s.a()     // Catch:{ Exception -> 0x0027, all -> 0x0023 }
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch:{ Exception -> 0x0027, all -> 0x0023 }
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0027, all -> 0x0023 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0027, all -> 0x0023 }
            com.xiaomi.push.b r0 = com.xiaomi.push.b.a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0021 }
            com.xiaomi.push.dp$a r0 = com.xiaomi.push.dp.a.b((com.xiaomi.push.b) r0)     // Catch:{ Exception -> 0x0021 }
            r4.f3362a = r0     // Catch:{ Exception -> 0x0021 }
            r2.close()     // Catch:{ Exception -> 0x0021 }
        L_0x001d:
            com.xiaomi.push.x.a((java.io.Closeable) r2)
            goto L_0x0043
        L_0x0021:
            r0 = move-exception
            goto L_0x002a
        L_0x0023:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0050
        L_0x0027:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x002a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004f }
            r1.<init>()     // Catch:{ all -> 0x004f }
            java.lang.String r3 = "load config failure: "
            r1.append(r3)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x004f }
            r1.append(r0)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x004f }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ all -> 0x004f }
            goto L_0x001d
        L_0x0043:
            com.xiaomi.push.dp$a r0 = r4.f3362a
            if (r0 != 0) goto L_0x004e
            com.xiaomi.push.dp$a r0 = new com.xiaomi.push.dp$a
            r0.<init>()
            r4.f3362a = r0
        L_0x004e:
            return
        L_0x004f:
            r0 = move-exception
        L_0x0050:
            com.xiaomi.push.x.a((java.io.Closeable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ax.d():void");
    }

    private void e() {
        try {
            if (this.f3362a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(s.a().openFileOutput("XMCloudCfg", 0));
                c a11 = c.a((OutputStream) bufferedOutputStream);
                this.f3362a.a(a11);
                a11.a();
                bufferedOutputStream.close();
            }
        } catch (Exception e11) {
            b.a("save config failure: " + e11.getMessage());
        }
    }

    public static ax a() {
        return f52530a;
    }

    public synchronized void a(a aVar) {
        this.f3363a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m3008a() {
        this.f3363a.clear();
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m3006a() {
        b();
        dp.a aVar = this.f3362a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public dp.a m3007a() {
        b();
        return this.f3362a;
    }

    public void a(dq.b bVar) {
        a[] aVarArr;
        if (bVar.d() && bVar.d() > a()) {
            c();
        }
        synchronized (this) {
            List<a> list = this.f3363a;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a a11 : aVarArr) {
            a11.a(bVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m3005a() {
        String str;
        synchronized (ax.class) {
            if (f3360a == null) {
                SharedPreferences sharedPreferences = s.a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", (String) null);
                f3360a = string;
                if (string == null) {
                    String a11 = i.a(s.a(), false);
                    f3360a = a11;
                    if (a11 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f3360a).commit();
                    }
                }
            }
            str = f3360a;
        }
        return str;
    }
}
