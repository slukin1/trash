package com.hbg.lib.network.pro.socket.listener;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import com.hbg.lib.network.pro.socket.response.MarketOverviewV2Response;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class MarketOverviewListener extends BaseResponseMarketListener<MarketOverviewResponse> {

    /* renamed from: d  reason: collision with root package name */
    public OverviewVersion f70636d = OverviewVersion.VERSION_1;

    public enum OverviewVersion {
        VERSION_1,
        VERSION_2
    }

    /* renamed from: i */
    public MarketOverviewResponse h(String str) {
        if (this.f70636d == OverviewVersion.VERSION_2) {
            return ((MarketOverviewV2Response) new Gson().fromJson(str, MarketOverviewV2Response.class)).unify();
        }
        return (MarketOverviewResponse) JSON.parseObject(str, MarketOverviewResponse.class);
    }

    public void j(OverviewVersion overviewVersion) {
        this.f70636d = overviewVersion;
    }
}
