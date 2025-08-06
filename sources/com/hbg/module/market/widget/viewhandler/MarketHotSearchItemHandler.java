package com.hbg.module.market.widget.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.widget.bean.MarketHotSearchItem;
import com.hbg.module.market.widget.event.MarketSearchSymbolEvent;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.r;
import org.greenrobot.eventbus.EventBus;
import pf.a;
import s9.c;

public class MarketHotSearchItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(TextView textView, View view) {
        String charSequence = textView.getText().toString();
        MarketSearchSymbolEvent marketSearchSymbolEvent = new MarketSearchSymbolEvent();
        marketSearchSymbolEvent.e(true);
        marketSearchSymbolEvent.f(charSequence);
        EventBus.d().k(marketSearchSymbolEvent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, MarketHotSearchItem marketHotSearchItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        cVar.itemView.getResources();
        TextView e12 = e11.e(R$id.tv_title);
        e12.setText(k.C().z(marketHotSearchItem.getSymbol()));
        ((RelativeLayout) e11.b(R$id.rl_hot_area)).setOnClickListener(new a(e12));
    }

    public int getResId() {
        return R$layout.market_item_hot_search;
    }
}
