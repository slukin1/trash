package com.iproov.sdk.p026return;

import android.content.Context;
import android.util.Size;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.p005class.Cdo;
import com.iproov.sdk.p016if.Cbreak;
import com.iproov.sdk.p016if.Celse;
import com.iproov.sdk.p016if.Cgoto;
import com.iproov.sdk.p017implements.Ccatch;
import com.iproov.sdk.p017implements.Cthis;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import d10.q;
import java.io.ByteArrayOutputStream;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
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
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.else  reason: invalid class name and invalid package */
public final class Celse extends BaseCoroutineScope implements com.iproov.sdk.p016if.Ccase {
    /* access modifiers changed from: private */

    /* renamed from: break  reason: not valid java name */
    public com.iproov.sdk.p005class.Cdo f1400break;
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public final f1<com.iproov.sdk.p016if.Celse> f1401case;

    /* renamed from: catch  reason: not valid java name */
    private int f1402catch;
    /* access modifiers changed from: private */

    /* renamed from: class  reason: not valid java name */
    public int f1403class;
    /* access modifiers changed from: private */

    /* renamed from: const  reason: not valid java name */
    public int f1404const;
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final Context f1405do;
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public final a1<com.iproov.sdk.p016if.Cgoto> f1406else;
    /* access modifiers changed from: private */

    /* renamed from: final  reason: not valid java name */
    public final Queue<Ccatch> f1407final;
    /* access modifiers changed from: private */

    /* renamed from: for  reason: not valid java name */
    public final j1<Size> f1408for;

    /* renamed from: goto  reason: not valid java name */
    private final a1<Cbreak> f1409goto;
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final j1<com.iproov.sdk.p021new.Cnew> f1410if;

    /* renamed from: import  reason: not valid java name */
    private final double f1411import;

    /* renamed from: native  reason: not valid java name */
    private final Ccase f1412native;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public final j1<com.iproov.sdk.p005class.Cnew> f1413new;
    /* access modifiers changed from: private */

    /* renamed from: super  reason: not valid java name */
    public com.iproov.sdk.p005class.Ctry f1414super;

    /* renamed from: this  reason: not valid java name */
    private final b1<Cthis> f1415this;
    /* access modifiers changed from: private */

    /* renamed from: throw  reason: not valid java name */
    public final a1<com.iproov.sdk.p005class.Ctry> f1416throw;

    /* renamed from: try  reason: not valid java name */
    private final b1<String> f1417try;

    /* renamed from: while  reason: not valid java name */
    private final Ccatch f1418while;

    @d(c = "com.iproov.sdk.impl.EncoderImpl$1", f = "EncoderImpl.kt", l = {232}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.else$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1426do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Celse f1427if;

        /* renamed from: com.iproov.sdk.return.else$do$do  reason: invalid class name */
        public static final class Cdo implements e<com.iproov.sdk.p016if.Celse> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Celse f1428do;

            @d(c = "com.iproov.sdk.impl.EncoderImpl$1$invokeSuspend$$inlined$collect$1", f = "EncoderImpl.kt", l = {139}, m = "emit")
            /* renamed from: com.iproov.sdk.return.else$do$do$do  reason: invalid class name */
            public static final class Cdo extends ContinuationImpl {

                /* renamed from: do  reason: not valid java name */
                public /* synthetic */ Object f1429do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cdo f1430for;

                /* renamed from: if  reason: not valid java name */
                public int f1431if;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cdo doVar, c cVar) {
                    super(cVar);
                    this.f1430for = doVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f1429do = obj;
                    this.f1431if |= Integer.MIN_VALUE;
                    return this.f1430for.emit((com.iproov.sdk.p016if.Celse) null, this);
                }
            }

