package kotlinx.serialization.json.internal;

import d10.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.b;
import kotlinx.serialization.json.g;

public final class d0 extends AbstractJsonTreeEncoder {

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<g> f57895f = new ArrayList<>();

    public d0(a aVar, l<? super g, Unit> lVar) {
        super(aVar, lVar, (r) null);
    }

    public String e0(f fVar, int i11) {
        return String.valueOf(i11);
    }

    public g v0() {
        return new b(this.f57895f);
    }

    public void y0(String str, g gVar) {
        this.f57895f.add(Integer.parseInt(str), gVar);
    }
}
