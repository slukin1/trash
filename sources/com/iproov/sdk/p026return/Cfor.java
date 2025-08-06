package com.iproov.sdk.p026return;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import com.iproov.sdk.cameray.Cbreak;
import com.iproov.sdk.cameray.Cclass;
import com.iproov.sdk.cameray.Cconst;
import com.iproov.sdk.cameray.Ctry;
import com.iproov.sdk.core.exception.CameraException;
import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p016if.Cfor;
import com.iproov.sdk.p016if.Cstatic;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.p017implements.Cthis;
import com.iproov.sdk.p021new.Cnew;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import java.util.Arrays;
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
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.for  reason: invalid class name and invalid package */
public final class Cfor extends BaseCoroutineScope implements com.iproov.sdk.p016if.Cdo {
    /* access modifiers changed from: private */

    /* renamed from: break  reason: not valid java name */
    public final a1<Cstatic> f1552break;
    /* access modifiers changed from: private */

    /* renamed from: case  reason: not valid java name */
    public final a1<com.iproov.sdk.p021new.Cfor> f1553case;
    /* access modifiers changed from: private */

    /* renamed from: catch  reason: not valid java name */
    public final Ctry f1554catch;
    /* access modifiers changed from: private */

    /* renamed from: class  reason: not valid java name */
    public final com.iproov.sdk.p020native.Cif f1555class;
    /* access modifiers changed from: private */

    /* renamed from: const  reason: not valid java name */
    public SurfaceTexture f1556const;
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final Context f1557do;
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public final b1<Cthis> f1558else;

    /* renamed from: final  reason: not valid java name */
    private final Cfor f1559final;
    /* access modifiers changed from: private */

    /* renamed from: for  reason: not valid java name */
    public final b1<Size> f1560for;

    /* renamed from: goto  reason: not valid java name */
    private final b1<Cconst> f1561goto;

    /* renamed from: if  reason: not valid java name */
    private final b1<Cnew> f1562if;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public final f1<com.iproov.sdk.p016if.Cif> f1563new;
    /* access modifiers changed from: private */

    /* renamed from: this  reason: not valid java name */
    public final f1<SurfaceTexture> f1564this;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public final a1<com.iproov.sdk.p016if.Cfor> f1565try;

