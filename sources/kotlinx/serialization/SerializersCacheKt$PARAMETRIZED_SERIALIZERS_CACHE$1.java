package kotlinx.serialization;

import d10.p;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.c;
import kotlinx.serialization.modules.e;

public final class SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1 extends Lambda implements p<c<Object>, List<? extends kotlin.reflect.p>, b<? extends Object>> {
    public static final SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1 INSTANCE = new SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1();

    public SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1() {
        super(2);
    }

    public final b<? extends Object> invoke(c<Object> cVar, List<? extends kotlin.reflect.p> list) {
        return h.a(cVar, list, h.h(e.a(), list, true));
    }
}
