package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.c;
import kotlin.reflect.e;
import kotlin.reflect.p;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.f;

public final class g1 {

    /* renamed from: a  reason: collision with root package name */
    public static final f[] f57717a = new f[0];

    public static final Set<String> a(f fVar) {
        if (fVar instanceof m) {
            return ((m) fVar).a();
        }
        HashSet hashSet = new HashSet(fVar.e());
        int e11 = fVar.e();
        for (int i11 = 0; i11 < e11; i11++) {
            hashSet.add(fVar.f(i11));
        }
        return hashSet;
    }

    public static final f[] b(List<? extends f> list) {
        f[] fVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (fVarArr = (f[]) list.toArray(new f[0])) == null) ? f57717a : fVarArr;
    }

    public static final c<Object> c(p pVar) {
        e c11 = pVar.c();
        if (c11 instanceof c) {
            return (c) c11;
        }
        throw new IllegalStateException(("Only KClass supported as classifier, got " + c11).toString());
    }

    public static final String d(String str) {
        return "Serializer for class '" + str + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    public static final String e(c<?> cVar) {
        String f11 = cVar.f();
        if (f11 == null) {
            f11 = "<local class name not available>";
        }
        return d(f11);
    }

    public static final Void f(c<?> cVar) {
        throw new SerializationException(e(cVar));
    }
}
