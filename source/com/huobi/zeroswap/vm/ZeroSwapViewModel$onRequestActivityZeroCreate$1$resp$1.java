package com.huobi.zeroswap.vm;

import com.hbg.lib.network.hbg.core.bean.ActivityZeroCreateBean;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.g;
import d10.p;
import d9.a;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import v7.b;

@d(c = "com.huobi.zeroswap.vm.ZeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1", f = "ZeroSwapViewModel.kt", l = {105}, m = "invokeSuspend")
public final class ZeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1 extends SuspendLambda implements p<h0, c<? super g<? extends ActivityZeroCreateBean>>, Object> {
    public int label;

    public ZeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1(c<? super ZeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ZeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1(cVar);
    }

    public final Object invoke(h0 h0Var, c<? super g<ActivityZeroCreateBean>> cVar) {
        return ((ZeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            a<ActivityZeroCreateBean> activityZeroCreatePosition = b.a().activityZeroCreatePosition();
            this.label = 1;
            obj = RequestExtKt.a(activityZeroCreatePosition, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
