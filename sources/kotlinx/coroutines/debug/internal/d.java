package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class d<T> extends WeakReference<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f57113a;

    public d(T t11, ReferenceQueue<T> referenceQueue) {
        super(t11, referenceQueue);
        this.f57113a = t11 != null ? t11.hashCode() : 0;
    }
}
