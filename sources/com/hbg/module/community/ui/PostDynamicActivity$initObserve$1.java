package com.hbg.module.community.ui;

import com.hbg.lib.common.utils.SP;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.VmState;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.b;

public final class PostDynamicActivity$initObserve$1 extends Lambda implements l<VmState<? extends DynamicDetailInfo>, Unit> {
    public final /* synthetic */ PostDynamicActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostDynamicActivity$initObserve$1(PostDynamicActivity postDynamicActivity) {
        super(1);
        this.this$0 = postDynamicActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VmState<? extends DynamicDetailInfo>) (VmState) obj);
        return Unit.f56620a;
    }

    public final void invoke(VmState<? extends DynamicDetailInfo> vmState) {
        APIStatusErrorException a11;
        this.this$0.Df();
        PostDynamicActivity.Ah(this.this$0).G.setEnabled(true);
        if (vmState instanceof VmState.b) {
            this.this$0.f17494l = "";
            SP.n("rich_title");
            SP.n("rich_content");
            HuobiToastUtil.r(this.this$0.getResources().getString(R$string.n_content_publish_success));
            b.m("communityRefreshPage", (Class) null, 2, (Object) null).g(Boolean.TRUE);
            this.this$0.finish();
        } else if ((vmState instanceof VmState.a) && (a11 = ((VmState.a) vmState).a()) != null) {
            HuobiToastUtil.i(a11.getErrMsg());
        }
    }
}
