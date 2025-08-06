package kotlinx.serialization.internal;

import d10.l;
import java.util.Iterator;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.g;
import kotlinx.serialization.descriptors.h;

public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {

    /* renamed from: m  reason: collision with root package name */
    public final h f57655m = h.b.f57646a;

    /* renamed from: n  reason: collision with root package name */
    public final i f57656n;

    public EnumDescriptor(String str, int i11) {
        super(str, (d0) null, i11, 2, (r) null);
        this.f57656n = LazyKt__LazyJVMKt.a(new EnumDescriptor$elementDescriptors$2(i11, str, this));
    }

    public f d(int i11) {
        return q()[i11];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return fVar.getKind() == h.b.f57646a && x.b(h(), fVar.h()) && x.b(g1.a(this), g1.a(fVar));
    }

    public h getKind() {
        return this.f57655m;
    }

    public int hashCode() {
        int hashCode = h().hashCode();
        Iterator<String> it2 = g.b(this).iterator();
        int i11 = 1;
        while (it2.hasNext()) {
            int i12 = i11 * 31;
            String next = it2.next();
            i11 = i12 + (next != null ? next.hashCode() : 0);
        }
        return (hashCode * 31) + i11;
    }

    public final f[] q() {
        return (f[]) this.f57656n.getValue();
    }

    public String toString() {
        Iterable<String> b11 = g.b(this);
        return CollectionsKt___CollectionsKt.k0(b11, ", ", h() + '(', ")", 0, (CharSequence) null, (l) null, 56, (Object) null);
    }
}