            public Cdo(Celse elseR) {
                this.f1428do = elseR;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(com.iproov.sdk.p016if.Celse r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.iproov.sdk.p026return.Celse.Cdo.Cdo.Cdo
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    com.iproov.sdk.return.else$do$do$do r0 = (com.iproov.sdk.p026return.Celse.Cdo.Cdo.Cdo) r0
                    int r1 = r0.f1431if
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f1431if = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.return.else$do$do$do r0 = new com.iproov.sdk.return.else$do$do$do
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.f1429do
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f1431if
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r7)
                    goto L_0x005f
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    kotlin.k.b(r7)
                    com.iproov.sdk.if.else r6 = (com.iproov.sdk.p016if.Celse) r6
                    boolean r7 = r6 instanceof com.iproov.sdk.p016if.Celse.Cdo
                    if (r7 == 0) goto L_0x005f
                    com.iproov.sdk.return.else r7 = r5.f1428do
                    kotlinx.coroutines.flow.j1 r7 = r7.f1413new
                    java.lang.Object r7 = r7.getValue()
                    com.iproov.sdk.class.new r7 = (com.iproov.sdk.p005class.Cnew) r7
                    if (r7 != 0) goto L_0x0049
                    goto L_0x005f
                L_0x0049:
                    com.iproov.sdk.return.else r2 = r5.f1428do
                    com.iproov.sdk.class.do r2 = r2.f1400break
                    if (r2 != 0) goto L_0x0052
                    goto L_0x005f
                L_0x0052:
                    com.iproov.sdk.return.else r4 = r5.f1428do
                    com.iproov.sdk.if.else$do r6 = (com.iproov.sdk.p016if.Celse.Cdo) r6
                    r0.f1431if = r3
                    java.lang.Object r6 = r4.m1447do((com.iproov.sdk.p016if.Celse.Cdo) r6, (com.iproov.sdk.p005class.Cnew) r7, (com.iproov.sdk.p005class.Cdo) r2, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
                    if (r6 != r1) goto L_0x005f
                    return r1
                L_0x005f:
                    kotlin.Unit r6 = kotlin.Unit.f56620a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Celse.Cdo.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Celse elseR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1427if = elseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f1427if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1426do;
            if (i11 == 0) {
                k.b(obj);
                f1 f1Var = this.f1427if.f1401case;
                Cdo doVar = new Cdo(this.f1427if);
                this.f1426do = 1;
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

    @d(c = "com.iproov.sdk.impl.EncoderImpl", f = "EncoderImpl.kt", l = {167, 168}, m = "outputEncodedFrame")
    /* renamed from: com.iproov.sdk.return.else$else  reason: invalid class name */
    public static final class Celse extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public final /* synthetic */ Celse f1432case;

        /* renamed from: do  reason: not valid java name */
        public Object f1433do;

        /* renamed from: else  reason: not valid java name */
        public int f1434else;

        /* renamed from: for  reason: not valid java name */
        public Object f1435for;

        /* renamed from: if  reason: not valid java name */
        public Object f1436if;

        /* renamed from: new  reason: not valid java name */
        public boolean f1437new;

        /* renamed from: try  reason: not valid java name */
        public /* synthetic */ Object f1438try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Celse(Celse elseR, c<? super Celse> cVar) {
            super(cVar);
            this.f1432case = elseR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1438try = obj;
            this.f1434else |= Integer.MIN_VALUE;
            return this.f1432case.m1452do((byte[]) null, false, (c<? super Unit>) this);
        }
    }

    @d(c = "com.iproov.sdk.impl.EncoderImpl$3", f = "EncoderImpl.kt", l = {232}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.else$for  reason: invalid class name */
    public static final class Cfor extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1439do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Celse f1440if;

        /* renamed from: com.iproov.sdk.return.else$for$do  reason: invalid class name */
        public static final class Cdo implements e<com.iproov.sdk.p005class.Ctry> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Celse f1441do;

            @d(c = "com.iproov.sdk.impl.EncoderImpl$3$invokeSuspend$$inlined$collect$1", f = "EncoderImpl.kt", l = {142, 144}, m = "emit")
            /* renamed from: com.iproov.sdk.return.else$for$do$do  reason: invalid class name */
            public static final class Cdo extends ContinuationImpl {

                /* renamed from: do  reason: not valid java name */
                public /* synthetic */ Object f1442do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cdo f1443for;

                /* renamed from: if  reason: not valid java name */
                public int f1444if;

                /* renamed from: new  reason: not valid java name */
                public Object f1445new;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cdo doVar, c cVar) {
                    super(cVar);
                    this.f1443for = doVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f1442do = obj;
                    this.f1444if |= Integer.MIN_VALUE;
                    return this.f1443for.emit((com.iproov.sdk.p005class.Ctry) null, this);
                }
            }

            public Cdo(Celse elseR) {
                this.f1441do = elseR;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(com.iproov.sdk.p005class.Ctry r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.iproov.sdk.p026return.Celse.Cfor.Cdo.Cdo
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    com.iproov.sdk.return.else$for$do$do r0 = (com.iproov.sdk.p026return.Celse.Cfor.Cdo.Cdo) r0
                    int r1 = r0.f1444if
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f1444if = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.return.else$for$do$do r0 = new com.iproov.sdk.return.else$for$do$do
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.f1442do
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f1444if
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003e
                    if (r2 == r4) goto L_0x0039
                    if (r2 != r3) goto L_0x0031
                    java.lang.Object r8 = r0.f1445new
                    com.iproov.sdk.return.else$for$do r8 = (com.iproov.sdk.p026return.Celse.Cfor.Cdo) r8
                    kotlin.k.b(r9)
                    goto L_0x00ac
                L_0x0031:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0039:
                    kotlin.k.b(r9)
                    goto L_0x00b2
                L_0x003e:
                    kotlin.k.b(r9)
                    com.iproov.sdk.class.try r8 = (com.iproov.sdk.p005class.Ctry) r8
                    boolean r9 = r8.m288do()
                    if (r9 == 0) goto L_0x004f
                    com.iproov.sdk.return.else r9 = r7.f1441do
                    r9.f1414super = r8
                    goto L_0x00b2
                L_0x004f:
                    com.iproov.sdk.return.else r9 = r7.f1441do
                    com.iproov.sdk.class.try r9 = r9.f1414super
                    com.iproov.sdk.return.else r2 = r7.f1441do
                    java.util.Queue r2 = r2.f1407final
                    java.lang.Object r2 = r2.peek()
                    com.iproov.sdk.return.catch r2 = (com.iproov.sdk.p026return.Ccatch) r2
                    r5 = 0
                    if (r2 != 0) goto L_0x0065
                    goto L_0x006d
                L_0x0065:
                    boolean r2 = r2.m1417for()
                    if (r2 != 0) goto L_0x006d
                    r2 = r4
                    goto L_0x006e
                L_0x006d:
                    r2 = r5
                L_0x006e:
                    if (r2 == 0) goto L_0x0087
                    com.iproov.sdk.return.else r2 = r7.f1441do
                    int r6 = r2.f1404const
                    int r6 = r6 + r4
                    r2.f1404const = r6
                    int r2 = r2.f1404const
                    com.iproov.sdk.return.else r6 = r7.f1441do
                    int r6 = r6.f1403class
                    if (r2 != r6) goto L_0x0087
                    r5 = r4
                L_0x0087:
                    if (r9 != 0) goto L_0x0096
                    com.iproov.sdk.return.else r9 = r7.f1441do
                    byte[] r8 = r8.f212do
                    r0.f1444if = r4
                    java.lang.Object r8 = r9.m1452do((byte[]) r8, (boolean) r5, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
                    if (r8 != r1) goto L_0x00b2
                    return r1
                L_0x0096:
                    com.iproov.sdk.return.else r2 = r7.f1441do
                    byte[] r9 = r9.f212do
                    byte[] r8 = r8.f212do
                    byte[] r8 = r2.m1457do((byte[]) r9, (byte[]) r8)
                    r0.f1445new = r7
                    r0.f1444if = r3
                    java.lang.Object r8 = r2.m1452do((byte[]) r8, (boolean) r5, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
                    if (r8 != r1) goto L_0x00ab
                    return r1
                L_0x00ab:
                    r8 = r7
                L_0x00ac:
                    com.iproov.sdk.return.else r8 = r8.f1441do
                    r9 = 0
                    r8.f1414super = r9
                L_0x00b2:
                    kotlin.Unit r8 = kotlin.Unit.f56620a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Celse.Cfor.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(Celse elseR, c<? super Cfor> cVar) {
            super(2, cVar);
            this.f1440if = elseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cfor(this.f1440if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cfor) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1439do;
            if (i11 == 0) {
                k.b(obj);
                a1 a1Var = this.f1440if.f1416throw;
                Cdo doVar = new Cdo(this.f1440if);
                this.f1439do = 1;
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

    @d(c = "com.iproov.sdk.impl.EncoderImpl", f = "EncoderImpl.kt", l = {188, 190}, m = "tryStart")
    /* renamed from: com.iproov.sdk.return.else$goto  reason: invalid class name */
    public static final class Cgoto extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public int f1446case;

        /* renamed from: do  reason: not valid java name */
        public Object f1447do;

        /* renamed from: for  reason: not valid java name */
        public Object f1448for;

        /* renamed from: if  reason: not valid java name */
        public Object f1449if;

        /* renamed from: new  reason: not valid java name */
        public /* synthetic */ Object f1450new;

        /* renamed from: try  reason: not valid java name */
        public final /* synthetic */ Celse f1451try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cgoto(Celse elseR, c<? super Cgoto> cVar) {
            super(cVar);
            this.f1451try = elseR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1450new = obj;
            this.f1446case |= Integer.MIN_VALUE;
            return this.f1451try.m1451do((c<? super Unit>) this);
        }
    }

    @d(c = "com.iproov.sdk.impl.EncoderImpl$2", f = "EncoderImpl.kt", l = {232}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.else$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1452do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Celse f1453if;

        @d(c = "com.iproov.sdk.impl.EncoderImpl$2$1", f = "EncoderImpl.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.else$if$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements q<com.iproov.sdk.p021new.Cnew, com.iproov.sdk.p005class.Cnew, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1454do;

            public Cdo(c<? super Cdo> cVar) {
                super(3, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(com.iproov.sdk.p021new.Cnew newR, com.iproov.sdk.p005class.Cnew newR2, c<? super Unit> cVar) {
                return new Cdo(cVar).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f1454do == 0) {
                    k.b(obj);
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.return.else$if$for  reason: invalid class name */
        public static final class Cfor implements e<Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Celse f1455do;

            public Cfor(Celse elseR) {
                this.f1455do = elseR;
            }

            public Object emit(Unit unit, c<? super Unit> cVar) {
                Unit unit2 = unit;
                Object obj = this.f1455do.m1451do(cVar);
                if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
                    return obj;
                }
                return Unit.f56620a;
            }
        }

        @d(c = "com.iproov.sdk.impl.EncoderImpl$2$2", f = "EncoderImpl.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.else$if$if  reason: invalid class name */
        public static final class Cif extends SuspendLambda implements q<Unit, Size, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1456do;

            public Cif(c<? super Cif> cVar) {
                super(3, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(Unit unit, Size size, c<? super Unit> cVar) {
                return new Cif(cVar).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f1456do == 0) {
                    k.b(obj);
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Celse elseR, c<? super Cif> cVar) {
            super(2, cVar);
            this.f1453if = elseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cif(this.f1453if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1452do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d G = f.G(f.G(f.y(this.f1453if.f1410if), f.y(this.f1453if.f1413new), new Cdo((c<? super Cdo>) null)), f.y(this.f1453if.f1408for), new Cif((c<? super Cif>) null));
                Cfor forR = new Cfor(this.f1453if);
                this.f1452do = 1;
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

    @d(c = "com.iproov.sdk.impl.EncoderImpl$doStop$1", f = "EncoderImpl.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.else$new  reason: invalid class name */
    public static final class Cnew extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1457do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Celse f1458if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(Celse elseR, c<? super Cnew> cVar) {
            super(2, cVar);
            this.f1458if = elseR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cnew(this.f1458if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cnew) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f1457do == 0) {
                k.b(obj);
                com.iproov.sdk.p005class.Cdo doVar = this.f1458if.f1400break;
                if (doVar != null) {
                    doVar.m263do();
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d(c = "com.iproov.sdk.impl.EncoderImpl", f = "EncoderImpl.kt", l = {215, 221}, m = "encodeFrame")
    /* renamed from: com.iproov.sdk.return.else$try  reason: invalid class name */
    public static final class Ctry extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public int f1459case;

        /* renamed from: do  reason: not valid java name */
        public Object f1460do;

        /* renamed from: for  reason: not valid java name */
        public Object f1461for;

        /* renamed from: if  reason: not valid java name */
        public Object f1462if;

        /* renamed from: new  reason: not valid java name */
        public /* synthetic */ Object f1463new;

        /* renamed from: try  reason: not valid java name */
        public final /* synthetic */ Celse f1464try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Ctry(Celse elseR, c<? super Ctry> cVar) {
            super(cVar);
            this.f1464try = elseR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1463new = obj;
            this.f1459case |= Integer.MIN_VALUE;
            return this.f1464try.m1447do((Celse.Cdo) null, (com.iproov.sdk.p005class.Cnew) null, (com.iproov.sdk.p005class.Cdo) null, (c<? super Unit>) this);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Celse(Context context, j1 j1Var, j1 j1Var2, j1 j1Var3, b1 b1Var, f1 f1Var, a1 a1Var, a1 a1Var2, b1 b1Var2, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, j1Var, j1Var2, j1Var3, b1Var, f1Var, a1Var, a1Var2, b1Var2, (i11 & 512) != 0 ? v0.a() : coroutineDispatcher);
    }

    public void doStop() {
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cnew(this, (c<? super Cnew>) null), 3, (Object) null);
    }

    public void handleCoroutineException(CoroutineContext coroutineContext, Throwable th2) {
        this.f1406else.d(new Cgoto.Cdo(new UnexpectedErrorException(this.f1405do, th2)));
        super.handleCoroutineException(coroutineContext, th2);
    }

    /* renamed from: com.iproov.sdk.return.else$case  reason: invalid class name */
    public static final class Ccase implements Cdo.Cif {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Celse f1419do;

        @d(c = "com.iproov.sdk.impl.EncoderImpl$legacyListener$1$onError$1", f = "EncoderImpl.kt", l = {139}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.else$case$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1420do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Exception f1421for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Celse f1422if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Celse elseR, Exception exc, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1422if = elseR;
                this.f1421for = exc;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f1422if, this.f1421for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1420do;
                if (i11 == 0) {
                    k.b(obj);
                    a1 a1Var = this.f1422if.f1406else;
                    Cgoto.Cdo doVar = new Cgoto.Cdo(new UnexpectedErrorException(this.f1422if.f1405do, this.f1421for));
                    this.f1420do = 1;
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

        @d(c = "com.iproov.sdk.impl.EncoderImpl$legacyListener$1$onFrameEncoded$1", f = "EncoderImpl.kt", l = {129}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.else$case$if  reason: invalid class name */
        public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1423do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p005class.Ctry f1424for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Celse f1425if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cif(Celse elseR, com.iproov.sdk.p005class.Ctry tryR, c<? super Cif> cVar) {
                super(2, cVar);
                this.f1425if = elseR;
                this.f1424for = tryR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cif(this.f1425if, this.f1424for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1423do;
                if (i11 == 0) {
                    k.b(obj);
                    a1 a1Var = this.f1425if.f1416throw;
                    com.iproov.sdk.p005class.Ctry tryR = this.f1424for;
                    this.f1423do = 1;
                    if (a1Var.emit(tryR, this) == d11) {
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

        public Ccase(Celse elseR) {
            this.f1419do = elseR;
        }

        /* renamed from: do  reason: not valid java name */
        public void m1467do(com.iproov.sdk.p005class.Ctry tryR) {
            com.iproov.sdk.p017implements.Ccase.m977do(this);
            Celse elseR = this.f1419do;
            n1 unused = i.d(elseR, (CoroutineContext) null, (CoroutineStart) null, new Cif(elseR, tryR, (c<? super Cif>) null), 3, (Object) null);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1466do() {
            com.iproov.sdk.p017implements.Ccase.m977do(this);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1468do(Exception exc) {
            Celse elseR = this.f1419do;
            n1 unused = i.d(elseR, (CoroutineContext) null, (CoroutineStart) null, new Cdo(elseR, exc, (c<? super Cdo>) null), 3, (Object) null);
        }
    }

    /* renamed from: if  reason: not valid java name */
    private final Object m1461if(long j11, c<? super Unit> cVar) {
        this.f1418while.m979do(((double) (System.nanoTime() - j11)) / this.f1411import);
        Object emit = this.f1415this.emit(new Cthis(this.f1418while.m981if(), this.f1418while.m983try(), this.f1418while.m982new(), this.f1418while.m980for()), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Celse(Context context, j1<? extends com.iproov.sdk.p021new.Cnew> j1Var, j1<Size> j1Var2, j1<? extends com.iproov.sdk.p005class.Cnew> j1Var3, b1<String> b1Var, f1<? extends com.iproov.sdk.p016if.Celse> f1Var, a1<com.iproov.sdk.p016if.Cgoto> a1Var, a1<Cbreak> a1Var2, b1<Cthis> b1Var2, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1405do = context;
        this.f1410if = j1Var;
        this.f1408for = j1Var2;
        this.f1413new = j1Var3;
        this.f1417try = b1Var;
        this.f1401case = f1Var;
        this.f1406else = a1Var;
        this.f1409goto = a1Var2;
        this.f1415this = b1Var2;
        this.f1407final = new LinkedBlockingQueue();
        this.f1416throw = g1.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.f1418while = new Ccatch(100);
        this.f1411import = 1.0E9d;
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
        n1 unused2 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, (c<? super Cif>) null), 3, (Object) null);
        n1 unused3 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cfor(this, (c<? super Cfor>) null), 3, (Object) null);
        this.f1412native = new Ccase(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final byte[] m1457do(byte[] bArr, byte[] bArr2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.write(bArr2);
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1452do(byte[] r11, boolean r12, kotlin.coroutines.c<? super kotlin.Unit> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.iproov.sdk.p026return.Celse.Celse
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.iproov.sdk.return.else$else r0 = (com.iproov.sdk.p026return.Celse.Celse) r0
            int r1 = r0.f1434else
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1434else = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.else$else r0 = new com.iproov.sdk.return.else$else
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f1438try
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1434else
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.k.b(r13)
            goto L_0x0095
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0035:
            boolean r12 = r0.f1437new
            java.lang.Object r11 = r0.f1435for
            com.iproov.sdk.return.catch r11 = (com.iproov.sdk.p026return.Ccatch) r11
            java.lang.Object r2 = r0.f1436if
            byte[] r2 = (byte[]) r2
            java.lang.Object r4 = r0.f1433do
            com.iproov.sdk.return.else r4 = (com.iproov.sdk.p026return.Celse) r4
            kotlin.k.b(r13)
            r6 = r12
            r5 = r2
            goto L_0x0070
        L_0x0049:
            kotlin.k.b(r13)
            java.util.Queue<com.iproov.sdk.return.catch> r13 = r10.f1407final
            java.lang.Object r13 = r13.poll()
            com.iproov.sdk.return.catch r13 = (com.iproov.sdk.p026return.Ccatch) r13
            if (r13 != 0) goto L_0x0057
            goto L_0x0095
        L_0x0057:
            long r5 = r13.m1416do()
            r0.f1433do = r10
            r0.f1436if = r11
            r0.f1435for = r13
            r0.f1437new = r12
            r0.f1434else = r4
            java.lang.Object r2 = r10.m1461if(r5, r0)
            if (r2 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r4 = r10
            r5 = r11
            r6 = r12
            r11 = r13
        L_0x0070:
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.break> r12 = r4.f1409goto
            com.iproov.sdk.if.break r13 = new com.iproov.sdk.if.break
            com.iproov.sdk.if.try r2 = new com.iproov.sdk.if.try
            long r7 = r11.m1418if()
            boolean r9 = r11.m1417for()
            r4 = r2
            r4.<init>(r5, r6, r7, r9)
            r13.<init>(r2)
            r11 = 0
            r0.f1433do = r11
            r0.f1436if = r11
            r0.f1435for = r11
            r0.f1434else = r3
            java.lang.Object r11 = r12.emit(r13, r0)
            if (r11 != r1) goto L_0x0095
            return r1
        L_0x0095:
            kotlin.Unit r11 = kotlin.Unit.f56620a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Celse.m1452do(byte[], boolean, kotlin.coroutines.c):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1451do(kotlin.coroutines.c<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.iproov.sdk.p026return.Celse.Cgoto
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.iproov.sdk.return.else$goto r0 = (com.iproov.sdk.p026return.Celse.Cgoto) r0
            int r1 = r0.f1446case
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1446case = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.else$goto r0 = new com.iproov.sdk.return.else$goto
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f1450new
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1446case
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.k.b(r8)
            goto L_0x009f
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0035:
            java.lang.Object r2 = r0.f1448for
            com.iproov.sdk.return.else r2 = (com.iproov.sdk.p026return.Celse) r2
            java.lang.Object r4 = r0.f1449if
            com.iproov.sdk.class.do r4 = (com.iproov.sdk.p005class.Cdo) r4
            java.lang.Object r5 = r0.f1447do
            com.iproov.sdk.return.else r5 = (com.iproov.sdk.p026return.Celse) r5
            kotlin.k.b(r8)
            goto L_0x0087
        L_0x0045:
            kotlin.k.b(r8)
            kotlinx.coroutines.flow.j1<android.util.Size> r8 = r7.f1408for
            java.lang.Object r8 = r8.getValue()
            android.util.Size r8 = (android.util.Size) r8
            if (r8 != 0) goto L_0x0053
            goto L_0x009f
        L_0x0053:
            kotlinx.coroutines.flow.j1<com.iproov.sdk.class.new> r2 = r7.f1413new
            java.lang.Object r2 = r2.getValue()
            com.iproov.sdk.class.new r2 = (com.iproov.sdk.p005class.Cnew) r2
            if (r2 != 0) goto L_0x005e
            goto L_0x009f
        L_0x005e:
            com.iproov.sdk.p017implements.Ccase.m977do(r7)
            com.iproov.sdk.class.do r5 = new com.iproov.sdk.class.do
            com.iproov.sdk.return.else$case r6 = r7.f1412native
            r5.<init>(r8, r6, r2)
            r5.m262case()
            kotlinx.coroutines.flow.b1<java.lang.String> r8 = r7.f1417try
            com.iproov.sdk.class.do$do r2 = r5.m265if()
            java.lang.String r2 = r2.toString()
            r0.f1447do = r7
            r0.f1449if = r5
            r0.f1448for = r7
            r0.f1446case = r4
            java.lang.Object r8 = r8.emit(r2, r0)
            if (r8 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r2 = r7
            r4 = r5
            r5 = r2
        L_0x0087:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            r2.f1400break = r4
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.goto> r8 = r5.f1406else
            com.iproov.sdk.if.goto$for r2 = com.iproov.sdk.p016if.Cgoto.Cfor.f674do
            r4 = 0
            r0.f1447do = r4
            r0.f1449if = r4
            r0.f1448for = r4
            r0.f1446case = r3
            java.lang.Object r8 = r8.emit(r2, r0)
            if (r8 != r1) goto L_0x009f
            return r1
        L_0x009f:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Celse.m1451do(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: com.iproov.sdk.class.do} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1447do(com.iproov.sdk.p016if.Celse.Cdo r12, com.iproov.sdk.p005class.Cnew r13, com.iproov.sdk.p005class.Cdo r14, kotlin.coroutines.c<? super kotlin.Unit> r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.iproov.sdk.p026return.Celse.Ctry
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.iproov.sdk.return.else$try r0 = (com.iproov.sdk.p026return.Celse.Ctry) r0
            int r1 = r0.f1459case
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1459case = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.else$try r0 = new com.iproov.sdk.return.else$try
            r0.<init>(r11, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f1463new
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1459case
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.k.b(r15)
            goto L_0x00ca
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0035:
            java.lang.Object r12 = r0.f1461for
            r14 = r12
            com.iproov.sdk.class.do r14 = (com.iproov.sdk.p005class.Cdo) r14
            java.lang.Object r12 = r0.f1462if
            com.iproov.sdk.if.else$do r12 = (com.iproov.sdk.p016if.Celse.Cdo) r12
            java.lang.Object r13 = r0.f1460do
            com.iproov.sdk.return.else r13 = (com.iproov.sdk.p026return.Celse) r13
            kotlin.k.b(r15)
            goto L_0x00a5
        L_0x0046:
            kotlin.k.b(r15)
            java.util.Queue<com.iproov.sdk.return.catch> r15 = r11.f1407final
            com.iproov.sdk.return.catch r2 = new com.iproov.sdk.return.catch
            long r6 = java.lang.System.nanoTime()
            com.iproov.sdk.new.for r5 = r12.m763do()
            long r8 = r5.m1194do()
            boolean r10 = r12.m764for()
            r5 = r2
            r5.<init>(r6, r8, r10)
            r15.offer(r2)
            boolean r15 = r14.m266new()
            if (r15 == 0) goto L_0x00a4
            boolean r15 = r12.m764for()     // Catch:{ if -> 0x0086 }
            if (r15 != 0) goto L_0x0075
            int r15 = r11.f1402catch     // Catch:{ if -> 0x0086 }
            int r15 = r15 + r4
            r11.f1402catch = r15     // Catch:{ if -> 0x0086 }
        L_0x0075:
            com.iproov.sdk.p017implements.Ccase.m977do(r11)     // Catch:{ if -> 0x0086 }
            com.iproov.sdk.new.for r15 = r12.m763do()     // Catch:{ if -> 0x0086 }
            int r13 = r13.f205new     // Catch:{ if -> 0x0086 }
            byte[] r13 = r15.m1195do(r13)     // Catch:{ if -> 0x0086 }
            r14.m264do((byte[]) r13)     // Catch:{ if -> 0x0086 }
            goto L_0x00a4
        L_0x0086:
            r13 = move-exception
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.goto> r15 = r11.f1406else
            com.iproov.sdk.if.goto$do r2 = new com.iproov.sdk.if.goto$do
            com.iproov.sdk.core.exception.UnexpectedErrorException r5 = new com.iproov.sdk.core.exception.UnexpectedErrorException
            android.content.Context r6 = r11.f1405do
            r5.<init>((android.content.Context) r6, (java.lang.Exception) r13)
            r2.<init>(r5)
            r0.f1460do = r11
            r0.f1462if = r12
            r0.f1461for = r14
            r0.f1459case = r4
            java.lang.Object r13 = r15.emit(r2, r0)
            if (r13 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            r13 = r11
        L_0x00a5:
            int r15 = r12.m765if()
            r13.f1403class = r15
            int r15 = r13.f1402catch
            int r12 = r12.m765if()
            if (r15 != r12) goto L_0x00cd
            r14.m263do()
            kotlinx.coroutines.flow.a1<com.iproov.sdk.if.goto> r12 = r13.f1406else
            com.iproov.sdk.if.goto$if r13 = com.iproov.sdk.p016if.Cgoto.Cif.f675do
            r14 = 0
            r0.f1460do = r14
            r0.f1462if = r14
            r0.f1461for = r14
            r0.f1459case = r3
            java.lang.Object r12 = r12.emit(r13, r0)
            if (r12 != r1) goto L_0x00ca
            return r1
        L_0x00ca:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x00cd:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Celse.m1447do(com.iproov.sdk.if.else$do, com.iproov.sdk.class.new, com.iproov.sdk.class.do, kotlin.coroutines.c):java.lang.Object");
    }
}
