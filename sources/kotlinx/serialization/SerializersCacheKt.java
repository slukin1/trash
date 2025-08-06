package kotlinx.serialization;

import java.util.List;
import kotlin.reflect.c;
import kotlin.reflect.p;
import kotlinx.serialization.internal.e1;
import kotlinx.serialization.internal.n;
import kotlinx.serialization.internal.r1;

public final class SerializersCacheKt {

    /* renamed from: a  reason: collision with root package name */
    public static final r1<? extends Object> f57602a = n.a(SerializersCacheKt$SERIALIZERS_CACHE$1.INSTANCE);

    /* renamed from: b  reason: collision with root package name */
    public static final r1<Object> f57603b = n.a(SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1.INSTANCE);

    /* renamed from: c  reason: collision with root package name */
    public static final e1<? extends Object> f57604c = n.b(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1.INSTANCE);

    /* renamed from: d  reason: collision with root package name */
    public static final e1<Object> f57605d = n.b(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1.INSTANCE);

    public static final b<Object> a(c<Object> cVar, boolean z11) {
        if (z11) {
            return f57603b.a(cVar);
        }
        b<? extends Object> a11 = f57602a.a(cVar);
        if (a11 != null) {
            return a11;
        }
        return null;
    }

    public static final Object b(c<Object> cVar, List<? extends p> list, boolean z11) {
        if (!z11) {
            return f57604c.a(cVar, list);
        }
        return f57605d.a(cVar, list);
    }
}
