package com.business.common.airdrop.dialog;

import com.business.common.R$string;
import com.business.common.airdrop.AirdropManager;
import com.business.common.airdrop.data.AirdropCloseIdBean;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.network.hbg.core.bean.AirdropResultBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.g;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import we.b;

@d(c = "com.business.common.airdrop.dialog.AirdropClaimDialogFragment$activityClaim$1$1", f = "AirdropClaimDialogFragment.kt", l = {261}, m = "invokeSuspend")
public final class AirdropClaimDialogFragment$activityClaim$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ AirdropClaimDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropClaimDialogFragment$activityClaim$1$1(AirdropClaimDialogFragment airdropClaimDialogFragment, c<? super AirdropClaimDialogFragment$activityClaim$1$1> cVar) {
        super(2, cVar);
        this.this$0 = airdropClaimDialogFragment;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new AirdropClaimDialogFragment$activityClaim$1$1(this.this$0, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((AirdropClaimDialogFragment$activityClaim$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            AirdropManager airdropManager = AirdropManager.f64272a;
            int yh2 = this.this$0.f64280c;
            String xh2 = this.this$0.f64281d;
            this.label = 1;
            obj = airdropManager.m(yh2, xh2, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        g gVar = (g) obj;
        int i12 = -1;
        if (gVar instanceof g.a) {
            g.a aVar = (g.a) gVar;
            APIStatusErrorException a11 = aVar.a();
            Throwable b11 = aVar.b();
            if (a11 == null) {
                if (b11 != null) {
                    LogAndWoodRecorder.a("Airdrop", "Claim-OtherError(Msg:" + b11.getMessage() + ')');
                }
                HuobiToastUtil.j(R$string.n_network_error_content);
            } else {
                LogAndWoodRecorder.a("Airdrop", "Claim-APIError(Code:" + a11.getErrCode() + ",Msg:" + a11.getErrMsg() + ')');
                HuobiToastUtil.j(R$string.n_airdrop_reward_missed_chances);
                this.this$0.dismiss();
                b.a<AirdropCloseIdBean> h11 = AirdropManager.f64272a.h();
                Integer id2 = this.this$0.f64279b.getId();
                if (id2 != null) {
                    i12 = id2.intValue();
                }
                h11.g(new AirdropCloseIdBean(i12));
            }
        } else if (gVar instanceof g.b) {
            AirdropResultBean airdropResultBean = (AirdropResultBean) ((g.b) gVar).a();
            if (airdropResultBean != null) {
                Boolean result = airdropResultBean.getResult();
                if (result != null ? result.booleanValue() : false) {
                    AirdropManager.f64272a.p(this.this$0.requireActivity().getSupportFragmentManager(), this.this$0.f64279b, airdropResultBean, this.this$0.f64280c, this.this$0.f64281d);
                } else {
                    HuobiToastUtil.m(this.this$0.requireContext().getString(R$string.n_airdrop_have_been_claimed));
                }
            }
            this.this$0.dismiss();
            b.a<AirdropCloseIdBean> h12 = AirdropManager.f64272a.h();
            Integer id3 = this.this$0.f64279b.getId();
            if (id3 != null) {
                i12 = id3.intValue();
            }
            h12.g(new AirdropCloseIdBean(i12));
        }
        return Unit.f56620a;
    }
}
