package com.hbg.lib.network.pro.socket.subscribe;

import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;
import d2.b;

public class MarketInfoDepthPercentSub extends BaseSocketSub {
    private static final long serialVersionUID = -1475156126569821201L;
    @b(serialize = false)
    private String symbol;
    @b(serialize = false)
    private String type;

    public MarketInfoDepthPercentSub(boolean z11, String str, String str2) {
        super(z11);
        this.symbol = str;
        this.type = str2;
        setChannel("market." + str + ".depth." + str2);
    }
}
