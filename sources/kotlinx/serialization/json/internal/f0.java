package kotlinx.serialization.json.internal;

import d10.l;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.b;
import kotlinx.serialization.json.c;
import kotlinx.serialization.json.g;
import kotlinx.serialization.json.s;
import kotlinx.serialization.json.t;

public final class f0 extends b0 {

    /* renamed from: g  reason: collision with root package name */
    public String f57900g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57901h = true;

    public f0(a aVar, l<? super g, Unit> lVar) {
        super(aVar, lVar);
    }

    public g v0() {
        return new JsonObject(z0());
    }

    public void y0(String str, g gVar) {
        if (!this.f57901h) {
            Map<String, g> z02 = z0();
            String str2 = this.f57900g;
            if (str2 == null) {
                str2 = null;
            }
            z02.put(str2, gVar);
            this.f57901h = true;
        } else if (gVar instanceof t) {
            this.f57900g = ((t) gVar).a();
            this.f57901h = false;
        } else if (gVar instanceof JsonObject) {
            throw w.d(s.f57950a.getDescriptor());
        } else if (gVar instanceof b) {
            throw w.d(c.f57832a.getDescriptor());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
