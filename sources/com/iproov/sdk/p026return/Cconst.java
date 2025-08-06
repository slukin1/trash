package com.iproov.sdk.p026return;

import com.iproov.sdk.IProovSessionState;
import com.iproov.sdk.IProovState;
import com.iproov.sdk.p009do.Ccase;
import com.iproov.sdk.p009do.Cnew;
import com.iproov.sdk.p016if.Ctransient;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import java.util.UUID;
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
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.const  reason: invalid class name and invalid package */
public final class Cconst extends BaseCoroutineScope implements Ccase {

    /* renamed from: do  reason: not valid java name */
    private final String f1361do;

    /* renamed from: for  reason: not valid java name */
    private final UUID f1362for;
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final j1<IProovState> f1363if;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public Ctransient f1364new;

    @d(c = "com.iproov.sdk.impl.InternalSession$1", f = "InternalSession.kt", l = {66}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.const$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1365do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cconst f1366for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f1367if;

        /* renamed from: com.iproov.sdk.return.const$do$do  reason: invalid class name */
        public static final class Cdo implements e<IProovState> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f1368do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cconst f1369if;

            @d(c = "com.iproov.sdk.impl.InternalSession$1$invokeSuspend$$inlined$collect$1", f = "InternalSession.kt", l = {136}, m = "emit")
            /* renamed from: com.iproov.sdk.return.const$do$do$do  reason: invalid class name */
            public static final class Cdo extends ContinuationImpl {

                /* renamed from: do  reason: not valid java name */
                public /* synthetic */ Object f1370do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cdo f1371for;

                /* renamed from: if  reason: not valid java name */
                public int f1372if;

                /* renamed from: new  reason: not valid java name */
                public Object f1373new;

                /* renamed from: try  reason: not valid java name */
                public Object f1374try;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cdo doVar, c cVar) {
                    super(cVar);
                    this.f1371for = doVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f1370do = obj;
                    this.f1372if |= Integer.MIN_VALUE;
                    return this.f1371for.emit((IProovState) null, this);
                }
            }

            public Cdo(h0 h0Var, Cconst constR) {
                this.f1368do = h0Var;
                this.f1369if = constR;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(com.iproov.sdk.IProovState r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.iproov.sdk.p026return.Cconst.Cdo.Cdo.Cdo
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    com.iproov.sdk.return.const$do$do$do r0 = (com.iproov.sdk.p026return.Cconst.Cdo.Cdo.Cdo) r0
                    int r1 = r0.f1372if
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f1372if = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.return.const$do$do$do r0 = new com.iproov.sdk.return.const$do$do$do
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.f1370do
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f1372if
                    r3 = 1
                    if (r2 == 0) goto L_0x0039
                    if (r2 != r3) goto L_0x0031
                    java.lang.Object r6 = r0.f1374try
                    com.iproov.sdk.IProovState r6 = (com.iproov.sdk.IProovState) r6
                    java.lang.Object r0 = r0.f1373new
                    com.iproov.sdk.return.const$do$do r0 = (com.iproov.sdk.p026return.Cconst.Cdo.Cdo) r0
                    kotlin.k.b(r7)
                    goto L_0x0063
                L_0x0031:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0039:
                    kotlin.k.b(r7)
                    com.iproov.sdk.IProovState r6 = (com.iproov.sdk.IProovState) r6
                    kotlinx.coroutines.h0 r7 = r5.f1368do
                    com.iproov.sdk.p017implements.Ccase.m977do(r7)
                    java.lang.String r7 = "Received: session state "
                    kotlin.jvm.internal.x.i(r7, r6)
                    com.iproov.sdk.do.new r7 = com.iproov.sdk.p009do.Cnew.f489do
                    kotlinx.coroutines.flow.b1 r7 = r7.m575do()
                    com.iproov.sdk.IProovSessionState r2 = new com.iproov.sdk.IProovSessionState
                    com.iproov.sdk.return.const r4 = r5.f1369if
                    r2.<init>(r4, r6)
                    r0.f1373new = r5
                    r0.f1374try = r6
                    r0.f1372if = r3
                    java.lang.Object r7 = r7.emit(r2, r0)
                    if (r7 != r1) goto L_0x0062
                    return r1
                L_0x0062:
                    r0 = r5
                L_0x0063:
                    boolean r6 = r6.isFinal()
                    if (r6 == 0) goto L_0x0080
                    com.iproov.sdk.return.const r6 = r0.f1369if
                    com.iproov.sdk.if.transient r6 = r6.f1364new
                    if (r6 != 0) goto L_0x0072
                    goto L_0x0075
                L_0x0072:
                    r6.stop()
                L_0x0075:
                    com.iproov.sdk.return.const r6 = r0.f1369if
                    r7 = 0
                    r6.f1364new = r7
                    com.iproov.sdk.return.const r6 = r0.f1369if
                    r6.stop()
                L_0x0080:
                    kotlin.Unit r6 = kotlin.Unit.f56620a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cconst.Cdo.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cconst constR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1366for = constR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cdo doVar = new Cdo(this.f1366for, cVar);
            doVar.f1367if = obj;
            return doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1365do;
            if (i11 == 0) {
                k.b(obj);
                j1 j1Var = this.f1366for.f1363if;
                Cdo doVar = new Cdo((h0) this.f1367if, this.f1366for);
                this.f1365do = 1;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cconst(String str, j1 j1Var, Ctransient transientR, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(str, j1Var, transientR, (i11 & 8) != 0 ? v0.a() : coroutineDispatcher);
    }

    public void cancel() {
        Ctransient transientR = this.f1364new;
        if (transientR != null) {
            transientR.cancel();
        }
    }

    public IProovState getCurrentState() {
        return this.f1363if.getValue();
    }

    public String getToken() {
        return this.f1361do;
    }

    public UUID getUuid() {
        return this.f1362for;
    }

    public boolean isActive() {
        return !getCurrentState().isFinal();
    }

    /* renamed from: try  reason: not valid java name */
    public final void m1423try() {
        Ctransient transientR = this.f1364new;
        if (transientR != null) {
            transientR.m839try();
        }
    }

    public Cconst(String str, j1<? extends IProovState> j1Var, Ctransient transientR, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1361do = str;
        this.f1363if = j1Var;
        this.f1362for = UUID.randomUUID();
        this.f1364new = transientR;
        Cnew.f489do.m575do().d(new IProovSessionState(this, IProovState.Connecting.INSTANCE));
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
    }
}
