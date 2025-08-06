package com.huobi.zeroswap.vm;

import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.libkt.base.ext.g;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;

@d(c = "com.huobi.zeroswap.vm.ZeroSwapViewModel$onRequestActivityZeroCreate$1", f = "ZeroSwapViewModel.kt", l = {105}, m = "invokeSuspend")
public final class ZeroSwapViewModel$onRequestActivityZeroCreate$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ ZeroSwapViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZeroSwapViewModel$onRequestActivityZeroCreate$1(ZeroSwapViewModel zeroSwapViewModel, c<? super ZeroSwapViewModel$onRequestActivityZeroCreate$1> cVar) {
        super(2, cVar);
        this.this$0 = zeroSwapViewModel;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ZeroSwapViewModel$onRequestActivityZeroCreate$1(this.this$0, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((ZeroSwapViewModel$onRequestActivityZeroCreate$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            CoroutineDispatcher b11 = v0.b();
            ZeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1 zeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1 = new ZeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1((c<? super ZeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1>) null);
            this.label = 1;
            obj = g.g(b11, zeroSwapViewModel$onRequestActivityZeroCreate$1$resp$1, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        com.hbg.module.libkt.base.ext.g gVar = (com.hbg.module.libkt.base.ext.g) obj;
        if (gVar instanceof g.b) {
            this.this$0.f21230m.postValue(((g.b) gVar).a());
        } else if (gVar instanceof g.a) {
            g.a aVar = (g.a) gVar;
            APIStatusErrorException a11 = aVar.a();
            if (a11 != null) {
                LogAndWoodRecorder.a("合约0元购", "activityZeroCreatePosition-apiE:" + a11.getErrMsg());
            }
            Throwable b12 = aVar.b();
            if (b12 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("activityZeroCreatePosition-other:");
                String message = b12.getMessage();
                if (message == null) {
                    message = "";
                }
                sb2.append(message);
                LogAndWoodRecorder.a("合约0元购", sb2.toString());
            }
        }
        return Unit.f56620a;
    }
}
