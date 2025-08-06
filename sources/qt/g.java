package qt;

public final class g {

    /* renamed from: d  reason: collision with root package name */
    public static g f84695d;

    /* renamed from: a  reason: collision with root package name */
    public String f84696a = "1";

    /* renamed from: b  reason: collision with root package name */
    public String f84697b = "0";

    /* renamed from: c  reason: collision with root package name */
    public boolean f84698c = false;

    public static g a() {
        if (f84695d == null) {
            f84695d = new g();
        }
        return f84695d;
    }

    public boolean b() {
        return "1".equals(this.f84697b);
    }

    public boolean c() {
        return this.f84698c;
    }

    public boolean d() {
        return "1".equals(this.f84696a);
    }

    public void e(boolean z11) {
        this.f84698c = z11;
    }

    public void f(String str) {
        this.f84696a = str;
    }

    public void g(String str) {
        this.f84697b = str;
    }
}
