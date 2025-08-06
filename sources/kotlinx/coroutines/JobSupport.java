package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import d10.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.sequences.g;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.selects.k;

public class JobSupport implements n1, s, y1 {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f56957b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f56958c;
    private volatile Object _parentHandle;
    private volatile Object _state;

    public static final class a<T> extends l<T> {

        /* renamed from: j  reason: collision with root package name */
        public final JobSupport f56959j;

        public a(kotlin.coroutines.c<? super T> cVar, JobSupport jobSupport) {
            super(cVar, 1);
            this.f56959j = jobSupport;
        }

        public String J() {
            return "AwaitContinuation";
        }

        public Throwable t(n1 n1Var) {
            Throwable e11;
            Object s02 = this.f56959j.s0();
            if ((s02 instanceof c) && (e11 = ((c) s02).e()) != null) {
                return e11;
            }
            if (s02 instanceof y) {
                return ((y) s02).f57583a;
            }
            return n1Var.A();
        }
    }

    public static final class b extends JobNode {

        /* renamed from: f  reason: collision with root package name */
        public final JobSupport f56960f;

        /* renamed from: g  reason: collision with root package name */
        public final c f56961g;

        /* renamed from: h  reason: collision with root package name */
        public final r f56962h;

        /* renamed from: i  reason: collision with root package name */
        public final Object f56963i;

        public b(JobSupport jobSupport, c cVar, r rVar, Object obj) {
            this.f56960f = jobSupport;
            this.f56961g = cVar;
            this.f56962h = rVar;
            this.f56963i = obj;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return Unit.f56620a;
        }

        public void q(Throwable th2) {
            this.f56960f.f0(this.f56961g, this.f56962h, this.f56963i);
        }
    }

    public static final class c implements i1 {

        /* renamed from: c  reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f56964c;

        /* renamed from: d  reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f56965d;

        /* renamed from: e  reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f56966e;
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: b  reason: collision with root package name */
        public final NodeList f56967b;

        static {
            Class<Object> cls = Object.class;
            Class<c> cls2 = c.class;
            f56964c = AtomicIntegerFieldUpdater.newUpdater(cls2, "_isCompleting");
            f56965d = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_rootCause");
            f56966e = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_exceptionsHolder");
        }

        public c(NodeList nodeList, boolean z11, Throwable th2) {
            this.f56967b = nodeList;
            this._isCompleting = z11 ? 1 : 0;
            this._rootCause = th2;
        }

        public NodeList a() {
            return this.f56967b;
        }

        public final void b(Throwable th2) {
            Throwable e11 = e();
            if (e11 == null) {
                l(th2);
            } else if (th2 != e11) {
                Object d11 = d();
                if (d11 == null) {
                    k(th2);
                } else if (d11 instanceof Throwable) {
                    if (th2 != d11) {
                        ArrayList<Throwable> c11 = c();
                        c11.add(d11);
                        c11.add(th2);
                        k(c11);
                    }
                } else if (d11 instanceof ArrayList) {
                    ((ArrayList) d11).add(th2);
                } else {
                    throw new IllegalStateException(("State is " + d11).toString());
                }
            }
        }

        public final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        public final Object d() {
            return f56966e.get(this);
        }

        public final Throwable e() {
            return (Throwable) f56965d.get(this);
        }

        public final boolean f() {
            return e() != null;
        }

        public final boolean g() {
            return f56964c.get(this) != 0;
        }

        public final boolean h() {
            return d() == s1.f57463e;
        }

        public final List<Throwable> i(Throwable th2) {
            ArrayList<Throwable> arrayList;
            Object d11 = d();
            if (d11 == null) {
                arrayList = c();
            } else if (d11 instanceof Throwable) {
                ArrayList<Throwable> c11 = c();
                c11.add(d11);
                arrayList = c11;
            } else if (d11 instanceof ArrayList) {
                arrayList = (ArrayList) d11;
            } else {
                throw new IllegalStateException(("State is " + d11).toString());
            }
            Throwable e11 = e();
            if (e11 != null) {
                arrayList.add(0, e11);
            }
            if (th2 != null && !x.b(th2, e11)) {
                arrayList.add(th2);
            }
            k(s1.f57463e);
            return arrayList;
        }

        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z11) {
            f56964c.set(this, z11 ? 1 : 0);
        }

        public final void k(Object obj) {
            f56966e.set(this, obj);
        }

