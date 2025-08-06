package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.n0;

public final class RxConvertKt {
    public static final <T> Flowable<T> a(d<? extends T> dVar, CoroutineContext coroutineContext) {
        return Flowable.c(kotlinx.coroutines.reactive.d.a(dVar, coroutineContext));
    }

    public static final <T> Single<T> b(n0<? extends T> n0Var, CoroutineContext coroutineContext) {
        return f.b(coroutineContext, new RxConvertKt$asSingle$1(n0Var, (c<? super RxConvertKt$asSingle$1>) null));
    }
}
