package com.hbg.module.market.widget.viewhandler;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.hbg.module.market.widget.bean.MarketSymbolHeaderItem;
import i6.r;
import s9.c;

public class MarketSymbolHeaderHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public TextView f26802b;

    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, MarketSymbolHeaderItem marketSymbolHeaderItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Resources resources = cVar.itemView.getResources();
        TextView e12 = e11.e(R$id.item_search_symbol_text);
        this.f26802b = e12;
        e12.setText(resources.getString(R$string.n_widget_market_list_header_coin));
    }

    public int getResId() {
        return R$layout.item_market_widget_symbol_header;
    }
}
