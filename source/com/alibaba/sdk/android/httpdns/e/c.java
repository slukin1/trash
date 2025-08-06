package com.alibaba.sdk.android.httpdns.e;

import com.alibaba.sdk.android.httpdns.RequestIpType;
import java.util.HashMap;
import java.util.HashSet;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public Object f14563a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public b f14564b = new b((a) null);

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, b> f14565c = new HashMap<>();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14566a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.alibaba.sdk.android.httpdns.RequestIpType[] r0 = com.alibaba.sdk.android.httpdns.RequestIpType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14566a = r0
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.v4     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14566a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.v6     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14566a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.both     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.e.c.a.<clinit>():void");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f14567a;

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f14568b;

        /* renamed from: c  reason: collision with root package name */
        public HashSet<String> f14569c;

        /* renamed from: d  reason: collision with root package name */
        public Object f14570d;

        public b() {
            this.f14567a = new HashSet<>();
            this.f14568b = new HashSet<>();
            this.f14569c = new HashSet<>();
            this.f14570d = new Object();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public void a(String str, RequestIpType requestIpType) {
            HashSet<String> hashSet;
            int i11 = a.f14566a[requestIpType.ordinal()];
            if (i11 == 1) {
                hashSet = this.f14567a;
            } else if (i11 == 2) {
                hashSet = this.f14568b;
            } else if (i11 == 3) {
                hashSet = this.f14569c;
            } else {
                return;
            }
            hashSet.remove(str);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0079, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00af, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b(java.lang.String r4, com.alibaba.sdk.android.httpdns.RequestIpType r5) {
            /*
                r3 = this;
                com.alibaba.sdk.android.httpdns.RequestIpType r0 = com.alibaba.sdk.android.httpdns.RequestIpType.both
                r1 = 1
                r2 = 0
                if (r5 != r0) goto L_0x0048
                java.util.HashSet<java.lang.String> r5 = r3.f14569c
                boolean r5 = r5.contains(r4)
                if (r5 != 0) goto L_0x0047
                java.util.HashSet<java.lang.String> r5 = r3.f14567a
                boolean r5 = r5.contains(r4)
                if (r5 == 0) goto L_0x001f
                java.util.HashSet<java.lang.String> r5 = r3.f14568b
                boolean r5 = r5.contains(r4)
                if (r5 == 0) goto L_0x001f
                goto L_0x0047
            L_0x001f:
                java.lang.Object r5 = r3.f14570d
                monitor-enter(r5)
                java.util.HashSet<java.lang.String> r0 = r3.f14569c     // Catch:{ all -> 0x0044 }
                boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x0044 }
                if (r0 != 0) goto L_0x0042
                java.util.HashSet<java.lang.String> r0 = r3.f14567a     // Catch:{ all -> 0x0044 }
                boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x0044 }
                if (r0 == 0) goto L_0x003b
                java.util.HashSet<java.lang.String> r0 = r3.f14568b     // Catch:{ all -> 0x0044 }
                boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x0044 }
                if (r0 == 0) goto L_0x003b
                goto L_0x0042
            L_0x003b:
                java.util.HashSet<java.lang.String> r0 = r3.f14569c     // Catch:{ all -> 0x0044 }
                r0.add(r4)     // Catch:{ all -> 0x0044 }
                monitor-exit(r5)     // Catch:{ all -> 0x0044 }
                return r1
            L_0x0042:
                monitor-exit(r5)     // Catch:{ all -> 0x0044 }
                return r2
            L_0x0044:
                r4 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0044 }
                throw r4
            L_0x0047:
                return r2
            L_0x0048:
                com.alibaba.sdk.android.httpdns.RequestIpType r0 = com.alibaba.sdk.android.httpdns.RequestIpType.v4
                if (r5 != r0) goto L_0x007e
                java.util.HashSet<java.lang.String> r5 = r3.f14567a
                boolean r5 = r5.contains(r4)
                if (r5 != 0) goto L_0x007d
                java.util.HashSet<java.lang.String> r5 = r3.f14569c
                boolean r5 = r5.contains(r4)
                if (r5 == 0) goto L_0x005d
                goto L_0x007d
            L_0x005d:
                java.lang.Object r5 = r3.f14570d
                monitor-enter(r5)
                java.util.HashSet<java.lang.String> r0 = r3.f14567a     // Catch:{ all -> 0x007a }
                boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x007a }
                if (r0 != 0) goto L_0x0078
                java.util.HashSet<java.lang.String> r0 = r3.f14569c     // Catch:{ all -> 0x007a }
                boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x007a }
                if (r0 == 0) goto L_0x0071
                goto L_0x0078
            L_0x0071:
                java.util.HashSet<java.lang.String> r0 = r3.f14567a     // Catch:{ all -> 0x007a }
                r0.add(r4)     // Catch:{ all -> 0x007a }
                monitor-exit(r5)     // Catch:{ all -> 0x007a }
                return r1
            L_0x0078:
                monitor-exit(r5)     // Catch:{ all -> 0x007a }
                return r2
            L_0x007a:
                r4 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x007a }
                throw r4
            L_0x007d:
                return r2
            L_0x007e:
                com.alibaba.sdk.android.httpdns.RequestIpType r0 = com.alibaba.sdk.android.httpdns.RequestIpType.v6
                if (r5 != r0) goto L_0x00b3
                java.util.HashSet<java.lang.String> r5 = r3.f14568b
                boolean r5 = r5.contains(r4)
                if (r5 != 0) goto L_0x00b3
                java.util.HashSet<java.lang.String> r5 = r3.f14569c
                boolean r5 = r5.contains(r4)
                if (r5 == 0) goto L_0x0093
                goto L_0x00b3
            L_0x0093:
                java.lang.Object r5 = r3.f14570d
                monitor-enter(r5)
                java.util.HashSet<java.lang.String> r0 = r3.f14568b     // Catch:{ all -> 0x00b0 }
                boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x00b0 }
                if (r0 != 0) goto L_0x00ae
                java.util.HashSet<java.lang.String> r0 = r3.f14569c     // Catch:{ all -> 0x00b0 }
                boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x00b0 }
                if (r0 == 0) goto L_0x00a7
                goto L_0x00ae
            L_0x00a7:
                java.util.HashSet<java.lang.String> r0 = r3.f14568b     // Catch:{ all -> 0x00b0 }
                r0.add(r4)     // Catch:{ all -> 0x00b0 }
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                return r1
            L_0x00ae:
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                return r2
            L_0x00b0:
                r4 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x00b0 }
                throw r4
            L_0x00b3:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.e.c.b.b(java.lang.String, com.alibaba.sdk.android.httpdns.RequestIpType):boolean");
        }
    }

    public final b a(String str) {
        b bVar;
        if (str == null || str.isEmpty()) {
            return this.f14564b;
        }
        b bVar2 = this.f14565c.get(str);
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (this.f14563a) {
            bVar = this.f14565c.get(str);
            if (bVar == null) {
                bVar = new b((a) null);
                this.f14565c.put(str, bVar);
            }
        }
        return bVar;
    }

    public void b(String str, RequestIpType requestIpType) {
        c(str, requestIpType, (String) null);
    }

    public void c(String str, RequestIpType requestIpType, String str2) {
        a(str2).a(str, requestIpType);
    }

    public boolean d(String str, RequestIpType requestIpType) {
        return e(str, requestIpType, (String) null);
    }

    public boolean e(String str, RequestIpType requestIpType, String str2) {
        return a(str2).b(str, requestIpType);
    }
}
