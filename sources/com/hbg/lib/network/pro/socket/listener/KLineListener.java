package com.hbg.lib.network.pro.socket.listener;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.pro.socket.response.KLineResponse;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class KLineListener extends BaseResponseMarketListener<KLineResponse> {
    /* renamed from: i */
    public KLineResponse h(String str) {
        return (KLineResponse) JSON.parseObject(str, KLineResponse.class);
    }
}
