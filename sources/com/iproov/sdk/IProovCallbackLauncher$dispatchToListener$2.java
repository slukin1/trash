package com.iproov.sdk;

import com.iproov.sdk.IProov;
import com.iproov.sdk.IProovCallbackLauncher;
import d10.p;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.iproov.sdk.IProovCallbackLauncher$dispatchToListener$2", f = "IProovCallbackLauncher.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class IProovCallbackLauncher$dispatchToListener$2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ IProov.IProovState $state;
    public int label;
    public final /* synthetic */ IProovCallbackLauncher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IProovCallbackLauncher$dispatchToListener$2(IProov.IProovState iProovState, IProovCallbackLauncher iProovCallbackLauncher, c<? super IProovCallbackLauncher$dispatchToListener$2> cVar) {
        super(2, cVar);
        this.$state = iProovState;
        this.this$0 = iProovCallbackLauncher;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new IProovCallbackLauncher$dispatchToListener$2(this.$state, this.this$0, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((IProovCallbackLauncher$dispatchToListener$2) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            IProov.IProovState iProovState = this.$state;
            if (iProovState instanceof IProov.IProovState.Connecting) {
                IProovCallbackLauncher.Listener listener = this.this$0.getListener();
                if (listener != null) {
                    listener.onConnecting();
                    return Unit.f56620a;
                }
            } else if (iProovState instanceof IProov.IProovState.Connected) {
                IProovCallbackLauncher.Listener listener2 = this.this$0.getListener();
                if (listener2 != null) {
                    listener2.onConnected();
                    return Unit.f56620a;
                }
            } else if (iProovState instanceof IProov.IProovState.Success) {
                IProovCallbackLauncher.Listener listener3 = this.this$0.getListener();
                if (listener3 != null) {
                    listener3.onSuccess(new IProov.SuccessResult(((IProov.IProovState.Success) this.$state).getSuccessResult().getFrame()));
                    return Unit.f56620a;
                }
            } else if (iProovState instanceof IProov.IProovState.Failure) {
                IProovCallbackLauncher.Listener listener4 = this.this$0.getListener();
                if (listener4 != null) {
                    listener4.onFailure(new IProov.FailureResult(((IProov.IProovState.Failure) this.$state).getFailureResult().getReason(), ((IProov.IProovState.Failure) this.$state).getFailureResult().getFrame()));
                    return Unit.f56620a;
                }
            } else if (iProovState instanceof IProov.IProovState.Error) {
                IProovCallbackLauncher.Listener listener5 = this.this$0.getListener();
                if (listener5 != null) {
                    listener5.onError(((IProov.IProovState.Error) this.$state).getException());
                    return Unit.f56620a;
                }
            } else if (iProovState instanceof IProov.IProovState.Cancelled) {
                IProovCallbackLauncher.Listener listener6 = this.this$0.getListener();
                if (listener6 != null) {
                    listener6.onCancelled(((IProov.IProovState.Cancelled) this.$state).getCanceller());
                    return Unit.f56620a;
                }
            } else if (iProovState instanceof IProov.IProovState.Processing) {
                IProovCallbackLauncher.Listener listener7 = this.this$0.getListener();
                if (listener7 != null) {
                    listener7.onProcessing(((IProov.IProovState.Processing) this.$state).getProgress(), ((IProov.IProovState.Processing) this.$state).getMessage());
                    return Unit.f56620a;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
