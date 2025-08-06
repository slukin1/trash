package kotlinx.coroutines.reactive;

import java.util.ServiceLoader;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.v0;
import z20.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final a[] f57414a;

    static {
        Class<a> cls = a.class;
        f57414a = (a[]) SequencesKt___SequencesKt.w(SequencesKt__SequencesKt.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator())).toArray(new a[0]);
    }

    public static final <T> b<T> a(kotlinx.coroutines.flow.d<? extends T> dVar, CoroutineContext coroutineContext) {
        return new b(dVar, v0.d().plus(coroutineContext));
    }

    public static final <T> b<T> b(b<T> bVar, CoroutineContext coroutineContext) {
        for (a a11 : f57414a) {
            bVar = a11.a(bVar, coroutineContext);
        }
        return bVar;
    }
}
