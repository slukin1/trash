package androidx.lifecycle;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;

final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2 extends Lambda implements l<Throwable, Unit> {
    public final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher;
    public final /* synthetic */ t0 $observer;
    public final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked;

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Lifecycle f9974b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t0 f9975c;

        public a(Lifecycle lifecycle, t0 t0Var) {
            this.f9974b = lifecycle;
        }

        public final void run() {
            this.f9974b.d(this.f9975c);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(CoroutineDispatcher coroutineDispatcher, Lifecycle lifecycle, t0 t0Var) {
        super(1);
        this.$lifecycleDispatcher = coroutineDispatcher;
        this.$this_suspendWithStateAtLeastUnchecked = lifecycle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2) {
        CoroutineDispatcher coroutineDispatcher = this.$lifecycleDispatcher;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher.B(emptyCoroutineContext)) {
            this.$lifecycleDispatcher.w(emptyCoroutineContext, new a(this.$this_suspendWithStateAtLeastUnchecked, this.$observer));
        } else {
            this.$this_suspendWithStateAtLeastUnchecked.d(this.$observer);
        }
    }
}
