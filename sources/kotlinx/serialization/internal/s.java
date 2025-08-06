package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.r;
import kotlinx.serialization.b;

public abstract class s<E, C extends Collection<? extends E>, B> extends r<E, C, B> {
    public s(b<E> bVar) {
        super(bVar, (r) null);
    }

    /* renamed from: o */
    public Iterator<E> d(C c11) {
        return c11.iterator();
    }

    /* renamed from: p */
    public int e(C c11) {
        return c11.size();
    }
}
