package kotlinx.serialization;

import d10.p;
import h10.a;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.c;
import kotlinx.serialization.modules.e;

public final class SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 extends Lambda implements p<c<Object>, List<? extends kotlin.reflect.p>, b<Object>> {
    public static final SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1 INSTANCE = new SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1();

    public SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1() {
        super(2);
    }

    public final b<Object> invoke(c<Object> cVar, List<? extends kotlin.reflect.p> list) {
        b<Object> u11;
        b<? extends Object> a11 = h.a(cVar, list, h.h(e.a(), list, true));
        if (a11 == null || (u11 = a.u(a11)) == null) {
            return null;
        }
        return u11;
    }
}
