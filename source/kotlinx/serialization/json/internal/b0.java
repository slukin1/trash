package kotlinx.serialization.json.internal;

import d10.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.g;

public class b0 extends AbstractJsonTreeEncoder {

    /* renamed from: f  reason: collision with root package name */
    public final Map<String, g> f57891f = new LinkedHashMap();

    public b0(a aVar, l<? super g, Unit> lVar) {
        super(aVar, lVar, (r) null);
    }

    public g v0() {
        return new JsonObject(this.f57891f);
    }

    public <T> void y(f fVar, int i11, kotlinx.serialization.g<? super T> gVar, T t11) {
        if (t11 != null || this.f57858d.f()) {
            super.y(fVar, i11, gVar, t11);
        }
    }

    public void y0(String str, g gVar) {
        this.f57891f.put(str, gVar);
    }

    public final Map<String, g> z0() {
        return this.f57891f;
    }
}
