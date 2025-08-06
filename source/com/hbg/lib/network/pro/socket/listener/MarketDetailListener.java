package com.hbg.lib.network.pro.socket.listener;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.pro.socket.response.MarketDetailResponse;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class MarketDetailListener extends BaseResponseMarketListener<MarketDetailResponse> {
    /* renamed from: i */
    public MarketDetailResponse h(String str) {
        return (MarketDetailResponse) JSON.parseObject(str, MarketDetailResponse.class);
    }
}
