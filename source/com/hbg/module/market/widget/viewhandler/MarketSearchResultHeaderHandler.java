package com.hbg.module.market.widget.viewhandler;

import android.view.ViewGroup;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.widget.bean.MarketSearchResultHeaderItem;
import s9.c;

public class MarketSearchResultHeaderHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, MarketSearchResultHeaderItem marketSearchResultHeaderItem, ViewGroup viewGroup) {
        cVar.e().e(R$id.item_search_result_title).setText(marketSearchResultHeaderItem.getTitle());
    }

    public int getResId() {
        return R$layout.item_market_search_result_header;
    }
}
