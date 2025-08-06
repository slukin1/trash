package com.huobi.contract.websocket;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.pro.socket.response.BaseContractPositionResponse;

public class LinearSwapPositionResponse extends BaseContractPositionResponse<LinearSwapPosition> {
    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapPositionResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LinearSwapPositionResponse) && ((LinearSwapPositionResponse) obj).canEqual(this) && super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "LinearSwapPositionResponse()";
    }
}
