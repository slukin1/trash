package com.mob.commons;

import android.os.Message;
import android.text.TextUtils;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.a.l;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.i;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f27214a = l.a("004IemedgjOh");

    /* renamed from: b  reason: collision with root package name */
    private static g f27215b;

    /* renamed from: c  reason: collision with root package name */
    private NetCommunicator f27216c;

    /* renamed from: d  reason: collision with root package name */
    private SimpleDateFormat f27217d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f27218e;

    /* renamed from: f  reason: collision with root package name */
    private String f27219f;

    /* renamed from: g  reason: collision with root package name */
    private String f27220g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Runnable f27221h;

    private g() {
        this.f27217d = new SimpleDateFormat(l.a("0259fdfdfdfdilididilededjgglgl1l>egeg1l9gjgjemfmfmfmjghe"));
        this.f27218e = new HashMap<>();
        this.f27219f = null;
        this.f27220g = l.a("0088gjggekeiOfe[egFg");
        this.f27219f = UUID.randomUUID().toString();
        this.f27221h = new i() {
            public void a() {
                if (b.c()) {
                    g.this.b();
                }
            }
        };
    }

    private void c() {
        if (this.f27216c == null) {
            this.f27216c = new NetCommunicator(1024, "ab0a0a6473d1891d388773574764b239d4ad80cb2fd3a83d81d03901c1548c13fee7c9692c326e6682b239d4c5d0021d1b607642c47ec29f10b0602908c3e6c9", "23c3c8cb41c47dd288cc7f4c218fbc7c839a34e0a0d1b2130e87b7914936b120a2d6570ee7ac66282328d50f2acfd82f2259957c89baea32547758db05de9cd7c6822304c8e45742f24bbbe41c1e12f09e18c6fab4d078065f2e5aaed94c900c66e8bbf8a120eefa7bd1fb52114d529250084f5f6f369ed4ce9645978dd30c51");
        }
    }

    private File d() {
        return new File(ResHelper.getDataCache(MobSDK.getContext()), f27214a);
    }

    /* access modifiers changed from: private */
    public void b() {
        boolean z11;
        File[] listFiles;
        if (this.f27218e.size() > 0) {
            z11 = a(this.f27218e);
            if (!z11) {
                c(this.f27218e);
            }
            this.f27218e.clear();
        } else {
            z11 = true;
        }
        if (z11) {
            File d11 = d();
            if (d11.exists() && d11.isDirectory() && (listFiles = d11.listFiles()) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (a((HashMap<String, Object>) (HashMap) ResHelper.readObjectFromFile(file.getAbsolutePath())) && !file.delete()) {
                        file.delete();
                    }
                }
            }
        }
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f27215b == null) {
                f27215b = new g();
            }
            gVar = f27215b;
        }
        return gVar;
    }

    private void c(HashMap<String, Object> hashMap) {
        File[] listFiles;
        try {
            File d11 = d();
            if (!d11.exists() || !d11.isDirectory()) {
                d11.delete();
                d11.mkdirs();
            }
            StringBuilder sb2 = new StringBuilder();
            String str = f27214a;
            sb2.append(str);
            sb2.append("_");
            int i11 = 0;
            sb2.append(0);
            File file = new File(d11, sb2.toString());
            if (file.exists() && (listFiles = d11.listFiles()) != null && listFiles.length > 0) {
                file = new File(d11, str + "_" + 0);
                while (file.exists()) {
                    i11++;
                    file = new File(d11, f27214a + "_" + i11);
                }
            }
            ResHelper.saveObjectToFile(file.getPath(), hashMap);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }

    public synchronized void a(int i11, int i12, Throwable th2, String str) {
        a(i11, i12, th2, (String) null, str);
    }

    public synchronized void a(int i11, int i12, String str, String str2) {
        a(i11, i12, (Throwable) null, str, str2);
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(int r7, int r8, java.lang.Throwable r9, java.lang.String r10, java.lang.String r11) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            if (r9 != 0) goto L_0x000e
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0058 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0058 }
            r1.d(r10, r2)     // Catch:{ all -> 0x0058 }
            goto L_0x0015
        L_0x000e:
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0058 }
            r1.d(r9)     // Catch:{ all -> 0x0058 }
        L_0x0015:
            boolean r1 = com.mob.commons.e.a()     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x001d
            monitor-exit(r6)
            return
        L_0x001d:
            android.os.Message r1 = new android.os.Message     // Catch:{ all -> 0x0058 }
            r1.<init>()     // Catch:{ all -> 0x0058 }
            r2 = 1
            r1.what = r2     // Catch:{ all -> 0x0058 }
            r1.arg1 = r2     // Catch:{ all -> 0x0058 }
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0058 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0058 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0058 }
            r3[r0] = r4     // Catch:{ all -> 0x0058 }
            if (r9 != 0) goto L_0x0037
            r9 = r10
        L_0x0037:
            r3[r2] = r9     // Catch:{ all -> 0x0058 }
            r9 = 2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0058 }
            r3[r9] = r7     // Catch:{ all -> 0x0058 }
            r7 = 3
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0058 }
            r3[r7] = r8     // Catch:{ all -> 0x0058 }
            r7 = 4
            r3[r7] = r11     // Catch:{ all -> 0x0058 }
            r1.obj = r3     // Catch:{ all -> 0x0058 }
            java.util.concurrent.ThreadPoolExecutor r7 = com.mob.commons.z.f27385d     // Catch:{ all -> 0x0058 }
            com.mob.commons.g$2 r8 = new com.mob.commons.g$2     // Catch:{ all -> 0x0058 }
            r8.<init>(r1)     // Catch:{ all -> 0x0058 }
            r7.execute(r8)     // Catch:{ all -> 0x0058 }
            monitor-exit(r6)
            return
        L_0x0058:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.g.a(int, int, java.lang.Throwable, java.lang.String, java.lang.String):void");
    }

    private boolean b(HashMap<String, Object> hashMap) throws Throwable {
        if (hashMap == null || hashMap.isEmpty()) {
            return true;
        }
        HashMap<String, Object> e11 = u.e();
        e11.put(l.a("006gFekekelekgj"), hashMap);
        c();
        HashMap hashMap2 = (HashMap) this.f27216c.requestWithoutEncode(false, MobCommunicator.getCommonDefaultHeaders(), e11, i.a().a("dtc") + "/v2/sdrl", true);
        if (hashMap2 == null || hashMap2.isEmpty()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void a(Message message) {
        String str;
        if (this.f27218e.size() > 10) {
            c(this.f27218e);
            this.f27218e.clear();
        }
        Object[] objArr = (Object[]) message.obj;
        this.f27218e.put(l.a("002 gjed"), this.f27219f);
        ArrayList arrayList = (ArrayList) this.f27218e.get(l.a("004h'ejgjCj"));
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(l.a("002dj"), objArr[0]);
        if (objArr[1] instanceof Throwable) {
            str = a((Throwable) objArr[1]);
        } else {
            str = String.valueOf(objArr[1]);
        }
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\r\n\t", " ").replaceAll("\n\t", " ").replaceAll("\n", " ");
        }
        String a11 = l.a("002<egfk");
        hashMap.put(a11, "[" + this.f27217d.format(objArr[0]) + "][" + objArr[2] + "][" + objArr[3] + "][" + objArr[4] + "] " + str);
        hashMap.put(l.a("002gj"), objArr[2]);
        hashMap.put(l.a("002k)el"), objArr[3]);
        hashMap.put(this.f27220g, objArr[4]);
        arrayList.add(hashMap);
        this.f27218e.put(l.a("004hJejgj!j"), arrayList);
        if (!e.a()) {
            DH.requester(MobSDK.getContext()).request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    l.a().c(10, g.this.f27221h);
                }
            });
        }
    }

    private boolean a(HashMap<String, Object> hashMap) {
        try {
            return b(hashMap);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040 A[Catch:{ all -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.Throwable r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            if (r7 != 0) goto L_0x0005
            return r0
        L_0x0005:
            r1 = 0
            r2 = r7
        L_0x0007:
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x001c
            boolean r5 = r2 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x003b }
            if (r5 == 0) goto L_0x0017
            java.io.Closeable[] r7 = new java.io.Closeable[r4]
            r7[r3] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r7)
            return r0
        L_0x0017:
            java.lang.Throwable r2 = r2.getCause()     // Catch:{ all -> 0x003b }
            goto L_0x0007
        L_0x001c:
            java.io.StringWriter r0 = new java.io.StringWriter     // Catch:{ all -> 0x003b }
            r0.<init>()     // Catch:{ all -> 0x003b }
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ all -> 0x0038 }
            r1.<init>(r0)     // Catch:{ all -> 0x0038 }
            r7.printStackTrace(r1)     // Catch:{ all -> 0x0038 }
            r1.flush()     // Catch:{ all -> 0x0038 }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x0038 }
            java.io.Closeable[] r1 = new java.io.Closeable[r4]
            r1[r3] = r0
            com.mob.commons.v.a((java.io.Closeable[]) r1)
            return r7
        L_0x0038:
            r7 = move-exception
            r1 = r0
            goto L_0x003c
        L_0x003b:
            r7 = move-exception
        L_0x003c:
            boolean r0 = r7 instanceof java.lang.OutOfMemoryError     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x004e
            java.lang.String r7 = "023NfkVgjZfmAjed0figdek7edgXfm^j?ekejUf^fkjgeleleg"
            java.lang.String r7 = com.mob.commons.a.l.a((java.lang.String) r7)     // Catch:{ all -> 0x005a }
            java.io.Closeable[] r0 = new java.io.Closeable[r4]
            r0[r3] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            return r7
        L_0x004e:
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x005a }
            java.io.Closeable[] r0 = new java.io.Closeable[r4]
            r0[r3] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            return r7
        L_0x005a:
            r7 = move-exception
            java.io.Closeable[] r0 = new java.io.Closeable[r4]
            r0[r3] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.g.a(java.lang.Throwable):java.lang.String");
    }
}
