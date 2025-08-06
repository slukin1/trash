package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ContractTpSlRelationOrder implements Serializable {
    private static final long serialVersionUID = -9127103559263970967L;
    @SerializedName("canceled_at")
    private long canceledAt;
    @SerializedName("client_order_id")
    private long clientOrderId;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("created_at")
    private long createdAt;
    private String direction;
    private String fee;
    @SerializedName("fee_asset")
    private String feeAsset;
    @SerializedName("lever_rate")
    private String leverRate;
    @SerializedName("margin_frozen")
    private String marginFrozen;
    private String offset;
    @SerializedName("order_id")
    private long orderId;
    @SerializedName("order_id_str")
    private String orderIdStr;
    @SerializedName("order_price_type")
    private String orderPriceType;
    @SerializedName("order_source")
    private String orderSource;
    @SerializedName("order_type")
    private int orderType;
    private String price;
    private String profit;
    private int status;
    private String symbol;
    @SerializedName("tpsl_order_info")
    public List<ContractTpSlOrder> tpSlOrderInfo;
    @SerializedName("trade_avg_price")
    private String tradeAvgPrice;
    @SerializedName("trade_turnover")
    private String tradeTurnover;
    @SerializedName("trade_volume")
    private String tradeVolume;
    private int volume;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractTpSlRelationOrder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractTpSlRelationOrder)) {
            return false;
        }
        ContractTpSlRelationOrder contractTpSlRelationOrder = (ContractTpSlRelationOrder) obj;
        if (!contractTpSlRelationOrder.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractTpSlRelationOrder.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractTpSlRelationOrder.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractTpSlRelationOrder.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        if (getVolume() != contractTpSlRelationOrder.getVolume()) {
            return false;
        }
        String price2 = getPrice();
        String price3 = contractTpSlRelationOrder.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = contractTpSlRelationOrder.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = contractTpSlRelationOrder.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = contractTpSlRelationOrder.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        String leverRate2 = getLeverRate();
        String leverRate3 = contractTpSlRelationOrder.getLeverRate();
        if (leverRate2 != null ? !leverRate2.equals(leverRate3) : leverRate3 != null) {
            return false;
        }
        if (getOrderId() != contractTpSlRelationOrder.getOrderId()) {
            return false;
        }
        String orderIdStr2 = getOrderIdStr();
        String orderIdStr3 = contractTpSlRelationOrder.getOrderIdStr();
        if (orderIdStr2 != null ? !orderIdStr2.equals(orderIdStr3) : orderIdStr3 != null) {
            return false;
        }
        if (getClientOrderId() != contractTpSlRelationOrder.getClientOrderId() || getCreatedAt() != contractTpSlRelationOrder.getCreatedAt()) {
            return false;
        }
        String tradeVolume2 = getTradeVolume();
        String tradeVolume3 = contractTpSlRelationOrder.getTradeVolume();
        if (tradeVolume2 != null ? !tradeVolume2.equals(tradeVolume3) : tradeVolume3 != null) {
            return false;
        }
        String tradeTurnover2 = getTradeTurnover();
        String tradeTurnover3 = contractTpSlRelationOrder.getTradeTurnover();
        if (tradeTurnover2 != null ? !tradeTurnover2.equals(tradeTurnover3) : tradeTurnover3 != null) {
            return false;
        }
        String fee2 = getFee();
        String fee3 = contractTpSlRelationOrder.getFee();
        if (fee2 != null ? !fee2.equals(fee3) : fee3 != null) {
            return false;
        }
        String tradeAvgPrice2 = getTradeAvgPrice();
        String tradeAvgPrice3 = contractTpSlRelationOrder.getTradeAvgPrice();
        if (tradeAvgPrice2 != null ? !tradeAvgPrice2.equals(tradeAvgPrice3) : tradeAvgPrice3 != null) {
            return false;
        }
        String marginFrozen2 = getMarginFrozen();
        String marginFrozen3 = contractTpSlRelationOrder.getMarginFrozen();
        if (marginFrozen2 != null ? !marginFrozen2.equals(marginFrozen3) : marginFrozen3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = contractTpSlRelationOrder.getProfit();
        if (profit2 != null ? !profit2.equals(profit3) : profit3 != null) {
            return false;
        }
        if (getStatus() != contractTpSlRelationOrder.getStatus() || getOrderType() != contractTpSlRelationOrder.getOrderType()) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = contractTpSlRelationOrder.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        String feeAsset2 = getFeeAsset();
        String feeAsset3 = contractTpSlRelationOrder.getFeeAsset();
        if (feeAsset2 != null ? !feeAsset2.equals(feeAsset3) : feeAsset3 != null) {
            return false;
        }
        if (getCanceledAt() != contractTpSlRelationOrder.getCanceledAt()) {
            return false;
        }
        List<ContractTpSlOrder> tpSlOrderInfo2 = getTpSlOrderInfo();
        List<ContractTpSlOrder> tpSlOrderInfo3 = contractTpSlRelationOrder.getTpSlOrderInfo();
        return tpSlOrderInfo2 != null ? tpSlOrderInfo2.equals(tpSlOrderInfo3) : tpSlOrderInfo3 == null;
    }

    public long getCanceledAt() {
        return this.canceledAt;
    }

    public long getClientOrderId() {
        return this.clientOrderId;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getFee() {
        return this.fee;
    }

    public String getFeeAsset() {
        return this.feeAsset;
    }

    public String getLeverRate() {
        return this.leverRate;
    }

    public String getMarginFrozen() {
        return this.marginFrozen;
    }

    public String getOffset() {
        return this.offset;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public String getOrderIdStr() {
        return this.orderIdStr;
    }

    public String getOrderPriceType() {
        return this.orderPriceType;
    }

    public String getOrderSource() {
        return this.orderSource;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public String getPrice() {
        return this.price;
    }

    public String getProfit() {
        return this.profit;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public List<ContractTpSlOrder> getTpSlOrderInfo() {
        return this.tpSlOrderInfo;
    }

    public String getTradeAvgPrice() {
        return this.tradeAvgPrice;
    }

    public String getTradeTurnover() {
        return this.tradeTurnover;
    }

    public String getTradeVolume() {
        return this.tradeVolume;
    }

    public int getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String contractType2 = getContractType();
        int hashCode3 = (((hashCode2 * 59) + (contractType2 == null ? 43 : contractType2.hashCode())) * 59) + getVolume();
        String price2 = getPrice();
        int hashCode4 = (hashCode3 * 59) + (price2 == null ? 43 : price2.hashCode());
        String orderPriceType2 = getOrderPriceType();
        int hashCode5 = (hashCode4 * 59) + (orderPriceType2 == null ? 43 : orderPriceType2.hashCode());
        String direction2 = getDirection();
        int hashCode6 = (hashCode5 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String offset2 = getOffset();
        int hashCode7 = (hashCode6 * 59) + (offset2 == null ? 43 : offset2.hashCode());
        String leverRate2 = getLeverRate();
        int hashCode8 = (hashCode7 * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode());
        long orderId2 = getOrderId();
        int i12 = (hashCode8 * 59) + ((int) (orderId2 ^ (orderId2 >>> 32)));
        String orderIdStr2 = getOrderIdStr();
        int hashCode9 = (i12 * 59) + (orderIdStr2 == null ? 43 : orderIdStr2.hashCode());
        long clientOrderId2 = getClientOrderId();
        int i13 = (hashCode9 * 59) + ((int) (clientOrderId2 ^ (clientOrderId2 >>> 32)));
        long createdAt2 = getCreatedAt();
        int i14 = (i13 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        String tradeVolume2 = getTradeVolume();
        int hashCode10 = (i14 * 59) + (tradeVolume2 == null ? 43 : tradeVolume2.hashCode());
        String tradeTurnover2 = getTradeTurnover();
        int hashCode11 = (hashCode10 * 59) + (tradeTurnover2 == null ? 43 : tradeTurnover2.hashCode());
        String fee2 = getFee();
        int hashCode12 = (hashCode11 * 59) + (fee2 == null ? 43 : fee2.hashCode());
        String tradeAvgPrice2 = getTradeAvgPrice();
        int hashCode13 = (hashCode12 * 59) + (tradeAvgPrice2 == null ? 43 : tradeAvgPrice2.hashCode());
        String marginFrozen2 = getMarginFrozen();
        int hashCode14 = (hashCode13 * 59) + (marginFrozen2 == null ? 43 : marginFrozen2.hashCode());
        String profit2 = getProfit();
        int hashCode15 = (((((hashCode14 * 59) + (profit2 == null ? 43 : profit2.hashCode())) * 59) + getStatus()) * 59) + getOrderType();
        String orderSource2 = getOrderSource();
        int hashCode16 = (hashCode15 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        String feeAsset2 = getFeeAsset();
        int hashCode17 = (hashCode16 * 59) + (feeAsset2 == null ? 43 : feeAsset2.hashCode());
        long canceledAt2 = getCanceledAt();
        int i15 = (hashCode17 * 59) + ((int) (canceledAt2 ^ (canceledAt2 >>> 32)));
        List<ContractTpSlOrder> tpSlOrderInfo2 = getTpSlOrderInfo();
        int i16 = i15 * 59;
        if (tpSlOrderInfo2 != null) {
            i11 = tpSlOrderInfo2.hashCode();
        }
        return i16 + i11;
    }

    public void setCanceledAt(long j11) {
        this.canceledAt = j11;
    }

    public void setClientOrderId(long j11) {
        this.clientOrderId = j11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setFeeAsset(String str) {
        this.feeAsset = str;
    }

    public void setLeverRate(String str) {
        this.leverRate = str;
    }

    public void setMarginFrozen(String str) {
        this.marginFrozen = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setOrderIdStr(String str) {
        this.orderIdStr = str;
    }

    public void setOrderPriceType(String str) {
        this.orderPriceType = str;
    }

    public void setOrderSource(String str) {
        this.orderSource = str;
    }

    public void setOrderType(int i11) {
        this.orderType = i11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTpSlOrderInfo(List<ContractTpSlOrder> list) {
        this.tpSlOrderInfo = list;
    }

    public void setTradeAvgPrice(String str) {
        this.tradeAvgPrice = str;
    }

    public void setTradeTurnover(String str) {
        this.tradeTurnover = str;
    }

    public void setTradeVolume(String str) {
        this.tradeVolume = str;
    }

    public void setVolume(int i11) {
        this.volume = i11;
    }

    public String toString() {
        return "ContractTpSlRelationOrder(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", volume=" + getVolume() + ", price=" + getPrice() + ", orderPriceType=" + getOrderPriceType() + ", direction=" + getDirection() + ", offset=" + getOffset() + ", leverRate=" + getLeverRate() + ", orderId=" + getOrderId() + ", orderIdStr=" + getOrderIdStr() + ", clientOrderId=" + getClientOrderId() + ", createdAt=" + getCreatedAt() + ", tradeVolume=" + getTradeVolume() + ", tradeTurnover=" + getTradeTurnover() + ", fee=" + getFee() + ", tradeAvgPrice=" + getTradeAvgPrice() + ", marginFrozen=" + getMarginFrozen() + ", profit=" + getProfit() + ", status=" + getStatus() + ", orderType=" + getOrderType() + ", orderSource=" + getOrderSource() + ", feeAsset=" + getFeeAsset() + ", canceledAt=" + getCanceledAt() + ", tpSlOrderInfo=" + getTpSlOrderInfo() + ")";
    }
}
