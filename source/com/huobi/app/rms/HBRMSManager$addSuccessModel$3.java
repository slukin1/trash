package com.huobi.app.rms;

import com.huobi.app.rms.wrapper.PathFetchEvent;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import org.greenrobot.eventbus.EventBus;

@d(c = "com.huobi.app.rms.HBRMSManager$addSuccessModel$3", f = "HBRMSManager.kt", l = {}, m = "invokeSuspend")
public final class HBRMSManager$addSuccessModel$3 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;

    public HBRMSManager$addSuccessModel$3(c<? super HBRMSManager$addSuccessModel$3> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new HBRMSManager$addSuccessModel$3(cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((HBRMSManager$addSuccessModel$3) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            EventBus.d().k(new PathFetchEvent());
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
