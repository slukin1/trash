package com.hbg.lib.network.hbg.socket.listener;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.hbg.socket.response.C2CMarketDepthResponse;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class C2CMarketDepthListener extends BaseResponseMarketListener<C2CMarketDepthResponse> {
    /* renamed from: i */
    public C2CMarketDepthResponse h(String str) {
        return (C2CMarketDepthResponse) JSON.parseObject(str, C2CMarketDepthResponse.class);
    }
}
