package com.hbg.lib.network.pro.socket.listener;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.pro.socket.response.MarketDepthResponse;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class MarketDepthListener extends BaseResponseMarketListener<MarketDepthResponse> {
    /* renamed from: i */
    public MarketDepthResponse h(String str) {
        return (MarketDepthResponse) JSON.parseObject(str, MarketDepthResponse.class);
    }
}
