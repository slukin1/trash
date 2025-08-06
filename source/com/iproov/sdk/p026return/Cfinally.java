package com.iproov.sdk.p026return;

import android.content.Context;
import com.iproov.sdk.core.exception.CameraException;
import com.iproov.sdk.core.exception.CameraPermissionException;
import com.iproov.sdk.core.exception.FaceDetectorException;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.p009do.Cbreak;
import com.iproov.sdk.p013finally.Ctry;
import com.iproov.sdk.p016if.Ccontinue;
import com.iproov.sdk.p016if.Cstrictfp;
import com.iproov.sdk.p016if.Cvolatile;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.finally  reason: invalid class name and invalid package */
public final class Cfinally extends BaseCoroutineScope implements Ccontinue {
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public IProovException f1528case;

    /* renamed from: do  reason: not valid java name */
    private final Context f1529do;

    /* renamed from: else  reason: not valid java name */
    private final Ccase f1530else;
    /* access modifiers changed from: private */

    /* renamed from: for  reason: not valid java name */
    public final a1<Cvolatile> f1531for;
    /* access modifiers changed from: private */

    /* renamed from: goto  reason: not valid java name */
    public final com.iproov.sdk.p013finally.Ctry f1532goto;
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final f1<Cstrictfp> f1533if;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public final j1<Integer> f1534new;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public final Cbreak f1535try;

    /* renamed from: com.iproov.sdk.return.finally$case  reason: invalid class name */
    public static final class Ccase implements Ctry.Cif {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfinally f1536do;

        public Ccase(Cfinally finallyR) {
            this.f1536do = finallyR;
        }

        /* renamed from: do  reason: not valid java name */
        public void m1540do(com.iproov.sdk.p003case.Cif ifVar) {
            this.f1536do.m1531do((Cvolatile) new Cvolatile.Ccase(ifVar));
        }

        /* renamed from: if  reason: not valid java name */
        public void m1542if() {
            this.f1536do.m1531do((Cvolatile) Cvolatile.Cnew.f738do);
        }

        public void onConnected() {
            this.f1536do.m1531do((Cvolatile) Cvolatile.Cdo.f733do);
        }

        public void onConnecting() {
            this.f1536do.m1531do((Cvolatile) Cvolatile.Cif.f737do);
        }

        public void onError(IProovException iProovException) {
            Cfinally finallyR = this.f1536do;
            IProovException iProovException2 = finallyR.f1528case;
            if (iProovException2 != null) {
                iProovException = iProovException2;
            }
            finallyR.m1531do((Cvolatile) new Cvolatile.Ctry(iProovException));
        }

        /* renamed from: do  reason: not valid java name */
        public void m1539do(double d11) {
            this.f1536do.m1531do((Cvolatile) new Cvolatile.Cgoto(d11));
        }

        /* renamed from: do  reason: not valid java name */
        public void m1541do(com.iproov.sdk.p035try.Cdo doVar) {
            this.f1536do.m1531do((Cvolatile) new Cvolatile.Celse(doVar));
        }

        /* renamed from: do  reason: not valid java name */
        public void m1538do() {
            this.f1536do.m1531do((Cvolatile) Cvolatile.Cfor.f735do);
        }
    }

