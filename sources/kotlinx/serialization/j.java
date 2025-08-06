package kotlinx.serialization;

import h10.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import kotlin.reflect.c;
import kotlin.reflect.p;
import kotlin.reflect.q;
import kotlinx.serialization.internal.e;
import kotlinx.serialization.internal.f0;
import kotlinx.serialization.internal.f1;
import kotlinx.serialization.internal.g1;
import kotlinx.serialization.internal.h0;
import kotlinx.serialization.internal.n1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.t0;
import kotlinx.serialization.modules.d;

public final /* synthetic */ class j {
    public static final b<? extends Object> a(c<Object> cVar, List<? extends p> list, List<? extends b<Object>> list2) {
        if (x.b(cVar, Reflection.b(Collection.class)) ? true : x.b(cVar, Reflection.b(List.class)) ? true : x.b(cVar, Reflection.b(List.class)) ? true : x.b(cVar, Reflection.b(ArrayList.class))) {
            return new e((b) list2.get(0));
        }
        if (x.b(cVar, Reflection.b(HashSet.class))) {
            return new h0((b) list2.get(0));
        }
        if (x.b(cVar, Reflection.b(Set.class)) ? true : x.b(cVar, Reflection.b(Set.class)) ? true : x.b(cVar, Reflection.b(LinkedHashSet.class))) {
            return new t0((b) list2.get(0));
        }
        if (x.b(cVar, Reflection.b(HashMap.class))) {
            return new f0((b) list2.get(0), (b) list2.get(1));
        }
        if (x.b(cVar, Reflection.b(Map.class)) ? true : x.b(cVar, Reflection.b(Map.class)) ? true : x.b(cVar, Reflection.b(LinkedHashMap.class))) {
            return new r0((b) list2.get(0), (b) list2.get(1));
        }
        if (x.b(cVar, Reflection.b(Map.Entry.class))) {
            return a.j((b) list2.get(0), (b) list2.get(1));
        }
        if (x.b(cVar, Reflection.b(Pair.class))) {
            return a.m((b) list2.get(0), (b) list2.get(1));
        }
        if (x.b(cVar, Reflection.b(Triple.class))) {
            return a.p((b) list2.get(0), (b) list2.get(1), (b) list2.get(2));
        }
        if (f1.k(cVar)) {
            return a.a((c) ((p) list.get(0)).c(), (b) list2.get(0));
        }
        return null;
    }

    public static final b<? extends Object> b(c<Object> cVar, List<? extends b<Object>> list) {
        b[] bVarArr = (b[]) list.toArray(new b[0]);
        return f1.d(cVar, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }

    public static final <T> b<T> c(b<T> bVar, boolean z11) {
        return z11 ? a.u(bVar) : bVar;
    }

    public static final b<? extends Object> d(c<Object> cVar, List<? extends p> list, List<? extends b<Object>> list2) {
        b<? extends Object> a11 = a(cVar, list, list2);
        return a11 == null ? b(cVar, list2) : a11;
    }

    public static final b<Object> e(d dVar, p pVar) {
        b<Object> f11 = f(dVar, pVar, true);
        if (f11 != null) {
            return f11;
        }
        f1.l(g1.c(pVar));
        throw new KotlinNothingValueException();
    }

    public static final b<Object> f(d dVar, p pVar, boolean z11) {
        b<Object> bVar;
        b<? extends Object> bVar2;
        c<Object> c11 = g1.c(pVar);
        boolean b11 = pVar.b();
        List<q> g11 = pVar.g();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(g11, 10));
        for (q a11 : g11) {
            p a12 = a11.a();
            if (a12 != null) {
                arrayList.add(a12);
            } else {
                throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + pVar).toString());
            }
        }
        if (arrayList.isEmpty()) {
            bVar = SerializersCacheKt.a(c11, b11);
        } else {
            Object b12 = SerializersCacheKt.b(c11, arrayList, b11);
            if (z11) {
                if (Result.m3078isFailureimpl(b12)) {
                    b12 = null;
                }
                bVar = (b) b12;
            } else if (Result.m3075exceptionOrNullimpl(b12) != null) {
                return null;
            } else {
                bVar = (b) b12;
            }
        }
        if (bVar != null) {
            return bVar;
        }
        if (arrayList.isEmpty()) {
            bVar2 = d.c(dVar, c11, (List) null, 2, (Object) null);
        } else {
            List h11 = h.h(dVar, arrayList, z11);
            if (h11 == null) {
                return null;
            }
            b<? extends Object> a13 = h.a(c11, arrayList, h11);
            bVar2 = a13 == null ? dVar.b(c11, h11) : a13;
        }
        if (bVar2 != null) {
            return c(bVar2, b11);
        }
        return null;
    }

    public static final <T> b<T> g(c<T> cVar) {
        b<T> b11 = f1.b(cVar);
        return b11 == null ? n1.b(cVar) : b11;
    }

    public static final b<Object> h(d dVar, p pVar) {
        return f(dVar, pVar, false);
    }

    public static final List<b<Object>> i(d dVar, List<? extends p> list, boolean z11) {
        ArrayList arrayList;
        if (z11) {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (p d11 : list) {
                arrayList.add(h.d(dVar, d11));
            }
        } else {
            arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (p g11 : list) {
                b<Object> g12 = h.g(dVar, g11);
                if (g12 == null) {
                    return null;
                }
                arrayList.add(g12);
            }
        }
        return arrayList;
    }
}
