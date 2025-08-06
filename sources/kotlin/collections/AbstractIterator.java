package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> implements Iterator<T>, e10.a {

    /* renamed from: b  reason: collision with root package name */
    public State f56623b = State.NotReady;

    /* renamed from: c  reason: collision with root package name */
    public T f56624c;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56625a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                kotlin.collections.State[] r0 = kotlin.collections.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.collections.State r1 = kotlin.collections.State.Done     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.collections.State r1 = kotlin.collections.State.Ready     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f56625a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.AbstractIterator.a.<clinit>():void");
        }
    }

    public abstract void a();

    public final void b() {
        this.f56623b = State.Done;
    }

    public final void c(T t11) {
        this.f56624c = t11;
        this.f56623b = State.Ready;
    }

    public final boolean d() {
        this.f56623b = State.Failed;
        a();
        return this.f56623b == State.Ready;
    }

    public boolean hasNext() {
        State state = this.f56623b;
        if (state != State.Failed) {
            int i11 = a.f56625a[state.ordinal()];
            if (i11 == 1) {
                return false;
            }
            if (i11 != 2) {
                return d();
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public T next() {
        if (hasNext()) {
            this.f56623b = State.NotReady;
            return this.f56624c;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
