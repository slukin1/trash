package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.f;

public final class i0 extends PluginGeneratedSerialDescriptor {

    /* renamed from: m  reason: collision with root package name */
    public final boolean f57726m = true;

    public i0(String str, d0<?> d0Var) {
        super(str, d0Var, 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i0) {
            f fVar = (f) obj;
            if (x.b(h(), fVar.h())) {
                i0 i0Var = (i0) obj;
                if ((i0Var.isInline() && Arrays.equals(o(), i0Var.o())) && e() == fVar.e()) {
                    int e11 = e();
                    int i11 = 0;
                    while (i11 < e11) {
                        if (x.b(d(i11).h(), fVar.d(i11).h()) && x.b(d(i11).getKind(), fVar.d(i11).getKind())) {
                            i11++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode() * 31;
    }

    public boolean isInline() {
        return this.f57726m;
    }
}
