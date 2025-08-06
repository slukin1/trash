package d7;

public class b1 {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b1 f68984b;

    /* renamed from: a  reason: collision with root package name */
    public c1 f68985a;

    public static b1 a() {
        if (f68984b == null) {
            synchronized (b1.class) {
                f68984b = new b1();
            }
        }
        return f68984b;
    }

    public c1 b() {
        return this.f68985a;
    }

    public void c(c1 c1Var) {
        this.f68985a = c1Var;
    }
}
