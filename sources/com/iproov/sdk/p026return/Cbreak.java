package com.iproov.sdk.p026return;

import android.content.Context;
import android.graphics.Bitmap;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.p010else.Cfor;
import com.iproov.sdk.p016if.Ccatch;
import com.iproov.sdk.p016if.Cpackage;
import com.iproov.sdk.p016if.Cstrictfp;
import com.iproov.sdk.p016if.Cswitch;
import com.tinder.StateMachine;
import d10.l;
import d10.p;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.break  reason: invalid class name and invalid package */
public final class Cbreak extends Cthis {

    /* renamed from: abstract  reason: not valid java name */
    private final int f1150abstract;
    /* access modifiers changed from: private */

    /* renamed from: const  reason: not valid java name */
    public final Context f1151const;
    /* access modifiers changed from: private */

    /* renamed from: continue  reason: not valid java name */
    public com.iproov.sdk.p010else.Cfor f1152continue;

    /* renamed from: default  reason: not valid java name */
    private final a1<com.iproov.sdk.p016if.Celse> f1153default;

    /* renamed from: extends  reason: not valid java name */
    private final a1<String> f1154extends;

    /* renamed from: final  reason: not valid java name */
    private final Cswitch f1155final;

    /* renamed from: finally  reason: not valid java name */
    private final b1<Bitmap> f1156finally;
    /* access modifiers changed from: private */

    /* renamed from: implements  reason: not valid java name */
    public final StateMachine<Ccase, Ctry, Cnew> f1157implements;
    /* access modifiers changed from: private */

    /* renamed from: import  reason: not valid java name */
    public final f1<com.iproov.sdk.p016if.Cclass> f1158import;

    /* renamed from: interface  reason: not valid java name */
    private final com.iproov.sdk.p017implements.Cbreak f1159interface;
    /* access modifiers changed from: private */

    /* renamed from: native  reason: not valid java name */
    public final a1<com.iproov.sdk.p016if.Ccatch> f1160native;
    /* access modifiers changed from: private */

    /* renamed from: package  reason: not valid java name */
    public final com.iproov.sdk.p019interface.Cif f1161package;
    /* access modifiers changed from: private */

    /* renamed from: private  reason: not valid java name */
    public final AtomicInteger f1162private;

    /* renamed from: protected  reason: not valid java name */
    private final Cthis f1163protected;
    /* access modifiers changed from: private */

    /* renamed from: public  reason: not valid java name */
    public final a1<com.iproov.sdk.p016if.Cconst> f1164public;
    /* access modifiers changed from: private */

    /* renamed from: return  reason: not valid java name */
    public final j1<com.iproov.sdk.p017implements.Cthis> f1165return;
    /* access modifiers changed from: private */

    /* renamed from: static  reason: not valid java name */
    public final j1<com.iproov.sdk.p017implements.Cthis> f1166static;
    /* access modifiers changed from: private */

    /* renamed from: strictfp  reason: not valid java name */
    public com.iproov.sdk.p015goto.Cdo f1167strictfp;

    /* renamed from: super  reason: not valid java name */
    private final com.iproov.sdk.p016if.Cthis f1168super;

    /* renamed from: switch  reason: not valid java name */
    private final a1<com.iproov.sdk.p016if.Cif> f1169switch;
    /* access modifiers changed from: private */

    /* renamed from: throw  reason: not valid java name */
    public final a1<Cstrictfp> f1170throw;
    /* access modifiers changed from: private */

    /* renamed from: throws  reason: not valid java name */
    public final b1<Integer> f1171throws;

    /* renamed from: transient  reason: not valid java name */
    private final com.iproov.sdk.p006const.Cfor f1172transient;

    /* renamed from: volatile  reason: not valid java name */
    private Double f1173volatile;
    /* access modifiers changed from: private */

    /* renamed from: while  reason: not valid java name */
    public final b1<com.iproov.sdk.p016if.Cfinal> f1174while;

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl", f = "GpaScannerImpl.kt", l = {210}, m = "processCannyFace")
    /* renamed from: com.iproov.sdk.return.break$break  reason: invalid class name */
    public static final class Cbreak extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f1175do;

        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ Object f1176for;

        /* renamed from: if  reason: not valid java name */
        public Object f1177if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cbreak f1178new;

