package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h0;

@d(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {91}, m = "invokeSuspend")
final class FlowExtKt$flowWithLifecycle$1 extends SuspendLambda implements p<k<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ Lifecycle $lifecycle;
    public final /* synthetic */ Lifecycle.State $minActiveState;
    public final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_flowWithLifecycle;
    private /* synthetic */ Object L$0;
    public int label;

    @d(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {92}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1$a */
        public static final class a<T> implements e {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ k<T> f9891b;

            public a(k<? super T> kVar) {
                this.f9891b = kVar;
            }

            public final Object emit(T t11, c<? super Unit> cVar) {
                Object send = this.f9891b.send(t11, cVar);
                return send == IntrinsicsKt__IntrinsicsKt.d() ? send : Unit.f56620a;
            }
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(dVar, kVar2, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                kotlin.k.b(obj);
                kotlinx.coroutines.flow.d<Object> dVar = dVar;
                a aVar = new a(kVar2);
                this.label = 1;
                if (dVar.collect(aVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                kotlin.k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowExtKt$flowWithLifecycle$1(Lifecycle lifecycle, Lifecycle.State state, kotlinx.coroutines.flow.d<Object> dVar, c<? super FlowExtKt$flowWithLifecycle$1> cVar) {
        super(2, cVar);
        this.$lifecycle = lifecycle;
        this.$minActiveState = state;
        this.$this_flowWithLifecycle = dVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowExtKt$flowWithLifecycle$1 flowExtKt$flowWithLifecycle$1 = new FlowExtKt$flowWithLifecycle$1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, cVar);
        flowExtKt$flowWithLifecycle$1.L$0 = obj;
        return flowExtKt$flowWithLifecycle$1;
    }

    public final Object invoke(k<Object> kVar, c<? super Unit> cVar) {
        return ((FlowExtKt$flowWithLifecycle$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        k kVar;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            kotlin.k.b(obj);
            final k kVar2 = (k) this.L$0;
            Lifecycle lifecycle = this.$lifecycle;
            Lifecycle.State state = this.$minActiveState;
            final kotlinx.coroutines.flow.d<Object> dVar = this.$this_flowWithLifecycle;
            AnonymousClass1 r52 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.L$0 = kVar2;
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, r52, this) == d11) {
                return d11;
            }
            kVar = kVar2;
        } else if (i11 == 1) {
            kVar = (k) this.L$0;
            kotlin.k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m.a.a(kVar, (Throwable) null, 1, (Object) null);
        return Unit.f56620a;
    }
}
