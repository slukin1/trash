package com.iproov.sdk.p027static;

import com.iproov.sdk.p016if.Cextends;
import com.iproov.sdk.p016if.Cswitch;
import com.iproov.sdk.p016if.Cthis;
import com.iproov.sdk.p026return.Cbreak;
import com.iproov.sdk.p026return.Cgoto;
import com.iproov.sdk.p026return.Cimport;
import com.iproov.sdk.p026return.Cthrow;
import com.iproov.sdk.p026return.Cwhile;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.a;

/* renamed from: com.iproov.sdk.static.if  reason: invalid class name and invalid package */
public final class Cif {

    /* renamed from: case  reason: not valid java name */
    private final i f1945case = LazyKt__LazyJVMKt.a(new Cif(this));

    /* renamed from: do  reason: not valid java name */
    private final Cfor f1946do;

    /* renamed from: else  reason: not valid java name */
    private final i f1947else = LazyKt__LazyJVMKt.a(new Cfor(this));

    /* renamed from: for  reason: not valid java name */
    private com.iproov.sdk.p003case.Cif f1948for;

    /* renamed from: goto  reason: not valid java name */
    private final i f1949goto = LazyKt__LazyJVMKt.a(new Cnew(this));

    /* renamed from: if  reason: not valid java name */
    private com.iproov.sdk.p021new.Cnew f1950if;

    /* renamed from: new  reason: not valid java name */
    private Cextends f1951new;

    /* renamed from: try  reason: not valid java name */
    private final a f1952try = MutexKt.b(false, 1, (Object) null);

    /* renamed from: com.iproov.sdk.static.if$do  reason: invalid class name */
    public /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f1953do;

