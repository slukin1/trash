package com.iproov.sdk.p026return;

import com.iproov.sdk.p016if.Cabstract;
import com.iproov.sdk.p016if.Cprivate;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.switch  reason: invalid class name and invalid package */
public final class Cswitch extends BaseCoroutineScope implements Cprivate {
    /* access modifiers changed from: private */

    /* renamed from: break  reason: not valid java name */
    public Map<Integer, Creturn> f1744break;

    /* renamed from: case  reason: not valid java name */
    private int f1745case;

    /* renamed from: catch  reason: not valid java name */
    private Map<Integer, Integer> f1746catch;
    /* access modifiers changed from: private */

    /* renamed from: class  reason: not valid java name */
    public final a f1747class;
    /* access modifiers changed from: private */

    /* renamed from: const  reason: not valid java name */
    public final List<Cstatic> f1748const;

    /* renamed from: do  reason: not valid java name */
    private final Cabstract f1749do;

    /* renamed from: else  reason: not valid java name */
    private long f1750else;

    /* renamed from: for  reason: not valid java name */
    private final b1<Long> f1751for;

    /* renamed from: goto  reason: not valid java name */
    private long f1752goto;
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final f1<Creturn> f1753if;

    /* renamed from: new  reason: not valid java name */
    private int f1754new;

    /* renamed from: this  reason: not valid java name */
    private long f1755this;

    /* renamed from: try  reason: not valid java name */
    private Integer f1756try;

    @d(c = "com.iproov.sdk.impl.SensorSamplerImpl", f = "SensorSamplerImpl.kt", l = {136}, m = "getUniqueSamples")
    /* renamed from: com.iproov.sdk.return.switch$do  reason: invalid class name */
    public static final class Cdo extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public int f1757case;

        /* renamed from: do  reason: not valid java name */
        public Object f1758do;

        /* renamed from: for  reason: not valid java name */
        public long f1759for;

        /* renamed from: if  reason: not valid java name */
        public Object f1760if;

        /* renamed from: new  reason: not valid java name */
        public /* synthetic */ Object f1761new;

