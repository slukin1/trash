package kotlinx.coroutines.reactive;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.d;
import z20.c;

public final class b<T> implements z20.b<T> {

    /* renamed from: b  reason: collision with root package name */
    public final d<T> f57412b;

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineContext f57413c;

    public b(d<? extends T> dVar, CoroutineContext coroutineContext) {
        this.f57412b = dVar;
        this.f57413c = coroutineContext;
    }

    public void subscribe(c<? super T> cVar) {
        Objects.requireNonNull(cVar);
        cVar.onSubscribe(new FlowSubscription(this.f57412b, cVar, this.f57413c));
    }
}
