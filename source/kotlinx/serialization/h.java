package kotlinx.serialization;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.reflect.c;
import kotlin.reflect.p;
import kotlinx.serialization.modules.d;

public final class h {
    public static final b<? extends Object> a(c<Object> cVar, List<? extends p> list, List<? extends b<Object>> list2) {
        return j.d(cVar, list, list2);
    }

    public static final b<Object> b(Type type) {
        return i.d(type);
    }

    public static final b<Object> c(d dVar, Type type) {
        return i.e(dVar, type);
    }

    public static final b<Object> d(d dVar, p pVar) {
        return j.e(dVar, pVar);
    }

    public static final <T> b<T> e(c<T> cVar) {
        return j.g(cVar);
    }

    public static final b<Object> f(d dVar, Type type) {
        return i.h(dVar, type);
    }

    public static final b<Object> g(d dVar, p pVar) {
        return j.h(dVar, pVar);
    }

    public static final List<b<Object>> h(d dVar, List<? extends p> list, boolean z11) {
        return j.i(dVar, list, z11);
    }
}
