package com.huobi.index.viewhandler;

import android.view.View;
import com.huobi.homemarket.model.MarketRemindFlashItem;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexMarketRemindHandler f74471b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MarketRemindFlashItem f74472c;

    public /* synthetic */ m(IndexMarketRemindHandler indexMarketRemindHandler, MarketRemindFlashItem marketRemindFlashItem) {
        this.f74471b = indexMarketRemindHandler;
        this.f74472c = marketRemindFlashItem;
    }

    public final void onClick(View view) {
        this.f74471b.h(this.f74472c, view);
    }
}
