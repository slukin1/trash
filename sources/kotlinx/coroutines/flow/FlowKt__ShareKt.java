package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.t;
import kotlinx.coroutines.v;

public final /* synthetic */ class FlowKt__ShareKt {
    public static final <T> f1<T> a(a1<T> a1Var) {
        return new c1(a1Var, (n1) null);
    }

    public static final <T> j1<T> b(b1<T> b1Var) {
        return new d1(b1Var, (n1) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r9 == 0) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlinx.coroutines.flow.h1<T> c(kotlinx.coroutines.flow.d<? extends T> r8, int r9) {
        /*
            boolean r0 = kotlinx.coroutines.j0.a()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0016
            if (r9 < 0) goto L_0x000c
            r0 = r1
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 == 0) goto L_0x0010
            goto L_0x0016
        L_0x0010:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L_0x0016:
            kotlinx.coroutines.channels.d$a r0 = kotlinx.coroutines.channels.d.f57045s0
            int r0 = r0.a()
            int r0 = kotlin.ranges.RangesKt___RangesKt.d(r9, r0)
            int r0 = r0 - r9
            boolean r3 = r8 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r3 == 0) goto L_0x0053
            r3 = r8
            kotlinx.coroutines.flow.internal.ChannelFlow r3 = (kotlinx.coroutines.flow.internal.ChannelFlow) r3
            kotlinx.coroutines.flow.d r4 = r3.j()
            if (r4 == 0) goto L_0x0053
            kotlinx.coroutines.flow.h1 r8 = new kotlinx.coroutines.flow.h1
            int r5 = r3.f57237c
            r6 = -3
            if (r5 == r6) goto L_0x003c
            r6 = -2
            if (r5 == r6) goto L_0x003c
            if (r5 == 0) goto L_0x003c
            r1 = r5
            goto L_0x004b
        L_0x003c:
            kotlinx.coroutines.channels.BufferOverflow r6 = r3.f57238d
            kotlinx.coroutines.channels.BufferOverflow r7 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r6 != r7) goto L_0x0047
            if (r5 != 0) goto L_0x0045
            goto L_0x004a
        L_0x0045:
            r1 = r0
            goto L_0x004b
        L_0x0047:
            if (r9 != 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r1 = r2
        L_0x004b:
            kotlinx.coroutines.channels.BufferOverflow r9 = r3.f57238d
            kotlin.coroutines.CoroutineContext r0 = r3.f57236b
            r8.<init>(r4, r1, r9, r0)
            return r8
        L_0x0053:
            kotlinx.coroutines.flow.h1 r9 = new kotlinx.coroutines.flow.h1
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r9.<init>(r8, r0, r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.c(kotlinx.coroutines.flow.d, int):kotlinx.coroutines.flow.h1");
    }

    public static final <T> n1 d(h0 h0Var, CoroutineContext coroutineContext, d<? extends T> dVar, a1<T> a1Var, i1 i1Var, T t11) {
        return g.c(h0Var, coroutineContext, x.b(i1Var, i1.f57228a.c()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new FlowKt__ShareKt$launchSharing$1(i1Var, dVar, a1Var, t11, (c<? super FlowKt__ShareKt$launchSharing$1>) null));
    }

    public static final <T> void e(h0 h0Var, CoroutineContext coroutineContext, d<? extends T> dVar, t<j1<T>> tVar) {
        n1 unused = i.d(h0Var, coroutineContext, (CoroutineStart) null, new FlowKt__ShareKt$launchSharingDeferred$1(dVar, tVar, (c<? super FlowKt__ShareKt$launchSharingDeferred$1>) null), 2, (Object) null);
    }

    public static final <T> f1<T> f(f1<? extends T> f1Var, p<? super e<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        return new SubscribedSharedFlow(f1Var, pVar);
    }

    public static final <T> f1<T> g(d<? extends T> dVar, h0 h0Var, i1 i1Var, int i11) {
        h1<? extends T> c11 = c(dVar, i11);
        a1 a11 = g1.a(i11, c11.f57225b, c11.f57226c);
        return new c1(a11, d(h0Var, c11.f57227d, c11.f57224a, a11, i1Var, g1.f57223a));
    }

    public static /* synthetic */ f1 h(d dVar, h0 h0Var, i1 i1Var, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return f.V(dVar, h0Var, i1Var, i11);
    }

    public static final <T> Object i(d<? extends T> dVar, h0 h0Var, c<? super j1<? extends T>> cVar) {
        h1<? extends T> c11 = c(dVar, 1);
        t b11 = v.b((n1) null, 1, (Object) null);
        e(h0Var, c11.f57227d, c11.f57224a, b11);
        return b11.j(cVar);
    }

    public static final <T> j1<T> j(d<? extends T> dVar, h0 h0Var, i1 i1Var, T t11) {
        h1<? extends T> c11 = c(dVar, 1);
        b1 a11 = k1.a(t11);
        return new d1(a11, d(h0Var, c11.f57227d, c11.f57224a, a11, i1Var, t11));
    }
}
