package com.hbg.lib.network.pro.socket.listener;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.pro.socket.response.RequestMarketTradeDetailResponse;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class RequestMarketTradeDetailListener extends BaseResponseMarketListener<RequestMarketTradeDetailResponse> {
    /* renamed from: i */
    public RequestMarketTradeDetailResponse h(String str) {
        return (RequestMarketTradeDetailResponse) JSON.parseObject(str, RequestMarketTradeDetailResponse.class);
    }
}
