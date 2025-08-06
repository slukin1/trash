package kotlinx.coroutines.flow;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.h;
import kotlinx.coroutines.flow.internal.k;

public final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements b1<T>, d, h<T> {

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57207g = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    private volatile Object _state;

    /* renamed from: f  reason: collision with root package name */
    public int f57208f;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    public List<T> a() {
        return CollectionsKt__CollectionsJVMKt.e(getValue());
    }

    public void b() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    public d<T> c(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return k1.d(this, coroutineContext, i11, bufferOverflow);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlinx.coroutines.flow.StateFlowSlot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: kotlinx.coroutines.flow.StateFlowImpl} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00bd A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bf A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2 A[Catch:{ all -> 0x0073 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d3 A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00da A[Catch:{ all -> 0x0073 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(kotlinx.coroutines.flow.e<? super T> r11, kotlin.coroutines.c<?> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.StateFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0076
            if (r2 == r6) goto L_0x0061
            if (r2 == r5) goto L_0x004a
            if (r2 != r4) goto L_0x0042
            java.lang.Object r11 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.n1 r2 = (kotlinx.coroutines.n1) r2
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.e r7 = (kotlinx.coroutines.flow.e) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.k.b(r12)     // Catch:{ all -> 0x0073 }
            goto L_0x00a6
        L_0x0042:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004a:
            java.lang.Object r11 = r0.L$4
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.n1 r2 = (kotlinx.coroutines.n1) r2
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.flow.e r7 = (kotlinx.coroutines.flow.e) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.k.b(r12)     // Catch:{ all -> 0x0073 }
            goto L_0x00d4
        L_0x0061:
            java.lang.Object r11 = r0.L$2
            r6 = r11
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.flow.e r11 = (kotlinx.coroutines.flow.e) r11
            java.lang.Object r2 = r0.L$0
            r8 = r2
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.k.b(r12)     // Catch:{ all -> 0x0073 }
            goto L_0x0097
        L_0x0073:
            r11 = move-exception
            goto L_0x00f0
        L_0x0076:
            kotlin.k.b(r12)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r12 = r10.h()
            kotlinx.coroutines.flow.StateFlowSlot r12 = (kotlinx.coroutines.flow.StateFlowSlot) r12
            boolean r2 = r11 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x00ed }
            if (r2 == 0) goto L_0x0095
            r2 = r11
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x00ed }
            r0.L$0 = r10     // Catch:{ all -> 0x00ed }
            r0.L$1 = r11     // Catch:{ all -> 0x00ed }
            r0.L$2 = r12     // Catch:{ all -> 0x00ed }
            r0.label = r6     // Catch:{ all -> 0x00ed }
            java.lang.Object r2 = r2.a(r0)     // Catch:{ all -> 0x00ed }
            if (r2 != r1) goto L_0x0095
            return r1
        L_0x0095:
            r8 = r10
            r6 = r12
        L_0x0097:
            kotlin.coroutines.CoroutineContext r12 = r0.getContext()     // Catch:{ all -> 0x0073 }
            kotlinx.coroutines.n1$b r2 = kotlinx.coroutines.n1.f57382r0     // Catch:{ all -> 0x0073 }
            kotlin.coroutines.CoroutineContext$a r12 = r12.get(r2)     // Catch:{ all -> 0x0073 }
            kotlinx.coroutines.n1 r12 = (kotlinx.coroutines.n1) r12     // Catch:{ all -> 0x0073 }
            r7 = r11
            r2 = r12
            r11 = r3
        L_0x00a6:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = f57207g     // Catch:{ all -> 0x0073 }
            java.lang.Object r12 = r12.get(r8)     // Catch:{ all -> 0x0073 }
            if (r2 == 0) goto L_0x00b1
            kotlinx.coroutines.p1.j(r2)     // Catch:{ all -> 0x0073 }
        L_0x00b1:
            if (r11 == 0) goto L_0x00b9
            boolean r9 = kotlin.jvm.internal.x.b(r11, r12)     // Catch:{ all -> 0x0073 }
            if (r9 != 0) goto L_0x00d4
        L_0x00b9:
            kotlinx.coroutines.internal.c0 r11 = kotlinx.coroutines.flow.internal.k.f57265a     // Catch:{ all -> 0x0073 }
            if (r12 != r11) goto L_0x00bf
            r11 = r3
            goto L_0x00c0
        L_0x00bf:
            r11 = r12
        L_0x00c0:
            r0.L$0 = r8     // Catch:{ all -> 0x0073 }
            r0.L$1 = r7     // Catch:{ all -> 0x0073 }
            r0.L$2 = r6     // Catch:{ all -> 0x0073 }
            r0.L$3 = r2     // Catch:{ all -> 0x0073 }
            r0.L$4 = r12     // Catch:{ all -> 0x0073 }
            r0.label = r5     // Catch:{ all -> 0x0073 }
            java.lang.Object r11 = r7.emit(r11, r0)     // Catch:{ all -> 0x0073 }
            if (r11 != r1) goto L_0x00d3
            return r1
        L_0x00d3:
            r11 = r12
        L_0x00d4:
            boolean r12 = r6.h()     // Catch:{ all -> 0x0073 }
            if (r12 != 0) goto L_0x00a6
            r0.L$0 = r8     // Catch:{ all -> 0x0073 }
            r0.L$1 = r7     // Catch:{ all -> 0x0073 }
            r0.L$2 = r6     // Catch:{ all -> 0x0073 }
            r0.L$3 = r2     // Catch:{ all -> 0x0073 }
            r0.L$4 = r11     // Catch:{ all -> 0x0073 }
            r0.label = r4     // Catch:{ all -> 0x0073 }
            java.lang.Object r12 = r6.e(r0)     // Catch:{ all -> 0x0073 }
            if (r12 != r1) goto L_0x00a6
            return r1
        L_0x00ed:
            r11 = move-exception
            r8 = r10
            r6 = r12
        L_0x00f0:
            r8.k(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.e, kotlin.coroutines.c):java.lang.Object");
    }

    public boolean d(T t11) {
        setValue(t11);
        return true;
    }

    public Object emit(T t11, c<? super Unit> cVar) {
        setValue(t11);
        return Unit.f56620a;
    }

    public T getValue() {
        T t11 = k.f57265a;
        T t12 = f57207g.get(this);
        if (t12 == t11) {
            return null;
        }
        return t12;
    }

    /* renamed from: n */
    public StateFlowSlot i() {
        return new StateFlowSlot();
    }

    /* renamed from: o */
    public StateFlowSlot[] j(int i11) {
        return new StateFlowSlot[i11];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        if (r8 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0032, code lost:
        r0 = r8.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0034, code lost:
        if (r3 >= r0) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        r4 = r8[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        if (r4 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        r4.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r8 = r6.f57208f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0043, code lost:
        if (r8 != r7) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0045, code lost:
        r6.f57208f = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0048, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0049, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r7 = m();
        r0 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0051, code lost:
        r5 = r8;
        r8 = r7;
        r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f57207g     // Catch:{ all -> 0x005e }
            java.lang.Object r1 = r0.get(r6)     // Catch:{ all -> 0x005e }
            r2 = 0
            if (r7 == 0) goto L_0x0012
            boolean r7 = kotlin.jvm.internal.x.b(r1, r7)     // Catch:{ all -> 0x005e }
            if (r7 != 0) goto L_0x0012
            monitor-exit(r6)
            return r2
        L_0x0012:
            boolean r7 = kotlin.jvm.internal.x.b(r1, r8)     // Catch:{ all -> 0x005e }
            r1 = 1
            if (r7 == 0) goto L_0x001b
            monitor-exit(r6)
            return r1
        L_0x001b:
            r0.set(r6, r8)     // Catch:{ all -> 0x005e }
            int r7 = r6.f57208f     // Catch:{ all -> 0x005e }
            r8 = r7 & 1
            if (r8 != 0) goto L_0x0058
            int r7 = r7 + r1
            r6.f57208f = r7     // Catch:{ all -> 0x005e }
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r8 = r6.m()     // Catch:{ all -> 0x005e }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x005e }
            monitor-exit(r6)
        L_0x002e:
            kotlinx.coroutines.flow.StateFlowSlot[] r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8
            if (r8 == 0) goto L_0x0040
            int r0 = r8.length
            r3 = r2
        L_0x0034:
            if (r3 >= r0) goto L_0x0040
            r4 = r8[r3]
            if (r4 == 0) goto L_0x003d
            r4.g()
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x0034
        L_0x0040:
            monitor-enter(r6)
            int r8 = r6.f57208f     // Catch:{ all -> 0x0055 }
            if (r8 != r7) goto L_0x004a
            int r7 = r7 + r1
            r6.f57208f = r7     // Catch:{ all -> 0x0055 }
            monitor-exit(r6)
            return r1
        L_0x004a:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r7 = r6.m()     // Catch:{ all -> 0x0055 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0055 }
            monitor-exit(r6)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x002e
        L_0x0055:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L_0x0058:
            int r7 = r7 + 2
            r6.f57208f = r7     // Catch:{ all -> 0x005e }
            monitor-exit(r6)
            return r1
        L_0x005e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.p(java.lang.Object, java.lang.Object):boolean");
    }

    public void setValue(T t11) {
        if (t11 == null) {
            t11 = k.f57265a;
        }
        p((Object) null, t11);
    }
}
