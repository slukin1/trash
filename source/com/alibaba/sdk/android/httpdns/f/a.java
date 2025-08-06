package com.alibaba.sdk.android.httpdns.f;

public class a implements s {

    /* renamed from: a  reason: collision with root package name */
    public C0070a f14571a = C0070a.NORMAL;

    /* renamed from: b  reason: collision with root package name */
    public l f14572b;

    /* renamed from: c  reason: collision with root package name */
    public q f14573c;

    /* renamed from: com.alibaba.sdk.android.httpdns.f.a$a  reason: collision with other inner class name */
    public enum C0070a {
        NORMAL,
        PRE_DISABLE,
        DISABLE
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14578a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.alibaba.sdk.android.httpdns.f.a$a[] r0 = com.alibaba.sdk.android.httpdns.f.a.C0070a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14578a = r0
                com.alibaba.sdk.android.httpdns.f.a$a r1 = com.alibaba.sdk.android.httpdns.f.a.C0070a.DISABLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14578a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.sdk.android.httpdns.f.a$a r1 = com.alibaba.sdk.android.httpdns.f.a.C0070a.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14578a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.sdk.android.httpdns.f.a$a r1 = com.alibaba.sdk.android.httpdns.f.a.C0070a.PRE_DISABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.httpdns.f.a.b.<clinit>():void");
        }
    }

    public a(u2.a aVar) {
        this.f14572b = new l(aVar, this);
        this.f14573c = new q(aVar, this);
    }

    public e a() {
        return b.f14578a[this.f14571a.ordinal()] != 1 ? this.f14572b : this.f14573c;
    }

    public void b() {
        this.f14571a = C0070a.NORMAL;
        this.f14573c.b();
    }

    public void c() {
        C0070a aVar;
        int i11 = b.f14578a[this.f14571a.ordinal()];
        if (i11 == 2) {
            aVar = C0070a.PRE_DISABLE;
        } else if (i11 == 3) {
            aVar = C0070a.DISABLE;
        } else {
            return;
        }
        this.f14571a = aVar;
    }

    public void d() {
        this.f14571a = C0070a.NORMAL;
    }
}
