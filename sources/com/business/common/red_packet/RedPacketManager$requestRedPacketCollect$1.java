package com.business.common.red_packet;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.business.common.red_packet.RedPacketManager", f = "RedPacketManager.kt", l = {151}, m = "requestRedPacketCollect")
public final class RedPacketManager$requestRedPacketCollect$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;

    public RedPacketManager$requestRedPacketCollect$1(c<? super RedPacketManager$requestRedPacketCollect$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RedPacketManager.c((String) null, (String) null, this);
    }
}
