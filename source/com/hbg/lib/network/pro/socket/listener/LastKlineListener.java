package com.hbg.lib.network.pro.socket.listener;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.pro.socket.response.LastKlineResponse;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class LastKlineListener extends BaseResponseMarketListener<LastKlineResponse> {
    /* renamed from: i */
    public LastKlineResponse h(String str) {
        return (LastKlineResponse) JSON.parseObject(str, LastKlineResponse.class);
    }
}
