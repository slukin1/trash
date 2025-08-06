package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.g;

public final class TreeJsonEncoderKt {
    public static final boolean b(f fVar) {
        return (fVar.getKind() instanceof e) || fVar.getKind() == h.b.f57646a;
    }

    public static final <T> g c(a aVar, T t11, kotlinx.serialization.g<? super T> gVar) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        new b0(aVar, new TreeJsonEncoderKt$writeJson$encoder$1(ref$ObjectRef)).e(gVar, t11);
        T t12 = ref$ObjectRef.element;
        if (t12 == null) {
            return null;
        }
        return (g) t12;
    }
}
