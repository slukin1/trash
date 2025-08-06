package com.business.common.red_packet;

import com.hbg.lib.network.hbg.core.bean.RedPacketCollectBean;
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

@d(c = "com.business.common.red_packet.RedPacketManager$requestRedPacketCollect$result$1", f = "RedPacketManager.kt", l = {151}, m = "invokeSuspend")
public final class RedPacketManager$requestRedPacketCollect$result$1 extends SuspendLambda implements p<h0, c<? super g<? extends RedPacketCollectBean>>, Object> {
    public final /* synthetic */ String $codeWord;
    public final /* synthetic */ String $vToken;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedPacketManager$requestRedPacketCollect$result$1(String str, String str2, c<? super RedPacketManager$requestRedPacketCollect$result$1> cVar) {
        super(2, cVar);
        this.$codeWord = str;
        this.$vToken = str2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RedPacketManager$requestRedPacketCollect$result$1(this.$codeWord, this.$vToken, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super g<RedPacketCollectBean>> cVar) {
        return ((RedPacketManager$requestRedPacketCollect$result$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            a<RedPacketCollectBean> X = b.a().X(this.$codeWord, this.$vToken);
            this.label = 1;
            obj = RequestExtKt.a(X, this);
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
