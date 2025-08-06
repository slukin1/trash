package cn.sharesdk.framework.a.b;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static int f13328c;

    /* renamed from: d  reason: collision with root package name */
    private static long f13329d;

    /* renamed from: a  reason: collision with root package name */
    public int f13330a;

    /* renamed from: b  reason: collision with root package name */
    public String f13331b;

    public String a() {
        return "[API]";
    }

    public void a(long j11) {
        f13329d = j11;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 50;
    }

    public long d() {
        return (long) f13328c;
    }

    public long e() {
        return f13329d;
    }

    public void f() {
        f13328c++;
    }

    public String toString() {
        return super.toString() + '|' + this.f13330a + '|' + this.f13331b;
    }
}
