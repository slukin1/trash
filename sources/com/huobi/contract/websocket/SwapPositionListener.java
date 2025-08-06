package com.huobi.contract.websocket;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class SwapPositionListener extends BaseResponseMarketListener<SwapPositionResponse> {
    /* renamed from: i */
    public SwapPositionResponse h(String str) {
        return (SwapPositionResponse) JSON.parseObject(str, SwapPositionResponse.class);
    }
}
