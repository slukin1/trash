package com.huobi.contract.websocket;

import com.hbg.lib.network.pro.socket.response.BaseContractPositionResponse;
import com.hbg.lib.network.swap.core.bean.SwapPosition;

public class SwapPositionResponse extends BaseContractPositionResponse<SwapPosition> {
    public boolean canEqual(Object obj) {
        return obj instanceof SwapPositionResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof SwapPositionResponse) && ((SwapPositionResponse) obj).canEqual(this) && super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "SwapPositionResponse()";
    }
}
