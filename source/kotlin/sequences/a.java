package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<g<T>> f56869a;

    public a(g<? extends T> gVar) {
        this.f56869a = new AtomicReference<>(gVar);
    }

    public Iterator<T> iterator() {
        g andSet = this.f56869a.getAndSet((Object) null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