    @d(c = "com.iproov.sdk.impl.CameraImpl$1", f = "CameraImpl.kt", l = {182}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.for$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1566do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cfor f1567for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f1568if;

        /* renamed from: com.iproov.sdk.return.for$do$do  reason: invalid class name */
        public static final class Cdo implements e<SurfaceTexture> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ h0 f1569do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cfor f1570if;

            public Cdo(h0 h0Var, Cfor forR) {
                this.f1569do = h0Var;
                this.f1570if = forR;
            }

            public Object emit(SurfaceTexture surfaceTexture, c<? super Unit> cVar) {
                SurfaceTexture surfaceTexture2 = surfaceTexture;
                Ccase.m977do(this.f1569do);
                if (surfaceTexture2 != null) {
                    Ccase.m977do(this.f1569do);
                    this.f1570if.f1556const = surfaceTexture2;
                    this.f1570if.m1551do(surfaceTexture2);
                } else {
                    this.f1570if.stop();
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cfor forR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1567for = forR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cdo doVar = new Cdo(this.f1567for, cVar);
            doVar.f1568if = obj;
            return doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1566do;
            if (i11 == 0) {
                k.b(obj);
                f1 f1Var = this.f1567for.f1564this;
                Cdo doVar = new Cdo((h0) this.f1568if, this.f1567for);
                this.f1566do = 1;
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

    /* renamed from: com.iproov.sdk.return.for$for  reason: invalid class name */
    public static final class Cfor implements Ctry.Cdo {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cfor f1571do;

        @d(c = "com.iproov.sdk.impl.CameraImpl$legacyListener$1$onCameraReady$1", f = "CameraImpl.kt", l = {62, 63}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.for$for$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1572do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Cfor f1573for;

            /* renamed from: if  reason: not valid java name */
            private /* synthetic */ Object f1574if;

            /* renamed from: new  reason: not valid java name */
            public final /* synthetic */ Size f1575new;

            /* renamed from: try  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p021new.Cnew f1576try;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cfor forR, Size size, com.iproov.sdk.p021new.Cnew newR, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1573for = forR;
                this.f1575new = size;
                this.f1576try = newR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cdo doVar = new Cdo(this.f1573for, this.f1575new, this.f1576try, cVar);
                doVar.f1574if = obj;
                return doVar;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1572do;
                if (i11 == 0) {
                    k.b(obj);
                    Ccase.m977do((h0) this.f1574if);
                    b1 b1Var = this.f1573for.f1560for;
                    Size size = this.f1575new;
                    this.f1572do = 1;
                    if (b1Var.emit(size, this) == d11) {
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
                a1 a1Var = this.f1573for.f1552break;
                Cstatic.Cfor forR = new Cstatic.Cfor(this.f1576try.m1205for().floatValue());
                this.f1572do = 2;
                if (a1Var.emit(forR, this) == d11) {
                    return d11;
                }
                return Unit.f56620a;
            }
        }

        @d(c = "com.iproov.sdk.impl.CameraImpl$legacyListener$1$onExposureLockChanged$1", f = "CameraImpl.kt", l = {80}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.for$for$for  reason: invalid class name */
        public static final class Cfor extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1577do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ boolean f1578for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cfor f1579if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cfor(Cfor forR, boolean z11, c<? super Cfor> cVar) {
                super(2, cVar);
                this.f1579if = forR;
                this.f1578for = z11;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cfor(this.f1579if, this.f1578for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cfor) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1577do;
                if (i11 == 0) {
                    k.b(obj);
                    a1 a1Var = this.f1579if.f1552break;
                    Cstatic.Cdo doVar = new Cstatic.Cdo(this.f1578for);
                    this.f1577do = 1;
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

        @d(c = "com.iproov.sdk.impl.CameraImpl$legacyListener$1$onError$1", f = "CameraImpl.kt", l = {69}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.for$for$if  reason: invalid class name */
        public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1580do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ Exception f1581for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cfor f1582if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cif(Cfor forR, Exception exc, c<? super Cif> cVar) {
                super(2, cVar);
                this.f1582if = forR;
                this.f1581for = exc;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cif(this.f1582if, this.f1581for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1580do;
                if (i11 == 0) {
                    k.b(obj);
                    a1 a1Var = this.f1582if.f1565try;
                    Cfor.Cdo doVar = new Cfor.Cdo(new CameraException(this.f1582if.f1557do, this.f1581for));
                    this.f1580do = 1;
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

        @d(c = "com.iproov.sdk.impl.CameraImpl$legacyListener$1$onFrame$1", f = "CameraImpl.kt", l = {96, 98, 101}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.for$for$new  reason: invalid class name */
        public static final class Cnew extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: case  reason: not valid java name */
            public final /* synthetic */ Cfor f1583case;

            /* renamed from: do  reason: not valid java name */
            public Object f1584do;

            /* renamed from: for  reason: not valid java name */
            public int f1585for;

            /* renamed from: if  reason: not valid java name */
            public Object f1586if;

            /* renamed from: new  reason: not valid java name */
            private /* synthetic */ Object f1587new;

            /* renamed from: try  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p021new.Cfor f1588try;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cnew(com.iproov.sdk.p021new.Cfor forR, Cfor forR2, c<? super Cnew> cVar) {
                super(2, cVar);
                this.f1588try = forR;
                this.f1583case = forR2;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                Cnew newR = new Cnew(this.f1588try, this.f1583case, cVar);
                newR.f1587new = obj;
                return newR;
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cnew) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            /* JADX WARNING: Removed duplicated region for block: B:22:0x0088  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r9.f1585for
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    r5 = 0
                    if (r1 == 0) goto L_0x0037
                    if (r1 == r4) goto L_0x0027
                    if (r1 == r3) goto L_0x001f
                    if (r1 != r2) goto L_0x0017
                    kotlin.k.b(r10)
                    goto L_0x00a9
                L_0x0017:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L_0x001f:
                    java.lang.Object r1 = r9.f1587new
                    kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                    kotlin.k.b(r10)
                    goto L_0x0084
                L_0x0027:
                    java.lang.Object r1 = r9.f1586if
                    com.iproov.sdk.new.for r1 = (com.iproov.sdk.p021new.Cfor) r1
                    java.lang.Object r4 = r9.f1584do
                    com.iproov.sdk.return.for r4 = (com.iproov.sdk.p026return.Cfor) r4
                    java.lang.Object r6 = r9.f1587new
                    kotlinx.coroutines.h0 r6 = (kotlinx.coroutines.h0) r6
                    kotlin.k.b(r10)
                    goto L_0x0071
                L_0x0037:
                    kotlin.k.b(r10)
                    java.lang.Object r10 = r9.f1587new
                    r6 = r10
                    kotlinx.coroutines.h0 r6 = (kotlinx.coroutines.h0) r6
                    com.iproov.sdk.new.for r1 = r9.f1588try
                    if (r1 != 0) goto L_0x0045
                    r10 = r5
                    goto L_0x0086
                L_0x0045:
                    com.iproov.sdk.return.for r10 = r9.f1583case
                    com.iproov.sdk.native.if r7 = r10.f1555class
                    r7.m1151goto()
                    com.iproov.sdk.native.if r7 = r10.f1555class
                    r7.m1147case()
                    kotlinx.coroutines.flow.b1 r7 = r10.f1558else
                    com.iproov.sdk.native.if r8 = r10.f1555class
                    com.iproov.sdk.implements.this r8 = r8.m1152if()
                    r9.f1587new = r6
                    r9.f1584do = r10
                    r9.f1586if = r1
                    r9.f1585for = r4
                    java.lang.Object r4 = r7.emit(r8, r9)
                    if (r4 != r0) goto L_0x0070
                    return r0
                L_0x0070:
                    r4 = r10
                L_0x0071:
                    kotlinx.coroutines.flow.a1 r10 = r4.f1553case
                    r9.f1587new = r6
                    r9.f1584do = r5
                    r9.f1586if = r5
                    r9.f1585for = r3
                    java.lang.Object r10 = r10.emit(r1, r9)
                    if (r10 != r0) goto L_0x0084
                    return r0
                L_0x0084:
                    kotlin.Unit r10 = kotlin.Unit.f56620a
                L_0x0086:
                    if (r10 != 0) goto L_0x00a9
                    com.iproov.sdk.return.for r10 = r9.f1583case
                    kotlinx.coroutines.flow.a1 r1 = r10.f1565try
                    com.iproov.sdk.if.for$do r3 = new com.iproov.sdk.if.for$do
                    com.iproov.sdk.core.exception.CameraException r4 = new com.iproov.sdk.core.exception.CameraException
                    android.content.Context r10 = r10.f1557do
                    java.lang.String r6 = "Frame not available, perhaps corrupt"
                    r4.<init>((android.content.Context) r10, (java.lang.String) r6)
                    r3.<init>(r4)
                    r9.f1587new = r5
                    r9.f1585for = r2
                    java.lang.Object r10 = r1.emit(r3, r9)
                    if (r10 != r0) goto L_0x00a9
                    return r0
                L_0x00a9:
                    kotlin.Unit r10 = kotlin.Unit.f56620a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cfor.Cfor.Cnew.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @d(c = "com.iproov.sdk.impl.CameraImpl$legacyListener$1$onNewExifData$1", f = "CameraImpl.kt", l = {86}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.for$for$try  reason: invalid class name */
        public static final class Ctry extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1589do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ com.iproov.sdk.p021new.Cthis f1590for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cfor f1591if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Ctry(Cfor forR, com.iproov.sdk.p021new.Cthis thisR, c<? super Ctry> cVar) {
                super(2, cVar);
                this.f1591if = forR;
                this.f1590for = thisR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Ctry(this.f1591if, this.f1590for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Ctry) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1589do;
                if (i11 == 0) {
                    k.b(obj);
                    a1 a1Var = this.f1591if.f1552break;
                    Cstatic.Cif ifVar = new Cstatic.Cif(this.f1590for);
                    this.f1589do = 1;
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

        public Cfor(Cfor forR) {
            this.f1571do = forR;
        }

        /* renamed from: do  reason: not valid java name */
        public void m1565do(com.iproov.sdk.p021new.Cnew newR, Size size) {
            Cfor forR = this.f1571do;
            n1 unused = i.d(forR, (CoroutineContext) null, (CoroutineStart) null, new Cdo(forR, size, newR, (c<? super Cdo>) null), 3, (Object) null);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1567do(Exception exc) {
            Cfor forR = this.f1571do;
            n1 unused = i.d(forR, (CoroutineContext) null, (CoroutineStart) null, new Cif(forR, exc, (c<? super Cif>) null), 3, (Object) null);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1563do(Ctry.Cif ifVar, Exception exc) {
            IPLog.w(Ccase.m977do(this), ifVar.toString());
            if (exc != null) {
                exc.printStackTrace();
            }
        }

        /* renamed from: do  reason: not valid java name */
        public void m1568do(boolean z11) {
            Cfor forR = this.f1571do;
            n1 unused = i.d(forR, (CoroutineContext) null, (CoroutineStart) null, new Cfor(forR, z11, (c<? super Cfor>) null), 3, (Object) null);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1566do(com.iproov.sdk.p021new.Cthis thisR) {
            Cfor forR = this.f1571do;
            n1 unused = i.d(forR, (CoroutineContext) null, (CoroutineStart) null, new Ctry(forR, thisR, (c<? super Ctry>) null), 3, (Object) null);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1564do(com.iproov.sdk.p021new.Cfor forR) {
            Cfor forR2 = this.f1571do;
            n1 unused = i.d(forR2, (CoroutineContext) null, (CoroutineStart) null, new Cnew(forR, forR2, (c<? super Cnew>) null), 3, (Object) null);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1562do() {
            this.f1571do.f1555class.m1149else();
        }
    }

    @d(c = "com.iproov.sdk.impl.CameraImpl$2", f = "CameraImpl.kt", l = {182}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.for$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1592do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cfor f1593if;

        /* renamed from: com.iproov.sdk.return.for$if$do  reason: invalid class name */
        public static final class Cdo implements e<com.iproov.sdk.p016if.Cif> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cfor f1594do;

            @d(c = "com.iproov.sdk.impl.CameraImpl$2$invokeSuspend$$inlined$collect$1", f = "CameraImpl.kt", l = {140}, m = "emit")
            /* renamed from: com.iproov.sdk.return.for$if$do$do  reason: invalid class name */
            public static final class Cdo extends ContinuationImpl {

                /* renamed from: do  reason: not valid java name */
                public /* synthetic */ Object f1595do;

                /* renamed from: for  reason: not valid java name */
                public final /* synthetic */ Cdo f1596for;

                /* renamed from: if  reason: not valid java name */
                public int f1597if;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Cdo(Cdo doVar, c cVar) {
                    super(cVar);
                    this.f1596for = doVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f1595do = obj;
                    this.f1597if |= Integer.MIN_VALUE;
                    return this.f1596for.emit((com.iproov.sdk.p016if.Cif) null, this);
                }
            }

            public Cdo(Cfor forR) {
                this.f1594do = forR;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(com.iproov.sdk.p016if.Cif r7, kotlin.coroutines.c<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.iproov.sdk.p026return.Cfor.Cif.Cdo.Cdo
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    com.iproov.sdk.return.for$if$do$do r0 = (com.iproov.sdk.p026return.Cfor.Cif.Cdo.Cdo) r0
                    int r1 = r0.f1597if
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f1597if = r1
                    goto L_0x0018
                L_0x0013:
                    com.iproov.sdk.return.for$if$do$do r0 = new com.iproov.sdk.return.for$if$do$do
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.f1595do
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r2 = r0.f1597if
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.k.b(r8)
                    goto L_0x008f
                L_0x0029:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0031:
                    kotlin.k.b(r8)
                    com.iproov.sdk.if.if r7 = (com.iproov.sdk.p016if.Cif) r7
                    boolean r8 = r7 instanceof com.iproov.sdk.p016if.Cif.Cfor
                    if (r8 == 0) goto L_0x004a
                    com.iproov.sdk.return.for r8 = r6.f1594do
                    com.iproov.sdk.cameray.try r8 = r8.f1554catch
                    com.iproov.sdk.if.if$for r7 = (com.iproov.sdk.p016if.Cif.Cfor) r7
                    boolean r7 = r7.m772do()
                    r8.m212do((boolean) r7)
                    goto L_0x008f
                L_0x004a:
                    boolean r8 = r7 instanceof com.iproov.sdk.p016if.Cif.Cdo
                    if (r8 == 0) goto L_0x0058
                    com.iproov.sdk.return.for r7 = r6.f1594do
                    com.iproov.sdk.cameray.try r7 = r7.f1554catch
                    r7.m208catch()
                    goto L_0x008f
                L_0x0058:
                    boolean r8 = r7 instanceof com.iproov.sdk.p016if.Cif.Cnew
                    if (r8 == 0) goto L_0x0066
                    com.iproov.sdk.return.for r7 = r6.f1594do
                    com.iproov.sdk.cameray.try r7 = r7.f1554catch
                    r7.m207case()
                    goto L_0x008f
                L_0x0066:
                    boolean r8 = r7 instanceof com.iproov.sdk.p016if.Cif.Cif
                    if (r8 == 0) goto L_0x008f
                    com.iproov.sdk.return.for r8 = r6.f1594do
                    kotlinx.coroutines.flow.a1 r8 = r8.f1565try
                    com.iproov.sdk.if.for$do r2 = new com.iproov.sdk.if.for$do
                    com.iproov.sdk.core.exception.CameraException r4 = new com.iproov.sdk.core.exception.CameraException
                    com.iproov.sdk.return.for r5 = r6.f1594do
                    android.content.Context r5 = r5.f1557do
                    com.iproov.sdk.if.if$if r7 = (com.iproov.sdk.p016if.Cif.Cif) r7
                    java.lang.Throwable r7 = r7.m773do()
                    r4.<init>((android.content.Context) r5, (java.lang.Throwable) r7)
                    r2.<init>(r4)
                    r0.f1597if = r3
                    java.lang.Object r7 = r8.emit(r2, r0)
                    if (r7 != r1) goto L_0x008f
                    return r1
                L_0x008f:
                    kotlin.Unit r7 = kotlin.Unit.f56620a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cfor.Cif.Cdo.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cfor forR, c<? super Cif> cVar) {
            super(2, cVar);
            this.f1593if = forR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cif(this.f1593if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1592do;
            if (i11 == 0) {
                k.b(obj);
                f1 f1Var = this.f1593if.f1563new;
                Cdo doVar = new Cdo(this.f1593if);
                this.f1592do = 1;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cfor(Context context, b1 b1Var, b1 b1Var2, f1 f1Var, a1 a1Var, a1 a1Var2, b1 b1Var3, b1 b1Var4, f1 f1Var2, a1 a1Var3, Cextends.Cif ifVar, com.iproov.sdk.p025public.Cif ifVar2, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, b1Var, b1Var2, f1Var, a1Var, a1Var2, b1Var3, b1Var4, f1Var2, a1Var3, ifVar, ifVar2, (i11 & 4096) != 0 ? v0.a() : coroutineDispatcher);
    }

    /* access modifiers changed from: private */
    /* renamed from: catch  reason: not valid java name */
    public static final void m1549catch(Cfor forR) {
        try {
            SurfaceTexture surfaceTexture = forR.f1556const;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            forR.f1556const = null;
        } catch (Exception unused) {
        }
    }

    public void doStop() {
        this.f1554catch.m211do((Runnable) new a(this));
    }

    public void handleCoroutineException(CoroutineContext coroutineContext, Throwable th2) {
        this.f1565try.d(new Cfor.Cdo(new CameraException(this.f1557do, th2)));
        super.handleCoroutineException(coroutineContext, th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Cfor(Context context, b1<Cnew> b1Var, b1<Size> b1Var2, f1<? extends com.iproov.sdk.p016if.Cif> f1Var, a1<com.iproov.sdk.p016if.Cfor> a1Var, a1<com.iproov.sdk.p021new.Cfor> a1Var2, b1<Cthis> b1Var3, b1<Cconst> b1Var4, f1<? extends SurfaceTexture> f1Var2, a1<Cstatic> a1Var3, Cextends.Cif ifVar, com.iproov.sdk.p025public.Cif ifVar2, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        b1<Cconst> b1Var5 = b1Var4;
        com.iproov.sdk.p025public.Cif ifVar3 = ifVar2;
        this.f1557do = context;
        this.f1562if = b1Var;
        this.f1560for = b1Var2;
        this.f1563new = f1Var;
        this.f1565try = a1Var;
        this.f1553case = a1Var2;
        this.f1558else = b1Var3;
        this.f1561goto = b1Var5;
        this.f1564this = f1Var2;
        this.f1552break = a1Var3;
        this.f1555class = new com.iproov.sdk.p020native.Cif();
        Cfor forR = new Cfor(this);
        this.f1559final = forR;
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
        Cbreak[] breakArr = ifVar.m1515do() == Cextends.Cdo.FRONT ? new Cbreak[]{Cbreak.FRONT} : new Cbreak[]{Cbreak.EXTERNAL, Cbreak.BACK};
        Ctry tryR = new Cclass(ifVar3, forR, new com.iproov.sdk.p035try.Ctry(ifVar3), (Cbreak[]) Arrays.copyOf(breakArr, breakArr.length)).m96do(context, com.iproov.sdk.p030switch.Cdo.m1884if(context));
        this.f1554catch = tryR;
        b1Var5.d(tryR.m209do());
        b1Var.d(tryR.m213if());
        n1 unused2 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, (c<? super Cif>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public final void m1551do(SurfaceTexture surfaceTexture) {
        this.f1554catch.m210do(surfaceTexture);
    }
}
