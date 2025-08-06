package kotlinx.serialization.internal;

import d10.a;
import java.lang.ref.SoftReference;

final class MutableSoftReference<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile SoftReference<T> f57663a = new SoftReference<>((Object) null);

    public final synchronized T a(a<? extends T> aVar) {
        T t11 = this.f57663a.get();
        if (t11 != null) {
            return t11;
        }
        T invoke = aVar.invoke();
        this.f57663a = new SoftReference<>(invoke);
        return invoke;
    }
}
