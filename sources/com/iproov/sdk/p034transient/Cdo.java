package com.iproov.sdk.p034transient;

import android.content.Context;
import android.util.Size;
import com.iproov.sdk.IProovState;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.ServerException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.p016if.Ccontinue;
import com.iproov.sdk.p016if.Cdefault;
import com.iproov.sdk.p016if.Cfinally;
import com.iproov.sdk.p016if.Cfor;
import com.iproov.sdk.p016if.Cgoto;
import com.iproov.sdk.p016if.Cinstanceof;
import com.iproov.sdk.p016if.Cinterface;
import com.iproov.sdk.p016if.Cpackage;
import com.iproov.sdk.p016if.Cprivate;
import com.iproov.sdk.p016if.Cstrictfp;
import com.iproov.sdk.p016if.Csynchronized;
import com.iproov.sdk.p016if.Ctransient;
import com.iproov.sdk.p016if.Cvolatile;
import com.iproov.sdk.utils.BaseCoroutineScope;
import com.tinder.StateMachine;
import d10.l;
import d10.p;
import d10.q;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.transient.do  reason: invalid class name and invalid package */
public final class Cdo extends BaseCoroutineScope implements Ctransient {

    /* renamed from: break  reason: not valid java name */
    private final Cprivate f2155break;
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public final Cfinally f2156case;

    /* renamed from: catch  reason: not valid java name */
    private final com.iproov.sdk.crypto.Cdo f2157catch;
    /* access modifiers changed from: private */

    /* renamed from: class  reason: not valid java name */
    public com.iproov.sdk.core.Cnew f2158class;
    /* access modifiers changed from: private */

    /* renamed from: const  reason: not valid java name */
    public com.iproov.sdk.core.Cthis f2159const;
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final Context f2160do;

    /* renamed from: else  reason: not valid java name */
    private final Ccontinue f2161else;
    /* access modifiers changed from: private */

    /* renamed from: final  reason: not valid java name */
    public final StateMachine<Ccatch, Cbreak, Cthis> f2162final;

    /* renamed from: for  reason: not valid java name */
    private final com.iproov.sdk.p016if.Cdo f2163for;
    /* access modifiers changed from: private */

    /* renamed from: goto  reason: not valid java name */
    public final com.iproov.sdk.p035try.Cif f2164goto;
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final Cdefault f2165if;

    /* renamed from: new  reason: not valid java name */
    private final com.iproov.sdk.p016if.Ccase f2166new;
    /* access modifiers changed from: private */

    /* renamed from: this  reason: not valid java name */
    public final Cinterface f2167this;

    /* renamed from: try  reason: not valid java name */
    private final com.iproov.sdk.p016if.Cwhile f2168try;

    /* renamed from: com.iproov.sdk.transient.do$break  reason: invalid class name */
    public static abstract class Cbreak {

        /* renamed from: com.iproov.sdk.transient.do$break$break  reason: invalid class name */
        public static final class Cbreak extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            public static final Cbreak f2169do = new Cbreak();

            private Cbreak() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$break$case  reason: invalid class name */
        public static final class Ccase extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            public static final Ccase f2170do = new Ccase();

            private Ccase() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$break$do  reason: invalid class name */
        public static final class Cdo extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            public static final Cdo f2171do = new Cdo();

            private Cdo() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$break$else  reason: invalid class name */
        public static final class Celse extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            public static final Celse f2172do = new Celse();

            private Celse() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$break$for  reason: invalid class name */
        public static final class Cfor extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            public static final Cfor f2173do = new Cfor();

            private Cfor() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$break$goto  reason: invalid class name */
        public static final class Cgoto extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            private final double f2174do;

            public Cgoto(double d11) {
                super((r) null);
                this.f2174do = d11;
            }

            /* renamed from: do  reason: not valid java name */
            public final double m2062do() {
                return this.f2174do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cgoto) && x.b(Double.valueOf(this.f2174do), Double.valueOf(((Cgoto) obj).f2174do));
            }

