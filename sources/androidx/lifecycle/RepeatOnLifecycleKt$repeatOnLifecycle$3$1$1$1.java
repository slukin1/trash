package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d10.p;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.sync.a;

public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f9931b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<n1> f9932c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h0 f9933d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f9934e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k<Unit> f9935f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ a f9936g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ p<h0, c<? super Unit>, Object> f9937h;

    @d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, 110}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public Object L$0;
        public Object L$1;
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(aVar, pVar, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Throwable th2;
            a aVar;
            a aVar2;
            p<h0, c<? super Unit>, Object> pVar;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                kotlin.k.b(obj);
                aVar2 = aVar;
                pVar = pVar;
                this.L$0 = aVar2;
                this.L$1 = pVar;
                this.label = 1;
                if (aVar2.d((Object) null, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                pVar = (p) this.L$1;
                kotlin.k.b(obj);
                aVar2 = (a) this.L$0;
            } else if (i11 == 2) {
                aVar = (a) this.L$0;
                try {
                    kotlin.k.b(obj);
                    Unit unit = Unit.f56620a;
                    aVar.e((Object) null);
                    return unit;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(pVar, (c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1>) null);
                this.L$0 = aVar2;
                this.L$1 = null;
                this.label = 2;
                if (i0.g(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == d11) {
                    return d11;
                }
                aVar = aVar2;
                Unit unit2 = Unit.f56620a;
                aVar.e((Object) null);
                return unit2;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                aVar = aVar2;
                th2 = th5;
                aVar.e((Object) null);
                throw th2;
            }
        }
    }

    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(Lifecycle.Event event, Ref$ObjectRef<n1> ref$ObjectRef, h0 h0Var, Lifecycle.Event event2, k<? super Unit> kVar, a aVar, p<? super h0, ? super c<? super Unit>, ? extends Object> pVar) {
        this.f9931b = event;
        this.f9932c = ref$ObjectRef;
        this.f9933d = h0Var;
        this.f9934e = event2;
        this.f9935f = kVar;
        this.f9936g = aVar;
        this.f9937h = pVar;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == this.f9931b) {
            Ref$ObjectRef<n1> ref$ObjectRef = this.f9932c;
            h0 h0Var = this.f9933d;
            final a aVar = this.f9936g;
            final p<h0, c<? super Unit>, Object> pVar = this.f9937h;
            ref$ObjectRef.element = i.d(h0Var, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        if (event == this.f9934e) {
            n1 n1Var = (n1) this.f9932c.element;
            if (n1Var != null) {
                n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            }
            this.f9932c.element = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            k<Unit> kVar = this.f9935f;
            Result.a aVar2 = Result.Companion;
            kVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
        }
    }
}
