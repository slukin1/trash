package com.huobi.contract.websocket;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class LinearSwapPositionListener extends BaseResponseMarketListener<LinearSwapPositionResponse> {
    /* renamed from: i */
    public LinearSwapPositionResponse h(String str) {
        return (LinearSwapPositionResponse) JSON.parseObject(str, LinearSwapPositionResponse.class);
    }
}