            public int hashCode() {
                return Double.doubleToLongBits(this.f2174do);
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p009do.Cdo.m564do(this.f2174do);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$break$if  reason: invalid class name */
        public static final class Cif extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.Cif f2175do;

            public Cif(com.iproov.sdk.Cif ifVar) {
                super((r) null);
                this.f2175do = ifVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.Cif m2063do() {
                return this.f2175do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cif) && this.f2175do == ((Cif) obj).f2175do;
            }

            public int hashCode() {
                return this.f2175do.hashCode();
            }

            public String toString() {
                return "Cancelled(canceller=" + this.f2175do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$break$new  reason: invalid class name */
        public static final class Cnew extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            private final IProovException f2176do;

            public Cnew(IProovException iProovException) {
                super((r) null);
                this.f2176do = iProovException;
            }

            /* renamed from: do  reason: not valid java name */
            public final IProovException m2064do() {
                return this.f2176do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cnew) && x.b(this.f2176do, ((Cnew) obj).f2176do);
            }

            public int hashCode() {
                return this.f2176do.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p009do.Cdo.m565do(this.f2176do);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$break$this  reason: invalid class name */
        public static final class Cthis extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.p035try.Cdo f2177do;

            public Cthis(com.iproov.sdk.p035try.Cdo doVar) {
                super((r) null);
                this.f2177do = doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.p035try.Cdo m2065do() {
                return this.f2177do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cthis) && x.b(this.f2177do, ((Cthis) obj).f2177do);
            }

            public int hashCode() {
                return this.f2177do.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p017implements.Cfinal.m1003do(this.f2177do);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$break$try  reason: invalid class name */
        public static final class Ctry extends Cbreak {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.p003case.Cif f2178do;

            public Ctry(com.iproov.sdk.p003case.Cif ifVar) {
                super((r) null);
                this.f2178do = ifVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.p003case.Cif m2066do() {
                return this.f2178do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Ctry) && x.b(this.f2178do, ((Ctry) obj).f2178do);
            }

            public int hashCode() {
                return this.f2178do.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p017implements.Cfinal.m1002do(this.f2178do);
            }
        }

        private Cbreak() {
        }

        public /* synthetic */ Cbreak(r rVar) {
            this();
        }

        public String toString() {
            return "Event [" + getClass().getSimpleName() + ']';
        }
    }

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$6", f = "BiometricScannerUseCase.kt", l = {609}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$case  reason: invalid class name */
    public static final class Ccase extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2179do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f2180for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f2181if;

        /* renamed from: com.iproov.sdk.transient.do$case$do  reason: invalid class name */
        public static final class Cdo implements e<com.iproov.sdk.p016if.Cgoto> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f2182do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f2183if;

            public Cdo(h0 h0Var, Cdo doVar) {
                this.f2182do = h0Var;
                this.f2183if = doVar;
            }

            public Object emit(com.iproov.sdk.p016if.Cgoto gotoR, c<? super Unit> cVar) {
                com.iproov.sdk.p016if.Cgoto gotoR2 = gotoR;
                com.iproov.sdk.p017implements.Ccase.m977do(this.f2182do);
                x.i("Received: encoder ", gotoR2);
                if (gotoR2 instanceof Cgoto.Cdo) {
                    this.f2183if.f2162final.f(new Cbreak.Cnew(((Cgoto.Cdo) gotoR2).m771do()));
                } else if (gotoR2 instanceof Cgoto.Cif) {
                    this.f2183if.f2162final.f(Cbreak.Cfor.f2173do);
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ccase(Cdo doVar, c<? super Ccase> cVar) {
            super(2, cVar);
            this.f2180for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Ccase caseR = new Ccase(this.f2180for, cVar);
            caseR.f2181if = obj;
            return caseR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Ccase) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2179do;
            if (i11 == 0) {
                k.b(obj);
                a1<com.iproov.sdk.p016if.Cgoto> f11 = this.f2180for.f2165if.f();
                Cdo doVar = new Cdo((h0) this.f2181if, this.f2180for);
                this.f2179do = 1;
                if (f11.collect(doVar, this) == d11) {
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

    /* renamed from: com.iproov.sdk.transient.do$catch  reason: invalid class name */
    public static abstract class Ccatch {

        /* renamed from: com.iproov.sdk.transient.do$catch$case  reason: invalid class name */
        public static final class Ccase extends Ccatch {

            /* renamed from: do  reason: not valid java name */
            public static final Ccase f2184do = new Ccase();

            private Ccase() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$catch$do  reason: invalid class name */
        public static final class Cdo extends Ccatch {

            /* renamed from: do  reason: not valid java name */
            public static final Cdo f2185do = new Cdo();

            private Cdo() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$catch$else  reason: invalid class name */
        public static final class Celse extends Ccatch {

            /* renamed from: do  reason: not valid java name */
            public static final Celse f2186do = new Celse();

            private Celse() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$catch$for  reason: invalid class name */
        public static final class Cfor extends Ccatch {

            /* renamed from: do  reason: not valid java name */
            public static final Cfor f2187do = new Cfor();

            private Cfor() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$catch$if  reason: invalid class name */
        public static final class Cif extends Ccatch {

            /* renamed from: do  reason: not valid java name */
            public static final Cif f2188do = new Cif();

            private Cif() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$catch$new  reason: invalid class name */
        public static final class Cnew extends Ccatch {

            /* renamed from: do  reason: not valid java name */
            public static final Cnew f2189do = new Cnew();

            private Cnew() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$catch$try  reason: invalid class name */
        public static final class Ctry extends Ccatch {

            /* renamed from: do  reason: not valid java name */
            public static final Ctry f2190do = new Ctry();

            private Ctry() {
                super((r) null);
            }
        }

        private Ccatch() {
        }

        public /* synthetic */ Ccatch(r rVar) {
            this();
        }

        public String toString() {
            return "State [" + getClass().getSimpleName() + ']';
        }
    }

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$actionAbortUI$2", f = "BiometricScannerUseCase.kt", l = {434}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$class  reason: invalid class name */
    public static final class Cclass extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2191do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f2192if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cclass(Cdo doVar, c<? super Cclass> cVar) {
            super(2, cVar);
            this.f2192if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cclass(this.f2192if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cclass) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2191do;
            if (i11 == 0) {
                k.b(obj);
                a1<Cinstanceof> a1Var = this.f2192if.f2165if.m744native();
                Cinstanceof.Cdo doVar = Cinstanceof.Cdo.f697do;
                this.f2191do = 1;
                if (a1Var.emit(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$actionCloseUI$2", f = "BiometricScannerUseCase.kt", l = {440}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$const  reason: invalid class name */
    public static final class Cconst extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2193do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f2194if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cconst(Cdo doVar, c<? super Cconst> cVar) {
            super(2, cVar);
            this.f2194if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cconst(this.f2194if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cconst) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2193do;
            if (i11 == 0) {
                k.b(obj);
                a1<Cinstanceof> a1Var = this.f2194if.f2165if.m744native();
                Cinstanceof.Cif ifVar = Cinstanceof.Cif.f698do;
                this.f2193do = 1;
                if (a1Var.emit(ifVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$1", f = "BiometricScannerUseCase.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2195do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f2196if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cdo doVar, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f2196if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f2196if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f2195do == 0) {
                k.b(obj);
                Cdo doVar = this.f2196if;
                doVar.f2158class = new com.iproov.sdk.core.Cnew(doVar.f2160do);
                this.f2196if.f2159const = new com.iproov.sdk.core.Cthis(this.f2196if.f2160do);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$7", f = "BiometricScannerUseCase.kt", l = {609}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$else  reason: invalid class name */
    public static final class Celse extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2197do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f2198if;

        /* renamed from: com.iproov.sdk.transient.do$else$do  reason: invalid class name */
        public static final class Cdo implements e<com.iproov.sdk.p016if.Cbreak> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cdo f2199do;

            public Cdo(Cdo doVar) {
                this.f2199do = doVar;
            }

            public Object emit(com.iproov.sdk.p016if.Cbreak breakR, c<? super Unit> cVar) {
                Object obj = this.f2199do.m2034do(breakR.m718do(), cVar);
                if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
                    return obj;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Celse(Cdo doVar, c<? super Celse> cVar) {
            super(2, cVar);
            this.f2198if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Celse(this.f2198if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Celse) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2197do;
            if (i11 == 0) {
                k.b(obj);
                a1<com.iproov.sdk.p016if.Cbreak> a1Var = this.f2198if.f2165if.m746package();
                Cdo doVar = new Cdo(this.f2198if);
                this.f2197do = 1;
                if (a1Var.collect(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase", f = "BiometricScannerUseCase.kt", l = {504, 505}, m = "actionReportResultAndCloseUI")
    /* renamed from: com.iproov.sdk.transient.do$final  reason: invalid class name */
    public static final class Cfinal extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f2200do;

        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ Object f2201for;

        /* renamed from: if  reason: not valid java name */
        public Object f2202if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cdo f2203new;

        /* renamed from: try  reason: not valid java name */
        public int f2204try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfinal(Cdo doVar, c<? super Cfinal> cVar) {
            super(cVar);
            this.f2203new = doVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f2201for = obj;
            this.f2204try |= Integer.MIN_VALUE;
            return this.f2203new.m2038do((Cthis.Cthis) null, (c<? super Unit>) this);
        }
    }

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$3", f = "BiometricScannerUseCase.kt", l = {609}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$for  reason: invalid class name */
    public static final class Cfor extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2205do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f2206for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f2207if;

        /* renamed from: com.iproov.sdk.transient.do$for$do  reason: invalid class name */
        public static final class Cdo implements e<Cpackage> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f2208do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f2209if;

            public Cdo(h0 h0Var, Cdo doVar) {
                this.f2208do = h0Var;
                this.f2209if = doVar;
            }

            public Object emit(Cpackage packageR, c<? super Unit> cVar) {
                Cpackage packageR2 = packageR;
                com.iproov.sdk.p017implements.Ccase.m977do(this.f2208do);
                x.i("Received: scanner ", packageR2);
                if (packageR2 instanceof Cpackage.Cdo) {
                    StateMachine.b f11 = this.f2209if.f2162final.f(new Cbreak.Cnew(((Cpackage.Cdo) packageR2).m791do()));
                    if (f11 == IntrinsicsKt__IntrinsicsKt.d()) {
                        return f11;
                    }
                    return Unit.f56620a;
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(Cdo doVar, c<? super Cfor> cVar) {
            super(2, cVar);
            this.f2206for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cfor forR = new Cfor(this.f2206for, cVar);
            forR.f2207if = obj;
            return forR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cfor) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2205do;
            if (i11 == 0) {
                k.b(obj);
                a1<Cpackage> a1Var = this.f2206for.f2165if.m754switch();
                Cdo doVar = new Cdo((h0) this.f2207if, this.f2206for);
                this.f2205do = 1;
                if (a1Var.collect(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$8", f = "BiometricScannerUseCase.kt", l = {609}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$goto  reason: invalid class name */
    public static final class Cgoto extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2210do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f2211for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f2212if;

        /* renamed from: com.iproov.sdk.transient.do$goto$do  reason: invalid class name */
        public static final class Cdo implements e<Csynchronized> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f2213do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f2214if;

            public Cdo(h0 h0Var, Cdo doVar) {
                this.f2213do = h0Var;
                this.f2214if = doVar;
            }

            public Object emit(Csynchronized synchronizedR, c<? super Unit> cVar) {
                Csynchronized synchronizedR2 = synchronizedR;
                com.iproov.sdk.p017implements.Ccase.m977do(this.f2213do);
                x.i("Received: view ", synchronizedR2);
                if (synchronizedR2 instanceof Csynchronized.Cdo) {
                    this.f2214if.f2162final.f(new Cbreak.Cnew(((Csynchronized.Cdo) synchronizedR2).m836do()));
                } else if (synchronizedR2 instanceof Csynchronized.Cif) {
                    this.f2214if.f2162final.f(Cbreak.Cbreak.f2169do);
                } else if (synchronizedR2 instanceof Csynchronized.Cfor) {
                    this.f2214if.f2162final.f(new Cbreak.Cif(com.iproov.sdk.Cif.USER));
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cgoto(Cdo doVar, c<? super Cgoto> cVar) {
            super(2, cVar);
            this.f2211for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cgoto gotoR = new Cgoto(this.f2211for, cVar);
            gotoR.f2212if = obj;
            return gotoR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cgoto) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2210do;
            if (i11 == 0) {
                k.b(obj);
                a1<Csynchronized> a1Var = this.f2211for.f2165if.m735final();
                Cdo doVar = new Cdo((h0) this.f2212if, this.f2211for);
                this.f2210do = 1;
                if (a1Var.collect(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$2", f = "BiometricScannerUseCase.kt", l = {609}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2215do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f2216for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f2217if;

        /* renamed from: com.iproov.sdk.transient.do$if$do  reason: invalid class name */
        public static final class Cdo implements e<Cvolatile> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f2218do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f2219if;

            public Cdo(h0 h0Var, Cdo doVar) {
                this.f2218do = h0Var;
                this.f2219if = doVar;
            }

            public Object emit(Cvolatile volatileR, c<? super Unit> cVar) {
                Object obj;
                Object obj2;
                Cvolatile volatileR2 = volatileR;
                com.iproov.sdk.p017implements.Ccase.m977do(this.f2218do);
                x.i("Received: streamer ", volatileR2);
                Unit unit = null;
                if (volatileR2 instanceof Cvolatile.Cif) {
                    obj = Cbreak.Ccase.f2170do;
                } else if (volatileR2 instanceof Cvolatile.Cdo) {
                    obj = Cbreak.Celse.f2172do;
                } else {
                    if (volatileR2 instanceof Cvolatile.Ccase) {
                        obj2 = new Cbreak.Ctry(((Cvolatile.Ccase) volatileR2).m844do());
                    } else if (volatileR2 instanceof Cvolatile.Cgoto) {
                        obj2 = new Cbreak.Cgoto(((Cvolatile.Cgoto) volatileR2).m846do());
                    } else if (volatileR2 instanceof Cvolatile.Celse) {
                        obj2 = new Cbreak.Cthis(((Cvolatile.Celse) volatileR2).m845do());
                    } else if (volatileR2 instanceof Cvolatile.Ctry) {
                        obj2 = new Cbreak.Cnew(((Cvolatile.Ctry) volatileR2).m847do());
                    } else {
                        obj = volatileR2 instanceof Cvolatile.Cnew ? new Cbreak.Cnew(new NetworkException(this.f2219if.f2160do, "Claim timeout, socket disconnected")) : null;
                    }
                    obj = obj2;
                }
                if (obj != null) {
                    this.f2219if.f2162final.f(obj);
                    unit = Unit.f56620a;
                }
                if (unit == IntrinsicsKt__IntrinsicsKt.d()) {
                    return unit;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cdo doVar, c<? super Cif> cVar) {
            super(2, cVar);
            this.f2216for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cif ifVar = new Cif(this.f2216for, cVar);
            ifVar.f2217if = obj;
            return ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2215do;
            if (i11 == 0) {
                k.b(obj);
                a1<Cvolatile> a1Var = this.f2216for.f2165if.m740implements();
                Cdo doVar = new Cdo((h0) this.f2217if, this.f2216for);
                this.f2215do = 1;
                if (a1Var.collect(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$4", f = "BiometricScannerUseCase.kt", l = {609}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$new  reason: invalid class name */
    public static final class Cnew extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2220do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cdo f2221if;

        /* renamed from: com.iproov.sdk.transient.do$new$do  reason: invalid class name */
        public static final class Cdo implements e<Size> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cdo f2222do;

            public Cdo(Cdo doVar) {
                this.f2222do = doVar;
            }

            public Object emit(Size size, c<? super Unit> cVar) {
                Size size2 = size;
                StateMachine.b f11 = this.f2222do.f2162final.f(Cbreak.Cdo.f2171do);
                if (f11 == IntrinsicsKt__IntrinsicsKt.d()) {
                    return f11;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(Cdo doVar, c<? super Cnew> cVar) {
            super(2, cVar);
            this.f2221if = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cnew(this.f2221if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cnew) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2220do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d<Size> y11 = f.y(this.f2221if.f2165if.m749public());
                Cdo doVar = new Cdo(this.f2221if);
                this.f2220do = 1;
                if (y11.collect(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$actionStartUI$1", f = "BiometricScannerUseCase.kt", l = {459, 460}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$super  reason: invalid class name */
    public static final class Csuper extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2223do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f2224for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f2225if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cbreak f2226new;

        @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$actionStartUI$1$1", f = "BiometricScannerUseCase.kt", l = {609}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.transient.do$super$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f2227do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Cbreak f2228for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f2229if;

            @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$actionStartUI$1$1$1", f = "BiometricScannerUseCase.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.iproov.sdk.transient.do$super$do$do  reason: invalid class name */
            public static final class Cdo extends SuspendLambda implements q<com.iproov.sdk.p003case.Cif, com.iproov.sdk.p021new.Cnew, c<? super Unit>, Object> {

                /* renamed from: do  reason: not valid java name */
                public int f2230do;

                public Cdo(c<? super Cdo> cVar) {
                    super(3, cVar);
                }

                /* renamed from: do  reason: not valid java name */
                public final Object invoke(com.iproov.sdk.p003case.Cif ifVar, com.iproov.sdk.p021new.Cnew newR, c<? super Unit> cVar) {
                    return new Cdo(cVar).invokeSuspend(Unit.f56620a);
                }

                public final Object invokeSuspend(Object obj) {
                    Object unused = IntrinsicsKt__IntrinsicsKt.d();
                    if (this.f2230do == 0) {
                        k.b(obj);
                        return Unit.f56620a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$super$do$for  reason: invalid class name */
            public static final class Cfor implements e<Unit> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ Cdo f2231do;

                /* renamed from: if  reason: not valid java name */
                public final /* synthetic */ Cbreak f2232if;

                public Cfor(Cdo doVar, Cbreak breakR) {
                    this.f2231do = doVar;
                    this.f2232if = breakR;
                }

                public Object emit(Unit unit, c<? super Unit> cVar) {
                    Unit unit2 = unit;
                    this.f2231do.f2167this.m787do(((Cbreak.Ctry) this.f2232if).m2066do().m232do());
                    return Unit.f56620a;
                }
            }

            @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$actionStartUI$1$1$2", f = "BiometricScannerUseCase.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.iproov.sdk.transient.do$super$do$if  reason: invalid class name */
            public static final class Cif extends SuspendLambda implements q<Unit, com.iproov.sdk.p005class.Cnew, c<? super Unit>, Object> {

                /* renamed from: do  reason: not valid java name */
                public int f2233do;

                public Cif(c<? super Cif> cVar) {
                    super(3, cVar);
                }

                /* renamed from: do  reason: not valid java name */
                public final Object invoke(Unit unit, com.iproov.sdk.p005class.Cnew newR, c<? super Unit> cVar) {
                    return new Cif(cVar).invokeSuspend(Unit.f56620a);
                }

                public final Object invokeSuspend(Object obj) {
                    Object unused = IntrinsicsKt__IntrinsicsKt.d();
                    if (this.f2233do == 0) {
                        k.b(obj);
                        return Unit.f56620a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cdo doVar, Cbreak breakR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f2229if = doVar;
                this.f2228for = breakR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f2229if, this.f2228for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f2227do;
                if (i11 == 0) {
                    k.b(obj);
                    kotlinx.coroutines.flow.d<R> G = f.G(f.G(f.y(this.f2229if.f2165if.m741import()), f.y(this.f2229if.f2165if.m739if()), new Cdo((c<? super Cdo>) null)), f.y(this.f2229if.f2165if.m724abstract()), new Cif((c<? super Cif>) null));
                    Cfor forR = new Cfor(this.f2229if, this.f2228for);
                    this.f2227do = 1;
                    if (G.collect(forR, this) == d11) {
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Csuper(Cdo doVar, Cbreak breakR, c<? super Csuper> cVar) {
            super(2, cVar);
            this.f2224for = doVar;
            this.f2226new = breakR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Csuper superR = new Csuper(this.f2224for, this.f2226new, cVar);
            superR.f2225if = obj;
            return superR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Csuper) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2223do;
            if (i11 == 0) {
                k.b(obj);
                n1 unused = i.d((h0) this.f2225if, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this.f2224for, this.f2226new, (c<? super Cdo>) null), 3, (Object) null);
                b1<com.iproov.sdk.p003case.Cif> b1Var = this.f2224for.f2165if.m741import();
                com.iproov.sdk.p003case.Cif ifVar = ((Cbreak.Ctry) this.f2226new).m2066do();
                this.f2223do = 1;
                if (b1Var.emit(ifVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else if (i11 == 2) {
                k.b(obj);
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b1<com.iproov.sdk.p005class.Cnew> b1Var2 = this.f2224for.f2165if.m724abstract();
            com.iproov.sdk.p005class.Cnew newR = new com.iproov.sdk.p005class.Cnew(((Cbreak.Ctry) this.f2226new).m2066do().m236if());
            this.f2223do = 2;
            if (b1Var2.emit(newR, this) == d11) {
                return d11;
            }
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.transient.do$this  reason: invalid class name */
    public static abstract class Cthis {

        /* renamed from: com.iproov.sdk.transient.do$this$break  reason: invalid class name */
        public static final class Cbreak extends Cthis {

            /* renamed from: do  reason: not valid java name */
            public static final Cbreak f2234do = new Cbreak();

            private Cbreak() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$case  reason: invalid class name */
        public static final class Ccase extends Cthis {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.Cif f2235do;

            public Ccase(com.iproov.sdk.Cif ifVar) {
                super((r) null);
                this.f2235do = ifVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.Cif m2080do() {
                return this.f2235do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Ccase) && this.f2235do == ((Ccase) obj).f2235do;
            }

            public int hashCode() {
                return this.f2235do.hashCode();
            }

            public String toString() {
                return x.i(super.toString(), " Cancelled");
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$catch  reason: invalid class name */
        public static final class Ccatch extends Cthis {

            /* renamed from: do  reason: not valid java name */
            public static final Ccatch f2236do = new Ccatch();

            private Ccatch() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$class  reason: invalid class name */
        public static final class Cclass extends Cthis {

            /* renamed from: do  reason: not valid java name */
            public static final Cclass f2237do = new Cclass();

            private Cclass() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$const  reason: invalid class name */
        public static final class Cconst extends Cthis {

            /* renamed from: do  reason: not valid java name */
            public static final Cconst f2238do = new Cconst();

            private Cconst() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$do  reason: invalid class name */
        public static final class Cdo extends Cthis {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.Cif f2239do;

            public Cdo(com.iproov.sdk.Cif ifVar) {
                super((r) null);
                this.f2239do = ifVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.Cif m2081do() {
                return this.f2239do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cdo) && this.f2239do == ((Cdo) obj).f2239do;
            }

            public int hashCode() {
                return this.f2239do.hashCode();
            }

            public String toString() {
                return "AbortClaimAndReportCancelled(canceller=" + this.f2239do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$else  reason: invalid class name */
        public static final class Celse extends Cthis {

            /* renamed from: do  reason: not valid java name */
            private final IProovException f2240do;

            public Celse(IProovException iProovException) {
                super((r) null);
                this.f2240do = iProovException;
            }

            /* renamed from: do  reason: not valid java name */
            public final IProovException m2082do() {
                return this.f2240do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Celse) && x.b(this.f2240do, ((Celse) obj).f2240do);
            }

            public int hashCode() {
                return this.f2240do.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p009do.Cdo.m565do(this.f2240do);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$final  reason: invalid class name */
        public static final class Cfinal extends Cthis {

            /* renamed from: do  reason: not valid java name */
            private final double f2241do;

            public Cfinal(double d11) {
                super((r) null);
                this.f2241do = d11;
            }

            /* renamed from: do  reason: not valid java name */
            public final double m2083do() {
                return this.f2241do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cfinal) && x.b(Double.valueOf(this.f2241do), Double.valueOf(((Cfinal) obj).f2241do));
            }

            public int hashCode() {
                return Double.doubleToLongBits(this.f2241do);
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p009do.Cdo.m564do(this.f2241do);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$for  reason: invalid class name */
        public static final class Cfor extends Cthis {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.Cif f2242do;

            public Cfor(com.iproov.sdk.Cif ifVar) {
                super((r) null);
                this.f2242do = ifVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.Cif m2084do() {
                return this.f2242do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cfor) && this.f2242do == ((Cfor) obj).f2242do;
            }

            public int hashCode() {
                return this.f2242do.hashCode();
            }

            public String toString() {
                return "AbortUIAndClaimAndReportCancelled(canceller=" + this.f2242do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$goto  reason: invalid class name */
        public static final class Cgoto extends Cthis {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.p035try.Cdo f2243do;

            public Cgoto(com.iproov.sdk.p035try.Cdo doVar) {
                super((r) null);
                this.f2243do = doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.p035try.Cdo m2085do() {
                return this.f2243do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cgoto) && x.b(this.f2243do, ((Cgoto) obj).f2243do);
            }

            public int hashCode() {
                return this.f2243do.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p017implements.Cfinal.m1003do(this.f2243do);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$if  reason: invalid class name */
        public static final class Cif extends Cthis {

            /* renamed from: do  reason: not valid java name */
            private final IProovException f2244do;

            public Cif(IProovException iProovException) {
                super((r) null);
                this.f2244do = iProovException;
            }

            /* renamed from: do  reason: not valid java name */
            public final IProovException m2086do() {
                return this.f2244do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cif) && x.b(this.f2244do, ((Cif) obj).f2244do);
            }

            public int hashCode() {
                return this.f2244do.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p009do.Cdo.m565do(this.f2244do);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$new  reason: invalid class name */
        public static final class Cnew extends Cthis {

            /* renamed from: do  reason: not valid java name */
            private final IProovException f2245do;

            public Cnew(IProovException iProovException) {
                super((r) null);
                this.f2245do = iProovException;
            }

            /* renamed from: do  reason: not valid java name */
            public final IProovException m2087do() {
                return this.f2245do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cnew) && x.b(this.f2245do, ((Cnew) obj).f2245do);
            }

            public int hashCode() {
                return this.f2245do.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p009do.Cdo.m565do(this.f2245do);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$this  reason: invalid class name */
        public static final class Cthis extends Cthis {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.p035try.Cdo f2246do;

            public Cthis(com.iproov.sdk.p035try.Cdo doVar) {
                super((r) null);
                this.f2246do = doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.p035try.Cdo m2088do() {
                return this.f2246do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cthis) && x.b(this.f2246do, ((Cthis) obj).f2246do);
            }

            public int hashCode() {
                return this.f2246do.hashCode();
            }

            public String toString() {
                return super.toString() + ' ' + com.iproov.sdk.p017implements.Cfinal.m1003do(this.f2246do);
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$this$try  reason: invalid class name */
        public static final class Ctry extends Cthis {

            /* renamed from: do  reason: not valid java name */
            public static final Ctry f2247do = new Ctry();

            private Ctry() {
                super((r) null);
            }
        }

        private Cthis() {
        }

        public /* synthetic */ Cthis(r rVar) {
            this();
        }

        public String toString() {
            return "Action [" + getClass().getSimpleName() + ']';
        }
    }

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase", f = "BiometricScannerUseCase.kt", l = {390, 398}, m = "sendFrame")
    /* renamed from: com.iproov.sdk.transient.do$throw  reason: invalid class name */
    public static final class Cthrow extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public final /* synthetic */ Cdo f2248case;

        /* renamed from: do  reason: not valid java name */
        public Object f2249do;

        /* renamed from: else  reason: not valid java name */
        public int f2250else;

        /* renamed from: for  reason: not valid java name */
        public Object f2251for;

        /* renamed from: if  reason: not valid java name */
        public Object f2252if;

        /* renamed from: new  reason: not valid java name */
        public Object f2253new;

        /* renamed from: try  reason: not valid java name */
        public /* synthetic */ Object f2254try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cthrow(Cdo doVar, c<? super Cthrow> cVar) {
            super(cVar);
            this.f2248case = doVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f2254try = obj;
            this.f2250else |= Integer.MIN_VALUE;
            return this.f2248case.m2034do((com.iproov.sdk.p016if.Ctry) null, (c<? super Unit>) this);
        }
    }

    @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$5", f = "BiometricScannerUseCase.kt", l = {609}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.transient.do$try  reason: invalid class name */
    public static final class Ctry extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2255do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cdo f2256for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f2257if;

        /* renamed from: com.iproov.sdk.transient.do$try$do  reason: invalid class name */
        public static final class Cdo implements e<com.iproov.sdk.p016if.Cfor> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f2258do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f2259if;

            public Cdo(h0 h0Var, Cdo doVar) {
                this.f2258do = h0Var;
                this.f2259if = doVar;
            }

            public Object emit(com.iproov.sdk.p016if.Cfor forR, c<? super Unit> cVar) {
                com.iproov.sdk.p016if.Cfor forR2 = forR;
                com.iproov.sdk.p017implements.Ccase.m977do(this.f2258do);
                x.i("Received: camera ", forR2);
                if (forR2 instanceof Cfor.Cdo) {
                    this.f2259if.f2162final.f(new Cbreak.Cnew(((Cfor.Cdo) forR2).m770do()));
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ctry(Cdo doVar, c<? super Ctry> cVar) {
            super(2, cVar);
            this.f2256for = doVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Ctry tryR = new Ctry(this.f2256for, cVar);
            tryR.f2257if = obj;
            return tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Ctry) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2255do;
            if (i11 == 0) {
                k.b(obj);
                a1<com.iproov.sdk.p016if.Cfor> a1Var = this.f2256for.f2165if.m742instanceof();
                Cdo doVar = new Cdo((h0) this.f2257if, this.f2256for);
                this.f2255do = 1;
                if (a1Var.collect(doVar, this) == d11) {
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

    /* renamed from: com.iproov.sdk.transient.do$while  reason: invalid class name */
    public static final class Cwhile extends Lambda implements l<StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cdo f2260do;

        /* renamed from: com.iproov.sdk.transient.do$while$case  reason: invalid class name */
        public static final class Ccase extends Lambda implements l<StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public static final Ccase f2261do = new Ccase();

            /* renamed from: com.iproov.sdk.transient.do$while$case$do  reason: invalid class name */
            public static final class Cdo extends Lambda implements p<Ccatch.Celse, Cbreak.Cthis, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse> f2262do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse> stateDefinitionBuilder) {
                    super(2);
                    this.f2262do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Celse elseR, Cbreak.Cthis thisR) {
                    return this.f2262do.e(elseR, Ccatch.Cnew.f2189do, new Cthis.Cgoto(thisR.m2065do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$case$for  reason: invalid class name */
            public static final class Cfor extends Lambda implements p<Ccatch.Celse, Cbreak.Cnew, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse> f2263do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cfor(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse> stateDefinitionBuilder) {
                    super(2);
                    this.f2263do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Celse elseR, Cbreak.Cnew newR) {
                    return this.f2263do.e(elseR, Ccatch.Cnew.f2189do, new Cthis.Cif(newR.m2064do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$case$if  reason: invalid class name */
            public static final class Cif extends Lambda implements p<Ccatch.Celse, Cbreak.Cif, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse> f2264do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cif(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse> stateDefinitionBuilder) {
                    super(2);
                    this.f2264do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Celse elseR, Cbreak.Cif ifVar) {
                    return this.f2264do.e(elseR, Ccatch.Cnew.f2189do, new Cthis.Cdo(ifVar.m2063do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$case$new  reason: invalid class name */
            public static final class Cnew extends Lambda implements p<Ccatch.Celse, Cbreak.Cgoto, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse> f2265do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cnew(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse> stateDefinitionBuilder) {
                    super(2);
                    this.f2265do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Celse elseR, Cbreak.Cgoto gotoR) {
                    return this.f2265do.b(elseR, new Cthis.Cfinal(gotoR.m2062do()));
                }
            }

            public Ccase() {
                super(1);
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2091do(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Celse> stateDefinitionBuilder) {
                Cdo doVar = new Cdo(stateDefinitionBuilder);
                StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cthis.class), doVar);
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cif.class), new Cif(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cnew.class), new Cfor(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cgoto.class), new Cnew(stateDefinitionBuilder));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2091do((StateMachine.GraphBuilder.StateDefinitionBuilder) obj);
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$while$do  reason: invalid class name */
        public static final class Cdo extends Lambda implements l<StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ctry>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public static final Cdo f2266do = new Cdo();

            /* renamed from: com.iproov.sdk.transient.do$while$do$do  reason: invalid class name */
            public static final class Cdo extends Lambda implements p<Ccatch.Ctry, Cbreak.Ccase, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ctry> f2267do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ctry> stateDefinitionBuilder) {
                    super(2);
                    this.f2267do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Ctry tryR, Cbreak.Ccase caseR) {
                    return this.f2267do.e(tryR, Ccatch.Ccase.f2184do, Cthis.Cclass.f2237do);
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$do$for  reason: invalid class name */
            public static final class Cfor extends Lambda implements p<Ccatch.Ctry, Cbreak.Cnew, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ctry> f2268do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cfor(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ctry> stateDefinitionBuilder) {
                    super(2);
                    this.f2268do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Ctry tryR, Cbreak.Cnew newR) {
                    return this.f2268do.e(tryR, Ccatch.Cnew.f2189do, new Cthis.Celse(newR.m2064do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$do$if  reason: invalid class name */
            public static final class Cif extends Lambda implements p<Ccatch.Ctry, Cbreak.Cif, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ctry> f2269do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cif(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ctry> stateDefinitionBuilder) {
                    super(2);
                    this.f2269do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Ctry tryR, Cbreak.Cif ifVar) {
                    return this.f2269do.e(tryR, Ccatch.Cnew.f2189do, new Cthis.Ccase(ifVar.m2063do()));
                }
            }

            public Cdo() {
                super(1);
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2096do(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ctry> stateDefinitionBuilder) {
                Cdo doVar = new Cdo(stateDefinitionBuilder);
                StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
                stateDefinitionBuilder.d(aVar.a(Cbreak.Ccase.class), doVar);
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cif.class), new Cif(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cnew.class), new Cfor(stateDefinitionBuilder));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2096do((StateMachine.GraphBuilder.StateDefinitionBuilder) obj);
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$while$else  reason: invalid class name */
        public static final class Celse extends Lambda implements l<StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cnew>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public static final Celse f2270do = new Celse();

            public Celse() {
                super(1);
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2100do(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cnew> stateDefinitionBuilder) {
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2100do((StateMachine.GraphBuilder.StateDefinitionBuilder) obj);
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$while$for  reason: invalid class name */
        public static final class Cfor extends Lambda implements l<StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cfor>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public static final Cfor f2271do = new Cfor();

            /* renamed from: com.iproov.sdk.transient.do$while$for$do  reason: invalid class name */
            public static final class Cdo extends Lambda implements p<Ccatch.Cfor, Cbreak.Ctry, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cfor> f2272do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cfor> stateDefinitionBuilder) {
                    super(2);
                    this.f2272do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cfor forR, Cbreak.Ctry tryR) {
                    return this.f2272do.e(forR, Ccatch.Cif.f2188do, Cthis.Cconst.f2238do);
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$for$for  reason: invalid class name */
            public static final class Cfor extends Lambda implements p<Ccatch.Cfor, Cbreak.Cnew, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cfor> f2273do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cfor(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cfor> stateDefinitionBuilder) {
                    super(2);
                    this.f2273do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cfor forR, Cbreak.Cnew newR) {
                    return this.f2273do.e(forR, Ccatch.Cnew.f2189do, new Cthis.Celse(newR.m2064do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$for$if  reason: invalid class name */
            public static final class Cif extends Lambda implements p<Ccatch.Cfor, Cbreak.Cif, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cfor> f2274do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cif(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cfor> stateDefinitionBuilder) {
                    super(2);
                    this.f2274do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cfor forR, Cbreak.Cif ifVar) {
                    return this.f2274do.e(forR, Ccatch.Cnew.f2189do, new Cthis.Ccase(ifVar.m2063do()));
                }
            }

            public Cfor() {
                super(1);
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2101do(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cfor> stateDefinitionBuilder) {
                Cdo doVar = new Cdo(stateDefinitionBuilder);
                StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
                stateDefinitionBuilder.d(aVar.a(Cbreak.Ctry.class), doVar);
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cif.class), new Cif(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cnew.class), new Cfor(stateDefinitionBuilder));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2101do((StateMachine.GraphBuilder.StateDefinitionBuilder) obj);
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$while$goto  reason: invalid class name */
        public static final class Cgoto extends Lambda implements l<StateMachine.b<? extends Ccatch, ? extends Cbreak, ? extends Cthis>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis> f2275do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cdo f2276if;

            @d(c = "com.iproov.sdk.usecase.BiometricScannerUseCase$stateMachine$1$8$1", f = "BiometricScannerUseCase.kt", l = {276, 278, 279, 283, 285, 286, 287, 290, 291, 292, 295, 298, 299, 302, 303, 306, 309, 312, 315}, m = "invokeSuspend")
            /* renamed from: com.iproov.sdk.transient.do$while$goto$do  reason: invalid class name */
            public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

                /* renamed from: do  reason: not valid java name */
                public int f2277do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cdo f2278for;

                /* renamed from: if  reason: not valid java name */
                public final /* synthetic */ Cthis f2279if;

                /* renamed from: new  reason: not valid java name */
                public final /* synthetic */ StateMachine.b<Ccatch, Cbreak, Cthis> f2280new;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cthis thisR, Cdo doVar, StateMachine.b<? extends Ccatch, ? extends Cbreak, ? extends Cthis> bVar, c<? super Cdo> cVar) {
                    super(2, cVar);
                    this.f2279if = thisR;
                    this.f2278for = doVar;
                    this.f2280new = bVar;
                }

                public final c<Unit> create(Object obj, c<?> cVar) {
                    return new Cdo(this.f2279if, this.f2278for, this.f2280new, cVar);
                }

                /* renamed from: do  reason: not valid java name */
                public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                    return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                }

                /* JADX WARNING: Code restructure failed: missing block: B:102:0x01fa, code lost:
                    return kotlin.Unit.f56620a;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
                    r4 = com.iproov.sdk.p034transient.Cdo.m2051for(r3.f2278for).m759transient();
                    r1 = new com.iproov.sdk.p016if.Cstrictfp.Cif(com.iproov.sdk.p034transient.Cdo.m2032do(r3.f2278for));
                    r3.f2277do = 3;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
                    if (r4.emit(r1, r3) != r0) goto L_0x01f8;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
                    return r0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d8, code lost:
                    r4 = r3.f2278for;
                    r1 = ((com.iproov.sdk.p034transient.Cdo.Cthis.Cfor) r3.f2279if).m2084do();
                    r3.f2277do = 6;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e9, code lost:
                    if (com.iproov.sdk.p034transient.Cdo.m2041do(r4, r1, (kotlin.coroutines.c) r3) != r0) goto L_0x00ec;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:45:0x00eb, code lost:
                    return r0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ec, code lost:
                    r4 = r3.f2278for;
                    r1 = ((com.iproov.sdk.p034transient.Cdo.Cthis.Cfor) r3.f2279if).m2084do();
                    r3.f2277do = 7;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fd, code lost:
                    if (com.iproov.sdk.p034transient.Cdo.m2056if(r4, r1, (kotlin.coroutines.c) r3) != r0) goto L_0x01f8;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ff, code lost:
                    return r0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:54:0x0111, code lost:
                    r4 = r3.f2278for;
                    r1 = ((com.iproov.sdk.p034transient.Cdo.Cthis.Cnew) r3.f2279if).m2087do();
                    r3.f2277do = 9;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:55:0x0123, code lost:
                    if (com.iproov.sdk.p034transient.Cdo.m2039do(r4, r1, (kotlin.coroutines.c) r3) != r0) goto L_0x0126;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:56:0x0125, code lost:
                    return r0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:57:0x0126, code lost:
                    r4 = r3.f2278for;
                    r1 = ((com.iproov.sdk.p034transient.Cdo.Cthis.Cnew) r3.f2279if).m2087do();
                    r3.f2277do = 10;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:58:0x0138, code lost:
                    if (com.iproov.sdk.p034transient.Cdo.m2055if(r4, r1, (kotlin.coroutines.c) r3) != r0) goto L_0x01f8;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:59:0x013a, code lost:
                    return r0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:70:0x0163, code lost:
                    r4 = r3.f2278for;
                    r1 = ((com.iproov.sdk.p034transient.Cdo.Cthis.Cdo) r3.f2279if).m2081do();
                    r3.f2277do = 13;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:71:0x0175, code lost:
                    if (com.iproov.sdk.p034transient.Cdo.m2056if(r4, r1, (kotlin.coroutines.c) r3) != r0) goto L_0x01f8;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:72:0x0177, code lost:
                    return r0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:78:0x018f, code lost:
                    r4 = r3.f2278for;
                    r1 = ((com.iproov.sdk.p034transient.Cdo.Cthis.Cif) r3.f2279if).m2086do();
                    r3.f2277do = 15;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a1, code lost:
                    if (com.iproov.sdk.p034transient.Cdo.m2055if(r4, r1, (kotlin.coroutines.c) r3) != r0) goto L_0x01f8;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a3, code lost:
                    return r0;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                    /*
                        r3 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                        int r1 = r3.f2277do
                        switch(r1) {
                            case 0: goto L_0x0038;
                            case 1: goto L_0x0033;
                            case 2: goto L_0x002f;
                            case 3: goto L_0x0033;
                            case 4: goto L_0x0033;
                            case 5: goto L_0x002a;
                            case 6: goto L_0x0025;
                            case 7: goto L_0x0033;
                            case 8: goto L_0x0020;
                            case 9: goto L_0x001b;
                            case 10: goto L_0x0033;
                            case 11: goto L_0x0033;
                            case 12: goto L_0x0016;
                            case 13: goto L_0x0033;
                            case 14: goto L_0x0011;
                            case 15: goto L_0x0033;
                            case 16: goto L_0x0033;
                            case 17: goto L_0x0033;
                            case 18: goto L_0x0033;
                            case 19: goto L_0x0033;
                            default: goto L_0x0009;
                        }
                    L_0x0009:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r0)
                        throw r4
                    L_0x0011:
                        kotlin.k.b(r4)
                        goto L_0x018f
                    L_0x0016:
                        kotlin.k.b(r4)
                        goto L_0x0163
                    L_0x001b:
                        kotlin.k.b(r4)
                        goto L_0x0126
                    L_0x0020:
                        kotlin.k.b(r4)
                        goto L_0x0111
                    L_0x0025:
                        kotlin.k.b(r4)
                        goto L_0x00ec
                    L_0x002a:
                        kotlin.k.b(r4)
                        goto L_0x00d8
                    L_0x002f:
                        kotlin.k.b(r4)
                        goto L_0x0075
                    L_0x0033:
                        kotlin.k.b(r4)
                        goto L_0x01f8
                    L_0x0038:
                        kotlin.k.b(r4)
                        com.iproov.sdk.transient.do$this r4 = r3.f2279if
                        if (r4 != 0) goto L_0x0041
                        goto L_0x01f8
                    L_0x0041:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cclass
                        if (r1 == 0) goto L_0x005b
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.if.default r4 = r4.f2165if
                        kotlinx.coroutines.flow.a1 r4 = r4.m759transient()
                        com.iproov.sdk.if.strictfp$for r1 = com.iproov.sdk.p016if.Cstrictfp.Cfor.f719do
                        r2 = 1
                        r3.f2277do = r2
                        java.lang.Object r4 = r4.emit(r1, r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x005b:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cbreak
                        if (r1 == 0) goto L_0x0094
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.if.default r4 = r4.f2165if
                        kotlinx.coroutines.flow.b1 r4 = r4.getCurrentState()
                        com.iproov.sdk.IProovState$Connected r1 = com.iproov.sdk.IProovState.Connected.INSTANCE
                        r2 = 2
                        r3.f2277do = r2
                        java.lang.Object r4 = r4.emit(r1, r3)
                        if (r4 != r0) goto L_0x0075
                        return r0
                    L_0x0075:
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.if.default r4 = r4.f2165if
                        kotlinx.coroutines.flow.a1 r4 = r4.m759transient()
                        com.iproov.sdk.if.strictfp$if r1 = new com.iproov.sdk.if.strictfp$if
                        com.iproov.sdk.transient.do r2 = r3.f2278for
                        com.iproov.sdk.try.if r2 = r2.f2164goto
                        r1.<init>(r2)
                        r2 = 3
                        r3.f2277do = r2
                        java.lang.Object r4 = r4.emit(r1, r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x0094:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cconst
                        if (r1 == 0) goto L_0x00a7
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.tinder.StateMachine$b<com.iproov.sdk.transient.do$catch, com.iproov.sdk.transient.do$break, com.iproov.sdk.transient.do$this> r0 = r3.f2280new
                        java.lang.Object r0 = r0.a()
                        com.iproov.sdk.transient.do$break r0 = (com.iproov.sdk.p034transient.Cdo.Cbreak) r0
                        r4.m2047do((com.iproov.sdk.p034transient.Cdo.Cbreak) r0)
                        goto L_0x01f8
                    L_0x00a7:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Ccatch
                        if (r1 == 0) goto L_0x00b6
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.if.finally r4 = r4.f2156case
                        r4.m769try()
                        goto L_0x01f8
                    L_0x00b6:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cfinal
                        if (r1 == 0) goto L_0x00c8
                        com.iproov.sdk.transient.do r1 = r3.f2278for
                        com.iproov.sdk.transient.do$this$final r4 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cfinal) r4
                        r2 = 4
                        r3.f2277do = r2
                        java.lang.Object r4 = r1.m2036do((com.iproov.sdk.p034transient.Cdo.Cthis.Cfinal) r4, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x00c8:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cfor
                        if (r1 == 0) goto L_0x0100
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        r1 = 5
                        r3.f2277do = r1
                        java.lang.Object r4 = r4.m2046do((kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x00d8
                        return r0
                    L_0x00d8:
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.transient.do$this r1 = r3.f2279if
                        com.iproov.sdk.transient.do$this$for r1 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cfor) r1
                        com.iproov.sdk.if r1 = r1.m2084do()
                        r2 = 6
                        r3.f2277do = r2
                        java.lang.Object r4 = r4.m2035do((com.iproov.sdk.Cif) r1, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x00ec
                        return r0
                    L_0x00ec:
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.transient.do$this r1 = r3.f2279if
                        com.iproov.sdk.transient.do$this$for r1 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cfor) r1
                        com.iproov.sdk.if r1 = r1.m2084do()
                        r2 = 7
                        r3.f2277do = r2
                        java.lang.Object r4 = r4.m2054if((com.iproov.sdk.Cif) r1, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x0100:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cnew
                        if (r1 == 0) goto L_0x013b
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        r1 = 8
                        r3.f2277do = r1
                        java.lang.Object r4 = r4.m2046do((kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x0111
                        return r0
                    L_0x0111:
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.transient.do$this r1 = r3.f2279if
                        com.iproov.sdk.transient.do$this$new r1 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cnew) r1
                        com.iproov.sdk.core.exception.IProovException r1 = r1.m2087do()
                        r2 = 9
                        r3.f2277do = r2
                        java.lang.Object r4 = r4.m2033do((com.iproov.sdk.core.exception.IProovException) r1, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x0126
                        return r0
                    L_0x0126:
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.transient.do$this r1 = r3.f2279if
                        com.iproov.sdk.transient.do$this$new r1 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cnew) r1
                        com.iproov.sdk.core.exception.IProovException r1 = r1.m2087do()
                        r2 = 10
                        r3.f2277do = r2
                        java.lang.Object r4 = r4.m2053if((com.iproov.sdk.core.exception.IProovException) r1, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x013b:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Ctry
                        if (r1 == 0) goto L_0x014c
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        r1 = 11
                        r3.f2277do = r1
                        java.lang.Object r4 = r4.m2058if((kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x014c:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cdo
                        if (r1 == 0) goto L_0x0178
                        com.iproov.sdk.transient.do r1 = r3.f2278for
                        com.iproov.sdk.transient.do$this$do r4 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cdo) r4
                        com.iproov.sdk.if r4 = r4.m2081do()
                        r2 = 12
                        r3.f2277do = r2
                        java.lang.Object r4 = r1.m2035do((com.iproov.sdk.Cif) r4, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x0163
                        return r0
                    L_0x0163:
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.transient.do$this r1 = r3.f2279if
                        com.iproov.sdk.transient.do$this$do r1 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cdo) r1
                        com.iproov.sdk.if r1 = r1.m2081do()
                        r2 = 13
                        r3.f2277do = r2
                        java.lang.Object r4 = r4.m2054if((com.iproov.sdk.Cif) r1, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x0178:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cif
                        if (r1 == 0) goto L_0x01a4
                        com.iproov.sdk.transient.do r1 = r3.f2278for
                        com.iproov.sdk.transient.do$this$if r4 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cif) r4
                        com.iproov.sdk.core.exception.IProovException r4 = r4.m2086do()
                        r2 = 14
                        r3.f2277do = r2
                        java.lang.Object r4 = r1.m2033do((com.iproov.sdk.core.exception.IProovException) r4, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x018f
                        return r0
                    L_0x018f:
                        com.iproov.sdk.transient.do r4 = r3.f2278for
                        com.iproov.sdk.transient.do$this r1 = r3.f2279if
                        com.iproov.sdk.transient.do$this$if r1 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cif) r1
                        com.iproov.sdk.core.exception.IProovException r1 = r1.m2086do()
                        r2 = 15
                        r3.f2277do = r2
                        java.lang.Object r4 = r4.m2053if((com.iproov.sdk.core.exception.IProovException) r1, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x01a4:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Celse
                        if (r1 == 0) goto L_0x01bb
                        com.iproov.sdk.transient.do r1 = r3.f2278for
                        com.iproov.sdk.transient.do$this$else r4 = (com.iproov.sdk.p034transient.Cdo.Cthis.Celse) r4
                        com.iproov.sdk.core.exception.IProovException r4 = r4.m2082do()
                        r2 = 16
                        r3.f2277do = r2
                        java.lang.Object r4 = r1.m2053if((com.iproov.sdk.core.exception.IProovException) r4, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x01bb:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Ccase
                        if (r1 == 0) goto L_0x01d2
                        com.iproov.sdk.transient.do r1 = r3.f2278for
                        com.iproov.sdk.transient.do$this$case r4 = (com.iproov.sdk.p034transient.Cdo.Cthis.Ccase) r4
                        com.iproov.sdk.if r4 = r4.m2080do()
                        r2 = 17
                        r3.f2277do = r2
                        java.lang.Object r4 = r1.m2054if((com.iproov.sdk.Cif) r4, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x01d2:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cgoto
                        if (r1 == 0) goto L_0x01e5
                        com.iproov.sdk.transient.do r1 = r3.f2278for
                        com.iproov.sdk.transient.do$this$goto r4 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cgoto) r4
                        r2 = 18
                        r3.f2277do = r2
                        java.lang.Object r4 = r1.m2037do((com.iproov.sdk.p034transient.Cdo.Cthis.Cgoto) r4, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x01e5:
                        boolean r1 = r4 instanceof com.iproov.sdk.p034transient.Cdo.Cthis.Cthis
                        if (r1 == 0) goto L_0x01f8
                        com.iproov.sdk.transient.do r1 = r3.f2278for
                        com.iproov.sdk.transient.do$this$this r4 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cthis) r4
                        r2 = 19
                        r3.f2277do = r2
                        java.lang.Object r4 = r1.m2038do((com.iproov.sdk.p034transient.Cdo.Cthis.Cthis) r4, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
                        if (r4 != r0) goto L_0x01f8
                        return r0
                    L_0x01f8:
                        kotlin.Unit r4 = kotlin.Unit.f56620a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p034transient.Cdo.Cwhile.Cgoto.Cdo.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cgoto(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis> graphBuilder, Cdo doVar) {
                super(1);
                this.f2275do = graphBuilder;
                this.f2276if = doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2105do(StateMachine.b<? extends Ccatch, ? extends Cbreak, ? extends Cthis> bVar) {
                StateMachine.b.C0639b bVar2 = bVar instanceof StateMachine.b.C0639b ? (StateMachine.b.C0639b) bVar : null;
                if (bVar2 != null) {
                    Cthis thisR = (Cthis) bVar2.c();
                    com.iproov.sdk.p017implements.Ccase.m977do(this.f2275do);
                    Objects.toString(bVar2.d());
                    Objects.toString(thisR);
                    Cdo doVar = this.f2276if;
                    n1 unused = i.d(doVar, (CoroutineContext) null, (CoroutineStart) null, new Cdo(thisR, doVar, bVar, (c<? super Cdo>) null), 3, (Object) null);
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2105do((StateMachine.b) obj);
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$while$if  reason: invalid class name */
        public static final class Cif extends Lambda implements l<StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ccase>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public static final Cif f2281do = new Cif();

            /* renamed from: com.iproov.sdk.transient.do$while$if$do  reason: invalid class name */
            public static final class Cdo extends Lambda implements p<Ccatch.Ccase, Cbreak.Celse, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ccase> f2282do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ccase> stateDefinitionBuilder) {
                    super(2);
                    this.f2282do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Ccase caseR, Cbreak.Celse elseR) {
                    return this.f2282do.e(caseR, Ccatch.Cfor.f2187do, Cthis.Cbreak.f2234do);
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$if$for  reason: invalid class name */
            public static final class Cfor extends Lambda implements p<Ccatch.Ccase, Cbreak.Cnew, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ccase> f2283do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cfor(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ccase> stateDefinitionBuilder) {
                    super(2);
                    this.f2283do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Ccase caseR, Cbreak.Cnew newR) {
                    return this.f2283do.e(caseR, Ccatch.Cnew.f2189do, new Cthis.Celse(newR.m2064do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$if$if  reason: invalid class name */
            public static final class Cif extends Lambda implements p<Ccatch.Ccase, Cbreak.Cif, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ccase> f2284do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cif(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ccase> stateDefinitionBuilder) {
                    super(2);
                    this.f2284do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Ccase caseR, Cbreak.Cif ifVar) {
                    return this.f2284do.e(caseR, Ccatch.Cnew.f2189do, new Cthis.Ccase(ifVar.m2063do()));
                }
            }

            public Cif() {
                super(1);
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2107do(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Ccase> stateDefinitionBuilder) {
                Cdo doVar = new Cdo(stateDefinitionBuilder);
                StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
                stateDefinitionBuilder.d(aVar.a(Cbreak.Celse.class), doVar);
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cif.class), new Cif(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cnew.class), new Cfor(stateDefinitionBuilder));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2107do((StateMachine.GraphBuilder.StateDefinitionBuilder) obj);
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$while$new  reason: invalid class name */
        public static final class Cnew extends Lambda implements l<StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cif>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public static final Cnew f2285do = new Cnew();

            /* renamed from: com.iproov.sdk.transient.do$while$new$do  reason: invalid class name */
            public static final class Cdo extends Lambda implements p<Ccatch.Cif, Cbreak.Cdo, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cif> f2286do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cif> stateDefinitionBuilder) {
                    super(2);
                    this.f2286do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cif ifVar, Cbreak.Cdo doVar) {
                    return this.f2286do.e(ifVar, Ccatch.Cdo.f2185do, Cthis.Ccatch.f2236do);
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$new$for  reason: invalid class name */
            public static final class Cfor extends Lambda implements p<Ccatch.Cif, Cbreak.Cnew, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cif> f2287do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cfor(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cif> stateDefinitionBuilder) {
                    super(2);
                    this.f2287do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cif ifVar, Cbreak.Cnew newR) {
                    return this.f2287do.e(ifVar, Ccatch.Cnew.f2189do, new Cthis.Cnew(newR.m2064do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$new$if  reason: invalid class name */
            public static final class Cif extends Lambda implements p<Ccatch.Cif, Cbreak.Cif, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cif> f2288do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cif(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cif> stateDefinitionBuilder) {
                    super(2);
                    this.f2288do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cif ifVar, Cbreak.Cif ifVar2) {
                    return this.f2288do.e(ifVar, Ccatch.Cnew.f2189do, new Cthis.Cfor(ifVar2.m2063do()));
                }
            }

            public Cnew() {
                super(1);
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2111do(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cif> stateDefinitionBuilder) {
                Cdo doVar = new Cdo(stateDefinitionBuilder);
                StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cdo.class), doVar);
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cif.class), new Cif(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cnew.class), new Cfor(stateDefinitionBuilder));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2111do((StateMachine.GraphBuilder.StateDefinitionBuilder) obj);
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.transient.do$while$try  reason: invalid class name */
        public static final class Ctry extends Lambda implements l<StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public static final Ctry f2289do = new Ctry();

            /* renamed from: com.iproov.sdk.transient.do$while$try$case  reason: invalid class name */
            public static final class Ccase extends Lambda implements p<Ccatch.Cdo, Cbreak.Cthis, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> f2290do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Ccase(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> stateDefinitionBuilder) {
                    super(2);
                    this.f2290do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cdo doVar, Cbreak.Cthis thisR) {
                    return this.f2290do.e(doVar, Ccatch.Cnew.f2189do, new Cthis.Cthis(thisR.m2065do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$try$do  reason: invalid class name */
            public static final class Cdo extends Lambda implements p<Ccatch.Cdo, Cbreak.Cfor, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> f2291do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> stateDefinitionBuilder) {
                    super(2);
                    this.f2291do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cdo doVar, Cbreak.Cfor forR) {
                    return this.f2291do.e(doVar, Ccatch.Celse.f2186do, Cthis.Ctry.f2247do);
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$try$for  reason: invalid class name */
            public static final class Cfor extends Lambda implements p<Ccatch.Cdo, Cbreak.Cbreak, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> f2292do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cfor(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> stateDefinitionBuilder) {
                    super(2);
                    this.f2292do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cdo doVar, Cbreak.Cbreak breakR) {
                    return this.f2292do.e(doVar, Ccatch.Cnew.f2189do, new Cthis.Cfor(com.iproov.sdk.Cif.USER));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$try$if  reason: invalid class name */
            public static final class Cif extends Lambda implements p<Ccatch.Cdo, Cbreak.Cgoto, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> f2293do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cif(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> stateDefinitionBuilder) {
                    super(2);
                    this.f2293do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cdo doVar, Cbreak.Cgoto gotoR) {
                    return this.f2293do.b(doVar, new Cthis.Cfinal(gotoR.m2062do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$try$new  reason: invalid class name */
            public static final class Cnew extends Lambda implements p<Ccatch.Cdo, Cbreak.Cif, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> f2294do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cnew(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> stateDefinitionBuilder) {
                    super(2);
                    this.f2294do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cdo doVar, Cbreak.Cif ifVar) {
                    return this.f2294do.e(doVar, Ccatch.Cnew.f2189do, new Cthis.Cfor(ifVar.m2063do()));
                }
            }

            /* renamed from: com.iproov.sdk.transient.do$while$try$try  reason: invalid class name */
            public static final class Ctry extends Lambda implements p<Ccatch.Cdo, Cbreak.Cnew, StateMachine.Graph.State.a<? extends Ccatch, ? extends Cthis>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> f2295do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Ctry(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> stateDefinitionBuilder) {
                    super(2);
                    this.f2295do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccatch, Cthis> invoke(Ccatch.Cdo doVar, Cbreak.Cnew newR) {
                    return this.f2295do.e(doVar, Ccatch.Cnew.f2189do, new Cthis.Cnew(newR.m2064do()));
                }
            }

            public Ctry() {
                super(1);
            }

            /* renamed from: do  reason: not valid java name */
            public final void m2115do(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis>.StateDefinitionBuilder<Ccatch.Cdo> stateDefinitionBuilder) {
                Cdo doVar = new Cdo(stateDefinitionBuilder);
                StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cfor.class), doVar);
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cgoto.class), new Cif(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cbreak.class), new Cfor(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cif.class), new Cnew(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cnew.class), new Ctry(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Cbreak.Cthis.class), new Ccase(stateDefinitionBuilder));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2115do((StateMachine.GraphBuilder.StateDefinitionBuilder) obj);
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cwhile(Cdo doVar) {
            super(1);
            this.f2260do = doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m2090do(StateMachine.GraphBuilder<Ccatch, Cbreak, Cthis> graphBuilder) {
            graphBuilder.b(Ccatch.Ctry.f2190do);
            Cdo doVar = Cdo.f2266do;
            StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
            graphBuilder.d(aVar.a(Ccatch.Ctry.class), doVar);
            graphBuilder.d(aVar.a(Ccatch.Ccase.class), Cif.f2281do);
            graphBuilder.d(aVar.a(Ccatch.Cfor.class), Cfor.f2271do);
            graphBuilder.d(aVar.a(Ccatch.Cif.class), Cnew.f2285do);
            graphBuilder.d(aVar.a(Ccatch.Cdo.class), Ctry.f2289do);
            graphBuilder.d(aVar.a(Ccatch.Celse.class), Ccase.f2261do);
            graphBuilder.d(aVar.a(Ccatch.Cnew.class), Celse.f2270do);
            graphBuilder.c(new Cgoto(graphBuilder, this.f2260do));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2090do((StateMachine.GraphBuilder) obj);
            return Unit.f56620a;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cdo(Context context, Cdefault defaultR, String str, com.iproov.sdk.p016if.Cdo doVar, com.iproov.sdk.p016if.Ccase caseR, com.iproov.sdk.p016if.Cwhile whileR, Cfinally finallyR, Ccontinue continueR, com.iproov.sdk.p035try.Cif ifVar, Cinterface interfaceR, Cprivate privateR, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, defaultR, str, doVar, caseR, whileR, finallyR, continueR, ifVar, interfaceR, privateR, (i11 & 2048) != 0 ? v0.a() : coroutineDispatcher);
    }

    /* renamed from: class  reason: not valid java name */
    private final void m2031class() {
        this.f2163for.stop();
        this.f2156case.stop();
    }

    public void cancel() {
        com.iproov.sdk.p017implements.Ccase.m977do(this);
        this.f2162final.f(new Cbreak.Cif(com.iproov.sdk.Cif.f643if));
    }

    public void doStop() {
        m2031class();
        this.f2166new.stop();
        this.f2161else.stop();
        this.f2165if.d();
    }

    public void handleCoroutineException(CoroutineContext coroutineContext, Throwable th2) {
        this.f2165if.m744native().d(Cinstanceof.Cdo.f697do);
        m2031class();
        super.handleCoroutineException(coroutineContext, th2);
        this.f2165if.getCurrentState().d(new IProovState.Error(new UnexpectedErrorException(this.f2160do, th2)));
    }

    /* renamed from: try  reason: not valid java name */
    public void m2061try() {
        com.iproov.sdk.p017implements.Ccase.m977do(this);
        this.f2162final.f(Cbreak.Ccase.f2170do);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cdo(Context context, Cdefault defaultR, String str, com.iproov.sdk.p016if.Cdo doVar, com.iproov.sdk.p016if.Ccase caseR, com.iproov.sdk.p016if.Cwhile whileR, Cfinally finallyR, Ccontinue continueR, com.iproov.sdk.p035try.Cif ifVar, Cinterface interfaceR, Cprivate privateR, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f2160do = context;
        this.f2165if = defaultR;
        this.f2163for = doVar;
        this.f2166new = caseR;
        this.f2168try = whileR;
        this.f2156case = finallyR;
        this.f2161else = continueR;
        this.f2164goto = ifVar;
        this.f2167this = interfaceR;
        this.f2155break = privateR;
        this.f2157catch = whileR.m848else();
        new Cif();
        com.iproov.sdk.p017implements.Ccase.m977do(this);
        n1 unused = i.d(this, v0.c(), (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 2, (Object) null);
        n1 unused2 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, (c<? super Cif>) null), 3, (Object) null);
        n1 unused3 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cfor(this, (c<? super Cfor>) null), 3, (Object) null);
        n1 unused4 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cnew(this, (c<? super Cnew>) null), 3, (Object) null);
        n1 unused5 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Ctry(this, (c<? super Ctry>) null), 3, (Object) null);
        n1 unused6 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Ccase(this, (c<? super Ccase>) null), 3, (Object) null);
        n1 unused7 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Celse(this, (c<? super Celse>) null), 3, (Object) null);
        n1 unused8 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cgoto(this, (c<? super Cgoto>) null), 3, (Object) null);
        this.f2162final = StateMachine.f51108c.b(new Cwhile(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public final Object m2054if(com.iproov.sdk.Cif ifVar, c<? super Unit> cVar) {
        Object emit = this.f2165if.getCurrentState().emit(new IProovState.Cancelled(ifVar), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public final Object m2053if(IProovException iProovException, c<? super Unit> cVar) {
        Object emit = this.f2165if.getCurrentState().emit(new IProovState.Error(iProovException), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }

    /* access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public final Object m2058if(c<? super Unit> cVar) {
        n1 d11 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cconst(this, (c<? super Cconst>) null), 3, (Object) null);
        if (d11 == IntrinsicsKt__IntrinsicsKt.d()) {
            return d11;
        }
        return Unit.f56620a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e4 A[Catch:{ IProovException -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0110 A[Catch:{ IProovException -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0111 A[Catch:{ IProovException -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0120 A[Catch:{ IProovException -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0121 A[Catch:{ IProovException -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0149 A[Catch:{ IProovException -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014c A[Catch:{ IProovException -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x015c A[Catch:{ IProovException -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0161 A[Catch:{ IProovException -> 0x0189 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0184 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m2034do(com.iproov.sdk.p016if.Ctry r21, kotlin.coroutines.c<? super kotlin.Unit> r22) {
        /*
            r20 = this;
            r1 = r20
            r0 = r22
            boolean r2 = r0 instanceof com.iproov.sdk.p034transient.Cdo.Cthrow
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.iproov.sdk.transient.do$throw r2 = (com.iproov.sdk.p034transient.Cdo.Cthrow) r2
            int r3 = r2.f2250else
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f2250else = r3
            goto L_0x001c
        L_0x0017:
            com.iproov.sdk.transient.do$throw r2 = new com.iproov.sdk.transient.do$throw
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f2254try
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f2250else
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x005a
            if (r4 == r6) goto L_0x0040
            if (r4 != r5) goto L_0x0038
            java.lang.Object r2 = r2.f2249do
            com.iproov.sdk.transient.do r2 = (com.iproov.sdk.p034transient.Cdo) r2
            kotlin.k.b(r0)     // Catch:{ IProovException -> 0x0035 }
            goto L_0x0186
        L_0x0035:
            r0 = move-exception
            goto L_0x018e
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0040:
            java.lang.Object r4 = r2.f2253new
            com.iproov.sdk.class.else r4 = (com.iproov.sdk.p005class.Celse) r4
            java.lang.Object r7 = r2.f2251for
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            java.lang.Object r8 = r2.f2252if
            com.iproov.sdk.if.try r8 = (com.iproov.sdk.p016if.Ctry) r8
            java.lang.Object r9 = r2.f2249do
            com.iproov.sdk.transient.do r9 = (com.iproov.sdk.p034transient.Cdo) r9
            kotlin.k.b(r0)     // Catch:{ IProovException -> 0x0057 }
            r17 = r4
            goto L_0x00d2
        L_0x0057:
            r0 = move-exception
            goto L_0x018f
        L_0x005a:
            kotlin.k.b(r0)
            com.iproov.sdk.p017implements.Ccase.m977do(r20)
            byte[] r0 = r21.m840do()
            int r0 = r0.length
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.a.c(r0)
            java.lang.String r4 = "onFrameEncoded -> streamer 🛒 frame size="
            kotlin.jvm.internal.x.i(r4, r0)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            com.iproov.sdk.crypto.do r0 = r1.f2157catch
            com.iproov.sdk.crypto.do r4 = com.iproov.sdk.crypto.Cdo.UNSUPPORTED
            if (r0 == r4) goto L_0x0095
            com.iproov.sdk.if.while r0 = r1.f2168try     // Catch:{ do -> 0x0086 }
            byte[] r4 = r21.m840do()     // Catch:{ do -> 0x0086 }
            byte[] r0 = r0.sign(r4)     // Catch:{ do -> 0x0086 }
            r7.element = r0     // Catch:{ do -> 0x0086 }
            goto L_0x0095
        L_0x0086:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r4 = com.iproov.sdk.p017implements.Ccase.m977do(r20)
            java.lang.String r0 = r0.getLocalizedMessage()
            com.iproov.sdk.logging.IPLog.w(r4, r0)
        L_0x0095:
            com.iproov.sdk.if.default r0 = r1.f2165if
            kotlinx.coroutines.flow.b1 r0 = r0.m741import()
            java.lang.Object r0 = r0.getValue()
            com.iproov.sdk.case.if r0 = (com.iproov.sdk.p003case.Cif) r0
            if (r0 != 0) goto L_0x00a5
            goto L_0x0199
        L_0x00a5:
            com.iproov.sdk.class.case r0 = r0.m236if()
            if (r0 != 0) goto L_0x00ad
            goto L_0x0199
        L_0x00ad:
            com.iproov.sdk.class.else r4 = r0.m246do()
            if (r4 != 0) goto L_0x00b5
            goto L_0x0199
        L_0x00b5:
            com.iproov.sdk.if.private r0 = r1.f2155break     // Catch:{ IProovException -> 0x018c }
            long r8 = r21.m842if()     // Catch:{ IProovException -> 0x018c }
            r2.f2249do = r1     // Catch:{ IProovException -> 0x018c }
            r10 = r21
            r2.f2252if = r10     // Catch:{ IProovException -> 0x018c }
            r2.f2251for = r7     // Catch:{ IProovException -> 0x018c }
            r2.f2253new = r4     // Catch:{ IProovException -> 0x018c }
            r2.f2250else = r6     // Catch:{ IProovException -> 0x018c }
            java.lang.Object r0 = r0.m792do((long) r8, (kotlin.coroutines.c<? super java.util.List<com.iproov.sdk.p026return.Cstatic>>) r2)     // Catch:{ IProovException -> 0x018c }
            if (r0 != r3) goto L_0x00ce
            return r3
        L_0x00ce:
            r9 = r1
            r17 = r4
            r8 = r10
        L_0x00d2:
            r14 = r0
            java.util.List r14 = (java.util.List) r14     // Catch:{ IProovException -> 0x0189 }
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ IProovException -> 0x0189 }
            r0.<init>()     // Catch:{ IProovException -> 0x0189 }
            java.util.Iterator r4 = r14.iterator()     // Catch:{ IProovException -> 0x0189 }
        L_0x00de:
            boolean r10 = r4.hasNext()     // Catch:{ IProovException -> 0x0189 }
            if (r10 == 0) goto L_0x0102
            java.lang.Object r10 = r4.next()     // Catch:{ IProovException -> 0x0189 }
            com.iproov.sdk.return.static r10 = (com.iproov.sdk.p026return.Cstatic) r10     // Catch:{ IProovException -> 0x0189 }
            int r11 = r0.length()     // Catch:{ IProovException -> 0x0189 }
            if (r11 <= 0) goto L_0x00f2
            r11 = r6
            goto L_0x00f3
        L_0x00f2:
            r11 = 0
        L_0x00f3:
            if (r11 == 0) goto L_0x00fa
            java.lang.String r11 = ","
            r0.append(r11)     // Catch:{ IProovException -> 0x0189 }
        L_0x00fa:
            int r10 = r10.m1693if()     // Catch:{ IProovException -> 0x0189 }
            r0.append(r10)     // Catch:{ IProovException -> 0x0189 }
            goto L_0x00de
        L_0x0102:
            com.iproov.sdk.p017implements.Ccase.m977do(r9)     // Catch:{ IProovException -> 0x0189 }
            r8.m842if()     // Catch:{ IProovException -> 0x0189 }
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r14)     // Catch:{ IProovException -> 0x0189 }
            com.iproov.sdk.return.static r0 = (com.iproov.sdk.p026return.Cstatic) r0     // Catch:{ IProovException -> 0x0189 }
            if (r0 != 0) goto L_0x0111
            goto L_0x0118
        L_0x0111:
            long r10 = r0.m1692for()     // Catch:{ IProovException -> 0x0189 }
            kotlin.coroutines.jvm.internal.a.d(r10)     // Catch:{ IProovException -> 0x0189 }
        L_0x0118:
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r14)     // Catch:{ IProovException -> 0x0189 }
            com.iproov.sdk.return.static r0 = (com.iproov.sdk.p026return.Cstatic) r0     // Catch:{ IProovException -> 0x0189 }
            if (r0 != 0) goto L_0x0121
            goto L_0x0128
        L_0x0121:
            long r10 = r0.m1692for()     // Catch:{ IProovException -> 0x0189 }
            kotlin.coroutines.jvm.internal.a.d(r10)     // Catch:{ IProovException -> 0x0189 }
        L_0x0128:
            com.iproov.sdk.if.default r0 = r9.f2165if     // Catch:{ IProovException -> 0x0189 }
            kotlinx.coroutines.flow.a1 r0 = r0.m759transient()     // Catch:{ IProovException -> 0x0189 }
            com.iproov.sdk.if.strictfp$else r4 = new com.iproov.sdk.if.strictfp$else     // Catch:{ IProovException -> 0x0189 }
            com.iproov.sdk.if.implements r6 = new com.iproov.sdk.if.implements     // Catch:{ IProovException -> 0x0189 }
            byte[] r11 = r8.m840do()     // Catch:{ IProovException -> 0x0189 }
            long r12 = r8.m842if()     // Catch:{ IProovException -> 0x0189 }
            com.iproov.sdk.if.default r10 = r9.f2165if     // Catch:{ IProovException -> 0x0189 }
            kotlinx.coroutines.flow.b1 r10 = r10.m728class()     // Catch:{ IProovException -> 0x0189 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ IProovException -> 0x0189 }
            com.iproov.sdk.if.new r10 = (com.iproov.sdk.p016if.Cnew) r10     // Catch:{ IProovException -> 0x0189 }
            r15 = 0
            if (r10 != 0) goto L_0x014c
            r16 = r15
            goto L_0x0152
        L_0x014c:
            android.graphics.RectF r10 = r10.m790if()     // Catch:{ IProovException -> 0x0189 }
            r16 = r10
        L_0x0152:
            T r7 = r7.element     // Catch:{ IProovException -> 0x0189 }
            byte[] r7 = (byte[]) r7     // Catch:{ IProovException -> 0x0189 }
            boolean r10 = r8.m843new()     // Catch:{ IProovException -> 0x0189 }
            if (r10 == 0) goto L_0x0161
            com.iproov.sdk.core.if r10 = com.iproov.sdk.core.Cif.SUPPLEMENTARY     // Catch:{ IProovException -> 0x0189 }
        L_0x015e:
            r18 = r10
            goto L_0x0164
        L_0x0161:
            com.iproov.sdk.core.if r10 = com.iproov.sdk.core.Cif.AUTHENTICATION     // Catch:{ IProovException -> 0x0189 }
            goto L_0x015e
        L_0x0164:
            boolean r19 = r8.m841for()     // Catch:{ IProovException -> 0x0189 }
            r10 = r6
            r8 = r15
            r15 = r16
            r16 = r7
            r10.<init>(r11, r12, r14, r15, r16, r17, r18, r19)     // Catch:{ IProovException -> 0x0189 }
            r4.<init>(r6)     // Catch:{ IProovException -> 0x0189 }
            r2.f2249do = r9     // Catch:{ IProovException -> 0x0189 }
            r2.f2252if = r8     // Catch:{ IProovException -> 0x0189 }
            r2.f2251for = r8     // Catch:{ IProovException -> 0x0189 }
            r2.f2253new = r8     // Catch:{ IProovException -> 0x0189 }
            r2.f2250else = r5     // Catch:{ IProovException -> 0x0189 }
            java.lang.Object r0 = r0.emit(r4, r2)     // Catch:{ IProovException -> 0x0189 }
            if (r0 != r3) goto L_0x0185
            return r3
        L_0x0185:
            r2 = r9
        L_0x0186:
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ IProovException -> 0x0035 }
            goto L_0x0199
        L_0x0189:
            r0 = move-exception
            r2 = r9
            goto L_0x018e
        L_0x018c:
            r0 = move-exception
            r2 = r1
        L_0x018e:
            r9 = r2
        L_0x018f:
            com.tinder.StateMachine<com.iproov.sdk.transient.do$catch, com.iproov.sdk.transient.do$break, com.iproov.sdk.transient.do$this> r2 = r9.f2162final
            com.iproov.sdk.transient.do$break$new r3 = new com.iproov.sdk.transient.do$break$new
            r3.<init>(r0)
            r2.f(r3)
        L_0x0199:
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p034transient.Cdo.m2034do(com.iproov.sdk.if.try, kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final Object m2035do(com.iproov.sdk.Cif ifVar, c<? super Unit> cVar) {
        com.iproov.sdk.p017implements.Ccase.m977do(this);
        Objects.toString(ifVar);
        Object emit = this.f2165if.m759transient().emit(new Cstrictfp.Ctry(ifVar), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final Object m2033do(IProovException iProovException, c<? super Unit> cVar) {
        com.iproov.sdk.p017implements.Ccase.m977do(this);
        if (iProovException instanceof ServerException) {
            return Unit.f56620a;
        }
        Object emit = this.f2165if.m759transient().emit(new Cstrictfp.Cnew(iProovException), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final Object m2046do(c<? super Unit> cVar) {
        n1 d11 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cclass(this, (c<? super Cclass>) null), 3, (Object) null);
        if (d11 == IntrinsicsKt__IntrinsicsKt.d()) {
            return d11;
        }
        return Unit.f56620a;
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m2047do(Cbreak breakR) {
        if (breakR instanceof Cbreak.Ctry) {
            n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Csuper(this, breakR, (c<? super Csuper>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final Object m2036do(Cthis.Cfinal finalR, c<? super Unit> cVar) {
        String str;
        com.iproov.sdk.p003case.Cif value = this.f2165if.m741import().getValue();
        if (value == null || (str = com.iproov.sdk.p003case.Cnew.f170do.m242do(this.f2160do, value.m235goto(), finalR.m2083do(), value.m232do())) == null) {
            str = "";
        }
        Object emit = this.f2165if.getCurrentState().emit(new IProovState.Processing(finalR.m2083do(), str), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final Object m2037do(Cthis.Cgoto gotoR, c<? super Unit> cVar) {
        com.iproov.sdk.p035try.Cdo doVar = gotoR.m2085do();
        if (doVar.m2127if()) {
            Object emit = this.f2165if.getCurrentState().emit(new IProovState.Success(new com.iproov.sdk.p009do.Cthis(this.f2165if.a().getValue())), cVar);
            if (emit == IntrinsicsKt__IntrinsicsKt.d()) {
                return emit;
            }
        } else {
            Object emit2 = this.f2165if.getCurrentState().emit(new IProovState.Failure(new com.iproov.sdk.p009do.Cif(com.iproov.sdk.Cfor.f562if.m686do(doVar.m2126do()), this.f2165if.a().getValue())), cVar);
            if (emit2 == IntrinsicsKt__IntrinsicsKt.d()) {
                return emit2;
            }
        }
        return Unit.f56620a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m2038do(com.iproov.sdk.p034transient.Cdo.Cthis.Cthis r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.iproov.sdk.p034transient.Cdo.Cfinal
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.iproov.sdk.transient.do$final r0 = (com.iproov.sdk.p034transient.Cdo.Cfinal) r0
            int r1 = r0.f2204try
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2204try = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.transient.do$final r0 = new com.iproov.sdk.transient.do$final
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f2201for
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f2204try
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r7)
            goto L_0x0068
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f2202if
            com.iproov.sdk.transient.do$this$this r6 = (com.iproov.sdk.p034transient.Cdo.Cthis.Cthis) r6
            java.lang.Object r2 = r0.f2200do
            com.iproov.sdk.transient.do r2 = (com.iproov.sdk.p034transient.Cdo) r2
            kotlin.k.b(r7)
            goto L_0x0051
        L_0x0040:
            kotlin.k.b(r7)
            r0.f2200do = r5
            r0.f2202if = r6
            r0.f2204try = r4
            java.lang.Object r7 = r5.m2046do((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r7 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r2 = r5
        L_0x0051:
            com.iproov.sdk.transient.do$this$goto r7 = new com.iproov.sdk.transient.do$this$goto
            com.iproov.sdk.try.do r6 = r6.m2088do()
            r7.<init>(r6)
            r6 = 0
            r0.f2200do = r6
            r0.f2202if = r6
            r0.f2204try = r3
            java.lang.Object r6 = r2.m2037do((com.iproov.sdk.p034transient.Cdo.Cthis.Cgoto) r7, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r6 != r1) goto L_0x0068
            return r1
        L_0x0068:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p034transient.Cdo.m2038do(com.iproov.sdk.transient.do$this$this, kotlin.coroutines.c):java.lang.Object");
    }
}
