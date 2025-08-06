package kotlinx.serialization.modules;

import d10.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.x;
import kotlin.reflect.c;
import kotlinx.serialization.a;
import kotlinx.serialization.b;
import kotlinx.serialization.g;
import kotlinx.serialization.modules.a;

public final class SerializersModuleBuilder implements SerializersModuleCollector {

    /* renamed from: a  reason: collision with root package name */
    public final Map<c<?>, a> f57957a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<c<?>, Map<c<?>, b<?>>> f57958b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<c<?>, l<?, g<?>>> f57959c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<c<?>, Map<String, b<?>>> f57960d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<c<?>, l<String, a<?>>> f57961e = new HashMap();

    public static /* synthetic */ void j(SerializersModuleBuilder serializersModuleBuilder, c cVar, c cVar2, b bVar, boolean z11, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        serializersModuleBuilder.i(cVar, cVar2, bVar, z11);
    }

    public static /* synthetic */ void l(SerializersModuleBuilder serializersModuleBuilder, c cVar, a aVar, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        serializersModuleBuilder.k(cVar, aVar, z11);
    }

    public <T> void a(c<T> cVar, l<? super List<? extends b<?>>, ? extends b<?>> lVar) {
        l(this, cVar, new a.b(lVar), false, 4, (Object) null);
    }

    public <Base> void b(c<Base> cVar, l<? super String, ? extends kotlinx.serialization.a<? extends Base>> lVar) {
        g(cVar, lVar, false);
    }

    public <Base, Sub extends Base> void c(c<Base> cVar, c<Sub> cVar2, b<Sub> bVar) {
        j(this, cVar, cVar2, bVar, false, 8, (Object) null);
    }

    public <T> void d(c<T> cVar, b<T> bVar) {
        l(this, cVar, new a.C0672a(bVar), false, 4, (Object) null);
    }

    public <Base> void e(c<Base> cVar, l<? super Base, ? extends g<? super Base>> lVar) {
        h(cVar, lVar, false);
    }

    public final d f() {
        return new c(this.f57957a, this.f57958b, this.f57959c, this.f57960d, this.f57961e);
    }

    public final <Base> void g(c<Base> cVar, l<? super String, ? extends kotlinx.serialization.a<? extends Base>> lVar, boolean z11) {
        l lVar2 = this.f57961e.get(cVar);
        if (lVar2 == null || x.b(lVar2, lVar) || z11) {
            this.f57961e.put(cVar, lVar);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + cVar + " is already registered: " + lVar2);
    }

    public final <Base> void h(c<Base> cVar, l<? super Base, ? extends g<? super Base>> lVar, boolean z11) {
        l lVar2 = this.f57959c.get(cVar);
        if (lVar2 == null || x.b(lVar2, lVar) || z11) {
            this.f57959c.put(cVar, lVar);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + cVar + " is already registered: " + lVar2);
    }

    public final <Base, Sub extends Base> void i(c<Base> cVar, c<Sub> cVar2, b<Sub> bVar, boolean z11) {
        Object obj;
        boolean z12;
        String h11 = bVar.getDescriptor().h();
        Map<c<?>, Map<c<?>, b<?>>> map = this.f57958b;
        Map<c<?>, b<?>> map2 = map.get(cVar);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(cVar, map2);
        }
        Map map3 = map2;
        b bVar2 = (b) map3.get(cVar2);
        Map<c<?>, Map<String, b<?>>> map4 = this.f57960d;
        Map<String, b<?>> map5 = map4.get(cVar);
        if (map5 == null) {
            map5 = new HashMap<>();
            map4.put(cVar, map5);
        }
        Map map6 = map5;
        if (z11) {
            if (bVar2 != null) {
                map6.remove(bVar2.getDescriptor().h());
            }
            map3.put(cVar2, bVar);
            map6.put(h11, bVar);
            return;
        }
        if (bVar2 != null) {
            if (x.b(bVar2, bVar)) {
                map6.remove(bVar2.getDescriptor().h());
            } else {
                throw new SerializerAlreadyRegisteredException(cVar, cVar2);
            }
        }
        b bVar3 = (b) map6.get(h11);
        if (bVar3 != null) {
            Iterator it2 = MapsKt___MapsKt.A(this.f57958b.get(cVar)).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((Map.Entry) obj).getValue() == bVar3) {
                    z12 = true;
                    continue;
                } else {
                    z12 = false;
                    continue;
                }
                if (z12) {
                    break;
                }
            }
            throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + cVar + "' have the same serial name '" + h11 + "': '" + cVar2 + "' and '" + ((Map.Entry) obj) + '\'');
        }
        map3.put(cVar2, bVar);
        map6.put(h11, bVar);
    }

    public final <T> void k(c<T> cVar, a aVar, boolean z11) {
        a aVar2;
        if (z11 || (aVar2 = this.f57957a.get(cVar)) == null || x.b(aVar2, aVar)) {
            this.f57957a.put(cVar, aVar);
            return;
        }
        throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + cVar + " already registered in this module");
    }
}
