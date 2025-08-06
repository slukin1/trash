package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.j0;

public abstract class AtomicOp<T> extends OpDescriptor {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57281a = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    private volatile Object _consensus = a.f57295a;

    public final Object a(Object obj) {
        Object obj2 = f57281a.get(this);
        if (obj2 == a.f57295a) {
            obj2 = c(d(obj));
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(T t11, Object obj);

    public final Object c(Object obj) {
        if (j0.a()) {
            if (!(obj != a.f57295a)) {
                throw new AssertionError();
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57281a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = a.f57295a;
        if (obj2 != obj3) {
            return obj2;
        }
        if (a.a(atomicReferenceFieldUpdater, this, obj3, obj)) {
            return obj;
        }
        return atomicReferenceFieldUpdater.get(this);
    }

    public abstract Object d(T t11);
}
