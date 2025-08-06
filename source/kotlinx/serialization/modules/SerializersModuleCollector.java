package kotlinx.serialization.modules;

import d10.l;
import java.util.List;
import kotlin.reflect.c;
import kotlinx.serialization.a;
import kotlinx.serialization.b;
import kotlinx.serialization.g;

public interface SerializersModuleCollector {

    public static final class DefaultImpls {
        public static <T> void a(SerializersModuleCollector serializersModuleCollector, c<T> cVar, b<T> bVar) {
            serializersModuleCollector.a(cVar, new SerializersModuleCollector$contextual$1(bVar));
        }
    }

    <T> void a(c<T> cVar, l<? super List<? extends b<?>>, ? extends b<?>> lVar);

    <Base> void b(c<Base> cVar, l<? super String, ? extends a<? extends Base>> lVar);

    <Base, Sub extends Base> void c(c<Base> cVar, c<Sub> cVar2, b<Sub> bVar);

    <T> void d(c<T> cVar, b<T> bVar);

    <Base> void e(c<Base> cVar, l<? super Base, ? extends g<? super Base>> lVar);
}
