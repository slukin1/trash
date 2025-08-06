package com.iproov.sdk.p030switch;

import android.graphics.SurfaceTexture;
import com.iproov.sdk.cameray.Cconst;
import com.iproov.sdk.cameray.Ctry;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.p021new.Cnew;
import com.iproov.sdk.utils.BaseCoroutineScope;
import d10.p;
import kotlin.NotImplementedError;
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
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

/* renamed from: com.iproov.sdk.switch.if  reason: invalid class name and invalid package */
public final class Cif extends BaseCoroutineScope implements Ctry {
    /* access modifiers changed from: private */

    /* renamed from: do  reason: not valid java name */
    public final a1<SurfaceTexture> f2006do;

    /* renamed from: if  reason: not valid java name */
    private final Cnew f2007if;

    @d(c = "com.iproov.sdk.impl.ui.CameraAPIImpl$open$1", f = "CameraAPIImpl.kt", l = {32}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.switch.if$do  reason: invalid class name */
    public static final class Cdo extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2008do;

        /* renamed from: for  reason: not valid java name */
        public final /* synthetic */ Cif f2009for;

        /* renamed from: if  reason: not valid java name */
        private /* synthetic */ Object f2010if;

        /* renamed from: new  reason: not valid java name */
        public final /* synthetic */ SurfaceTexture f2011new;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cdo(Cif ifVar, SurfaceTexture surfaceTexture, c<? super Cdo> cVar) {
            super(2, cVar);
            this.f2009for = ifVar;
            this.f2011new = surfaceTexture;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            Cdo doVar = new Cdo(this.f2009for, this.f2011new, cVar);
            doVar.f2010if = obj;
            return doVar;
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cdo) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2008do;
            if (i11 == 0) {
                k.b(obj);
                Ccase.m977do((h0) this.f2010if);
                a1 a1Var = this.f2009for.f2006do;
                SurfaceTexture surfaceTexture = this.f2011new;
                this.f2008do = 1;
                if (a1Var.emit(surfaceTexture, this) == d11) {
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

    @d(c = "com.iproov.sdk.impl.ui.CameraAPIImpl$stop$1", f = "CameraAPIImpl.kt", l = {38}, m = "invokeSuspend")
    /* renamed from: com.iproov.sdk.switch.if$if  reason: invalid class name */
    public static final class Cif extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: do  reason: not valid java name */
        public int f2012do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ Cif f2013if;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Cif(Cif ifVar, c<? super Cif> cVar) {
            super(2, cVar);
            this.f2013if = ifVar;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new Cif(this.f2013if, cVar);
        }

        /* renamed from: do  reason: not valid java name */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((Cif) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f2012do;
            if (i11 == 0) {
                k.b(obj);
                a1 a1Var = this.f2013if.f2006do;
                this.f2012do = 1;
                if (a1Var.emit(null, this) == d11) {
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
    public /* synthetic */ Cif(a1 a1Var, Cnew newR, CoroutineDispatcher coroutineDispatcher, int i11, r rVar) {
        this(a1Var, newR, (i11 & 4) != 0 ? v0.a() : coroutineDispatcher);
    }

    /* renamed from: case  reason: not valid java name */
    public void m1888case() {
        throw new NotImplementedError("An operation is not implemented: " + "Not used");
    }

    /* renamed from: catch  reason: not valid java name */
    public void m1889catch() {
        throw new NotImplementedError("An operation is not implemented: " + "Not used");
    }

    /* renamed from: if  reason: not valid java name */
    public Cnew m1894if() {
        return this.f2007if;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1891do(SurfaceTexture surfaceTexture) {
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cdo(this, surfaceTexture, (c<? super Cdo>) null), 3, (Object) null);
    }

    public Cif(a1<SurfaceTexture> a1Var, Cnew newR, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        this.f2006do = a1Var;
        this.f2007if = newR;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1892do(Runnable runnable) {
        n1 unused = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new Cif(this, (c<? super Cif>) null), 3, (Object) null);
    }

    /* renamed from: do  reason: not valid java name */
    public void m1893do(boolean z11) {
        throw new NotImplementedError("An operation is not implemented: " + "Not used");
    }

    /* renamed from: do  reason: not valid java name */
    public Cconst m1890do() {
        throw new NotImplementedError("An operation is not implemented: " + "Not used");
    }
}
