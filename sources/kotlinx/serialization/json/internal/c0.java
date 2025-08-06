package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.r;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.b;
import kotlinx.serialization.json.g;

public final class c0 extends b {

    /* renamed from: f  reason: collision with root package name */
    public final b f57892f;

    /* renamed from: g  reason: collision with root package name */
    public final int f57893g = v0().size();

    /* renamed from: h  reason: collision with root package name */
    public int f57894h = -1;

    public c0(a aVar, b bVar) {
        super(aVar, bVar, (r) null);
        this.f57892f = bVar;
    }

    public String c0(f fVar, int i11) {
        return String.valueOf(i11);
    }

    public g g0(String str) {
        return v0().get(Integer.parseInt(str));
    }

    public int w(f fVar) {
        int i11 = this.f57894h;
        if (i11 >= this.f57893g - 1) {
            return -1;
        }
        int i12 = i11 + 1;
        this.f57894h = i12;
        return i12;
    }

    /* renamed from: x0 */
    public b v0() {
        return this.f57892f;
    }
}
