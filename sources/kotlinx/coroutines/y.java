package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.r;

public class y {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57582b = AtomicIntegerFieldUpdater.newUpdater(y.class, "_handled");
    private volatile int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f57583a;

    public y(Throwable th2, boolean z11) {
        this.f57583a = th2;
        this._handled = z11 ? 1 : 0;
    }

    public final boolean a() {
        return f57582b.get(this) != 0;
    }

    public final boolean b() {
        return f57582b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return k0.a(this) + '[' + this.f57583a + ']';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(Throwable th2, boolean z11, int i11, r rVar) {
        this(th2, (i11 & 2) != 0 ? false : z11);
    }
}
