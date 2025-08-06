package cn.sharesdk.framework.a.b;

public class d extends c {

    /* renamed from: d  reason: collision with root package name */
    private static int f13346d;

    /* renamed from: m  reason: collision with root package name */
    private static long f13347m;

    /* renamed from: a  reason: collision with root package name */
    public String f13348a;

    /* renamed from: b  reason: collision with root package name */
    public int f13349b;

    /* renamed from: c  reason: collision with root package name */
    public String f13350c = "";

    public String a() {
        return "[EVT]";
    }

    public void a(long j11) {
        f13347m = j11;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 30;
    }

    public long d() {
        return (long) f13346d;
    }

    public long e() {
        return f13347m;
    }

    public void f() {
        f13346d++;
    }

    public String toString() {
        return super.toString() + '|' + this.f13348a + '|' + this.f13349b + '|' + this.f13350c;
    }
}
