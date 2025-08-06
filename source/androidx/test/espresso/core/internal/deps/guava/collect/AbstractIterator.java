package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: b  reason: collision with root package name */
    public State f11304b = State.NOT_READY;

    /* renamed from: c  reason: collision with root package name */
    public T f11305c;

    /* renamed from: androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11306a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator$State[] r0 = androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11306a = r0
                androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator$State r1 = androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator.State.DONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11306a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator$State r1 = androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator.State.READY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.collect.AbstractIterator.AnonymousClass1.<clinit>():void");
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
        this.f11304b = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f11304b = State.FAILED;
        this.f11305c = a();
        if (this.f11304b == State.DONE) {
            return false;
        }
        this.f11304b = State.READY;
        return true;
    }

    public final boolean hasNext() {
        Preconditions.o(this.f11304b != State.FAILED);
        int i11 = AnonymousClass1.f11306a[this.f11304b.ordinal()];
        if (i11 == 1) {
            return false;
        }
        if (i11 != 2) {
            return c();
        }
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.f11304b = State.NOT_READY;
            T t11 = this.f11305c;
            this.f11305c = null;
            return t11;
        }
        throw new NoSuchElementException();
    }
}
