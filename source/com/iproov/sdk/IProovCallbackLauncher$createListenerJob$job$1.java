package com.iproov.sdk;

import com.iproov.sdk.IProov;
import d10.p;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.h0;

@d(c = "com.iproov.sdk.IProovCallbackLauncher$createListenerJob$job$1", f = "IProovCallbackLauncher.kt", l = {176}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class IProovCallbackLauncher$createListenerJob$job$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ UUID $uuid;
    public int label;
    public final /* synthetic */ IProovCallbackLauncher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IProovCallbackLauncher$createListenerJob$job$1(IProovCallbackLauncher iProovCallbackLauncher, UUID uuid, c<? super IProovCallbackLauncher$createListenerJob$job$1> cVar) {
        super(2, cVar);
        this.this$0 = iProovCallbackLauncher;
        this.$uuid = uuid;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new IProovCallbackLauncher$createListenerJob$job$1(this.this$0, this.$uuid, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((IProovCallbackLauncher$createListenerJob$job$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            j1<IProov.IProovSessionState> sessionsStates = this.this$0.iProovFlowLauncher.getSessionsStates();
            IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1 iProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1 = new IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1(this.$uuid, this.this$0);
            this.label = 1;
            if (sessionsStates.collect(iProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1, this) == d11) {
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
