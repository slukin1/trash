package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.r;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.g;
import kotlinx.serialization.json.t;

public final class x extends b {

    /* renamed from: f  reason: collision with root package name */
    public final t f57940f;

    public x(a aVar, t tVar) {
        super(aVar, tVar, (r) null);
        this.f57940f = tVar;
        Z("primitive");
    }

    public g g0(String str) {
        if (str == "primitive") {
            return v0();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
    }

    public int w(f fVar) {
        return 0;
    }

    /* renamed from: x0 */
    public t v0() {
        return this.f57940f;
    }
}
