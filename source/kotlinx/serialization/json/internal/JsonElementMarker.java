package kotlinx.serialization.json.internal;

import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.internal.z;

public final class JsonElementMarker {

    /* renamed from: a  reason: collision with root package name */
    public final z f57870a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57871b;

    public JsonElementMarker(f fVar) {
        this.f57870a = new z(fVar, new JsonElementMarker$origin$1(this));
    }

    public final boolean b() {
        return this.f57871b;
    }

    public final void c(int i11) {
        this.f57870a.a(i11);
    }

    public final int d() {
        return this.f57870a.d();
    }

    public final boolean e(f fVar, int i11) {
        boolean z11 = !fVar.i(i11) && fVar.d(i11).b();
        this.f57871b = z11;
        return z11;
    }
}