    @d(c = "com.iproov.sdk.impl.StreamerImpl$1", f = "StreamerImpl.kt", l = {183}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.finally$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1537do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cfinally f1538for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f1539if;

        /* renamed from: com.iproov.sdk.return.finally$do$do  reason: invalid class name */
        public static final class Cdo implements e<Cstrictfp> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f1540do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cfinally f1541if;

            public Cdo(h0 h0Var, Cfinally finallyR) {
                this.f1540do = h0Var;
                this.f1541if = finallyR;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d4, code lost:
                if (r12 == null) goto L_0x00d6;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(com.iproov.sdk.p016if.Cstrictfp r11, kotlin.coroutines.c<? super kotlin.Unit> r12) {
                /*
                    r10 = this;
                    com.iproov.sdk.if.strictfp r11 = (com.iproov.sdk.p016if.Cstrictfp) r11
                    kotlinx.coroutines.h0 r12 = r10.f1540do
                    com.iproov.sdk.p017implements.Ccase.m977do(r12)
                    java.lang.String r12 = "Streamer Action: "
                    kotlin.jvm.internal.x.i(r12, r11)
                    boolean r12 = r11 instanceof com.iproov.sdk.p016if.Cstrictfp.Cfor
                    if (r12 == 0) goto L_0x001b
                    com.iproov.sdk.return.finally r11 = r10.f1541if
                    com.iproov.sdk.finally.try r11 = r11.f1532goto
                    r11.m662if()
                    goto L_0x0107
                L_0x001b:
                    boolean r12 = r11 instanceof com.iproov.sdk.p016if.Cstrictfp.Cif
                    if (r12 == 0) goto L_0x0030
                    com.iproov.sdk.return.finally r12 = r10.f1541if
                    com.iproov.sdk.finally.try r12 = r12.f1532goto
                    com.iproov.sdk.if.strictfp$if r11 = (com.iproov.sdk.p016if.Cstrictfp.Cif) r11
                    com.iproov.sdk.try.if r11 = r11.m826do()
                    r12.m659do((com.iproov.sdk.p035try.Cif) r11)
                    goto L_0x0107
                L_0x0030:
                    boolean r12 = r11 instanceof com.iproov.sdk.p016if.Cstrictfp.Ccase
                    if (r12 == 0) goto L_0x0045
                    com.iproov.sdk.return.finally r12 = r10.f1541if
                    com.iproov.sdk.finally.try r12 = r12.f1532goto
                    com.iproov.sdk.if.strictfp$case r11 = (com.iproov.sdk.p016if.Cstrictfp.Ccase) r11
                    com.iproov.sdk.throws.break r11 = r11.m822do()
                    r12.m658do((com.iproov.sdk.p033throws.Cbreak) r11)
                    goto L_0x0107
                L_0x0045:
                    boolean r12 = r11 instanceof com.iproov.sdk.p016if.Cstrictfp.Cnew
                    if (r12 == 0) goto L_0x0069
                    com.iproov.sdk.return.finally r12 = r10.f1541if
                    com.iproov.sdk.if.strictfp$new r11 = (com.iproov.sdk.p016if.Cstrictfp.Cnew) r11
                    com.iproov.sdk.core.exception.IProovException r0 = r11.m827do()
                    r12.f1528case = r0
                    com.iproov.sdk.return.finally r12 = r10.f1541if
                    com.iproov.sdk.finally.try r12 = r12.f1532goto
                    com.iproov.sdk.return.finally r0 = r10.f1541if
                    com.iproov.sdk.core.exception.IProovException r11 = r11.m827do()
                    java.lang.String r11 = r0.m1527do((com.iproov.sdk.core.exception.IProovException) r11)
                    r12.m664new(r11)
                    goto L_0x0107
                L_0x0069:
                    boolean r12 = r11 instanceof com.iproov.sdk.p016if.Cstrictfp.Ctry
                    if (r12 == 0) goto L_0x0084
                    com.iproov.sdk.return.finally r12 = r10.f1541if
                    com.iproov.sdk.finally.try r12 = r12.f1532goto
                    com.iproov.sdk.return.finally r0 = r10.f1541if
                    com.iproov.sdk.if.strictfp$try r11 = (com.iproov.sdk.p016if.Cstrictfp.Ctry) r11
                    com.iproov.sdk.if r11 = r11.m828do()
                    java.lang.String r11 = r0.m1528do((com.iproov.sdk.Cif) r11)
                    r12.m664new(r11)
                    goto L_0x0107
                L_0x0084:
                    boolean r12 = r11 instanceof com.iproov.sdk.p016if.Cstrictfp.Cdo
                    if (r12 == 0) goto L_0x009c
                    com.iproov.sdk.return.finally r12 = r10.f1541if
                    com.iproov.sdk.finally.try r12 = r12.f1532goto
                    com.iproov.sdk.if.strictfp$do r11 = (com.iproov.sdk.p016if.Cstrictfp.Cdo) r11
                    com.iproov.sdk.cameray.break r0 = r11.m823do()
                    int r11 = r11.m824if()
                    r12.m657do((com.iproov.sdk.cameray.Cbreak) r0, (int) r11)
                    goto L_0x0107
                L_0x009c:
                    boolean r12 = r11 instanceof com.iproov.sdk.p016if.Cstrictfp.Celse
                    if (r12 == 0) goto L_0x0107
                    com.iproov.sdk.if.strictfp$else r11 = (com.iproov.sdk.p016if.Cstrictfp.Celse) r11
                    com.iproov.sdk.if.implements r11 = r11.m825do()
                    com.iproov.sdk.core.catch r12 = com.iproov.sdk.core.Ccatch.AND5
                    com.iproov.sdk.core.Cbreak.m310do(r12)
                    com.iproov.sdk.return.finally r12 = r10.f1541if     // Catch:{ IProovException -> 0x00fc }
                    com.iproov.sdk.finally.try r0 = r12.f1532goto     // Catch:{ IProovException -> 0x00fc }
                    byte[] r1 = r11.m779if()     // Catch:{ IProovException -> 0x00fc }
                    long r2 = r11.m776else()     // Catch:{ IProovException -> 0x00fc }
                    java.lang.Long r2 = kotlin.coroutines.jvm.internal.a.d(r2)     // Catch:{ IProovException -> 0x00fc }
                    java.util.List r3 = r11.m781try()     // Catch:{ IProovException -> 0x00fc }
                    android.graphics.RectF r4 = r11.m775do()     // Catch:{ IProovException -> 0x00fc }
                    byte[] r12 = r11.m774case()     // Catch:{ IProovException -> 0x00fc }
                    if (r12 != 0) goto L_0x00cc
                    goto L_0x00d6
                L_0x00cc:
                    byte[] r12 = r11.m774case()     // Catch:{ IProovException -> 0x00fc }
                    java.lang.String r12 = com.iproov.sdk.p017implements.Cimport.m1016do((byte[]) r12)     // Catch:{ IProovException -> 0x00fc }
                    if (r12 != 0) goto L_0x00d8
                L_0x00d6:
                    java.lang.String r12 = ""
                L_0x00d8:
                    r5 = r12
                    com.iproov.sdk.class.else r6 = r11.m777for()     // Catch:{ IProovException -> 0x00fc }
                    com.iproov.sdk.core.if r7 = r11.m780new()     // Catch:{ IProovException -> 0x00fc }
                    boolean r8 = r11.m778goto()     // Catch:{ IProovException -> 0x00fc }
                    boolean r11 = r11.m778goto()     // Catch:{ IProovException -> 0x00fc }
                    if (r11 == 0) goto L_0x00f6
                    com.iproov.sdk.return.finally r11 = r10.f1541if     // Catch:{ IProovException -> 0x00fc }
                    com.iproov.sdk.do.break r11 = r11.f1535try     // Catch:{ IProovException -> 0x00fc }
                    com.iproov.sdk.do.break$for r11 = r11.m558do()     // Catch:{ IProovException -> 0x00fc }
                    goto L_0x00f7
                L_0x00f6:
                    r11 = 0
                L_0x00f7:
                    r9 = r11
                    r0.m660do(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ IProovException -> 0x00fc }
                    goto L_0x0107
                L_0x00fc:
                    r11 = move-exception
                    com.iproov.sdk.return.finally r12 = r10.f1541if
                    com.iproov.sdk.if.volatile$try r0 = new com.iproov.sdk.if.volatile$try
                    r0.<init>(r11)
                    r12.m1531do((com.iproov.sdk.p016if.Cvolatile) r0)
                L_0x0107:
                    kotlin.Unit r11 = kotlin.Unit.f56620a
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cfinally.Cdo.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cfinally finallyR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1538for = finallyR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cdo doVar = new Cdo(this.f1538for, cVar);
            doVar.f1539if = obj;
            return doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1537do;
            if (i11 == 0) {
                k.b(obj);
                f1 f1Var = this.f1538for.f1533if;
                Cdo doVar = new Cdo((h0) this.f1539if, this.f1538for);
                this.f1537do = 1;
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

    /* renamed from: com.iproov.sdk.return.finally$for  reason: invalid class name */
    public /* synthetic */ class Cfor {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f1542do;

        static {
            int[] iArr = new int[com.iproov.sdk.Cif.values().length];
            iArr[com.iproov.sdk.Cif.f643if.ordinal()] = 1;
            iArr[com.iproov.sdk.Cif.USER.ordinal()] = 2;
            f1542do = iArr;
        }
    }

    @d(c = "com.iproov.sdk.impl.StreamerImpl$2", f = "StreamerImpl.kt", l = {183}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.finally$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1543do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cfinally f1544if;

        /* renamed from: com.iproov.sdk.return.finally$if$do  reason: invalid class name */
        public static final class Cdo implements e<Integer> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cfinally f1545do;

            public Cdo(Cfinally finallyR) {
                this.f1545do = finallyR;
            }

            public Object emit(Integer num, c<? super Unit> cVar) {
                Unit unit;
                Integer num2 = num;
                if (num2 == null) {
                    unit = null;
                } else {
                    this.f1545do.f1532goto.m656do(num2.intValue());
                    unit = Unit.f56620a;
                }
                if (unit == IntrinsicsKt__IntrinsicsKt.d()) {
                    return unit;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cfinally finallyR, c<? super Cif> cVar) {
            super(2, cVar);
            this.f1544if = finallyR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cif(this.f1544if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1543do;
            if (i11 == 0) {
                k.b(obj);
                j1 j1Var = this.f1544if.f1534new;
                Cdo doVar = new Cdo(this.f1544if);
                this.f1543do = 1;
                if (j1Var.collect(doVar, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.StreamerImpl$doStop$1", f = "StreamerImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.finally$new  reason: invalid class name */
    public static final class Cnew extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1546do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cfinally f1547if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(Cfinally finallyR, c<? super Cnew> cVar) {
            super(2, cVar);
            this.f1547if = finallyR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cnew(this.f1547if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cnew) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f1546do == 0) {
                k.b(obj);
                com.iproov.sdk.p013finally.Ctry.m644do(this.f1547if.f1532goto, (String) null, 1, (Object) null);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d(c = "com.iproov.sdk.impl.StreamerImpl$emitStreamerEvent$1", f = "StreamerImpl.kt", l = {156}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.finally$try  reason: invalid class name */
    public static final class Ctry extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1548do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cvolatile f1549for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f1550if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cfinally f1551new;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ctry(Cvolatile volatileR, Cfinally finallyR, c<? super Ctry> cVar) {
            super(2, cVar);
            this.f1549for = volatileR;
            this.f1551new = finallyR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Ctry tryR = new Ctry(this.f1549for, this.f1551new, cVar);
            tryR.f1550if = obj;
            return tryR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Ctry) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1548do;
            if (i11 == 0) {
                k.b(obj);
                com.iproov.sdk.p017implements.Ccase.m977do((h0) this.f1550if);
                x.i("Streamer Event -> ", this.f1549for);
                a1 a1Var = this.f1551new.f1531for;
                Cvolatile volatileR = this.f1549for;
                this.f1548do = 1;
                if (a1Var.emit(volatileR, this) == d11) {
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cfinally(Context context, String str, String str2, Cextends.Ccatch catchR, f1 f1Var, a1 a1Var, j1 j1Var, Cbreak breakR, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, str, str2, catchR, f1Var, a1Var, j1Var, breakR, (i11 & 256) != 0 ? v0.b() : coroutineDispatcher);
    }

    public void doStop() {
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cnew(this, (c<? super Cnew>) null), 3, (Object) null);
    }

    public void handleCoroutineException(CoroutineContext coroutineContext, Throwable th2) {
        this.f1531for.d(new Cvolatile.Ctry(new UnexpectedErrorException(this.f1529do, th2)));
        super.handleCoroutineException(coroutineContext, th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cfinally(Context context, String str, String str2, Cextends.Ccatch catchR, f1<? extends Cstrictfp> f1Var, a1<Cvolatile> a1Var, j1<Integer> j1Var, Cbreak breakR, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1529do = context;
        this.f1533if = f1Var;
        this.f1531for = a1Var;
        this.f1534new = j1Var;
        this.f1535try = breakR;
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
        n1 unused2 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, (c<? super Cif>) null), 3, (Object) null);
        Ccase caseR = new Ccase(this);
        this.f1530else = caseR;
        this.f1532goto = new com.iproov.sdk.p013finally.Ctry(context, str, str2, catchR, caseR);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final String m1527do(IProovException iProovException) {
        if (iProovException instanceof CameraException) {
            return "error_camera";
        }
        if (iProovException instanceof CameraPermissionException) {
            return "error_camera_permission_denied";
        }
        if (iProovException instanceof FaceDetectorException) {
            return "error_face_detector";
        }
        return iProovException instanceof NetworkException ? "error_network" : "error_client";
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final String m1528do(com.iproov.sdk.Cif ifVar) {
        int i11 = Cfor.f1542do[ifVar.ordinal()];
        if (i11 == 1) {
            return "cancelled_integration";
        }
        if (i11 == 2) {
            return "cancelled_user";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m1531do(Cvolatile volatileR) {
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Ctry(volatileR, this, (c<? super Ctry>) null), 3, (Object) null);
    }
}
