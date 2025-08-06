package m2;

import com.alibaba.sdk.android.httpdns.RequestIpType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f16142a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f16143b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f16144c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f16145d;

    /* renamed from: e  reason: collision with root package name */
    public long f16146e;

    /* renamed from: f  reason: collision with root package name */
    public int f16147f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16148g = false;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f16149a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.alibaba.sdk.android.httpdns.RequestIpType[] r0 = com.alibaba.sdk.android.httpdns.RequestIpType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16149a = r0
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.v4     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16149a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.sdk.android.httpdns.RequestIpType r1 = com.alibaba.sdk.android.httpdns.RequestIpType.v6     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: m2.b.a.<clinit>():void");
        }
    }

    public b(String str) {
        this.f16142a = str;
        String[] strArr = w2.b.f16741b;
        this.f16143b = strArr;
        this.f16144c = strArr;
        this.f16145d = w2.b.f16742c;
        this.f16146e = System.currentTimeMillis();
        this.f16147f = 60;
        this.f16148g = false;
    }

    public b(String str, String[] strArr, String[] strArr2, Map<String, String> map, boolean z11, boolean z12) {
        this.f16142a = str;
        this.f16143b = strArr;
        this.f16144c = strArr2;
        this.f16145d = map;
        this.f16146e = System.currentTimeMillis();
        this.f16147f = 60;
        this.f16148g = z12;
    }

    public String[] a() {
        return this.f16143b;
    }

    public boolean b() {
        return System.currentTimeMillis() > this.f16146e + ((long) (this.f16147f * 1000));
    }

    public boolean c() {
        return this.f16148g;
    }

    public void d(com.alibaba.sdk.android.httpdns.b.a aVar) {
        if (aVar.m().equals(this.f16142a)) {
            if (aVar.q() == RequestIpType.v4.ordinal()) {
                this.f16143b = aVar.o();
            } else if (aVar.q() == RequestIpType.v6.ordinal()) {
                this.f16144c = aVar.o();
            }
            this.f16145d = w2.a.d(aVar.l());
            this.f16146e = aVar.b();
            this.f16147f = aVar.a();
            this.f16148g = aVar.s();
        }
    }

    public void e(List<com.alibaba.sdk.android.httpdns.b.a> list) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = null;
        int i11 = Integer.MAX_VALUE;
        boolean z11 = false;
        for (com.alibaba.sdk.android.httpdns.b.a next : list) {
            if (next.m().equals(this.f16142a)) {
                if (next.q() == RequestIpType.v4.ordinal()) {
                    this.f16143b = next.o();
                } else if (next.q() == RequestIpType.v6.ordinal()) {
                    this.f16144c = next.o();
                }
                if (next.l() != null && !next.l().isEmpty()) {
                    str = next.l();
                }
                if (currentTimeMillis > next.b()) {
                    currentTimeMillis = next.b();
                }
                if (i11 > next.a()) {
                    i11 = next.a();
                }
                z11 |= next.s();
            }
        }
        this.f16145d = w2.a.d(str);
        this.f16146e = currentTimeMillis;
        this.f16147f = i11;
        this.f16148g = z11;
    }

    public void f(String[] strArr, RequestIpType requestIpType) {
        int i11 = a.f16149a[requestIpType.ordinal()];
        if (i11 == 1) {
            this.f16143b = strArr;
        } else if (i11 == 2) {
            this.f16144c = strArr;
        }
    }

    public String toString() {
        return "host:" + this.f16142a + ", ips:" + Arrays.toString(this.f16143b) + ", ipv6s:" + Arrays.toString(this.f16144c) + ", extras:" + this.f16145d + ", expired:" + b() + ", fromDB:" + this.f16148g;
    }
}
