package com.business.common.airdrop;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.business.common.airdrop.AirdropManager", f = "AirdropManager.kt", l = {135}, m = "requestAirdropClose")
public final class AirdropManager$requestAirdropClose$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AirdropManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropManager$requestAirdropClose$1(AirdropManager airdropManager, c<? super AirdropManager$requestAirdropClose$1> cVar) {
        super(cVar);
        this.this$0 = airdropManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(0, (String) null, this);
    }
}
