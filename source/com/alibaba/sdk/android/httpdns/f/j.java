package com.alibaba.sdk.android.httpdns.f;

import com.alibaba.sdk.android.httpdns.RequestIpType;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public o2.a f14600a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14601b = false;

    /* renamed from: c  reason: collision with root package name */
    public q2.a f14602c;

    /* renamed from: d  reason: collision with root package name */
    public x2.c f14603d;

    /* renamed from: e  reason: collision with root package name */
    public d f14604e;

    public class a implements x2.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.alibaba.sdk.android.httpdns.b.a f14605a;

        public a(com.alibaba.sdk.android.httpdns.b.a aVar) {
            this.f14605a = aVar;
        }

        public void a(String str, String[] strArr) {
            j.this.h(str, RequestIpType.v4, this.f14605a.d(), strArr);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f14607b;

        public b(ArrayList arrayList) {
            this.f14607b = arrayList;
        }

        public void run() {
            j.this.f14600a.f(this.f14607b);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f14609b;

        public c(ArrayList arrayList) {
            this.f14609b = arrayList;
        }

        public void run() {
            j.this.f14600a.f(this.f14609b);
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f14611b;

        public d(ArrayList arrayList) {
            this.f14611b = arrayList;
        }

        public void run() {
            j.this.f14600a.f(this.f14611b);
        }
    }

    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f14613b;

        public e(boolean z11) {
            this.f14613b = z11;
        }

        public void run() {
            j.this.k(this.f14613b);
        }
    }

    public static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14615a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.alibaba.sdk.android.httpdns.RequestIpType[] r0 = com.alibaba.sdk.android.httpdns.RequestIpType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14615a = r0
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.v4     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14615a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.v6     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14615a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.both     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.f.j.f.<clinit>():void");
        }
    }

    public j(q2.a aVar, x2.c cVar, o2.a aVar2, d dVar) {
        this.f14602c = aVar;
        this.f14603d = cVar;
        this.f14600a = aVar2;
        this.f14604e = dVar;
    }

    public HashMap<String, RequestIpType> a() {
        return this.f14604e.a((String) null).b();
    }

    public m2.b b(String str, RequestIpType requestIpType, String str2) {
        return this.f14604e.a(str2).d(str, requestIpType);
    }

    public void e(String str, RequestIpType requestIpType, m mVar) {
        com.alibaba.sdk.android.httpdns.b.a aVar;
        ArrayList arrayList = new ArrayList();
        for (String next : mVar.c()) {
            int i11 = f.f14615a[requestIpType.ordinal()];
            if (i11 == 1) {
                aVar = i(str, next, RequestIpType.v4, (String) null, (String) null, mVar.a(next).d(), mVar.a(next).a());
            } else if (i11 == 2) {
                aVar = i(str, next, RequestIpType.v6, (String) null, (String) null, mVar.a(next).e(), mVar.a(next).a());
            } else if (i11 == 3) {
                String str2 = str;
                String str3 = next;
                arrayList.add(i(str2, str3, RequestIpType.v4, (String) null, (String) null, mVar.a(next).d(), mVar.a(next).a()));
                aVar = i(str2, str3, RequestIpType.v6, (String) null, (String) null, mVar.a(next).e(), mVar.a(next).a());
            }
            arrayList.add(aVar);
        }
        if (this.f14601b) {
            try {
                this.f14602c.j().execute(new d(arrayList));
            } catch (Exception unused) {
            }
        }
    }

    public final void f(String str, RequestIpType requestIpType, String str2, String[] strArr) {
        com.alibaba.sdk.android.httpdns.b.a a11 = this.f14604e.a(str2).a(str, requestIpType, strArr);
        if (this.f14601b) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a11);
            try {
                this.f14602c.j().execute(new b(arrayList));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006c A[SYNTHETIC, Splitter:B:12:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(java.lang.String r11, java.lang.String r12, com.alibaba.sdk.android.httpdns.RequestIpType r13, java.lang.String r14, java.lang.String r15, com.alibaba.sdk.android.httpdns.f.h r16) {
        /*
            r10 = this;
            r8 = r10
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            int[] r0 = com.alibaba.sdk.android.httpdns.f.j.f.f14615a
            int r1 = r13.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L_0x0052
            r1 = 2
            if (r0 == r1) goto L_0x003e
            r1 = 3
            if (r0 == r1) goto L_0x0018
            goto L_0x0068
        L_0x0018:
            com.alibaba.sdk.android.httpdns.RequestIpType r3 = com.alibaba.sdk.android.httpdns.RequestIpType.v4
            java.lang.String[] r6 = r16.e()
            int r7 = r16.a()
            r0 = r10
            r1 = r11
            r2 = r12
            r4 = r14
            r5 = r15
            com.alibaba.sdk.android.httpdns.b.a r0 = r0.i(r1, r2, r3, r4, r5, r6, r7)
            r9.add(r0)
            com.alibaba.sdk.android.httpdns.RequestIpType r3 = com.alibaba.sdk.android.httpdns.RequestIpType.v6
            java.lang.String[] r6 = r16.c()
            int r7 = r16.a()
            r0 = r10
            com.alibaba.sdk.android.httpdns.b.a r0 = r0.i(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0065
        L_0x003e:
            com.alibaba.sdk.android.httpdns.RequestIpType r3 = com.alibaba.sdk.android.httpdns.RequestIpType.v6
            java.lang.String[] r6 = r16.c()
            int r7 = r16.a()
            r0 = r10
            r1 = r11
            r2 = r12
            r4 = r14
            r5 = r15
            com.alibaba.sdk.android.httpdns.b.a r0 = r0.i(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x0065
        L_0x0052:
            com.alibaba.sdk.android.httpdns.RequestIpType r3 = com.alibaba.sdk.android.httpdns.RequestIpType.v4
            java.lang.String[] r6 = r16.e()
            int r7 = r16.a()
            r0 = r10
            r1 = r11
            r2 = r12
            r4 = r14
            r5 = r15
            com.alibaba.sdk.android.httpdns.b.a r0 = r0.i(r1, r2, r3, r4, r5, r6, r7)
        L_0x0065:
            r9.add(r0)
        L_0x0068:
            boolean r0 = r8.f14601b
            if (r0 == 0) goto L_0x007a
            q2.a r0 = r8.f14602c     // Catch:{ Exception -> 0x007a }
            java.util.concurrent.ExecutorService r0 = r0.j()     // Catch:{ Exception -> 0x007a }
            com.alibaba.sdk.android.httpdns.f.j$c r1 = new com.alibaba.sdk.android.httpdns.f.j$c     // Catch:{ Exception -> 0x007a }
            r1.<init>(r9)     // Catch:{ Exception -> 0x007a }
            r0.execute(r1)     // Catch:{ Exception -> 0x007a }
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.f.j.g(java.lang.String, java.lang.String, com.alibaba.sdk.android.httpdns.RequestIpType, java.lang.String, java.lang.String, com.alibaba.sdk.android.httpdns.f.h):void");
    }

    public void h(String str, RequestIpType requestIpType, String str2, String[] strArr) {
        RequestIpType requestIpType2;
        int i11 = f.f14615a[requestIpType.ordinal()];
        if (i11 == 1) {
            requestIpType2 = RequestIpType.v4;
        } else if (i11 != 2) {
            HttpDnsLog.c("update both is impossible for " + str);
            return;
        } else {
            requestIpType2 = RequestIpType.v6;
        }
        f(str, requestIpType2, str2, strArr);
    }

    public final com.alibaba.sdk.android.httpdns.b.a i(String str, String str2, RequestIpType requestIpType, String str3, String str4, String[] strArr, int i11) {
        return this.f14604e.a(str4).h(str, str2, requestIpType, str3, str4, strArr, i11);
    }

    public void j() {
        this.f14604e.b();
    }

    public final void k(boolean z11) {
        String u11 = this.f14602c.u();
        List<com.alibaba.sdk.android.httpdns.b.a> b11 = this.f14600a.b(u11);
        for (com.alibaba.sdk.android.httpdns.b.a next : b11) {
            this.f14604e.a(next.d()).e(next);
        }
        if (z11) {
            this.f14600a.e(b11);
        } else {
            ArrayList arrayList = new ArrayList();
            for (com.alibaba.sdk.android.httpdns.b.a next2 : b11) {
                if (next2.r()) {
                    arrayList.add(next2);
                }
            }
            this.f14600a.e(arrayList);
        }
        if (!this.f14602c.u().equals(u11)) {
            this.f14604e.b();
        }
        for (com.alibaba.sdk.android.httpdns.b.a next3 : b11) {
            if (!next3.r() && RequestIpType.values()[next3.q()] == RequestIpType.v4) {
                this.f14603d.c(next3.m(), next3.o(), new a(next3));
            }
        }
    }

    public void l(boolean z11, boolean z12) {
        this.f14601b = z11;
        try {
            this.f14602c.j().execute(new e(z12));
        } catch (Throwable unused) {
        }
    }
}
