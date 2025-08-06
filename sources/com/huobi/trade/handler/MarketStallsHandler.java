package com.huobi.trade.handler;

import android.view.ViewGroup;
import pro.huobi.R;
import s9.c;
import u9.b;

public class MarketStallsHandler implements c {
    /* renamed from: b */
    public void handleView(b bVar, int i11, ws.c cVar, ViewGroup viewGroup) {
        bVar.c().e(R.id.stalls_tv).setText(cVar.a());
    }

    public int getResId() {
        return R.layout.item_trade_spot_market_stalls;
    }
}
