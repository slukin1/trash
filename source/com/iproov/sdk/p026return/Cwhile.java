package com.iproov.sdk.p026return;

import android.content.Context;
import android.graphics.Bitmap;
import com.iproov.sdk.cameray.Cconst;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.p016if.Cif;
import com.iproov.sdk.p016if.Cstatic;
import com.iproov.sdk.p016if.Cswitch;
import com.iproov.sdk.p033throws.Cfor;
import com.iproov.sdk.p033throws.Cnew;
import com.iproov.sdk.p035try.Ctry;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
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

/* renamed from: com.iproov.sdk.return.while  reason: invalid class name and invalid package */
public final class Cwhile extends BaseCoroutineScope implements Cswitch {

    /* renamed from: case  reason: not valid java name */
    private final com.iproov.sdk.p025public.Cif f1888case;

    /* renamed from: do  reason: not valid java name */
    private final Context f1889do;
    /* access modifiers changed from: private */

    /* renamed from: else  reason: not valid java name */
    public com.iproov.sdk.p033throws.Cfor f1890else;
    /* access modifiers changed from: private */

    /* renamed from: for  reason: not valid java name */
    public final a1<com.iproov.sdk.p016if.Cif> f1891for;

    /* renamed from: goto  reason: not valid java name */
    private final com.iproov.sdk.p008default.Cdo f1892goto;
    /* access modifiers changed from: private */

    /* renamed from: if  reason: not valid java name */
    public final j1<com.iproov.sdk.p003case.Cif> f1893if;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public final j1<Cconst> f1894new;

    /* renamed from: this  reason: not valid java name */
    private final Cfor f1895this;
    /* access modifiers changed from: private */

    /* renamed from: try  reason: not valid java name */
    public final f1<Cstatic> f1896try;

