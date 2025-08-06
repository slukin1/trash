package com.iproov.sdk.p026return;

import android.content.Context;
import android.graphics.Bitmap;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.p016if.Cthis;
import com.iproov.sdk.p026return.Cextends;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
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
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.return.goto  reason: invalid class name and invalid package */
public final class Cgoto extends BaseCoroutineScope implements Cthis {

    /* renamed from: do  reason: not valid java name */
    private final b1<com.iproov.sdk.p017implements.Cthis> f1598do;

    /* renamed from: for  reason: not valid java name */
    private final a f1599for;

    /* renamed from: if  reason: not valid java name */
    private final com.iproov.sdk.p020native.Cif f1600if;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public final FaceDetector f1601new;

    @d(c = "com.iproov.sdk.impl.FaceDetectorImpl$1", f = "FaceDetectorImpl.kt", l = {40}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.goto$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1602do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cgoto f1603for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ b1<String> f1604if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(b1<String> b1Var, Cgoto gotoR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1604if = b1Var;
            this.f1603for = gotoR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f1604if, this.f1603for, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1602do;
            if (i11 == 0) {
                k.b(obj);
                b1<String> b1Var = this.f1604if;
                String name = this.f1603for.f1601new.getName();
                this.f1602do = 1;
                if (b1Var.emit(name, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.FaceDetectorImpl", f = "FaceDetectorImpl.kt", l = {77, 59}, m = "detectFace")
    /* renamed from: com.iproov.sdk.return.goto$if  reason: invalid class name */
    public static final class Cif extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public int f1605case;

        /* renamed from: do  reason: not valid java name */
        public Object f1606do;

        /* renamed from: for  reason: not valid java name */
        public Object f1607for;

        /* renamed from: if  reason: not valid java name */
        public Object f1608if;

        /* renamed from: new  reason: not valid java name */
        public /* synthetic */ Object f1609new;

        /* renamed from: try  reason: not valid java name */
        public final /* synthetic */ Cgoto f1610try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cgoto gotoR, c<? super Cif> cVar) {
            super(cVar);
            this.f1610try = gotoR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1609new = obj;
            this.f1605case |= Integer.MIN_VALUE;
            return this.f1610try.m1577do((Bitmap) null, this);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Cgoto(Context context, Cextends.Cif ifVar, b1 b1Var, b1 b1Var2, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, ifVar, b1Var, b1Var2, (i11 & 16) != 0 ? v0.a() : coroutineDispatcher);
    }

    public void setOmega(double d11) {
        this.f1601new.setOmega(d11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: do  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m1577do(android.graphics.Bitmap r7, kotlin.coroutines.c<? super com.iproov.sdk.face.model.FaceFeature> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.iproov.sdk.p026return.Cgoto.Cif
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.iproov.sdk.return.goto$if r0 = (com.iproov.sdk.p026return.Cgoto.Cif) r0
            int r1 = r0.f1605case
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f1605case = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.return.goto$if r0 = new com.iproov.sdk.return.goto$if
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f1609new
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f1605case
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r7 = r0.f1608if
            com.iproov.sdk.face.model.FaceFeature r7 = (com.iproov.sdk.face.model.FaceFeature) r7
            java.lang.Object r0 = r0.f1606do
            kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) r0
            kotlin.k.b(r8)     // Catch:{ all -> 0x0035 }
            goto L_0x0081
        L_0x0035:
            r7 = move-exception
            goto L_0x0087
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            java.lang.Object r7 = r0.f1607for
            kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r7
            java.lang.Object r2 = r0.f1608if
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            java.lang.Object r4 = r0.f1606do
            com.iproov.sdk.return.goto r4 = (com.iproov.sdk.p026return.Cgoto) r4
            kotlin.k.b(r8)
            r8 = r7
            r7 = r2
            goto L_0x0066
        L_0x0051:
            kotlin.k.b(r8)
            kotlinx.coroutines.sync.a r8 = r6.f1599for
            r0.f1606do = r6
            r0.f1608if = r7
            r0.f1607for = r8
            r0.f1605case = r4
            java.lang.Object r2 = r8.d(r5, r0)
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r4 = r6
        L_0x0066:
            com.iproov.sdk.native.if r2 = r4.f1600if     // Catch:{ all -> 0x0085 }
            r2.m1151goto()     // Catch:{ all -> 0x0085 }
            com.iproov.sdk.face.FaceDetector r2 = r4.f1601new     // Catch:{ all -> 0x0085 }
            com.iproov.sdk.face.model.FaceFeature r7 = r2.detectFace(r7)     // Catch:{ all -> 0x0085 }
            r0.f1606do = r8     // Catch:{ all -> 0x0085 }
            r0.f1608if = r7     // Catch:{ all -> 0x0085 }
            r0.f1607for = r5     // Catch:{ all -> 0x0085 }
            r0.f1605case = r3     // Catch:{ all -> 0x0085 }
            java.lang.Object r0 = r4.m1576do((kotlin.coroutines.c<? super kotlin.Unit>) r0)     // Catch:{ all -> 0x0085 }
            if (r0 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r0 = r8
        L_0x0081:
            r0.e(r5)
            return r7
        L_0x0085:
            r7 = move-exception
            r0 = r8
        L_0x0087:
            r0.e(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cgoto.m1577do(android.graphics.Bitmap, kotlin.coroutines.c):java.lang.Object");
    }

    public Cgoto(Context context, Cextends.Cif ifVar, b1<String> b1Var, b1<com.iproov.sdk.p017implements.Cthis> b1Var2, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1598do = b1Var2;
        this.f1600if = new com.iproov.sdk.p020native.Cif();
        this.f1599for = MutexKt.b(false, 1, (Object) null);
        this.f1601new = com.iproov.sdk.face.Cdo.m611do(context, ifVar).getFaceDetector(context);
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(b1Var, this, (c<? super Cdo>) null), 3, (Object) null);
    }

    /* renamed from: do  reason: not valid java name */
    private final Object m1576do(c<? super Unit> cVar) {
        this.f1600if.m1147case();
        this.f1600if.m1149else();
        Object emit = this.f1598do.emit(this.f1600if.m1152if(), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }
}
