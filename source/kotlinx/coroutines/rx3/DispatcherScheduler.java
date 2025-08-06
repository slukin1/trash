package kotlinx.coroutines.rx3;

import d10.l;
import d10.p;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.f;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.w;

public final class DispatcherScheduler extends Scheduler {

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57418f = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter");

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineDispatcher f57419c;

    /* renamed from: d  reason: collision with root package name */
    public final w f57420d;

    /* renamed from: e  reason: collision with root package name */
    public final h0 f57421e;
    private volatile long workerCounter;

    public static final class DispatcherWorker extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final long f57422b;

        /* renamed from: c  reason: collision with root package name */
        public final CoroutineDispatcher f57423c;

        /* renamed from: d  reason: collision with root package name */
        public final w f57424d;

        /* renamed from: e  reason: collision with root package name */
        public final h0 f57425e;

        /* renamed from: f  reason: collision with root package name */
        public final d<l<c<? super Unit>, Object>> f57426f = f.b(Integer.MAX_VALUE, (BufferOverflow) null, (l) null, 6, (Object) null);

        public DispatcherWorker(long j11, CoroutineDispatcher coroutineDispatcher, n1 n1Var) {
            this.f57422b = j11;
            this.f57423c = coroutineDispatcher;
            w a11 = e2.a(n1Var);
            this.f57424d = a11;
            h0 a12 = i0.a(a11.plus(coroutineDispatcher));
            this.f57425e = a12;
            n1 unused = i.d(a12, (CoroutineContext) null, (CoroutineStart) null, new p<h0, c<? super Unit>, Object>(this, (c<? super AnonymousClass1>) null) {
                public Object L$0;
                public Object L$1;
                public int label;
                public final /* synthetic */ DispatcherWorker this$0;

                {
                    this.this$0 = r1;
                }

                public final c<Unit> create(Object obj, c<?> cVar) {
                    return 

                    public Scheduler.Worker a() {
                        return new DispatcherWorker(f57418f.getAndIncrement(this), this.f57419c, this.f57420d);
                    }

                    public b d(Runnable runnable, long j11, TimeUnit timeUnit) {
                        return RxSchedulerKt.e(this.f57421e, runnable, timeUnit.toMillis(j11), new DispatcherScheduler$scheduleDirect$1(this));
                    }

                    public String toString() {
                        return this.f57419c.toString();
                    }
                }
