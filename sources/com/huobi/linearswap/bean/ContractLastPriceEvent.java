package com.huobi.linearswap.bean;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import java.io.Serializable;

public class ContractLastPriceEvent implements Serializable {
    private static final long serialVersionUID = 2630663472834462999L;
    private double buyFirstPrice;
    private double lastPriceNew;
    private LinearSwapAccountInfo linearSwapAccountInfo;
    private double sellFirstPrice;

    public ContractLastPriceEvent(double d11, double d12, double d13, LinearSwapAccountInfo linearSwapAccountInfo2) {
        this.lastPriceNew = d11;
        this.buyFirstPrice = d12;
        this.sellFirstPrice = d13;
        this.linearSwapAccountInfo = linearSwapAccountInfo2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ContractLastPriceEvent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractLastPriceEvent)) {
            return false;
        }
        ContractLastPriceEvent contractLastPriceEvent = (ContractLastPriceEvent) obj;
        if (!contractLastPriceEvent.canEqual(this) || Double.compare(getLastPriceNew(), contractLastPriceEvent.getLastPriceNew()) != 0 || Double.compare(getBuyFirstPrice(), contractLastPriceEvent.getBuyFirstPrice()) != 0 || Double.compare(getSellFirstPrice(), contractLastPriceEvent.getSellFirstPrice()) != 0) {
            return false;
        }
        LinearSwapAccountInfo linearSwapAccountInfo2 = getLinearSwapAccountInfo();
        LinearSwapAccountInfo linearSwapAccountInfo3 = contractLastPriceEvent.getLinearSwapAccountInfo();
        return linearSwapAccountInfo2 != null ? linearSwapAccountInfo2.equals(linearSwapAccountInfo3) : linearSwapAccountInfo3 == null;
    }

    public double getBuyFirstPrice() {
        return this.buyFirstPrice;
    }

    public double getLastPriceNew() {
        return this.lastPriceNew;
    }

    public LinearSwapAccountInfo getLinearSwapAccountInfo() {
        return this.linearSwapAccountInfo;
    }

    public double getSellFirstPrice() {
        return this.sellFirstPrice;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(getLastPriceNew());
        long doubleToLongBits2 = Double.doubleToLongBits(getBuyFirstPrice());
        int i11 = ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 59) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(getSellFirstPrice());
        LinearSwapAccountInfo linearSwapAccountInfo2 = getLinearSwapAccountInfo();
        return (((i11 * 59) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3))) * 59) + (linearSwapAccountInfo2 == null ? 43 : linearSwapAccountInfo2.hashCode());
    }

    public void setBuyFirstPrice(double d11) {
        this.buyFirstPrice = d11;
    }

    public void setLastPriceNew(double d11) {
        this.lastPriceNew = d11;
    }

    public void setLinearSwapAccountInfo(LinearSwapAccountInfo linearSwapAccountInfo2) {
        this.linearSwapAccountInfo = linearSwapAccountInfo2;
    }

    public void setSellFirstPrice(double d11) {
        this.sellFirstPrice = d11;
    }

    public String toString() {
        return "ContractLastPriceEvent(lastPriceNew=" + getLastPriceNew() + ", buyFirstPrice=" + getBuyFirstPrice() + ", sellFirstPrice=" + getSellFirstPrice() + ", linearSwapAccountInfo=" + getLinearSwapAccountInfo() + ")";
    }
}
