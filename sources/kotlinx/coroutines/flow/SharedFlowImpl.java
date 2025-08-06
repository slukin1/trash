package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.h;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n;
import kotlinx.coroutines.x0;

public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements a1<T>, d, h<T> {

    /* renamed from: f  reason: collision with root package name */
    public final int f57188f;

    /* renamed from: g  reason: collision with root package name */
    public final int f57189g;

    /* renamed from: h  reason: collision with root package name */
    public final BufferOverflow f57190h;

    /* renamed from: i  reason: collision with root package name */
    public Object[] f57191i;

    /* renamed from: j  reason: collision with root package name */
    public long f57192j;

    /* renamed from: k  reason: collision with root package name */
    public long f57193k;

    /* renamed from: l  reason: collision with root package name */
    public int f57194l;

    /* renamed from: m  reason: collision with root package name */
    public int f57195m;

    public static final class a implements x0 {

        /* renamed from: b  reason: collision with root package name */
        public final SharedFlowImpl<?> f57196b;

        /* renamed from: c  reason: collision with root package name */
        public long f57197c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f57198d;

        /* renamed from: e  reason: collision with root package name */
        public final c<Unit> f57199e;

        public a(SharedFlowImpl<?> sharedFlowImpl, long j11, Object obj, c<? super Unit> cVar) {
            this.f57196b = sharedFlowImpl;
            this.f57197c = j11;
            this.f57198d = obj;
            this.f57199e = cVar;
        }

        public void dispose() {
            this.f57196b.y(this);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57200a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlinx.coroutines.channels.BufferOverflow[] r0 = kotlinx.coroutines.channels.BufferOverflow.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_LATEST     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f57200a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.b.<clinit>():void");
        }
    }

    public SharedFlowImpl(int i11, int i12, BufferOverflow bufferOverflow) {
        this.f57188f = i11;
        this.f57189g = i12;
        this.f57190h = bufferOverflow;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: kotlinx.coroutines.flow.SharedFlowSlot} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A[Catch:{ all -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ <T> java.lang.Object A(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, kotlinx.coroutines.flow.e<? super T> r9, kotlin.coroutines.c<?> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0075
            if (r2 == r5) goto L_0x005e
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.n1 r8 = (kotlinx.coroutines.n1) r8
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
            goto L_0x0054
        L_0x003c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0044:
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.n1 r8 = (kotlinx.coroutines.n1) r8
            java.lang.Object r9 = r0.L$2
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.e r2 = (kotlinx.coroutines.flow.e) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
        L_0x0054:
            kotlin.k.b(r10)     // Catch:{ all -> 0x005b }
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x00a3
        L_0x005b:
            r8 = move-exception
            goto L_0x00da
        L_0x005e:
            java.lang.Object r8 = r0.L$2
            r9 = r8
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.e r8 = (kotlinx.coroutines.flow.e) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.SharedFlowImpl r2 = (kotlinx.coroutines.flow.SharedFlowImpl) r2
            kotlin.k.b(r10)     // Catch:{ all -> 0x0071 }
            r10 = r8
            r8 = r2
            goto L_0x0097
        L_0x0071:
            r8 = move-exception
            r5 = r2
            goto L_0x00da
        L_0x0075:
            kotlin.k.b(r10)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r10 = r8.h()
            kotlinx.coroutines.flow.SharedFlowSlot r10 = (kotlinx.coroutines.flow.SharedFlowSlot) r10
            boolean r2 = r9 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x00d6 }
            if (r2 == 0) goto L_0x0094
            r2 = r9
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x00d6 }
            r0.L$0 = r8     // Catch:{ all -> 0x00d6 }
            r0.L$1 = r9     // Catch:{ all -> 0x00d6 }
            r0.L$2 = r10     // Catch:{ all -> 0x00d6 }
            r0.label = r5     // Catch:{ all -> 0x00d6 }
            java.lang.Object r2 = r2.a(r0)     // Catch:{ all -> 0x00d6 }
            if (r2 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0097:
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()     // Catch:{ all -> 0x00d2 }
            kotlinx.coroutines.n1$b r5 = kotlinx.coroutines.n1.f57382r0     // Catch:{ all -> 0x00d2 }
            kotlin.coroutines.CoroutineContext$a r2 = r2.get(r5)     // Catch:{ all -> 0x00d2 }
            kotlinx.coroutines.n1 r2 = (kotlinx.coroutines.n1) r2     // Catch:{ all -> 0x00d2 }
        L_0x00a3:
            java.lang.Object r5 = r8.U(r9)     // Catch:{ all -> 0x00d2 }
            kotlinx.coroutines.internal.c0 r6 = kotlinx.coroutines.flow.g1.f57223a     // Catch:{ all -> 0x00d2 }
            if (r5 != r6) goto L_0x00bc
            r0.L$0 = r8     // Catch:{ all -> 0x00d2 }
            r0.L$1 = r10     // Catch:{ all -> 0x00d2 }
            r0.L$2 = r9     // Catch:{ all -> 0x00d2 }
            r0.L$3 = r2     // Catch:{ all -> 0x00d2 }
            r0.label = r4     // Catch:{ all -> 0x00d2 }
            java.lang.Object r5 = r8.x(r9, r0)     // Catch:{ all -> 0x00d2 }
            if (r5 != r1) goto L_0x00a3
            return r1
        L_0x00bc:
            if (r2 == 0) goto L_0x00c1
            kotlinx.coroutines.p1.j(r2)     // Catch:{ all -> 0x00d2 }
        L_0x00c1:
            r0.L$0 = r8     // Catch:{ all -> 0x00d2 }
            r0.L$1 = r10     // Catch:{ all -> 0x00d2 }
            r0.L$2 = r9     // Catch:{ all -> 0x00d2 }
            r0.L$3 = r2     // Catch:{ all -> 0x00d2 }
            r0.label = r3     // Catch:{ all -> 0x00d2 }
            java.lang.Object r5 = r10.emit(r5, r0)     // Catch:{ all -> 0x00d2 }
            if (r5 != r1) goto L_0x00a3
            return r1
        L_0x00d2:
            r10 = move-exception
            r5 = r8
            r8 = r10
            goto L_0x00da
        L_0x00d6:
            r9 = move-exception
            r5 = r8
            r8 = r9
            r9 = r10
        L_0x00da:
            r5.k(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.A(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.e, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ <T> Object F(SharedFlowImpl<T> sharedFlowImpl, T t11, c<? super Unit> cVar) {
        if (sharedFlowImpl.d(t11)) {
            return Unit.f56620a;
        }
        Object G = sharedFlowImpl.G(t11, cVar);
        return G == IntrinsicsKt__IntrinsicsKt.d() ? G : Unit.f56620a;
    }

    public final void B(long j11) {
        AbstractSharedFlowSlot[] g11;
        if (!(this.f57233c == 0 || (g11 = this.f57232b) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : g11) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j12 = sharedFlowSlot.f57201a;
                    if (j12 >= 0 && j12 < j11) {
                        sharedFlowSlot.f57201a = j11;
                    }
                }
            }
        }
        this.f57193k = j11;
    }

    /* renamed from: C */
    public SharedFlowSlot i() {
        return new SharedFlowSlot();
    }

    /* renamed from: D */
    public SharedFlowSlot[] j(int i11) {
        return new SharedFlowSlot[i11];
    }

    public final void E() {
        g1.g(this.f57191i, K(), (Object) null);
        this.f57194l--;
        long K = K() + 1;
        if (this.f57192j < K) {
            this.f57192j = K;
        }
        if (this.f57193k < K) {
            B(K);
        }
        if (j0.a()) {
            if (!(K() == K)) {
                throw new AssertionError();
            }
        }
    }

    public final Object G(T t11, c<? super Unit> cVar) {
        c<Unit>[] cVarArr;
        a aVar;
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        c<Unit>[] cVarArr2 = kotlinx.coroutines.flow.internal.a.f57259a;
        synchronized (this) {
            if (R(t11)) {
                Result.a aVar2 = Result.Companion;
                lVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
                cVarArr = I(cVarArr2);
                aVar = null;
            } else {
                a aVar3 = new a(this, ((long) P()) + K(), t11, lVar);
                H(aVar3);
                this.f57195m = this.f57195m + 1;
                if (this.f57189g == 0) {
                    cVarArr2 = I(cVarArr2);
                }
                cVarArr = cVarArr2;
                aVar = aVar3;
            }
        }
        if (aVar != null) {
            n.a(lVar, aVar);
        }
        for (c<Unit> cVar2 : cVarArr) {
            if (cVar2 != null) {
                Result.a aVar4 = Result.Companion;
                cVar2.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
            }
        }
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            return v11;
        }
        return Unit.f56620a;
    }

    public final void H(Object obj) {
        int P = P();
        Object[] objArr = this.f57191i;
        if (objArr == null) {
            objArr = Q((Object[]) null, 0, 2);
        } else if (P >= objArr.length) {
            objArr = Q(objArr, P, objArr.length * 2);
        }
        g1.g(objArr, K() + ((long) P), obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: kotlin.coroutines.c<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: kotlin.coroutines.c<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: kotlin.coroutines.c<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: kotlin.coroutines.c<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: kotlin.coroutines.c<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: kotlin.coroutines.c<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: kotlin.coroutines.c<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: kotlin.coroutines.c<kotlin.Unit>[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: kotlin.coroutines.c<kotlin.Unit>[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        r11 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.coroutines.c<kotlin.Unit>[], code=java.lang.Object[], for r11v0, types: [kotlin.coroutines.c<kotlin.Unit>[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.c<kotlin.Unit>[] I(java.lang.Object[] r11) {
        /*
            r10 = this;
            int r0 = r11.length
            int r1 = r10.f57233c
            if (r1 == 0) goto L_0x0042
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r1 = r10.f57232b
            if (r1 == 0) goto L_0x0042
            r2 = 0
            int r3 = r1.length
        L_0x000f:
            if (r2 >= r3) goto L_0x0042
            r4 = r1[r2]
            if (r4 == 0) goto L_0x003f
            kotlinx.coroutines.flow.SharedFlowSlot r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4
            kotlin.coroutines.c<? super kotlin.Unit> r5 = r4.f57202b
            if (r5 != 0) goto L_0x001c
            goto L_0x003f
        L_0x001c:
            long r6 = r10.T(r4)
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x003f
            int r6 = r11.length
            if (r0 < r6) goto L_0x0034
            int r6 = r11.length
            r7 = 2
            int r6 = r6 * r7
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r6)
        L_0x0034:
            r6 = r11
            kotlin.coroutines.c[] r6 = (kotlin.coroutines.c[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f57202b = r0
            r0 = r7
        L_0x003f:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0042:
            kotlin.coroutines.c[] r11 = (kotlin.coroutines.c[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.I(kotlin.coroutines.c[]):kotlin.coroutines.c[]");
    }

    public final long J() {
        return K() + ((long) this.f57194l);
    }

    public final long K() {
        return Math.min(this.f57193k, this.f57192j);
    }

    public final T L() {
        return g1.f(this.f57191i, (this.f57192j + ((long) O())) - 1);
    }

    public final Object M(long j11) {
        Object c11 = g1.f(this.f57191i, j11);
        return c11 instanceof a ? ((a) c11).f57198d : c11;
    }

    public final long N() {
        return K() + ((long) this.f57194l) + ((long) this.f57195m);
    }

    public final int O() {
        return (int) ((K() + ((long) this.f57194l)) - this.f57192j);
    }

    public final int P() {
        return this.f57194l + this.f57195m;
    }

    public final Object[] Q(Object[] objArr, int i11, int i12) {
        if (i12 > 0) {
            Object[] objArr2 = new Object[i12];
            this.f57191i = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long K = K();
            for (int i13 = 0; i13 < i11; i13++) {
                long j11 = ((long) i13) + K;
                g1.g(objArr2, j11, g1.f(objArr, j11));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    public final boolean R(T t11) {
        if (l() == 0) {
            return S(t11);
        }
        if (this.f57194l >= this.f57189g && this.f57193k <= this.f57192j) {
            int i11 = b.f57200a[this.f57190h.ordinal()];
            if (i11 == 1) {
                return false;
            }
            if (i11 == 2) {
                return true;
            }
        }
        H(t11);
        int i12 = this.f57194l + 1;
        this.f57194l = i12;
        if (i12 > this.f57189g) {
            E();
        }
        if (O() > this.f57188f) {
            V(this.f57192j + 1, this.f57193k, J(), N());
        }
        return true;
    }

    public final boolean S(T t11) {
        if (j0.a()) {
            if (!(l() == 0)) {
                throw new AssertionError();
            }
        }
        if (this.f57188f == 0) {
            return true;
        }
        H(t11);
        int i11 = this.f57194l + 1;
        this.f57194l = i11;
        if (i11 > this.f57188f) {
            E();
        }
        this.f57193k = K() + ((long) this.f57194l);
        return true;
    }

    public final long T(SharedFlowSlot sharedFlowSlot) {
        long j11 = sharedFlowSlot.f57201a;
        if (j11 < J()) {
            return j11;
        }
        if (this.f57189g <= 0 && j11 <= K() && this.f57195m != 0) {
            return j11;
        }
        return -1;
    }

    public final Object U(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        c<Unit>[] cVarArr = kotlinx.coroutines.flow.internal.a.f57259a;
        synchronized (this) {
            long T = T(sharedFlowSlot);
            if (T < 0) {
                obj = g1.f57223a;
            } else {
                long j11 = sharedFlowSlot.f57201a;
                Object M = M(T);
                sharedFlowSlot.f57201a = T + 1;
                Object obj2 = M;
                cVarArr = W(j11);
                obj = obj2;
            }
        }
        for (c<Unit> cVar : cVarArr) {
            if (cVar != null) {
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
            }
        }
        return obj;
    }

    public final void V(long j11, long j12, long j13, long j14) {
        long j15 = j11;
        long j16 = j12;
        long min = Math.min(j16, j15);
        boolean z11 = true;
        if (j0.a()) {
            if (!(min >= K())) {
                throw new AssertionError();
            }
        }
        for (long K = K(); K < min; K++) {
            g1.g(this.f57191i, K, (Object) null);
        }
        this.f57192j = j15;
        this.f57193k = j16;
        this.f57194l = (int) (j13 - min);
        this.f57195m = (int) (j14 - j13);
        if (j0.a()) {
            if (!(this.f57194l >= 0)) {
                throw new AssertionError();
            }
        }
        if (j0.a()) {
            if (!(this.f57195m >= 0)) {
                throw new AssertionError();
            }
        }
        if (j0.a()) {
            if (this.f57192j > K() + ((long) this.f57194l)) {
                z11 = false;
            }
            if (!z11) {
                throw new AssertionError();
            }
        }
    }

    public final c<Unit>[] W(long j11) {
        int i11;
        long j12;
        long j13;
        AbstractSharedFlowSlot[] g11;
        if (j0.a()) {
            if (!(j11 >= this.f57193k)) {
                throw new AssertionError();
            }
        }
        if (j11 > this.f57193k) {
            return kotlinx.coroutines.flow.internal.a.f57259a;
        }
        long K = K();
        long j14 = ((long) this.f57194l) + K;
        if (this.f57189g == 0 && this.f57195m > 0) {
            j14++;
        }
        if (!(this.f57233c == 0 || (g11 = this.f57232b) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : g11) {
                if (abstractSharedFlowSlot != null) {
                    long j15 = ((SharedFlowSlot) abstractSharedFlowSlot).f57201a;
                    if (j15 >= 0 && j15 < j14) {
                        j14 = j15;
                    }
                }
            }
        }
        if (j0.a()) {
            if (!(j14 >= this.f57193k)) {
                throw new AssertionError();
            }
        }
        if (j14 <= this.f57193k) {
            return kotlinx.coroutines.flow.internal.a.f57259a;
        }
        long J = J();
        if (l() > 0) {
            i11 = Math.min(this.f57195m, this.f57189g - ((int) (J - j14)));
        } else {
            i11 = this.f57195m;
        }
        c<Unit>[] cVarArr = kotlinx.coroutines.flow.internal.a.f57259a;
        long j16 = ((long) this.f57195m) + J;
        if (i11 > 0) {
            cVarArr = new c[i11];
            Object[] objArr = this.f57191i;
            long j17 = J;
            int i12 = 0;
            while (true) {
                if (J >= j16) {
                    j12 = j14;
                    break;
                }
                Object c11 = g1.f(objArr, J);
                c0 c0Var = g1.f57223a;
                if (c11 != c0Var) {
                    a aVar = (a) c11;
                    j12 = j14;
                    int i13 = i12 + 1;
                    cVarArr[i12] = aVar.f57199e;
                    g1.g(objArr, J, c0Var);
                    g1.g(objArr, j17, aVar.f57198d);
                    j13 = 1;
                    j17++;
                    if (i13 >= i11) {
                        break;
                    }
                    i12 = i13;
                } else {
                    j12 = j14;
                    j13 = 1;
                }
                J += j13;
                j14 = j12;
            }
            J = j17;
        } else {
            j12 = j14;
        }
        int i14 = (int) (J - K);
        long j18 = l() == 0 ? J : j12;
        long max = Math.max(this.f57192j, J - ((long) Math.min(this.f57188f, i14)));
        if (this.f57189g == 0 && max < j16 && x.b(g1.f(this.f57191i, max), g1.f57223a)) {
            J++;
            max++;
        }
        V(max, j18, J, j16);
        z();
        return true ^ (cVarArr.length == 0) ? I(cVarArr) : cVarArr;
    }

    public final long X() {
        long j11 = this.f57192j;
        if (j11 < this.f57193k) {
            this.f57193k = j11;
        }
        return j11;
    }

    public List<T> a() {
        synchronized (this) {
            int O = O();
            if (O == 0) {
                List<T> k11 = CollectionsKt__CollectionsKt.k();
                return k11;
            }
            ArrayList arrayList = new ArrayList(O);
            Object[] objArr = this.f57191i;
            for (int i11 = 0; i11 < O; i11++) {
                arrayList.add(g1.f(objArr, this.f57192j + ((long) i11)));
            }
            return arrayList;
        }
    }

    public void b() {
        synchronized (this) {
            V(J(), this.f57193k, J(), N());
            Unit unit = Unit.f56620a;
        }
    }

    public d<T> c(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        return g1.e(this, coroutineContext, i11, bufferOverflow);
    }

    public Object collect(e<? super T> eVar, c<?> cVar) {
        return A(this, eVar, cVar);
    }

    public boolean d(T t11) {
        int i11;
        boolean z11;
        c<Unit>[] cVarArr = kotlinx.coroutines.flow.internal.a.f57259a;
        synchronized (this) {
            if (R(t11)) {
                cVarArr = I(cVarArr);
                z11 = true;
            } else {
                z11 = false;
            }
        }
        for (c<Unit> cVar : cVarArr) {
            if (cVar != null) {
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
            }
        }
        return z11;
    }

    public Object emit(T t11, c<? super Unit> cVar) {
        return F(this, t11, cVar);
    }

    public final Object x(SharedFlowSlot sharedFlowSlot, c<? super Unit> cVar) {
        Unit unit;
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        synchronized (this) {
            if (T(sharedFlowSlot) < 0) {
                sharedFlowSlot.f57202b = lVar;
                sharedFlowSlot.f57202b = lVar;
            } else {
                Result.a aVar = Result.Companion;
                lVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
            }
            unit = Unit.f56620a;
        }
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return v11 == IntrinsicsKt__IntrinsicsKt.d() ? v11 : unit;
    }

    public final void y(a aVar) {
        synchronized (this) {
            if (aVar.f57197c >= K()) {
                Object[] objArr = this.f57191i;
                if (g1.f(objArr, aVar.f57197c) == aVar) {
                    g1.g(objArr, aVar.f57197c, g1.f57223a);
                    z();
                    Unit unit = Unit.f56620a;
                }
            }
        }
    }

    public final void z() {
        if (this.f57189g != 0 || this.f57195m > 1) {
            Object[] objArr = this.f57191i;
            while (this.f57195m > 0 && g1.f(objArr, (K() + ((long) P())) - 1) == g1.f57223a) {
                this.f57195m--;
                g1.g(objArr, K() + ((long) P()), (Object) null);
            }
        }
    }
}
