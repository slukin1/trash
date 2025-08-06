package u2;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f16613a;

    /* renamed from: b  reason: collision with root package name */
    public long f16614b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f16615c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f16616d;

    public c(String str, long j11, String[] strArr, int[] iArr) {
        this.f16613a = str;
        this.f16614b = j11;
        this.f16615c = strArr;
        this.f16616d = iArr;
    }

    public c(String str, String[] strArr, int[] iArr) {
        this(str, System.currentTimeMillis(), strArr, iArr);
    }

    public int[] a() {
        return this.f16616d;
    }

    public String[] b() {
        return this.f16615c;
    }

    public long c() {
        return this.f16614b;
    }
}
