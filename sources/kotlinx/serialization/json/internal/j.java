package kotlinx.serialization.json.internal;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final g0 f57909a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57910b = true;

    public j(g0 g0Var) {
        this.f57909a = g0Var;
    }

    public final boolean a() {
        return this.f57910b;
    }

    public void b() {
        this.f57910b = true;
    }

    public void c() {
        this.f57910b = false;
    }

    public void d(byte b11) {
        this.f57909a.writeLong((long) b11);
    }

    public final void e(char c11) {
        this.f57909a.a(c11);
    }

    public void f(double d11) {
        this.f57909a.c(String.valueOf(d11));
    }

    public void g(float f11) {
        this.f57909a.c(String.valueOf(f11));
    }

    public void h(int i11) {
        this.f57909a.writeLong((long) i11);
    }

    public void i(long j11) {
        this.f57909a.writeLong(j11);
    }

    public final void j(String str) {
        this.f57909a.c(str);
    }

    public void k(short s11) {
        this.f57909a.writeLong((long) s11);
    }

    public void l(boolean z11) {
        this.f57909a.c(String.valueOf(z11));
    }

    public void m(String str) {
        this.f57909a.b(str);
    }

    public final void n(boolean z11) {
        this.f57910b = z11;
    }

    public void o() {
    }

    public void p() {
    }
}
