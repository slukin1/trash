package kotlinx.serialization;

import d10.l;
import h10.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.c;

public final class SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1 extends Lambda implements l<c<?>, b<Object>> {
    public static final SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1 INSTANCE = new SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1();

    public SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1() {
        super(1);
    }

    public final b<Object> invoke(c<?> cVar) {
        b<Object> u11;
        b<?> e11 = h.e(cVar);
        if (e11 == null || (u11 = a.u(e11)) == null) {
            return null;
        }
        return u11;
    }
}
