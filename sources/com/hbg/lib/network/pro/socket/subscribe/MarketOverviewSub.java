package com.hbg.lib.network.pro.socket.subscribe;

import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;

public class MarketOverviewSub extends BaseSocketSub {
    private static final long serialVersionUID = 7850412459592144510L;

    public MarketOverviewSub(boolean z11) {
        super(z11);
        setChannel("market.overview");
    }
}
