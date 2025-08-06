package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;

@d(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", l = {444}, m = "invokeSuspend")
final class LifecycleKt$eventFlow$1 extends SuspendLambda implements p<k<? super Lifecycle.Event>, c<? super Unit>, Object> {
    public final /* synthetic */ Lifecycle $this_eventFlow;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LifecycleKt$eventFlow$1(Lifecycle lifecycle, c<? super LifecycleKt$eventFlow$1> cVar) {
        super(2, cVar);
        this.$this_eventFlow = lifecycle;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(k kVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        kVar.q(event);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.$this_eventFlow, cVar);
        lifecycleKt$eventFlow$1.L$0 = obj;
        return lifecycleKt$eventFlow$1;
    }

    public final Object invoke(k<? super Lifecycle.Event> kVar, c<? super Unit> cVar) {
        return ((LifecycleKt$eventFlow$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            kotlin.k.b(obj);
            k kVar = (k) this.L$0;
            final s sVar = new s(kVar);
            this.$this_eventFlow.a(sVar);
            final Lifecycle lifecycle = this.$this_eventFlow;
            AnonymousClass1 r32 = new a<Unit>() {
                public final void invoke() {
                    lifecycle.d(sVar);
                }
            };
            this.label = 1;
            if (ProduceKt.a(kVar, r32, this) == d11) {
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
