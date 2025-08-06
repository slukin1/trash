package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Function;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators {
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it2) {
        Preconditions.i(collection);
        Preconditions.i(it2);
        boolean z11 = false;
        while (it2.hasNext()) {
            z11 |= collection.add(it2.next());
        }
        return z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = androidx.test.espresso.core.internal.deps.guava.base.Objects.a(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.collect.Iterators.b(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static <T> T c(Iterator<? extends T> it2, T t11) {
        return it2.hasNext() ? it2.next() : t11;
    }

    public static <T> UnmodifiableIterator<T> d(final T t11) {
        return new UnmodifiableIterator<T>() {

            /* renamed from: b  reason: collision with root package name */
            public boolean f11322b;

            public boolean hasNext() {
                return !this.f11322b;
            }

            public T next() {
                if (!this.f11322b) {
                    this.f11322b = true;
                    return t11;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static String e(Iterator<?> it2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z11 = true;
        while (it2.hasNext()) {
            if (!z11) {
                sb2.append(", ");
            }
            z11 = false;
            sb2.append(it2.next());
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static <F, T> Iterator<T> f(Iterator<F> it2, final Function<? super F, ? extends T> function) {
        Preconditions.i(function);
        return new TransformedIterator<F, T>(it2) {
            public T a(F f11) {
                return function.apply(f11);
            }
        };
    }
}
