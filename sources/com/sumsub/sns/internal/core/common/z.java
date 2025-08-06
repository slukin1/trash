package com.sumsub.sns.internal.core.common;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.j;
import androidx.lifecycle.v;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public final class z<T extends View> implements DefaultLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Fragment f32322a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32323b;

    /* renamed from: c  reason: collision with root package name */
    public T f32324c;

    @d(c = "com.sumsub.sns.internal.core.common.LifecycleAwareFindView$getValue$1", f = "LifecycleAwareFindView.kt", l = {}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f32325a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z<T> f32326b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(z<T> zVar, c<? super a> cVar) {
            super(2, cVar);
            this.f32326b = zVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new a(this.f32326b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f32325a == 0) {
                k.b(obj);
                try {
                    if (this.f32326b.f32322a.getView() != null) {
                        this.f32326b.f32322a.getViewLifecycleOwner().getLifecycle().a(this.f32326b);
                    }
                } catch (Throwable th2) {
                    com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this.f32326b), "Error adding lifecycle observer", th2);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public z(Fragment fragment, int i11) {
        this.f32322a = fragment;
        this.f32323b = i11;
    }

    public /* bridge */ /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        j.a(this, lifecycleOwner);
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        this.f32324c = null;
    }

    public /* bridge */ /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        j.c(this, lifecycleOwner);
    }

    public /* bridge */ /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        j.d(this, lifecycleOwner);
    }

    public /* bridge */ /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        j.e(this, lifecycleOwner);
    }

    public /* bridge */ /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        j.f(this, lifecycleOwner);
    }

    public final T a(Object obj, l<?> lVar) {
        T t11 = null;
        if (this.f32324c == null && this.f32322a.getView() != null) {
            n1 unused = i.d(v.a(this.f32322a), v0.c().G(), (CoroutineStart) null, new a(this, (c<? super a>) null), 2, (Object) null);
        }
        if (this.f32322a.getView() == null) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.b(aVar, a11, this.f32322a + ".view is null", (Throwable) null, 4, (Object) null);
            this.f32324c = null;
            return null;
        }
        if (this.f32324c == null) {
            View view = this.f32322a.getView();
            if (view != null) {
                t11 = view.findViewById(this.f32323b);
            }
            this.f32324c = t11;
        }
        return this.f32324c;
    }
}
