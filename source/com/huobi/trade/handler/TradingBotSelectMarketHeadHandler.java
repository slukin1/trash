package com.huobi.trade.handler;

import android.view.ViewGroup;
import android.widget.TextView;
import com.huobi.trade.bean.TradingBotSelectMarketHead;
import pro.huobi.R;
import s9.c;

public class TradingBotSelectMarketHeadHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, TradingBotSelectMarketHead tradingBotSelectMarketHead, ViewGroup viewGroup) {
        ((TextView) cVar.e().b(R.id.id_symbol_tv)).setText(tradingBotSelectMarketHead.getLetter());
    }

    public int getResId() {
        return R.layout.item_tradingbot_select_market_head;
    }
}
