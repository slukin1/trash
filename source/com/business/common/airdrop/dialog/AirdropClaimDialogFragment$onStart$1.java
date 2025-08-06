package com.business.common.airdrop.dialog;

import com.hbg.lib.network.hbg.core.bean.AirdropRuleBean;
import d10.p;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.business.common.airdrop.dialog.AirdropClaimDialogFragment$onStart$1", f = "AirdropClaimDialogFragment.kt", l = {148}, m = "invokeSuspend")
public final class AirdropClaimDialogFragment$onStart$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ AirdropClaimDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropClaimDialogFragment$onStart$1(AirdropClaimDialogFragment airdropClaimDialogFragment, c<? super AirdropClaimDialogFragment$onStart$1> cVar) {
        super(2, cVar);
        this.this$0 = airdropClaimDialogFragment;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        AirdropClaimDialogFragment$onStart$1 airdropClaimDialogFragment$onStart$1 = new AirdropClaimDialogFragment$onStart$1(this.this$0, cVar);
        airdropClaimDialogFragment$onStart$1.L$0 = obj;
        return airdropClaimDialogFragment$onStart$1;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((AirdropClaimDialogFragment$onStart$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Integer prizeTime;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            h0 h0Var = (h0) this.L$0;
            long timeInMillis = Calendar.getInstance(TimeZone.getTimeZone(UtcDates.UTC)).getTimeInMillis();
            Long firstTimeMillis = this.this$0.f64279b.getFirstTimeMillis();
            long longValue = firstTimeMillis != null ? firstTimeMillis.longValue() : 0;
            AirdropRuleBean rule = this.this$0.f64279b.getRule();
            int intValue = (rule == null || (prizeTime = rule.getPrizeTime()) == null) ? 0 : prizeTime.intValue();
            AirdropClaimDialogFragment airdropClaimDialogFragment = this.this$0;
            this.label = 1;
            if (airdropClaimDialogFragment.Eh(h0Var, ((longValue + ((long) (intValue * 1000))) - timeInMillis) / ((long) 1000), this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
