package kotlin.coroutines;

import d10.p;
import kotlin.jvm.internal.x;

public interface CoroutineContext {

    public static final class DefaultImpls {
        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            return coroutineContext2 == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, CoroutineContext$plus$1.INSTANCE);
        }
    }

    public interface a extends CoroutineContext {

        /* renamed from: kotlin.coroutines.CoroutineContext$a$a  reason: collision with other inner class name */
        public static final class C0663a {
            public static <R> R a(a aVar, R r11, p<? super R, ? super a, ? extends R> pVar) {
                return pVar.invoke(r11, aVar);
            }

            public static <E extends a> E b(a aVar, b<E> bVar) {
                if (x.b(aVar.getKey(), bVar)) {
                    return aVar;
                }
                return null;
            }

            public static CoroutineContext c(a aVar, b<?> bVar) {
                return x.b(aVar.getKey(), bVar) ? EmptyCoroutineContext.INSTANCE : aVar;
            }

            public static CoroutineContext d(a aVar, CoroutineContext coroutineContext) {
                return DefaultImpls.a(aVar, coroutineContext);
            }
        }

        <E extends a> E get(b<E> bVar);

        b<?> getKey();
    }

    public interface b<E extends a> {
    }

    <R> R fold(R r11, p<? super R, ? super a, ? extends R> pVar);

    <E extends a> E get(b<E> bVar);

    CoroutineContext minusKey(b<?> bVar);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
