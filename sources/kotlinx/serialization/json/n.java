package kotlinx.serialization.json;

import gw.e;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.json.internal.n0;

public final class n extends t {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f57943a;

    /* renamed from: b  reason: collision with root package name */
    public final f f57944b;

    /* renamed from: c  reason: collision with root package name */
    public final String f57945c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(Object obj, boolean z11, f fVar, int i11, r rVar) {
        this(obj, z11, (i11 & 4) != 0 ? null : fVar);
    }

    public String a() {
        return this.f57945c;
    }

    public boolean c() {
        return this.f57943a;
    }

    public final f d() {
        return this.f57944b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return c() == nVar.c() && x.b(a(), nVar.a());
    }

    public int hashCode() {
        return (e.a(c()) * 31) + a().hashCode();
    }

    public String toString() {
        if (!c()) {
            return a();
        }
        StringBuilder sb2 = new StringBuilder();
        n0.c(sb2, a());
        return sb2.toString();
    }

    public n(Object obj, boolean z11, f fVar) {
        super((r) null);
        this.f57943a = z11;
        this.f57944b = fVar;
        this.f57945c = obj.toString();
        if (fVar != null && !fVar.isInline()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
