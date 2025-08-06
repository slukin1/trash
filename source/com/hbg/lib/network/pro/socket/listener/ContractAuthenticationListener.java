package com.hbg.lib.network.pro.socket.listener;

import com.alibaba.fastjson.JSON;
import com.hbg.lib.network.pro.socket.response.ContractAuthenticationResponse;
import com.hbg.lib.network.retrofit.websocket.callback.BaseResponseMarketListener;

public abstract class ContractAuthenticationListener extends BaseResponseMarketListener<ContractAuthenticationResponse> {
    /* renamed from: i */
    public ContractAuthenticationResponse h(String str) {
        return (ContractAuthenticationResponse) JSON.parseObject(str, ContractAuthenticationResponse.class);
    }
}
