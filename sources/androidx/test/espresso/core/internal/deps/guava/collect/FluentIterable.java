package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Optional;

public abstract class FluentIterable<E> implements Iterable<E> {

    /* renamed from: b  reason: collision with root package name */
    public final Optional<Iterable<E>> f11308b = Optional.absent();

    public final Iterable<E> a() {
        return this.f11308b.or(this);
    }

    public String toString() {
        return Iterables.c(a());
    }
}
