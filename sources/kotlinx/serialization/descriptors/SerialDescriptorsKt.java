package kotlinx.serialization.descriptors;

import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.i;
import kotlinx.serialization.internal.n1;

public final class SerialDescriptorsKt {
    public static final f a(String str, e eVar) {
        if (!StringsKt__StringsJVMKt.z(str)) {
            return n1.a(str, eVar);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final f b(String str, f[] fVarArr, l<? super a, Unit> lVar) {
        if (!StringsKt__StringsJVMKt.z(str)) {
            a aVar = new a(str);
            lVar.invoke(aVar);
            return new SerialDescriptorImpl(str, i.a.f57647a, aVar.f().size(), ArraysKt___ArraysKt.x0(fVarArr), aVar);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final f c(String str, h hVar, f[] fVarArr, l<? super a, Unit> lVar) {
        if (!(!StringsKt__StringsJVMKt.z(str))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        } else if (!x.b(hVar, i.a.f57647a)) {
            a aVar = new a(str);
            lVar.invoke(aVar);
            return new SerialDescriptorImpl(str, hVar, aVar.f().size(), ArraysKt___ArraysKt.x0(fVarArr), aVar);
        } else {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
    }

    public static /* synthetic */ f d(String str, h hVar, f[] fVarArr, l lVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            lVar = SerialDescriptorsKt$buildSerialDescriptor$1.INSTANCE;
        }
        return c(str, hVar, fVarArr, lVar);
    }
}
