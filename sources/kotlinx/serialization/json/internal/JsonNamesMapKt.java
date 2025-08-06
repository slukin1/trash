package kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.x;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.p;
import kotlinx.serialization.json.q;
import kotlinx.serialization.json.v;

public final class JsonNamesMapKt {

    /* renamed from: a  reason: collision with root package name */
    public static final DescriptorSchemaCache.Key<Map<String, Integer>> f57872a = new DescriptorSchemaCache.Key<>();

    /* renamed from: b  reason: collision with root package name */
    public static final DescriptorSchemaCache.Key<String[]> f57873b = new DescriptorSchemaCache.Key<>();

    public static final Map<String, Integer> b(f fVar, a aVar) {
        String[] names;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        q k11 = k(fVar, aVar);
        int e11 = fVar.e();
        for (int i11 = 0; i11 < e11; i11++) {
            List<Annotation> g11 = fVar.g(i11);
            ArrayList arrayList = new ArrayList();
            for (T next : g11) {
                if (next instanceof p) {
                    arrayList.add(next);
                }
            }
            p pVar = (p) CollectionsKt___CollectionsKt.x0(arrayList);
            if (!(pVar == null || (names = pVar.names()) == null)) {
                for (String c11 : names) {
                    c(linkedHashMap, fVar, c11, i11);
                }
            }
            if (k11 != null) {
                c(linkedHashMap, fVar, k11.a(fVar, i11, fVar.f(i11)), i11);
            }
        }
        return linkedHashMap.isEmpty() ? MapsKt__MapsKt.h() : linkedHashMap;
    }

    public static final void c(Map<String, Integer> map, f fVar, String str, int i11) {
        if (!map.containsKey(str)) {
            map.put(str, Integer.valueOf(i11));
            return;
        }
        throw new JsonException("The suggested name '" + str + "' for property " + fVar.f(i11) + " is already one of the names for property " + fVar.f(((Number) MapsKt__MapsKt.i(map, str)).intValue()) + " in " + fVar);
    }

    public static final Map<String, Integer> d(a aVar, f fVar) {
        return (Map) v.a(aVar).b(fVar, f57872a, new JsonNamesMapKt$deserializationNamesMap$1(fVar, aVar));
    }

    public static final DescriptorSchemaCache.Key<Map<String, Integer>> e() {
        return f57872a;
    }

    public static final String f(f fVar, a aVar, int i11) {
        q k11 = k(fVar, aVar);
        return k11 == null ? fVar.f(i11) : l(fVar, aVar, k11)[i11];
    }

    public static final int g(f fVar, a aVar, String str) {
        if (k(fVar, aVar) != null) {
            return h(aVar, fVar, str);
        }
        int c11 = fVar.c(str);
        if (c11 == -3 && aVar.f().k()) {
            return h(aVar, fVar, str);
        }
        return c11;
    }

    public static final int h(a aVar, f fVar, String str) {
        Integer num = d(aVar, fVar).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int i(f fVar, a aVar, String str, String str2) {
        int g11 = g(fVar, aVar, str);
        if (g11 != -3) {
            return g11;
        }
        throw new SerializationException(fVar.h() + " does not contain element with name '" + str + '\'' + str2);
    }

    public static /* synthetic */ int j(f fVar, a aVar, String str, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = "";
        }
        return i(fVar, aVar, str, str2);
    }

    public static final q k(f fVar, a aVar) {
        if (x.b(fVar.getKind(), i.a.f57647a)) {
            return aVar.f().h();
        }
        return null;
    }

    public static final String[] l(f fVar, a aVar, q qVar) {
        return (String[]) v.a(aVar).b(fVar, f57873b, new JsonNamesMapKt$serializationNamesIndices$1(fVar, qVar));
    }
}
