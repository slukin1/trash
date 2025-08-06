package com.hbg.module.livesquare.ui;

import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.livesquare.adapter.g;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class RecommendSpeakerActivity$initVm$1 extends Lambda implements l<VmState<? extends RecommendSpeakerList>, Unit> {
    public final /* synthetic */ RecommendSpeakerActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecommendSpeakerActivity$initVm$1(RecommendSpeakerActivity recommendSpeakerActivity) {
        super(1);
        this.this$0 = recommendSpeakerActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VmState<? extends RecommendSpeakerList>) (VmState) obj);
        return Unit.f56620a;
    }

    public final void invoke(VmState<? extends RecommendSpeakerList> vmState) {
        List<RecommendSpeakerList.RecommendSpeakerBean> listData;
        RecommendSpeakerActivity.Bh(this.this$0).E.finishRefresh();
        RecommendSpeakerActivity.Bh(this.this$0).E.w();
        if (vmState instanceof VmState.b) {
            RecommendSpeakerList recommendSpeakerList = (RecommendSpeakerList) ((VmState.b) vmState).a();
            if (recommendSpeakerList != null && (listData = recommendSpeakerList.getListData()) != null) {
                RecommendSpeakerActivity recommendSpeakerActivity = this.this$0;
                if (!b.w(listData)) {
                    RecommendSpeakerActivity.Bh(recommendSpeakerActivity).B.g();
                    g Ah = recommendSpeakerActivity.f26651k;
                    if (Ah != null) {
                        Ah.a(recommendSpeakerActivity.f26650j == 1 ? 0 : 1, listData);
                    }
                    recommendSpeakerActivity.f26650j = recommendSpeakerActivity.f26650j + 1;
                } else if (recommendSpeakerActivity.f26650j > 1) {
                    RecommendSpeakerActivity.Bh(recommendSpeakerActivity).E.e();
                } else {
                    RecommendSpeakerActivity.Bh(recommendSpeakerActivity).B.i();
                }
            }
        } else if (vmState instanceof VmState.a) {
            RecommendSpeakerActivity.Bh(this.this$0).B.k();
            APIStatusErrorException a11 = ((VmState.a) vmState).a();
            if (a11 != null) {
                HuobiToastUtil.i(a11.getErrMsg());
            }
            if (this.this$0.f26650j == 1) {
                RecommendSpeakerActivity.Bh(this.this$0).B.k();
            }
        } else if (this.this$0.f26650j == 1) {
            RecommendSpeakerActivity.Bh(this.this$0).B.k();
        }
    }
}
