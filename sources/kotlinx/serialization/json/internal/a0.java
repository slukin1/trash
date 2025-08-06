package kotlinx.serialization.json.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.d;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.internal.n0;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.g;
import kotlinx.serialization.json.i;
import kotlinx.serialization.json.q;
import kotlinx.serialization.json.t;
import kotlinx.serialization.json.v;

public class a0 extends b {

    /* renamed from: f  reason: collision with root package name */
    public final JsonObject f57883f;

    /* renamed from: g  reason: collision with root package name */
    public final String f57884g;

    /* renamed from: h  reason: collision with root package name */
    public final f f57885h;

    /* renamed from: i  reason: collision with root package name */
    public int f57886i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f57887j;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(a aVar, JsonObject jsonObject, String str, f fVar, int i11, r rVar) {
        this(aVar, jsonObject, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? null : fVar);
    }

    public boolean D() {
        return !this.f57887j && super.D();
    }

    public kotlinx.serialization.encoding.a b(f fVar) {
        if (fVar == this.f57885h) {
            return this;
        }
        return super.b(fVar);
    }

    public void c(f fVar) {
        Set<String> set;
        if (!this.f57890e.g() && !(fVar.getKind() instanceof d)) {
            q k11 = JsonNamesMapKt.k(fVar, d());
            if (k11 == null && !this.f57890e.k()) {
                set = n0.a(fVar);
            } else if (k11 != null) {
                set = JsonNamesMapKt.d(d(), fVar).keySet();
            } else {
                Set<String> a11 = n0.a(fVar);
                Map map = (Map) v.a(d()).a(fVar, JsonNamesMapKt.e());
                Set keySet = map != null ? map.keySet() : null;
                if (keySet == null) {
                    keySet = SetsKt__SetsKt.d();
                }
                set = SetsKt___SetsKt.i(a11, keySet);
            }
            for (String next : v0().keySet()) {
                if (!set.contains(next) && !x.b(next, this.f57884g)) {
                    throw w.g(next, v0().toString());
                }
            }
        }
    }

    public String c0(f fVar, int i11) {
        String str;
        T t11;
        boolean z11;
        q k11 = JsonNamesMapKt.k(fVar, d());
        String f11 = fVar.f(i11);
        if (k11 == null && (!this.f57890e.k() || v0().keySet().contains(f11))) {
            return f11;
        }
        Map<String, Integer> d11 = JsonNamesMapKt.d(d(), fVar);
        Iterator<T> it2 = v0().keySet().iterator();
        while (true) {
            str = null;
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            Integer num = d11.get((String) t11);
            if (num != null && num.intValue() == i11) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        String str2 = (String) t11;
        if (str2 != null) {
            return str2;
        }
        if (k11 != null) {
            str = k11.a(fVar, i11, f11);
        }
        return str == null ? f11 : str;
    }

    public g g0(String str) {
        return (g) MapsKt__MapsKt.i(v0(), str);
    }

    public int w(f fVar) {
        while (this.f57886i < fVar.e()) {
            int i11 = this.f57886i;
            this.f57886i = i11 + 1;
            String d02 = X(fVar, i11);
            int i12 = this.f57886i - 1;
            this.f57887j = false;
            if ((v0().containsKey(d02) || x0(fVar, i12)) && (!this.f57890e.d() || !y0(fVar, i12, d02))) {
                return i12;
            }
        }
        return -1;
    }

    public final boolean x0(f fVar, int i11) {
        boolean z11 = !d().f().f() && !fVar.i(i11) && fVar.d(i11).b();
        this.f57887j = z11;
        return z11;
    }

    public final boolean y0(f fVar, int i11, String str) {
        a d11 = d();
        f d12 = fVar.d(i11);
        if (!d12.b() && (g0(str) instanceof JsonNull)) {
            return true;
        }
        if (x.b(d12.getKind(), h.b.f57646a) && (!d12.b() || !(g0(str) instanceof JsonNull))) {
            g g02 = g0(str);
            String str2 = null;
            t tVar = g02 instanceof t ? (t) g02 : null;
            if (tVar != null) {
                str2 = i.f(tVar);
            }
            if (str2 != null && JsonNamesMapKt.g(d12, d11, str2) == -3) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: z0 */
    public JsonObject v0() {
        return this.f57883f;
    }

    public a0(a aVar, JsonObject jsonObject, String str, f fVar) {
        super(aVar, jsonObject, (r) null);
        this.f57883f = jsonObject;
        this.f57884g = str;
        this.f57885h = fVar;
    }
}
