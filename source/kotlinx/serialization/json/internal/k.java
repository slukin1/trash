package kotlinx.serialization.json.internal;

public final class k extends j {

    /* renamed from: c  reason: collision with root package name */
    public final boolean f57921c;

    public k(g0 g0Var, boolean z11) {
        super(g0Var);
        this.f57921c = z11;
    }

    public void m(String str) {
        if (this.f57921c) {
            super.m(str);
        } else {
            super.j(str);
        }
    }
}
