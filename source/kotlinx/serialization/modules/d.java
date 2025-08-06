package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.reflect.c;
import kotlinx.serialization.a;
import kotlinx.serialization.b;
import kotlinx.serialization.g;

public abstract class d {
    public d() {
    }

    public /* synthetic */ d(r rVar) {
        this();
    }

    public static /* synthetic */ b c(d dVar, c cVar, List list, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                list = CollectionsKt__CollectionsKt.k();
            }
            return dVar.b(cVar, list);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
    }

    public abstract void a(SerializersModuleCollector serializersModuleCollector);

    public abstract <T> b<T> b(c<T> cVar, List<? extends b<?>> list);

    public abstract <T> a<T> d(c<? super T> cVar, String str);

    public abstract <T> g<T> e(c<? super T> cVar, T t11);
}
