package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.l;
import kotlinx.coroutines.p1;
import z20.c;
import z20.d;

public final class FlowSubscription<T> extends kotlinx.coroutines.a<Unit> implements d {

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57400g;

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57401h;
    private volatile boolean cancellationRequested;

    /* renamed from: e  reason: collision with root package name */
    public final kotlinx.coroutines.flow.d<T> f57402e;

    /* renamed from: f  reason: collision with root package name */
    public final c<? super T> f57403f;
    private volatile Object producer = j1();
    private volatile long requested;

    public static final class a<T> implements e {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FlowSubscription<T> f57404b;

        public a(FlowSubscription<T> flowSubscription) {
            this.f57404b = flowSubscription;
        }

        public final Object emit(T t11, kotlin.coroutines.c<? super Unit> cVar) {
            this.f57404b.f57403f.onNext(t11);
            if (FlowSubscription.f57400g.decrementAndGet(this.f57404b) <= 0) {
                FlowSubscription<T> flowSubscription = this.f57404b;
                l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
                lVar.A();
                FlowSubscription.f57401h.set(flowSubscription, lVar);
                Object v11 = lVar.v();
                if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    f.c(cVar);
                }
                if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return v11;
                }
                return Unit.f56620a;
            }
            p1.i(this.f57404b.getCoroutineContext());
            return Unit.f56620a;
        }
    }

    public static final class b implements kotlin.coroutines.c<Unit> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f57405b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FlowSubscription f57406c;

        public b(CoroutineContext coroutineContext, FlowSubscription flowSubscription) {
            this.f57405b = coroutineContext;
            this.f57406c = flowSubscription;
        }

        public CoroutineContext getContext() {
            return this.f57405b;
        }

        public void resumeWith(Object obj) {
            f10.a.b(new FlowSubscription$createInitialContinuation$1$1(this.f57406c), this.f57406c);
        }
    }

    static {
        Class<FlowSubscription> cls = FlowSubscription.class;
        f57400g = AtomicLongFieldUpdater.newUpdater(cls, "requested");
        f57401h = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "producer");
    }

    public FlowSubscription(kotlinx.coroutines.flow.d<? extends T> dVar, c<? super T> cVar, CoroutineContext coroutineContext) {
        super(coroutineContext, false, true);
        this.f57402e = dVar;
        this.f57403f = cVar;
    }

    public void cancel() {
        this.cancellationRequested = true;
        b((CancellationException) null);
    }

    public final Object i1(kotlin.coroutines.c<? super Unit> cVar) {
        Object collect = this.f57402e.collect(new a(this), cVar);
        return collect == IntrinsicsKt__IntrinsicsKt.d() ? collect : Unit.f56620a;
    }

    public final kotlin.coroutines.c<Unit> j1() {
        return new b(getCoroutineContext(), this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k1(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = (kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1 r0 = new kotlinx.coroutines.reactive.FlowSubscription$flowProcessing$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.reactive.FlowSubscription r0 = (kotlinx.coroutines.reactive.FlowSubscription) r0
            kotlin.k.b(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0046
        L_0x002d:
            r5 = move-exception
            goto L_0x0059
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.k.b(r5)
            r0.L$0 = r4     // Catch:{ all -> 0x0057 }
            r0.label = r3     // Catch:{ all -> 0x0057 }
            java.lang.Object r5 = r4.i1(r0)     // Catch:{ all -> 0x0057 }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r4
        L_0x0046:
            z20.c<? super T> r5 = r0.f57403f     // Catch:{ all -> 0x004c }
            r5.onComplete()     // Catch:{ all -> 0x004c }
            goto L_0x0054
        L_0x004c:
            r5 = move-exception
            kotlin.coroutines.CoroutineContext r0 = r0.getCoroutineContext()
            kotlinx.coroutines.e0.a(r0, r5)
        L_0x0054:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        L_0x0057:
            r5 = move-exception
            r0 = r4
        L_0x0059:
            boolean r1 = kotlinx.coroutines.j0.d()
            if (r1 != 0) goto L_0x0061
            r1 = r5
            goto L_0x0065
        L_0x0061:
            java.lang.Throwable r1 = kotlinx.coroutines.internal.b0.l(r5)
        L_0x0065:
            boolean r2 = r0.cancellationRequested
            if (r2 == 0) goto L_0x0075
            boolean r2 = r0.isActive()
            if (r2 != 0) goto L_0x0075
            java.util.concurrent.CancellationException r2 = r0.A()
            if (r1 == r2) goto L_0x0086
        L_0x0075:
            z20.c<? super T> r1 = r0.f57403f     // Catch:{ all -> 0x007b }
            r1.onError(r5)     // Catch:{ all -> 0x007b }
            goto L_0x0086
        L_0x007b:
            r1 = move-exception
            kotlin.ExceptionsKt__ExceptionsKt.a(r5, r1)
            kotlin.coroutines.CoroutineContext r0 = r0.getCoroutineContext()
            kotlinx.coroutines.e0.a(r0, r5)
        L_0x0086:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.FlowSubscription.k1(kotlin.coroutines.c):java.lang.Object");
    }

    public void request(long j11) {
        long j12;
        long j13;
        kotlin.coroutines.c cVar;
        if (j11 > 0) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f57400g;
            do {
                j12 = atomicLongFieldUpdater.get(this);
                j13 = j12 + j11;
                if (j13 <= 0) {
                    j13 = Long.MAX_VALUE;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j12, j13));
            if (j12 <= 0) {
                do {
                    cVar = (kotlin.coroutines.c) f57401h.getAndSet(this, (Object) null);
                } while (cVar == null);
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
            }
        }
    }
}