        /* renamed from: try  reason: not valid java name */
        public int f1179try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cbreak(Cbreak breakR, c<? super Cbreak> cVar) {
            super(cVar);
            this.f1178new = breakR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1176for = obj;
            this.f1179try |= Integer.MIN_VALUE;
            return this.f1178new.m1337do((com.iproov.sdk.p021new.Cfor) null, (Bitmap) null, (FaceFeature) null, this);
        }
    }

    /* renamed from: com.iproov.sdk.return.break$case  reason: invalid class name */
    public static abstract class Ccase {

        /* renamed from: com.iproov.sdk.return.break$case$do  reason: invalid class name */
        public static final class Cdo extends Ccase {

            /* renamed from: do  reason: not valid java name */
            public static final Cdo f1180do = new Cdo();

            private Cdo() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.return.break$case$if  reason: invalid class name */
        public static final class Cif extends Ccase {

            /* renamed from: do  reason: not valid java name */
            public static final Cif f1181do = new Cif();

            private Cif() {
                super((r) null);
            }
        }

        private Ccase() {
        }

        public /* synthetic */ Ccase(r rVar) {
            this();
        }

        public String toString() {
            return "GPAState [" + getClass().getSimpleName() + ']';
        }
    }

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl$processCannyFace$3$1$1", f = "GpaScannerImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.break$catch  reason: invalid class name */
    public static final class Ccatch extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1182do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ com.iproov.sdk.p015goto.Cif f1183for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cbreak f1184if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ccatch(Cbreak breakR, com.iproov.sdk.p015goto.Cif ifVar, c<? super Ccatch> cVar) {
            super(2, cVar);
            this.f1184if = breakR;
            this.f1183for = ifVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Ccatch(this.f1184if, this.f1183for, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Ccatch) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f1182do == 0) {
                k.b(obj);
                this.f1184if.f1157implements.f(new Ctry.Cif(com.iproov.sdk.p016if.Csuper.m830do(this.f1183for)));
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl$sendClientLuxData$2$1", f = "GpaScannerImpl.kt", l = {350}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.break$class  reason: invalid class name */
    public static final class Cclass extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1185do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ com.iproov.sdk.p033throws.Cbreak f1186for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cbreak f1187if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cclass(Cbreak breakR, com.iproov.sdk.p033throws.Cbreak breakR2, c<? super Cclass> cVar) {
            super(2, cVar);
            this.f1187if = breakR;
            this.f1186for = breakR2;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cclass(this.f1187if, this.f1186for, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cclass) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1185do;
            if (i11 == 0) {
                k.b(obj);
                a1 a1Var = this.f1187if.f1170throw;
                Cstrictfp.Ccase caseR = new Cstrictfp.Ccase(this.f1186for);
                this.f1185do = 1;
                if (a1Var.emit(caseR, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl", f = "GpaScannerImpl.kt", l = {297, 301}, m = "sendFrameActions")
    /* renamed from: com.iproov.sdk.return.break$const  reason: invalid class name */
    public static final class Cconst extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f1188do;

        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ Object f1189for;

        /* renamed from: if  reason: not valid java name */
        public Object f1190if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cbreak f1191new;

        /* renamed from: try  reason: not valid java name */
        public int f1192try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cconst(Cbreak breakR, c<? super Cconst> cVar) {
            super(cVar);
            this.f1191new = breakR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1189for = obj;
            this.f1192try |= Integer.MIN_VALUE;
            return this.f1191new.m1318do((c<? super Unit>) this);
        }
    }

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl$1", f = "GpaScannerImpl.kt", l = {146}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.break$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1193do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cbreak f1194if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cbreak breakR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1194if = breakR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f1194if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1193do;
            if (i11 == 0) {
                k.b(obj);
                b1 b1Var = this.f1194if.f1171throws;
                com.iproov.sdk.p010else.Cfor forR = this.f1194if.f1152continue;
                if (forR == null) {
                    forR = null;
                }
                Integer c11 = a.c(forR.m589new());
                this.f1193do = 1;
                if (b1Var.emit(c11, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl", f = "GpaScannerImpl.kt", l = {309, 316}, m = "checkEncodeFrame")
    /* renamed from: com.iproov.sdk.return.break$else  reason: invalid class name */
    public static final class Celse extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f1195do;

        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ Object f1196for;

        /* renamed from: if  reason: not valid java name */
        public Object f1197if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cbreak f1198new;

        /* renamed from: try  reason: not valid java name */
        public int f1199try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Celse(Cbreak breakR, c<? super Celse> cVar) {
            super(cVar);
            this.f1198new = breakR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1196for = obj;
            this.f1199try |= Integer.MIN_VALUE;
            return this.f1198new.m1323for((com.iproov.sdk.p021new.Cfor) null, (c<? super Unit>) this);
        }
    }

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl", f = "GpaScannerImpl.kt", l = {361, 362, 366, 368}, m = "startFlashing")
    /* renamed from: com.iproov.sdk.return.break$final  reason: invalid class name */
    public static final class Cfinal extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f1200do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cbreak f1201for;

        /* renamed from: if  reason: not valid java name */
        public /* synthetic */ Object f1202if;

        /* renamed from: new  reason: not valid java name */
        public int f1203new;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfinal(Cbreak breakR, c<? super Cfinal> cVar) {
            super(cVar);
            this.f1201for = breakR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1202if = obj;
            this.f1203new |= Integer.MIN_VALUE;
            return this.f1201for.m1331if((c<? super Unit>) this);
        }
    }

    /* renamed from: com.iproov.sdk.return.break$for  reason: invalid class name */
    public static final class Cfor {
        private Cfor() {
        }

        public /* synthetic */ Cfor(r rVar) {
            this();
        }
    }

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl", f = "GpaScannerImpl.kt", l = {322, 323}, m = "checkEncodeSupplementaryFrame")
    /* renamed from: com.iproov.sdk.return.break$goto  reason: invalid class name */
    public static final class Cgoto extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public Object f1204do;

        /* renamed from: for  reason: not valid java name */
        public /* synthetic */ Object f1205for;

        /* renamed from: if  reason: not valid java name */
        public Object f1206if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cbreak f1207new;

        /* renamed from: try  reason: not valid java name */
        public int f1208try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cgoto(Cbreak breakR, c<? super Cgoto> cVar) {
            super(cVar);
            this.f1207new = breakR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1205for = obj;
            this.f1208try |= Integer.MIN_VALUE;
            return this.f1207new.m1332new((com.iproov.sdk.p021new.Cfor) null, this);
        }
    }

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl$2", f = "GpaScannerImpl.kt", l = {404}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.break$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1209do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cbreak f1210for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f1211if;

        @d(c = "com.iproov.sdk.impl.GpaScannerImpl$2$1$1", f = "GpaScannerImpl.kt", l = {156}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.break$if$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1212do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cbreak f1213if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cbreak breakR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1213if = breakR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f1213if, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1212do;
                if (i11 == 0) {
                    k.b(obj);
                    this.f1212do = 1;
                    if (DelayKt.b(3000, this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.f1213if.m1314const();
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.return.break$if$for  reason: invalid class name */
        public static final class Cfor implements e<com.iproov.sdk.p016if.Cclass> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cbreak f1214do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ h0 f1215if;

            public Cfor(Cbreak breakR, h0 h0Var) {
                this.f1214do = breakR;
                this.f1215if = h0Var;
            }

            public Object emit(com.iproov.sdk.p016if.Cclass classR, c<? super Unit> cVar) {
                int i11 = Cif.f1216do[classR.ordinal()];
                if (i11 != 1) {
                    if (i11 == 2) {
                        this.f1214do.m1314const();
                    } else if (i11 == 3) {
                        this.f1214do.m1314const();
                    }
                } else if (this.f1214do.f1161package.m1107const()) {
                    n1 unused = i.d(this.f1215if, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this.f1214do, (c<? super Cdo>) null), 3, (Object) null);
                }
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.return.break$if$if  reason: invalid class name */
        public /* synthetic */ class Cif {

            /* renamed from: do  reason: not valid java name */
            public static final /* synthetic */ int[] f1216do;

            static {
                int[] iArr = new int[com.iproov.sdk.p016if.Cclass.values().length];
                iArr[com.iproov.sdk.p016if.Cclass.READY.ordinal()] = 1;
                iArr[com.iproov.sdk.p016if.Cclass.TAP_TO_START.ordinal()] = 2;
                iArr[com.iproov.sdk.p016if.Cclass.COUNTDOWN_COMPLETE.ordinal()] = 3;
                f1216do = iArr;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cbreak breakR, c<? super Cif> cVar) {
            super(2, cVar);
            this.f1210for = breakR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cif ifVar = new Cif(this.f1210for, cVar);
            ifVar.f1211if = obj;
            return ifVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1209do;
            if (i11 == 0) {
                k.b(obj);
                f1 f1Var = this.f1210for.f1158import;
                Cfor forR = new Cfor(this.f1210for, (h0) this.f1211if);
                this.f1209do = 1;
                if (f1Var.collect(forR, this) == d11) {
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

    /* renamed from: com.iproov.sdk.return.break$new  reason: invalid class name */
    public static abstract class Cnew {

        /* renamed from: com.iproov.sdk.return.break$new$do  reason: invalid class name */
        public static final class Cdo extends Cnew {

            /* renamed from: do  reason: not valid java name */
            private final Ctry.Cdo f1217do;

            public Cdo(Ctry.Cdo doVar) {
                super((r) null);
                this.f1217do = doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Ctry.Cdo m1345do() {
                return this.f1217do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cdo) && x.b(this.f1217do, ((Cdo) obj).f1217do);
            }

            public int hashCode() {
                return this.f1217do.hashCode();
            }

            public String toString() {
                return "FlashWithColor(event=" + this.f1217do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.break$new$for  reason: invalid class name */
        public static final class Cfor extends Cnew {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.p021new.Cfor f1218do;

            public Cfor(com.iproov.sdk.p021new.Cfor forR) {
                super((r) null);
                this.f1218do = forR;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.p021new.Cfor m1346do() {
                return this.f1218do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cfor) && x.b(this.f1218do, ((Cfor) obj).f1218do);
            }

            public int hashCode() {
                return this.f1218do.hashCode();
            }

            public String toString() {
                return "ProcessFlashingFrame(frame=" + this.f1218do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.break$new$if  reason: invalid class name */
        public static final class Cif extends Cnew {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.p021new.Cfor f1219do;

            public Cif(com.iproov.sdk.p021new.Cfor forR) {
                super((r) null);
                this.f1219do = forR;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.p021new.Cfor m1347do() {
                return this.f1219do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cif) && x.b(this.f1219do, ((Cif) obj).f1219do);
            }

            public int hashCode() {
                return this.f1219do.hashCode();
            }

            public String toString() {
                return "ProcessCannyFrame(frame=" + this.f1219do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.break$new$new  reason: invalid class name */
        public static final class Cnew extends Cnew {

            /* renamed from: do  reason: not valid java name */
            public static final Cnew f1220do = new Cnew();

            private Cnew() {
                super((r) null);
            }
        }

        /* renamed from: com.iproov.sdk.return.break$new$try  reason: invalid class name */
        public static final class Ctry extends Cnew {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.p016if.Cfinal f1221do;

            public Ctry(com.iproov.sdk.p016if.Cfinal finalR) {
                super((r) null);
                this.f1221do = finalR;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.p016if.Cfinal m1348do() {
                return this.f1221do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Ctry) && this.f1221do == ((Ctry) obj).f1221do;
            }

            public int hashCode() {
                return this.f1221do.hashCode();
            }

            public String toString() {
                return "SendView(gpaViewState=" + this.f1221do + ')';
            }
        }

        private Cnew() {
        }

        public /* synthetic */ Cnew(r rVar) {
            this();
        }

        public String toString() {
            return "GPAAction [" + getClass().getSimpleName() + ']';
        }
    }

    /* renamed from: com.iproov.sdk.return.break$super  reason: invalid class name */
    public static final class Csuper extends Lambda implements l<StateMachine.GraphBuilder<Ccase, Ctry, Cnew>, Unit> {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cbreak f1222do;

        /* renamed from: com.iproov.sdk.return.break$super$do  reason: invalid class name */
        public static final class Cdo extends Lambda implements l<StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cdo>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cbreak f1223do;

            /* renamed from: com.iproov.sdk.return.break$super$do$do  reason: invalid class name */
            public static final class Cdo extends Lambda implements p<Ccase.Cdo, Ctry.Cif, StateMachine.Graph.State.a<? extends Ccase, ? extends Cnew>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cdo> f1224do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cdo> stateDefinitionBuilder) {
                    super(2);
                    this.f1224do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccase, Cnew> invoke(Ccase.Cdo doVar, Ctry.Cif ifVar) {
                    return this.f1224do.b(doVar, new Cnew.Ctry(ifVar.m1373do()));
                }
            }

            /* renamed from: com.iproov.sdk.return.break$super$do$for  reason: invalid class name */
            public static final class Cfor extends Lambda implements p<Ccase.Cdo, Ctry.Cnew, StateMachine.Graph.State.a<? extends Ccase, ? extends Cnew>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ Cbreak f1225do;

                /* renamed from: if  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cdo> f1226if;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cfor(Cbreak breakR, StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cdo> stateDefinitionBuilder) {
                    super(2);
                    this.f1225do = breakR;
                    this.f1226if = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccase, Cnew> invoke(Ccase.Cdo doVar, Ctry.Cnew newR) {
                    if (!this.f1225do.f1161package.m1107const()) {
                        com.iproov.sdk.p015goto.Cdo doVar2 = this.f1225do.f1167strictfp;
                        if (!(doVar2 != null && doVar2.m690for())) {
                            return StateMachine.GraphBuilder.StateDefinitionBuilder.c(this.f1226if, doVar, (Object) null, 1, (Object) null);
                        }
                    }
                    return this.f1226if.e(doVar, Ccase.Cif.f1181do, Cnew.Cnew.f1220do);
                }
            }

            /* renamed from: com.iproov.sdk.return.break$super$do$if  reason: invalid class name */
            public static final class Cif extends Lambda implements p<Ccase.Cdo, Ctry.Cfor, StateMachine.Graph.State.a<? extends Ccase, ? extends Cnew>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cdo> f1227do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cif(StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cdo> stateDefinitionBuilder) {
                    super(2);
                    this.f1227do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccase, Cnew> invoke(Ccase.Cdo doVar, Ctry.Cfor forR) {
                    return this.f1227do.b(doVar, new Cnew.Cif(forR.m1372do()));
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cbreak breakR) {
                super(1);
                this.f1223do = breakR;
            }

            /* renamed from: do  reason: not valid java name */
            public final void m1350do(StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cdo> stateDefinitionBuilder) {
                Cdo doVar = new Cdo(stateDefinitionBuilder);
                StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
                stateDefinitionBuilder.d(aVar.a(Ctry.Cif.class), doVar);
                stateDefinitionBuilder.d(aVar.a(Ctry.Cfor.class), new Cif(stateDefinitionBuilder));
                stateDefinitionBuilder.d(aVar.a(Ctry.Cnew.class), new Cfor(this.f1223do, stateDefinitionBuilder));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1350do((StateMachine.GraphBuilder.StateDefinitionBuilder) obj);
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.return.break$super$for  reason: invalid class name */
        public static final class Cfor extends Lambda implements l<StateMachine.b<? extends Ccase, ? extends Ctry, ? extends Cnew>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ StateMachine.GraphBuilder<Ccase, Ctry, Cnew> f1228do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cbreak f1229if;

            @d(c = "com.iproov.sdk.impl.GpaScannerImpl$stateMachine$1$3$1", f = "GpaScannerImpl.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.iproov.sdk.return.break$super$for$do  reason: invalid class name */
            public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

                /* renamed from: do  reason: not valid java name */
                public int f1230do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cnew f1231for;

                /* renamed from: if  reason: not valid java name */
                private /* synthetic */ Object f1232if;

                /* renamed from: new  reason: not valid java name */
                public final /* synthetic */ Cbreak f1233new;

                @d(c = "com.iproov.sdk.impl.GpaScannerImpl$stateMachine$1$3$1$1", f = "GpaScannerImpl.kt", l = {256, 257, 258, 259}, m = "invokeSuspend")
                /* renamed from: com.iproov.sdk.return.break$super$for$do$do  reason: invalid class name */
                public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

                    /* renamed from: do  reason: not valid java name */
                    public int f1234do;

                    /* renamed from: for  reason: not valid java name */
                    public final /* synthetic */ Cnew f1235for;

                    /* renamed from: if  reason: not valid java name */
                    public final /* synthetic */ Cbreak f1236if;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Cdo(Cbreak breakR, Cnew newR, c<? super Cdo> cVar) {
                        super(2, cVar);
                        this.f1236if = breakR;
                        this.f1235for = newR;
                    }

                    public final c<Unit> create(Object obj, c<?> cVar) {
                        return new Cdo(this.f1236if, this.f1235for, cVar);
                    }

                    /* renamed from: do  reason: not valid java name */
                    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                        return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[RETURN] */
                    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                        /*
                            r6 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                            int r1 = r6.f1234do
                            r2 = 4
                            r3 = 3
                            r4 = 2
                            r5 = 1
                            if (r1 == 0) goto L_0x002c
                            if (r1 == r5) goto L_0x0028
                            if (r1 == r4) goto L_0x0024
                            if (r1 == r3) goto L_0x0020
                            if (r1 != r2) goto L_0x0018
                            kotlin.k.b(r7)
                            goto L_0x006b
                        L_0x0018:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r0)
                            throw r7
                        L_0x0020:
                            kotlin.k.b(r7)
                            goto L_0x0060
                        L_0x0024:
                            kotlin.k.b(r7)
                            goto L_0x004d
                        L_0x0028:
                            kotlin.k.b(r7)
                            goto L_0x0042
                        L_0x002c:
                            kotlin.k.b(r7)
                            com.iproov.sdk.return.break r7 = r6.f1236if
                            com.iproov.sdk.return.break$new r1 = r6.f1235for
                            com.iproov.sdk.return.break$new$if r1 = (com.iproov.sdk.p026return.Cbreak.Cnew.Cif) r1
                            com.iproov.sdk.new.for r1 = r1.m1347do()
                            r6.f1234do = r5
                            java.lang.Object r7 = com.iproov.sdk.p026return.Cbreak.Csuper.Cfor.Cdo.super.m1717if(r1, r6)
                            if (r7 != r0) goto L_0x0042
                            return r0
                        L_0x0042:
                            com.iproov.sdk.return.break r7 = r6.f1236if
                            r6.f1234do = r4
                            java.lang.Object r7 = r7.m1318do((kotlin.coroutines.c<? super kotlin.Unit>) r6)
                            if (r7 != r0) goto L_0x004d
                            return r0
                        L_0x004d:
                            com.iproov.sdk.return.break r7 = r6.f1236if
                            com.iproov.sdk.return.break$new r1 = r6.f1235for
                            com.iproov.sdk.return.break$new$if r1 = (com.iproov.sdk.p026return.Cbreak.Cnew.Cif) r1
                            com.iproov.sdk.new.for r1 = r1.m1347do()
                            r6.f1234do = r3
                            java.lang.Object r7 = r7.m1332new(r1, r6)
                            if (r7 != r0) goto L_0x0060
                            return r0
                        L_0x0060:
                            com.iproov.sdk.return.break r7 = r6.f1236if
                            r6.f1234do = r2
                            java.lang.Object r7 = r7.m1326for((kotlin.coroutines.c<? super kotlin.Unit>) r6)
                            if (r7 != r0) goto L_0x006b
                            return r0
                        L_0x006b:
                            kotlin.Unit r7 = kotlin.Unit.f56620a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cbreak.Csuper.Cfor.Cdo.Cdo.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                @d(c = "com.iproov.sdk.impl.GpaScannerImpl$stateMachine$1$3$1$3", f = "GpaScannerImpl.kt", l = {271}, m = "invokeSuspend")
                /* renamed from: com.iproov.sdk.return.break$super$for$do$for  reason: invalid class name */
                public static final class Cfor extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

                    /* renamed from: do  reason: not valid java name */
                    public int f1237do;

                    /* renamed from: for  reason: not valid java name */
                    public final /* synthetic */ Cnew f1238for;

                    /* renamed from: if  reason: not valid java name */
                    public final /* synthetic */ Cbreak f1239if;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Cfor(Cbreak breakR, Cnew newR, c<? super Cfor> cVar) {
                        super(2, cVar);
                        this.f1239if = breakR;
                        this.f1238for = newR;
                    }

                    public final c<Unit> create(Object obj, c<?> cVar) {
                        return new Cfor(this.f1239if, this.f1238for, cVar);
                    }

                    /* renamed from: do  reason: not valid java name */
                    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                        return ((Cfor) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                        int i11 = this.f1237do;
                        if (i11 == 0) {
                            k.b(obj);
                            b1 b1Var = this.f1239if.f1174while;
                            com.iproov.sdk.p016if.Cfinal finalR = ((Cnew.Ctry) this.f1238for).m1348do();
                            this.f1237do = 1;
                            if (b1Var.emit(finalR, this) == d11) {
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

                @d(c = "com.iproov.sdk.impl.GpaScannerImpl$stateMachine$1$3$1$2", f = "GpaScannerImpl.kt", l = {264, 265, 266}, m = "invokeSuspend")
                /* renamed from: com.iproov.sdk.return.break$super$for$do$if  reason: invalid class name */
                public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

                    /* renamed from: do  reason: not valid java name */
                    public int f1240do;

                    /* renamed from: for  reason: not valid java name */
                    public final /* synthetic */ Cnew f1241for;

                    /* renamed from: if  reason: not valid java name */
                    public final /* synthetic */ Cbreak f1242if;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Cif(Cbreak breakR, Cnew newR, c<? super Cif> cVar) {
                        super(2, cVar);
                        this.f1242if = breakR;
                        this.f1241for = newR;
                    }

                    public final c<Unit> create(Object obj, c<?> cVar) {
                        return new Cif(this.f1242if, this.f1241for, cVar);
                    }

                    /* renamed from: do  reason: not valid java name */
                    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                        return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                        /*
                            r5 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                            int r1 = r5.f1240do
                            r2 = 3
                            r3 = 2
                            r4 = 1
                            if (r1 == 0) goto L_0x0025
                            if (r1 == r4) goto L_0x0021
                            if (r1 == r3) goto L_0x001d
                            if (r1 != r2) goto L_0x0015
                            kotlin.k.b(r6)
                            goto L_0x0051
                        L_0x0015:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r0)
                            throw r6
                        L_0x001d:
                            kotlin.k.b(r6)
                            goto L_0x0046
                        L_0x0021:
                            kotlin.k.b(r6)
                            goto L_0x0033
                        L_0x0025:
                            kotlin.k.b(r6)
                            com.iproov.sdk.return.break r6 = r5.f1242if
                            r5.f1240do = r4
                            java.lang.Object r6 = r6.m1318do((kotlin.coroutines.c<? super kotlin.Unit>) r5)
                            if (r6 != r0) goto L_0x0033
                            return r0
                        L_0x0033:
                            com.iproov.sdk.return.break r6 = r5.f1242if
                            com.iproov.sdk.return.break$new r1 = r5.f1241for
                            com.iproov.sdk.return.break$new$for r1 = (com.iproov.sdk.p026return.Cbreak.Cnew.Cfor) r1
                            com.iproov.sdk.new.for r1 = r1.m1346do()
                            r5.f1240do = r3
                            java.lang.Object r6 = r6.m1323for((com.iproov.sdk.p021new.Cfor) r1, (kotlin.coroutines.c<? super kotlin.Unit>) r5)
                            if (r6 != r0) goto L_0x0046
                            return r0
                        L_0x0046:
                            com.iproov.sdk.return.break r6 = r5.f1242if
                            r5.f1240do = r2
                            java.lang.Object r6 = r6.m1326for((kotlin.coroutines.c<? super kotlin.Unit>) r5)
                            if (r6 != r0) goto L_0x0051
                            return r0
                        L_0x0051:
                            kotlin.Unit r6 = kotlin.Unit.f56620a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cbreak.Csuper.Cfor.Cdo.Cif.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                @d(c = "com.iproov.sdk.impl.GpaScannerImpl$stateMachine$1$3$1$4", f = "GpaScannerImpl.kt", l = {275}, m = "invokeSuspend")
                /* renamed from: com.iproov.sdk.return.break$super$for$do$new  reason: invalid class name */
                public static final class Cnew extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

                    /* renamed from: do  reason: not valid java name */
                    public int f1243do;

                    /* renamed from: if  reason: not valid java name */
                    public final /* synthetic */ Cbreak f1244if;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Cnew(Cbreak breakR, c<? super Cnew> cVar) {
                        super(2, cVar);
                        this.f1244if = breakR;
                    }

                    public final c<Unit> create(Object obj, c<?> cVar) {
                        return new Cnew(this.f1244if, cVar);
                    }

                    /* renamed from: do  reason: not valid java name */
                    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                        return ((Cnew) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                        int i11 = this.f1243do;
                        if (i11 == 0) {
                            k.b(obj);
                            Cbreak breakR = this.f1244if;
                            this.f1243do = 1;
                            if (breakR.m1331if((c<? super Unit>) this) == d11) {
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

                @d(c = "com.iproov.sdk.impl.GpaScannerImpl$stateMachine$1$3$1$5", f = "GpaScannerImpl.kt", l = {279, 287}, m = "invokeSuspend")
                /* renamed from: com.iproov.sdk.return.break$super$for$do$try  reason: invalid class name */
                public static final class Ctry extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

                    /* renamed from: do  reason: not valid java name */
                    public int f1245do;

                    /* renamed from: for  reason: not valid java name */
                    public final /* synthetic */ Cnew f1246for;

                    /* renamed from: if  reason: not valid java name */
                    public final /* synthetic */ Cbreak f1247if;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public Ctry(Cbreak breakR, Cnew newR, c<? super Ctry> cVar) {
                        super(2, cVar);
                        this.f1247if = breakR;
                        this.f1246for = newR;
                    }

                    public final c<Unit> create(Object obj, c<?> cVar) {
                        return new Ctry(this.f1247if, this.f1246for, cVar);
                    }

                    /* renamed from: do  reason: not valid java name */
                    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                        return ((Ctry) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                        int i11 = this.f1245do;
                        if (i11 == 0) {
                            k.b(obj);
                            a1 a1Var = this.f1247if.f1164public;
                            com.iproov.sdk.p016if.Cconst constR = new com.iproov.sdk.p016if.Cconst(((Cnew.Cdo) this.f1246for).m1345do().m1368do(), ((Cnew.Cdo) this.f1246for).m1345do().m1371new(), ((Cnew.Cdo) this.f1246for).m1345do().m1370if());
                            this.f1245do = 1;
                            if (a1Var.emit(constR, this) == d11) {
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
                        if (((Cnew.Cdo) this.f1246for).m1345do().m1369for()) {
                            a1 a1Var2 = this.f1247if.f1160native;
                            Ccatch.Cfor forR = Ccatch.Cfor.f646do;
                            this.f1245do = 2;
                            if (a1Var2.emit(forR, this) == d11) {
                                return d11;
                            }
                        }
                        return Unit.f56620a;
                    }
                }

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cnew newR, Cbreak breakR, c<? super Cdo> cVar) {
                    super(2, cVar);
                    this.f1231for = newR;
                    this.f1233new = breakR;
                }

                public final c<Unit> create(Object obj, c<?> cVar) {
                    Cdo doVar = new Cdo(this.f1231for, this.f1233new, cVar);
                    doVar.f1232if = obj;
                    return doVar;
                }

                /* renamed from: do  reason: not valid java name */
                public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                    return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
                }

                public final Object invokeSuspend(Object obj) {
                    Object unused = IntrinsicsKt__IntrinsicsKt.d();
                    if (this.f1230do == 0) {
                        k.b(obj);
                        h0 h0Var = (h0) this.f1232if;
                        Cnew newR = this.f1231for;
                        if (newR != null) {
                            if (newR instanceof Cnew.Cif) {
                                n1 unused2 = i.d(h0Var, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this.f1233new, newR, (c<? super Cdo>) null), 3, (Object) null);
                            } else if (newR instanceof Cnew.Cfor) {
                                n1 unused3 = i.d(h0Var, (CoroutineContext) null, (CoroutineStart) null, new Cif(this.f1233new, newR, (c<? super Cif>) null), 3, (Object) null);
                            } else if (newR instanceof Cnew.Ctry) {
                                n1 unused4 = i.d(h0Var, (CoroutineContext) null, (CoroutineStart) null, new Cfor(this.f1233new, newR, (c<? super Cfor>) null), 3, (Object) null);
                            } else if (newR instanceof Cnew.Cnew) {
                                n1 unused5 = i.d(h0Var, (CoroutineContext) null, (CoroutineStart) null, new Cnew(this.f1233new, (c<? super Cnew>) null), 3, (Object) null);
                            } else if (newR instanceof Cnew.Cdo) {
                                n1 unused6 = i.d(h0Var, (CoroutineContext) null, (CoroutineStart) null, new Ctry(this.f1233new, newR, (c<? super Ctry>) null), 3, (Object) null);
                            }
                        }
                        return Unit.f56620a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cfor(StateMachine.GraphBuilder<Ccase, Ctry, Cnew> graphBuilder, Cbreak breakR) {
                super(1);
                this.f1228do = graphBuilder;
                this.f1229if = breakR;
            }

            /* renamed from: do  reason: not valid java name */
            public final void m1354do(StateMachine.b<? extends Ccase, ? extends Ctry, ? extends Cnew> bVar) {
                StateMachine.b.C0639b bVar2 = bVar instanceof StateMachine.b.C0639b ? (StateMachine.b.C0639b) bVar : null;
                if (bVar2 != null) {
                    Cnew newR = (Cnew) bVar2.c();
                    com.iproov.sdk.p017implements.Ccase.m977do(this.f1228do);
                    Objects.toString(bVar2.d());
                    Objects.toString(newR);
                    Cbreak breakR = this.f1229if;
                    n1 unused = i.d(breakR, (CoroutineContext) null, (CoroutineStart) null, new Cdo(newR, breakR, (c<? super Cdo>) null), 3, (Object) null);
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1354do((StateMachine.b) obj);
                return Unit.f56620a;
            }
        }

        /* renamed from: com.iproov.sdk.return.break$super$if  reason: invalid class name */
        public static final class Cif extends Lambda implements l<StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cif>, Unit> {

            /* renamed from: do  reason: not valid java name */
            public static final Cif f1248do = new Cif();

            /* renamed from: com.iproov.sdk.return.break$super$if$do  reason: invalid class name */
            public static final class Cdo extends Lambda implements p<Ccase.Cif, Ctry.Cdo, StateMachine.Graph.State.a<? extends Ccase, ? extends Cnew>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cif> f1249do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cif> stateDefinitionBuilder) {
                    super(2);
                    this.f1249do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccase, Cnew> invoke(Ccase.Cif ifVar, Ctry.Cdo doVar) {
                    return this.f1249do.b(ifVar, new Cnew.Cdo(doVar));
                }
            }

            /* renamed from: com.iproov.sdk.return.break$super$if$if  reason: invalid class name */
            public static final class Cif extends Lambda implements p<Ccase.Cif, Ctry.Cfor, StateMachine.Graph.State.a<? extends Ccase, ? extends Cnew>> {

                /* renamed from: do  reason: not valid java name */
                public final /* synthetic */ StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cif> f1250do;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cif(StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cif> stateDefinitionBuilder) {
                    super(2);
                    this.f1250do = stateDefinitionBuilder;
                }

                /* renamed from: do  reason: not valid java name */
                public final StateMachine.Graph.State.a<Ccase, Cnew> invoke(Ccase.Cif ifVar, Ctry.Cfor forR) {
                    return this.f1250do.b(ifVar, new Cnew.Cfor(forR.m1372do()));
                }
            }

            public Cif() {
                super(1);
            }

            /* renamed from: do  reason: not valid java name */
            public final void m1361do(StateMachine.GraphBuilder<Ccase, Ctry, Cnew>.StateDefinitionBuilder<Ccase.Cif> stateDefinitionBuilder) {
                Cdo doVar = new Cdo(stateDefinitionBuilder);
                StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
                stateDefinitionBuilder.d(aVar.a(Ctry.Cdo.class), doVar);
                stateDefinitionBuilder.d(aVar.a(Ctry.Cfor.class), new Cif(stateDefinitionBuilder));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1361do((StateMachine.GraphBuilder.StateDefinitionBuilder) obj);
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Csuper(Cbreak breakR) {
            super(1);
            this.f1222do = breakR;
        }

        /* renamed from: do  reason: not valid java name */
        public final void m1349do(StateMachine.GraphBuilder<Ccase, Ctry, Cnew> graphBuilder) {
            graphBuilder.b(Ccase.Cdo.f1180do);
            Cdo doVar = new Cdo(this.f1222do);
            StateMachine.Matcher.a aVar = StateMachine.Matcher.f51124c;
            graphBuilder.d(aVar.a(Ccase.Cdo.class), doVar);
            graphBuilder.d(aVar.a(Ccase.Cif.class), Cif.f1248do);
            graphBuilder.c(new Cfor(graphBuilder, this.f1222do));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m1349do((StateMachine.GraphBuilder) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.iproov.sdk.return.break$this  reason: invalid class name */
    public static final class Cthis implements Cfor.Cdo {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cbreak f1251do;

        @d(c = "com.iproov.sdk.impl.GpaScannerImpl$legacyListener$1$onFlashRequested$1", f = "GpaScannerImpl.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.break$this$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1252do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p010else.Cdo f1253for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cbreak f1254if;

            /* renamed from: new  reason: not valid java name */
            public final /* synthetic */ int f1255new;

            /* renamed from: try  reason: not valid java name */
            public final /* synthetic */ int f1256try;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cbreak breakR, com.iproov.sdk.p010else.Cdo doVar, int i11, int i12, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1254if = breakR;
                this.f1253for = doVar;
                this.f1255new = i11;
                this.f1256try = i12;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f1254if, this.f1253for, this.f1255new, this.f1256try, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f1252do == 0) {
                    k.b(obj);
                    int color = this.f1254if.f1151const.getResources().getColor(this.f1253for.m582do());
                    boolean z11 = true;
                    float f11 = (float) (this.f1255new + 1);
                    com.iproov.sdk.p010else.Cfor forR = this.f1254if.f1152continue;
                    com.iproov.sdk.p010else.Cfor forR2 = null;
                    if (forR == null) {
                        forR = null;
                    }
                    float f12 = f11 / ((float) forR.m586for());
                    com.iproov.sdk.p010else.Cfor forR3 = this.f1254if.f1152continue;
                    if (forR3 == null) {
                        forR3 = null;
                    }
                    forR3.m585do((float) ((com.iproov.sdk.p017implements.Cthis) this.f1254if.f1165return.getValue()).m1040do(), (float) ((com.iproov.sdk.p017implements.Cthis) this.f1254if.f1166static.getValue()).m1040do());
                    StateMachine stateMachine = this.f1254if.f1157implements;
                    long j11 = (long) this.f1256try;
                    double d11 = (double) this.f1255new;
                    com.iproov.sdk.p010else.Cfor forR4 = this.f1254if.f1152continue;
                    if (forR4 != null) {
                        forR2 = forR4;
                    }
                    if (d11 < ((double) forR2.m586for()) * 0.8d) {
                        z11 = false;
                    }
                    stateMachine.f(new Ctry.Cdo(color, f12, j11, z11));
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public Cthis(Cbreak breakR) {
            this.f1251do = breakR;
        }

        /* renamed from: do  reason: not valid java name */
        public void m1364do() {
        }

        /* renamed from: do  reason: not valid java name */
        public void m1365do(int i11, com.iproov.sdk.p010else.Cdo doVar, int i12) {
            Cbreak breakR = this.f1251do;
            n1 unused = i.d(breakR, (CoroutineContext) null, (CoroutineStart) null, new Cdo(breakR, doVar, i11, i12, (c<? super Cdo>) null), 3, (Object) null);
        }

        /* renamed from: if  reason: not valid java name */
        public void m1366if() {
            this.f1251do.f1162private.incrementAndGet();
        }
    }

    @d(c = "com.iproov.sdk.impl.GpaScannerImpl", f = "GpaScannerImpl.kt", l = {337}, m = "updateDebugOutput")
    /* renamed from: com.iproov.sdk.return.break$throw  reason: invalid class name */
    public static final class Cthrow extends ContinuationImpl {

        /* renamed from: do  reason: not valid java name */
        public /* synthetic */ Object f1257do;

        /* renamed from: for  reason: not valid java name */
        public int f1258for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cbreak f1259if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cthrow(Cbreak breakR, c<? super Cthrow> cVar) {
            super(cVar);
            this.f1259if = breakR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1257do = obj;
            this.f1258for |= Integer.MIN_VALUE;
            return this.f1259if.m1326for((c<? super Unit>) this);
        }
    }

    /* renamed from: com.iproov.sdk.return.break$try  reason: invalid class name */
    public static abstract class Ctry {

        /* renamed from: com.iproov.sdk.return.break$try$do  reason: invalid class name */
        public static final class Cdo extends Ctry {

            /* renamed from: do  reason: not valid java name */
            private final int f1260do;

            /* renamed from: for  reason: not valid java name */
            private final long f1261for;

            /* renamed from: if  reason: not valid java name */
            private final float f1262if;

            /* renamed from: new  reason: not valid java name */
            private final boolean f1263new;

            public Cdo(int i11, float f11, long j11, boolean z11) {
                super((r) null);
                this.f1260do = i11;
                this.f1262if = f11;
                this.f1261for = j11;
                this.f1263new = z11;
            }

            /* renamed from: do  reason: not valid java name */
            public final int m1368do() {
                return this.f1260do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Cdo)) {
                    return false;
                }
                Cdo doVar = (Cdo) obj;
                return this.f1260do == doVar.f1260do && x.b(Float.valueOf(this.f1262if), Float.valueOf(doVar.f1262if)) && this.f1261for == doVar.f1261for && this.f1263new == doVar.f1263new;
            }

            /* renamed from: for  reason: not valid java name */
            public final boolean m1369for() {
                return this.f1263new;
            }

            public int hashCode() {
                int floatToIntBits = ((((this.f1260do * 31) + Float.floatToIntBits(this.f1262if)) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f1261for)) * 31;
                boolean z11 = this.f1263new;
                if (z11) {
                    z11 = true;
                }
                return floatToIntBits + (z11 ? 1 : 0);
            }

            /* renamed from: if  reason: not valid java name */
            public final long m1370if() {
                return this.f1261for;
            }

            /* renamed from: new  reason: not valid java name */
            public final float m1371new() {
                return this.f1262if;
            }

            public String toString() {
                return "FlashWithColor(color=" + this.f1260do + ", progress=" + this.f1262if + ", estimatedDurationMillis=" + this.f1261for + ", fadeOutIfNeeded=" + this.f1263new + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.break$try$for  reason: invalid class name */
        public static final class Cfor extends Ctry {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.p021new.Cfor f1264do;

            public Cfor(com.iproov.sdk.p021new.Cfor forR) {
                super((r) null);
                this.f1264do = forR;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.p021new.Cfor m1372do() {
                return this.f1264do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cfor) && x.b(this.f1264do, ((Cfor) obj).f1264do);
            }

            public int hashCode() {
                return this.f1264do.hashCode();
            }

            public String toString() {
                return "NewFrame(frame=" + this.f1264do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.break$try$if  reason: invalid class name */
        public static final class Cif extends Ctry {

            /* renamed from: do  reason: not valid java name */
            private final com.iproov.sdk.p016if.Cfinal f1265do;

            public Cif(com.iproov.sdk.p016if.Cfinal finalR) {
                super((r) null);
                this.f1265do = finalR;
            }

            /* renamed from: do  reason: not valid java name */
            public final com.iproov.sdk.p016if.Cfinal m1373do() {
                return this.f1265do;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Cif) && this.f1265do == ((Cif) obj).f1265do;
            }

            public int hashCode() {
                return this.f1265do.hashCode();
            }

            public String toString() {
                return "NewCannyUI(gpaViewState=" + this.f1265do + ')';
            }
        }

        /* renamed from: com.iproov.sdk.return.break$try$new  reason: invalid class name */
        public static final class Cnew extends Ctry {

            /* renamed from: do  reason: not valid java name */
            public static final Cnew f1266do = new Cnew();

            private Cnew() {
                super((r) null);
            }
        }

        private Ctry() {
        }

        public /* synthetic */ Ctry(r rVar) {
            this();
        }

        public String toString() {
            return "GPAEvent [" + getClass().getSimpleName() + ']';
        }
    }

    static {
        new Cfor((r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cbreak(Context context, Cextends extendsR, com.iproov.sdk.p021new.Cnew newR, com.iproov.sdk.p003case.Cif ifVar, Cswitch switchR, com.iproov.sdk.p016if.Cthis thisR, a1 a1Var, b1 b1Var, f1 f1Var, a1 a1Var2, a1 a1Var3, j1 j1Var, j1 j1Var2, a1 a1Var4, b1 b1Var2, j1 j1Var3, a1 a1Var5, a1 a1Var6, a1 a1Var7, b1 b1Var3, a1 a1Var8, a1 a1Var9, b1 b1Var4, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, extendsR, newR, ifVar, switchR, thisR, a1Var, b1Var, f1Var, a1Var2, a1Var3, j1Var, j1Var2, a1Var4, b1Var2, j1Var3, a1Var5, a1Var6, a1Var7, b1Var3, a1Var8, a1Var9, b1Var4, (i11 & 8388608) != 0 ? v0.a() : coroutineDispatcher);
    }

    public void doStop() {
        com.iproov.sdk.p010else.Cfor forR = this.f1152continue;
        if (forR == null) {
            forR = null;
        }
        forR.m587if();
        this.f1155final.stop();
        this.f1168super.stop();
    }

    /* access modifiers changed from: private */
    /* renamed from: const  reason: not valid java name */
    public final void m1314const() {
        this.f1157implements.f(Ctry.Cnew.f1266do);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: new  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1332new(com.iproov.sdk.p021new.Cfor r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.iproov.sdk.p026return.Cbreak.Cgoto
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.iproov.sdk.return.break$goto r0 = (com.iproov.sdk.p026return.Cbreak.Cgoto) r0
            int r1 = r0.f1208try
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1208try = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.break$goto r0 = new com.iproov.sdk.return.break$goto
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f1205for
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1208try
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r9)
            goto L_0x0080
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            java.lang.Object r8 = r0.f1206if
            com.iproov.sdk.new.for r8 = (com.iproov.sdk.p021new.Cfor) r8
            java.lang.Object r2 = r0.f1204do
            com.iproov.sdk.return.break r2 = (com.iproov.sdk.p026return.Cbreak) r2
            kotlin.k.b(r9)
            goto L_0x0062
        L_0x0040:
            kotlin.k.b(r9)
            com.iproov.sdk.try.else r9 = r7.m1713class()
            boolean r9 = r9.m2129do()
            if (r9 == 0) goto L_0x0083
            com.iproov.sdk.p017implements.Ccase.m977do(r7)
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.catch> r9 = r7.f1160native
            com.iproov.sdk.if.catch$do r2 = com.iproov.sdk.p016if.Ccatch.Cdo.f645do
            r0.f1204do = r7
            r0.f1206if = r8
            r0.f1208try = r4
            java.lang.Object r9 = r9.emit(r2, r0)
            if (r9 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r2 = r7
        L_0x0062:
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.else> r9 = r2.f1153default
            com.iproov.sdk.if.else$do r5 = new com.iproov.sdk.if.else$do
            com.iproov.sdk.else.for r2 = r2.f1152continue
            r6 = 0
            if (r2 != 0) goto L_0x006c
            r2 = r6
        L_0x006c:
            int r2 = r2.m589new()
            r5.<init>(r8, r4, r2)
            r0.f1204do = r6
            r0.f1206if = r6
            r0.f1208try = r3
            java.lang.Object r8 = r9.emit(r5, r0)
            if (r8 != r1) goto L_0x0080
            return r1
        L_0x0080:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        L_0x0083:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cbreak.m1332new(com.iproov.sdk.new.for, kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: this  reason: not valid java name */
    public int m1339this() {
        return this.f1150abstract;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cbreak(Context context, Cextends extendsR, com.iproov.sdk.p021new.Cnew newR, com.iproov.sdk.p003case.Cif ifVar, Cswitch switchR, com.iproov.sdk.p016if.Cthis thisR, a1<Cstrictfp> a1Var, b1<com.iproov.sdk.p016if.Cfinal> b1Var, f1<? extends com.iproov.sdk.p016if.Cclass> f1Var, a1<com.iproov.sdk.p016if.Ccatch> a1Var2, a1<com.iproov.sdk.p016if.Cconst> a1Var3, j1<com.iproov.sdk.p017implements.Cthis> j1Var, j1<com.iproov.sdk.p017implements.Cthis> j1Var2, a1<com.iproov.sdk.p016if.Cif> a1Var4, b1<Integer> b1Var2, j1<? extends Orientation> j1Var3, a1<Cpackage> a1Var5, a1<com.iproov.sdk.p016if.Celse> a1Var6, a1<Cstrictfp> a1Var7, b1<Bitmap> b1Var3, a1<String> a1Var8, a1<FaceFeature> a1Var9, b1<Bitmap> b1Var4, CoroutineDispatcher coroutineDispatcher) {
        super(context, newR, ifVar, thisR, j1Var3, a1Var5, a1Var7, a1Var9, b1Var3, coroutineDispatcher);
        this.f1151const = context;
        this.f1155final = switchR;
        this.f1168super = thisR;
        this.f1170throw = a1Var;
        this.f1174while = b1Var;
        this.f1158import = f1Var;
        this.f1160native = a1Var2;
        this.f1164public = a1Var3;
        this.f1165return = j1Var;
        this.f1166static = j1Var2;
        this.f1169switch = a1Var4;
        this.f1171throws = b1Var2;
        this.f1153default = a1Var6;
        this.f1154extends = a1Var8;
        this.f1156finally = b1Var4;
        this.f1161package = new com.iproov.sdk.p019interface.Cif(context);
        this.f1162private = new AtomicInteger(0);
        this.f1150abstract = 4;
        this.f1159interface = new com.iproov.sdk.p017implements.Cbreak(ifVar.m237new().f523goto, ifVar.m237new().f526this);
        Cthis thisR2 = new Cthis(this);
        this.f1163protected = thisR2;
        this.f1172transient = new com.iproov.sdk.p006const.Cfor(Float.valueOf(extendsR.m1477do().m1516for().m1520if()), Float.valueOf(extendsR.m1477do().m1516for().m1519for()), Float.valueOf(extendsR.m1477do().m1516for().m1518do()));
        m1713class().m2128do(ifVar.m231catch());
        this.f1152continue = new com.iproov.sdk.p010else.Cfor(ifVar.m234for(), ifVar.m237new(), thisR2);
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
        n1 unused2 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, (c<? super Cif>) null), 3, (Object) null);
        this.f1157implements = StateMachine.f51108c.b(new Csuper(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: for  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1323for(com.iproov.sdk.p021new.Cfor r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.iproov.sdk.p026return.Cbreak.Celse
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.iproov.sdk.return.break$else r0 = (com.iproov.sdk.p026return.Cbreak.Celse) r0
            int r1 = r0.f1199try
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1199try = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.break$else r0 = new com.iproov.sdk.return.break$else
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f1196for
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1199try
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.k.b(r10)
            goto L_0x0084
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.f1197if
            com.iproov.sdk.new.for r9 = (com.iproov.sdk.p021new.Cfor) r9
            java.lang.Object r2 = r0.f1195do
            com.iproov.sdk.return.break r2 = (com.iproov.sdk.p026return.Cbreak) r2
            kotlin.k.b(r10)
            goto L_0x0076
        L_0x0041:
            kotlin.k.b(r10)
            java.util.concurrent.atomic.AtomicInteger r10 = r8.f1162private
            int r10 = r10.get()
            if (r10 != 0) goto L_0x004f
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x004f:
            com.iproov.sdk.p017implements.Ccase.m977do(r8)
            java.util.concurrent.atomic.AtomicInteger r10 = r8.f1162private
            r10.decrementAndGet()
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.else> r10 = r8.f1153default
            com.iproov.sdk.if.else$do r2 = new com.iproov.sdk.if.else$do
            r6 = 0
            com.iproov.sdk.else.for r7 = r8.f1152continue
            if (r7 != 0) goto L_0x0061
            r7 = r5
        L_0x0061:
            int r7 = r7.m589new()
            r2.<init>(r9, r6, r7)
            r0.f1195do = r8
            r0.f1197if = r9
            r0.f1199try = r4
            java.lang.Object r10 = r10.emit(r2, r0)
            if (r10 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r2 = r8
        L_0x0076:
            r0.f1195do = r5
            r0.f1197if = r5
            r0.f1199try = r3
            r10 = 4
            java.lang.Object r9 = r2.m1715do(r9, r10, r0)
            if (r9 != r1) goto L_0x0084
            return r1
        L_0x0084:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cbreak.m1323for(com.iproov.sdk.new.for, kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1331if(kotlin.coroutines.c<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.iproov.sdk.p026return.Cbreak.Cfinal
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.iproov.sdk.return.break$final r0 = (com.iproov.sdk.p026return.Cbreak.Cfinal) r0
            int r1 = r0.f1203new
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1203new = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.break$final r0 = new com.iproov.sdk.return.break$final
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f1202if
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1203new
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r7) goto L_0x004d
            if (r2 == r6) goto L_0x0045
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            kotlin.k.b(r11)
            goto L_0x00d9
        L_0x0034:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x003c:
            java.lang.Object r2 = r0.f1200do
            com.iproov.sdk.return.break r2 = (com.iproov.sdk.p026return.Cbreak) r2
            kotlin.k.b(r11)
            goto L_0x00c7
        L_0x0045:
            java.lang.Object r2 = r0.f1200do
            com.iproov.sdk.return.break r2 = (com.iproov.sdk.p026return.Cbreak) r2
            kotlin.k.b(r11)
            goto L_0x0085
        L_0x004d:
            java.lang.Object r2 = r0.f1200do
            com.iproov.sdk.return.break r2 = (com.iproov.sdk.p026return.Cbreak) r2
            kotlin.k.b(r11)
            goto L_0x0076
        L_0x0055:
            kotlin.k.b(r11)
            com.iproov.sdk.p017implements.Ccase.m977do(r10)
            kotlinx.coroutines.flow.j1<com.iproov.sdk.implements.this> r11 = r10.f1165return
            java.lang.Object r11 = r11.getValue()
            java.lang.String r2 = "*** START FLASHING *** "
            kotlin.jvm.internal.x.i(r2, r11)
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.catch> r11 = r10.f1160native
            com.iproov.sdk.if.catch$new r2 = com.iproov.sdk.p016if.Ccatch.Cnew.f648do
            r0.f1200do = r10
            r0.f1203new = r7
            java.lang.Object r11 = r11.emit(r2, r0)
            if (r11 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r2 = r10
        L_0x0076:
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.if> r11 = r2.f1169switch
            com.iproov.sdk.if.if$do r8 = com.iproov.sdk.p016if.Cif.Cdo.f676do
            r0.f1200do = r2
            r0.f1203new = r6
            java.lang.Object r11 = r11.emit(r8, r0)
            if (r11 != r1) goto L_0x0085
            return r1
        L_0x0085:
            com.iproov.sdk.try.else r11 = r2.m1713class()
            r11.m2130if()
            com.iproov.sdk.else.for r11 = r2.f1152continue
            if (r11 != 0) goto L_0x0091
            r11 = r3
        L_0x0091:
            kotlinx.coroutines.flow.j1<com.iproov.sdk.implements.this> r6 = r2.f1165return
            java.lang.Object r6 = r6.getValue()
            com.iproov.sdk.implements.this r6 = (com.iproov.sdk.p017implements.Cthis) r6
            double r8 = r6.m1040do()
            float r6 = (float) r8
            kotlinx.coroutines.flow.j1<com.iproov.sdk.implements.this> r8 = r2.f1166static
            java.lang.Object r8 = r8.getValue()
            com.iproov.sdk.implements.this r8 = (com.iproov.sdk.p017implements.Cthis) r8
            double r8 = r8.m1040do()
            float r8 = (float) r8
            r11.m588if(r6, r8)
            com.iproov.sdk.goto.do r11 = r2.f1167strictfp
            if (r11 != 0) goto L_0x00b3
            goto L_0x00c7
        L_0x00b3:
            com.iproov.sdk.throws.this r11 = r11.m689do()
            if (r11 != 0) goto L_0x00ba
            goto L_0x00c7
        L_0x00ba:
            r0.f1200do = r2
            r0.f1203new = r5
            java.lang.String r5 = "flashing_start"
            java.lang.Object r11 = r2.m1317do((java.lang.String) r5, (com.iproov.sdk.p033throws.Cthis) r11, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r11 != r1) goto L_0x00c7
            return r1
        L_0x00c7:
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.if> r11 = r2.f1169switch
            com.iproov.sdk.if.if$for r2 = new com.iproov.sdk.if.if$for
            r2.<init>(r7)
            r0.f1200do = r3
            r0.f1203new = r4
            java.lang.Object r11 = r11.emit(r2, r0)
            if (r11 != r1) goto L_0x00d9
            return r1
        L_0x00d9:
            kotlin.Unit r11 = kotlin.Unit.f56620a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cbreak.m1331if(kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: do  reason: not valid java name */
    public Object m1338do(com.iproov.sdk.p021new.Cfor forR, c<? super Unit> cVar) {
        if (getJob().isActive()) {
            this.f1157implements.f(new Ctry.Cfor(forR));
        }
        return Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1337do(com.iproov.sdk.p021new.Cfor r10, android.graphics.Bitmap r11, com.iproov.sdk.face.model.FaceFeature r12, kotlin.coroutines.c<? super kotlin.Unit> r13) {
        /*
            r9 = this;
            boolean r10 = r13 instanceof com.iproov.sdk.p026return.Cbreak.Cbreak
            if (r10 == 0) goto L_0x0013
            r10 = r13
            com.iproov.sdk.return.break$break r10 = (com.iproov.sdk.p026return.Cbreak.Cbreak) r10
            int r0 = r10.f1179try
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r10.f1179try = r0
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.break$break r10 = new com.iproov.sdk.return.break$break
            r10.<init>(r9, r13)
        L_0x0018:
            java.lang.Object r13 = r10.f1176for
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r10.f1179try
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x003c
            if (r1 != r3) goto L_0x0034
            java.lang.Object r11 = r10.f1177if
            com.iproov.sdk.goto.if r11 = (com.iproov.sdk.p015goto.Cif) r11
            java.lang.Object r10 = r10.f1175do
            com.iproov.sdk.return.break r10 = (com.iproov.sdk.p026return.Cbreak) r10
            kotlin.k.b(r13)
            r3 = r10
            goto L_0x00b5
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            kotlin.k.b(r13)
            com.iproov.sdk.implements.break r13 = r9.f1159interface
            if (r12 != 0) goto L_0x0045
            r1 = r3
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            boolean r13 = r13.m976do(r1)
            if (r13 == 0) goto L_0x0052
            com.iproov.sdk.p017implements.Ccase.m977do(r9)
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        L_0x0052:
            com.iproov.sdk.if.switch r13 = r9.f1155final
            com.iproov.sdk.goto.do r11 = r13.m832do(r11, r12)
            if (r11 != 0) goto L_0x005c
            r11 = r2
            goto L_0x007d
        L_0x005c:
            if (r12 == 0) goto L_0x007d
            boolean r13 = r11.m690for()
            if (r13 == 0) goto L_0x007d
            com.iproov.sdk.face.model.Pose r12 = r12.getPose()
            if (r12 != 0) goto L_0x006b
            goto L_0x007d
        L_0x006b:
            com.iproov.sdk.const.for r13 = r9.f1172transient
            com.iproov.sdk.goto.if r12 = r13.m290do(r12)
            if (r12 == 0) goto L_0x007d
            com.iproov.sdk.goto.do r13 = new com.iproov.sdk.goto.do
            com.iproov.sdk.throws.this r11 = r11.m689do()
            r13.<init>(r12, r11)
            r11 = r13
        L_0x007d:
            if (r11 != 0) goto L_0x0080
            goto L_0x00c1
        L_0x0080:
            com.iproov.sdk.goto.if r12 = r11.m691if()
            com.iproov.sdk.goto.do r13 = r9.f1167strictfp
            if (r13 != 0) goto L_0x008a
            r13 = r2
            goto L_0x008e
        L_0x008a:
            com.iproov.sdk.goto.if r13 = r13.m691if()
        L_0x008e:
            if (r12 == r13) goto L_0x00c1
            r9.f1167strictfp = r11
            com.iproov.sdk.goto.if r12 = r11.m691if()
            com.iproov.sdk.p017implements.Ccase.m977do(r9)
            java.lang.String r13 = "GPA CannyState: "
            kotlin.jvm.internal.x.i(r13, r12)
            java.lang.String r13 = r12.m692do()
            com.iproov.sdk.throws.this r11 = r11.m689do()
            r10.f1175do = r9
            r10.f1177if = r12
            r10.f1179try = r3
            java.lang.Object r10 = r9.m1317do((java.lang.String) r13, (com.iproov.sdk.p033throws.Cthis) r11, (kotlin.coroutines.c<? super kotlin.Unit>) r10)
            if (r10 != r0) goto L_0x00b3
            return r0
        L_0x00b3:
            r3 = r9
            r11 = r12
        L_0x00b5:
            com.iproov.sdk.return.break$catch r6 = new com.iproov.sdk.return.break$catch
            r6.<init>(r3, r11, r2)
            r4 = 0
            r5 = 0
            r7 = 3
            r8 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r3, r4, r5, r6, r7, r8)
        L_0x00c1:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cbreak.m1337do(com.iproov.sdk.new.for, android.graphics.Bitmap, com.iproov.sdk.face.model.FaceFeature, kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: for  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1326for(kotlin.coroutines.c<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.iproov.sdk.p026return.Cbreak.Cthrow
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.iproov.sdk.return.break$throw r0 = (com.iproov.sdk.p026return.Cbreak.Cthrow) r0
            int r1 = r0.f1258for
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1258for = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.break$throw r0 = new com.iproov.sdk.return.break$throw
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f1257do
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1258for
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r5)
            goto L_0x0050
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.k.b(r5)
            com.iproov.sdk.interface.if r5 = r4.f1161package
            boolean r5 = r5.m1105catch()
            if (r5 == 0) goto L_0x0050
            com.iproov.sdk.if.switch r5 = r4.f1155final
            java.lang.String r5 = r5.m833for()
            if (r5 != 0) goto L_0x0045
            goto L_0x0050
        L_0x0045:
            kotlinx.coroutines.flow.a1<java.lang.String> r2 = r4.f1154extends
            r0.f1258for = r3
            java.lang.Object r5 = r2.emit(r5, r0)
            if (r5 != r1) goto L_0x0050
            return r1
        L_0x0050:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cbreak.m1326for(kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1318do(kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.iproov.sdk.p026return.Cbreak.Cconst
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.iproov.sdk.return.break$const r0 = (com.iproov.sdk.p026return.Cbreak.Cconst) r0
            int r1 = r0.f1192try
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1192try = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.break$const r0 = new com.iproov.sdk.return.break$const
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f1189for
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1192try
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r8)
            goto L_0x008d
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0034:
            java.lang.Object r2 = r0.f1190if
            java.lang.Double r2 = (java.lang.Double) r2
            java.lang.Object r4 = r0.f1188do
            com.iproov.sdk.return.break r4 = (com.iproov.sdk.p026return.Cbreak) r4
            kotlin.k.b(r8)
            goto L_0x006b
        L_0x0040:
            kotlin.k.b(r8)
            com.iproov.sdk.if.switch r8 = r7.f1155final
            java.lang.Double r2 = r8.m835new()
            java.lang.Double r8 = r7.f1173volatile
            r5 = 4502148214488346440(0x3e7ad7f29abcaf48, double:1.0E-7)
            boolean r8 = com.iproov.sdk.p017implements.Celse.m1001do(r8, r2, r5)
            if (r8 != 0) goto L_0x006e
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.catch> r8 = r7.f1160native
            com.iproov.sdk.if.catch$if r5 = new com.iproov.sdk.if.catch$if
            r5.<init>(r2)
            r0.f1188do = r7
            r0.f1190if = r2
            r0.f1192try = r4
            java.lang.Object r8 = r8.emit(r5, r0)
            if (r8 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r4 = r7
        L_0x006b:
            r4.f1173volatile = r2
            goto L_0x006f
        L_0x006e:
            r4 = r7
        L_0x006f:
            com.iproov.sdk.interface.if r8 = r4.f1161package
            boolean r8 = r8.m1105catch()
            if (r8 == 0) goto L_0x0090
            kotlinx.coroutines.flow.b1<android.graphics.Bitmap> r8 = r4.f1156finally
            com.iproov.sdk.if.switch r2 = r4.f1155final
            android.graphics.Bitmap r2 = r2.m834goto()
            r4 = 0
            r0.f1188do = r4
            r0.f1190if = r4
            r0.f1192try = r3
            java.lang.Object r8 = r8.emit(r2, r0)
            if (r8 != r1) goto L_0x008d
            return r1
        L_0x008d:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        L_0x0090:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cbreak.m1318do(kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: do  reason: not valid java name */
    private final Object m1317do(String str, com.iproov.sdk.p033throws.Cthis thisR, c<? super Unit> cVar) {
        n1 d11 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cclass(this, new com.iproov.sdk.p033throws.Cbreak(thisR, System.currentTimeMillis(), str, this.f1155final.m831break()), (c<? super Cclass>) null), 3, (Object) null);
        if (d11 == IntrinsicsKt__IntrinsicsKt.d()) {
            return d11;
        }
        return Unit.f56620a;
    }
}
