package com.hbg.module.content.ui.fragment;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.provider.HbgBaseApmProvider;
import com.xiaomi.mipush.sdk.Constants;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class NewsChildFragment$getNewListBySelect$2 extends Lambda implements p<Throwable, APIStatusErrorException, Unit> {
    public final /* synthetic */ NewsChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsChildFragment$getNewListBySelect$2(NewsChildFragment newsChildFragment) {
        super(2);
        this.this$0 = newsChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Throwable) obj, (APIStatusErrorException) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
        this.this$0.Ji(false);
        this.this$0.sh();
        NewsChildFragment.Zh(this.this$0).E.finishRefresh();
        if (b.x(this.this$0.ni())) {
            NewsChildFragment.Zh(this.this$0).C.k();
        } else {
            NewsChildFragment.Zh(this.this$0).E.w();
        }
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
        Integer Xh = this.this$0.f18785t;
        if (Xh != null && Xh.intValue() == -1 && x.b(this.this$0.ni(), "") && !this.this$0.A) {
            this.this$0.A = true;
            HbgBaseApmProvider Wh = this.this$0.B;
            if (Wh != null) {
                Wh.i("huobiapp_market_content_newsflash_end", Constants.ACCEPT_TIME_SEPARATOR_SERVER, true);
            }
        }
    }
}
