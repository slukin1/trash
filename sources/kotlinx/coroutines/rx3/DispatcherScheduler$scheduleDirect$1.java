package kotlinx.coroutines.rx3;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class DispatcherScheduler$scheduleDirect$1 extends Lambda implements l<l<? super c<? super Unit>, ? extends Object>, Runnable> {
    public final /* synthetic */ DispatcherScheduler this$0;

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DispatcherScheduler f57429b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f57430c;

        public a(DispatcherScheduler dispatcherScheduler, l lVar) {
            this.f57429b = dispatcherScheduler;
            this.f57430c = lVar;
        }

        public final void run() {
            n1 unused = i.d(this.f57429b.f57421e, (CoroutineContext) null, (CoroutineStart) null, new DispatcherScheduler$scheduleDirect$1$1$1(this.f57430c, (c<? super DispatcherScheduler$scheduleDirect$1$1$1>) null), 3, (Object) null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DispatcherScheduler$scheduleDirect$1(DispatcherScheduler dispatcherScheduler) {
        super(1);
        this.this$0 = dispatcherScheduler;
    }

    public final Runnable invoke(l<? super c<? super Unit>, ? extends Object> lVar) {
        return new a(this.this$0, lVar);
    }
}
