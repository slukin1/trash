package com.huobi.trade.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.NewBannerBean;

public final /* synthetic */ class g2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f82634b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NewBannerBean.BannerAdv f82635c;

    public /* synthetic */ g2(String str, NewBannerBean.BannerAdv bannerAdv) {
        this.f82634b = str;
        this.f82635c = bannerAdv;
    }

    public final void onClick(View view) {
        TradeHeadView.u(this.f82634b, this.f82635c, view);
    }
}
