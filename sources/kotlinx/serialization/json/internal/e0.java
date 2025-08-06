package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.jvm.internal.r;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.g;
import kotlinx.serialization.json.i;

public final class e0 extends a0 {

    /* renamed from: k  reason: collision with root package name */
    public final JsonObject f57896k;

    /* renamed from: l  reason: collision with root package name */
    public final List<String> f57897l;

    /* renamed from: m  reason: collision with root package name */
    public final int f57898m;

    /* renamed from: n  reason: collision with root package name */
    public int f57899n = -1;

    public e0(a aVar, JsonObject jsonObject) {
        super(aVar, jsonObject, (String) null, (f) null, 12, (r) null);
        this.f57896k = jsonObject;
        List<String> I0 = CollectionsKt___CollectionsKt.I0(v0().keySet());
        this.f57897l = I0;
        this.f57898m = I0.size() * 2;
    }

    public void c(f fVar) {
    }

    public String c0(f fVar, int i11) {
        return this.f57897l.get(i11 / 2);
    }

    public g g0(String str) {
        return this.f57899n % 2 == 0 ? i.c(str) : (g) MapsKt__MapsKt.i(v0(), str);
    }

    public int w(f fVar) {
        int i11 = this.f57899n;
        if (i11 >= this.f57898m - 1) {
            return -1;
        }
        int i12 = i11 + 1;
        this.f57899n = i12;
        return i12;
    }

    /* renamed from: z0 */
    public JsonObject v0() {
        return this.f57896k;
    }
}
