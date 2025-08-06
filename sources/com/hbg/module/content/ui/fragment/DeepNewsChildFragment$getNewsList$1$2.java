package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.xiaomi.mipush.sdk.Constants;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class DeepNewsChildFragment$getNewsList$1$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ DeepNewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepNewsChildFragment$getNewsList$1$2(DeepNewsChildFragment deepNewsChildFragment) {
        super(2);
        this.this$0 = deepNewsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.gi(false);
        this.this$0.sh();
        DeepNewsChildFragment.Th(this.this$0).E.finishRefresh();
        if (this.this$0.Xh() == 0) {
            DeepNewsChildFragment.Th(this.this$0).C.k();
        } else {
            DeepNewsChildFragment.Th(this.this$0).E.w();
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
        Integer Wh = this.this$0.Wh();
        if (Wh != null && Wh.intValue() == -1 && this.this$0.Xh() == 0 && !this.this$0.f18738v) {
            this.this$0.f18738v = true;
            HbgBaseApmProvider Sh = this.this$0.f18739w;
            if (Sh != null) {
                Sh.i("huobiapp_market_content_deep_end", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
            }
        }
    }
}
