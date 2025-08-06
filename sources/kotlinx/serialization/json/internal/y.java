package kotlinx.serialization.json.internal;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.g;

public final class y extends AbstractJsonTreeEncoder {

    /* renamed from: f  reason: collision with root package name */
    public g f57941f;

    public y(a aVar, l<? super g, Unit> lVar) {
        super(aVar, lVar, (r) null);
        c0("primitive");
    }

    public g v0() {
        g gVar = this.f57941f;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalArgumentException("Primitive element has not been recorded. Is call to .encodeXxx is missing in serializer?".toString());
    }

    public void y0(String str, g gVar) {
        boolean z11 = true;
        if (str == "primitive") {
            if (this.f57941f != null) {
                z11 = false;
            }
            if (z11) {
                this.f57941f = gVar;
                return;
            }
            throw new IllegalArgumentException("Primitive element was already recorded. Does call to .encodeXxx happen more than once?".toString());
        }
        throw new IllegalArgumentException("This output can only consume primitives with 'primitive' tag".toString());
    }
}
