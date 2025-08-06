package k2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class b {

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f16036h;

    /* renamed from: a  reason: collision with root package name */
    public final Context f16037a;

    /* renamed from: b  reason: collision with root package name */
    public final com.alibaba.sdk.android.crashdefend.a.a f16038b = new com.alibaba.sdk.android.crashdefend.a.a();

    /* renamed from: c  reason: collision with root package name */
    public com.alibaba.sdk.android.crashdefend.a.b f16039c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f16040d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, String> f16041e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public final int[] f16042f = new int[5];

    /* renamed from: g  reason: collision with root package name */
    public final List<com.alibaba.sdk.android.crashdefend.a.b> f16043g = new ArrayList();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public com.alibaba.sdk.android.crashdefend.a.b f16044b;

        /* renamed from: c  reason: collision with root package name */
        public int f16045c;

        public a(com.alibaba.sdk.android.crashdefend.a.b bVar, int i11) {
            this.f16044b = bVar;
            this.f16045c = i11;
        }

        public void run() {
            int i11;
            do {
                try {
                    Thread.sleep(1000);
                    i11 = this.f16045c - 1;
                    this.f16045c = i11;
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e11) {
                    Log.d("CrashDefend", e11.getMessage(), e11);
                    return;
                }
            } while (i11 > 0);
            if (i11 <= 0) {
                b.this.m(this.f16044b);
                l2.a.b(b.this.f16037a, b.this.f16038b, b.this.f16043g);
            }
        }
    }

    public b(Context context) {
        this.f16037a = context.getApplicationContext();
        this.f16040d = new com.alibaba.sdk.android.crashdefend.b.a().a();
        for (int i11 = 0; i11 < 5; i11++) {
            this.f16042f[i11] = (i11 * 5) + 5;
        }
        this.f16041e.put("sdkId", "crashdefend");
        this.f16041e.put("sdkVersion", "0.0.6");
        try {
            c();
            j();
        } catch (Exception e11) {
            Log.d("CrashDefend", e11.getMessage(), e11);
        }
    }

    public static b b(Context context) {
        if (f16036h == null) {
            synchronized (b.class) {
                if (f16036h == null) {
                    f16036h = new b(context);
                }
            }
        }
        return f16036h;
    }

    public final void c() {
        if (l2.a.e(this.f16037a, this.f16038b, this.f16043g)) {
            this.f16038b.f14492a++;
            return;
        }
        this.f16038b.f14492a = 1;
    }

    public final boolean e(com.alibaba.sdk.android.crashdefend.a.b bVar) {
        if (bVar.f14496e >= bVar.f14495d) {
            com.alibaba.sdk.android.crashdefend.a.b bVar2 = this.f16039c;
            if (bVar2 == null || !bVar2.f14493b.equals(bVar.f14493b)) {
                return false;
            }
            bVar.f14496e = bVar.f14495d - 1;
        }
        bVar.f14499h = bVar.f14498g;
        return true;
    }

    public final boolean f(com.alibaba.sdk.android.crashdefend.a.b bVar, a aVar) {
        String str;
        com.alibaba.sdk.android.crashdefend.a.b bVar2 = bVar;
        a aVar2 = aVar;
        if (!(bVar2 == null || aVar2 == null)) {
            try {
                if (!TextUtils.isEmpty(bVar2.f14494c)) {
                    if (!TextUtils.isEmpty(bVar2.f14493b)) {
                        com.alibaba.sdk.android.crashdefend.a.b i11 = i(bVar, aVar);
                        if (i11 == null) {
                            return false;
                        }
                        boolean e11 = e(i11);
                        i11.f14496e++;
                        l2.a.b(this.f16037a, this.f16038b, this.f16043g);
                        if (e11) {
                            k(i11);
                            str = "START:" + i11.f14493b + " --- limit:" + i11.f14495d + "  count:" + (i11.f14496e - 1) + "  restore:" + i11.f14500i + "  startSerialNumber:" + i11.f14499h + "  registerSerialNumber:" + i11.f14498g;
                        } else {
                            int i12 = i11.f14500i;
                            if (i12 >= 5) {
                                aVar2.c(i12);
                                str = "CLOSED: " + i11.f14493b + " --- restored " + i11.f14500i + ", has more than retry limit, so closed it";
                            } else {
                                aVar.b(i11.f14495d, i11.f14496e - 1, i12, i11.f14501j);
                                str = "STOP:" + i11.f14493b + " --- limit:" + i11.f14495d + "  count:" + (i11.f14496e - 1) + "  restore:" + i11.f14500i + "  startSerialNumber:" + i11.f14499h + "  registerSerialNumber:" + i11.f14498g;
                            }
                        }
                        l2.b.c("CrashDefend", str);
                        return true;
                    }
                }
                return false;
            } catch (Exception e12) {
                Log.d("CrashDefend", e12.getMessage(), e12);
            }
        }
        return false;
    }

    public boolean g(String str, String str2, int i11, int i12, a aVar) {
        com.alibaba.sdk.android.crashdefend.a.b bVar = new com.alibaba.sdk.android.crashdefend.a.b();
        bVar.f14493b = str;
        bVar.f14494c = str2;
        bVar.f14495d = i11;
        bVar.f14497f = i12;
        return f(bVar, aVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.alibaba.sdk.android.crashdefend.a.b} */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if (r4.f14494c.equals(r8.f14494c) != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r4.f14494c = r8.f14494c;
        r4.f14495d = r8.f14495d;
        r4.f14497f = r8.f14497f;
        r4.f14496e = 0;
        r4.f14500i = 0;
        r4.f14501j = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r4.f14502k == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        l2.b.c("CrashDefend", "SDK " + r8.f14493b + " has been registered");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.f14502k = true;
        r4.f14503l = r9;
        r4.f14498g = r7.f16038b.f14492a;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0091, code lost:
        return r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.alibaba.sdk.android.crashdefend.a.b i(com.alibaba.sdk.android.crashdefend.a.b r8, k2.a r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.List<com.alibaba.sdk.android.crashdefend.a.b> r0 = r7.f16043g     // Catch:{ all -> 0x0092 }
            int r0 = r0.size()     // Catch:{ all -> 0x0092 }
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 <= 0) goto L_0x0076
            java.util.List<com.alibaba.sdk.android.crashdefend.a.b> r0 = r7.f16043g     // Catch:{ all -> 0x0092 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0092 }
        L_0x0012:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0092 }
            if (r4 == 0) goto L_0x0076
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0092 }
            com.alibaba.sdk.android.crashdefend.a.b r4 = (com.alibaba.sdk.android.crashdefend.a.b) r4     // Catch:{ all -> 0x0092 }
            if (r4 == 0) goto L_0x0012
            java.lang.String r5 = r4.f14493b     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = r8.f14493b     // Catch:{ all -> 0x0092 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0092 }
            if (r5 == 0) goto L_0x0012
            java.lang.String r0 = r4.f14494c     // Catch:{ all -> 0x0092 }
            java.lang.String r5 = r8.f14494c     // Catch:{ all -> 0x0092 }
            boolean r0 = r0.equals(r5)     // Catch:{ all -> 0x0092 }
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = r8.f14494c     // Catch:{ all -> 0x0092 }
            r4.f14494c = r0     // Catch:{ all -> 0x0092 }
            int r0 = r8.f14495d     // Catch:{ all -> 0x0092 }
            r4.f14495d = r0     // Catch:{ all -> 0x0092 }
            int r0 = r8.f14497f     // Catch:{ all -> 0x0092 }
            r4.f14497f = r0     // Catch:{ all -> 0x0092 }
            r4.f14496e = r3     // Catch:{ all -> 0x0092 }
            r4.f14500i = r3     // Catch:{ all -> 0x0092 }
            r5 = 0
            r4.f14501j = r5     // Catch:{ all -> 0x0092 }
        L_0x0048:
            boolean r0 = r4.f14502k     // Catch:{ all -> 0x0092 }
            if (r0 == 0) goto L_0x006b
            java.lang.String r9 = "CrashDefend"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0092 }
            r0.<init>()     // Catch:{ all -> 0x0092 }
            java.lang.String r1 = "SDK "
            r0.append(r1)     // Catch:{ all -> 0x0092 }
            java.lang.String r8 = r8.f14493b     // Catch:{ all -> 0x0092 }
            r0.append(r8)     // Catch:{ all -> 0x0092 }
            java.lang.String r8 = " has been registered"
            r0.append(r8)     // Catch:{ all -> 0x0092 }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x0092 }
            l2.b.c(r9, r8)     // Catch:{ all -> 0x0092 }
            monitor-exit(r7)
            return r2
        L_0x006b:
            r4.f14502k = r1     // Catch:{ all -> 0x0092 }
            r4.f14503l = r9     // Catch:{ all -> 0x0092 }
            com.alibaba.sdk.android.crashdefend.a.a r0 = r7.f16038b     // Catch:{ all -> 0x0092 }
            long r5 = r0.f14492a     // Catch:{ all -> 0x0092 }
            r4.f14498g = r5     // Catch:{ all -> 0x0092 }
            r2 = r4
        L_0x0076:
            if (r2 != 0) goto L_0x0090
            java.lang.Object r8 = r8.clone()     // Catch:{ all -> 0x0092 }
            r2 = r8
            com.alibaba.sdk.android.crashdefend.a.b r2 = (com.alibaba.sdk.android.crashdefend.a.b) r2     // Catch:{ all -> 0x0092 }
            r2.f14502k = r1     // Catch:{ all -> 0x0092 }
            r2.f14503l = r9     // Catch:{ all -> 0x0092 }
            r2.f14496e = r3     // Catch:{ all -> 0x0092 }
            com.alibaba.sdk.android.crashdefend.a.a r8 = r7.f16038b     // Catch:{ all -> 0x0092 }
            long r8 = r8.f14492a     // Catch:{ all -> 0x0092 }
            r2.f14498g = r8     // Catch:{ all -> 0x0092 }
            java.util.List<com.alibaba.sdk.android.crashdefend.a.b> r8 = r7.f16043g     // Catch:{ all -> 0x0092 }
            r8.add(r2)     // Catch:{ all -> 0x0092 }
        L_0x0090:
            monitor-exit(r7)
            return r2
        L_0x0092:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.b.i(com.alibaba.sdk.android.crashdefend.a.b, k2.a):com.alibaba.sdk.android.crashdefend.a.b");
    }

    public final void j() {
        String str;
        String str2;
        this.f16039c = null;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f16043g) {
            for (com.alibaba.sdk.android.crashdefend.a.b next : this.f16043g) {
                if (next.f14496e >= next.f14495d) {
                    arrayList.add(next);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    com.alibaba.sdk.android.crashdefend.a.b bVar = (com.alibaba.sdk.android.crashdefend.a.b) it2.next();
                    int i11 = bVar.f14500i;
                    if (i11 < 5) {
                        long j11 = this.f16038b.f14492a - ((long) this.f16042f[i11]);
                        long j12 = (bVar.f14499h - j11) + 1;
                        l2.b.a("CrashDefend", "after restart " + j12 + " times, sdk will be restore");
                        bVar.f14501j = j12;
                        if (bVar.f14499h < j11) {
                            this.f16039c = bVar;
                            break;
                        }
                    } else {
                        l2.b.c("CrashDefend", "SDK " + bVar.f14493b + " has been closed");
                    }
                } else {
                    break;
                }
            }
            com.alibaba.sdk.android.crashdefend.a.b bVar2 = this.f16039c;
            if (bVar2 == null) {
                str = "CrashDefend";
                str2 = "NO SDK restore";
            } else {
                bVar2.f14500i++;
                str = "CrashDefend";
                str2 = this.f16039c.f14493b + " will restore --- startSerialNumber:" + this.f16039c.f14499h + "   crashCount:" + this.f16039c.f14496e;
            }
            l2.b.c(str, str2);
        }
    }

    public final void k(com.alibaba.sdk.android.crashdefend.a.b bVar) {
        if (bVar != null) {
            n(bVar);
            a aVar = bVar.f14503l;
            if (aVar != null) {
                aVar.a(bVar.f14495d, bVar.f14496e - 1, bVar.f14500i);
            }
        }
    }

    public final void m(com.alibaba.sdk.android.crashdefend.a.b bVar) {
        if (bVar != null) {
            bVar.f14496e = 0;
            bVar.f14500i = 0;
        }
    }

    public final void n(com.alibaba.sdk.android.crashdefend.a.b bVar) {
        if (bVar != null) {
            this.f16040d.execute(new a(bVar, bVar.f14497f));
        }
    }
}
