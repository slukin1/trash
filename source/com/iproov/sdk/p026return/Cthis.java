package com.iproov.sdk.p026return;

import android.content.Context;
import android.graphics.Bitmap;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.p016if.Cextends;
import com.iproov.sdk.p016if.Cpackage;
import com.iproov.sdk.p016if.Cstrictfp;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.p017implements.Cgoto;
import com.iproov.sdk.p035try.Celse;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

/* renamed from: com.iproov.sdk.return.this  reason: invalid class name and invalid package */
public abstract class Cthis extends BaseCoroutineScope implements Cextends {

    /* renamed from: break  reason: not valid java name */
    private final Celse f1774break = new Celse();

    /* renamed from: case  reason: not valid java name */
    private final a1<Cpackage> f1775case;
    /* access modifiers changed from: private */

    /* renamed from: catch  reason: not valid java name */
    public Orientation f1776catch;

    /* renamed from: class  reason: not valid java name */
    private int f1777class;

    /* renamed from: do  reason: not valid java name */
    private final Context f1778do;
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public final a1<Cstrictfp> f1779else;

    /* renamed from: for  reason: not valid java name */
    private final com.iproov.sdk.p003case.Cif f1780for;
    /* access modifiers changed from: private */

    /* renamed from: goto  reason: not valid java name */
    public final a1<FaceFeature> f1781goto;
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final com.iproov.sdk.p021new.Cnew f1782if;

    /* renamed from: new  reason: not valid java name */
    private final com.iproov.sdk.p016if.Cthis f1783new;
    /* access modifiers changed from: private */

    /* renamed from: this  reason: not valid java name */
    public final b1<Bitmap> f1784this;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public final j1<Orientation> f1785try;

