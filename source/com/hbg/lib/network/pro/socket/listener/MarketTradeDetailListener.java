package com.hbg.lib.network.pro.socket.listener;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.pro.socket.response.TradeDetailResponse;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class MarketTradeDetailListener extends BaseResponseMarketListener<TradeDetailResponse> {
    /* renamed from: i */
    public TradeDetailResponse h(String str) {
        return (TradeDetailResponse) JSON.parseObject(str, TradeDetailResponse.class);
    }
}
