package kotlinx.coroutines.rx3;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.rx3.DispatcherScheduler;

public final class DispatcherScheduler$DispatcherWorker$schedule$1 extends Lambda implements l<l<? super c<? super Unit>, ? extends Object>, Runnable> {
    public final /* synthetic */ DispatcherScheduler.DispatcherWorker this$0;

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DispatcherScheduler.DispatcherWorker f57427b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f57428c;

        public a(DispatcherScheduler.DispatcherWorker dispatcherWorker, l lVar) {
            this.f57427b = dispatcherWorker;
            this.f57428c = lVar;
        }

        public final void run() {
            this.f57427b.f57426f.q(this.f57428c);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DispatcherScheduler$DispatcherWorker$schedule$1(DispatcherScheduler.DispatcherWorker dispatcherWorker) {
        super(1);
        this.this$0 = dispatcherWorker;
    }

    public final Runnable invoke(l<? super c<? super Unit>, ? extends Object> lVar) {
        return new a(this.this$0, lVar);
    }
}
