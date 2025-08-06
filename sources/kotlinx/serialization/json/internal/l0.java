package kotlinx.serialization.json.internal;

import h10.a;
import java.util.Set;
import kotlin.jvm.internal.x;
import kotlin.m;
import kotlin.o;
import kotlin.q;
import kotlin.t;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.json.i;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<f> f57931a = SetsKt__SetsKt.f(a.w(o.f56805c).getDescriptor(), a.x(q.f56813c).getDescriptor(), a.v(m.f56800c).getDescriptor(), a.y(t.f56897c).getDescriptor());

    public static final boolean a(f fVar) {
        return fVar.isInline() && x.b(fVar, i.m());
    }

    public static final boolean b(f fVar) {
        return fVar.isInline() && f57931a.contains(fVar);
    }
}
