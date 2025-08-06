package com.hbg.module.share.ui;

import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.share.R$string;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import wf.a;
import wf.b;

public final class FeedShareActivity$share$1 extends Lambda implements l<DynamicDetailInfo, Unit> {
    public final /* synthetic */ FeedShareActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedShareActivity$share$1(FeedShareActivity feedShareActivity) {
        super(1);
        this.this$0 = feedShareActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DynamicDetailInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(DynamicDetailInfo dynamicDetailInfo) {
        this.this$0.Df();
        HuobiToastUtil.g(R$string.n_content_share_sent);
        b g11 = a.f40622a.g();
        if (g11 != null) {
            g11.a(0, "");
        }
        this.this$0.finish();
    }
}
