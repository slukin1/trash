package com.hbg.lib.network.pro.socket.subscribe;

import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;
import d2.b;

public class TradeDetailSub extends BaseSocketSub {
    private static final long serialVersionUID = 3063036985036663132L;
    @b(serialize = false)
    private String symbol;

    public TradeDetailSub(boolean z11, String str) {
        super(z11);
        this.symbol = str;
        setChannel("market." + str + ".trade.detail");
    }
}
