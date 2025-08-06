package com.mob.tools.b;

import android.content.Context;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.C0891r;
import com.mob.commons.ab;
import com.mob.commons.b;
import com.mob.commons.cc.a;
import com.mob.commons.z;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f27769a = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f27770d = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f27771b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, Object> f27772c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f27773e = new byte[0];
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f27774f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private volatile File f27775g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ConcurrentLinkedQueue<CountDownLatch> f27776h = new ConcurrentLinkedQueue<>();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile String f27777i = null;

    /* renamed from: j  reason: collision with root package name */
    private volatile int f27778j = -1;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public long f27779k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public long f27780l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public long f27781m;

    private d(Context context) {
        this.f27771b = context;
    }

    private String e() {
        try {
            String str = (String) b.b(C0891r.b("002[eheh"), null);
            return str == null ? (String) b.b(C0891r.b("009;eheecidkefch;hbg"), null) : str;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public static boolean c() {
        return f27770d;
    }

    public CountDownLatch d() {
        ConcurrentLinkedQueue<CountDownLatch> concurrentLinkedQueue = this.f27776h;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return null;
        }
        return this.f27776h.peek();
    }

    /* access modifiers changed from: private */
    public String c(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("#")) == null || split.length != 2) {
            return null;
        }
        return split[1];
    }

    public int b() {
        return this.f27778j;
    }

    /* access modifiers changed from: private */
    public String b(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("#")) == null || split.length != 2) {
            return null;
        }
        return split[0];
    }

    private void d(String str) {
        File dataCacheFile = ResHelper.getDataCacheFile(this.f27771b, str);
        if (dataCacheFile.exists() && dataCacheFile.length() > 0) {
            dataCacheFile.delete();
        }
    }

    /* access modifiers changed from: private */
    public boolean e(String str) {
        return !TextUtils.isEmpty(b(str)) && !TextUtils.isEmpty(c(str));
    }

    public static d a(Context context) {
        if (f27769a == null) {
            synchronized (d.class) {
                if (f27769a == null) {
                    f27769a = new d(context);
                }
            }
        }
        return f27769a;
    }

    /* access modifiers changed from: private */
    public File b(File file, String str) {
        if (!file.exists()) {
            file.mkdirs();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d(str);
        return new File(file, str);
    }

    public final CountDownLatch a() {
        return a(e());
    }

    public void a(int i11) {
        this.f27778j = i11;
    }

    public final CountDownLatch a(final String str) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        NLog instance = MobLog.getInstance();
        instance.d("dhs ofr: " + countDownLatch, new Object[0]);
        this.f27776h.offer(countDownLatch);
        z.f27387f.execute(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(11:(3:29|30|(18:32|(1:34)|35|36|37|40|41|(1:48)(1:47)|49|(2:51|(1:53)(2:54|(1:56)(1:57)))(1:58)|59|(2:63|(5:68|69|(1:71)|72|73)(1:67))|74|75|(2:79|80)|91|92|93))|38|40|41|(0)(0)|49|(0)(0)|59|61|63|(0)(0)) */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x012e, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x021f, code lost:
                return;
             */
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0283 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x03cc */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x0298 A[Catch:{ all -> 0x04aa, all -> 0x05aa, all -> 0x067e }] */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x029a A[Catch:{ all -> 0x04aa, all -> 0x05aa, all -> 0x067e }] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x02bb A[Catch:{ all -> 0x04aa, all -> 0x05aa, all -> 0x067e }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0328 A[Catch:{ all -> 0x04aa, all -> 0x05aa, all -> 0x067e }] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x0388 A[Catch:{ all -> 0x04aa, all -> 0x05aa, all -> 0x067e }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x03c3 A[SYNTHETIC, Splitter:B:68:0x03c3] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r16 = this;
                    r1 = r16
                    com.mob.tools.b.d r2 = com.mob.tools.b.d.this
                    byte[] r2 = r2.f27773e
                    monitor-enter(r2)
                    java.lang.ThreadLocal<java.lang.Boolean> r3 = com.mob.tools.c.a.f27897c     // Catch:{ all -> 0x067e }
                    java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x067e }
                    r3.set(r4)     // Catch:{ all -> 0x067e }
                    long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x067e }
                    r5 = 11
                    r6 = 3
                    r7 = 3500(0xdac, double:1.729E-320)
                    r9 = 16
                    r10 = 0
                    com.mob.tools.log.NLog r11 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x04aa }
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x04aa }
                    r12.<init>()     // Catch:{ all -> 0x04aa }
                    java.lang.String r13 = "dhs stch: "
                    r12.append(r13)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r13 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.lang.String r14 = r5     // Catch:{ all -> 0x04aa }
                    boolean r13 = r13.e((java.lang.String) r14)     // Catch:{ all -> 0x04aa }
                    r12.append(r13)     // Catch:{ all -> 0x04aa }
                    java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x04aa }
                    java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ all -> 0x04aa }
                    r11.d(r12, r13)     // Catch:{ all -> 0x04aa }
                    java.io.File r11 = new java.io.File     // Catch:{ all -> 0x04aa }
                    android.content.Context r12 = com.mob.MobSDK.getContext()     // Catch:{ all -> 0x04aa }
                    java.io.File r12 = r12.getFilesDir()     // Catch:{ all -> 0x04aa }
                    java.lang.String r13 = "003PcbcbTg"
                    java.lang.String r13 = com.mob.commons.C0891r.b(r13)     // Catch:{ all -> 0x04aa }
                    r11.<init>(r12, r13)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r12 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.lang.String r13 = r5     // Catch:{ all -> 0x04aa }
                    boolean r12 = r12.e((java.lang.String) r13)     // Catch:{ all -> 0x04aa }
                    if (r12 != 0) goto L_0x012f
                    boolean unused = com.mob.tools.b.d.f27770d = r10     // Catch:{ all -> 0x04aa }
                    com.mob.tools.utils.ResHelper.deleteFileAndFolder(r11)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r11 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x067e }
                    long r12 = r12 - r3
                    long unused = r11.f27781m = r12     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r11 = "dhs ctd: "
                    r4.append(r11)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r11 = r0     // Catch:{ all -> 0x067e }
                    r4.append(r11)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r11)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r3 = r0     // Catch:{ all -> 0x067e }
                    r3.countDown()     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.util.concurrent.ConcurrentLinkedQueue r3 = r3.f27776h     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r4 = r0     // Catch:{ all -> 0x067e }
                    r3.remove(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r11 = "dhs tt "
                    r4.append(r11)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r11 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r11 = r11.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r11)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r10)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r3 = r3.f27781m     // Catch:{ all -> 0x067e }
                    int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                    if (r3 <= 0) goto L_0x012d
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    int r3 = r3.b()     // Catch:{ all -> 0x067e }
                    if (r3 != r9) goto L_0x012d
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r7 = "-t-"
                    r4.append(r7)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r7 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r7 = r7.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r7)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    r3.<init>(r4)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-d-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r7 = r4.f27780l     // Catch:{ all -> 0x067e }
                    r3.append(r7)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-l-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r7 = r4.f27779k     // Catch:{ all -> 0x067e }
                    r3.append(r7)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = " "
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.commons.g r4 = com.mob.commons.g.a()     // Catch:{ all -> 0x067e }
                    java.lang.Throwable r7 = new java.lang.Throwable     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r7.<init>(r3)     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r3.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r8 = ""
                    r3.append(r8)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r8 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.lang.String r8 = r8.f27777i     // Catch:{ all -> 0x067e }
                    r3.append(r8)     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r4.a((int) r6, (int) r5, (java.lang.Throwable) r7, (java.lang.String) r3)     // Catch:{ all -> 0x067e }
                L_0x012d:
                    monitor-exit(r2)     // Catch:{ all -> 0x067e }
                    return
                L_0x012f:
                    com.mob.tools.b.d r12 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    r12.a((int) r10)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r12 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.lang.String r13 = r5     // Catch:{ all -> 0x04aa }
                    java.lang.String r12 = r12.b((java.lang.String) r13)     // Catch:{ all -> 0x04aa }
                    boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x04aa }
                    if (r13 == 0) goto L_0x0220
                    boolean unused = com.mob.tools.b.d.f27770d = r10     // Catch:{ all -> 0x04aa }
                    com.mob.commons.g r11 = com.mob.commons.g.a()     // Catch:{ all -> 0x04aa }
                    r12 = -1
                    r13 = 4
                    java.lang.String r14 = ""
                    java.lang.String r15 = ""
                    r11.a((int) r12, (int) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r11 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x067e }
                    long r12 = r12 - r3
                    long unused = r11.f27781m = r12     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r11 = "dhs ctd: "
                    r4.append(r11)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r11 = r0     // Catch:{ all -> 0x067e }
                    r4.append(r11)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r11)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r3 = r0     // Catch:{ all -> 0x067e }
                    r3.countDown()     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.util.concurrent.ConcurrentLinkedQueue r3 = r3.f27776h     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r4 = r0     // Catch:{ all -> 0x067e }
                    r3.remove(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r11 = "dhs tt "
                    r4.append(r11)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r11 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r11 = r11.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r11)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r10)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r3 = r3.f27781m     // Catch:{ all -> 0x067e }
                    int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
                    if (r3 <= 0) goto L_0x021e
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    int r3 = r3.b()     // Catch:{ all -> 0x067e }
                    if (r3 != r9) goto L_0x021e
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r7 = "-t-"
                    r4.append(r7)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r7 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r7 = r7.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r7)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    r3.<init>(r4)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-d-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r7 = r4.f27780l     // Catch:{ all -> 0x067e }
                    r3.append(r7)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-l-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r7 = r4.f27779k     // Catch:{ all -> 0x067e }
                    r3.append(r7)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = " "
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.commons.g r4 = com.mob.commons.g.a()     // Catch:{ all -> 0x067e }
                    java.lang.Throwable r7 = new java.lang.Throwable     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r7.<init>(r3)     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r3.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r8 = ""
                    r3.append(r8)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r8 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.lang.String r8 = r8.f27777i     // Catch:{ all -> 0x067e }
                    r3.append(r8)     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r4.a((int) r6, (int) r5, (java.lang.Throwable) r7, (java.lang.String) r3)     // Catch:{ all -> 0x067e }
                L_0x021e:
                    monitor-exit(r2)     // Catch:{ all -> 0x067e }
                    return
                L_0x0220:
                    boolean r13 = com.mob.tools.utils.DH.SyncMtd.isInMainProcess()     // Catch:{ all -> 0x0282 }
                    if (r13 != 0) goto L_0x0282
                    java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0282 }
                    r13.<init>()     // Catch:{ all -> 0x0282 }
                    java.lang.String r14 = com.mob.tools.utils.DH.SyncMtd.getCurrentProcessName()     // Catch:{ all -> 0x0282 }
                    r13.append(r14)     // Catch:{ all -> 0x0282 }
                    java.lang.String r14 = ""
                    r13.append(r14)     // Catch:{ all -> 0x0282 }
                    java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0282 }
                    java.lang.String r14 = com.mob.tools.utils.DH.SyncMtd.getPackageName()     // Catch:{ all -> 0x0282 }
                    boolean r15 = r13.contains(r14)     // Catch:{ all -> 0x0282 }
                    if (r15 == 0) goto L_0x024b
                    java.lang.String r15 = ""
                    java.lang.String r13 = r13.replace(r14, r15)     // Catch:{ all -> 0x0282 }
                L_0x024b:
                    java.lang.String r14 = ":"
                    java.lang.String r15 = ""
                    java.lang.String r13 = r13.replace(r14, r15)     // Catch:{ all -> 0x0282 }
                    java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0282 }
                    r14.<init>()     // Catch:{ all -> 0x0282 }
                    r14.append(r12)     // Catch:{ all -> 0x0282 }
                    java.lang.String r15 = "_"
                    r14.append(r15)     // Catch:{ all -> 0x0282 }
                    r14.append(r13)     // Catch:{ all -> 0x0282 }
                    java.lang.String r13 = r14.toString()     // Catch:{ all -> 0x0282 }
                    com.mob.tools.log.NLog r14 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0283 }
                    java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0283 }
                    r15.<init>()     // Catch:{ all -> 0x0283 }
                    java.lang.String r5 = "dhs cld nm "
                    r15.append(r5)     // Catch:{ all -> 0x0283 }
                    r15.append(r13)     // Catch:{ all -> 0x0283 }
                    java.lang.String r5 = r15.toString()     // Catch:{ all -> 0x0283 }
                    java.lang.Object[] r15 = new java.lang.Object[r10]     // Catch:{ all -> 0x0283 }
                    r14.d(r5, r15)     // Catch:{ all -> 0x0283 }
                    goto L_0x0283
                L_0x0282:
                    r13 = r12
                L_0x0283:
                    com.mob.tools.b.d r5 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.io.File r5 = r5.b((java.io.File) r11, (java.lang.String) r13)     // Catch:{ all -> 0x04aa }
                    r11 = 1
                    if (r5 == 0) goto L_0x029a
                    boolean r13 = r5.exists()     // Catch:{ all -> 0x04aa }
                    if (r13 == 0) goto L_0x029a
                    boolean r13 = r5.isFile()     // Catch:{ all -> 0x04aa }
                    if (r13 == 0) goto L_0x029a
                    r13 = r11
                    goto L_0x029b
                L_0x029a:
                    r13 = r10
                L_0x029b:
                    com.mob.tools.log.NLog r14 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x04aa }
                    java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x04aa }
                    r15.<init>()     // Catch:{ all -> 0x04aa }
                    java.lang.String r6 = "dhs cac: "
                    r15.append(r6)     // Catch:{ all -> 0x04aa }
                    r15.append(r13)     // Catch:{ all -> 0x04aa }
                    java.lang.String r6 = r15.toString()     // Catch:{ all -> 0x04aa }
                    java.lang.Object[] r15 = new java.lang.Object[r10]     // Catch:{ all -> 0x04aa }
                    r14.d(r6, r15)     // Catch:{ all -> 0x04aa }
                    java.lang.String r6 = com.mob.tools.utils.Data.MD5((java.io.File) r5)     // Catch:{ all -> 0x04aa }
                    if (r13 == 0) goto L_0x0328
                    com.mob.tools.b.d r13 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    r14 = 5
                    r13.a((int) r14)     // Catch:{ all -> 0x04aa }
                    boolean r13 = r12.equals(r6)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.log.NLog r14 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x04aa }
                    java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x04aa }
                    r15.<init>()     // Catch:{ all -> 0x04aa }
                    java.lang.String r7 = "dhs m5: "
                    r15.append(r7)     // Catch:{ all -> 0x04aa }
                    r15.append(r13)     // Catch:{ all -> 0x04aa }
                    java.lang.String r7 = r15.toString()     // Catch:{ all -> 0x04aa }
                    java.lang.Object[] r8 = new java.lang.Object[r10]     // Catch:{ all -> 0x04aa }
                    r14.d(r7, r8)     // Catch:{ all -> 0x04aa }
                    if (r13 != 0) goto L_0x02f4
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    r7 = 6
                    r6.a((int) r7)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.lang.String r7 = r5     // Catch:{ all -> 0x04aa }
                    java.lang.String r7 = r6.c((java.lang.String) r7)     // Catch:{ all -> 0x04aa }
                    java.lang.String r6 = r6.a((java.lang.String) r7, (java.io.File) r5, (java.lang.String) r12)     // Catch:{ all -> 0x04aa }
                    goto L_0x033b
                L_0x02f4:
                    com.mob.tools.log.NLog r7 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x04aa }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x04aa }
                    r8.<init>()     // Catch:{ all -> 0x04aa }
                    java.lang.String r12 = "dhs tbm: "
                    r8.append(r12)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r12 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.util.concurrent.atomic.AtomicBoolean r12 = r12.f27774f     // Catch:{ all -> 0x04aa }
                    boolean r12 = r12.get()     // Catch:{ all -> 0x04aa }
                    r8.append(r12)     // Catch:{ all -> 0x04aa }
                    java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x04aa }
                    java.lang.Object[] r12 = new java.lang.Object[r10]     // Catch:{ all -> 0x04aa }
                    r7.d(r8, r12)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r7 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.util.concurrent.atomic.AtomicBoolean r7 = r7.f27774f     // Catch:{ all -> 0x04aa }
                    boolean r7 = r7.compareAndSet(r10, r11)     // Catch:{ all -> 0x04aa }
                    if (r7 == 0) goto L_0x0325
                    goto L_0x033b
                L_0x0325:
                    java.lang.String r6 = ""
                    goto L_0x033b
                L_0x0328:
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    r7 = 8
                    r6.a((int) r7)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.lang.String r7 = r5     // Catch:{ all -> 0x04aa }
                    java.lang.String r7 = r6.c((java.lang.String) r7)     // Catch:{ all -> 0x04aa }
                    java.lang.String r6 = r6.a((java.lang.String) r7, (java.io.File) r5, (java.lang.String) r12)     // Catch:{ all -> 0x04aa }
                L_0x033b:
                    com.mob.tools.log.NLog r7 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x04aa }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x04aa }
                    r8.<init>()     // Catch:{ all -> 0x04aa }
                    java.lang.String r11 = "dhs cl:  tm5: "
                    r8.append(r11)     // Catch:{ all -> 0x04aa }
                    r8.append(r6)     // Catch:{ all -> 0x04aa }
                    java.lang.String r11 = ", cm5: "
                    r8.append(r11)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r11 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.lang.String r11 = r11.f27777i     // Catch:{ all -> 0x04aa }
                    r8.append(r11)     // Catch:{ all -> 0x04aa }
                    java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x04aa }
                    java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x04aa }
                    r7.d(r8, r11)     // Catch:{ all -> 0x04aa }
                    boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x04aa }
                    if (r7 != 0) goto L_0x03d7
                    com.mob.tools.b.d r7 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.lang.String r7 = r7.f27777i     // Catch:{ all -> 0x04aa }
                    boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x04aa }
                    if (r7 != 0) goto L_0x03d7
                    com.mob.tools.b.d r7 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    r7.a((java.io.File) r5)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r7 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.util.HashMap r6 = r7.a((java.io.File) r5, (java.lang.String) r6)     // Catch:{ all -> 0x04aa }
                    if (r6 == 0) goto L_0x03c3
                    boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x04aa }
                    if (r7 != 0) goto L_0x03c3
                    com.mob.tools.log.NLog r7 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x04aa }
                    java.lang.String r8 = "dhs l succ"
                    java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ all -> 0x04aa }
                    r7.d(r8, r11)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.f r7 = new com.mob.tools.b.f     // Catch:{ all -> 0x04aa }
                    r7.<init>(r6)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    java.lang.String r5 = com.mob.tools.utils.Data.MD5((java.io.File) r5)     // Catch:{ all -> 0x04aa }
                    java.lang.String unused = r6.f27777i = r5     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r5 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    android.content.Context r5 = r5.f27771b     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.c r5 = com.mob.tools.b.c.a((android.content.Context) r5)     // Catch:{ all -> 0x04aa }
                    boolean r5 = r5.a((com.mob.tools.b.a) r7)     // Catch:{ all -> 0x04aa }
                    boolean unused = com.mob.tools.b.d.f27770d = r5     // Catch:{ all -> 0x04aa }
                    com.mob.tools.b.d r5 = com.mob.tools.b.d.this     // Catch:{ all -> 0x04aa }
                    r5.a((int) r9)     // Catch:{ all -> 0x04aa }
                    com.mob.tools.log.NLog r5 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x04aa }
                    java.lang.String r6 = "dhs fin"
                    java.lang.Object[] r7 = new java.lang.Object[r10]     // Catch:{ all -> 0x04aa }
                    r5.d(r6, r7)     // Catch:{ all -> 0x04aa }
                    goto L_0x03d7
                L_0x03c3:
                    boolean r6 = r5.exists()     // Catch:{ all -> 0x03cc }
                    if (r6 == 0) goto L_0x03cc
                    r5.delete()     // Catch:{ all -> 0x03cc }
                L_0x03cc:
                    com.mob.tools.log.NLog r5 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x04aa }
                    java.lang.String r6 = "dhs l fail"
                    java.lang.Object[] r7 = new java.lang.Object[r10]     // Catch:{ all -> 0x04aa }
                    r5.d(r6, r7)     // Catch:{ all -> 0x04aa }
                L_0x03d7:
                    com.mob.tools.b.d r5 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x067e }
                    long r6 = r6 - r3
                    long unused = r5.f27781m = r6     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r5 = "dhs ctd: "
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r5 = r0     // Catch:{ all -> 0x067e }
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r5 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r5)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r3 = r0     // Catch:{ all -> 0x067e }
                    r3.countDown()     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.util.concurrent.ConcurrentLinkedQueue r3 = r3.f27776h     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r4 = r0     // Catch:{ all -> 0x067e }
                    r3.remove(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r5 = "dhs tt "
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r5 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r5 = r5.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r5 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r5)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r3 = r3.f27781m     // Catch:{ all -> 0x067e }
                    r5 = 3500(0xdac, double:1.729E-320)
                    int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r3 <= 0) goto L_0x05a1
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    int r3 = r3.b()     // Catch:{ all -> 0x067e }
                    if (r3 != r9) goto L_0x05a1
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r5 = "-t-"
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r5 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r5 = r5.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    r3.<init>(r4)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-d-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r4 = r4.f27780l     // Catch:{ all -> 0x067e }
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-l-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r4 = r4.f27779k     // Catch:{ all -> 0x067e }
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = " "
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.commons.g r4 = com.mob.commons.g.a()     // Catch:{ all -> 0x067e }
                    java.lang.Throwable r5 = new java.lang.Throwable     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r5.<init>(r3)     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r3.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r6 = ""
                    r3.append(r6)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.lang.String r6 = r6.f27777i     // Catch:{ all -> 0x067e }
                    r3.append(r6)     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r6 = 11
                    r7 = 3
                L_0x04a5:
                    r4.a((int) r7, (int) r6, (java.lang.Throwable) r5, (java.lang.String) r3)     // Catch:{ all -> 0x067e }
                    goto L_0x05a1
                L_0x04aa:
                    r0 = move-exception
                    r5 = r0
                    com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x05aa }
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x05aa }
                    r7.<init>()     // Catch:{ all -> 0x05aa }
                    java.lang.String r8 = "dhs oops: "
                    r7.append(r8)     // Catch:{ all -> 0x05aa }
                    java.lang.String r8 = r5.getMessage()     // Catch:{ all -> 0x05aa }
                    r7.append(r8)     // Catch:{ all -> 0x05aa }
                    java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x05aa }
                    java.lang.Object[] r8 = new java.lang.Object[r10]     // Catch:{ all -> 0x05aa }
                    r6.d(r7, r8)     // Catch:{ all -> 0x05aa }
                    com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x05aa }
                    r6.d(r5)     // Catch:{ all -> 0x05aa }
                    com.mob.tools.b.d r5 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x067e }
                    long r6 = r6 - r3
                    long unused = r5.f27781m = r6     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r5 = "dhs ctd: "
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r5 = r0     // Catch:{ all -> 0x067e }
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r5 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r5)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r3 = r0     // Catch:{ all -> 0x067e }
                    r3.countDown()     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.util.concurrent.ConcurrentLinkedQueue r3 = r3.f27776h     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r4 = r0     // Catch:{ all -> 0x067e }
                    r3.remove(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r5 = "dhs tt "
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r5 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r5 = r5.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r5 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r5)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r3 = r3.f27781m     // Catch:{ all -> 0x067e }
                    r5 = 3500(0xdac, double:1.729E-320)
                    int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r3 <= 0) goto L_0x05a1
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    int r3 = r3.b()     // Catch:{ all -> 0x067e }
                    if (r3 != r9) goto L_0x05a1
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r5 = "-t-"
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r5 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r5 = r5.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r5)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    r3.<init>(r4)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-d-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r4 = r4.f27780l     // Catch:{ all -> 0x067e }
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-l-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r4 = r4.f27779k     // Catch:{ all -> 0x067e }
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = " "
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.commons.g r4 = com.mob.commons.g.a()     // Catch:{ all -> 0x067e }
                    java.lang.Throwable r5 = new java.lang.Throwable     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r5.<init>(r3)     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r3.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r6 = ""
                    r3.append(r6)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.lang.String r6 = r6.f27777i     // Catch:{ all -> 0x067e }
                    r3.append(r6)     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r6 = 11
                    r7 = 3
                    goto L_0x04a5
                L_0x05a1:
                    java.lang.ThreadLocal<java.lang.Boolean> r3 = com.mob.tools.c.a.f27897c     // Catch:{ all -> 0x067e }
                    java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x067e }
                    r3.set(r4)     // Catch:{ all -> 0x067e }
                    monitor-exit(r2)     // Catch:{ all -> 0x067e }
                    return
                L_0x05aa:
                    r0 = move-exception
                    r5 = r0
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x067e }
                    long r7 = r7 - r3
                    long unused = r6.f27781m = r7     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r6 = "dhs ctd: "
                    r4.append(r6)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r6 = r0     // Catch:{ all -> 0x067e }
                    r4.append(r6)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r6 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r6)     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r3 = r0     // Catch:{ all -> 0x067e }
                    r3.countDown()     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.util.concurrent.ConcurrentLinkedQueue r3 = r3.f27776h     // Catch:{ all -> 0x067e }
                    java.util.concurrent.CountDownLatch r4 = r0     // Catch:{ all -> 0x067e }
                    r3.remove(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r6 = "dhs tt "
                    r4.append(r6)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r6 = r6.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r6)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    java.lang.Object[] r6 = new java.lang.Object[r10]     // Catch:{ all -> 0x067e }
                    r3.d(r4, r6)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r3 = r3.f27781m     // Catch:{ all -> 0x067e }
                    r6 = 3500(0xdac, double:1.729E-320)
                    int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                    if (r3 <= 0) goto L_0x067d
                    com.mob.tools.b.d r3 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    int r3 = r3.b()     // Catch:{ all -> 0x067e }
                    if (r3 != r9) goto L_0x067d
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r4.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r6 = "-t-"
                    r4.append(r6)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r6 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r6 = r6.f27781m     // Catch:{ all -> 0x067e }
                    r4.append(r6)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x067e }
                    r3.<init>(r4)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-d-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r6 = r4.f27780l     // Catch:{ all -> 0x067e }
                    r3.append(r6)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = "-l-"
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r4 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    long r6 = r4.f27779k     // Catch:{ all -> 0x067e }
                    r3.append(r6)     // Catch:{ all -> 0x067e }
                    java.lang.String r4 = " "
                    r3.append(r4)     // Catch:{ all -> 0x067e }
                    com.mob.commons.g r4 = com.mob.commons.g.a()     // Catch:{ all -> 0x067e }
                    java.lang.Throwable r6 = new java.lang.Throwable     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r6.<init>(r3)     // Catch:{ all -> 0x067e }
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
                    r3.<init>()     // Catch:{ all -> 0x067e }
                    java.lang.String r7 = ""
                    r3.append(r7)     // Catch:{ all -> 0x067e }
                    com.mob.tools.b.d r7 = com.mob.tools.b.d.this     // Catch:{ all -> 0x067e }
                    java.lang.String r7 = r7.f27777i     // Catch:{ all -> 0x067e }
                    r3.append(r7)     // Catch:{ all -> 0x067e }
                    java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x067e }
                    r7 = 11
                    r8 = 3
                    r4.a((int) r8, (int) r7, (java.lang.Throwable) r6, (java.lang.String) r3)     // Catch:{ all -> 0x067e }
                L_0x067d:
                    throw r5     // Catch:{ all -> 0x067e }
                L_0x067e:
                    r0 = move-exception
                    r3 = r0
                    monitor-exit(r2)     // Catch:{ all -> 0x067e }
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.d.AnonymousClass1.run():void");
            }
        });
        return countDownLatch;
    }

    /* access modifiers changed from: private */
    public void a(File file) {
        if (this.f27775g != null && this.f27775g.exists()) {
            if (this.f27775g.delete()) {
                MobLog.getInstance().d("dhs dof succ", new Object[0]);
            } else {
                MobLog.getInstance().d("dhs dof fail", new Object[0]);
            }
        }
        this.f27775g = file;
    }

    /* access modifiers changed from: private */
    public HashMap<String, Object> a(File file, String str) {
        HashMap hashMap = new HashMap();
        String c11 = ab.a().c();
        if (TextUtils.isEmpty(c11)) {
            c11 = HashonHelper.fromHashMap(hashMap);
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        if (this.f27772c == null) {
            HashMap<String, Object> hashMap3 = new HashMap<>();
            this.f27772c = hashMap3;
            hashMap3.put("cacheMap", new ConcurrentHashMap());
            this.f27772c.put("invokeTimesMap", new ConcurrentHashMap());
            this.f27772c.put("expireTimeMap", new ConcurrentHashMap());
        }
        String str2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a.a(MobSDK.getContext(), file.getAbsolutePath(), c11, hashMap2, this.f27772c);
            this.f27779k = System.currentTimeMillis() - currentTimeMillis;
            if (TextUtils.isEmpty((CharSequence) null)) {
                str2 = String.format("dhs l %d", new Object[]{Long.valueOf(this.f27779k)});
            }
            MobLog.getInstance().d(str2, new Object[0]);
        } catch (Throwable unused) {
        }
        return hashMap2;
        this.f27779k = System.currentTimeMillis() - currentTimeMillis;
        if (TextUtils.isEmpty(str2)) {
            str2 = String.format("dhs l %d", new Object[]{Long.valueOf(this.f27779k)});
        }
        MobLog.getInstance().d(str2, new Object[0]);
        return hashMap2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.CharSequence, com.mob.tools.network.NetworkHelper$NetworkTimeOut] */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00af A[Catch:{ all -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f6 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r12, java.io.File r13, java.lang.String r14) {
        /*
            r11 = this;
            java.lang.String r0 = "dhs d %d"
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x013e
            if (r13 == 0) goto L_0x013e
            long r3 = java.lang.System.currentTimeMillis()
            r1 = 0
            r5 = 1
            r6 = 0
            boolean r7 = r13.exists()     // Catch:{ all -> 0x00a7 }
            if (r7 == 0) goto L_0x001c
            r13.delete()     // Catch:{ all -> 0x00a7 }
        L_0x001c:
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x00a7 }
            r7.<init>(r13)     // Catch:{ all -> 0x00a7 }
            com.mob.tools.log.NLog r8 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00a5 }
            java.lang.String r9 = "dhs d..."
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ all -> 0x00a5 }
            r8.d(r9, r10)     // Catch:{ all -> 0x00a5 }
            com.mob.tools.network.NetworkHelper r8 = new com.mob.tools.network.NetworkHelper     // Catch:{ all -> 0x00a5 }
            r8.<init>()     // Catch:{ all -> 0x00a5 }
            r8.download(r12, r7, r1)     // Catch:{ all -> 0x00a5 }
            java.lang.String r12 = com.mob.tools.utils.Data.MD5((java.io.File) r13)     // Catch:{ all -> 0x00a5 }
            boolean r8 = android.text.TextUtils.equals(r14, r12)     // Catch:{ all -> 0x00a5 }
            if (r8 != 0) goto L_0x007b
            com.mob.commons.g r12 = com.mob.commons.g.a()     // Catch:{ all -> 0x00a5 }
            r8 = -1
            r9 = 20
            r12.a((int) r8, (int) r9, (java.lang.String) r2, (java.lang.String) r14)     // Catch:{ all -> 0x00a5 }
            boolean r12 = r13.exists()     // Catch:{ all -> 0x00a5 }
            if (r12 == 0) goto L_0x0051
            r13.delete()     // Catch:{ all -> 0x00a5 }
        L_0x0051:
            java.io.Closeable[] r12 = new java.io.Closeable[r5]
            r12[r6] = r7
            com.mob.commons.v.a((java.io.Closeable[]) r12)
            boolean r12 = android.text.TextUtils.isEmpty(r1)
            if (r12 == 0) goto L_0x0071
            long r12 = java.lang.System.currentTimeMillis()
            long r12 = r12 - r3
            r11.f27780l = r12
            java.lang.Object[] r14 = new java.lang.Object[r5]
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r14[r6] = r12
            java.lang.String r1 = java.lang.String.format(r0, r14)
        L_0x0071:
            com.mob.tools.log.NLog r12 = com.mob.tools.MobLog.getInstance()
            java.lang.Object[] r13 = new java.lang.Object[r6]
            r12.d(r1, r13)
            return r2
        L_0x007b:
            java.io.Closeable[] r13 = new java.io.Closeable[r5]
            r13[r6] = r7
            com.mob.commons.v.a((java.io.Closeable[]) r13)
            boolean r13 = android.text.TextUtils.isEmpty(r1)
            if (r13 == 0) goto L_0x009b
            long r13 = java.lang.System.currentTimeMillis()
            long r13 = r13 - r3
            r11.f27780l = r13
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.Long r13 = java.lang.Long.valueOf(r13)
            r1[r6] = r13
            java.lang.String r1 = java.lang.String.format(r0, r1)
        L_0x009b:
            com.mob.tools.log.NLog r13 = com.mob.tools.MobLog.getInstance()
            java.lang.Object[] r14 = new java.lang.Object[r6]
            r13.d(r1, r14)
            return r12
        L_0x00a5:
            r12 = move-exception
            goto L_0x00a9
        L_0x00a7:
            r12 = move-exception
            r7 = r1
        L_0x00a9:
            boolean r8 = r13.exists()     // Catch:{ all -> 0x0113 }
            if (r8 == 0) goto L_0x00b2
            r13.delete()     // Catch:{ all -> 0x0113 }
        L_0x00b2:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r13.<init>()     // Catch:{ all -> 0x0113 }
            java.lang.String r8 = "dhs d e: "
            r13.append(r8)     // Catch:{ all -> 0x0113 }
            java.lang.String r8 = r12.getMessage()     // Catch:{ all -> 0x0113 }
            r13.append(r8)     // Catch:{ all -> 0x0113 }
            java.lang.String r1 = r13.toString()     // Catch:{ all -> 0x0113 }
            com.mob.tools.log.NLog r13 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0113 }
            r13.d(r12)     // Catch:{ all -> 0x0113 }
            com.mob.commons.g r13 = com.mob.commons.g.a()     // Catch:{ all -> 0x0113 }
            r8 = 2
            int r9 = r11.b()     // Catch:{ all -> 0x0113 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0113 }
            r10.<init>()     // Catch:{ all -> 0x0113 }
            r10.append(r2)     // Catch:{ all -> 0x0113 }
            r10.append(r14)     // Catch:{ all -> 0x0113 }
            java.lang.String r14 = r10.toString()     // Catch:{ all -> 0x0113 }
            r13.a((int) r8, (int) r9, (java.lang.Throwable) r12, (java.lang.String) r14)     // Catch:{ all -> 0x0113 }
            java.io.Closeable[] r12 = new java.io.Closeable[r5]
            r12[r6] = r7
            com.mob.commons.v.a((java.io.Closeable[]) r12)
            boolean r12 = android.text.TextUtils.isEmpty(r1)
            if (r12 == 0) goto L_0x0109
            long r12 = java.lang.System.currentTimeMillis()
            long r12 = r12 - r3
            r11.f27780l = r12
            java.lang.Object[] r14 = new java.lang.Object[r5]
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            r14[r6] = r12
            java.lang.String r1 = java.lang.String.format(r0, r14)
        L_0x0109:
            com.mob.tools.log.NLog r12 = com.mob.tools.MobLog.getInstance()
            java.lang.Object[] r13 = new java.lang.Object[r6]
            r12.d(r1, r13)
            goto L_0x013e
        L_0x0113:
            r12 = move-exception
            java.io.Closeable[] r13 = new java.io.Closeable[r5]
            r13[r6] = r7
            com.mob.commons.v.a((java.io.Closeable[]) r13)
            boolean r13 = android.text.TextUtils.isEmpty(r1)
            if (r13 == 0) goto L_0x0134
            long r13 = java.lang.System.currentTimeMillis()
            long r13 = r13 - r3
            r11.f27780l = r13
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.Long r13 = java.lang.Long.valueOf(r13)
            r1[r6] = r13
            java.lang.String r1 = java.lang.String.format(r0, r1)
        L_0x0134:
            com.mob.tools.log.NLog r13 = com.mob.tools.MobLog.getInstance()
            java.lang.Object[] r14 = new java.lang.Object[r6]
            r13.d(r1, r14)
            throw r12
        L_0x013e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.d.a(java.lang.String, java.io.File, java.lang.String):java.lang.String");
    }
}