        /* renamed from: try  reason: not valid java name */
        public final /* synthetic */ Cswitch f1762try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cswitch switchR, c<? super Cdo> cVar) {
            super(cVar);
            this.f1762try = switchR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1761new = obj;
            this.f1757case |= Integer.MIN_VALUE;
            return this.f1762try.m1703do(0, (c<? super List<Cstatic>>) this);
        }
    }

    @d(c = "com.iproov.sdk.impl.SensorSamplerImpl$start$1", f = "SensorSamplerImpl.kt", l = {136, 142}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.switch$for  reason: invalid class name */
    public static final class Cfor extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public Object f1763do;

        /* renamed from: for  reason: not valid java name */
        public int f1764for;

        /* renamed from: if  reason: not valid java name */
        public Object f1765if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cswitch f1766new;

        /* renamed from: com.iproov.sdk.return.switch$for$do  reason: invalid class name */
        public static final class Cdo implements e<Creturn> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cswitch f1767do;

            public Cdo(Cswitch switchR) {
                this.f1767do = switchR;
            }

            public Object emit(Creturn returnR, c<? super Unit> cVar) {
                Object obj = this.f1767do.m1697do(returnR, cVar);
                if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
                    return obj;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(Cswitch switchR, c<? super Cfor> cVar) {
            super(2, cVar);
            this.f1766new = switchR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cfor(this.f1766new, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cfor) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        /* JADX INFO: finally extract failed */
        public final Object invokeSuspend(Object obj) {
            a aVar;
            Cswitch switchR;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1764for;
            if (i11 == 0) {
                k.b(obj);
                a aVar2 = this.f1766new.f1747class;
                switchR = this.f1766new;
                this.f1763do = aVar2;
                this.f1765if = switchR;
                this.f1764for = 1;
                if (aVar2.d((Object) null, this) == d11) {
                    return d11;
                }
                aVar = aVar2;
            } else if (i11 == 1) {
                switchR = (Cswitch) this.f1765if;
                aVar = (a) this.f1763do;
                k.b(obj);
            } else if (i11 == 2) {
                k.b(obj);
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                switchR.f1744break.clear();
                switchR.f1748const.clear();
                Unit unit = Unit.f56620a;
                aVar.e((Object) null);
                f1 f1Var = this.f1766new.f1753if;
                Cdo doVar = new Cdo(this.f1766new);
                this.f1763do = null;
                this.f1765if = null;
                this.f1764for = 2;
                if (f1Var.collect(doVar, this) == d11) {
                    return d11;
                }
                return Unit.f56620a;
            } catch (Throwable th2) {
                aVar.e((Object) null);
                throw th2;
            }
        }
    }

    @d(c = "com.iproov.sdk.impl.SensorSamplerImpl", f = "SensorSamplerImpl.kt", l = {136}, m = "newEvent")
    /* renamed from: com.iproov.sdk.return.switch$if  reason: invalid class name */
    public static final class Cif extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public int f1768case;

        /* renamed from: do  reason: not valid java name */
        public Object f1769do;

        /* renamed from: for  reason: not valid java name */
        public Object f1770for;

        /* renamed from: if  reason: not valid java name */
        public Object f1771if;

        /* renamed from: new  reason: not valid java name */
        public /* synthetic */ Object f1772new;

        /* renamed from: try  reason: not valid java name */
        public final /* synthetic */ Cswitch f1773try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cswitch switchR, c<? super Cif> cVar) {
            super(cVar);
            this.f1773try = switchR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1772new = obj;
            this.f1768case |= Integer.MIN_VALUE;
            return this.f1773try.m1697do((Creturn) null, (c<? super Unit>) this);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cswitch(Cabstract abstractR, f1 f1Var, b1 b1Var, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(abstractR, f1Var, b1Var, (i11 & 8) != 0 ? v0.a() : coroutineDispatcher);
    }

    public void doStop() {
        Ccase.m977do(this);
        this.f1749do.stop();
        super.doStop();
    }

    public Cswitch(Cabstract abstractR, f1<Creturn> f1Var, b1<Long> b1Var, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1749do = abstractR;
        this.f1753if = f1Var;
        this.f1751for = b1Var;
        this.f1754new = 5;
        this.f1744break = new LinkedHashMap();
        this.f1746catch = new LinkedHashMap();
        this.f1747class = MutexKt.b(false, 1, (Object) null);
        this.f1748const = new ArrayList();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c A[Catch:{ all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cf A[Catch:{ all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0104 A[Catch:{ all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0105 A[Catch:{ all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1697do(com.iproov.sdk.p026return.Creturn r21, kotlin.coroutines.c<? super kotlin.Unit> r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r22
            boolean r2 = r0 instanceof com.iproov.sdk.p026return.Cswitch.Cif
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.iproov.sdk.return.switch$if r2 = (com.iproov.sdk.p026return.Cswitch.Cif) r2
            int r3 = r2.f1768case
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f1768case = r3
            goto L_0x001c
        L_0x0017:
            com.iproov.sdk.return.switch$if r2 = new com.iproov.sdk.return.switch$if
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f1772new
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f1768case
            r5 = 0
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x0044
            if (r4 != r6) goto L_0x003c
            java.lang.Object r3 = r2.f1770for
            kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) r3
            java.lang.Object r4 = r2.f1771if
            com.iproov.sdk.return.return r4 = (com.iproov.sdk.p026return.Creturn) r4
            java.lang.Object r2 = r2.f1769do
            com.iproov.sdk.return.switch r2 = (com.iproov.sdk.p026return.Cswitch) r2
            kotlin.k.b(r0)
            goto L_0x0065
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0044:
            kotlin.k.b(r0)
            long r9 = r1.f1750else
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0050
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        L_0x0050:
            kotlinx.coroutines.sync.a r0 = r1.f1747class
            r2.f1769do = r1
            r4 = r21
            r2.f1771if = r4
            r2.f1770for = r0
            r2.f1768case = r6
            java.lang.Object r2 = r0.d(r5, r2)
            if (r2 != r3) goto L_0x0063
            return r3
        L_0x0063:
            r3 = r0
            r2 = r1
        L_0x0065:
            long r9 = r2.f1752goto     // Catch:{ all -> 0x0117 }
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            r9 = 0
            if (r0 == 0) goto L_0x00c9
            long r10 = r4.m1688do()     // Catch:{ all -> 0x0117 }
            long r14 = r2.f1752goto     // Catch:{ all -> 0x0117 }
            long r10 = r10 - r14
            long r12 = r2.f1750else     // Catch:{ all -> 0x0117 }
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c9
            com.iproov.sdk.return.static r0 = new com.iproov.sdk.return.static     // Catch:{ all -> 0x0117 }
            int r10 = r2.f1745case     // Catch:{ all -> 0x0117 }
            int r13 = r10 + 1
            r2.f1745case = r13     // Catch:{ all -> 0x0117 }
            long r10 = r2.f1755this     // Catch:{ all -> 0x0117 }
            java.util.Map<java.lang.Integer, com.iproov.sdk.return.return> r12 = r2.f1744break     // Catch:{ all -> 0x0117 }
            java.util.Map r18 = kotlin.collections.MapsKt__MapsKt.u(r12)     // Catch:{ all -> 0x0117 }
            java.util.Map<java.lang.Integer, java.lang.Integer> r12 = r2.f1746catch     // Catch:{ all -> 0x0117 }
            java.util.Map r19 = kotlin.collections.MapsKt__MapsKt.u(r12)     // Catch:{ all -> 0x0117 }
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r16, r18, r19)     // Catch:{ all -> 0x0117 }
            com.iproov.sdk.p017implements.Ccase.m977do(r2)     // Catch:{ all -> 0x0117 }
            java.lang.String r10 = "SensorSampling: Sample = "
            kotlin.jvm.internal.x.i(r10, r0)     // Catch:{ all -> 0x0117 }
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0117 }
            r10.<init>()     // Catch:{ all -> 0x0117 }
            r2.f1746catch = r10     // Catch:{ all -> 0x0117 }
            java.util.List<com.iproov.sdk.return.static> r10 = r2.f1748const     // Catch:{ all -> 0x0117 }
            r10.add(r0)     // Catch:{ all -> 0x0117 }
            java.util.List<com.iproov.sdk.return.static> r0 = r2.f1748const     // Catch:{ all -> 0x0117 }
            int r0 = r0.size()     // Catch:{ all -> 0x0117 }
            java.lang.Integer r10 = r2.f1756try     // Catch:{ all -> 0x0117 }
            if (r10 != 0) goto L_0x00b5
            r10 = r9
            goto L_0x00b9
        L_0x00b5:
            int r10 = r10.intValue()     // Catch:{ all -> 0x0117 }
        L_0x00b9:
            if (r0 <= r10) goto L_0x00c0
            java.util.List<com.iproov.sdk.return.static> r0 = r2.f1748const     // Catch:{ all -> 0x0117 }
            r0.remove(r9)     // Catch:{ all -> 0x0117 }
        L_0x00c0:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0117 }
            r0.<init>()     // Catch:{ all -> 0x0117 }
            r2.f1744break = r0     // Catch:{ all -> 0x0117 }
            r2.f1752goto = r7     // Catch:{ all -> 0x0117 }
        L_0x00c9:
            long r10 = r2.f1752goto     // Catch:{ all -> 0x0117 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x00d5
            long r7 = r4.m1688do()     // Catch:{ all -> 0x0117 }
            r2.f1752goto = r7     // Catch:{ all -> 0x0117 }
        L_0x00d5:
            long r7 = r4.m1688do()     // Catch:{ all -> 0x0117 }
            r2.f1755this = r7     // Catch:{ all -> 0x0117 }
            java.util.Map<java.lang.Integer, com.iproov.sdk.return.return> r0 = r2.f1744break     // Catch:{ all -> 0x0117 }
            int r7 = r4.m1690if()     // Catch:{ all -> 0x0117 }
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.c(r7)     // Catch:{ all -> 0x0117 }
            r0.put(r7, r4)     // Catch:{ all -> 0x0117 }
            java.util.Map<java.lang.Integer, java.lang.Integer> r0 = r2.f1746catch     // Catch:{ all -> 0x0117 }
            int r7 = r4.m1690if()     // Catch:{ all -> 0x0117 }
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.a.c(r7)     // Catch:{ all -> 0x0117 }
            java.util.Map<java.lang.Integer, java.lang.Integer> r2 = r2.f1746catch     // Catch:{ all -> 0x0117 }
            int r4 = r4.m1690if()     // Catch:{ all -> 0x0117 }
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.a.c(r4)     // Catch:{ all -> 0x0117 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ all -> 0x0117 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0117 }
            if (r2 != 0) goto L_0x0105
            goto L_0x0109
        L_0x0105:
            int r9 = r2.intValue()     // Catch:{ all -> 0x0117 }
        L_0x0109:
            int r9 = r9 + r6
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.a.c(r9)     // Catch:{ all -> 0x0117 }
            r0.put(r7, r2)     // Catch:{ all -> 0x0117 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0117 }
            r3.e(r5)
            return r0
        L_0x0117:
            r0 = move-exception
            r3.e(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cswitch.m1697do(com.iproov.sdk.return.return, kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: do  reason: not valid java name */
    public void m1704do(long j11, int i11) {
        Ccase.m977do(this);
        this.f1750else = j11;
        this.f1751for.d(Long.valueOf(j11 * 500));
        this.f1754new = i11;
        this.f1756try = Integer.valueOf(i11 * 10);
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cfor(this, (c<? super Cfor>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064 A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007f A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[SYNTHETIC, Splitter:B:31:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1703do(long r10, kotlin.coroutines.c<? super java.util.List<com.iproov.sdk.p026return.Cstatic>> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.iproov.sdk.p026return.Cswitch.Cdo
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.iproov.sdk.return.switch$do r0 = (com.iproov.sdk.p026return.Cswitch.Cdo) r0
            int r1 = r0.f1757case
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1757case = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.switch$do r0 = new com.iproov.sdk.return.switch$do
            r0.<init>(r9, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f1761new
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1757case
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            long r10 = r0.f1759for
            java.lang.Object r1 = r0.f1760if
            kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r1
            java.lang.Object r0 = r0.f1758do
            com.iproov.sdk.return.switch r0 = (com.iproov.sdk.p026return.Cswitch) r0
            kotlin.k.b(r12)
            goto L_0x0052
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            kotlin.k.b(r12)
            kotlinx.coroutines.sync.a r12 = r9.f1747class
            r0.f1758do = r9
            r0.f1760if = r12
            r0.f1759for = r10
            r0.f1757case = r4
            java.lang.Object r0 = r12.d(r3, r0)
            if (r0 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r0 = r9
            r1 = r12
        L_0x0052:
            java.util.List<com.iproov.sdk.return.static> r12 = r0.f1748const     // Catch:{ all -> 0x00a9 }
            int r2 = r12.size()     // Catch:{ all -> 0x00a9 }
            java.util.ListIterator r12 = r12.listIterator(r2)     // Catch:{ all -> 0x00a9 }
        L_0x005c:
            boolean r2 = r12.hasPrevious()     // Catch:{ all -> 0x00a9 }
            r5 = -1
            r6 = 0
            if (r2 == 0) goto L_0x007c
            java.lang.Object r2 = r12.previous()     // Catch:{ all -> 0x00a9 }
            com.iproov.sdk.return.static r2 = (com.iproov.sdk.p026return.Cstatic) r2     // Catch:{ all -> 0x00a9 }
            long r7 = r2.m1692for()     // Catch:{ all -> 0x00a9 }
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x0074
            r2 = r4
            goto L_0x0075
        L_0x0074:
            r2 = r6
        L_0x0075:
            if (r2 == 0) goto L_0x005c
            int r10 = r12.nextIndex()     // Catch:{ all -> 0x00a9 }
            goto L_0x007d
        L_0x007c:
            r10 = r5
        L_0x007d:
            if (r10 != r5) goto L_0x0087
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.k()     // Catch:{ all -> 0x00a9 }
            r1.e(r3)
            return r10
        L_0x0087:
            int r11 = r0.f1754new     // Catch:{ all -> 0x00a9 }
            int r11 = r10 - r11
            int r11 = java.lang.Math.max(r6, r11)     // Catch:{ all -> 0x00a9 }
            java.util.List<com.iproov.sdk.return.static> r12 = r0.f1748const     // Catch:{ all -> 0x00a9 }
            int r10 = r10 + r4
            java.util.List r11 = r12.subList(r11, r10)     // Catch:{ all -> 0x00a9 }
            java.util.List r11 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r11)     // Catch:{ all -> 0x00a9 }
            r12 = r6
        L_0x009b:
            if (r12 >= r10) goto L_0x00a5
            java.util.List<com.iproov.sdk.return.static> r2 = r0.f1748const     // Catch:{ all -> 0x00a9 }
            r2.remove(r6)     // Catch:{ all -> 0x00a9 }
            int r12 = r12 + 1
            goto L_0x009b
        L_0x00a5:
            r1.e(r3)
            return r11
        L_0x00a9:
            r10 = move-exception
            r1.e(r3)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cswitch.m1703do(long, kotlin.coroutines.c):java.lang.Object");
    }
}
