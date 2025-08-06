package com.business.common.red_packet;

import com.hbg.lib.network.hbg.core.bean.RedPacketInfoBean;
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

@d(c = "com.business.common.red_packet.RedPacketManager$actualRequest$1$result$1", f = "RedPacketManager.kt", l = {95}, m = "invokeSuspend")
public final class RedPacketManager$actualRequest$1$result$1 extends SuspendLambda implements p<h0, c<? super g<? extends RedPacketInfoBean>>, Object> {
    public final /* synthetic */ String $codeWord;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedPacketManager$actualRequest$1$result$1(String str, c<? super RedPacketManager$actualRequest$1$result$1> cVar) {
        super(2, cVar);
        this.$codeWord = str;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RedPacketManager$actualRequest$1$result$1(this.$codeWord, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super g<RedPacketInfoBean>> cVar) {
        return ((RedPacketManager$actualRequest$1$result$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            a<RedPacketInfoBean> redPacketInfo = b.a().redPacketInfo(this.$codeWord);
            this.label = 1;
            obj = RequestExtKt.a(redPacketInfo, this);
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
