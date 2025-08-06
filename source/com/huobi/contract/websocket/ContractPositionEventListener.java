package com.huobi.contract.websocket;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class ContractPositionEventListener extends BaseResponseMarketListener<ContractPositionEventResponse> {
    /* renamed from: i */
    public ContractPositionEventResponse h(String str) {
        return (ContractPositionEventResponse) JSON.parseObject(str, ContractPositionEventResponse.class);
    }
}
