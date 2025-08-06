package com.hbg.lib.network.pro.socket.subscribe;

import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;

public class MarketOverviewV2Sub extends BaseSocketSub {
    private static final long serialVersionUID = -976062955220566922L;

    public MarketOverviewV2Sub(boolean z11) {
        super(z11);
        setChannel("market.overviewv2");
    }
}
