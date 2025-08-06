package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import com.huobi.contract.viewhandler.ContractOrderRspInfoHandler;
import java.io.Serializable;
import s9.a;

public class ContractOrderDetailInfo implements Serializable, a {
    private static final long serialVersionUID = -5770121365834751549L;
    private transient String contractCode;
    private transient String contractFace;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("trade_fee")
    private String fee;
    @SerializedName("order_id")
    private Long orderId;
    private String orderPriceTypeStr;
    private transient String price;
    private String role;
    private transient String symbol;
    @SerializedName("trade_price")
    private String tradePrice;
    @SerializedName("trade_turnover")
    private String tradeTurnover;
    @SerializedName("trade_volume")
    private String tradeVolume;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractOrderDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractOrderDetailInfo)) {
            return false;
        }
        ContractOrderDetailInfo contractOrderDetailInfo = (ContractOrderDetailInfo) obj;
        if (!contractOrderDetailInfo.canEqual(this)) {
            return false;
        }
        Long orderId2 = getOrderId();
        Long orderId3 = contractOrderDetailInfo.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String tradeVolume2 = getTradeVolume();
        String tradeVolume3 = contractOrderDetailInfo.getTradeVolume();
        if (tradeVolume2 != null ? !tradeVolume2.equals(tradeVolume3) : tradeVolume3 != null) {
            return false;
        }
        String tradePrice2 = getTradePrice();
        String tradePrice3 = contractOrderDetailInfo.getTradePrice();
        if (tradePrice2 != null ? !tradePrice2.equals(tradePrice3) : tradePrice3 != null) {
            return false;
        }
        String fee2 = getFee();
        String fee3 = contractOrderDetailInfo.getFee();
        if (fee2 != null ? !fee2.equals(fee3) : fee3 != null) {
            return false;
        }
        String tradeTurnover2 = getTradeTurnover();
        String tradeTurnover3 = contractOrderDetailInfo.getTradeTurnover();
        if (tradeTurnover2 != null ? !tradeTurnover2.equals(tradeTurnover3) : tradeTurnover3 != null) {
            return false;
        }
        if (getCreatedAt() != contractOrderDetailInfo.getCreatedAt()) {
            return false;
        }
        String role2 = getRole();
        String role3 = contractOrderDetailInfo.getRole();
        if (role2 != null ? !role2.equals(role3) : role3 != null) {
            return false;
        }
        String orderPriceTypeStr2 = getOrderPriceTypeStr();
        String orderPriceTypeStr3 = contractOrderDetailInfo.getOrderPriceTypeStr();
        return orderPriceTypeStr2 != null ? orderPriceTypeStr2.equals(orderPriceTypeStr3) : orderPriceTypeStr3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractFace() {
        return this.contractFace;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getFee() {
        return this.fee;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public String getOrderPriceTypeStr() {
        return this.orderPriceTypeStr;
    }

    public String getPrice() {
        return this.price;
    }

    public String getRole() {
        return this.role;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradePrice() {
        return this.tradePrice;
    }

    public String getTradeTurnover() {
        return this.tradeTurnover;
    }

    public String getTradeVolume() {
        return this.tradeVolume;
    }

    public String getViewHandlerName() {
        return ContractOrderRspInfoHandler.class.getName();
    }

    public int hashCode() {
        Long orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = orderId2 == null ? 43 : orderId2.hashCode();
        String tradeVolume2 = getTradeVolume();
        int hashCode2 = ((hashCode + 59) * 59) + (tradeVolume2 == null ? 43 : tradeVolume2.hashCode());
        String tradePrice2 = getTradePrice();
        int hashCode3 = (hashCode2 * 59) + (tradePrice2 == null ? 43 : tradePrice2.hashCode());
        String fee2 = getFee();
        int hashCode4 = (hashCode3 * 59) + (fee2 == null ? 43 : fee2.hashCode());
        String tradeTurnover2 = getTradeTurnover();
        int hashCode5 = (hashCode4 * 59) + (tradeTurnover2 == null ? 43 : tradeTurnover2.hashCode());
        long createdAt2 = getCreatedAt();
        int i12 = (hashCode5 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        String role2 = getRole();
        int hashCode6 = (i12 * 59) + (role2 == null ? 43 : role2.hashCode());
        String orderPriceTypeStr2 = getOrderPriceTypeStr();
        int i13 = hashCode6 * 59;
        if (orderPriceTypeStr2 != null) {
            i11 = orderPriceTypeStr2.hashCode();
        }
        return i13 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractFace(String str) {
        this.contractFace = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setOrderId(Long l11) {
        this.orderId = l11;
    }

    public void setOrderPriceTypeStr(String str) {
        this.orderPriceTypeStr = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradePrice(String str) {
        this.tradePrice = str;
    }

    public void setTradeTurnover(String str) {
        this.tradeTurnover = str;
    }

    public void setTradeVolume(String str) {
        this.tradeVolume = str;
    }

    public String toString() {
        return "ContractOrderDetailInfo(symbol=" + getSymbol() + ", price=" + getPrice() + ", contractFace=" + getContractFace() + ", contractCode=" + getContractCode() + ", orderId=" + getOrderId() + ", tradeVolume=" + getTradeVolume() + ", tradePrice=" + getTradePrice() + ", fee=" + getFee() + ", tradeTurnover=" + getTradeTurnover() + ", createdAt=" + getCreatedAt() + ", role=" + getRole() + ", orderPriceTypeStr=" + getOrderPriceTypeStr() + ")";
    }
}
