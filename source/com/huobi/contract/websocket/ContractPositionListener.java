package com.huobi.contract.websocket;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class ContractPositionListener extends BaseResponseMarketListener<ContractPositionResponse> {
    /* renamed from: i */
    public ContractPositionResponse h(String str) {
        return (ContractPositionResponse) JSON.parseObject(str, ContractPositionResponse.class);
    }
}