        static {
            int[] iArr = new int[com.iproov.sdk.p003case.Cdo.values().length];
            iArr[com.iproov.sdk.p003case.Cdo.LIVENESS.ordinal()] = 1;
            iArr[com.iproov.sdk.p003case.Cdo.GENUINE_PRESENCE_ASSURANCE.ordinal()] = 2;
            f1953do = iArr;
        }
    }

    /* renamed from: com.iproov.sdk.static.if$for  reason: invalid class name */
    public static final class Cfor extends Lambda implements d10.a<Cwhile> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cif f1954do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(Cif ifVar) {
            super(0);
            this.f1954do = ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cwhile invoke() {
            return new Cwhile(this.f1954do.m1833if().m1809for(), f.b(this.f1954do.m1833if().m1808else().m741import()), this.f1954do.m1833if().m1808else().m755synchronized(), f.b(this.f1954do.m1833if().m1808else().m732do()), f.a(this.f1954do.m1833if().m1808else().e()), this.f1954do.m1833if().m1810new(), (CoroutineDispatcher) null, 64, (r) null);
        }
    }

    /* renamed from: com.iproov.sdk.static.if$if  reason: invalid class name */
    public static final class Cif extends Lambda implements d10.a<Cgoto> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cif f1955do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cif ifVar) {
            super(0);
            this.f1955do = ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cgoto invoke() {
            return new Cgoto(this.f1955do.m1833if().m1809for(), this.f1955do.m1833if().m1807catch().m1477do(), this.f1955do.m1833if().m1808else().m743interface(), this.f1955do.m1833if().m1808else().m751static(), (CoroutineDispatcher) null, 16, (r) null);
        }
    }

    /* renamed from: com.iproov.sdk.static.if$new  reason: invalid class name */
    public static final class Cnew extends Lambda implements d10.a<Cimport> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cif f1956do;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(Cif ifVar) {
            super(0);
            this.f1956do = ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final Cimport invoke() {
            return new Cimport(this.f1956do.m1833if().m1808else().m747private());
        }
    }

    @d(c = "com.iproov.sdk.impl.di.ScannerComponentImpl", f = "ScannerComponentImpl.kt", l = {134}, m = "provideValues")
    /* renamed from: com.iproov.sdk.static.if$try  reason: invalid class name */
    public static final class Ctry extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public final /* synthetic */ Cif f1957case;

        /* renamed from: do  reason: not valid java name */
        public Object f1958do;

        /* renamed from: else  reason: not valid java name */
        public int f1959else;

        /* renamed from: for  reason: not valid java name */
        public Object f1960for;

        /* renamed from: if  reason: not valid java name */
        public Object f1961if;

        /* renamed from: new  reason: not valid java name */
        public Object f1962new;

        /* renamed from: try  reason: not valid java name */
        public /* synthetic */ Object f1963try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ctry(Cif ifVar, c<? super Ctry> cVar) {
            super(cVar);
            this.f1957case = ifVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1963try = obj;
            this.f1959else |= Integer.MIN_VALUE;
            return this.f1957case.m1830do((com.iproov.sdk.p021new.Cnew) null, (com.iproov.sdk.p003case.Cif) null, this);
        }
    }

    public Cif(Cfor forR) {
        this.f1946do = forR;
    }

    /* renamed from: else  reason: not valid java name */
    private final void m1824else() {
        com.iproov.sdk.p003case.Cif ifVar;
        Cextends extendsR;
        com.iproov.sdk.p021new.Cnew newR = this.f1950if;
        if (newR != null && (ifVar = m1829do()) != null) {
            int i11 = Cdo.f1953do[ifVar.m232do().ordinal()];
            if (i11 == 1) {
                extendsR = new Cthrow(m1833if().m1809for(), newR, ifVar, m1825for(), m1833if().m1808else().m728class(), m1833if().m1808else().m742instanceof(), f.b(m1833if().m1808else().m749public()), m1833if().m1808else().m725break(), m1833if().m1808else().m760try(), m1833if().m1808else().m729const(), f.b(m1833if().m1808else().m727catch()), f.a(m1833if().m1808else().m747private()), f.b(m1833if().m1808else().m733else()), f.b(m1833if().m1808else().m737for()), m1833if().m1808else().m754switch(), m1833if().m1808else().m731default(), m1833if().m1808else().m759transient(), m1833if().m1808else().m750return(), m1833if().m1808else().a(), m1833if().m1808else().m752strictfp(), m1833if().m1811this(), m1827try(), (CoroutineDispatcher) null, 4194304, (r) null);
            } else if (i11 == 2) {
                extendsR = new Cbreak(m1833if().m1809for(), m1833if().m1807catch(), newR, ifVar, m1826new(), m1825for(), m1833if().m1808else().m759transient(), m1833if().m1808else().m762while(), f.a(m1833if().m1808else().m745new()), m1833if().m1808else().m753super(), m1833if().m1808else().m726case(), f.b(m1833if().m1808else().m736finally()), f.b(m1833if().m1808else().m757throw()), m1833if().m1808else().m755synchronized(), m1833if().m1808else().m750return(), f.b(m1833if().m1808else().m733else()), m1833if().m1808else().m754switch(), m1833if().m1808else().m731default(), m1833if().m1808else().m759transient(), m1833if().m1808else().a(), m1833if().m1808else().m734extends(), m1833if().m1808else().m752strictfp(), m1833if().m1808else().m758throws(), (CoroutineDispatcher) null, 8388608, (r) null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.f1951new = extendsR;
        }
    }

    /* renamed from: for  reason: not valid java name */
    private final Cthis m1825for() {
        return (Cthis) this.f1945case.getValue();
    }

    /* renamed from: new  reason: not valid java name */
    private final Cswitch m1826new() {
        return (Cswitch) this.f1947else.getValue();
    }

    /* renamed from: try  reason: not valid java name */
    private final Cimport m1827try() {
        return (Cimport) this.f1949goto.getValue();
    }

    /* renamed from: case  reason: not valid java name */
    public Cextends m1828case() {
        return this.f1951new;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1832do(com.iproov.sdk.p021new.Cnew newR) {
        this.f1950if = newR;
    }

    /* renamed from: if  reason: not valid java name */
    public final Cfor m1833if() {
        return this.f1946do;
    }

    /* renamed from: do  reason: not valid java name */
    public final com.iproov.sdk.p003case.Cif m1829do() {
        return this.f1948for;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1831do(com.iproov.sdk.p003case.Cif ifVar) {
        this.f1948for = ifVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1830do(com.iproov.sdk.p021new.Cnew r6, com.iproov.sdk.p003case.Cif r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.iproov.sdk.p027static.Cif.Ctry
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.iproov.sdk.static.if$try r0 = (com.iproov.sdk.p027static.Cif.Ctry) r0
            int r1 = r0.f1959else
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1959else = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.static.if$try r0 = new com.iproov.sdk.static.if$try
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f1963try
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1959else
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r4) goto L_0x003a
            java.lang.Object r6 = r0.f1962new
            kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r6
            java.lang.Object r7 = r0.f1960for
            com.iproov.sdk.case.if r7 = (com.iproov.sdk.p003case.Cif) r7
            java.lang.Object r1 = r0.f1961if
            com.iproov.sdk.new.new r1 = (com.iproov.sdk.p021new.Cnew) r1
            java.lang.Object r0 = r0.f1958do
            com.iproov.sdk.static.if r0 = (com.iproov.sdk.p027static.Cif) r0
            kotlin.k.b(r8)
            goto L_0x005b
        L_0x003a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0042:
            kotlin.k.b(r8)
            kotlinx.coroutines.sync.a r8 = r5.f1952try
            r0.f1958do = r5
            r0.f1961if = r6
            r0.f1960for = r7
            r0.f1962new = r8
            r0.f1959else = r4
            java.lang.Object r0 = r8.d(r3, r0)
            if (r0 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r0 = r5
            r1 = r6
            r6 = r8
        L_0x005b:
            r0.m1832do((com.iproov.sdk.p021new.Cnew) r1)     // Catch:{ all -> 0x006a }
            r0.m1831do((com.iproov.sdk.p003case.Cif) r7)     // Catch:{ all -> 0x006a }
            r0.m1824else()     // Catch:{ all -> 0x006a }
            kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x006a }
            r6.e(r3)
            return r7
        L_0x006a:
            r7 = move-exception
            r6.e(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p027static.Cif.m1830do(com.iproov.sdk.new.new, com.iproov.sdk.case.if, kotlin.coroutines.c):java.lang.Object");
    }
}
