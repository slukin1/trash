package com.huobi.linearswap.bean;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import java.io.Serializable;

public class ContractPositionEvent implements Serializable {
    private static final long serialVersionUID = 2630663472834462999L;
    private LinearSwapPosition contractPosition;

    public ContractPositionEvent(LinearSwapPosition linearSwapPosition) {
        this.contractPosition = linearSwapPosition;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ContractPositionEvent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractPositionEvent)) {
            return false;
        }
        ContractPositionEvent contractPositionEvent = (ContractPositionEvent) obj;
        if (!contractPositionEvent.canEqual(this)) {
            return false;
        }
        LinearSwapPosition contractPosition2 = getContractPosition();
        LinearSwapPosition contractPosition3 = contractPositionEvent.getContractPosition();
        return contractPosition2 != null ? contractPosition2.equals(contractPosition3) : contractPosition3 == null;
    }

    public LinearSwapPosition getContractPosition() {
        return this.contractPosition;
    }

    public int hashCode() {
        LinearSwapPosition contractPosition2 = getContractPosition();
        return 59 + (contractPosition2 == null ? 43 : contractPosition2.hashCode());
    }

    public void setContractPosition(LinearSwapPosition linearSwapPosition) {
        this.contractPosition = linearSwapPosition;
    }

    public String toString() {
        return "ContractPositionEvent(contractPosition=" + getContractPosition() + ")";
    }
}
