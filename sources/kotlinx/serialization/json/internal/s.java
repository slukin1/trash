package kotlinx.serialization.json.internal;

import kotlinx.serialization.json.a;

public final class s extends j {

    /* renamed from: c  reason: collision with root package name */
    public final a f57936c;

    /* renamed from: d  reason: collision with root package name */
    public int f57937d;

    public s(g0 g0Var, a aVar) {
        super(g0Var);
        this.f57936c = aVar;
    }

    public void b() {
        n(true);
        this.f57937d++;
    }

    public void c() {
        n(false);
        j("\n");
        int i11 = this.f57937d;
        for (int i12 = 0; i12 < i11; i12++) {
            j(this.f57936c.f().j());
        }
    }

    public void o() {
        e(' ');
    }

    public void p() {
        this.f57937d--;
    }
}