    @d(c = "com.iproov.sdk.impl.FaceScannerBase$2", f = "FaceScannerBase.kt", l = {136}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.this$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1786do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cthis f1787if;

        /* renamed from: com.iproov.sdk.return.this$do$do  reason: invalid class name */
        public static final class Cdo implements e<Orientation> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cthis f1788do;

            public Cdo(Cthis thisR) {
                this.f1788do = thisR;
            }

            public Object emit(Orientation orientation, c<? super Unit> cVar) {
                Orientation orientation2 = Cgoto.m1007do(this.f1788do.f1782if.m1207new(), orientation);
                this.f1788do.f1776catch = orientation2;
                Object emit = this.f1788do.f1779else.emit(new Cstrictfp.Cdo(this.f1788do.f1782if.m1206if(), orientation2.angleDegrees), cVar);
                if (emit == IntrinsicsKt__IntrinsicsKt.d()) {
                    return emit;
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cthis thisR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1787if = thisR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f1787if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1786do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d y11 = f.y(this.f1787if.f1785try);
                Cdo doVar = new Cdo(this.f1787if);
                this.f1786do = 1;
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

    @d(c = "com.iproov.sdk.impl.FaceScannerBase", f = "FaceScannerBase.kt", l = {92, 103, 106, 109}, m = "processFrameForCanny")
    /* renamed from: com.iproov.sdk.return.this$for  reason: invalid class name */
    public static final class Cfor extends ContinuationImpl {

        /* renamed from: case  reason: not valid java name */
        public int f1789case;

        /* renamed from: do  reason: not valid java name */
        public Object f1790do;

        /* renamed from: for  reason: not valid java name */
        public Object f1791for;

        /* renamed from: if  reason: not valid java name */
        public Object f1792if;

        /* renamed from: new  reason: not valid java name */
        public /* synthetic */ Object f1793new;

        /* renamed from: try  reason: not valid java name */
        public final /* synthetic */ Cthis f1794try;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cfor(Cthis thisR, c<? super Cfor> cVar) {
            super(cVar);
            this.f1794try = thisR;
        }

        public final Object invokeSuspend(Object obj) {
            this.f1793new = obj;
            this.f1789case |= Integer.MIN_VALUE;
            return this.f1794try.m1717if((com.iproov.sdk.p021new.Cfor) null, this);
        }
    }

    @d(c = "com.iproov.sdk.impl.FaceScannerBase$emitSelfieFrameIfRequired$2", f = "FaceScannerBase.kt", l = {77}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.this$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1795do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ com.iproov.sdk.p021new.Cfor f1796for;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cthis f1797if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cthis thisR, com.iproov.sdk.p021new.Cfor forR, c<? super Cif> cVar) {
            super(2, cVar);
            this.f1797if = thisR;
            this.f1796for = forR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cif(this.f1797if, this.f1796for, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1795do;
            if (i11 == 0) {
                k.b(obj);
                Orientation orientation = this.f1797if.f1776catch;
                if (orientation != null) {
                    Cthis thisR = this.f1797if;
                    com.iproov.sdk.p021new.Cfor forR = this.f1796for;
                    b1 b1Var = thisR.f1784this;
                    Bitmap bitmap = com.iproov.sdk.p017implements.Cnew.m1030do(forR.m1196for(1), orientation);
                    this.f1795do = 1;
                    if (b1Var.emit(bitmap, this) == d11) {
                        return d11;
                    }
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @d(c = "com.iproov.sdk.impl.FaceScannerBase$processFrameForCanny$2$1$1", f = "FaceScannerBase.kt", l = {98}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.this$new  reason: invalid class name */
    public static final class Cnew extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1798do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ FaceFeature f1799for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f1800if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ Cthis f1801new;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cnew(FaceFeature faceFeature, Cthis thisR, c<? super Cnew> cVar) {
            super(2, cVar);
            this.f1799for = faceFeature;
            this.f1801new = thisR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cnew newR = new Cnew(this.f1799for, this.f1801new, cVar);
            newR.f1800if = obj;
            return newR;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cnew) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1798do;
            if (i11 == 0) {
                k.b(obj);
                Ccase.m977do((h0) this.f1800if);
                Object obj2 = this.f1799for;
                if (obj2 == null) {
                    obj2 = "not found";
                }
                x.i("FACE ", obj2);
                a1 a1Var = this.f1801new.f1781goto;
                FaceFeature faceFeature = this.f1799for;
                this.f1798do = 1;
                if (a1Var.emit(faceFeature, this) == d11) {
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

    public Cthis(Context context, com.iproov.sdk.p021new.Cnew newR, com.iproov.sdk.p003case.Cif ifVar, com.iproov.sdk.p016if.Cthis thisR, j1<? extends Orientation> j1Var, a1<Cpackage> a1Var, a1<Cstrictfp> a1Var2, a1<FaceFeature> a1Var3, b1<Bitmap> b1Var, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1778do = context;
        this.f1782if = newR;
        this.f1780for = ifVar;
        this.f1783new = thisR;
        this.f1785try = j1Var;
        this.f1775case = a1Var;
        this.f1779else = a1Var2;
        this.f1781goto = a1Var3;
        this.f1784this = b1Var;
        Double d11 = ifVar.m233else();
        if (d11 != null) {
            thisR.setOmega(d11.doubleValue());
        }
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
    }

    /* renamed from: class  reason: not valid java name */
    public final Celse m1713class() {
        return this.f1774break;
    }

    /* renamed from: do  reason: not valid java name */
    public abstract Object m1716do(com.iproov.sdk.p021new.Cfor forR, Bitmap bitmap, FaceFeature faceFeature, c<? super Unit> cVar);

    public void handleCoroutineException(CoroutineContext coroutineContext, Throwable th2) {
        this.f1775case.d(new Cpackage.Cdo(new UnexpectedErrorException(this.f1778do, th2)));
        super.handleCoroutineException(coroutineContext, th2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: com.iproov.sdk.return.this} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* renamed from: if  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m1717if(com.iproov.sdk.p021new.Cfor r19, kotlin.coroutines.c<? super kotlin.Unit> r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            r2 = r20
            boolean r3 = r2 instanceof com.iproov.sdk.p026return.Cthis.Cfor
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.iproov.sdk.return.this$for r3 = (com.iproov.sdk.p026return.Cthis.Cfor) r3
            int r4 = r3.f1789case
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f1789case = r4
            goto L_0x001e
        L_0x0019:
            com.iproov.sdk.return.this$for r3 = new com.iproov.sdk.return.this$for
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f1793new
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f1789case
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r5 == 0) goto L_0x0071
            if (r5 == r9) goto L_0x005b
            if (r5 == r8) goto L_0x004b
            if (r5 == r7) goto L_0x0042
            if (r5 != r6) goto L_0x003a
            kotlin.k.b(r2)
            goto L_0x00eb
        L_0x003a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0042:
            java.lang.Object r0 = r3.f1790do
            com.iproov.sdk.return.this r0 = (com.iproov.sdk.p026return.Cthis) r0
            kotlin.k.b(r2)
            goto L_0x00d3
        L_0x004b:
            java.lang.Object r0 = r3.f1790do
            r5 = r0
            com.iproov.sdk.return.this r5 = (com.iproov.sdk.p026return.Cthis) r5
            kotlin.k.b(r2)     // Catch:{ IProovException -> 0x0056 }
            r0 = r5
            goto L_0x00d3
        L_0x0056:
            r0 = move-exception
            r2 = r0
            r0 = r5
            goto L_0x00c1
        L_0x005b:
            java.lang.Object r0 = r3.f1791for
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            java.lang.Object r5 = r3.f1792if
            com.iproov.sdk.new.for r5 = (com.iproov.sdk.p021new.Cfor) r5
            java.lang.Object r9 = r3.f1790do
            com.iproov.sdk.return.this r9 = (com.iproov.sdk.p026return.Cthis) r9
            kotlin.k.b(r2)
            r17 = r2
            r2 = r0
            r0 = r5
            r5 = r17
            goto L_0x009d
        L_0x0071:
            kotlin.k.b(r2)
            com.iproov.sdk.cameray.Orientation r2 = r1.f1776catch
            if (r2 != 0) goto L_0x007a
            goto L_0x00eb
        L_0x007a:
            int r5 = r18.m767this()
            android.graphics.Bitmap r5 = r0.m1197if(r5)
            android.graphics.Bitmap r2 = com.iproov.sdk.p017implements.Cnew.m1030do(r5, r2)
            if (r2 != 0) goto L_0x008b
            r0 = r1
            r2 = r10
            goto L_0x00d5
        L_0x008b:
            com.iproov.sdk.if.this r5 = r1.f1783new
            r3.f1790do = r1
            r3.f1792if = r0
            r3.f1791for = r2
            r3.f1789case = r9
            java.lang.Object r5 = r5.m837do(r2, r3)
            if (r5 != r4) goto L_0x009c
            return r4
        L_0x009c:
            r9 = r1
        L_0x009d:
            com.iproov.sdk.face.model.FaceFeature r5 = (com.iproov.sdk.face.model.FaceFeature) r5
            com.iproov.sdk.return.this$new r14 = new com.iproov.sdk.return.this$new
            r14.<init>(r5, r9, r10)
            r12 = 0
            r13 = 0
            r15 = 3
            r16 = 0
            r11 = r9
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r11, r12, r13, r14, r15, r16)
            r3.f1790do = r9     // Catch:{ IProovException -> 0x00be }
            r3.f1792if = r10     // Catch:{ IProovException -> 0x00be }
            r3.f1791for = r10     // Catch:{ IProovException -> 0x00be }
            r3.f1789case = r8     // Catch:{ IProovException -> 0x00be }
            java.lang.Object r0 = r9.m1716do(r0, r2, r5, r3)     // Catch:{ IProovException -> 0x00be }
            if (r0 != r4) goto L_0x00bc
            return r4
        L_0x00bc:
            r0 = r9
            goto L_0x00d3
        L_0x00be:
            r0 = move-exception
            r2 = r0
            r0 = r9
        L_0x00c1:
            r2.printStackTrace()
            r3.f1790do = r0
            r3.f1792if = r10
            r3.f1791for = r10
            r3.f1789case = r7
            java.lang.Object r2 = r0.m1714do((com.iproov.sdk.core.exception.IProovException) r2, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
            if (r2 != r4) goto L_0x00d3
            return r4
        L_0x00d3:
            kotlin.Unit r2 = kotlin.Unit.f56620a
        L_0x00d5:
            if (r2 != 0) goto L_0x00eb
            com.iproov.sdk.core.exception.UnexpectedErrorException r2 = new com.iproov.sdk.core.exception.UnexpectedErrorException
            android.content.Context r5 = r0.f1778do
            java.lang.String r7 = "Bitmap can not be null"
            r2.<init>((android.content.Context) r5, (java.lang.String) r7)
            r3.f1790do = r10
            r3.f1789case = r6
            java.lang.Object r0 = r0.m1714do((com.iproov.sdk.core.exception.IProovException) r2, (kotlin.coroutines.c<? super kotlin.Unit>) r3)
            if (r0 != r4) goto L_0x00eb
            return r4
        L_0x00eb:
            kotlin.Unit r0 = kotlin.Unit.f56620a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.p026return.Cthis.m1717if(com.iproov.sdk.new.for, kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: do  reason: not valid java name */
    public final Object m1715do(com.iproov.sdk.p021new.Cfor forR, int i11, c<? super Unit> cVar) {
        int i12 = this.f1777class + 1;
        this.f1777class = i12;
        if (i12 == i11 && this.f1780for.m229break()) {
            n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, forR, (c<? super Cif>) null), 3, (Object) null);
        }
        return Unit.f56620a;
    }

    /* renamed from: do  reason: not valid java name */
    public final Object m1714do(IProovException iProovException, c<? super Unit> cVar) {
        Object emit = this.f1775case.emit(new Cpackage.Cdo(iProovException), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }
}
