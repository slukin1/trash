package com.mob.commons;

import android.os.Message;
import android.text.TextUtils;
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

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f27226a = C0891r.b("004=ckcbdbDf");

    /* renamed from: b  reason: collision with root package name */
    private static h f27227b;

    /* renamed from: c  reason: collision with root package name */
    private NetCommunicator f27228c;

    /* renamed from: d  reason: collision with root package name */
    private SimpleDateFormat f27229d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f27230e;

    /* renamed from: f  reason: collision with root package name */
    private String f27231f;

    /* renamed from: g  reason: collision with root package name */
    private int f27232g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Runnable f27233h;

    private h() {
        this.f27229d = new SimpleDateFormat(C0891r.b("0256dbdbdbdbgjgbgbgjcbcbheejej4j:cece<j1ehehckdkdkdkhefc"));
        this.f27230e = new HashMap<>();
        this.f27231f = null;
        this.f27232g = -1;
        this.f27231f = UUID.randomUUID().toString();
        this.f27233h = new i() {
            public void a() {
                if (b.c()) {
                    h.this.c();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void c() {
        boolean z11;
        File[] listFiles;
        if (this.f27230e.size() > 0) {
            z11 = a(this.f27230e);
            if (!z11) {
                c(this.f27230e);
            }
            this.f27230e.clear();
        } else {
            z11 = true;
        }
        if (z11) {
            File e11 = e();
            if (e11.exists() && e11.isDirectory() && (listFiles = e11.listFiles()) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (a((HashMap<String, Object>) (HashMap) ResHelper.readObjectFromFile(file.getAbsolutePath())) && !file.delete()) {
                        file.delete();
                    }
                }
            }
        }
    }

    private void d() {
        if (this.f27228c == null) {
            this.f27228c = new NetCommunicator(1024, "ab0a0a6473d1891d388773574764b239d4ad80cb2fd3a83d81d03901c1548c13fee7c9692c326e6682b239d4c5d0021d1b607642c47ec29f10b0602908c3e6c9", "23c3c8cb41c47dd288cc7f4c218fbc7c839a34e0a0d1b2130e87b7914936b120a2d6570ee7ac66282328d50f2acfd82f2259957c89baea32547758db05de9cd7c6822304c8e45742f24bbbe41c1e12f09e18c6fab4d078065f2e5aaed94c900c66e8bbf8a120eefa7bd1fb52114d529250084f5f6f369ed4ce9645978dd30c51");
        }
    }

    private File e() {
        return new File(ResHelper.getDataCache(MobSDK.getContext()), f27226a);
    }

    private synchronized int b() {
        return this.f27232g;
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f27227b == null) {
                f27227b = new h();
            }
            hVar = f27227b;
        }
        return hVar;
    }

    private boolean b(HashMap<String, Object> hashMap) throws Throwable {
        if (hashMap == null || hashMap.isEmpty()) {
            return true;
        }
        HashMap<String, Object> e11 = u.e();
        e11.put(C0891r.b("006e@cicicjcieh"), hashMap);
        d();
        HashMap hashMap2 = (HashMap) this.f27228c.requestWithoutEncode(false, NetCommunicator.getCommonDefaultHeaders(), e11, i.a().a("dtc") + "/v2/drl", true);
        if (hashMap2 == null || hashMap2.isEmpty()) {
            return true;
        }
        return false;
    }

    public synchronized void a(int i11) {
        this.f27232g = i11;
        if (!(i11 == 1 || i11 == 4 || i11 == 17 || i11 == 18 || i11 == 19 || i11 == 20)) {
        }
    }

    public synchronized void a(int i11, Throwable th2) {
        a(i11, b(), th2, (String) null, "-99");
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
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0056 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0056 }
            r1.d(r10, r2)     // Catch:{ all -> 0x0056 }
            goto L_0x0015
        L_0x000e:
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0056 }
            r1.d(r9)     // Catch:{ all -> 0x0056 }
        L_0x0015:
            boolean r1 = com.mob.commons.e.a()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x001d
            monitor-exit(r6)
            return
        L_0x001d:
            android.os.Message r1 = new android.os.Message     // Catch:{ all -> 0x0056 }
            r1.<init>()     // Catch:{ all -> 0x0056 }
            r2 = 1
            r1.what = r2     // Catch:{ all -> 0x0056 }
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0056 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0056 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0056 }
            r3[r0] = r4     // Catch:{ all -> 0x0056 }
            if (r9 != 0) goto L_0x0035
            r9 = r10
        L_0x0035:
            r3[r2] = r9     // Catch:{ all -> 0x0056 }
            r9 = 2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0056 }
            r3[r9] = r7     // Catch:{ all -> 0x0056 }
            r7 = 3
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0056 }
            r3[r7] = r8     // Catch:{ all -> 0x0056 }
            r7 = 4
            r3[r7] = r11     // Catch:{ all -> 0x0056 }
            r1.obj = r3     // Catch:{ all -> 0x0056 }
            java.util.concurrent.ThreadPoolExecutor r7 = com.mob.commons.z.f27385d     // Catch:{ all -> 0x0056 }
            com.mob.commons.h$2 r8 = new com.mob.commons.h$2     // Catch:{ all -> 0x0056 }
            r8.<init>(r1)     // Catch:{ all -> 0x0056 }
            r7.execute(r8)     // Catch:{ all -> 0x0056 }
            monitor-exit(r6)
            return
        L_0x0056:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.h.a(int, int, java.lang.Throwable, java.lang.String, java.lang.String):void");
    }

    private void c(HashMap<String, Object> hashMap) {
        File[] listFiles;
        try {
            File e11 = e();
            if (!e11.exists() || !e11.isDirectory()) {
                e11.delete();
                e11.mkdirs();
            }
            StringBuilder sb2 = new StringBuilder();
            String str = f27226a;
            sb2.append(str);
            sb2.append("_");
            int i11 = 0;
            sb2.append(0);
            File file = new File(e11, sb2.toString());
            if (file.exists() && (listFiles = e11.listFiles()) != null && listFiles.length > 0) {
                file = new File(e11, str + "_" + 0);
                while (file.exists()) {
                    i11++;
                    file = new File(e11, f27226a + "_" + i11);
                }
            }
            ResHelper.saveObjectToFile(file.getPath(), hashMap);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
    }

    /* access modifiers changed from: private */
    public void a(Message message) {
        String str;
        if (this.f27230e.size() > 10) {
            c(this.f27230e);
            this.f27230e.clear();
        }
        Object[] objArr = (Object[]) message.obj;
        this.f27230e.put(C0891r.b("0027ehcb"), this.f27231f);
        ArrayList arrayList = (ArrayList) this.f27230e.get(C0891r.b("004f?cheh4h"));
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(C0891r.b("002bh"), objArr[0]);
        if (objArr[1] instanceof Throwable) {
            str = a((Throwable) objArr[1]);
        } else {
            str = String.valueOf(objArr[1]);
        }
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\r\n\t", " ").replaceAll("\n\t", " ").replaceAll("\n", " ");
        }
        String b11 = C0891r.b("002Gcedi");
        hashMap.put(b11, "[" + this.f27229d.format(objArr[0]) + "][" + objArr[2] + "][" + objArr[3] + "][" + objArr[4] + "] " + str);
        hashMap.put(C0891r.b("002eh"), objArr[2]);
        hashMap.put(C0891r.b("002i(cj"), objArr[3]);
        arrayList.add(hashMap);
        this.f27230e.put(C0891r.b("004f;chehXh"), arrayList);
        if (!e.a()) {
            DH.requester(MobSDK.getContext()).request(new DH.DHResponder() {
                public void onResponse(DH.DHResponse dHResponse) {
                    l.a().b(10, h.this.f27233h);
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
            java.lang.String r7 = "023PdiNeh(dk hcbOdgebciUcbe-dkHh,cich^d8dihecjcjce"
            java.lang.String r7 = com.mob.commons.C0891r.b(r7)     // Catch:{ all -> 0x005a }
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
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.h.a(java.lang.Throwable):java.lang.String");
    }
}
