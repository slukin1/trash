package com.mob.commons;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.hbg.lib.network.pro.core.util.Period;
import com.jumio.sdk.reject.JumioRejectReason;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.a.l;
import com.mob.commons.cc.a;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.e;
import com.mob.tools.utils.h;
import com.mob.tools.utils.i;
import com.mob.tools.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f27019a = false;

    /* renamed from: b  reason: collision with root package name */
    private static AtomicBoolean f27020b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private static AtomicBoolean f27021c = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f27022d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private static volatile HashMap<String, Object> f27023e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static ConcurrentHashMap<String, Object> f27024f = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static ConcurrentHashMap<String, Object> f27025g = new ConcurrentHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static CountDownLatch f27026h = new CountDownLatch(1);

    /* renamed from: i  reason: collision with root package name */
    private static CountDownLatch f27027i = new CountDownLatch(1);
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static volatile boolean f27028j = false;

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicBoolean f27029k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    private static volatile boolean f27030l = false;

    /* renamed from: m  reason: collision with root package name */
    private static volatile AtomicBoolean f27031m = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static AtomicInteger f27032n = new AtomicInteger(3);

    public static boolean d() {
        return c();
    }

    public static ConcurrentHashMap<String, Object> e() {
        return f27024f;
    }

    public static ConcurrentHashMap<String, Object> f() {
        return f27025g;
    }

    public static ArrayList<String> g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m.a("004Scjcjccdj"));
        arrayList.add(m.a("005=dhcjcjccdj"));
        arrayList.add(m.a("005edSbbZde"));
        arrayList.add(m.a("009@cdbh,dUbcbe[dcaUca"));
        arrayList.add(m.a("010KbfbfbfNa1bebhcbbi:cc"));
        return (ArrayList) a(m.a("004<debgdg=a"), arrayList);
    }

    public static void h() {
        if (a()) {
            c(3);
        }
    }

    private static void n() {
        a(m.a("003@dgdd-e"), m.a("007?bjbhdgPe$ddbh@a"));
    }

    private static void o() {
        a(m.a("003Adg@aa"), m.a("009(fabidd(jGbjbdbd+aa"), m.a("016PfabiddJja*bibdbd)jJbadddg=jSbdbaAa"), m.a("005RfabedjFeJbb"), m.a("0122bjcf?gIfdfffbgifcfggidffb"));
    }

    private static void p() {
        Object obj = p.f27296i;
        synchronized (obj) {
            h.a().a(10);
            obj.notifyAll();
        }
    }

    private static void q() {
        Object obj = p.f27297j;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    private static void r() {
        h.a().a(m.a("004$bi<bFbgba"), (Integer) 1);
        h.a().a(m.a("003bee"), (Integer) 1);
        h.a().a(m.a("003e<biBa"), (Integer) 1);
        h.a().a(m.a("002'debg"), (Integer) 1);
        h.a().a(m.a("002]dddg"), (Integer) 1);
    }

    private static void s() {
        if (x.h() && f27029k.compareAndSet(false, true)) {
            try {
                com.mob.mgs.impl.b.a();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean c() {
        if ((((Integer) a(m.a("002cMbh"), 0)).intValue() == 1) || x.a()) {
            return true;
        }
        return false;
    }

    private static boolean d(String str) {
        List list = (List) a(m.a("002ae"), (Object) null);
        return (list == null || list.size() == 0 || !list.contains(str)) ? false : true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: java.io.Closeable[]} */
    /* JADX WARNING: type inference failed for: r7v6, types: [java.io.OutputStream, com.mob.commons.b$6] */
    /* JADX WARNING: type inference failed for: r6v8, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(java.lang.String r13) {
        /*
            r0 = 2
            r1 = 0
            com.mob.commons.h r2 = com.mob.commons.h.a()     // Catch:{ all -> 0x01d2 }
            r3 = 0
            r2.a((int) r3)     // Catch:{ all -> 0x01d2 }
            java.lang.String r13 = com.mob.commons.v.b((java.lang.String) r13)     // Catch:{ all -> 0x01d2 }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x01d2 }
            android.content.Context r4 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x01d2 }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ all -> 0x01d2 }
            java.lang.String r5 = "003Xdg[aa"
            java.lang.String r5 = com.mob.commons.m.a(r5)     // Catch:{ all -> 0x01d2 }
            r2.<init>(r4, r5)     // Catch:{ all -> 0x01d2 }
            com.mob.commons.j r4 = com.mob.commons.j.a()     // Catch:{ all -> 0x01cf }
            boolean r4 = r4.b()     // Catch:{ all -> 0x01cf }
            if (r4 != 0) goto L_0x0039
            com.mob.commons.h r13 = com.mob.commons.h.a()     // Catch:{ all -> 0x01cf }
            r1 = 18
            r13.a((int) r1)     // Catch:{ all -> 0x01cf }
            o()     // Catch:{ all -> 0x01cf }
            goto L_0x01dd
        L_0x0039:
            boolean r4 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x01cf }
            r5 = 1
            if (r4 == 0) goto L_0x0049
            com.mob.commons.h r13 = com.mob.commons.h.a()     // Catch:{ all -> 0x01cf }
            r13.a((int) r5)     // Catch:{ all -> 0x01cf }
            goto L_0x01dd
        L_0x0049:
            boolean r4 = c()     // Catch:{ all -> 0x01ca }
            if (r4 != 0) goto L_0x0053
            p()     // Catch:{ all -> 0x01cf }
            return
        L_0x0053:
            com.mob.commons.h r4 = com.mob.commons.h.a()     // Catch:{ all -> 0x01ca }
            r4.a((int) r0)     // Catch:{ all -> 0x01ca }
            java.util.HashMap r4 = com.mob.commons.u.e()     // Catch:{ all -> 0x01ca }
            com.mob.tools.network.NetCommunicator r6 = new com.mob.tools.network.NetCommunicator     // Catch:{ all -> 0x01ca }
            r7 = 1024(0x400, float:1.435E-42)
            java.lang.String r8 = "9e87e8d4b8f52f2916d0fb4342aa6b54a81a05666d0bdb23cc5ebf3a07440bc3976adff1ce11c64ddcdbfc017920648217196d51e3165e780e58b5460c525ee9"
            java.lang.String r9 = "13bda4b87eb42ab9e64e6b4f3d17cf8005a4ae94af37bc9fd76ebd91a828f017c81bd63cbe2924e361e20003b9e5f47cdac1f5fba5fca05730a32c5c65869590287207e79a604a2aac429e55f0d35c211367bd226dd5e57df7810f036071854aa1061a0f34b418b9178895a531107c652a428cfa6ecfa65333580ae7e0edf0e1"
            r6.<init>(r7, r8, r9)     // Catch:{ all -> 0x01ca }
            java.lang.Object r13 = r6.requestSynchronized((java.util.HashMap<java.lang.String, java.lang.Object>) r4, (java.lang.String) r13, (boolean) r3)     // Catch:{ all -> 0x01ca }
            java.util.HashMap r13 = (java.util.HashMap) r13     // Catch:{ all -> 0x01ca }
            com.mob.commons.h r4 = com.mob.commons.h.a()     // Catch:{ all -> 0x01ca }
            r6 = 3
            r4.a((int) r6)     // Catch:{ all -> 0x01ca }
            java.lang.String r4 = "002[cdBe"
            java.lang.String r4 = com.mob.commons.m.a(r4)     // Catch:{ all -> 0x01ca }
            java.lang.Object r4 = r13.get(r4)     // Catch:{ all -> 0x01ca }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x01ca }
            java.lang.String r6 = "m"
            java.lang.Object r6 = r13.get(r6)     // Catch:{ all -> 0x01ca }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x01ca }
            java.lang.String r7 = "002bIdg"
            java.lang.String r7 = com.mob.commons.m.a(r7)     // Catch:{ all -> 0x01ca }
            java.lang.Object r7 = r13.get(r7)     // Catch:{ all -> 0x01ca }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x01ca }
            if (r7 == 0) goto L_0x009e
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x01ca }
            goto L_0x009f
        L_0x009e:
            r7 = r3
        L_0x009f:
            java.lang.String r8 = "002bKcf"
            java.lang.String r8 = com.mob.commons.m.a(r8)     // Catch:{ all -> 0x01ca }
            java.lang.Object r8 = r13.get(r8)     // Catch:{ all -> 0x01ca }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x01ca }
            java.lang.String r9 = "002ac"
            java.lang.String r9 = com.mob.commons.m.a(r9)     // Catch:{ all -> 0x01ca }
            java.lang.Object r9 = r13.get(r9)     // Catch:{ all -> 0x01ca }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x01ca }
            java.lang.String r10 = "0023cd(c"
            java.lang.String r10 = com.mob.commons.m.a(r10)     // Catch:{ all -> 0x01ca }
            java.lang.Object r13 = r13.get(r10)     // Catch:{ all -> 0x01ca }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x01ca }
            boolean r10 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x01ca }
            if (r10 != 0) goto L_0x01bb
            boolean r10 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01ca }
            if (r10 != 0) goto L_0x01bb
            boolean r10 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x01ca }
            if (r10 == 0) goto L_0x00d7
            goto L_0x01bb
        L_0x00d7:
            java.lang.Object r10 = com.mob.commons.p.f27296i     // Catch:{ all -> 0x01ca }
            monitor-enter(r10)     // Catch:{ all -> 0x01ca }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r11 = f27024f     // Catch:{ all -> 0x01b8 }
            r11.clear()     // Catch:{ all -> 0x01b8 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r11 = f27024f     // Catch:{ all -> 0x01b8 }
            java.lang.String r12 = "h"
            r11.put(r12, r6)     // Catch:{ all -> 0x01b8 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r11 = f27024f     // Catch:{ all -> 0x01b8 }
            java.lang.String r12 = "k"
            r11.put(r12, r8)     // Catch:{ all -> 0x01b8 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r8 = f27024f     // Catch:{ all -> 0x01b8 }
            java.lang.String r11 = "002ac"
            java.lang.String r11 = com.mob.commons.m.a(r11)     // Catch:{ all -> 0x01b8 }
            r8.put(r11, r9)     // Catch:{ all -> 0x01b8 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r8 = f27024f     // Catch:{ all -> 0x01b8 }
            java.lang.String r9 = "002[cdYc"
            java.lang.String r9 = com.mob.commons.m.a(r9)     // Catch:{ all -> 0x01b8 }
            r8.put(r9, r13)     // Catch:{ all -> 0x01b8 }
            java.lang.String r13 = com.mob.tools.network.NetCommunicator.checkHttpRequestUrl(r4)     // Catch:{ all -> 0x01b8 }
            if (r7 == 0) goto L_0x0163
            com.mob.commons.h r4 = com.mob.commons.h.a()     // Catch:{ all -> 0x01b8 }
            r7 = 5
            r4.a((int) r7)     // Catch:{ all -> 0x01b8 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x01b8 }
            java.lang.String r7 = "008a<biKc-cdbjdg aa"
            java.lang.String r7 = com.mob.commons.m.a(r7)     // Catch:{ all -> 0x01b8 }
            r4.<init>(r2, r7)     // Catch:{ all -> 0x01b8 }
            boolean r7 = r4.exists()     // Catch:{ all -> 0x01b8 }
            if (r7 == 0) goto L_0x012c
            java.lang.String r7 = com.mob.tools.utils.Data.MD5((java.io.File) r4)     // Catch:{ all -> 0x01b8 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x01b8 }
            if (r6 != 0) goto L_0x01aa
        L_0x012c:
            com.mob.commons.h r6 = com.mob.commons.h.a()     // Catch:{ all -> 0x01b8 }
            r7 = 6
            r6.a((int) r7)     // Catch:{ all -> 0x01b8 }
            com.mob.tools.utils.ResHelper.deleteFileAndFolder(r2)     // Catch:{ all -> 0x01b8 }
            r2.mkdirs()     // Catch:{ all -> 0x01b8 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x015a }
            r6.<init>(r4)     // Catch:{ all -> 0x015a }
            com.mob.tools.network.NetworkHelper r4 = new com.mob.tools.network.NetworkHelper     // Catch:{ all -> 0x0157 }
            r4.<init>()     // Catch:{ all -> 0x0157 }
            r4.download(r13, r6, r1)     // Catch:{ all -> 0x0157 }
            com.mob.commons.h r13 = com.mob.commons.h.a()     // Catch:{ all -> 0x0157 }
            r1 = 7
            r13.a((int) r1)     // Catch:{ all -> 0x0157 }
            java.io.Closeable[] r13 = new java.io.Closeable[r5]     // Catch:{ all -> 0x01b8 }
            r13[r3] = r6     // Catch:{ all -> 0x01b8 }
            com.mob.commons.v.a((java.io.Closeable[]) r13)     // Catch:{ all -> 0x01b8 }
            goto L_0x01aa
        L_0x0157:
            r13 = move-exception
            r1 = r6
            goto L_0x015b
        L_0x015a:
            r13 = move-exception
        L_0x015b:
            java.io.Closeable[] r4 = new java.io.Closeable[r5]     // Catch:{ all -> 0x01b8 }
            r4[r3] = r1     // Catch:{ all -> 0x01b8 }
            com.mob.commons.v.a((java.io.Closeable[]) r4)     // Catch:{ all -> 0x01b8 }
            throw r13     // Catch:{ all -> 0x01b8 }
        L_0x0163:
            com.mob.commons.h r4 = com.mob.commons.h.a()     // Catch:{ all -> 0x01b8 }
            r6 = 8
            r4.a((int) r6)     // Catch:{ all -> 0x01b8 }
            com.mob.tools.utils.ResHelper.deleteFileAndFolder(r2)     // Catch:{ all -> 0x01b8 }
            byte[][] r4 = new byte[r5][]     // Catch:{ all -> 0x01b8 }
            int[] r6 = new int[r5]     // Catch:{ all -> 0x01b8 }
            com.mob.commons.b$6 r7 = new com.mob.commons.b$6     // Catch:{ all -> 0x01af }
            r7.<init>(r4, r6)     // Catch:{ all -> 0x01af }
            com.mob.tools.network.NetworkHelper r8 = new com.mob.tools.network.NetworkHelper     // Catch:{ all -> 0x01ac }
            r8.<init>()     // Catch:{ all -> 0x01ac }
            r8.download(r13, r7, r1)     // Catch:{ all -> 0x01ac }
            com.mob.commons.h r13 = com.mob.commons.h.a()     // Catch:{ all -> 0x01ac }
            r1 = 9
            r13.a((int) r1)     // Catch:{ all -> 0x01ac }
            java.io.Closeable[] r13 = new java.io.Closeable[r5]     // Catch:{ all -> 0x01b8 }
            r13[r3] = r7     // Catch:{ all -> 0x01b8 }
            com.mob.commons.v.a((java.io.Closeable[]) r13)     // Catch:{ all -> 0x01b8 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r13 = f27024f     // Catch:{ all -> 0x01b8 }
            java.lang.String r1 = "0011dd"
            java.lang.String r1 = com.mob.commons.m.a(r1)     // Catch:{ all -> 0x01b8 }
            r4 = r4[r3]     // Catch:{ all -> 0x01b8 }
            r13.put(r1, r4)     // Catch:{ all -> 0x01b8 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r13 = f27024f     // Catch:{ all -> 0x01b8 }
            java.lang.String r1 = "s"
            r3 = r6[r3]     // Catch:{ all -> 0x01b8 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01b8 }
            r13.put(r1, r3)     // Catch:{ all -> 0x01b8 }
        L_0x01aa:
            monitor-exit(r10)     // Catch:{ all -> 0x01b8 }
            goto L_0x01c6
        L_0x01ac:
            r13 = move-exception
            r1 = r7
            goto L_0x01b0
        L_0x01af:
            r13 = move-exception
        L_0x01b0:
            java.io.Closeable[] r4 = new java.io.Closeable[r5]     // Catch:{ all -> 0x01b8 }
            r4[r3] = r1     // Catch:{ all -> 0x01b8 }
            com.mob.commons.v.a((java.io.Closeable[]) r4)     // Catch:{ all -> 0x01b8 }
            throw r13     // Catch:{ all -> 0x01b8 }
        L_0x01b8:
            r13 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x01b8 }
            throw r13     // Catch:{ all -> 0x01ca }
        L_0x01bb:
            com.mob.commons.h r13 = com.mob.commons.h.a()     // Catch:{ all -> 0x01ca }
            r1 = 4
            r13.a((int) r1)     // Catch:{ all -> 0x01ca }
            com.mob.tools.utils.ResHelper.deleteFileAndFolder(r2)     // Catch:{ all -> 0x01ca }
        L_0x01c6:
            p()     // Catch:{ all -> 0x01cf }
            goto L_0x01dd
        L_0x01ca:
            r13 = move-exception
            p()     // Catch:{ all -> 0x01cf }
            throw r13     // Catch:{ all -> 0x01cf }
        L_0x01cf:
            r13 = move-exception
            r1 = r2
            goto L_0x01d3
        L_0x01d2:
            r13 = move-exception
        L_0x01d3:
            com.mob.tools.utils.ResHelper.deleteFileAndFolder(r1)
            com.mob.commons.h r1 = com.mob.commons.h.a()
            r1.a((int) r0, (java.lang.Throwable) r13)
        L_0x01dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.e(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static void f(String str) {
        File file;
        Throwable th2;
        try {
            String b11 = v.b(str);
            file = new File(MobSDK.getContext().getFilesDir(), m.a("003Hdgdd7e"));
            try {
                File file2 = new File(MobSDK.getContext().getFilesDir(), m.a("007>bjbhdg<eZddbhTa"));
                if (!j.a().b()) {
                    ResHelper.deleteFileAndFolder(file);
                    ResHelper.deleteFileAndFolder(file2);
                } else if (TextUtils.isEmpty(b11)) {
                    ResHelper.deleteFileAndFolder(file);
                } else if (!c()) {
                    q();
                    return;
                } else {
                    HashMap<String, Object> e11 = u.e();
                    e11.put(m.a("007:bb1dUbhdgbgbi8c"), String.valueOf(a.a()));
                    ArrayList arrayList = (ArrayList) ((HashMap) new NetCommunicator(1024, "9e87e8d4b8f52f2916d0fb4342aa6b54a81a05666d0bdb23cc5ebf3a07440bc3976adff1ce11c64ddcdbfc017920648217196d51e3165e780e58b5460c525ee9", "13bda4b87eb42ab9e64e6b4f3d17cf8005a4ae94af37bc9fd76ebd91a828f017c81bd63cbe2924e361e20003b9e5f47cdac1f5fba5fca05730a32c5c65869590287207e79a604a2aac429e55f0d35c211367bd226dd5e57df7810f036071854aa1061a0f34b418b9178895a531107c652a428cfa6ecfa65333580ae7e0edf0e1").requestWithoutEncode(false, NetCommunicator.getCommonDefaultHeaders(), e11, b11, true)).get(m.a("004e6bgdg@g"));
                    if (arrayList != null) {
                        if (!arrayList.isEmpty()) {
                            synchronized (p.f27297j) {
                                f27025g.clear();
                                f27025g.put(m.a("002eg"), arrayList);
                            }
                        }
                    }
                    ResHelper.deleteFileAndFolder(file);
                    ResHelper.deleteFileAndFolder(file2);
                    q();
                    return;
                }
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    g.a().a(9, -1, th2, "-1");
                    ResHelper.deleteFileAndFolder(file);
                    q();
                } catch (Throwable th4) {
                    q();
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
            file = null;
            g.a().a(9, -1, th2, "-1");
            ResHelper.deleteFileAndFolder(file);
            q();
        }
        q();
    }

    public static <T> T b(String str, T t11) {
        if (TextUtils.isEmpty(str)) {
            return t11;
        }
        if (f27023e != null) {
            return a(f27023e, str, t11);
        }
        return a((HashMap<String, Object>) HashonHelper.fromJson(ab.a().c()), str, t11);
    }

    /* access modifiers changed from: private */
    public static void c(boolean z11) {
        if (b()) {
            MobLog.getInstance().d("b db st", new Object[0]);
            e.a((MobProduct) null);
            if (z11) {
                d.a().b();
            }
        }
    }

    public static void a(CountDownLatch countDownLatch) {
        b(countDownLatch);
    }

    public static <T> T a(String str, T t11) {
        if (TextUtils.isEmpty(str) || f27023e == null || !CSCenter.getInstance().isConfigEnable()) {
            return t11;
        }
        if (b(f27023e)) {
            f27023e.clear();
            f27023e = new HashMap<>();
            c(2);
        }
        return ResHelper.forceCast(f27023e.get(str), t11);
    }

    public static boolean b() {
        if (((Integer) a(m.a("004aEbiMcc"), 0)).intValue() == 1) {
            return true;
        }
        return false;
    }

    private static void c(int i11) {
        if (f27022d.compareAndSet(false, true)) {
            String format = String.format(m.a("005.cbeafihidg"), new Object[]{Integer.valueOf(i11)});
            if (i11 == 2) {
                z.f27384c.execute(b(format, i11));
            } else {
                b(format, i11).run();
            }
        }
    }

    private static void b(CountDownLatch countDownLatch) {
        HashMap fromJson = HashonHelper.fromJson(ab.a().c());
        if (b((HashMap<String, Object>) fromJson)) {
            ab.a().c((String) null);
            fromJson = null;
        }
        if (a()) {
            a((HashMap<String, Object>) fromJson, false);
            if (fromJson == null || fromJson.isEmpty()) {
                MobLog.getInstance().d("g ch: n", new Object[0]);
                c(1);
                return;
            }
            MobLog.getInstance().d("g ch: y", new Object[0]);
            boolean z11 = System.currentTimeMillis() - ab.a().b(ab.f26999m, 0) < 2000;
            MobLog.getInstance().d("g ch fre: " + z11, new Object[0]);
            if (!z11) {
                c(2);
            }
            if (countDownLatch != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    MobLog.getInstance().d("g dhs_w cdl: " + countDownLatch, new Object[0]);
                    countDownLatch.await(3500, TimeUnit.MILLISECONDS);
                    MobLog.getInstance().d("g dhs_w end, dur: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
            a(true, false, z11, 2);
        }
    }

    private static CountDownLatch c(HashMap<String, Object> hashMap) {
        CountDownLatch countDownLatch;
        HashMap<String, Object> hashMap2 = hashMap;
        String str = (String) ResHelper.forceCast(hashMap2.get(m.a("002_dgdg")), null);
        CountDownLatch a11 = com.mob.tools.b.d.a(MobSDK.getContext()).a(str);
        try {
            HashMap hashMap3 = (HashMap) hashMap2.get(m.a("002d:bd"));
            countDownLatch = a11;
            try {
                String str2 = (String) ResHelper.forceCast((String) hashMap2.get(m.a("002a9ba")), m.a("006Rfcfcfdfdfdfd"));
                String str3 = "0047bhchSa-cd";
                long longValue = ((Long) ResHelper.forceCast(hashMap2.get(m.a("004dad,cg")), 5L)).longValue();
                HashMap hashMap4 = (HashMap) hashMap2.get(m.a("004QchYhaHba"));
                Integer num = (Integer) hashMap2.get(m.a("004Fch]d7bi*g"));
                HashMap hashMap5 = (HashMap) hashMap2.get(m.a("002[chGh"));
                HashMap hashMap6 = new HashMap();
                hashMap6.put(m.a("002 bi.f"), hashMap2.get(m.a("002 bi.f")));
                hashMap6.put(m.a("002*dgdg"), str);
                hashMap6.put(m.a("002d;bd"), hashMap3);
                hashMap6.put(m.a("002a6ba"), str2);
                hashMap6.put(m.a("004dad:cg"), Long.valueOf(longValue));
                hashMap6.put(m.a("004JchAdTbiFg"), num);
                hashMap6.put(m.a("003=bhbgba"), ResHelper.forceCast((String) hashMap2.get(m.a("003=bhbgba")), null));
                hashMap6.put(m.a("003Kdgbi7a"), hashMap2.get(m.a("003Kdgbi7a")));
                hashMap6.put(m.a("003_dgbg'g"), hashMap2.get(m.a("003_dgbg'g")));
                hashMap6.put("aps", hashMap2.get("aps"));
                hashMap6.put(m.a("005+dg@e1bg7g:dg"), hashMap2.get(m.a("005+dg@e1bg7g:dg")));
                hashMap6.put(m.a("0030bh.hg"), hashMap2.get(m.a("0030bh.hg")));
                hashMap6.put("ndi", hashMap2.get("ndi"));
                hashMap6.put("dm", hashMap2.get("dm"));
                Object obj = "sti";
                hashMap6.put(obj, hashMap2.get(obj));
                hashMap6.put(m.a(str3), ResHelper.forceCast(hashMap2.get(m.a(str3)), 86400));
                if (hashMap3 != null && hashMap3.size() > 0) {
                    if (TextUtils.isEmpty(str2)) {
                    }
                    a(hashMap6, hashMap, hashMap3, hashMap5, hashMap4, num, countDownLatch);
                    j.a().a(hashMap2, hashMap3, hashMap5);
                    hashMap2.put(m.a("010;baAdSbbbg6adUdabgbdQd"), Long.valueOf(System.currentTimeMillis()));
                    ab.a().c(HashonHelper.fromHashMap(hashMap));
                    r();
                    return countDownLatch;
                }
                if (hashMap5 != null && hashMap5.size() > 0 && hashMap4 != null && hashMap4.size() > 0) {
                    a(hashMap6, hashMap, hashMap3, hashMap5, hashMap4, num, countDownLatch);
                    j.a().a(hashMap2, hashMap3, hashMap5);
                }
                hashMap2.put(m.a("010;baAdSbbbg6adUdabgbdQd"), Long.valueOf(System.currentTimeMillis()));
                ab.a().c(HashonHelper.fromHashMap(hashMap));
                r();
            } catch (Throwable th2) {
                th = th2;
                MobLog.getInstance().d(th);
                return countDownLatch;
            }
        } catch (Throwable th3) {
            th = th3;
            countDownLatch = a11;
            MobLog.getInstance().d(th);
            return countDownLatch;
        }
        return countDownLatch;
    }

    private static <T> T a(HashMap<String, Object> hashMap, String str, T t11) {
        return (!TextUtils.isEmpty(str) && !b(hashMap) && a(hashMap)) ? ResHelper.forceCast(hashMap.get(str), t11) : t11;
    }

    public static <T> T a(String str, T t11, long j11) {
        try {
            if ((f27023e == null || f27023e.isEmpty()) && f27026h.getCount() > 0) {
                if (j11 > 0) {
                    f27026h.await(j11, TimeUnit.MILLISECONDS);
                } else {
                    f27026h.await();
                }
            }
            if (!d(str) && f27027i.getCount() > 0) {
                if (j11 > 0) {
                    f27027i.await(j11, TimeUnit.MILLISECONDS);
                } else {
                    f27027i.await();
                }
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
        return a(str, t11);
    }

    private static boolean a(HashMap<String, Object> hashMap) {
        return hashMap == null || ((Integer) ResHelper.forceCast(hashMap.get(m.a("002g)bi")), 0)).intValue() == 0;
    }

    public static boolean a() {
        if (((Integer) a(m.a("002g0bi"), 0)).intValue() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static void b(int i11) {
        MobLog.getInstance().d("b ob st", new Object[0]);
        if (!a() || !b()) {
            if (i11 == 3 || x.b()) {
                p();
            }
            o();
            return;
        }
        final String str = (String) a(m.a("003TcdQca"), (Object) null);
        if (TextUtils.isEmpty(str)) {
            if (i11 == 3 || x.b()) {
                p();
            }
            o();
        } else if (i11 == 3 || f27020b.compareAndSet(false, true)) {
            new j(m.a("003Rdjgjfi") + i11) {
                public void a() {
                    p.a(p.a(p.f27291d), false, new o() {
                        public boolean a(FileLocker fileLocker) {
                            synchronized (b.f27024f) {
                                b.e(str);
                            }
                            return false;
                        }
                    });
                }
            }.start();
        }
        if (!a() || !b()) {
            q();
            n();
            return;
        }
        final String str2 = (String) a("sbr", (Object) null);
        if (TextUtils.isEmpty(str2)) {
            n();
            q();
        } else if (i11 == 3 || f27021c.compareAndSet(false, true)) {
            new j("DS-" + i11) {
                public void a() {
                    p.a(p.a(p.f27292e), false, new o() {
                        public boolean a(FileLocker fileLocker) {
                            synchronized (b.f27025g) {
                                b.f(str2);
                            }
                            return false;
                        }
                    });
                }
            }.start();
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || !a() || !b() || ((Integer) a(str, 0)).intValue() == 0) {
            return false;
        }
        return true;
    }

    private static void a(HashMap<String, Object> hashMap, boolean z11) {
        f27023e = new HashMap<>();
        if (hashMap != null) {
            f27023e.putAll(hashMap);
        }
        if (z11) {
            try {
                f27026h.countDown();
                f27027i.countDown();
            } catch (Throwable unused) {
            }
        } else {
            f27026h.countDown();
        }
    }

    private static void a(boolean z11, boolean z12, boolean z13, int i11) {
        final boolean z14 = z11;
        final boolean z15 = z12;
        final boolean z16 = z13;
        final int i12 = i11;
        new j("PY-B" + i11) {
            public void a() {
                NLog instance = MobLog.getInstance();
                instance.d("b enter:" + Process.myPid() + ", lbms: " + b.f27028j + ", fc" + z14 + ", ol: " + z15 + ", gf: " + z16 + ", in: " + i12, new Object[0]);
                if (!b.f27028j) {
                    NLog instance2 = MobLog.getInstance();
                    instance2.d("b lk st: " + Process.myPid(), new Object[0]);
                    p.a(p.a(p.f27293f), new o() {
                        public boolean a(FileLocker fileLocker) {
                            boolean unused = b.f27028j = true;
                            NLog instance = MobLog.getInstance();
                            instance.d("b lk: " + Process.myPid() + ", proc st", new Object[0]);
                            long currentTimeMillis = System.currentTimeMillis();
                            b.c(z15);
                            AnonymousClass3 r42 = AnonymousClass3.this;
                            if (!z14 || z16) {
                                b.b(i12);
                            }
                            NLog instance2 = MobLog.getInstance();
                            instance2.d("b lk: " + Process.myPid() + ", proc ed, dur: " + (System.currentTimeMillis() - currentTimeMillis) + ", release: n", new Object[0]);
                            Looper.prepare();
                            Looper.loop();
                            return true;
                        }
                    });
                    return;
                }
                NLog instance3 = MobLog.getInstance();
                instance3.d("b lked already: " + Process.myPid(), new Object[0]);
                b.c(z15);
                if (!z14 || z16) {
                    b.b(i12);
                }
            }
        }.start();
    }

    private static void a(HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, HashMap<String, Object> hashMap3, HashMap<String, Object> hashMap4, HashMap<String, Object> hashMap5, Integer num, CountDownLatch countDownLatch) {
        if (num != null && num.intValue() == 2) {
            com.mob.tools.c.a.f27896b.set(Boolean.FALSE);
            try {
                countDownLatch.await(3500, TimeUnit.MILLISECONDS);
                MobLog.getInstance().d("dhs wt geot.2 ovr", new Object[0]);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        boolean a11 = j.a().a(true);
        j.a().c().put(m.a("006d!bdbfbhOdUdg"), Boolean.valueOf(a11));
        if (hashMap3 != null && hashMap3.size() > 0 && !a11) {
            MobLog.getInstance().d("dhs em dg", new Object[0]);
            hashMap2.clear();
            hashMap2.putAll(hashMap);
            hashMap2.putAll(hashMap3);
        } else if (hashMap4 == null || hashMap4.size() <= 0 || j.a().a(hashMap5)) {
            hashMap2.remove(m.a("002<ch h"));
            hashMap2.remove(m.a("002d<bd"));
        } else {
            MobLog.getInstance().d("dhs gpe dg", new Object[0]);
            hashMap2.clear();
            hashMap2.putAll(hashMap);
            hashMap2.putAll(hashMap4);
        }
    }

    /* access modifiers changed from: private */
    public static i b(final String str, final int i11) {
        return new i() {
            public void a() {
                com.mob.tools.c.a.f27896b.set(Boolean.TRUE);
                if (!TextUtils.isEmpty("M-")) {
                    Thread currentThread = Thread.currentThread();
                    currentThread.setName("M-" + str);
                }
                b.b((e<HashMap<String, Object>>) new e<HashMap<String, Object>>() {
                    public void a(HashMap<String, Object> hashMap) {
                        try {
                            b.b(hashMap, i11);
                            if (hashMap == null) {
                                l a11 = l.a();
                                AnonymousClass4 r32 = AnonymousClass4.this;
                                a11.e(300000, b.b(str, i11));
                            }
                        } finally {
                            b.f27022d.set(false);
                        }
                    }
                });
                com.mob.tools.c.a.f27896b.set(Boolean.FALSE);
            }
        };
    }

    /* access modifiers changed from: private */
    public static void b(HashMap<String, Object> hashMap, int i11) {
        if (hashMap == null) {
            HashMap<String, Object> fromJson = HashonHelper.fromJson(ab.a().d());
            if (!b(fromJson)) {
                hashMap = fromJson;
            }
            ab.a().e();
        }
        CountDownLatch countDownLatch = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            countDownLatch = c(hashMap);
        }
        a(hashMap, true);
        com.mob.tools.c.a.f27896b.set(Boolean.FALSE);
        if (((Integer) a("dm", 1)).intValue() == 1 && f27031m.compareAndSet(false, true)) {
            i.a().b();
        }
        if (!f27030l) {
            s();
        }
        if (countDownLatch == null) {
            countDownLatch = com.mob.tools.b.d.a(MobSDK.getContext()).a();
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            NLog instance = MobLog.getInstance();
            instance.d("ge dhs_w cdl: " + countDownLatch, new Object[0]);
            countDownLatch.await(3500, TimeUnit.MILLISECONDS);
            NLog instance2 = MobLog.getInstance();
            instance2.d("ge dhs_w end, dur: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
        a(false, true, true, i11);
    }

    private static void a(String... strArr) {
        File filesDir = MobSDK.getContext().getFilesDir();
        for (String file : strArr) {
            try {
                v.a(new File(filesDir, file));
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(final e<HashMap<String, Object>> eVar) {
        com.mob.tools.c.a.f27896b.set(Boolean.TRUE);
        DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().getODH().request(new DH.DHResponder() {
            public void onResponse(DH.DHResponse dHResponse) {
                com.mob.tools.c.a.f27896b.set(Boolean.TRUE);
                try {
                    HashMap a11 = b.b(dHResponse);
                    long j11 = 1;
                    while (b.f27032n.get() > 0 && (a11 == null || a11.isEmpty())) {
                        Thread.sleep(1000 * j11);
                        a11 = b.b(dHResponse);
                        if (a11 == null || a11.isEmpty()) {
                            b.f27032n.getAndDecrement();
                            j11 *= 2;
                        }
                    }
                    e.this.a(a11);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                    e.this.a(null);
                }
            }
        });
    }

    private static boolean b(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            long longValue = ((Long) ResHelper.forceCast(hashMap.get(m.a("010Aba9dCbbbgKadQdabgbd;d")), 0L)).longValue();
            long intValue = ((long) ((Integer) ResHelper.forceCast(hashMap.get(m.a("004Mbhch^aZcd")), 86400)).intValue()) * 1000;
            if (longValue != 0) {
                int i11 = (intValue > 0 ? 1 : (intValue == 0 ? 0 : -1));
                if (i11 > 0) {
                    if (System.currentTimeMillis() - longValue >= intValue) {
                        return true;
                    }
                    return false;
                } else if (i11 != 0) {
                    return !v.a(System.currentTimeMillis(), longValue);
                } else {
                    if (System.currentTimeMillis() - longValue >= Period.DAY_MILLS) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static HashMap<String, Object> b(DH.DHResponse dHResponse) {
        try {
            String packageName = DH.SyncMtd.getPackageName();
            String a11 = u.a();
            HashMap hashMap = new HashMap();
            hashMap.put(m.a("003^cf6dDca"), a11);
            hashMap.put(m.a("013Lcidg?d3bhficcbaWdcg*bg>g-ca"), aa.f());
            hashMap.put(m.a("004Ubdbibgba"), dHResponse.getODH());
            HashMap<String, Object> a12 = u.a(dHResponse.getDetailNetworkTypeForStatic());
            a12.put(m.a("002g0dg"), String.valueOf(System.currentTimeMillis()));
            int i11 = 1;
            a12.put("nbs", 1);
            int privacyGrantedStatus = MobSDK.getPrivacyGrantedStatus();
            if (privacyGrantedStatus != -1) {
                a12.put(m.a("009?bgdgdbchbh9dd*ej)h"), String.valueOf(privacyGrantedStatus == 1));
            }
            String a13 = m.a("002*bbff");
            if (!MobSDK.checkV6()) {
                i11 = -1;
            }
            a12.put(a13, String.valueOf(i11));
            a12.put("ait", Long.valueOf(ab.a().q()));
            String b11 = e.b();
            if (!TextUtils.isEmpty(b11)) {
                a12.put("psid", b11 + packageName);
            }
            String httpGet = new NetworkHelper().httpGet(i.a().a("gcfg") + "/v6/gcf", a12, hashMap);
            HashMap fromJson = HashonHelper.fromJson(httpGet);
            if (fromJson.isEmpty()) {
                return null;
            }
            if (JumioRejectReason.NOT_READABLE.equals(String.valueOf(fromJson.get(m.a("006 dg)gbg;bedg"))))) {
                byte[] rawMD5 = Data.rawMD5((a11 + ":" + packageName + ":" + fromJson.get(m.a("009g7bgbdVdCdg9gb<bd=h"))).getBytes("utf-8"));
                String str = (String) ResHelper.forceCast(fromJson.get(m.a("002(dg,a")));
                if (str != null) {
                    String str2 = new String(Data.AES128Decode(rawMD5, Base64.decode(str, 2)), "utf-8");
                    MobLog.getInstance().d("sw: " + str2, new Object[0]);
                    HashMap<String, Object> fromJson2 = HashonHelper.fromJson(str2);
                    if (!fromJson2.isEmpty()) {
                        fromJson2.put(m.a("010[ba?d7bbbg'ad<dabgbd@d"), Long.valueOf(SystemClock.elapsedRealtime()));
                        ab.a().d(HashonHelper.fromHashMap(fromJson2));
                        return fromJson2;
                    }
                    throw new Throwable("RS is illegal: " + httpGet);
                }
                throw new Throwable("RS is illegal: " + httpGet);
            }
            throw new Throwable("RS is illegal: " + httpGet);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }
}
