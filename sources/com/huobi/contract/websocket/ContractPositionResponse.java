package com.huobi.contract.websocket;

import com.hbg.lib.network.pro.socket.response.BaseContractPositionResponse;
import com.huobi.contract.entity.ContractPosition;

public class ContractPositionResponse extends BaseContractPositionResponse<ContractPosition> {
    public boolean canEqual(Object obj) {
        return obj instanceof ContractPositionResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof ContractPositionResponse) && ((ContractPositionResponse) obj).canEqual(this) && super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "ContractPositionResponse()";
    }
}
