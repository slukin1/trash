package com.business.common.airdrop.view;

import com.business.common.airdrop.data.AirdropHeaderBean;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.business.common.airdrop.view.AirdropView", f = "AirdropView.kt", l = {321, 327, 328, 329, 330}, m = "handleHeader")
public final class AirdropView$handleHeader$1 extends ContinuationImpl {
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AirdropView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropView$handleHeader$1(AirdropView airdropView, c<? super AirdropView$handleHeader$1> cVar) {
        super(cVar);
        this.this$0 = airdropView;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.w((AirdropHeaderBean) null, this);
    }
}
