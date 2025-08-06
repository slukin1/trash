package com.hbg.lib.network.pro.socket.listener;

import com.google.gson.Gson;
import com.hbg.lib.network.pro.socket.response.MarketOverviewV2Response;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class MarketOverviewListenerV2 extends BaseResponseMarketListener<MarketOverviewV2Response> {
    /* renamed from: i */
    public MarketOverviewV2Response h(String str) {
        return (MarketOverviewV2Response) new Gson().fromJson(str, MarketOverviewV2Response.class);
    }
}
