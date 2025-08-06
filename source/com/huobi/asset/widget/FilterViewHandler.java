package com.huobi.asset.widget;

import android.view.ViewGroup;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import s9.c;

public class FilterViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, FilterViewData filterViewData, ViewGroup viewGroup) {
        FilterBar filterBar = (FilterBar) cVar.e().b(R$id.f16933fb);
        if (filterViewData.c() != null) {
            filterBar.setFilterTitle(filterViewData.c());
        }
        if (filterViewData.d()) {
            filterBar.n();
        }
    }

    public int getResId() {
        return R$layout.item_asset_filter;
    }
}