        public final void l(Throwable th2) {
            f56965d.set(this, th2);
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + a() + ']';
        }
    }

    public final class d extends JobNode {

        /* renamed from: f  reason: collision with root package name */
        public final k<?> f56968f;

        public d(k<?> kVar) {
            this.f56968f = kVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return Unit.f56620a;
        }

        public void q(Throwable th2) {
            Object s02 = JobSupport.this.s0();
            if (!(s02 instanceof y)) {
                s02 = s1.h(s02);
            }
            this.f56968f.f(JobSupport.this, s02);
        }
    }

    public final class e extends JobNode {

        /* renamed from: f  reason: collision with root package name */
        public final k<?> f56970f;

        public e(k<?> kVar) {
            this.f56970f = kVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return Unit.f56620a;
        }

        public void q(Throwable th2) {
            this.f56970f.f(JobSupport.this, Unit.f56620a);
        }
    }

    public static final class f extends LockFreeLinkedListNode.a {

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ JobSupport f56972d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f56973e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
            super(lockFreeLinkedListNode);
            this.f56972d = jobSupport;
            this.f56973e = obj;
        }

        /* renamed from: f */
        public Object d(LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f56972d.s0() == this.f56973e) {
                return null;
            }
            return p.a();
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<JobSupport> cls2 = JobSupport.class;
        f56957b = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_state");
        f56958c = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_parentHandle");
    }

    public JobSupport(boolean z11) {
        this._state = z11 ? s1.f57465g : s1.f57464f;
    }

    public static /* synthetic */ CancellationException U0(JobSupport jobSupport, Throwable th2, String str, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                str = null;
            }
            return jobSupport.T0(th2, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    public final CancellationException A() {
        Object s02 = s0();
        if (s02 instanceof c) {
            Throwable e11 = ((c) s02).e();
            if (e11 != null) {
                CancellationException T0 = T0(e11, k0.a(this) + " is cancelling");
                if (T0 != null) {
                    return T0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (s02 instanceof i1) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (s02 instanceof y) {
            return U0(this, ((y) s02).f57583a, (String) null, 1, (Object) null);
        } else {
            return new JobCancellationException(k0.a(this) + " has completed normally", (Throwable) null, this);
        }
    }

    public final boolean A0(Object obj) {
        Object Y0;
        do {
            Y0 = Y0(s0(), obj);
            if (Y0 == s1.f57459a) {
                return false;
            }
            if (Y0 == s1.f57460b) {
                return true;
            }
        } while (Y0 == s1.f57461c);
        U(Y0);
        return true;
    }

    public final Object B0(Object obj) {
        Object Y0;
        do {
            Y0 = Y0(s0(), obj);
            if (Y0 == s1.f57459a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, m0(obj));
            }
        } while (Y0 == s1.f57461c);
        return Y0;
    }

    public CancellationException C() {
        Throwable th2;
        Object s02 = s0();
        CancellationException cancellationException = null;
        if (s02 instanceof c) {
            th2 = ((c) s02).e();
        } else if (s02 instanceof y) {
            th2 = ((y) s02).f57583a;
        } else if (!(s02 instanceof i1)) {
            th2 = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + s02).toString());
        }
        if (th2 instanceof CancellationException) {
            cancellationException = (CancellationException) th2;
        }
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + S0(s02), th2, this);
    }

    public final JobNode C0(l<? super Throwable, Unit> lVar, boolean z11) {
        JobNode jobNode = null;
        if (z11) {
            if (lVar instanceof JobCancellingNode) {
                jobNode = (JobCancellingNode) lVar;
            }
            if (jobNode == null) {
                jobNode = new l1(lVar);
            }
        } else {
            if (lVar instanceof JobNode) {
                jobNode = (JobNode) lVar;
            }
            if (jobNode == null) {
                jobNode = new m1(lVar);
            } else if (j0.a() && !(!(jobNode instanceof JobCancellingNode))) {
                throw new AssertionError();
            }
        }
        jobNode.s(this);
        return jobNode;
    }

    public String D0() {
        return k0.a(this);
    }

    public final x0 E(boolean z11, boolean z12, l<? super Throwable, Unit> lVar) {
        JobNode C0 = C0(lVar, z11);
        while (true) {
            Object s02 = s0();
            if (s02 instanceof a1) {
                a1 a1Var = (a1) s02;
                if (!a1Var.isActive()) {
                    M0(a1Var);
                } else if (androidx.concurrent.futures.a.a(f56957b, this, s02, C0)) {
                    return C0;
                }
            } else {
                Throwable th2 = null;
                if (s02 instanceof i1) {
                    NodeList a11 = ((i1) s02).a();
                    if (a11 == null) {
                        N0((JobNode) s02);
                    } else {
                        x0 x0Var = w1.f57576b;
                        if (z11 && (s02 instanceof c)) {
                            synchronized (s02) {
                                th2 = ((c) s02).e();
                                if (th2 == null || ((lVar instanceof r) && !((c) s02).g())) {
                                    if (S(s02, a11, C0)) {
                                        if (th2 == null) {
                                            return C0;
                                        }
                                        x0Var = C0;
                                    }
                                }
                                Unit unit = Unit.f56620a;
                            }
                        }
                        if (th2 != null) {
                            if (z12) {
                                lVar.invoke(th2);
                            }
                            return x0Var;
                        } else if (S(s02, a11, C0)) {
                            return C0;
                        }
                    }
                } else {
                    if (z12) {
                        y yVar = s02 instanceof y ? (y) s02 : null;
                        if (yVar != null) {
                            th2 = yVar.f57583a;
                        }
                        lVar.invoke(th2);
                    }
                    return w1.f57576b;
                }
            }
        }
    }

    public final r E0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.l()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.k();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.j();
            if (!lockFreeLinkedListNode.l()) {
                if (lockFreeLinkedListNode instanceof r) {
                    return (r) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public final Object F(kotlin.coroutines.c<? super Unit> cVar) {
        if (!x0()) {
            p1.i(cVar.getContext());
            return Unit.f56620a;
        }
        Object y02 = y0(cVar);
        return y02 == IntrinsicsKt__IntrinsicsKt.d() ? y02 : Unit.f56620a;
    }

    public final void F0(NodeList nodeList, Throwable th2) {
        J0(th2);
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.i(); !x.b(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.j()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.q(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                        Unit unit = Unit.f56620a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            u0(completionHandlerException);
        }
        b0(th2);
    }

    public final void G0(NodeList nodeList, Throwable th2) {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) nodeList.i(); !x.b(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.j()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.q(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        ExceptionsKt__ExceptionsKt.a(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                        Unit unit = Unit.f56620a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            u0(completionHandlerException);
        }
    }

    public final Object H0(Object obj, Object obj2) {
        if (!(obj2 instanceof y)) {
            return obj2;
        }
        throw ((y) obj2).f57583a;
    }

    public final void I0(k<?> kVar, Object obj) {
        Object s02;
        do {
            s02 = s0();
            if (!(s02 instanceof i1)) {
                if (!(s02 instanceof y)) {
                    s02 = s1.h(s02);
                }
                kVar.d(s02);
                return;
            }
        } while (R0(s02) < 0);
        kVar.e(L(new d(kVar)));
    }

    public void J0(Throwable th2) {
    }

    public void K0(Object obj) {
    }

    public final x0 L(l<? super Throwable, Unit> lVar) {
        return E(false, true, lVar);
    }

    public void L0() {
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [kotlinx.coroutines.h1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M0(kotlinx.coroutines.a1 r3) {
        /*
            r2 = this;
            kotlinx.coroutines.NodeList r0 = new kotlinx.coroutines.NodeList
            r0.<init>()
            boolean r1 = r3.isActive()
            if (r1 == 0) goto L_0x000c
            goto L_0x0012
        L_0x000c:
            kotlinx.coroutines.h1 r1 = new kotlinx.coroutines.h1
            r1.<init>(r0)
            r0 = r1
        L_0x0012:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f56957b
            androidx.concurrent.futures.a.a(r1, r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.M0(kotlinx.coroutines.a1):void");
    }

    public final void N0(JobNode jobNode) {
        jobNode.e(new NodeList());
        androidx.concurrent.futures.a.a(f56957b, this, jobNode, jobNode.j());
    }

    public final void O0(k<?> kVar, Object obj) {
        if (!x0()) {
            kVar.d(Unit.f56620a);
        } else {
            kVar.e(L(new e(kVar)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void P0(kotlinx.coroutines.JobNode r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.s0()
            boolean r1 = r0 instanceof kotlinx.coroutines.JobNode
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f56957b
            kotlinx.coroutines.a1 r2 = kotlinx.coroutines.s1.f57465g
            boolean r0 = androidx.concurrent.futures.a.a(r1, r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.i1
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.i1 r0 = (kotlinx.coroutines.i1) r0
            kotlinx.coroutines.NodeList r0 = r0.a()
            if (r0 == 0) goto L_0x0027
            r4.m()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.P0(kotlinx.coroutines.JobNode):void");
    }

    public final void Q0(q qVar) {
        f56958c.set(this, qVar);
    }

    public final int R0(Object obj) {
        if (obj instanceof a1) {
            if (((a1) obj).isActive()) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(f56957b, this, obj, s1.f57465g)) {
                return -1;
            }
            L0();
            return 1;
        } else if (!(obj instanceof h1)) {
            return 0;
        } else {
            if (!androidx.concurrent.futures.a.a(f56957b, this, obj, ((h1) obj).a())) {
                return -1;
            }
            L0();
            return 1;
        }
    }

    public final boolean S(Object obj, NodeList nodeList, JobNode jobNode) {
        int p11;
        f fVar = new f(jobNode, this, obj);
        do {
            p11 = nodeList.k().p(jobNode, nodeList, fVar);
            if (p11 == 1) {
                return true;
            }
        } while (p11 != 2);
        return false;
    }

    public final String S0(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.f()) {
                return "Cancelling";
            }
            if (cVar.g()) {
                return "Completing";
            }
            return "Active";
        } else if (!(obj instanceof i1)) {
            return obj instanceof y ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        } else {
            if (((i1) obj).isActive()) {
                return "Active";
            }
            return "New";
        }
    }

    public final void T(Throwable th2, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Throwable l11 = !j0.d() ? th2 : b0.l(th2);
            for (Throwable th3 : list) {
                if (j0.d()) {
                    th3 = b0.l(th3);
                }
                if (th3 != th2 && th3 != l11 && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                    ExceptionsKt__ExceptionsKt.a(th2, th3);
                }
            }
        }
    }

    public final CancellationException T0(Throwable th2, String str) {
        CancellationException cancellationException = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (cancellationException == null) {
            if (str == null) {
                str = c0();
            }
            cancellationException = new JobCancellationException(str, th2, this);
        }
        return cancellationException;
    }

    public void U(Object obj) {
    }

    public final Object V(kotlin.coroutines.c<Object> cVar) {
        Object s02;
        do {
            s02 = s0();
            if (!(s02 instanceof i1)) {
                if (!(s02 instanceof y)) {
                    return s1.h(s02);
                }
                Throwable th2 = ((y) s02).f57583a;
                if (!j0.d()) {
                    throw th2;
                } else if (!(cVar instanceof kotlin.coroutines.jvm.internal.c)) {
                    throw th2;
                } else {
                    throw b0.i(th2, (kotlin.coroutines.jvm.internal.c) cVar);
                }
            }
        } while (R0(s02) < 0);
        return W(cVar);
    }

    public final String V0() {
        return D0() + '{' + S0(s0()) + '}';
    }

    public final Object W(kotlin.coroutines.c<Object> cVar) {
        a aVar = new a(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), this);
        aVar.A();
        n.a(aVar, L(new z1(aVar)));
        Object v11 = aVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        return v11;
    }

    public final boolean W0(i1 i1Var, Object obj) {
        if (j0.a()) {
            if (!((i1Var instanceof a1) || (i1Var instanceof JobNode))) {
                throw new AssertionError();
            }
        }
        if (j0.a() && !(!(obj instanceof y))) {
            throw new AssertionError();
        } else if (!androidx.concurrent.futures.a.a(f56957b, this, i1Var, s1.g(obj))) {
            return false;
        } else {
            J0((Throwable) null);
            K0(obj);
            e0(i1Var, obj);
            return true;
        }
    }

    public final boolean X(Throwable th2) {
        return Y(th2);
    }

    public final boolean X0(i1 i1Var, Throwable th2) {
        if (j0.a() && !(!(i1Var instanceof c))) {
            throw new AssertionError();
        } else if (!j0.a() || i1Var.isActive()) {
            NodeList q02 = q0(i1Var);
            if (q02 == null) {
                return false;
            }
            if (!androidx.concurrent.futures.a.a(f56957b, this, i1Var, new c(q02, false, th2))) {
                return false;
            }
            F0(q02, th2);
            return true;
        } else {
            throw new AssertionError();
        }
    }

    public final boolean Y(Object obj) {
        Object a11 = s1.f57459a;
        if (p0() && (a11 = a0(obj)) == s1.f57460b) {
            return true;
        }
        if (a11 == s1.f57459a) {
            a11 = z0(obj);
        }
        if (a11 == s1.f57459a || a11 == s1.f57460b) {
            return true;
        }
        if (a11 == s1.f57462d) {
            return false;
        }
        U(a11);
        return true;
    }

    public final Object Y0(Object obj, Object obj2) {
        if (!(obj instanceof i1)) {
            return s1.f57459a;
        }
        if ((!(obj instanceof a1) && !(obj instanceof JobNode)) || (obj instanceof r) || (obj2 instanceof y)) {
            return Z0((i1) obj, obj2);
        }
        if (W0((i1) obj, obj2)) {
            return obj2;
        }
        return s1.f57461c;
    }

    public void Z(Throwable th2) {
        Y(th2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0082, code lost:
        r3 = (java.lang.Throwable) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0085, code lost:
        if (r2 == null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0087, code lost:
        F0(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008a, code lost:
        r9 = i0(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x008e, code lost:
        if (r9 == null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0094, code lost:
        if (a1(r1, r9, r10) == false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0098, code lost:
        return kotlinx.coroutines.s1.f57460b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x009d, code lost:
        return h0(r1, r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object Z0(kotlinx.coroutines.i1 r9, java.lang.Object r10) {
        /*
            r8 = this;
            kotlinx.coroutines.NodeList r0 = r8.q0(r9)
            if (r0 != 0) goto L_0x000b
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.s1.f57461c
            return r9
        L_0x000b:
            boolean r1 = r9 instanceof kotlinx.coroutines.JobSupport.c
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r1 = r9
            kotlinx.coroutines.JobSupport$c r1 = (kotlinx.coroutines.JobSupport.c) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            r3 = 0
            if (r1 != 0) goto L_0x001d
            kotlinx.coroutines.JobSupport$c r1 = new kotlinx.coroutines.JobSupport$c
            r1.<init>(r0, r3, r2)
        L_0x001d:
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            monitor-enter(r1)
            boolean r5 = r1.g()     // Catch:{ all -> 0x009e }
            if (r5 == 0) goto L_0x002f
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.s1.f57459a     // Catch:{ all -> 0x009e }
            monitor-exit(r1)
            return r9
        L_0x002f:
            r5 = 1
            r1.j(r5)     // Catch:{ all -> 0x009e }
            if (r1 == r9) goto L_0x0043
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = f56957b     // Catch:{ all -> 0x009e }
            boolean r6 = androidx.concurrent.futures.a.a(r6, r8, r9, r1)     // Catch:{ all -> 0x009e }
            if (r6 != 0) goto L_0x0043
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.s1.f57461c     // Catch:{ all -> 0x009e }
            monitor-exit(r1)
            return r9
        L_0x0043:
            boolean r6 = kotlinx.coroutines.j0.a()     // Catch:{ all -> 0x009e }
            if (r6 == 0) goto L_0x0057
            boolean r6 = r1.h()     // Catch:{ all -> 0x009e }
            r6 = r6 ^ r5
            if (r6 == 0) goto L_0x0051
            goto L_0x0057
        L_0x0051:
            java.lang.AssertionError r9 = new java.lang.AssertionError     // Catch:{ all -> 0x009e }
            r9.<init>()     // Catch:{ all -> 0x009e }
            throw r9     // Catch:{ all -> 0x009e }
        L_0x0057:
            boolean r6 = r1.f()     // Catch:{ all -> 0x009e }
            boolean r7 = r10 instanceof kotlinx.coroutines.y     // Catch:{ all -> 0x009e }
            if (r7 == 0) goto L_0x0063
            r7 = r10
            kotlinx.coroutines.y r7 = (kotlinx.coroutines.y) r7     // Catch:{ all -> 0x009e }
            goto L_0x0064
        L_0x0063:
            r7 = r2
        L_0x0064:
            if (r7 == 0) goto L_0x006b
            java.lang.Throwable r7 = r7.f57583a     // Catch:{ all -> 0x009e }
            r1.b(r7)     // Catch:{ all -> 0x009e }
        L_0x006b:
            java.lang.Throwable r7 = r1.e()     // Catch:{ all -> 0x009e }
            if (r6 != 0) goto L_0x0072
            r3 = r5
        L_0x0072:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x009e }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x009e }
            if (r3 == 0) goto L_0x007d
            r2 = r7
        L_0x007d:
            r4.element = r2     // Catch:{ all -> 0x009e }
            kotlin.Unit r3 = kotlin.Unit.f56620a     // Catch:{ all -> 0x009e }
            monitor-exit(r1)
            r3 = r2
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            if (r2 == 0) goto L_0x008a
            r8.F0(r0, r2)
        L_0x008a:
            kotlinx.coroutines.r r9 = r8.i0(r9)
            if (r9 == 0) goto L_0x0099
            boolean r9 = r8.a1(r1, r9, r10)
            if (r9 == 0) goto L_0x0099
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.s1.f57460b
            return r9
        L_0x0099:
            java.lang.Object r9 = r8.h0(r1, r10)
            return r9
        L_0x009e:
            r9 = move-exception
            monitor-exit(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.Z0(kotlinx.coroutines.i1, java.lang.Object):java.lang.Object");
    }

    public final boolean a() {
        return !(s0() instanceof i1);
    }

    public final Object a0(Object obj) {
        Object Y0;
        do {
            Object s02 = s0();
            if (!(s02 instanceof i1) || ((s02 instanceof c) && ((c) s02).g())) {
                return s1.f57459a;
            }
            Y0 = Y0(s02, new y(g0(obj), false, 2, (r) null));
        } while (Y0 == s1.f57461c);
        return Y0;
    }

    public final boolean a1(c cVar, r rVar, Object obj) {
        while (n1.a.d(rVar.f57390f, false, false, new b(this, cVar, rVar, obj), 1, (Object) null) == w1.f57576b) {
            rVar = E0(rVar);
            if (rVar == null) {
                return false;
            }
        }
        return true;
    }

    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(c0(), (Throwable) null, this);
        }
        Z(cancellationException);
    }

    public final boolean b0(Throwable th2) {
        if (w0()) {
            return true;
        }
        boolean z11 = th2 instanceof CancellationException;
        q r02 = r0();
        if (r02 == null || r02 == w1.f57576b) {
            return z11;
        }
        if (r02.b(th2) || z11) {
            return true;
        }
        return false;
    }

    public String c0() {
        return "Job was cancelled";
    }

    public boolean d0(Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        if (!Y(th2) || !o0()) {
            return false;
        }
        return true;
    }

    public final void e0(i1 i1Var, Object obj) {
        q r02 = r0();
        if (r02 != null) {
            r02.dispose();
            Q0(w1.f57576b);
        }
        Throwable th2 = null;
        y yVar = obj instanceof y ? (y) obj : null;
        if (yVar != null) {
            th2 = yVar.f57583a;
        }
        if (i1Var instanceof JobNode) {
            try {
                ((JobNode) i1Var).q(th2);
            } catch (Throwable th3) {
                u0(new CompletionHandlerException("Exception in completion handler " + i1Var + " for " + this, th3));
            }
        } else {
            NodeList a11 = i1Var.a();
            if (a11 != null) {
                G0(a11, th2);
            }
        }
    }

    public final void f0(c cVar, r rVar, Object obj) {
        if (j0.a()) {
            if (!(s0() == cVar)) {
                throw new AssertionError();
            }
        }
        r E0 = E0(rVar);
        if (E0 == null || !a1(cVar, E0, obj)) {
            U(h0(cVar, obj));
        }
    }

    public <R> R fold(R r11, d10.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return n1.a.b(this, r11, pVar);
    }

    public final Throwable g0(Object obj) {
        if (!(obj == null ? true : obj instanceof Throwable)) {
            return ((y1) obj).C();
        }
        Throwable th2 = (Throwable) obj;
        if (th2 == null) {
            return new JobCancellationException(c0(), (Throwable) null, this);
        }
        return th2;
    }

    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return n1.a.c(this, bVar);
    }

    public final g<n1> getChildren() {
        return SequencesKt__SequenceBuilderKt.b(new JobSupport$children$1(this, (kotlin.coroutines.c<? super JobSupport$children$1>) null));
    }

    public final CoroutineContext.b<?> getKey() {
        return n1.f57382r0;
    }

    public n1 getParent() {
        q r02 = r0();
        if (r02 != null) {
            return r02.getParent();
        }
        return null;
    }

    public final Object h0(c cVar, Object obj) {
        boolean f11;
        Throwable n02;
        boolean z11 = true;
        if (j0.a()) {
            if (!(s0() == cVar)) {
                throw new AssertionError();
            }
        }
        if (j0.a() && !(!cVar.h())) {
            throw new AssertionError();
        } else if (!j0.a() || cVar.g()) {
            y yVar = obj instanceof y ? (y) obj : null;
            Throwable th2 = yVar != null ? yVar.f57583a : null;
            synchronized (cVar) {
                f11 = cVar.f();
                List<Throwable> i11 = cVar.i(th2);
                n02 = n0(cVar, i11);
                if (n02 != null) {
                    T(n02, i11);
                }
            }
            if (!(n02 == null || n02 == th2)) {
                obj = new y(n02, false, 2, (r) null);
            }
            if (n02 != null) {
                if (!b0(n02) && !t0(n02)) {
                    z11 = false;
                }
                if (z11) {
                    ((y) obj).b();
                }
            }
            if (!f11) {
                J0(n02);
            }
            K0(obj);
            boolean a11 = androidx.concurrent.futures.a.a(f56957b, this, cVar, s1.g(obj));
            if (!j0.a() || a11) {
                e0(cVar, obj);
                return obj;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    public final r i0(i1 i1Var) {
        r rVar = i1Var instanceof r ? (r) i1Var : null;
        if (rVar != null) {
            return rVar;
        }
        NodeList a11 = i1Var.a();
        if (a11 != null) {
            return E0(a11);
        }
        return null;
    }

    public boolean isActive() {
        Object s02 = s0();
        return (s02 instanceof i1) && ((i1) s02).isActive();
    }

    public final boolean isCancelled() {
        Object s02 = s0();
        return (s02 instanceof y) || ((s02 instanceof c) && ((c) s02).f());
    }

    public final Object j0() {
        Object s02 = s0();
        if (!(!(s02 instanceof i1))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        } else if (!(s02 instanceof y)) {
            return s1.h(s02);
        } else {
            throw ((y) s02).f57583a;
        }
    }

    public final void k(y1 y1Var) {
        Y(y1Var);
    }

    public final Throwable k0() {
        Object s02 = s0();
        if (s02 instanceof c) {
            Throwable e11 = ((c) s02).e();
            if (e11 != null) {
                return e11;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (s02 instanceof i1) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (s02 instanceof y) {
            return ((y) s02).f57583a;
        } else {
            return null;
        }
    }

    public final boolean l0() {
        Object s02 = s0();
        return (s02 instanceof y) && ((y) s02).a();
    }

    public final Throwable m0(Object obj) {
        y yVar = obj instanceof y ? (y) obj : null;
        if (yVar != null) {
            return yVar.f57583a;
        }
        return null;
    }

    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return n1.a.e(this, bVar);
    }

    public final Throwable n0(c cVar, List<? extends Throwable> list) {
        T t11;
        boolean z11;
        T t12 = null;
        if (!list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it2.next();
                if (!(((Throwable) t11) instanceof CancellationException)) {
                    break;
                }
            }
            Throwable th2 = (Throwable) t11;
            if (th2 != null) {
                return th2;
            }
            Throwable th3 = (Throwable) list.get(0);
            if (th3 instanceof TimeoutCancellationException) {
                Iterator<T> it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    T next = it3.next();
                    Throwable th4 = (Throwable) next;
                    if (th4 == th3 || !(th4 instanceof TimeoutCancellationException)) {
                        z11 = false;
                        continue;
                    } else {
                        z11 = true;
                        continue;
                    }
                    if (z11) {
                        t12 = next;
                        break;
                    }
                }
                Throwable th5 = (Throwable) t12;
                if (th5 != null) {
                    return th5;
                }
            }
            return th3;
        } else if (cVar.f()) {
            return new JobCancellationException(c0(), (Throwable) null, this);
        } else {
            return null;
        }
    }

    public boolean o0() {
        return true;
    }

    public boolean p0() {
        return false;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return n1.a.f(this, coroutineContext);
    }

    public final NodeList q0(i1 i1Var) {
        NodeList a11 = i1Var.a();
        if (a11 != null) {
            return a11;
        }
        if (i1Var instanceof a1) {
            return new NodeList();
        }
        if (i1Var instanceof JobNode) {
            N0((JobNode) i1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + i1Var).toString());
    }

    public final q r0() {
        return (q) f56958c.get(this);
    }

    public final Object s0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f56957b;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).a(this);
        }
    }

    public final boolean start() {
        int R0;
        do {
            R0 = R0(s0());
            if (R0 == 0) {
                return false;
            }
        } while (R0 != 1);
        return true;
    }

    public boolean t0(Throwable th2) {
        return false;
    }

    public String toString() {
        return V0() + '@' + k0.b(this);
    }

    public void u0(Throwable th2) {
        throw th2;
    }

    public final q v(s sVar) {
        return (q) n1.a.d(this, true, false, new r(sVar), 2, (Object) null);
    }

    public final void v0(n1 n1Var) {
        if (j0.a()) {
            if (!(r0() == null)) {
                throw new AssertionError();
            }
        }
        if (n1Var == null) {
            Q0(w1.f57576b);
            return;
        }
        n1Var.start();
        q v11 = n1Var.v(this);
        Q0(v11);
        if (a()) {
            v11.dispose();
            Q0(w1.f57576b);
        }
    }

    public boolean w0() {
        return false;
    }

    public final boolean x0() {
        Object s02;
        do {
            s02 = s0();
            if (!(s02 instanceof i1)) {
                return false;
            }
        } while (R0(s02) < 0);
        return true;
    }

    public final Object y0(kotlin.coroutines.c<? super Unit> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        n.a(lVar, L(new a2(lVar)));
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            return v11;
        }
        return Unit.f56620a;
    }

    public final Throwable z() {
        Object s02 = s0();
        if (!(s02 instanceof i1)) {
            return m0(s02);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        F0(((kotlinx.coroutines.JobSupport.c) r2).a(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        return kotlinx.coroutines.s1.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z0(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r6.s0()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.c
            if (r3 == 0) goto L_0x0051
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$c r3 = (kotlinx.coroutines.JobSupport.c) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.h()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x001a
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.s1.f57462d     // Catch:{ all -> 0x004e }
            monitor-exit(r2)
            return r7
        L_0x001a:
            r3 = r2
            kotlinx.coroutines.JobSupport$c r3 = (kotlinx.coroutines.JobSupport.c) r3     // Catch:{ all -> 0x004e }
            boolean r3 = r3.f()     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x0025
            if (r3 != 0) goto L_0x0031
        L_0x0025:
            if (r1 != 0) goto L_0x002b
            java.lang.Throwable r1 = r6.g0(r7)     // Catch:{ all -> 0x004e }
        L_0x002b:
            r7 = r2
            kotlinx.coroutines.JobSupport$c r7 = (kotlinx.coroutines.JobSupport.c) r7     // Catch:{ all -> 0x004e }
            r7.b(r1)     // Catch:{ all -> 0x004e }
        L_0x0031:
            r7 = r2
            kotlinx.coroutines.JobSupport$c r7 = (kotlinx.coroutines.JobSupport.c) r7     // Catch:{ all -> 0x004e }
            java.lang.Throwable r7 = r7.e()     // Catch:{ all -> 0x004e }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003d
            r0 = r7
        L_0x003d:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x0049
            kotlinx.coroutines.JobSupport$c r2 = (kotlinx.coroutines.JobSupport.c) r2
            kotlinx.coroutines.NodeList r7 = r2.a()
            r6.F0(r7, r0)
        L_0x0049:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.s1.f57459a
            return r7
        L_0x004e:
            r7 = move-exception
            monitor-exit(r2)
            throw r7
        L_0x0051:
            boolean r3 = r2 instanceof kotlinx.coroutines.i1
            if (r3 == 0) goto L_0x00a2
            if (r1 != 0) goto L_0x005b
            java.lang.Throwable r1 = r6.g0(r7)
        L_0x005b:
            r3 = r2
            kotlinx.coroutines.i1 r3 = (kotlinx.coroutines.i1) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x006f
            boolean r2 = r6.X0(r3, r1)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.s1.f57459a
            return r7
        L_0x006f:
            kotlinx.coroutines.y r3 = new kotlinx.coroutines.y
            r4 = 0
            r5 = 2
            r3.<init>(r1, r4, r5, r0)
            java.lang.Object r3 = r6.Y0(r2, r3)
            kotlinx.coroutines.internal.c0 r4 = kotlinx.coroutines.s1.f57459a
            if (r3 == r4) goto L_0x0087
            kotlinx.coroutines.internal.c0 r2 = kotlinx.coroutines.s1.f57461c
            if (r3 == r2) goto L_0x0002
            return r3
        L_0x0087:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot happen in "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        L_0x00a2:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.s1.f57462d
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.z0(java.lang.Object):java.lang.Object");
    }
}
