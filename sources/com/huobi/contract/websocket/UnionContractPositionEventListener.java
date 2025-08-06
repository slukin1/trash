package com.huobi.contract.websocket;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class UnionContractPositionEventListener extends BaseResponseMarketListener<UnionContractPositionEventResponse> {
    /* renamed from: i */
    public UnionContractPositionEventResponse h(String str) {
        return (UnionContractPositionEventResponse) JSON.parseObject(str, UnionContractPositionEventResponse.class);
    }
}
