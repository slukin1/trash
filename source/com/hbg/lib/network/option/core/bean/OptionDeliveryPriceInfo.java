package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionDeliveryPriceInfo implements Serializable {
    private static final long serialVersionUID = 7961532336761266315L;
    @SerializedName("delivery_price")
    private String deliveryPrice;
    private String symbol;
    @SerializedName("trade_partition")
    private String tradePartition;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionDeliveryPriceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionDeliveryPriceInfo)) {
            return false;
        }
        OptionDeliveryPriceInfo optionDeliveryPriceInfo = (OptionDeliveryPriceInfo) obj;
        if (!optionDeliveryPriceInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionDeliveryPriceInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = optionDeliveryPriceInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String deliveryPrice2 = getDeliveryPrice();
        String deliveryPrice3 = optionDeliveryPriceInfo.getDeliveryPrice();
        return deliveryPrice2 != null ? deliveryPrice2.equals(deliveryPrice3) : deliveryPrice3 == null;
    }

    public String getDeliveryPrice() {
        return this.deliveryPrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String tradePartition2 = getTradePartition();
        int hashCode2 = ((hashCode + 59) * 59) + (tradePartition2 == null ? 43 : tradePartition2.hashCode());
        String deliveryPrice2 = getDeliveryPrice();
        int i12 = hashCode2 * 59;
        if (deliveryPrice2 != null) {
            i11 = deliveryPrice2.hashCode();
        }
        return i12 + i11;
    }

    public void setDeliveryPrice(String str) {
        this.deliveryPrice = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public String toString() {
        return "OptionDeliveryPriceInfo(symbol=" + getSymbol() + ", tradePartition=" + getTradePartition() + ", deliveryPrice=" + getDeliveryPrice() + ")";
    }
}
