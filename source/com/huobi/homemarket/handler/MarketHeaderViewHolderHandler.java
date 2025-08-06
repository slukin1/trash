package com.huobi.homemarket.handler;

import android.view.View;
import android.view.ViewGroup;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import i6.r;
import s9.c;

public class MarketHeaderViewHolderHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, ml.c cVar2, ViewGroup viewGroup) {
        r e11 = cVar.e();
        e11.e(R$id.market_header_partition).setText(cVar2.a());
        View b11 = e11.b(R$id.market_header_divider);
        if (!cVar2.c()) {
            b11.setVisibility(8);
        }
    }

    public int getResId() {
        return R$layout.item_market_header;
    }
}
