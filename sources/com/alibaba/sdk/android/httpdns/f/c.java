package com.alibaba.sdk.android.httpdns.f;

import com.alibaba.sdk.android.httpdns.RequestIpType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import m2.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, com.alibaba.sdk.android.httpdns.b.a> f14580a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, com.alibaba.sdk.android.httpdns.b.a> f14581b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, b> f14582c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, b> f14583d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentHashMap<String, b> f14584e = new ConcurrentHashMap<>();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14585a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.alibaba.sdk.android.httpdns.RequestIpType[] r0 = com.alibaba.sdk.android.httpdns.RequestIpType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14585a = r0
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.v6     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14585a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.v4     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14585a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.both     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.f.c.a.<clinit>():void");
        }
    }

    public com.alibaba.sdk.android.httpdns.b.a a(String str, RequestIpType requestIpType, String[] strArr) {
        com.alibaba.sdk.android.httpdns.b.a aVar;
        int i11 = a.f14585a[requestIpType.ordinal()];
        if (i11 == 1) {
            aVar = this.f14581b.get(str);
            if (aVar == null) {
                return null;
            }
        } else if (i11 == 2) {
            aVar = this.f14580a.get(str);
            if (aVar == null) {
                return null;
            }
        } else {
            throw new IllegalStateException("type should be v4 or b6");
        }
        aVar.i(strArr);
        g(str, requestIpType, strArr);
        return aVar;
    }

    public HashMap<String, RequestIpType> b() {
        HashMap<String, RequestIpType> hashMap = new HashMap<>();
        for (com.alibaba.sdk.android.httpdns.b.a m11 : this.f14580a.values()) {
            hashMap.put(m11.m(), RequestIpType.v4);
        }
        for (com.alibaba.sdk.android.httpdns.b.a next : this.f14581b.values()) {
            hashMap.put(next.m(), hashMap.get(next.m()) == null ? RequestIpType.v6 : RequestIpType.both);
        }
        return hashMap;
    }

    public List<com.alibaba.sdk.android.httpdns.b.a> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f14580a.values());
        arrayList.addAll(this.f14581b.values());
        this.f14580a.clear();
        this.f14581b.clear();
        this.f14582c.clear();
        this.f14583d.clear();
        this.f14584e.clear();
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public m2.b d(java.lang.String r6, com.alibaba.sdk.android.httpdns.RequestIpType r7) {
        /*
            r5 = this;
            int[] r0 = com.alibaba.sdk.android.httpdns.f.c.a.f14585a
            int r1 = r7.ordinal()
            r1 = r0[r1]
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L_0x0019
            if (r1 == r3) goto L_0x0016
            if (r1 == r2) goto L_0x0013
            r1 = 0
            goto L_0x0021
        L_0x0013:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m2.b> r1 = r5.f14584e
            goto L_0x001b
        L_0x0016:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m2.b> r1 = r5.f14582c
            goto L_0x001b
        L_0x0019:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m2.b> r1 = r5.f14583d
        L_0x001b:
            java.lang.Object r1 = r1.get(r6)
            m2.b r1 = (m2.b) r1
        L_0x0021:
            if (r1 != 0) goto L_0x0041
            m2.b r1 = r5.i(r6, r7)
            if (r1 == 0) goto L_0x0041
            int r7 = r7.ordinal()
            r7 = r0[r7]
            if (r7 == r4) goto L_0x003c
            if (r7 == r3) goto L_0x0039
            if (r7 == r2) goto L_0x0036
            goto L_0x0041
        L_0x0036:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m2.b> r7 = r5.f14584e
            goto L_0x003e
        L_0x0039:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m2.b> r7 = r5.f14582c
            goto L_0x003e
        L_0x003c:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m2.b> r7 = r5.f14583d
        L_0x003e:
            r7.put(r6, r1)
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.f.c.d(java.lang.String, com.alibaba.sdk.android.httpdns.RequestIpType):m2.b");
    }

    public void e(com.alibaba.sdk.android.httpdns.b.a aVar) {
        ConcurrentHashMap<String, com.alibaba.sdk.android.httpdns.b.a> concurrentHashMap;
        if (aVar.q() == RequestIpType.v4.ordinal()) {
            concurrentHashMap = this.f14580a;
        } else if (aVar.q() == RequestIpType.v6.ordinal()) {
            concurrentHashMap = this.f14581b;
        } else {
            return;
        }
        concurrentHashMap.put(aVar.m(), aVar);
    }

    public final void f(String str, RequestIpType requestIpType, com.alibaba.sdk.android.httpdns.b.a aVar) {
        b bVar;
        if (requestIpType != RequestIpType.v4 ? !(requestIpType != RequestIpType.v6 || (bVar = this.f14583d.get(str)) == null) : (bVar = this.f14582c.get(str)) != null) {
            bVar.d(aVar);
        }
        b bVar2 = this.f14584e.get(str);
        if (bVar2 != null) {
            bVar2.d(aVar);
        }
    }

    public final void g(String str, RequestIpType requestIpType, String[] strArr) {
        b bVar;
        if (requestIpType != RequestIpType.v4 ? !(requestIpType != RequestIpType.v6 || (bVar = this.f14583d.get(str)) == null) : (bVar = this.f14582c.get(str)) != null) {
            bVar.f(strArr, requestIpType);
        }
        b bVar2 = this.f14584e.get(str);
        if (bVar2 != null) {
            bVar2.f(strArr, requestIpType);
        }
    }

    public com.alibaba.sdk.android.httpdns.b.a h(String str, String str2, RequestIpType requestIpType, String str3, String str4, String[] strArr, int i11) {
        com.alibaba.sdk.android.httpdns.b.a aVar;
        ConcurrentHashMap<String, com.alibaba.sdk.android.httpdns.b.a> concurrentHashMap;
        com.alibaba.sdk.android.httpdns.b.a aVar2;
        int i12 = a.f14585a[requestIpType.ordinal()];
        if (i12 == 1) {
            aVar2 = this.f14581b.get(str2);
            if (aVar2 == null) {
                aVar = com.alibaba.sdk.android.httpdns.b.a.c(str, str2, requestIpType, str3, str4, strArr, i11);
                concurrentHashMap = this.f14581b;
            }
            aVar.u(str);
            aVar.f(System.currentTimeMillis());
            aVar.i(strArr);
            aVar.e(i11);
            aVar.g(str3);
            aVar.h(false);
            f(str2, requestIpType, aVar);
            return aVar;
        } else if (i12 == 2) {
            aVar2 = this.f14580a.get(str2);
            if (aVar2 == null) {
                aVar = com.alibaba.sdk.android.httpdns.b.a.c(str, str2, requestIpType, str3, str4, strArr, i11);
                concurrentHashMap = this.f14580a;
            }
            aVar.u(str);
            aVar.f(System.currentTimeMillis());
            aVar.i(strArr);
            aVar.e(i11);
            aVar.g(str3);
            aVar.h(false);
            f(str2, requestIpType, aVar);
            return aVar;
        } else {
            throw new IllegalStateException("type should be v4 or b6");
        }
        concurrentHashMap.put(str2, aVar);
        f(str2, requestIpType, aVar);
        return aVar;
    }

    public final b i(String str, RequestIpType requestIpType) {
        com.alibaba.sdk.android.httpdns.b.a aVar;
        b bVar;
        int i11 = a.f14585a[requestIpType.ordinal()];
        if (i11 == 1) {
            aVar = this.f14581b.get(str);
            if (aVar == null) {
                return null;
            }
            bVar = new b(str);
        } else if (i11 != 2) {
            com.alibaba.sdk.android.httpdns.b.a aVar2 = this.f14580a.get(str);
            com.alibaba.sdk.android.httpdns.b.a aVar3 = this.f14581b.get(str);
            if (aVar2 == null || aVar3 == null) {
                return null;
            }
            b bVar2 = new b(str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar2);
            arrayList.add(aVar3);
            bVar2.e(arrayList);
            return bVar2;
        } else {
            aVar = this.f14580a.get(str);
            if (aVar == null) {
                return null;
            }
            bVar = new b(str);
        }
        bVar.d(aVar);
        return bVar;
    }
}
