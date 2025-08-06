package kotlinx.coroutines;

import kotlin.collections.ArrayDeque;

public abstract class EventLoop extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    public long f56943c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56944d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayDeque<s0<?>> f56945e;

    public static /* synthetic */ void H(EventLoop eventLoop, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            eventLoop.G(z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    public static /* synthetic */ void O(EventLoop eventLoop, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            eventLoop.N(z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void G(boolean z11) {
        long I = this.f56943c - I(z11);
        this.f56943c = I;
        if (I <= 0) {
            if (j0.a()) {
                if (!(this.f56943c == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.f56944d) {
                shutdown();
            }
        }
    }

    public final long I(boolean z11) {
        return z11 ? 4294967296L : 1;
    }

    public final void J(s0<?> s0Var) {
        ArrayDeque<s0<?>> arrayDeque = this.f56945e;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
            this.f56945e = arrayDeque;
        }
        arrayDeque.addLast(s0Var);
    }

    public long K() {
        ArrayDeque<s0<?>> arrayDeque = this.f56945e;
        if (arrayDeque != null && !arrayDeque.isEmpty()) {
            return 0;
        }
        return Long.MAX_VALUE;
    }

    public final void N(boolean z11) {
        this.f56943c += I(z11);
        if (!z11) {
            this.f56944d = true;
        }
    }

    public final boolean P() {
        return this.f56943c >= I(true);
    }

    public final boolean Q() {
        ArrayDeque<s0<?>> arrayDeque = this.f56945e;
        if (arrayDeque != null) {
            return arrayDeque.isEmpty();
        }
        return true;
    }

    public long R() {
        return !S() ? Long.MAX_VALUE : 0;
    }

    public final boolean S() {
        s0 k11;
        ArrayDeque<s0<?>> arrayDeque = this.f56945e;
        if (arrayDeque == null || (k11 = arrayDeque.k()) == null) {
            return false;
        }
        k11.run();
        return true;
    }

    public boolean T() {
        return false;
    }

    public void shutdown() {
    }
}
