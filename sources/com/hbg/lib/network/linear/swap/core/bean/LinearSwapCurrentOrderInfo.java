package com.hbg.lib.network.linear.swap.core.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class LinearSwapCurrentOrderInfo implements Serializable {
    public static final String DELIVERY = "settlement";
    public static final String EXPLOSE = "risk";
    public static final String ORDER_DIRECTION_BUY = "buy";
    public static final String ORDER_DIRECTION_SELL = "sell";
    public static final String ORDER_OFFSET_CLOSE = "close";
    public static final String ORDER_OFFSET_OPEN = "open";
    public static final String ORDER_OFFSET_SINGLE_SIDE = "both";
    public static final String ORDER_SOURCE = "grid";
    public static final String ORDER_SOURCE_1 = "grid_end";
    private static final long serialVersionUID = 3700023261204599385L;
    @SerializedName("client_order_id")
    private Long clientOrderId;
    @SerializedName("contract_code")
    private String contractCode;
    private transient String contractFace;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("created_time")
    private String createTime;
    @SerializedName("created_at")
    private Long createdAt;
    private String direction;
    private String fee;
    @SerializedName("fee_amount")
    private String feeAmount;
    @SerializedName("fee_asset")
    private String feeAsset;
    @SerializedName("is_tpsl")
    private int isTpsl;
    @SerializedName("lever_rate")
    private Integer leverRate;
    @SerializedName("margin_frozen")
    private String marginFrozen;
    @SerializedName("margin_mode")
    private String marginMode;
    private String offset;
    @SerializedName("order_id")
    private Long orderId;
    @SerializedName("order_price_type")
    private String orderPriceType;
    @SerializedName("order_source")
    private String orderSource;
    @SerializedName("order_type")
    private int orderType;
    @SerializedName("position_side")
    private String positionSide;
    private String price;
    @SerializedName("price_match")
    private String priceMatch;
    private String profit;
    private String side;
    private String status;
    private String symbol;
    @SerializedName("time_in_force")
    private String timeInForce;
    @SerializedName("trade_avg_price")
    private String tradeAvgPrice;
    @SerializedName("trade_turnover")
    private String tradeTurnover;
    @SerializedName("trade_volume")
    private String tradeVolume;
    @SerializedName("type")
    private String type;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapCurrentOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapCurrentOrderInfo)) {
            return false;
        }
        LinearSwapCurrentOrderInfo linearSwapCurrentOrderInfo = (LinearSwapCurrentOrderInfo) obj;
        if (!linearSwapCurrentOrderInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = linearSwapCurrentOrderInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = linearSwapCurrentOrderInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapCurrentOrderInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = linearSwapCurrentOrderInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = linearSwapCurrentOrderInfo.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = linearSwapCurrentOrderInfo.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = linearSwapCurrentOrderInfo.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String priceMatch2 = getPriceMatch();
        String priceMatch3 = linearSwapCurrentOrderInfo.getPriceMatch();
        if (priceMatch2 != null ? !priceMatch2.equals(priceMatch3) : priceMatch3 != null) {
            return false;
        }
        String timeInForce2 = getTimeInForce();
        String timeInForce3 = linearSwapCurrentOrderInfo.getTimeInForce();
        if (timeInForce2 != null ? !timeInForce2.equals(timeInForce3) : timeInForce3 != null) {
            return false;
        }
        String direction2 = getDirection();
        String direction3 = linearSwapCurrentOrderInfo.getDirection();
        if (direction2 != null ? !direction2.equals(direction3) : direction3 != null) {
            return false;
        }
        String side2 = getSide();
        String side3 = linearSwapCurrentOrderInfo.getSide();
        if (side2 != null ? !side2.equals(side3) : side3 != null) {
            return false;
        }
        String positionSide2 = getPositionSide();
        String positionSide3 = linearSwapCurrentOrderInfo.getPositionSide();
        if (positionSide2 != null ? !positionSide2.equals(positionSide3) : positionSide3 != null) {
            return false;
        }
        String offset2 = getOffset();
        String offset3 = linearSwapCurrentOrderInfo.getOffset();
        if (offset2 != null ? !offset2.equals(offset3) : offset3 != null) {
            return false;
        }
        Integer leverRate2 = getLeverRate();
        Integer leverRate3 = linearSwapCurrentOrderInfo.getLeverRate();
        if (leverRate2 != null ? !leverRate2.equals(leverRate3) : leverRate3 != null) {
            return false;
        }
        if (getOrderType() != linearSwapCurrentOrderInfo.getOrderType()) {
            return false;
        }
        Long orderId2 = getOrderId();
        Long orderId3 = linearSwapCurrentOrderInfo.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        Long clientOrderId2 = getClientOrderId();
        Long clientOrderId3 = linearSwapCurrentOrderInfo.getClientOrderId();
        if (clientOrderId2 != null ? !clientOrderId2.equals(clientOrderId3) : clientOrderId3 != null) {
            return false;
        }
        String orderSource2 = getOrderSource();
        String orderSource3 = linearSwapCurrentOrderInfo.getOrderSource();
        if (orderSource2 != null ? !orderSource2.equals(orderSource3) : orderSource3 != null) {
            return false;
        }
        Long createdAt2 = getCreatedAt();
        Long createdAt3 = linearSwapCurrentOrderInfo.getCreatedAt();
        if (createdAt2 != null ? !createdAt2.equals(createdAt3) : createdAt3 != null) {
            return false;
        }
        if (getCreateTime() != linearSwapCurrentOrderInfo.getCreateTime()) {
            return false;
        }
        String tradeVolume2 = getTradeVolume();
        String tradeVolume3 = linearSwapCurrentOrderInfo.getTradeVolume();
        if (tradeVolume2 != null ? !tradeVolume2.equals(tradeVolume3) : tradeVolume3 != null) {
            return false;
        }
        String tradeTurnover2 = getTradeTurnover();
        String tradeTurnover3 = linearSwapCurrentOrderInfo.getTradeTurnover();
        if (tradeTurnover2 != null ? !tradeTurnover2.equals(tradeTurnover3) : tradeTurnover3 != null) {
            return false;
        }
        String fee2 = getFee();
        String fee3 = linearSwapCurrentOrderInfo.getFee();
        if (fee2 != null ? !fee2.equals(fee3) : fee3 != null) {
            return false;
        }
        String feeAsset2 = getFeeAsset();
        String feeAsset3 = linearSwapCurrentOrderInfo.getFeeAsset();
        if (feeAsset2 != null ? !feeAsset2.equals(feeAsset3) : feeAsset3 != null) {
            return false;
        }
        String feeAmount2 = getFeeAmount();
        String feeAmount3 = linearSwapCurrentOrderInfo.getFeeAmount();
        if (feeAmount2 != null ? !feeAmount2.equals(feeAmount3) : feeAmount3 != null) {
            return false;
        }
        String tradeAvgPrice2 = getTradeAvgPrice();
        String tradeAvgPrice3 = linearSwapCurrentOrderInfo.getTradeAvgPrice();
        if (tradeAvgPrice2 != null ? !tradeAvgPrice2.equals(tradeAvgPrice3) : tradeAvgPrice3 != null) {
            return false;
        }
        String marginFrozen2 = getMarginFrozen();
        String marginFrozen3 = linearSwapCurrentOrderInfo.getMarginFrozen();
        if (marginFrozen2 != null ? !marginFrozen2.equals(marginFrozen3) : marginFrozen3 != null) {
            return false;
        }
        String profit2 = getProfit();
        String profit3 = linearSwapCurrentOrderInfo.getProfit();
        if (profit2 != null ? !profit2.equals(profit3) : profit3 != null) {
            return false;
        }
        String status2 = getStatus();
        String status3 = linearSwapCurrentOrderInfo.getStatus();
        if (status2 != null ? !status2.equals(status3) : status3 != null) {
            return false;
        }
        if (getIsTpsl() != linearSwapCurrentOrderInfo.getIsTpsl()) {
            return false;
        }
        String marginMode2 = getMarginMode();
        String marginMode3 = linearSwapCurrentOrderInfo.getMarginMode();
        return marginMode2 != null ? marginMode2.equals(marginMode3) : marginMode3 == null;
    }

    public String getBuyOrSell() {
        String str = this.direction;
        if (str == null || str.isEmpty()) {
            return this.side;
        }
        return this.direction;
    }

    public Long getClientOrderId() {
        return this.clientOrderId;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractFace() {
        return this.contractFace;
    }

    public String getContractType() {
        return this.contractType;
    }

    public long getCreateTime() {
        Long l11 = this.createdAt;
        if (l11 != null && l11.longValue() > 0) {
            return this.createdAt.longValue();
        }
        try {
            String str = this.createTime;
            if (str != null) {
                return Long.parseLong(str);
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getFee() {
        return this.fee;
    }

    public String getFeeAmount() {
        return this.feeAmount;
    }

    public String getFeeAsset() {
        return this.feeAsset;
    }

    public String getFeeUnit() {
        String str = this.feeAsset;
        return (str == null || str.isEmpty()) ? "USDT" : this.feeAsset;
    }

    public int getIsTpsl() {
        return this.isTpsl;
    }

    public Integer getLeverRate() {
        return this.leverRate;
    }

    public String getMarginFrozen() {
        return this.marginFrozen;
    }

    public String getMarginMode() {
        return this.marginMode;
    }

    public String getOffset() {
        if (!SPUtil.j()) {
            return this.offset;
        }
        if (TextUtils.equals(this.positionSide, "long") && TextUtils.equals(this.side, "buy")) {
            return "open";
        }
        if (TextUtils.equals(this.positionSide, "short") && TextUtils.equals(this.side, "sell")) {
            return "open";
        }
        if (!TextUtils.equals(this.positionSide, "long") || !TextUtils.equals(this.side, "sell")) {
            return (!TextUtils.equals(this.positionSide, "short") || !TextUtils.equals(this.side, "buy")) ? ORDER_OFFSET_SINGLE_SIDE : "close";
        }
        return "close";
    }

    public Long getOrderId() {
        return this.orderId;
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

    public String getPositionSide() {
        return this.positionSide;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPriceMatch() {
        return this.priceMatch;
    }

    public String getProfit() {
        return this.profit;
    }

    public String getSide() {
        return this.side;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTimeInForce() {
        return this.timeInForce;
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

    public String getType() {
        return this.type;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractType2 = getContractType();
        int hashCode2 = ((hashCode + 59) * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode3 = (hashCode2 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String volume2 = getVolume();
        int hashCode4 = (hashCode3 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String price2 = getPrice();
        int hashCode5 = (hashCode4 * 59) + (price2 == null ? 43 : price2.hashCode());
        String orderPriceType2 = getOrderPriceType();
        int hashCode6 = (hashCode5 * 59) + (orderPriceType2 == null ? 43 : orderPriceType2.hashCode());
        String type2 = getType();
        int hashCode7 = (hashCode6 * 59) + (type2 == null ? 43 : type2.hashCode());
        String priceMatch2 = getPriceMatch();
        int hashCode8 = (hashCode7 * 59) + (priceMatch2 == null ? 43 : priceMatch2.hashCode());
        String timeInForce2 = getTimeInForce();
        int hashCode9 = (hashCode8 * 59) + (timeInForce2 == null ? 43 : timeInForce2.hashCode());
        String direction2 = getDirection();
        int hashCode10 = (hashCode9 * 59) + (direction2 == null ? 43 : direction2.hashCode());
        String side2 = getSide();
        int hashCode11 = (hashCode10 * 59) + (side2 == null ? 43 : side2.hashCode());
        String positionSide2 = getPositionSide();
        int hashCode12 = (hashCode11 * 59) + (positionSide2 == null ? 43 : positionSide2.hashCode());
        String offset2 = getOffset();
        int hashCode13 = (hashCode12 * 59) + (offset2 == null ? 43 : offset2.hashCode());
        Integer leverRate2 = getLeverRate();
        int hashCode14 = (((hashCode13 * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode())) * 59) + getOrderType();
        Long orderId2 = getOrderId();
        int hashCode15 = (hashCode14 * 59) + (orderId2 == null ? 43 : orderId2.hashCode());
        Long clientOrderId2 = getClientOrderId();
        int hashCode16 = (hashCode15 * 59) + (clientOrderId2 == null ? 43 : clientOrderId2.hashCode());
        String orderSource2 = getOrderSource();
        int hashCode17 = (hashCode16 * 59) + (orderSource2 == null ? 43 : orderSource2.hashCode());
        Long createdAt2 = getCreatedAt();
        int hashCode18 = (hashCode17 * 59) + (createdAt2 == null ? 43 : createdAt2.hashCode());
        long createTime2 = getCreateTime();
        int i12 = (hashCode18 * 59) + ((int) (createTime2 ^ (createTime2 >>> 32)));
        String tradeVolume2 = getTradeVolume();
        int hashCode19 = (i12 * 59) + (tradeVolume2 == null ? 43 : tradeVolume2.hashCode());
        String tradeTurnover2 = getTradeTurnover();
        int hashCode20 = (hashCode19 * 59) + (tradeTurnover2 == null ? 43 : tradeTurnover2.hashCode());
        String fee2 = getFee();
        int hashCode21 = (hashCode20 * 59) + (fee2 == null ? 43 : fee2.hashCode());
        String feeAsset2 = getFeeAsset();
        int hashCode22 = (hashCode21 * 59) + (feeAsset2 == null ? 43 : feeAsset2.hashCode());
        String feeAmount2 = getFeeAmount();
        int hashCode23 = (hashCode22 * 59) + (feeAmount2 == null ? 43 : feeAmount2.hashCode());
        String tradeAvgPrice2 = getTradeAvgPrice();
        int hashCode24 = (hashCode23 * 59) + (tradeAvgPrice2 == null ? 43 : tradeAvgPrice2.hashCode());
        String marginFrozen2 = getMarginFrozen();
        int hashCode25 = (hashCode24 * 59) + (marginFrozen2 == null ? 43 : marginFrozen2.hashCode());
        String profit2 = getProfit();
        int hashCode26 = (hashCode25 * 59) + (profit2 == null ? 43 : profit2.hashCode());
        String status2 = getStatus();
        int hashCode27 = (((hashCode26 * 59) + (status2 == null ? 43 : status2.hashCode())) * 59) + getIsTpsl();
        String marginMode2 = getMarginMode();
        int i13 = hashCode27 * 59;
        if (marginMode2 != null) {
            i11 = marginMode2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isBuy() {
        return "buy".equals(getBuyOrSell());
    }

    public boolean isDelivery() {
        return "settlement".equals(getOrderSource());
    }

    public boolean isExplose() {
        return "risk".equals(getOrderSource());
    }

    public boolean isGrid() {
        return this.orderSource.equals("grid") || this.orderSource.equals("grid_end");
    }

    public boolean isHideCancelAndEdit() {
        return PrimeRounds.ROUND_TRADE_MARKET_TYPE.equalsIgnoreCase(this.type) || ("limit".equalsIgnoreCase(this.type) && "ioc".equalsIgnoreCase(this.timeInForce)) || ("limit".equalsIgnoreCase(this.type) && "fok".equalsIgnoreCase(this.timeInForce));
    }

    public boolean isOpen() {
        return "open".equals(getOffset());
    }

    public boolean isTpsl() {
        return this.isTpsl == 1;
    }

    public boolean isUseFeeOnly() {
        String str = this.feeAsset;
        if (str == null) {
            return false;
        }
        if ("USDT".equalsIgnoreCase(str) || this.feeAsset.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            return true;
        }
        return false;
    }

    public void setClientOrderId(Long l11) {
        this.clientOrderId = l11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractFace(String str) {
        this.contractFace = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setCreatedAt(Long l11) {
        this.createdAt = l11;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setFeeAmount(String str) {
        this.feeAmount = str;
    }

    public void setFeeAsset(String str) {
        this.feeAsset = str;
    }

    public void setIsTpsl(int i11) {
        this.isTpsl = i11;
    }

    public void setLeverRate(Integer num) {
        this.leverRate = num;
    }

    public void setMarginFrozen(String str) {
        this.marginFrozen = str;
    }

    public void setMarginMode(String str) {
        this.marginMode = str;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public void setOrderId(Long l11) {
        this.orderId = l11;
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

    public void setPositionSide(String str) {
        this.positionSide = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPriceMatch(String str) {
        this.priceMatch = str;
    }

    public void setProfit(String str) {
        this.profit = str;
    }

    public void setSide(String str) {
        this.side = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTimeInForce(String str) {
        this.timeInForce = str;
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

    public void setType(String str) {
        this.type = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "LinearSwapCurrentOrderInfo(symbol=" + getSymbol() + ", contractType=" + getContractType() + ", contractCode=" + getContractCode() + ", volume=" + getVolume() + ", price=" + getPrice() + ", orderPriceType=" + getOrderPriceType() + ", type=" + getType() + ", priceMatch=" + getPriceMatch() + ", timeInForce=" + getTimeInForce() + ", direction=" + getDirection() + ", side=" + getSide() + ", positionSide=" + getPositionSide() + ", offset=" + getOffset() + ", leverRate=" + getLeverRate() + ", orderType=" + getOrderType() + ", orderId=" + getOrderId() + ", clientOrderId=" + getClientOrderId() + ", orderSource=" + getOrderSource() + ", createdAt=" + getCreatedAt() + ", createTime=" + getCreateTime() + ", tradeVolume=" + getTradeVolume() + ", tradeTurnover=" + getTradeTurnover() + ", fee=" + getFee() + ", feeAsset=" + getFeeAsset() + ", feeAmount=" + getFeeAmount() + ", tradeAvgPrice=" + getTradeAvgPrice() + ", marginFrozen=" + getMarginFrozen() + ", profit=" + getProfit() + ", status=" + getStatus() + ", contractFace=" + getContractFace() + ", isTpsl=" + getIsTpsl() + ", marginMode=" + getMarginMode() + ")";
    }
}
