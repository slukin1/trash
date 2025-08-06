package dagger.internal;

import q00.a;

public final class DelegateFactory<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public a<T> f53570a;

    public T get() {
        a<T> aVar = this.f53570a;
        if (aVar != null) {
            return aVar.get();
        }
        throw new IllegalStateException();
    }
}
