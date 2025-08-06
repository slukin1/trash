package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: b  reason: collision with root package name */
    public State f11146b = State.NOT_READY;

    /* renamed from: c  reason: collision with root package name */
    public T f11147c;

    /* renamed from: androidx.test.espresso.core.internal.deps.guava.base.AbstractIterator$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11148a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.test.espresso.core.internal.deps.guava.base.AbstractIterator$State[] r0 = androidx.test.espresso.core.internal.deps.guava.base.AbstractIterator.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11148a = r0
                androidx.test.espresso.core.internal.deps.guava.base.AbstractIterator$State r1 = androidx.test.espresso.core.internal.deps.guava.base.AbstractIterator.State.READY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11148a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.test.espresso.core.internal.deps.guava.base.AbstractIterator$State r1 = androidx.test.espresso.core.internal.deps.guava.base.AbstractIterator.State.DONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.base.AbstractIterator.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract T a();

    public final T b() {
        this.f11146b = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f11146b = State.FAILED;
        this.f11147c = a();
        if (this.f11146b == State.DONE) {
            return false;
        }
        this.f11146b = State.READY;
        return true;
    }

    public final boolean hasNext() {
        Preconditions.o(this.f11146b != State.FAILED);
        int i11 = AnonymousClass1.f11148a[this.f11146b.ordinal()];
        if (i11 == 1) {
            return true;
        }
        if (i11 != 2) {
            return c();
        }
        return false;
    }

    public final T next() {
        if (hasNext()) {
            this.f11146b = State.NOT_READY;
            T t11 = this.f11147c;
            this.f11147c = null;
            return t11;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
