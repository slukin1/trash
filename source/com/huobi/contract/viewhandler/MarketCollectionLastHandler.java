package com.huobi.contract.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.huobi.homemarket.bean.MarketCollectionLastItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import oa.a;
import s9.c;

public class MarketCollectionLastHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, MarketCollectionLastItem marketCollectionLastItem, ViewGroup viewGroup) {
        cVar.itemView.findViewById(R$id.layout_content).setOnClickListener(this);
    }

    public int getResId() {
        return R$layout.item_market_collection_last;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        MarketModuleConfig.a().h((FragmentActivity) a.g().b());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