    @d(c = "com.iproov.sdk.impl.LightingDetectorImpl$1", f = "LightingDetectorImpl.kt", l = {129}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.while$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1897do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cwhile f1898if;

        @d(c = "com.iproov.sdk.impl.LightingDetectorImpl$1$1", f = "LightingDetectorImpl.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.while$do$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements q<Cconst, com.iproov.sdk.p003case.Cif, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1899do;

            public Cdo(c<? super Cdo> cVar) {
                super(3, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(Cconst constR, com.iproov.sdk.p003case.Cif ifVar, c<? super Unit> cVar) {
                return new Cdo(cVar).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f1899do == 0) {
                    k.b(obj);
                    return Unit.f56620a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* renamed from: com.iproov.sdk.return.while$do$if  reason: invalid class name */
        public static final class Cif implements e<Unit> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cwhile f1900do;

            public Cif(Cwhile whileR) {
                this.f1900do = whileR;
            }

            public Object emit(Unit unit, c<? super Unit> cVar) {
                Unit unit2 = unit;
                this.f1900do.m1764class();
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cwhile whileR, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f1898if = whileR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cdo(this.f1898if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1897do;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d G = f.G(f.y(this.f1898if.f1894new), f.y(this.f1898if.f1893if), new Cdo((c<? super Cdo>) null));
                Cif ifVar = new Cif(this.f1898if);
                this.f1897do = 1;
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

    /* renamed from: com.iproov.sdk.return.while$for  reason: invalid class name */
    public static final class Cfor implements Cfor.Cdo {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Cwhile f1901do;

        @d(c = "com.iproov.sdk.impl.LightingDetectorImpl$legacyListener$1$setExposureLocked$1", f = "LightingDetectorImpl.kt", l = {48}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.while$for$do  reason: invalid class name */
        public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1902do;

            /* renamed from: for  reason: not valid java name */
            public final /* synthetic */ boolean f1903for;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cwhile f1904if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cdo(Cwhile whileR, boolean z11, c<? super Cdo> cVar) {
                super(2, cVar);
                this.f1904if = whileR;
                this.f1903for = z11;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cdo(this.f1904if, this.f1903for, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1902do;
                if (i11 == 0) {
                    k.b(obj);
                    a1 a1Var = this.f1904if.f1891for;
                    Cif.Cfor forR = new Cif.Cfor(this.f1903for);
                    this.f1902do = 1;
                    if (a1Var.emit(forR, this) == d11) {
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

        @d(c = "com.iproov.sdk.impl.LightingDetectorImpl$legacyListener$1$takePhotoAndLockExposure$1", f = "LightingDetectorImpl.kt", l = {54}, m = "invokeSuspend")
        /* renamed from: com.iproov.sdk.return.while$for$if  reason: invalid class name */
        public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: do  reason: not valid java name */
            public int f1905do;

            /* renamed from: if  reason: not valid java name */
            public final /* synthetic */ Cwhile f1906if;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cif(Cwhile whileR, c<? super Cif> cVar) {
                super(2, cVar);
                this.f1906if = whileR;
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new Cif(this.f1906if, cVar);
            }

            /* renamed from: do  reason: not valid java name */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f1905do;
                if (i11 == 0) {
                    k.b(obj);
                    a1 a1Var = this.f1906if.f1891for;
                    Cif.Cnew newR = Cif.Cnew.f679do;
                    this.f1905do = 1;
                    if (a1Var.emit(newR, this) == d11) {
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

        public Cfor(Cwhile whileR) {
            this.f1901do = whileR;
        }

        /* renamed from: case  reason: not valid java name */
        public void m1777case() {
            Cwhile whileR = this.f1901do;
            n1 unused = i.d(whileR, (CoroutineContext) null, (CoroutineStart) null, new Cif(whileR, (c<? super Cif>) null), 3, (Object) null);
        }

        /* renamed from: do  reason: not valid java name */
        public void m1778do(boolean z11) {
            Cwhile whileR = this.f1901do;
            n1 unused = i.d(whileR, (CoroutineContext) null, (CoroutineStart) null, new Cdo(whileR, z11, (c<? super Cdo>) null), 3, (Object) null);
        }
    }

    @d(c = "com.iproov.sdk.impl.LightingDetectorImpl$2", f = "LightingDetectorImpl.kt", l = {129}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.return.while$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f1907do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cwhile f1908if;

        /* renamed from: com.iproov.sdk.return.while$if$do  reason: invalid class name */
        public static final class Cdo implements e<Cstatic> {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ Cwhile f1909do;

            public Cdo(Cwhile whileR) {
                this.f1909do = whileR;
            }

            public Object emit(Cstatic staticR, c<? super Unit> cVar) {
                com.iproov.sdk.p033throws.Cfor forR;
                Cstatic staticR2 = staticR;
                if (staticR2 instanceof Cstatic.Cif) {
                    com.iproov.sdk.p033throws.Cfor forR2 = this.f1909do.f1890else;
                    if (forR2 != null) {
                        forR2.m1968do(((Cstatic.Cif) staticR2).m821do());
                    }
                } else if (staticR2 instanceof Cstatic.Cfor) {
                    com.iproov.sdk.p033throws.Cfor forR3 = this.f1909do.f1890else;
                    if (forR3 != null) {
                        forR3.m1967do(((Cstatic.Cfor) staticR2).m820do());
                    }
                } else if ((staticR2 instanceof Cstatic.Cdo) && (forR = this.f1909do.f1890else) != null) {
                    forR.m1969do(((Cstatic.Cdo) staticR2).m819do());
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cwhile whileR, c<? super Cif> cVar) {
            super(2, cVar);
            this.f1908if = whileR;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cif(this.f1908if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f1907do;
            if (i11 == 0) {
                k.b(obj);
                f1 f1Var = this.f1908if.f1896try;
                Cdo doVar = new Cdo(this.f1908if);
                this.f1907do = 1;
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
    public /* synthetic */ Cwhile(Context context, j1 j1Var, a1 a1Var, j1 j1Var2, f1 f1Var, com.iproov.sdk.p025public.Cif ifVar, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(context, j1Var, a1Var, j1Var2, f1Var, ifVar, (i11 & 64) != 0 ? v0.a() : coroutineDispatcher);
    }

    /* access modifiers changed from: private */
    /* renamed from: class  reason: not valid java name */
    public final void m1764class() {
        com.iproov.sdk.p003case.Cif value;
        Cconst value2 = this.f1894new.getValue();
        if (value2 != null && (value = this.f1893if.getValue()) != null) {
            this.f1890else = new Cnew(this.f1889do, value2, value.m239try(), this.f1895this, new Ctry(this.f1888case));
        }
    }

    /* renamed from: break  reason: not valid java name */
    public float m1770break() {
        return this.f1892goto.m526if();
    }

    public void doStop() {
        this.f1892goto.m524do();
    }

    /* renamed from: goto  reason: not valid java name */
    public Bitmap m1773goto() {
        com.iproov.sdk.p033throws.Cfor forR = this.f1890else;
        if (forR == null) {
            return null;
        }
        return forR.m1971goto();
    }

    public void handleCoroutineException(CoroutineContext coroutineContext, Throwable th2) {
        this.f1891for.d(new Cif.Cif(th2));
        super.handleCoroutineException(coroutineContext, th2);
    }

    /* renamed from: do  reason: not valid java name */
    public com.iproov.sdk.p015goto.Cdo m1771do(Bitmap bitmap, FaceFeature faceFeature) {
        com.iproov.sdk.p033throws.Cfor forR = this.f1890else;
        if (forR == null) {
            return null;
        }
        return forR.m1966do(bitmap, faceFeature);
    }

    /* renamed from: for  reason: not valid java name */
    public String m1772for() {
        com.iproov.sdk.p033throws.Cfor forR = this.f1890else;
        if (forR == null) {
            return null;
        }
        return forR.m1970for();
    }

    /* renamed from: new  reason: not valid java name */
    public Double m1774new() {
        com.iproov.sdk.p033throws.Cfor forR = this.f1890else;
        if (forR == null) {
            return null;
        }
        return Double.valueOf(forR.m1972new());
    }

    public Cwhile(Context context, j1<com.iproov.sdk.p003case.Cif> j1Var, a1<com.iproov.sdk.p016if.Cif> a1Var, j1<? extends Cconst> j1Var2, f1<? extends Cstatic> f1Var, com.iproov.sdk.p025public.Cif ifVar, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f1889do = context;
        this.f1893if = j1Var;
        this.f1891for = a1Var;
        this.f1894new = j1Var2;
        this.f1896try = f1Var;
        this.f1888case = ifVar;
        com.iproov.sdk.p008default.Cdo doVar = new com.iproov.sdk.p008default.Cdo(context);
        this.f1892goto = doVar;
        this.f1895this = new Cfor(this);
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, (c<? super Cdo>) null), 3, (Object) null);
        n1 unused2 = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, (c<? super Cif>) null), 3, (Object) null);
        doVar.m525for();
    }
}
