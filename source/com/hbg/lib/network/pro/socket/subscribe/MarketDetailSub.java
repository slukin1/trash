package com.hbg.lib.network.pro.socket.subscribe;

import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;
import d2.b;

public class MarketDetailSub extends BaseSocketSub {
    private static final long serialVersionUID = 7850412459592144510L;
    @b(serialize = false)
    private String symbol;

    public MarketDetailSub(boolean z11, String str) {
        super(z11);
        this.symbol = str;
        setChannel("market." + str + ".detail");
    }
}
