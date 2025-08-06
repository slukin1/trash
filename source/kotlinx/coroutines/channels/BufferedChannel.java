package kotlinx.coroutines.channels;

import d10.l;
import d10.p;
import d10.q;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.d;
import kotlinx.coroutines.internal.e;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import kotlinx.coroutines.selects.g;
import kotlinx.coroutines.selects.h;
import kotlinx.coroutines.selects.i;
import kotlinx.coroutines.selects.k;

public class BufferedChannel<E> implements d<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57001e;

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57002f;

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57003g;

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57004h;

    /* renamed from: i  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57005i;

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57006j;

    /* renamed from: k  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57007k;

    /* renamed from: l  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57008l;

    /* renamed from: m  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57009m;
    private volatile Object _closeCause;

    /* renamed from: b  reason: collision with root package name */
    public final int f57010b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* renamed from: c  reason: collision with root package name */
    public final l<E, Unit> f57011c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;

    /* renamed from: d  reason: collision with root package name */
    public final q<k<?>, Object, Object, l<Throwable, Unit>> f57012d;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    public final class a implements ChannelIterator<E>, q2 {

        /* renamed from: b  reason: collision with root package name */
        public Object f57013b = BufferedChannelKt.f57033p;

        /* renamed from: c  reason: collision with root package name */
        public kotlinx.coroutines.l<? super Boolean> f57014c;

        public a() {
        }

        public Object a(c<? super Boolean> cVar) {
            g gVar;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            g gVar2 = (g) BufferedChannel.f57006j.get(bufferedChannel);
            while (!bufferedChannel.g0()) {
                long andIncrement = BufferedChannel.f57002f.getAndIncrement(bufferedChannel);
                int i11 = BufferedChannelKt.f57019b;
                long j11 = andIncrement / ((long) i11);
                int i12 = (int) (andIncrement % ((long) i11));
                if (gVar2.f57353d != j11) {
                    g a11 = bufferedChannel.S(j11, gVar2);
                    if (a11 == null) {
                        continue;
                    } else {
                        gVar = a11;
                    }
                } else {
                    gVar = gVar2;
                }
                Object B = bufferedChannel.Z0(gVar, i12, andIncrement, (Object) null);
                if (B == BufferedChannelKt.f57030m) {
                    throw new IllegalStateException("unreachable".toString());
                } else if (B == BufferedChannelKt.f57032o) {
                    if (andIncrement < bufferedChannel.Z()) {
                        gVar.b();
                    }
                    gVar2 = gVar;
                } else if (B == BufferedChannelKt.f57031n) {
                    return f(gVar, i12, andIncrement, cVar);
                } else {
                    gVar.b();
                    this.f57013b = B;
                    return kotlin.coroutines.jvm.internal.a.a(true);
                }
            }
            return kotlin.coroutines.jvm.internal.a.a(g());
        }

        public void b(z<?> zVar, int i11) {
            kotlinx.coroutines.l<? super Boolean> lVar = this.f57014c;
            if (lVar != null) {
                lVar.b(zVar, i11);
            }
        }

        public final Object f(g<E> gVar, int i11, long j11, c<? super Boolean> cVar) {
            Boolean a11;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            kotlinx.coroutines.l b11 = n.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
            try {
                this.f57014c = b11;
                Object B = bufferedChannel.Z0(gVar, i11, j11, this);
                if (B == BufferedChannelKt.f57030m) {
                    bufferedChannel.z0(this, gVar, i11);
                } else {
                    l<Throwable, Unit> lVar = null;
                    if (B == BufferedChannelKt.f57032o) {
                        if (j11 < bufferedChannel.Z()) {
                            gVar.b();
                        }
                        g gVar2 = (g) BufferedChannel.f57006j.get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.g0()) {
                                h();
                                break;
                            }
                            long andIncrement = BufferedChannel.f57002f.getAndIncrement(bufferedChannel);
                            int i12 = BufferedChannelKt.f57019b;
                            long j12 = andIncrement / ((long) i12);
                            int i13 = (int) (andIncrement % ((long) i12));
                            if (gVar2.f57353d != j12) {
                                g a12 = bufferedChannel.S(j12, gVar2);
                                if (a12 != null) {
                                    gVar2 = a12;
                                }
                            }
                            Object B2 = bufferedChannel.Z0(gVar2, i13, andIncrement, this);
                            if (B2 == BufferedChannelKt.f57030m) {
                                bufferedChannel.z0(this, gVar2, i13);
                                break;
                            } else if (B2 == BufferedChannelKt.f57032o) {
                                if (andIncrement < bufferedChannel.Z()) {
                                    gVar2.b();
                                }
                            } else if (B2 != BufferedChannelKt.f57031n) {
                                gVar2.b();
                                this.f57013b = B2;
                                this.f57014c = null;
                                a11 = kotlin.coroutines.jvm.internal.a.a(true);
                                l<E, Unit> lVar2 = bufferedChannel.f57011c;
                                if (lVar2 != null) {
                                    lVar = OnUndeliveredElementKt.a(lVar2, B2, b11.getContext());
                                }
                            } else {
                                throw new IllegalStateException("unexpected".toString());
                            }
                        }
                    } else {
                        gVar.b();
                        this.f57013b = B;
                        this.f57014c = null;
                        a11 = kotlin.coroutines.jvm.internal.a.a(true);
                        l<E, Unit> lVar3 = bufferedChannel.f57011c;
                        if (lVar3 != null) {
                            lVar = OnUndeliveredElementKt.a(lVar3, B, b11.getContext());
                        }
                    }
                    b11.h(a11, lVar);
                }
                Object v11 = b11.v();
                if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    f.c(cVar);
                }
                return v11;
            } catch (Throwable th2) {
                b11.L();
                throw th2;
            }
        }

        public final boolean g() {
            this.f57013b = BufferedChannelKt.z();
            Throwable V = BufferedChannel.this.V();
            if (V == null) {
                return false;
            }
            throw b0.j(V);
        }

        public final void h() {
            kotlinx.coroutines.l<? super Boolean> lVar = this.f57014c;
            this.f57014c = null;
            this.f57013b = BufferedChannelKt.z();
            Throwable V = BufferedChannel.this.V();
            if (V == null) {
                Result.a aVar = Result.Companion;
                lVar.resumeWith(Result.m3072constructorimpl(Boolean.FALSE));
                return;
            }
            if (j0.d() && (lVar instanceof kotlin.coroutines.jvm.internal.c)) {
                V = b0.i(V, lVar);
            }
            Result.a aVar2 = Result.Companion;
            lVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(V)));
        }

        public final boolean i(E e11) {
            kotlinx.coroutines.l<? super Boolean> lVar = this.f57014c;
            l<Throwable, Unit> lVar2 = null;
            this.f57014c = null;
            this.f57013b = e11;
            Boolean bool = Boolean.TRUE;
            l<E, Unit> lVar3 = BufferedChannel.this.f57011c;
            if (lVar3 != null) {
                lVar2 = OnUndeliveredElementKt.a(lVar3, e11, lVar.getContext());
            }
            return BufferedChannelKt.B(lVar, bool, lVar2);
        }

        public final void j() {
            kotlinx.coroutines.l<? super Boolean> lVar = this.f57014c;
            this.f57014c = null;
            this.f57013b = BufferedChannelKt.z();
            Throwable V = BufferedChannel.this.V();
            if (V == null) {
                Result.a aVar = Result.Companion;
                lVar.resumeWith(Result.m3072constructorimpl(Boolean.FALSE));
                return;
            }
            if (j0.d() && (lVar instanceof kotlin.coroutines.jvm.internal.c)) {
                V = b0.i(V, lVar);
            }
            Result.a aVar2 = Result.Companion;
            lVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(V)));
        }

        public E next() {
            E e11 = this.f57013b;
            if (e11 != BufferedChannelKt.f57033p) {
                this.f57013b = BufferedChannelKt.f57033p;
                if (e11 != BufferedChannelKt.z()) {
                    return e11;
                }
                throw b0.j(BufferedChannel.this.W());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }
    }

    public static final class b implements q2 {

        /* renamed from: b  reason: collision with root package name */
        public final kotlinx.coroutines.k<Boolean> f57016b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.l<Boolean> f57017c;

        public b(kotlinx.coroutines.k<? super Boolean> kVar) {
            this.f57016b = kVar;
            this.f57017c = (kotlinx.coroutines.l) kVar;
        }

        public final kotlinx.coroutines.k<Boolean> a() {
            return this.f57016b;
        }

        public void b(z<?> zVar, int i11) {
            this.f57017c.b(zVar, i11);
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<BufferedChannel> cls2 = BufferedChannel.class;
        f57001e = AtomicLongFieldUpdater.newUpdater(cls2, "sendersAndCloseStatus");
        f57002f = AtomicLongFieldUpdater.newUpdater(cls2, "receivers");
        f57003g = AtomicLongFieldUpdater.newUpdater(cls2, "bufferEnd");
        f57004h = AtomicLongFieldUpdater.newUpdater(cls2, "completedExpandBuffersAndPauseFlag");
        f57005i = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "sendSegment");
        f57006j = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "receiveSegment");
        f57007k = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "bufferEndSegment");
        f57008l = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_closeCause");
        f57009m = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "closeHandler");
    }

    public BufferedChannel(int i11, l<? super E, Unit> lVar) {
        this.f57010b = i11;
        this.f57011c = lVar;
        if (i11 >= 0) {
            this.bufferEnd = BufferedChannelKt.A(i11);
            this.completedExpandBuffersAndPauseFlag = U();
            g gVar = new g(0, (g) null, this, 3);
            this.sendSegment = gVar;
            this.receiveSegment = gVar;
            this.bufferEndSegment = k0() ? BufferedChannelKt.f57018a : gVar;
            this.f57012d = lVar != null ? new BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(this) : null;
            this._closeCause = BufferedChannelKt.f57036s;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i11 + ", should be >=0").toString());
    }

    /* access modifiers changed from: private */
    public final Object E0(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.z()) {
            return this;
        }
        throw Y();
    }

    public static /* synthetic */ <E> Object F0(BufferedChannel<E> bufferedChannel, c<? super E> cVar) {
        g gVar = (g) f57006j.get(bufferedChannel);
        while (!bufferedChannel.g0()) {
            long andIncrement = f57002f.getAndIncrement(bufferedChannel);
            int i11 = BufferedChannelKt.f57019b;
            long j11 = andIncrement / ((long) i11);
            int i12 = (int) (andIncrement % ((long) i11));
            if (gVar.f57353d != j11) {
                g a11 = bufferedChannel.S(j11, gVar);
                if (a11 == null) {
                    continue;
                } else {
                    gVar = a11;
                }
            }
            Object B = bufferedChannel.Z0(gVar, i12, andIncrement, (Object) null);
            if (B == BufferedChannelKt.f57030m) {
                throw new IllegalStateException("unexpected".toString());
            } else if (B == BufferedChannelKt.f57032o) {
                if (andIncrement < bufferedChannel.Z()) {
                    gVar.b();
                }
            } else if (B == BufferedChannelKt.f57031n) {
                return bufferedChannel.I0(gVar, i12, andIncrement, cVar);
            } else {
                gVar.b();
                return B;
            }
        }
        throw b0.j(bufferedChannel.W());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ <E> java.lang.Object G0(kotlinx.coroutines.channels.BufferedChannel<E> r14, kotlin.coroutines.c<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r14, r15)
        L_0x0018:
            r6 = r0
            java.lang.Object r15 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            kotlin.k.b(r15)
            kotlinx.coroutines.channels.ChannelResult r15 = (kotlinx.coroutines.channels.ChannelResult) r15
            java.lang.Object r14 = r15.l()
            goto L_0x00b6
        L_0x0031:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0039:
            kotlin.k.b(r15)
            r15 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f57006j
            java.lang.Object r1 = r1.get(r14)
            kotlinx.coroutines.channels.g r1 = (kotlinx.coroutines.channels.g) r1
        L_0x0047:
            boolean r3 = r14.g0()
            if (r3 == 0) goto L_0x0059
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.f57037b
            java.lang.Throwable r14 = r14.V()
            java.lang.Object r14 = r15.a(r14)
            goto L_0x00b6
        L_0x0059:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = f57002f
            long r4 = r3.getAndIncrement(r14)
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r7 = (long) r3
            long r7 = r4 / r7
            long r9 = (long) r3
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r1.f57353d
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0079
            kotlinx.coroutines.channels.g r7 = r14.S(r7, r1)
            if (r7 != 0) goto L_0x0077
            goto L_0x0047
        L_0x0077:
            r13 = r7
            goto L_0x007a
        L_0x0079:
            r13 = r1
        L_0x007a:
            r7 = r14
            r8 = r13
            r9 = r3
            r10 = r4
            r12 = r15
            java.lang.Object r1 = r7.Z0(r8, r9, r10, r12)
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.f57030m
            if (r1 == r7) goto L_0x00b7
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.f57032o
            if (r1 != r7) goto L_0x009c
            long r7 = r14.Z()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x009a
            r13.b()
        L_0x009a:
            r1 = r13
            goto L_0x0047
        L_0x009c:
            kotlinx.coroutines.internal.c0 r15 = kotlinx.coroutines.channels.BufferedChannelKt.f57031n
            if (r1 != r15) goto L_0x00ad
            r6.label = r2
            r1 = r14
            r2 = r13
            java.lang.Object r14 = r1.H0(r2, r3, r4, r6)
            if (r14 != r0) goto L_0x00b6
            return r0
        L_0x00ad:
            r13.b()
            kotlinx.coroutines.channels.ChannelResult$b r14 = kotlinx.coroutines.channels.ChannelResult.f57037b
            java.lang.Object r14 = r14.c(r1)
        L_0x00b6:
            return r14
        L_0x00b7:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.G0(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ <E> Object P0(BufferedChannel<E> bufferedChannel, E e11, c<? super Unit> cVar) {
        g gVar = (g) f57005i.get(bufferedChannel);
        while (true) {
            long andIncrement = f57001e.getAndIncrement(bufferedChannel);
            long j11 = 1152921504606846975L & andIncrement;
            boolean k11 = bufferedChannel.i0(andIncrement);
            int i11 = BufferedChannelKt.f57019b;
            long j12 = j11 / ((long) i11);
            int i12 = (int) (j11 % ((long) i11));
            if (gVar.f57353d != j12) {
                g c11 = bufferedChannel.T(j12, gVar);
                if (c11 != null) {
                    gVar = c11;
                } else if (k11) {
                    Object v02 = bufferedChannel.v0(e11, cVar);
                    if (v02 == IntrinsicsKt__IntrinsicsKt.d()) {
                        return v02;
                    }
                }
            }
            int C = bufferedChannel.b1(gVar, i12, e11, j11, (Object) null, k11);
            if (C == 0) {
                gVar.b();
                break;
            } else if (C == 1) {
                break;
            } else if (C != 2) {
                if (C == 3) {
                    Object S0 = bufferedChannel.S0(gVar, i12, e11, j11, cVar);
                    if (S0 == IntrinsicsKt__IntrinsicsKt.d()) {
                        return S0;
                    }
                } else if (C == 4) {
                    if (j11 < bufferedChannel.X()) {
                        gVar.b();
                    }
                    Object v03 = bufferedChannel.v0(e11, cVar);
                    if (v03 == IntrinsicsKt__IntrinsicsKt.d()) {
                        return v03;
                    }
                } else if (C == 5) {
                    gVar.b();
                }
            } else if (k11) {
                gVar.p();
                Object v04 = bufferedChannel.v0(e11, cVar);
                if (v04 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return v04;
                }
            } else if (j0.a()) {
                throw new AssertionError();
            }
        }
        return Unit.f56620a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b6, code lost:
        r0 = kotlin.Result.Companion;
        r9.resumeWith(kotlin.Result.m3072constructorimpl(kotlin.coroutines.jvm.internal.a.a(true)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ <E> java.lang.Object R0(kotlinx.coroutines.channels.BufferedChannel<E> r18, E r19, kotlin.coroutines.c<? super java.lang.Boolean> r20) {
        /*
            r8 = r18
            kotlinx.coroutines.l r9 = new kotlinx.coroutines.l
            kotlin.coroutines.c r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r20)
            r10 = 1
            r9.<init>(r0, r10)
            r9.A()
            d10.l<E, kotlin.Unit> r0 = r8.f57011c
            r11 = 0
            if (r0 != 0) goto L_0x0016
            r0 = r10
            goto L_0x0017
        L_0x0016:
            r0 = r11
        L_0x0017:
            if (r0 == 0) goto L_0x00d1
            kotlinx.coroutines.channels.BufferedChannel$b r12 = new kotlinx.coroutines.channels.BufferedChannel$b
            r12.<init>(r9)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f57005i
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.g r0 = (kotlinx.coroutines.channels.g) r0
        L_0x0028:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f57001e
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r13 = r1 & r3
            boolean r15 = r8.i0(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r2 = (long) r1
            long r2 = r13 / r2
            long r4 = (long) r1
            long r4 = r13 % r4
            int r7 = (int) r4
            long r4 = r0.f57353d
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0055
            kotlinx.coroutines.channels.g r1 = r8.T(r2, r0)
            if (r1 != 0) goto L_0x0053
            if (r15 == 0) goto L_0x0028
            goto L_0x009b
        L_0x0053:
            r6 = r1
            goto L_0x0056
        L_0x0055:
            r6 = r0
        L_0x0056:
            r0 = r18
            r1 = r6
            r2 = r7
            r3 = r19
            r4 = r13
            r16 = r6
            r6 = r12
            r17 = r7
            r7 = r15
            int r0 = r0.b1(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00b1
            if (r0 == r10) goto L_0x00b6
            r1 = 2
            if (r0 == r1) goto L_0x0096
            r1 = 3
            if (r0 == r1) goto L_0x008a
            r1 = 4
            if (r0 == r1) goto L_0x007e
            r1 = 5
            if (r0 == r1) goto L_0x0078
            goto L_0x007b
        L_0x0078:
            r16.b()
        L_0x007b:
            r0 = r16
            goto L_0x0028
        L_0x007e:
            long r0 = r18.X()
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x009b
            r16.b()
            goto L_0x009b
        L_0x008a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0096:
            if (r15 == 0) goto L_0x00a9
            r16.p()
        L_0x009b:
            kotlin.Result$a r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.a.a(r11)
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)
            r9.resumeWith(r0)
            goto L_0x00c3
        L_0x00a9:
            r1 = r16
            r0 = r17
            r8.A0(r12, r1, r0)
            goto L_0x00c3
        L_0x00b1:
            r1 = r16
            r1.b()
        L_0x00b6:
            kotlin.Result$a r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.a.a(r10)
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)
            r9.resumeWith(r0)
        L_0x00c3:
            java.lang.Object r0 = r9.v()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r0 != r1) goto L_0x00d0
            kotlin.coroutines.jvm.internal.f.c(r20)
        L_0x00d0:
            return r0
        L_0x00d1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.R0(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ void c0(BufferedChannel bufferedChannel, long j11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                j11 = 1;
            }
            bufferedChannel.b0(j11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    public final void A0(q2 q2Var, g<E> gVar, int i11) {
        q2Var.b(gVar, i11 + BufferedChannelKt.f57019b);
    }

    public final Object B0(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.z()) {
            return obj2;
        }
        throw W();
    }

    public final Object C0(Object obj, Object obj2) {
        Object obj3;
        if (obj2 == BufferedChannelKt.z()) {
            obj3 = ChannelResult.f57037b.a(V());
        } else {
            obj3 = ChannelResult.f57037b.c(obj2);
        }
        return ChannelResult.b(obj3);
    }

    public final boolean D(long j11) {
        return j11 < U() || j11 < X() + ((long) this.f57010b);
    }

    public final Object D0(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.z()) {
            return obj2;
        }
        if (V() == null) {
            return null;
        }
        throw W();
    }

    public boolean E(Throwable th2) {
        if (th2 == null) {
            th2 = new CancellationException("Channel was cancelled");
        }
        return L(th2, true);
    }

    public final void F(g<E> gVar, long j11) {
        Object b11 = m.b((Object) null, 1, (r) null);
        loop0:
        while (gVar != null) {
            for (int i11 = BufferedChannelKt.f57019b - 1; -1 < i11; i11--) {
                if ((gVar.f57353d * ((long) BufferedChannelKt.f57019b)) + ((long) i11) < j11) {
                    break loop0;
                }
                while (true) {
                    Object w11 = gVar.w(i11);
                    if (w11 == null || w11 == BufferedChannelKt.f57022e) {
                        if (gVar.r(i11, w11, BufferedChannelKt.z())) {
                            gVar.p();
                            break;
                        }
                    } else if (w11 instanceof n) {
                        if (gVar.r(i11, w11, BufferedChannelKt.z())) {
                            b11 = m.c(b11, ((n) w11).f57054a);
                            gVar.x(i11, true);
                            break;
                        }
                    } else if (!(w11 instanceof q2)) {
                        break;
                    } else if (gVar.r(i11, w11, BufferedChannelKt.z())) {
                        b11 = m.c(b11, w11);
                        gVar.x(i11, true);
                        break;
                    }
                }
            }
            gVar = (g) gVar.g();
        }
        if (b11 == null) {
            return;
        }
        if (!(b11 instanceof ArrayList)) {
            M0((q2) b11);
            return;
        }
        ArrayList arrayList = (ArrayList) b11;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            M0((q2) arrayList.get(size));
        }
    }

    public kotlinx.coroutines.selects.f<E> G() {
        return new g(this, (q) TypeIntrinsics.e(BufferedChannel$onReceive$1.INSTANCE, 3), (q) TypeIntrinsics.e(BufferedChannel$onReceive$2.INSTANCE, 3), this.f57012d);
    }

    public void H(l<? super Throwable, Unit> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57009m;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, (Object) null, lVar)) {
            do {
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj != BufferedChannelKt.f57034q) {
                    if (obj == BufferedChannelKt.f57035r) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            } while (!androidx.concurrent.futures.a.a(f57009m, this, BufferedChannelKt.f57034q, BufferedChannelKt.f57035r));
            lVar.invoke(V());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object H0(kotlinx.coroutines.channels.g<E> r11, int r12, long r13, kotlin.coroutines.c<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.channels.g r11 = (kotlinx.coroutines.channels.g) r11
            java.lang.Object r11 = r0.L$0
            kotlinx.coroutines.channels.BufferedChannel r11 = (kotlinx.coroutines.channels.BufferedChannel) r11
            kotlin.k.b(r15)
            goto L_0x012c
        L_0x0032:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003a:
            kotlin.k.b(r15)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.I$0 = r12
            r0.J$0 = r13
            r0.label = r3
            kotlin.coroutines.c r15 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r0)
            kotlinx.coroutines.l r15 = kotlinx.coroutines.n.b(r15)
            kotlinx.coroutines.channels.l r8 = new kotlinx.coroutines.channels.l     // Catch:{ all -> 0x0133 }
            r8.<init>(r15)     // Catch:{ all -> 0x0133 }
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r7 = r8
            java.lang.Object r2 = r2.Z0(r3, r4, r5, r7)     // Catch:{ all -> 0x0133 }
            kotlinx.coroutines.internal.c0 r3 = kotlinx.coroutines.channels.BufferedChannelKt.f57030m     // Catch:{ all -> 0x0133 }
            if (r2 != r3) goto L_0x0068
            r10.z0(r8, r11, r12)     // Catch:{ all -> 0x0133 }
            goto L_0x011c
        L_0x0068:
            kotlinx.coroutines.internal.c0 r12 = kotlinx.coroutines.channels.BufferedChannelKt.f57032o     // Catch:{ all -> 0x0133 }
            r9 = 0
            if (r2 != r12) goto L_0x0102
            long r2 = r10.Z()     // Catch:{ all -> 0x0133 }
            int r12 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x007a
            r11.b()     // Catch:{ all -> 0x0133 }
        L_0x007a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = f57006j     // Catch:{ all -> 0x0133 }
            java.lang.Object r11 = r11.get(r10)     // Catch:{ all -> 0x0133 }
            kotlinx.coroutines.channels.g r11 = (kotlinx.coroutines.channels.g) r11     // Catch:{ all -> 0x0133 }
        L_0x0084:
            boolean r12 = r10.g0()     // Catch:{ all -> 0x0133 }
            if (r12 == 0) goto L_0x008f
            r10.r0(r15)     // Catch:{ all -> 0x0133 }
            goto L_0x011c
        L_0x008f:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = f57002f     // Catch:{ all -> 0x0133 }
            long r12 = r12.getAndIncrement(r10)     // Catch:{ all -> 0x0133 }
            int r14 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b     // Catch:{ all -> 0x0133 }
            long r2 = (long) r14     // Catch:{ all -> 0x0133 }
            long r2 = r12 / r2
            long r4 = (long) r14     // Catch:{ all -> 0x0133 }
            long r4 = r12 % r4
            int r14 = (int) r4     // Catch:{ all -> 0x0133 }
            long r4 = r11.f57353d     // Catch:{ all -> 0x0133 }
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ae
            kotlinx.coroutines.channels.g r2 = r10.S(r2, r11)     // Catch:{ all -> 0x0133 }
            if (r2 != 0) goto L_0x00ad
            goto L_0x0084
        L_0x00ad:
            r11 = r2
        L_0x00ae:
            r2 = r10
            r3 = r11
            r4 = r14
            r5 = r12
            r7 = r8
            java.lang.Object r2 = r2.Z0(r3, r4, r5, r7)     // Catch:{ all -> 0x0133 }
            kotlinx.coroutines.internal.c0 r3 = kotlinx.coroutines.channels.BufferedChannelKt.f57030m     // Catch:{ all -> 0x0133 }
            if (r2 != r3) goto L_0x00c1
            r10.z0(r8, r11, r14)     // Catch:{ all -> 0x0133 }
            goto L_0x011c
        L_0x00c1:
            kotlinx.coroutines.internal.c0 r14 = kotlinx.coroutines.channels.BufferedChannelKt.f57032o     // Catch:{ all -> 0x0133 }
            if (r2 != r14) goto L_0x00d3
            long r2 = r10.Z()     // Catch:{ all -> 0x0133 }
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x0084
            r11.b()     // Catch:{ all -> 0x0133 }
            goto L_0x0084
        L_0x00d3:
            kotlinx.coroutines.internal.c0 r12 = kotlinx.coroutines.channels.BufferedChannelKt.f57031n     // Catch:{ all -> 0x0133 }
            if (r2 == r12) goto L_0x00f6
            r11.b()     // Catch:{ all -> 0x0133 }
            kotlinx.coroutines.channels.ChannelResult$b r11 = kotlinx.coroutines.channels.ChannelResult.f57037b     // Catch:{ all -> 0x0133 }
            java.lang.Object r11 = r11.c(r2)     // Catch:{ all -> 0x0133 }
            kotlinx.coroutines.channels.ChannelResult r11 = kotlinx.coroutines.channels.ChannelResult.b(r11)     // Catch:{ all -> 0x0133 }
            d10.l<E, kotlin.Unit> r12 = r10.f57011c     // Catch:{ all -> 0x0133 }
            if (r12 == 0) goto L_0x00f2
            kotlin.coroutines.CoroutineContext r13 = r15.getContext()     // Catch:{ all -> 0x0133 }
            d10.l r9 = kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r12, r2, r13)     // Catch:{ all -> 0x0133 }
        L_0x00f2:
            r15.h(r11, r9)     // Catch:{ all -> 0x0133 }
            goto L_0x011c
        L_0x00f6:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0133 }
            java.lang.String r12 = "unexpected"
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0133 }
            r11.<init>(r12)     // Catch:{ all -> 0x0133 }
            throw r11     // Catch:{ all -> 0x0133 }
        L_0x0102:
            r11.b()     // Catch:{ all -> 0x0133 }
            kotlinx.coroutines.channels.ChannelResult$b r11 = kotlinx.coroutines.channels.ChannelResult.f57037b     // Catch:{ all -> 0x0133 }
            java.lang.Object r11 = r11.c(r2)     // Catch:{ all -> 0x0133 }
            kotlinx.coroutines.channels.ChannelResult r11 = kotlinx.coroutines.channels.ChannelResult.b(r11)     // Catch:{ all -> 0x0133 }
            d10.l<E, kotlin.Unit> r12 = r10.f57011c     // Catch:{ all -> 0x0133 }
            if (r12 == 0) goto L_0x00f2
            kotlin.coroutines.CoroutineContext r13 = r15.getContext()     // Catch:{ all -> 0x0133 }
            d10.l r9 = kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r12, r2, r13)     // Catch:{ all -> 0x0133 }
            goto L_0x00f2
        L_0x011c:
            java.lang.Object r15 = r15.v()
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r15 != r11) goto L_0x0129
            kotlin.coroutines.jvm.internal.f.c(r0)
        L_0x0129:
            if (r15 != r1) goto L_0x012c
            return r1
        L_0x012c:
            kotlinx.coroutines.channels.ChannelResult r15 = (kotlinx.coroutines.channels.ChannelResult) r15
            java.lang.Object r11 = r15.l()
            return r11
        L_0x0133:
            r11 = move-exception
            r15.L()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.H0(kotlinx.coroutines.channels.g, int, long, kotlin.coroutines.c):java.lang.Object");
    }

    public final g<E> I() {
        g gVar = f57007k.get(this);
        g gVar2 = (g) f57005i.get(this);
        if (gVar2.f57353d > ((g) gVar).f57353d) {
            gVar = gVar2;
        }
        g gVar3 = (g) f57006j.get(this);
        if (gVar3.f57353d > ((g) gVar).f57353d) {
            gVar = gVar3;
        }
        return (g) d.b((e) gVar);
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v2, types: [d10.l] */
    /* JADX WARNING: type inference failed for: r7v3, types: [kotlinx.coroutines.q2] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object I0(kotlinx.coroutines.channels.g<E> r9, int r10, long r11, kotlin.coroutines.c<? super E> r13) {
        /*
            r8 = this;
            kotlin.coroutines.c r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r13)
            kotlinx.coroutines.l r0 = kotlinx.coroutines.n.b(r0)
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r0
            java.lang.Object r1 = r1.Z0(r2, r3, r4, r6)     // Catch:{ all -> 0x00d1 }
            kotlinx.coroutines.internal.c0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.f57030m     // Catch:{ all -> 0x00d1 }
            if (r1 != r2) goto L_0x001c
            r8.z0(r0, r9, r10)     // Catch:{ all -> 0x00d1 }
            goto L_0x00c3
        L_0x001c:
            kotlinx.coroutines.internal.c0 r10 = kotlinx.coroutines.channels.BufferedChannelKt.f57032o     // Catch:{ all -> 0x00d1 }
            r7 = 0
            if (r1 != r10) goto L_0x00b3
            long r1 = r8.Z()     // Catch:{ all -> 0x00d1 }
            int r10 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x002e
            r9.b()     // Catch:{ all -> 0x00d1 }
        L_0x002e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r9 = f57006j     // Catch:{ all -> 0x00d1 }
            java.lang.Object r9 = r9.get(r8)     // Catch:{ all -> 0x00d1 }
            kotlinx.coroutines.channels.g r9 = (kotlinx.coroutines.channels.g) r9     // Catch:{ all -> 0x00d1 }
        L_0x0038:
            boolean r10 = r8.g0()     // Catch:{ all -> 0x00d1 }
            if (r10 == 0) goto L_0x0043
            r8.s0(r0)     // Catch:{ all -> 0x00d1 }
            goto L_0x00c3
        L_0x0043:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r10 = f57002f     // Catch:{ all -> 0x00d1 }
            long r10 = r10.getAndIncrement(r8)     // Catch:{ all -> 0x00d1 }
            int r12 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b     // Catch:{ all -> 0x00d1 }
            long r1 = (long) r12     // Catch:{ all -> 0x00d1 }
            long r1 = r10 / r1
            long r3 = (long) r12     // Catch:{ all -> 0x00d1 }
            long r3 = r10 % r3
            int r12 = (int) r3     // Catch:{ all -> 0x00d1 }
            long r3 = r9.f57353d     // Catch:{ all -> 0x00d1 }
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0062
            kotlinx.coroutines.channels.g r1 = r8.S(r1, r9)     // Catch:{ all -> 0x00d1 }
            if (r1 != 0) goto L_0x0061
            goto L_0x0038
        L_0x0061:
            r9 = r1
        L_0x0062:
            r1 = r8
            r2 = r9
            r3 = r12
            r4 = r10
            r6 = r0
            java.lang.Object r1 = r1.Z0(r2, r3, r4, r6)     // Catch:{ all -> 0x00d1 }
            kotlinx.coroutines.internal.c0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.f57030m     // Catch:{ all -> 0x00d1 }
            if (r1 != r2) goto L_0x007c
            boolean r10 = r0 instanceof kotlinx.coroutines.q2     // Catch:{ all -> 0x00d1 }
            if (r10 == 0) goto L_0x0076
            r7 = r0
        L_0x0076:
            if (r7 == 0) goto L_0x00c3
            r8.z0(r7, r9, r12)     // Catch:{ all -> 0x00d1 }
            goto L_0x00c3
        L_0x007c:
            kotlinx.coroutines.internal.c0 r12 = kotlinx.coroutines.channels.BufferedChannelKt.f57032o     // Catch:{ all -> 0x00d1 }
            if (r1 != r12) goto L_0x008e
            long r1 = r8.Z()     // Catch:{ all -> 0x00d1 }
            int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x0038
            r9.b()     // Catch:{ all -> 0x00d1 }
            goto L_0x0038
        L_0x008e:
            kotlinx.coroutines.internal.c0 r10 = kotlinx.coroutines.channels.BufferedChannelKt.f57031n     // Catch:{ all -> 0x00d1 }
            if (r1 == r10) goto L_0x00a7
            r9.b()     // Catch:{ all -> 0x00d1 }
            d10.l<E, kotlin.Unit> r9 = r8.f57011c     // Catch:{ all -> 0x00d1 }
            if (r9 == 0) goto L_0x00a3
            kotlin.coroutines.CoroutineContext r10 = r0.getContext()     // Catch:{ all -> 0x00d1 }
            d10.l r7 = kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r9, r1, r10)     // Catch:{ all -> 0x00d1 }
        L_0x00a3:
            r0.h(r1, r7)     // Catch:{ all -> 0x00d1 }
            goto L_0x00c3
        L_0x00a7:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00d1 }
            java.lang.String r10 = "unexpected"
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00d1 }
            r9.<init>(r10)     // Catch:{ all -> 0x00d1 }
            throw r9     // Catch:{ all -> 0x00d1 }
        L_0x00b3:
            r9.b()     // Catch:{ all -> 0x00d1 }
            d10.l<E, kotlin.Unit> r9 = r8.f57011c     // Catch:{ all -> 0x00d1 }
            if (r9 == 0) goto L_0x00a3
            kotlin.coroutines.CoroutineContext r10 = r0.getContext()     // Catch:{ all -> 0x00d1 }
            d10.l r7 = kotlinx.coroutines.internal.OnUndeliveredElementKt.a(r9, r1, r10)     // Catch:{ all -> 0x00d1 }
            goto L_0x00a3
        L_0x00c3:
            java.lang.Object r9 = r0.v()
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r9 != r10) goto L_0x00d0
            kotlin.coroutines.jvm.internal.f.c(r13)
        L_0x00d0:
            return r9
        L_0x00d1:
            r9 = move-exception
            r0.L()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.I0(kotlinx.coroutines.channels.g, int, long, kotlin.coroutines.c):java.lang.Object");
    }

    public Object J(c<? super E> cVar) {
        return F0(this, cVar);
    }

    public final void J0(k<?> kVar, Object obj) {
        g gVar = (g) f57006j.get(this);
        while (!g0()) {
            long andIncrement = f57002f.getAndIncrement(this);
            int i11 = BufferedChannelKt.f57019b;
            long j11 = andIncrement / ((long) i11);
            int i12 = (int) (andIncrement % ((long) i11));
            if (gVar.f57353d != j11) {
                g a11 = S(j11, gVar);
                if (a11 == null) {
                    continue;
                } else {
                    gVar = a11;
                }
            }
            Object B = Z0(gVar, i12, andIncrement, kVar);
            if (B == BufferedChannelKt.f57030m) {
                q2 q2Var = kVar instanceof q2 ? (q2) kVar : null;
                if (q2Var != null) {
                    z0(q2Var, gVar, i12);
                    return;
                }
                return;
            } else if (B == BufferedChannelKt.f57032o) {
                if (andIncrement < Z()) {
                    gVar.b();
                }
            } else if (B != BufferedChannelKt.f57031n) {
                gVar.b();
                kVar.d(B);
                return;
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        t0(kVar);
    }

    public boolean K(Throwable th2) {
        return L(th2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0088, code lost:
        r14.d(kotlin.Unit.f56620a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K0(kotlinx.coroutines.selects.k<?> r14, java.lang.Object r15) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f57005i
            java.lang.Object r0 = r0.get(r13)
            kotlinx.coroutines.channels.g r0 = (kotlinx.coroutines.channels.g) r0
        L_0x000a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f57001e
            long r1 = r1.getAndIncrement(r13)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r3 = r3 & r1
            boolean r1 = r13.i0(r1)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r5 = (long) r2
            long r5 = r3 / r5
            long r7 = (long) r2
            long r7 = r3 % r7
            int r2 = (int) r7
            long r7 = r0.f57353d
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0035
            kotlinx.coroutines.channels.g r5 = r13.T(r5, r0)
            if (r5 != 0) goto L_0x0034
            if (r1 == 0) goto L_0x000a
            goto L_0x0073
        L_0x0034:
            r0 = r5
        L_0x0035:
            r5 = r13
            r6 = r0
            r7 = r2
            r8 = r15
            r9 = r3
            r11 = r14
            r12 = r1
            int r5 = r5.b1(r6, r7, r8, r9, r11, r12)
            if (r5 == 0) goto L_0x0085
            r6 = 1
            if (r5 == r6) goto L_0x0088
            r6 = 2
            if (r5 == r6) goto L_0x006e
            r1 = 3
            if (r5 == r1) goto L_0x0062
            r1 = 4
            if (r5 == r1) goto L_0x0056
            r1 = 5
            if (r5 == r1) goto L_0x0052
            goto L_0x000a
        L_0x0052:
            r0.b()
            goto L_0x000a
        L_0x0056:
            long r1 = r13.X()
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0073
            r0.b()
            goto L_0x0073
        L_0x0062:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x006e:
            if (r1 == 0) goto L_0x0077
            r0.p()
        L_0x0073:
            r13.u0(r15, r14)
            goto L_0x008d
        L_0x0077:
            boolean r15 = r14 instanceof kotlinx.coroutines.q2
            if (r15 == 0) goto L_0x007e
            kotlinx.coroutines.q2 r14 = (kotlinx.coroutines.q2) r14
            goto L_0x007f
        L_0x007e:
            r14 = 0
        L_0x007f:
            if (r14 == 0) goto L_0x008d
            r13.A0(r14, r0, r2)
            goto L_0x008d
        L_0x0085:
            r0.b()
        L_0x0088:
            kotlin.Unit r15 = kotlin.Unit.f56620a
            r14.d(r15)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.K0(kotlinx.coroutines.selects.k, java.lang.Object):void");
    }

    public boolean L(Throwable th2, boolean z11) {
        if (z11) {
            m0();
        }
        boolean a11 = androidx.concurrent.futures.a.a(f57008l, this, BufferedChannelKt.f57036s, th2);
        if (z11) {
            n0();
        } else {
            o0();
        }
        O();
        q0();
        if (a11) {
            d0();
        }
        return a11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b3, code lost:
        r12 = (kotlinx.coroutines.channels.g) r12.g();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void L0(kotlinx.coroutines.channels.g<E> r12) {
        /*
            r11 = this;
            d10.l<E, kotlin.Unit> r0 = r11.f57011c
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.m.b(r1, r2, r1)
        L_0x0008:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            int r4 = r4 - r2
        L_0x000b:
            r5 = -1
            if (r5 >= r4) goto L_0x00b3
            long r6 = r12.f57353d
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L_0x0016:
            java.lang.Object r8 = r12.w(r4)
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.f57026i
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.f57021d
            if (r8 != r9) goto L_0x0048
            long r9 = r11.X()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0040
            java.lang.Object r5 = r12.v(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.c(r0, r5, r1)
        L_0x0040:
            r12.s(r4)
            r12.p()
            goto L_0x00af
        L_0x0048:
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.f57022e
            if (r8 == r9) goto L_0x00a2
            if (r8 != 0) goto L_0x0051
            goto L_0x00a2
        L_0x0051:
            boolean r9 = r8 instanceof kotlinx.coroutines.q2
            if (r9 != 0) goto L_0x006e
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.n
            if (r9 == 0) goto L_0x005a
            goto L_0x006e
        L_0x005a:
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.f57024g
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.f57023f
            if (r8 != r9) goto L_0x0067
            goto L_0x00bb
        L_0x0067:
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.f57024g
            if (r8 == r9) goto L_0x0016
            goto L_0x00af
        L_0x006e:
            long r9 = r11.X()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.n
            if (r9 == 0) goto L_0x0080
            r9 = r8
            kotlinx.coroutines.channels.n r9 = (kotlinx.coroutines.channels.n) r9
            kotlinx.coroutines.q2 r9 = r9.f57054a
            goto L_0x0083
        L_0x0080:
            r9 = r8
            kotlinx.coroutines.q2 r9 = (kotlinx.coroutines.q2) r9
        L_0x0083:
            kotlinx.coroutines.internal.c0 r10 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.r(r4, r8, r10)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0097
            java.lang.Object r5 = r12.v(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.c(r0, r5, r1)
        L_0x0097:
            java.lang.Object r3 = kotlinx.coroutines.internal.m.c(r3, r9)
            r12.s(r4)
            r12.p()
            goto L_0x00af
        L_0x00a2:
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            r12.p()
        L_0x00af:
            int r4 = r4 + -1
            goto L_0x000b
        L_0x00b3:
            kotlinx.coroutines.internal.e r12 = r12.g()
            kotlinx.coroutines.channels.g r12 = (kotlinx.coroutines.channels.g) r12
            if (r12 != 0) goto L_0x0008
        L_0x00bb:
            if (r3 == 0) goto L_0x00dc
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto L_0x00c7
            kotlinx.coroutines.q2 r3 = (kotlinx.coroutines.q2) r3
            r11.N0(r3)
            goto L_0x00dc
        L_0x00c7:
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        L_0x00ce:
            if (r5 >= r12) goto L_0x00dc
            java.lang.Object r0 = r3.get(r12)
            kotlinx.coroutines.q2 r0 = (kotlinx.coroutines.q2) r0
            r11.N0(r0)
            int r12 = r12 + -1
            goto L_0x00ce
        L_0x00dc:
            if (r1 != 0) goto L_0x00df
            return
        L_0x00df:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.L0(kotlinx.coroutines.channels.g):void");
    }

    public final void M(long j11) {
        L0(N(j11));
    }

    public final void M0(q2 q2Var) {
        O0(q2Var, true);
    }

    public final g<E> N(long j11) {
        g<E> I = I();
        if (j0()) {
            long l02 = l0(I);
            if (l02 != -1) {
                P(l02);
            }
        }
        F(I, j11);
        return I;
    }

    public final void N0(q2 q2Var) {
        O0(q2Var, false);
    }

    public final void O() {
        u();
    }

    public final void O0(q2 q2Var, boolean z11) {
        if (q2Var instanceof b) {
            kotlinx.coroutines.k<Boolean> a11 = ((b) q2Var).a();
            Result.a aVar = Result.Companion;
            a11.resumeWith(Result.m3072constructorimpl(Boolean.FALSE));
        } else if (q2Var instanceof kotlinx.coroutines.k) {
            c cVar = (c) q2Var;
            Result.a aVar2 = Result.Companion;
            cVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(z11 ? W() : Y())));
        } else if (q2Var instanceof l) {
            kotlinx.coroutines.l<ChannelResult<? extends E>> lVar = ((l) q2Var).f57053b;
            Result.a aVar3 = Result.Companion;
            lVar.resumeWith(Result.m3072constructorimpl(ChannelResult.b(ChannelResult.f57037b.a(V()))));
        } else if (q2Var instanceof a) {
            ((a) q2Var).j();
        } else if (q2Var instanceof k) {
            ((k) q2Var).f(this, BufferedChannelKt.z());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + q2Var).toString());
        }
    }

    public final void P(long j11) {
        UndeliveredElementException d11;
        if (!j0.a() || j0()) {
            g gVar = (g) f57006j.get(this);
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = f57002f;
                long j12 = atomicLongFieldUpdater.get(this);
                if (j11 >= Math.max(((long) this.f57010b) + j12, U())) {
                    if (atomicLongFieldUpdater.compareAndSet(this, j12, j12 + 1)) {
                        int i11 = BufferedChannelKt.f57019b;
                        long j13 = j12 / ((long) i11);
                        int i12 = (int) (j12 % ((long) i11));
                        if (gVar.f57353d != j13) {
                            g S = S(j13, gVar);
                            if (S == null) {
                                continue;
                            } else {
                                gVar = S;
                            }
                        }
                        Object Z0 = Z0(gVar, i12, j12, (Object) null);
                        if (Z0 != BufferedChannelKt.f57032o) {
                            gVar.b();
                            l<E, Unit> lVar = this.f57011c;
                            if (!(lVar == null || (d11 = OnUndeliveredElementKt.d(lVar, Z0, (UndeliveredElementException) null, 2, (Object) null)) == null)) {
                                throw d11;
                            }
                        } else if (j12 < Z()) {
                            gVar.b();
                        }
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    public final void Q() {
        if (!k0()) {
            g gVar = (g) f57007k.get(this);
            while (true) {
                long andIncrement = f57003g.getAndIncrement(this);
                int i11 = BufferedChannelKt.f57019b;
                long j11 = andIncrement / ((long) i11);
                if (Z() <= andIncrement) {
                    if (gVar.f57353d < j11 && gVar.e() != null) {
                        p0(j11, gVar);
                    }
                    c0(this, 0, 1, (Object) null);
                    return;
                }
                if (gVar.f57353d != j11) {
                    g R = R(j11, gVar, andIncrement);
                    if (R == null) {
                        continue;
                    } else {
                        gVar = R;
                    }
                }
                if (X0(gVar, (int) (andIncrement % ((long) i11)), andIncrement)) {
                    c0(this, 0, 1, (Object) null);
                    return;
                }
                c0(this, 0, 1, (Object) null);
            }
        }
    }

    public Object Q0(E e11, c<? super Boolean> cVar) {
        return R0(this, e11, cVar);
    }

    public final g<E> R(long j11, g<E> gVar, long j12) {
        Object c11;
        boolean z11;
        boolean z12;
        long j13 = j11;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57007k;
        p pVar = (p) BufferedChannelKt.y();
        g<E> gVar2 = gVar;
        do {
            c11 = d.c(gVar2, j13, pVar);
            z11 = false;
            if (a0.c(c11)) {
                break;
            }
            z b11 = a0.b(c11);
            while (true) {
                z zVar = (z) atomicReferenceFieldUpdater.get(this);
                if (zVar.f57353d >= b11.f57353d) {
                    break;
                } else if (!b11.q()) {
                    z12 = false;
                    continue;
                    break;
                } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, b11)) {
                    if (zVar.m()) {
                        zVar.k();
                    }
                } else if (b11.m()) {
                    b11.k();
                }
            }
            z12 = true;
            continue;
        } while (!z12);
        if (a0.c(c11)) {
            O();
            p0(j11, gVar);
            c0(this, 0, 1, (Object) null);
            return null;
        }
        g<E> gVar3 = (g) a0.b(c11);
        long j14 = gVar3.f57353d;
        if (j14 > j13) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f57003g;
            int i11 = BufferedChannelKt.f57019b;
            if (atomicLongFieldUpdater.compareAndSet(this, j12 + 1, ((long) i11) * j14)) {
                b0((gVar3.f57353d * ((long) i11)) - j12);
                return null;
            }
            c0(this, 0, 1, (Object) null);
            return null;
        }
        if (j0.a()) {
            if (gVar3.f57353d == j13) {
                z11 = true;
            }
            if (!z11) {
                throw new AssertionError();
            }
        }
        return gVar3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0040, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        r3 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.channels.g<E> S(long r12, kotlinx.coroutines.channels.g<E> r14) {
        /*
            r11 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f57006j
            kotlin.reflect.g r1 = kotlinx.coroutines.channels.BufferedChannelKt.y()
            d10.p r1 = (d10.p) r1
        L_0x0008:
            java.lang.Object r2 = kotlinx.coroutines.internal.d.c(r14, r12, r1)
            boolean r3 = kotlinx.coroutines.internal.a0.c(r2)
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x004d
            kotlinx.coroutines.internal.z r3 = kotlinx.coroutines.internal.a0.b(r2)
        L_0x0018:
            java.lang.Object r6 = r0.get(r11)
            kotlinx.coroutines.internal.z r6 = (kotlinx.coroutines.internal.z) r6
            long r7 = r6.f57353d
            long r9 = r3.f57353d
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x0028
        L_0x0026:
            r3 = r5
            goto L_0x0040
        L_0x0028:
            boolean r7 = r3.q()
            if (r7 != 0) goto L_0x0030
            r3 = r4
            goto L_0x0040
        L_0x0030:
            boolean r7 = androidx.concurrent.futures.a.a(r0, r11, r6, r3)
            if (r7 == 0) goto L_0x0043
            boolean r3 = r6.m()
            if (r3 == 0) goto L_0x0026
            r6.k()
            goto L_0x0026
        L_0x0040:
            if (r3 == 0) goto L_0x0008
            goto L_0x004d
        L_0x0043:
            boolean r6 = r3.m()
            if (r6 == 0) goto L_0x0018
            r3.k()
            goto L_0x0018
        L_0x004d:
            boolean r0 = kotlinx.coroutines.internal.a0.c(r2)
            r1 = 0
            if (r0 == 0) goto L_0x006a
            r11.O()
            long r12 = r14.f57353d
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r2 = (long) r0
            long r12 = r12 * r2
            long r2 = r11.Z()
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x00e6
            r14.b()
            goto L_0x00e6
        L_0x006a:
            kotlinx.coroutines.internal.z r14 = kotlinx.coroutines.internal.a0.b(r2)
            kotlinx.coroutines.channels.g r14 = (kotlinx.coroutines.channels.g) r14
            boolean r0 = r11.k0()
            if (r0 != 0) goto L_0x00b2
            long r2 = r11.U()
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r6 = (long) r0
            long r2 = r2 / r6
            int r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x00b2
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f57007k
        L_0x0084:
            java.lang.Object r2 = r0.get(r11)
            kotlinx.coroutines.internal.z r2 = (kotlinx.coroutines.internal.z) r2
            long r6 = r2.f57353d
            long r8 = r14.f57353d
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x00b2
            boolean r3 = r14.q()
            if (r3 == 0) goto L_0x00b2
            boolean r3 = androidx.concurrent.futures.a.a(r0, r11, r2, r14)
            if (r3 == 0) goto L_0x00a8
            boolean r0 = r2.m()
            if (r0 == 0) goto L_0x00b2
            r2.k()
            goto L_0x00b2
        L_0x00a8:
            boolean r2 = r14.m()
            if (r2 == 0) goto L_0x0084
            r14.k()
            goto L_0x0084
        L_0x00b2:
            long r2 = r14.f57353d
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x00cf
            int r12 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r4 = (long) r12
            long r2 = r2 * r4
            r11.d1(r2)
            long r2 = r14.f57353d
            long r12 = (long) r12
            long r2 = r2 * r12
            long r12 = r11.Z()
            int r12 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x00e6
            r14.b()
            goto L_0x00e6
        L_0x00cf:
            boolean r0 = kotlinx.coroutines.j0.a()
            if (r0 == 0) goto L_0x00e5
            long r0 = r14.f57353d
            int r12 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r12 != 0) goto L_0x00dc
            r4 = r5
        L_0x00dc:
            if (r4 == 0) goto L_0x00df
            goto L_0x00e5
        L_0x00df:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x00e5:
            r1 = r14
        L_0x00e6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.S(long, kotlinx.coroutines.channels.g):kotlinx.coroutines.channels.g");
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0122 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object S0(kotlinx.coroutines.channels.g<E> r21, int r22, E r23, long r24, kotlin.coroutines.c<? super kotlin.Unit> r26) {
        /*
            r20 = this;
            r9 = r20
            r0 = r23
            kotlin.coroutines.c r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r26)
            kotlinx.coroutines.l r10 = kotlinx.coroutines.n.b(r1)
            r8 = 0
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r7 = r10
            int r1 = r1.b1(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0126 }
            if (r1 == 0) goto L_0x0101
            r11 = 1
            if (r1 == r11) goto L_0x00f8
            r12 = 2
            if (r1 == r12) goto L_0x00f0
            r13 = 4
            if (r1 == r13) goto L_0x00e3
            java.lang.String r14 = "unexpected"
            r15 = 5
            if (r1 != r15) goto L_0x00d9
            r21.b()     // Catch:{ all -> 0x0126 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f57005i     // Catch:{ all -> 0x0126 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ all -> 0x0126 }
            kotlinx.coroutines.channels.g r1 = (kotlinx.coroutines.channels.g) r1     // Catch:{ all -> 0x0126 }
        L_0x0039:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f57001e     // Catch:{ all -> 0x0126 }
            long r2 = r2.getAndIncrement(r9)     // Catch:{ all -> 0x0126 }
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r16 = r2 & r4
            boolean r18 = r9.i0(r2)     // Catch:{ all -> 0x0126 }
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b     // Catch:{ all -> 0x0126 }
            long r3 = (long) r2     // Catch:{ all -> 0x0126 }
            long r3 = r16 / r3
            long r5 = (long) r2     // Catch:{ all -> 0x0126 }
            long r5 = r16 % r5
            int r8 = (int) r5     // Catch:{ all -> 0x0126 }
            long r5 = r1.f57353d     // Catch:{ all -> 0x0126 }
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x006a
            kotlinx.coroutines.channels.g r2 = r9.T(r3, r1)     // Catch:{ all -> 0x0126 }
            if (r2 != 0) goto L_0x0068
            if (r18 == 0) goto L_0x0039
        L_0x0063:
            r9.w0(r0, r10)     // Catch:{ all -> 0x0126 }
            goto L_0x010f
        L_0x0068:
            r7 = r2
            goto L_0x006b
        L_0x006a:
            r7 = r1
        L_0x006b:
            r1 = r20
            r2 = r7
            r3 = r8
            r4 = r23
            r5 = r16
            r21 = r7
            r7 = r10
            r19 = r8
            r8 = r18
            int r1 = r1.b1(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0126 }
            if (r1 == 0) goto L_0x00cb
            if (r1 == r11) goto L_0x00bf
            if (r1 == r12) goto L_0x00a8
            r2 = 3
            if (r1 == r2) goto L_0x009e
            if (r1 == r13) goto L_0x0092
            if (r1 == r15) goto L_0x008c
            goto L_0x008f
        L_0x008c:
            r21.b()     // Catch:{ all -> 0x0126 }
        L_0x008f:
            r1 = r21
            goto L_0x0039
        L_0x0092:
            long r1 = r20.X()     // Catch:{ all -> 0x0126 }
            int r1 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0063
            r21.b()     // Catch:{ all -> 0x0126 }
            goto L_0x0063
        L_0x009e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0126 }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x0126 }
            r0.<init>(r1)     // Catch:{ all -> 0x0126 }
            throw r0     // Catch:{ all -> 0x0126 }
        L_0x00a8:
            if (r18 == 0) goto L_0x00ae
            r21.p()     // Catch:{ all -> 0x0126 }
            goto L_0x0063
        L_0x00ae:
            boolean r0 = r10 instanceof kotlinx.coroutines.q2     // Catch:{ all -> 0x0126 }
            if (r0 == 0) goto L_0x00b4
            r0 = r10
            goto L_0x00b5
        L_0x00b4:
            r0 = 0
        L_0x00b5:
            if (r0 == 0) goto L_0x010f
            r2 = r21
            r1 = r19
            r9.A0(r0, r2, r1)     // Catch:{ all -> 0x0126 }
            goto L_0x010f
        L_0x00bf:
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0126 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0126 }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ all -> 0x0126 }
        L_0x00c7:
            r10.resumeWith(r0)     // Catch:{ all -> 0x0126 }
            goto L_0x010f
        L_0x00cb:
            r2 = r21
            r2.b()     // Catch:{ all -> 0x0126 }
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0126 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0126 }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ all -> 0x0126 }
            goto L_0x00c7
        L_0x00d9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0126 }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x0126 }
            r0.<init>(r1)     // Catch:{ all -> 0x0126 }
            throw r0     // Catch:{ all -> 0x0126 }
        L_0x00e3:
            long r1 = r20.X()     // Catch:{ all -> 0x0126 }
            int r1 = (r24 > r1 ? 1 : (r24 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0063
            r21.b()     // Catch:{ all -> 0x0126 }
            goto L_0x0063
        L_0x00f0:
            r0 = r21
            r1 = r22
            r9.A0(r10, r0, r1)     // Catch:{ all -> 0x0126 }
            goto L_0x010f
        L_0x00f8:
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0126 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0126 }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ all -> 0x0126 }
            goto L_0x00c7
        L_0x0101:
            r0 = r21
            r21.b()     // Catch:{ all -> 0x0126 }
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0126 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0126 }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ all -> 0x0126 }
            goto L_0x00c7
        L_0x010f:
            java.lang.Object r0 = r10.v()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r0 != r1) goto L_0x011c
            kotlin.coroutines.jvm.internal.f.c(r26)
        L_0x011c:
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r0 != r1) goto L_0x0123
            return r0
        L_0x0123:
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        L_0x0126:
            r0 = move-exception
            r10.L()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.S0(kotlinx.coroutines.channels.g, int, java.lang.Object, long, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0040, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        r3 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.channels.g<E> T(long r12, kotlinx.coroutines.channels.g<E> r14) {
        /*
            r11 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f57005i
            kotlin.reflect.g r1 = kotlinx.coroutines.channels.BufferedChannelKt.y()
            d10.p r1 = (d10.p) r1
        L_0x0008:
            java.lang.Object r2 = kotlinx.coroutines.internal.d.c(r14, r12, r1)
            boolean r3 = kotlinx.coroutines.internal.a0.c(r2)
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x004d
            kotlinx.coroutines.internal.z r3 = kotlinx.coroutines.internal.a0.b(r2)
        L_0x0018:
            java.lang.Object r6 = r0.get(r11)
            kotlinx.coroutines.internal.z r6 = (kotlinx.coroutines.internal.z) r6
            long r7 = r6.f57353d
            long r9 = r3.f57353d
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x0028
        L_0x0026:
            r3 = r5
            goto L_0x0040
        L_0x0028:
            boolean r7 = r3.q()
            if (r7 != 0) goto L_0x0030
            r3 = r4
            goto L_0x0040
        L_0x0030:
            boolean r7 = androidx.concurrent.futures.a.a(r0, r11, r6, r3)
            if (r7 == 0) goto L_0x0043
            boolean r3 = r6.m()
            if (r3 == 0) goto L_0x0026
            r6.k()
            goto L_0x0026
        L_0x0040:
            if (r3 == 0) goto L_0x0008
            goto L_0x004d
        L_0x0043:
            boolean r6 = r3.m()
            if (r6 == 0) goto L_0x0018
            r3.k()
            goto L_0x0018
        L_0x004d:
            boolean r0 = kotlinx.coroutines.internal.a0.c(r2)
            r1 = 0
            if (r0 == 0) goto L_0x0069
            r11.O()
            long r12 = r14.f57353d
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r2 = (long) r0
            long r12 = r12 * r2
            long r2 = r11.X()
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x00a3
            r14.b()
            goto L_0x00a3
        L_0x0069:
            kotlinx.coroutines.internal.z r14 = kotlinx.coroutines.internal.a0.b(r2)
            kotlinx.coroutines.channels.g r14 = (kotlinx.coroutines.channels.g) r14
            long r2 = r14.f57353d
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x008c
            int r12 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r4 = (long) r12
            long r2 = r2 * r4
            r11.e1(r2)
            long r2 = r14.f57353d
            long r12 = (long) r12
            long r2 = r2 * r12
            long r12 = r11.X()
            int r12 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x00a3
            r14.b()
            goto L_0x00a3
        L_0x008c:
            boolean r0 = kotlinx.coroutines.j0.a()
            if (r0 == 0) goto L_0x00a2
            long r0 = r14.f57353d
            int r12 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r12 != 0) goto L_0x0099
            r4 = r5
        L_0x0099:
            if (r4 == 0) goto L_0x009c
            goto L_0x00a2
        L_0x009c:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x00a2:
            r1 = r14
        L_0x00a3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.T(long, kotlinx.coroutines.channels.g):kotlinx.coroutines.channels.g");
    }

    public final boolean T0(long j11) {
        if (i0(j11)) {
            return false;
        }
        return !D(j11 & 1152921504606846975L);
    }

    public final long U() {
        return f57003g.get(this);
    }

    public boolean U0() {
        return T0(f57001e.get(this));
    }

    public final Throwable V() {
        return (Throwable) f57008l.get(this);
    }

    public final boolean V0(Object obj, E e11) {
        if (obj instanceof k) {
            return ((k) obj).f(this, e11);
        }
        l<Throwable, Unit> lVar = null;
        if (obj instanceof l) {
            l lVar2 = (l) obj;
            kotlinx.coroutines.l<ChannelResult<? extends E>> lVar3 = lVar2.f57053b;
            ChannelResult b11 = ChannelResult.b(ChannelResult.f57037b.c(e11));
            l<E, Unit> lVar4 = this.f57011c;
            if (lVar4 != null) {
                lVar = OnUndeliveredElementKt.a(lVar4, e11, lVar2.f57053b.getContext());
            }
            return BufferedChannelKt.B(lVar3, b11, lVar);
        } else if (obj instanceof a) {
            return ((a) obj).i(e11);
        } else {
            if (obj instanceof kotlinx.coroutines.k) {
                kotlinx.coroutines.k kVar = (kotlinx.coroutines.k) obj;
                l<E, Unit> lVar5 = this.f57011c;
                if (lVar5 != null) {
                    lVar = OnUndeliveredElementKt.a(lVar5, e11, kVar.getContext());
                }
                return BufferedChannelKt.B(kVar, e11, lVar);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    public final Throwable W() {
        Throwable V = V();
        return V == null ? new ClosedReceiveChannelException("Channel was closed") : V;
    }

    public final boolean W0(Object obj, g<E> gVar, int i11) {
        if (obj instanceof kotlinx.coroutines.k) {
            return BufferedChannelKt.C((kotlinx.coroutines.k) obj, Unit.f56620a, (l) null, 2, (Object) null);
        }
        if (obj instanceof k) {
            TrySelectDetailedResult C = ((SelectImplementation) obj).C(this, Unit.f56620a);
            if (C == TrySelectDetailedResult.REREGISTER) {
                gVar.s(i11);
            }
            return C == TrySelectDetailedResult.SUCCESSFUL;
        } else if (obj instanceof b) {
            return BufferedChannelKt.C(((b) obj).a(), Boolean.TRUE, (l) null, 2, (Object) null);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    public final long X() {
        return f57002f.get(this);
    }

    public final boolean X0(g<E> gVar, int i11, long j11) {
        Object w11 = gVar.w(i11);
        if (!(w11 instanceof q2) || j11 < f57002f.get(this) || !gVar.r(i11, w11, BufferedChannelKt.f57024g)) {
            return Y0(gVar, i11, j11);
        }
        if (W0(w11, gVar, i11)) {
            gVar.A(i11, BufferedChannelKt.f57021d);
            return true;
        }
        gVar.A(i11, BufferedChannelKt.f57027j);
        gVar.x(i11, false);
        return false;
    }

    public final Throwable Y() {
        Throwable V = V();
        return V == null ? new ClosedSendChannelException("Channel was closed") : V;
    }

    public final boolean Y0(g<E> gVar, int i11, long j11) {
        while (true) {
            Object w11 = gVar.w(i11);
            if (w11 instanceof q2) {
                if (j11 < f57002f.get(this)) {
                    if (gVar.r(i11, w11, new n((q2) w11))) {
                        return true;
                    }
                } else if (gVar.r(i11, w11, BufferedChannelKt.f57024g)) {
                    if (W0(w11, gVar, i11)) {
                        gVar.A(i11, BufferedChannelKt.f57021d);
                        return true;
                    }
                    gVar.A(i11, BufferedChannelKt.f57027j);
                    gVar.x(i11, false);
                    return false;
                }
            } else if (w11 == BufferedChannelKt.f57027j) {
                return false;
            } else {
                if (w11 == null) {
                    if (gVar.r(i11, w11, BufferedChannelKt.f57022e)) {
                        return true;
                    }
                } else if (w11 == BufferedChannelKt.f57021d || w11 == BufferedChannelKt.f57025h || w11 == BufferedChannelKt.f57026i || w11 == BufferedChannelKt.f57028k || w11 == BufferedChannelKt.z()) {
                    return true;
                } else {
                    if (w11 != BufferedChannelKt.f57023f) {
                        throw new IllegalStateException(("Unexpected cell state: " + w11).toString());
                    }
                }
            }
        }
        return true;
    }

    public final long Z() {
        return f57001e.get(this) & 1152921504606846975L;
    }

    public final Object Z0(g<E> gVar, int i11, long j11, Object obj) {
        Object w11 = gVar.w(i11);
        if (w11 == null) {
            if (j11 >= (f57001e.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.f57031n;
                }
                if (gVar.r(i11, w11, obj)) {
                    Q();
                    return BufferedChannelKt.f57030m;
                }
            }
        } else if (w11 == BufferedChannelKt.f57021d && gVar.r(i11, w11, BufferedChannelKt.f57026i)) {
            Q();
            return gVar.y(i11);
        }
        return a1(gVar, i11, j11, obj);
    }

    public final boolean a0() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57006j;
            g gVar = (g) atomicReferenceFieldUpdater.get(this);
            long X = X();
            if (Z() <= X) {
                return false;
            }
            int i11 = BufferedChannelKt.f57019b;
            long j11 = X / ((long) i11);
            if (gVar.f57353d == j11 || (gVar = S(j11, gVar)) != null) {
                gVar.b();
                if (e0(gVar, (int) (X % ((long) i11)), X)) {
                    return true;
                }
                f57002f.compareAndSet(this, X, X + 1);
            } else if (((g) atomicReferenceFieldUpdater.get(this)).f57353d < j11) {
                return false;
            }
        }
    }

    public final Object a1(g<E> gVar, int i11, long j11, Object obj) {
        while (true) {
            Object w11 = gVar.w(i11);
            if (w11 == null || w11 == BufferedChannelKt.f57022e) {
                if (j11 < (f57001e.get(this) & 1152921504606846975L)) {
                    if (gVar.r(i11, w11, BufferedChannelKt.f57025h)) {
                        Q();
                        return BufferedChannelKt.f57032o;
                    }
                } else if (obj == null) {
                    return BufferedChannelKt.f57031n;
                } else {
                    if (gVar.r(i11, w11, obj)) {
                        Q();
                        return BufferedChannelKt.f57030m;
                    }
                }
            } else if (w11 == BufferedChannelKt.f57021d) {
                if (gVar.r(i11, w11, BufferedChannelKt.f57026i)) {
                    Q();
                    return gVar.y(i11);
                }
            } else if (w11 == BufferedChannelKt.f57027j) {
                return BufferedChannelKt.f57032o;
            } else {
                if (w11 == BufferedChannelKt.f57025h) {
                    return BufferedChannelKt.f57032o;
                }
                if (w11 == BufferedChannelKt.z()) {
                    Q();
                    return BufferedChannelKt.f57032o;
                } else if (w11 != BufferedChannelKt.f57024g && gVar.r(i11, w11, BufferedChannelKt.f57023f)) {
                    boolean z11 = w11 instanceof n;
                    if (z11) {
                        w11 = ((n) w11).f57054a;
                    }
                    if (W0(w11, gVar, i11)) {
                        gVar.A(i11, BufferedChannelKt.f57026i);
                        Q();
                        return gVar.y(i11);
                    }
                    gVar.A(i11, BufferedChannelKt.f57027j);
                    gVar.x(i11, false);
                    if (z11) {
                        Q();
                    }
                    return BufferedChannelKt.f57032o;
                }
            }
        }
    }

    public final void b(CancellationException cancellationException) {
        E(cancellationException);
    }

    public final void b0(long j11) {
        boolean z11;
        if ((f57004h.addAndGet(this, j11) & 4611686018427387904L) != 0) {
            do {
                if ((f57004h.get(this) & 4611686018427387904L) != 0) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
            } while (z11);
        }
    }

    public final int b1(g<E> gVar, int i11, E e11, long j11, Object obj, boolean z11) {
        gVar.B(i11, e11);
        if (z11) {
            return c1(gVar, i11, e11, j11, obj, z11);
        }
        Object w11 = gVar.w(i11);
        if (w11 == null) {
            if (D(j11)) {
                if (gVar.r(i11, (Object) null, BufferedChannelKt.f57021d)) {
                    return 1;
                }
            } else if (obj == null) {
                return 3;
            } else {
                if (gVar.r(i11, (Object) null, obj)) {
                    return 2;
                }
            }
        } else if (w11 instanceof q2) {
            gVar.s(i11);
            if (V0(w11, e11)) {
                gVar.A(i11, BufferedChannelKt.f57026i);
                x0();
                return 0;
            }
            if (gVar.t(i11, BufferedChannelKt.f57028k) != BufferedChannelKt.f57028k) {
                gVar.x(i11, true);
            }
            return 5;
        }
        return c1(gVar, i11, e11, j11, obj, z11);
    }

    public final int c1(g<E> gVar, int i11, E e11, long j11, Object obj, boolean z11) {
        while (true) {
            Object w11 = gVar.w(i11);
            if (w11 == null) {
                if (!D(j11) || z11) {
                    if (z11) {
                        if (gVar.r(i11, (Object) null, BufferedChannelKt.f57027j)) {
                            gVar.x(i11, false);
                            return 4;
                        }
                    } else if (obj == null) {
                        return 3;
                    } else {
                        if (gVar.r(i11, (Object) null, obj)) {
                            return 2;
                        }
                    }
                } else if (gVar.r(i11, (Object) null, BufferedChannelKt.f57021d)) {
                    return 1;
                }
            } else if (w11 == BufferedChannelKt.f57022e) {
                if (gVar.r(i11, w11, BufferedChannelKt.f57021d)) {
                    return 1;
                }
            } else if (w11 == BufferedChannelKt.f57028k) {
                gVar.s(i11);
                return 5;
            } else if (w11 == BufferedChannelKt.f57025h) {
                gVar.s(i11);
                return 5;
            } else if (w11 == BufferedChannelKt.z()) {
                gVar.s(i11);
                O();
                return 4;
            } else {
                if (j0.a()) {
                    if (!((w11 instanceof q2) || (w11 instanceof n))) {
                        throw new AssertionError();
                    }
                }
                gVar.s(i11);
                if (w11 instanceof n) {
                    w11 = ((n) w11).f57054a;
                }
                if (V0(w11, e11)) {
                    gVar.A(i11, BufferedChannelKt.f57026i);
                    x0();
                    return 0;
                }
                if (gVar.t(i11, BufferedChannelKt.f57028k) != BufferedChannelKt.f57028k) {
                    gVar.x(i11, true);
                }
                return 5;
            }
        }
    }

    public h<E, BufferedChannel<E>> d() {
        return new i(this, (q) TypeIntrinsics.e(BufferedChannel$onSend$1.INSTANCE, 3), (q) TypeIntrinsics.e(BufferedChannel$onSend$2.INSTANCE, 3), (q) null, 8, (r) null);
    }

    public final void d0() {
        Object obj;
        c0 c0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57009m;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                c0Var = BufferedChannelKt.f57034q;
            } else {
                c0Var = BufferedChannelKt.f57035r;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, c0Var));
        if (obj != null) {
            l lVar = (l) TypeIntrinsics.e(obj, 1);
            ((l) obj).invoke(V());
        }
    }

    public final void d1(long j11) {
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57002f;
        do {
            j12 = atomicLongFieldUpdater.get(this);
            if (j12 >= j11 || f57002f.compareAndSet(this, j12, j11)) {
            }
            j12 = atomicLongFieldUpdater.get(this);
            return;
        } while (f57002f.compareAndSet(this, j12, j11));
    }

    public final boolean e0(g<E> gVar, int i11, long j11) {
        Object w11;
        do {
            w11 = gVar.w(i11);
            if (w11 != null && w11 != BufferedChannelKt.f57022e) {
                if (w11 == BufferedChannelKt.f57021d) {
                    return true;
                }
                if (w11 == BufferedChannelKt.f57027j || w11 == BufferedChannelKt.z() || w11 == BufferedChannelKt.f57026i || w11 == BufferedChannelKt.f57025h) {
                    return false;
                }
                if (w11 == BufferedChannelKt.f57024g) {
                    return true;
                }
                if (w11 != BufferedChannelKt.f57023f && j11 == X()) {
                    return true;
                }
                return false;
            }
        } while (!gVar.r(i11, w11, BufferedChannelKt.f57025h));
        Q();
        return false;
    }

    public final void e1(long j11) {
        long j12;
        long j13;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57001e;
        do {
            j12 = atomicLongFieldUpdater.get(this);
            j13 = 1152921504606846975L & j12;
            if (j13 < j11) {
            } else {
                return;
            }
        } while (!f57001e.compareAndSet(this, j12, BufferedChannelKt.w(j13, (int) (j12 >> 60))));
    }

    public final boolean f0(long j11, boolean z11) {
        int i11 = (int) (j11 >> 60);
        if (i11 == 0 || i11 == 1) {
            return false;
        }
        if (i11 == 2) {
            N(j11 & 1152921504606846975L);
            if (z11 && a0()) {
                return false;
            }
        } else if (i11 == 3) {
            M(j11 & 1152921504606846975L);
        } else {
            throw new IllegalStateException(("unexpected close status: " + i11).toString());
        }
        return true;
    }

    public final void f1(long j11) {
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j13;
        if (!k0()) {
            do {
            } while (U() <= j11);
            int g11 = BufferedChannelKt.f57020c;
            int i11 = 0;
            while (i11 < g11) {
                long U = U();
                if (U != (4611686018427387903L & f57004h.get(this)) || U != U()) {
                    i11++;
                } else {
                    return;
                }
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f57004h;
            do {
                j12 = atomicLongFieldUpdater2.get(this);
            } while (!atomicLongFieldUpdater2.compareAndSet(this, j12, BufferedChannelKt.v(j12 & 4611686018427387903L, true)));
            while (true) {
                long U2 = U();
                atomicLongFieldUpdater = f57004h;
                long j14 = atomicLongFieldUpdater.get(this);
                long j15 = j14 & 4611686018427387903L;
                boolean z11 = (4611686018427387904L & j14) != 0;
                if (U2 == j15 && U2 == U()) {
                    break;
                } else if (!z11) {
                    atomicLongFieldUpdater.compareAndSet(this, j14, BufferedChannelKt.v(j15, true));
                }
            }
            do {
                j13 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j13, BufferedChannelKt.v(j13 & 4611686018427387903L, false)));
        }
    }

    public boolean g0() {
        return h0(f57001e.get(this));
    }

    public final boolean h0(long j11) {
        return f0(j11, true);
    }

    public final boolean i0(long j11) {
        return f0(j11, false);
    }

    public ChannelIterator<E> iterator() {
        return new a();
    }

    public boolean j0() {
        return false;
    }

    public final boolean k0() {
        long U = U();
        return U == 0 || U == Long.MAX_VALUE;
    }

    public final long l0(g<E> gVar) {
        do {
            int i11 = BufferedChannelKt.f57019b;
            while (true) {
                i11--;
                if (-1 < i11) {
                    long j11 = (gVar.f57353d * ((long) BufferedChannelKt.f57019b)) + ((long) i11);
                    if (j11 < X()) {
                        return -1;
                    }
                    while (true) {
                        Object w11 = gVar.w(i11);
                        if (w11 == null || w11 == BufferedChannelKt.f57022e) {
                            if (gVar.r(i11, w11, BufferedChannelKt.z())) {
                                gVar.p();
                                break;
                            }
                        } else if (w11 == BufferedChannelKt.f57021d) {
                            return j11;
                        }
                    }
                } else {
                    gVar = (g) gVar.g();
                }
            }
        } while (gVar != null);
        return -1;
    }

    public final void m0() {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57001e;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (((int) (j11 >> 60)) == 0) {
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, BufferedChannelKt.w(1152921504606846975L & j11, 1)));
    }

    public final void n0() {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57001e;
        do {
            j11 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, BufferedChannelKt.w(1152921504606846975L & j11, 3)));
    }

    public final void o0() {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57001e;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            int i11 = (int) (j11 >> 60);
            if (i11 == 0) {
                j12 = BufferedChannelKt.w(j11 & 1152921504606846975L, 2);
            } else if (i11 == 1) {
                j12 = BufferedChannelKt.w(j11 & 1152921504606846975L, 3);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, j12));
    }

    public final void p0(long j11, g<E> gVar) {
        boolean z11;
        g<E> gVar2;
        g<E> gVar3;
        while (gVar.f57353d < j11 && (gVar3 = (g) gVar.e()) != null) {
            gVar = gVar3;
        }
        while (true) {
            if (!gVar.h() || (gVar2 = (g) gVar.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57007k;
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    z11 = true;
                    if (zVar.f57353d >= gVar.f57353d) {
                        break;
                    } else if (!gVar.q()) {
                        z11 = false;
                        break;
                    } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, zVar, gVar)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (gVar.m()) {
                        gVar.k();
                    }
                }
                if (z11) {
                    return;
                }
            } else {
                gVar = gVar2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return kotlinx.coroutines.channels.ChannelResult.f57037b.a(Y());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object q(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f57001e
            long r0 = r0.get(r14)
            boolean r0 = r14.T0(r0)
            if (r0 == 0) goto L_0x0013
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.f57037b
            java.lang.Object r15 = r15.b()
            return r15
        L_0x0013:
            kotlinx.coroutines.internal.c0 r8 = kotlinx.coroutines.channels.BufferedChannelKt.f57027j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f57005i
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.g r0 = (kotlinx.coroutines.channels.g) r0
        L_0x0021:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f57001e
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = r14.i0(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.f57353d
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x004e
            kotlinx.coroutines.channels.g r1 = r14.T(r2, r0)
            if (r1 != 0) goto L_0x004c
            if (r11 == 0) goto L_0x0021
            goto L_0x008e
        L_0x004c:
            r13 = r1
            goto L_0x004f
        L_0x004e:
            r13 = r0
        L_0x004f:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = r0.b1(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00b0
            r1 = 1
            if (r0 == r1) goto L_0x00b3
            r1 = 2
            if (r0 == r1) goto L_0x0089
            r1 = 3
            if (r0 == r1) goto L_0x007d
            r1 = 4
            if (r0 == r1) goto L_0x0071
            r1 = 5
            if (r0 == r1) goto L_0x006c
            goto L_0x006f
        L_0x006c:
            r13.b()
        L_0x006f:
            r0 = r13
            goto L_0x0021
        L_0x0071:
            long r0 = r14.X()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L_0x008e
            r13.b()
            goto L_0x008e
        L_0x007d:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L_0x0089:
            if (r11 == 0) goto L_0x0099
            r13.p()
        L_0x008e:
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.f57037b
            java.lang.Throwable r0 = r14.Y()
            java.lang.Object r15 = r15.a(r0)
            goto L_0x00bb
        L_0x0099:
            boolean r15 = r8 instanceof kotlinx.coroutines.q2
            if (r15 == 0) goto L_0x00a0
            kotlinx.coroutines.q2 r8 = (kotlinx.coroutines.q2) r8
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r8 == 0) goto L_0x00a6
            r14.A0(r8, r13, r12)
        L_0x00a6:
            r13.p()
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.f57037b
            java.lang.Object r15 = r15.b()
            goto L_0x00bb
        L_0x00b0:
            r13.b()
        L_0x00b3:
            kotlinx.coroutines.channels.ChannelResult$b r15 = kotlinx.coroutines.channels.ChannelResult.f57037b
            kotlin.Unit r0 = kotlin.Unit.f56620a
            java.lang.Object r15 = r15.c(r0)
        L_0x00bb:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.q(java.lang.Object):java.lang.Object");
    }

    public void q0() {
    }

    public kotlinx.coroutines.selects.f<ChannelResult<E>> r() {
        return new g(this, (q) TypeIntrinsics.e(BufferedChannel$onReceiveCatching$1.INSTANCE, 3), (q) TypeIntrinsics.e(BufferedChannel$onReceiveCatching$2.INSTANCE, 3), this.f57012d);
    }

    public final void r0(kotlinx.coroutines.k<? super ChannelResult<? extends E>> kVar) {
        Result.a aVar = Result.Companion;
        kVar.resumeWith(Result.m3072constructorimpl(ChannelResult.b(ChannelResult.f57037b.a(V()))));
    }

    public Object s() {
        g gVar;
        long j11 = f57002f.get(this);
        long j12 = f57001e.get(this);
        if (h0(j12)) {
            return ChannelResult.f57037b.a(V());
        }
        if (j11 >= (j12 & 1152921504606846975L)) {
            return ChannelResult.f57037b.b();
        }
        c0 i11 = BufferedChannelKt.f57028k;
        g gVar2 = (g) f57006j.get(this);
        while (!g0()) {
            long andIncrement = f57002f.getAndIncrement(this);
            int i12 = BufferedChannelKt.f57019b;
            long j13 = andIncrement / ((long) i12);
            int i13 = (int) (andIncrement % ((long) i12));
            if (gVar2.f57353d != j13) {
                g a11 = S(j13, gVar2);
                if (a11 == null) {
                    continue;
                } else {
                    gVar = a11;
                }
            } else {
                gVar = gVar2;
            }
            Object B = Z0(gVar, i13, andIncrement, i11);
            if (B == BufferedChannelKt.f57030m) {
                q2 q2Var = i11 instanceof q2 ? (q2) i11 : null;
                if (q2Var != null) {
                    z0(q2Var, gVar, i13);
                }
                f1(andIncrement);
                gVar.p();
                return ChannelResult.f57037b.b();
            } else if (B == BufferedChannelKt.f57032o) {
                if (andIncrement < Z()) {
                    gVar.b();
                }
                gVar2 = gVar;
            } else if (B != BufferedChannelKt.f57031n) {
                gVar.b();
                return ChannelResult.f57037b.c(B);
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        return ChannelResult.f57037b.a(V());
    }

    public final void s0(kotlinx.coroutines.k<? super E> kVar) {
        Result.a aVar = Result.Companion;
        kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(W())));
    }

    public Object send(E e11, c<? super Unit> cVar) {
        return P0(this, e11, cVar);
    }

    public Object t(c<? super ChannelResult<? extends E>> cVar) {
        return G0(this, cVar);
    }

    public final void t0(k<?> kVar) {
        kVar.d(BufferedChannelKt.z());
    }

    /* JADX WARNING: type inference failed for: r2v12, types: [kotlinx.coroutines.internal.e] */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01df, code lost:
        r3 = r3.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01e6, code lost:
        if (r3 != null) goto L_0x0201;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r16 = this;
            r0 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = f57001e
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            r3 = 3
            r4 = 2
            if (r2 == r4) goto L_0x001e
            if (r2 == r3) goto L_0x0018
            goto L_0x0023
        L_0x0018:
            java.lang.String r2 = "cancelled,"
            r1.append(r2)
            goto L_0x0023
        L_0x001e:
            java.lang.String r2 = "closed,"
            r1.append(r2)
        L_0x0023:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "capacity="
            r2.append(r5)
            int r5 = r0.f57010b
            r2.append(r5)
            r5 = 44
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = "data=["
            r1.append(r2)
            kotlinx.coroutines.channels.g[] r2 = new kotlinx.coroutines.channels.g[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f57006j
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f57005i
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f57007k
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.n(r2)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x006c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0088
            java.lang.Object r4 = r2.next()
            r8 = r4
            kotlinx.coroutines.channels.g r8 = (kotlinx.coroutines.channels.g) r8
            kotlinx.coroutines.channels.g r9 = kotlinx.coroutines.channels.BufferedChannelKt.f57018a
            if (r8 == r9) goto L_0x0081
            r8 = r7
            goto L_0x0082
        L_0x0081:
            r8 = r6
        L_0x0082:
            if (r8 == 0) goto L_0x006c
            r3.add(r4)
            goto L_0x006c
        L_0x0088:
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0205
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x009d
            goto L_0x00b7
        L_0x009d:
            r4 = r3
            kotlinx.coroutines.channels.g r4 = (kotlinx.coroutines.channels.g) r4
            long r8 = r4.f57353d
        L_0x00a2:
            java.lang.Object r4 = r2.next()
            r10 = r4
            kotlinx.coroutines.channels.g r10 = (kotlinx.coroutines.channels.g) r10
            long r10 = r10.f57353d
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00b1
            r3 = r4
            r8 = r10
        L_0x00b1:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x00a2
        L_0x00b7:
            kotlinx.coroutines.channels.g r3 = (kotlinx.coroutines.channels.g) r3
            long r10 = r16.X()
            long r12 = r16.Z()
        L_0x00c1:
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            r4 = r6
        L_0x00c4:
            if (r4 >= r2) goto L_0x01df
            long r8 = r3.f57353d
            int r14 = kotlinx.coroutines.channels.BufferedChannelKt.f57019b
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00d6
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x01e8
        L_0x00d6:
            java.lang.Object r15 = r3.w(r4)
            java.lang.Object r6 = r3.v(r4)
            boolean r7 = r15 instanceof kotlinx.coroutines.k
            if (r7 == 0) goto L_0x00f8
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ec
            if (r14 < 0) goto L_0x00ec
            java.lang.String r7 = "receive"
            goto L_0x01a5
        L_0x00ec:
            if (r14 >= 0) goto L_0x00f4
            if (r7 < 0) goto L_0x00f4
            java.lang.String r7 = "send"
            goto L_0x01a5
        L_0x00f4:
            java.lang.String r7 = "cont"
            goto L_0x01a5
        L_0x00f8:
            boolean r7 = r15 instanceof kotlinx.coroutines.selects.k
            if (r7 == 0) goto L_0x0112
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0106
            if (r14 < 0) goto L_0x0106
            java.lang.String r7 = "onReceive"
            goto L_0x01a5
        L_0x0106:
            if (r14 >= 0) goto L_0x010e
            if (r7 < 0) goto L_0x010e
            java.lang.String r7 = "onSend"
            goto L_0x01a5
        L_0x010e:
            java.lang.String r7 = "select"
            goto L_0x01a5
        L_0x0112:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.l
            if (r7 == 0) goto L_0x011a
            java.lang.String r7 = "receiveCatching"
            goto L_0x01a5
        L_0x011a:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel.b
            if (r7 == 0) goto L_0x0122
            java.lang.String r7 = "sendBroadcast"
            goto L_0x01a5
        L_0x0122:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.n
            if (r7 == 0) goto L_0x013e
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "EB("
            r7.append(r8)
            r7.append(r15)
            r8 = 41
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x01a5
        L_0x013e:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.f57023f
            boolean r7 = kotlin.jvm.internal.x.b(r15, r7)
            if (r7 == 0) goto L_0x014a
            r7 = 1
            goto L_0x0152
        L_0x014a:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.f57024g
            boolean r7 = kotlin.jvm.internal.x.b(r15, r7)
        L_0x0152:
            if (r7 == 0) goto L_0x0157
            java.lang.String r7 = "resuming_sender"
            goto L_0x01a5
        L_0x0157:
            if (r15 != 0) goto L_0x015b
            r7 = 1
            goto L_0x0163
        L_0x015b:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.f57022e
            boolean r7 = kotlin.jvm.internal.x.b(r15, r7)
        L_0x0163:
            if (r7 == 0) goto L_0x0167
            r7 = 1
            goto L_0x016f
        L_0x0167:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.f57026i
            boolean r7 = kotlin.jvm.internal.x.b(r15, r7)
        L_0x016f:
            if (r7 == 0) goto L_0x0173
            r7 = 1
            goto L_0x017b
        L_0x0173:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.f57025h
            boolean r7 = kotlin.jvm.internal.x.b(r15, r7)
        L_0x017b:
            if (r7 == 0) goto L_0x017f
            r7 = 1
            goto L_0x0187
        L_0x017f:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.f57028k
            boolean r7 = kotlin.jvm.internal.x.b(r15, r7)
        L_0x0187:
            if (r7 == 0) goto L_0x018b
            r7 = 1
            goto L_0x0193
        L_0x018b:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.f57027j
            boolean r7 = kotlin.jvm.internal.x.b(r15, r7)
        L_0x0193:
            if (r7 == 0) goto L_0x0197
            r7 = 1
            goto L_0x019f
        L_0x0197:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r7 = kotlin.jvm.internal.x.b(r15, r7)
        L_0x019f:
            if (r7 != 0) goto L_0x01d9
            java.lang.String r7 = r15.toString()
        L_0x01a5:
            if (r6 == 0) goto L_0x01c7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 40
            r8.append(r9)
            r8.append(r7)
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = "),"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r1.append(r6)
            goto L_0x01d9
        L_0x01c7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
        L_0x01d9:
            int r4 = r4 + 1
            r6 = 0
            r7 = 1
            goto L_0x00c4
        L_0x01df:
            kotlinx.coroutines.internal.e r2 = r3.e()
            r3 = r2
            kotlinx.coroutines.channels.g r3 = (kotlinx.coroutines.channels.g) r3
            if (r3 != 0) goto L_0x0201
        L_0x01e8:
            char r2 = kotlin.text.StringsKt___StringsKt.n1(r1)
            if (r2 != r5) goto L_0x01f7
            int r2 = r1.length()
            r4 = 1
            int r2 = r2 - r4
            r1.deleteCharAt(r2)
        L_0x01f7:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x0201:
            r6 = 0
            r7 = 1
            goto L_0x00c1
        L_0x0205:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    public boolean u() {
        return i0(f57001e.get(this));
    }

    public final void u0(E e11, k<?> kVar) {
        l<E, Unit> lVar = this.f57011c;
        if (lVar != null) {
            OnUndeliveredElementKt.b(lVar, e11, kVar.getContext());
        }
        kVar.d(BufferedChannelKt.z());
    }

    public final Object v0(E e11, c<? super Unit> cVar) {
        Throwable d11;
        kotlinx.coroutines.l lVar = new kotlinx.coroutines.l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        l<E, Unit> lVar2 = this.f57011c;
        if (lVar2 == null || (d11 = OnUndeliveredElementKt.d(lVar2, e11, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            Throwable Y = Y();
            Result.a aVar = Result.Companion;
            if (j0.d()) {
                Y = b0.i(Y, lVar);
            }
            lVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(Y)));
        } else {
            ExceptionsKt__ExceptionsKt.a(d11, Y());
            Result.a aVar2 = Result.Companion;
            if (j0.d()) {
                d11 = b0.i(d11, lVar);
            }
            lVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(d11)));
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

    public final void w0(E e11, kotlinx.coroutines.k<? super Unit> kVar) {
        l<E, Unit> lVar = this.f57011c;
        if (lVar != null) {
            OnUndeliveredElementKt.b(lVar, e11, kVar.getContext());
        }
        Throwable Y = Y();
        if (j0.d() && (kVar instanceof kotlin.coroutines.jvm.internal.c)) {
            Y = b0.i(Y, (kotlin.coroutines.jvm.internal.c) kVar);
        }
        Result.a aVar = Result.Companion;
        kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(Y)));
    }

    public void x0() {
    }

    public void y0() {
    }

    public final void z0(q2 q2Var, g<E> gVar, int i11) {
        y0();
        q2Var.b(gVar, i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BufferedChannel(int i11, l lVar, int i12, r rVar) {
        this(i11, (i12 & 2) != 0 ? null : lVar);
    }
}
