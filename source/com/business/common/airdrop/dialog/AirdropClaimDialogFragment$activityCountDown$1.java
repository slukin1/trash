package com.business.common.airdrop.dialog;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.h0;

@d(c = "com.business.common.airdrop.dialog.AirdropClaimDialogFragment", f = "AirdropClaimDialogFragment.kt", l = {175}, m = "activityCountDown")
public final class AirdropClaimDialogFragment$activityCountDown$1 extends ContinuationImpl {
    public long J$0;
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AirdropClaimDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropClaimDialogFragment$activityCountDown$1(AirdropClaimDialogFragment airdropClaimDialogFragment, c<? super AirdropClaimDialogFragment$activityCountDown$1> cVar) {
        super(cVar);
        this.this$0 = airdropClaimDialogFragment;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Eh((h0) null, 0, this);
    }
}
