package kotlinx.serialization.modules;

import d10.l;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlinx.serialization.a;
import kotlinx.serialization.b;
import kotlinx.serialization.g;
import kotlinx.serialization.modules.a;

public final class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public final Map<kotlin.reflect.c<?>, a> f57964a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<kotlin.reflect.c<?>, Map<kotlin.reflect.c<?>, b<?>>> f57965b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<kotlin.reflect.c<?>, l<?, g<?>>> f57966c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<kotlin.reflect.c<?>, Map<String, b<?>>> f57967d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<kotlin.reflect.c<?>, l<String, a<?>>> f57968e;

    public c(Map<kotlin.reflect.c<?>, ? extends a> map, Map<kotlin.reflect.c<?>, ? extends Map<kotlin.reflect.c<?>, ? extends b<?>>> map2, Map<kotlin.reflect.c<?>, ? extends l<?, ? extends g<?>>> map3, Map<kotlin.reflect.c<?>, ? extends Map<String, ? extends b<?>>> map4, Map<kotlin.reflect.c<?>, ? extends l<? super String, ? extends a<?>>> map5) {
        super((r) null);
        this.f57964a = map;
        this.f57965b = map2;
        this.f57966c = map3;
        this.f57967d = map4;
        this.f57968e = map5;
    }

    public void a(SerializersModuleCollector serializersModuleCollector) {
        for (Map.Entry next : this.f57964a.entrySet()) {
            kotlin.reflect.c cVar = (kotlin.reflect.c) next.getKey();
            a aVar = (a) next.getValue();
            if (aVar instanceof a.C0672a) {
                serializersModuleCollector.d(cVar, ((a.C0672a) aVar).b());
            } else if (aVar instanceof a.b) {
                serializersModuleCollector.a(cVar, ((a.b) aVar).b());
            }
        }
        for (Map.Entry next2 : this.f57965b.entrySet()) {
            kotlin.reflect.c cVar2 = (kotlin.reflect.c) next2.getKey();
            for (Map.Entry entry : ((Map) next2.getValue()).entrySet()) {
                serializersModuleCollector.c(cVar2, (kotlin.reflect.c) entry.getKey(), (b) entry.getValue());
            }
        }
        for (Map.Entry next3 : this.f57966c.entrySet()) {
            serializersModuleCollector.e((kotlin.reflect.c) next3.getKey(), (l) TypeIntrinsics.e((l) next3.getValue(), 1));
        }
        for (Map.Entry next4 : this.f57968e.entrySet()) {
            serializersModuleCollector.b((kotlin.reflect.c) next4.getKey(), (l) TypeIntrinsics.e((l) next4.getValue(), 1));
        }
    }

    public <T> b<T> b(kotlin.reflect.c<T> cVar, List<? extends b<?>> list) {
        a aVar = this.f57964a.get(cVar);
        b<?> a11 = aVar != null ? aVar.a(list) : null;
        if (a11 instanceof b) {
            return a11;
        }
        return null;
    }

    public <T> kotlinx.serialization.a<T> d(kotlin.reflect.c<? super T> cVar, String str) {
        Map map = this.f57967d.get(cVar);
        b bVar = map != null ? (b) map.get(str) : null;
        if (!(bVar instanceof b)) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        l<String, kotlinx.serialization.a<?>> lVar = this.f57968e.get(cVar);
        l lVar2 = TypeIntrinsics.k(lVar, 1) ? lVar : null;
        if (lVar2 != null) {
            return (kotlinx.serialization.a) lVar2.invoke(str);
        }
        return null;
    }

    public <T> g<T> e(kotlin.reflect.c<? super T> cVar, T t11) {
        if (!cVar.d(t11)) {
            return null;
        }
        Map map = this.f57965b.get(cVar);
        b bVar = map != null ? (b) map.get(Reflection.b(t11.getClass())) : null;
        if (!(bVar instanceof g)) {
            bVar = null;
        }
        if (bVar != null) {
            return bVar;
        }
        l<?, g<?>> lVar = this.f57966c.get(cVar);
        l lVar2 = TypeIntrinsics.k(lVar, 1) ? lVar : null;
        if (lVar2 != null) {
            return (g) lVar2.invoke(t11);
        }
        return null;
    }
}
