package com.iproov.sdk.p026return;

import android.content.Context;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.p016if.Cfinally;
import com.iproov.sdk.p016if.Cpackage;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import d10.q;
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
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.public  reason: invalid class name and invalid package */
public final class Cpublic extends BaseCoroutineScope implements Cfinally {
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public final f1<com.iproov.sdk.p021new.Cfor> f1710case;

    /* renamed from: do  reason: not valid java name */
    private final Context f1711do;

    /* renamed from: else  reason: not valid java name */
    private final a1<Cpackage> f1712else;

    /* renamed from: for  reason: not valid java name */
    private final Cextends.Cclass f1713for;
    /* access modifiers changed from: private */

    /* renamed from: goto  reason: not valid java name */
    public com.iproov.sdk.p016if.Cextends f1714goto;

    /* renamed from: if  reason: not valid java name */
    private final com.iproov.sdk.p027static.Cif f1715if;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public final j1<com.iproov.sdk.p003case.Cif> f1716new;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public final j1<com.iproov.sdk.p021new.Cnew> f1717try;

    @d(c = "com.iproov.sdk.impl.ScannerContainerImpl$1", f = "ScannerContainerImpl.kt", l = {117}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.public$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1718do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cpublic f1719if;

        @d(c = "com.iproov.sdk.impl.ScannerContainerImpl$1$1", f = "ScannerContainerImpl.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.public$do$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements q<com.iproov.sdk.p003case.Cif, com.iproov.sdk.p021new.Cnew, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1720do;

            public Cdo(c<? super Cdo> cVar) {
                super(3, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(com.iproov.sdk.p003case.Cif ifVar, com.iproov.sdk.p021new.Cnew newR, c<? super Unit> cVar) {
                return new Cdo(cVar).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f1720do == 0) {
                    k.b(obj);
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.return.public$do$if  reason: invalid class name */
        public static final class Cif implements e<Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cpublic f1721do;

            public Cif(Cpublic publicR) {
                this.f1721do = publicR;
            }

            public Object emit(Unit unit, c<? super Unit> cVar) {
                Unit unit2 = unit;
                Object obj = this.f1721do.m1678do(cVar);
                if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
                    return obj;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cpublic publicR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1719if = publicR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f1719if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1718do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d G = f.G(f.y(this.f1719if.f1716new), f.y(this.f1719if.f1717try), new Cdo((c<? super Cdo>) null));
                Cif ifVar = new Cif(this.f1719if);
                this.f1718do = 1;
                if (G.collect(ifVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @d(c = "com.iproov.sdk.impl.ScannerContainerImpl$start$1", f = "ScannerContainerImpl.kt", l = {117}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.public$for  reason: invalid class name */
    public static final class Cfor extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1722do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cpublic f1723if;

        /* renamed from: com.iproov.sdk.return.public$for$do  reason: invalid class name */
        public static final class Cdo implements e<com.iproov.sdk.p021new.Cfor> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cpublic f1724do;

            public Cdo(Cpublic publicR) {
                this.f1724do = publicR;
            }

            public Object emit(com.iproov.sdk.p021new.Cfor forR, c<? super Unit> cVar) {
                com.iproov.sdk.p021new.Cfor forR2 = forR;
                com.iproov.sdk.p016if.Cextends extendsR = this.f1724do.f1714goto;
                if (extendsR != null) {
                    Object obj = extendsR.m766do(forR2, cVar);
                    if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
                        return obj;
                    }
                } else if (IntrinsicsKt__IntrinsicsKt.d() == null) {
                    return null;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(Cpublic publicR, c<? super Cfor> cVar) {
            super(2, cVar);
            this.f1723if = publicR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cfor(this.f1723if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cfor) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1722do;
            if (i11 == 0) {
                k.b(obj);
                f1 f1Var = this.f1723if.f1710case;
                Cdo doVar = new Cdo(this.f1723if);
                this.f1722do = 1;
                if (f1Var.collect(doVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.return.public$if  reason: invalid class name */
    public static abstract class Cif {

        /* renamed from: com.iproov.sdk.return.public$if$do  reason: invalid class name */
        public static final class Cdo extends Cif {

            /* renamed from: do  reason: not valid java name */
            private final String f1725do;

            public Cdo(String str) {
                super((r) null);
                this.f1725do = str;
            }

            /* renamed from: do  reason: not valid java name */
            public final String m1687do() {
                return this.f1725do;
            }
        }

        /* renamed from: com.iproov.sdk.return.public$if$if  reason: invalid class name */
        public static final class Cif extends Cif {

            /* renamed from: do  reason: not valid java name */
            public static final Cif f1726do = new Cif();

            private Cif() {
                super((r) null);
            }
        }

        private Cif() {
        }

        public /* synthetic */ Cif(r rVar) {
            this();
        }
    }

    @d(c = "com.iproov.sdk.impl.ScannerContainerImpl", f = "ScannerContainerImpl.kt", l = {86}, m = "tryToCreateScanner")
    /* renamed from: com.iproov.sdk.return.public$new  reason: invalid class name */
    public static final class Cnew extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f1727do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cpublic f1728for;

        /* renamed from: if  reason: not valid java name */
        public /* synthetic */ Object f1729if;

        /* renamed from: new  reason: not valid java name */
        public int f1730new;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(Cpublic publicR, c<? super Cnew> cVar) {
            super(cVar);
            this.f1728for = publicR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1729if = obj;
            this.f1730new |= Integer.MIN_VALUE;
            return this.f1728for.m1678do((c<? super Unit>) this);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cpublic(Context context, com.iproov.sdk.p027static.Cif ifVar, Cextends.Cclass classR, j1 j1Var, j1 j1Var2, f1 f1Var, a1 a1Var, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, ifVar, classR, j1Var, j1Var2, f1Var, a1Var, (i11 & 128) != 0 ? v0.a() : coroutineDispatcher);
    }

    /* renamed from: class  reason: not valid java name */
    private final Cif m1676class() {
        com.iproov.sdk.p003case.Cif value = this.f1716new.getValue();
        if ((value == null ? null : value.m232do()) == com.iproov.sdk.p003case.Cdo.GENUINE_PRESENCE_ASSURANCE && (this.f1713for.m1498new() instanceof Cextends.Ccase.Cif)) {
            return new Cif.Cdo("NaturalFilter is not available for Genuine Presence Assurance");
        }
        if (!(this.f1713for.m1498new() instanceof Cextends.Ccase.Cif) || ((Cextends.Ccase.Cif) this.f1713for.m1498new()).m1484do() != Cextends.Cbreak.BLUR || !this.f1713for.m1497if()) {
            return Cif.Cif.f1726do;
        }
        return new Cif.Cdo("Blur filter cannot be used when exterior effects are disabled");
    }

    public void doStop() {
        com.iproov.sdk.p016if.Cextends extendsR = this.f1714goto;
        if (extendsR != null) {
            extendsR.stop();
        }
        this.f1714goto = null;
    }

    public void handleCoroutineException(CoroutineContext coroutineContext, Throwable th2) {
        a1<Cpackage> a1Var = this.f1712else;
        IProovException iProovException = th2 instanceof IProovException ? (IProovException) th2 : null;
        if (iProovException == null) {
            iProovException = new UnexpectedErrorException(this.f1711do, th2);
        }
        a1Var.d(new Cpackage.Cdo(iProovException));
        super.handleCoroutineException(coroutineContext, th2);
    }

    /* renamed from: try  reason: not valid java name */
    public void m1683try() {
        Ccase.m977do(this);
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cfor(this, (c<? super Cfor>) null), 3, (Object) null);
    }

    public Cpublic(Context context, com.iproov.sdk.p027static.Cif ifVar, Cextends.Cclass classR, j1<com.iproov.sdk.p003case.Cif> j1Var, j1<? extends com.iproov.sdk.p021new.Cnew> j1Var2, f1<? extends com.iproov.sdk.p021new.Cfor> f1Var, a1<Cpackage> a1Var, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1711do = context;
        this.f1715if = ifVar;
        this.f1713for = classR;
        this.f1716new = j1Var;
        this.f1717try = j1Var2;
        this.f1710case = f1Var;
        this.f1712else = a1Var;
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1678do(kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.iproov.sdk.p026return.Cpublic.Cnew
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.iproov.sdk.return.public$new r0 = (com.iproov.sdk.p026return.Cpublic.Cnew) r0
            int r1 = r0.f1730new
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1730new = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.public$new r0 = new com.iproov.sdk.return.public$new
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f1729if
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1730new
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f1727do
            com.iproov.sdk.return.public r0 = (com.iproov.sdk.p026return.Cpublic) r0
            kotlin.k.b(r6)
            goto L_0x005e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.k.b(r6)
            com.iproov.sdk.return.public$if r6 = r5.m1676class()
            boolean r2 = r6 instanceof com.iproov.sdk.p026return.Cpublic.Cif.Cif
            if (r2 == 0) goto L_0x0067
            com.iproov.sdk.static.if r6 = r5.f1715if
            kotlinx.coroutines.flow.j1<com.iproov.sdk.new.new> r2 = r5.f1717try
            java.lang.Object r2 = r2.getValue()
            com.iproov.sdk.new.new r2 = (com.iproov.sdk.p021new.Cnew) r2
            kotlinx.coroutines.flow.j1<com.iproov.sdk.case.if> r4 = r5.f1716new
            java.lang.Object r4 = r4.getValue()
            com.iproov.sdk.case.if r4 = (com.iproov.sdk.p003case.Cif) r4
            r0.f1727do = r5
            r0.f1730new = r3
            java.lang.Object r6 = r6.m1830do(r2, r4, r0)
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r0 = r5
        L_0x005e:
            com.iproov.sdk.static.if r6 = r0.f1715if
            com.iproov.sdk.if.extends r6 = r6.m1828case()
            r0.f1714goto = r6
            goto L_0x0085
        L_0x0067:
            boolean r0 = r6 instanceof com.iproov.sdk.p026return.Cpublic.Cif.Cdo
            if (r0 == 0) goto L_0x0085
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.package> r0 = r5.f1712else
            com.iproov.sdk.if.package$do r1 = new com.iproov.sdk.if.package$do
            com.iproov.sdk.core.exception.InvalidOptionsException r2 = new com.iproov.sdk.core.exception.InvalidOptionsException
            android.content.Context r3 = r5.f1711do
            com.iproov.sdk.return.public$if$do r6 = (com.iproov.sdk.p026return.Cpublic.Cif.Cdo) r6
            java.lang.String r6 = r6.m1687do()
            r2.<init>((android.content.Context) r3, (java.lang.String) r6)
            r1.<init>(r2)
            r0.d(r1)
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        L_0x0085:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cpublic.m1678do(kotlin.coroutines.c):java.lang.Object");
    }
}
