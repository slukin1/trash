package com.huobi.order.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.order.handler.TradeOrderHistoryDetailHandler;
import com.huobi.trade.bean.TradeOrderType;
import com.huobi.trade.handler.FilledOrderHandler;
import com.huobi.utils.SymbolUtil;
import i6.m;
import java.io.Serializable;
import java.math.BigDecimal;
import s9.a;

public class OrderBeanDetails implements Serializable, a {
    public static final int STYLE_FILLED_ORDER = 1;
    private static final long serialVersionUID = -5427949119665778303L;
    @SerializedName("created-at")
    private long createdAt;
    private String feeCurrency;
    @SerializedName("fee-deduct-currency")
    private String feeDeductCurrency;
    @SerializedName("filled-amount")
    private String filledAmount;
    @SerializedName("filled-fees")
    private String filledFees;
    @SerializedName("filled-points")
    private String filledPoints;

    /* renamed from: id  reason: collision with root package name */
    private long f78109id;
    @SerializedName("match-id")
    private long matchId;
    private String operator;
    @SerializedName("order-id")
    private long orderId;
    @SerializedName("period-order-type")
    private int periodOrderType;
    private String price;
    @SerializedName("role")
    private String role;
    private String source;
    @SerializedName("stop-price")
    private String stopPrice;
    private int style = 0;
    private String symbol;
    private String totalCash;
    private String type;

    public void buildFeeCurrency() {
        this.feeCurrency = buildFeeCurrency(isBuy(), this.symbol, this.filledFees);
    }

    public void calculateTotalCash() {
        this.totalCash = m.m(m.a(this.filledAmount).multiply(m.a(this.price)).toPlainString(), 32);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OrderBeanDetails;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderBeanDetails)) {
            return false;
        }
        OrderBeanDetails orderBeanDetails = (OrderBeanDetails) obj;
        if (!orderBeanDetails.canEqual(this) || getOrderId() != orderBeanDetails.getOrderId() || getMatchId() != orderBeanDetails.getMatchId() || getCreatedAt() != orderBeanDetails.getCreatedAt()) {
            return false;
        }
        String filledAmount2 = getFilledAmount();
        String filledAmount3 = orderBeanDetails.getFilledAmount();
        if (filledAmount2 != null ? !filledAmount2.equals(filledAmount3) : filledAmount3 != null) {
            return false;
        }
        String role2 = getRole();
        String role3 = orderBeanDetails.getRole();
        if (role2 != null ? !role2.equals(role3) : role3 != null) {
            return false;
        }
        String filledFees2 = getFilledFees();
        String filledFees3 = orderBeanDetails.getFilledFees();
        if (filledFees2 != null ? !filledFees2.equals(filledFees3) : filledFees3 != null) {
            return false;
        }
        String feeCurrency2 = getFeeCurrency();
        String feeCurrency3 = orderBeanDetails.getFeeCurrency();
        if (feeCurrency2 != null ? !feeCurrency2.equals(feeCurrency3) : feeCurrency3 != null) {
            return false;
        }
        String filledPoints2 = getFilledPoints();
        String filledPoints3 = orderBeanDetails.getFilledPoints();
        if (filledPoints2 != null ? !filledPoints2.equals(filledPoints3) : filledPoints3 != null) {
            return false;
        }
        String feeDeductCurrency2 = getFeeDeductCurrency();
        String feeDeductCurrency3 = orderBeanDetails.getFeeDeductCurrency();
        if (feeDeductCurrency2 != null ? !feeDeductCurrency2.equals(feeDeductCurrency3) : feeDeductCurrency3 != null) {
            return false;
        }
        if (getPeriodOrderType() != orderBeanDetails.getPeriodOrderType() || getId() != orderBeanDetails.getId()) {
            return false;
        }
        String price2 = getPrice();
        String price3 = orderBeanDetails.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String source2 = getSource();
        String source3 = orderBeanDetails.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = orderBeanDetails.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = orderBeanDetails.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String totalCash2 = getTotalCash();
        String totalCash3 = orderBeanDetails.getTotalCash();
        if (totalCash2 != null ? !totalCash2.equals(totalCash3) : totalCash3 != null) {
            return false;
        }
        String stopPrice2 = getStopPrice();
        String stopPrice3 = orderBeanDetails.getStopPrice();
        if (stopPrice2 != null ? !stopPrice2.equals(stopPrice3) : stopPrice3 != null) {
            return false;
        }
        String operator2 = getOperator();
        String operator3 = orderBeanDetails.getOperator();
        if (operator2 != null ? operator2.equals(operator3) : operator3 == null) {
            return getStyle() == orderBeanDetails.getStyle();
        }
        return false;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getFeeCurrency() {
        return this.feeCurrency;
    }

    public String getFeeDeductCurrency() {
        return this.feeDeductCurrency;
    }

    public String getFilledAmount() {
        return this.filledAmount;
    }

    public String getFilledFees() {
        return this.filledFees;
    }

    public String getFilledPoints() {
        return this.filledPoints;
    }

    public long getId() {
        return this.f78109id;
    }

    public long getMatchId() {
        return this.matchId;
    }

    public String getOperator() {
        return this.operator;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public int getPeriodOrderType() {
        return this.periodOrderType;
    }

    public String getPrice() {
        return this.price;
    }

    public String getRole() {
        return this.role;
    }

    public String getSource() {
        return this.source;
    }

    public String getStopPrice() {
        return this.stopPrice;
    }

    public int getStyle() {
        return this.style;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTotalCash() {
        return this.totalCash;
    }

    public String getType() {
        return this.type;
    }

    public String getViewHandlerName() {
        if (this.style == 1) {
            return FilledOrderHandler.class.getName();
        }
        return TradeOrderHistoryDetailHandler.class.getName();
    }

    public int hashCode() {
        long orderId2 = getOrderId();
        long matchId2 = getMatchId();
        int i11 = ((((int) (orderId2 ^ (orderId2 >>> 32))) + 59) * 59) + ((int) (matchId2 ^ (matchId2 >>> 32)));
        long createdAt2 = getCreatedAt();
        int i12 = (i11 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        String filledAmount2 = getFilledAmount();
        int i13 = 43;
        int hashCode = (i12 * 59) + (filledAmount2 == null ? 43 : filledAmount2.hashCode());
        String role2 = getRole();
        int hashCode2 = (hashCode * 59) + (role2 == null ? 43 : role2.hashCode());
        String filledFees2 = getFilledFees();
        int hashCode3 = (hashCode2 * 59) + (filledFees2 == null ? 43 : filledFees2.hashCode());
        String feeCurrency2 = getFeeCurrency();
        int hashCode4 = (hashCode3 * 59) + (feeCurrency2 == null ? 43 : feeCurrency2.hashCode());
        String filledPoints2 = getFilledPoints();
        int hashCode5 = (hashCode4 * 59) + (filledPoints2 == null ? 43 : filledPoints2.hashCode());
        String feeDeductCurrency2 = getFeeDeductCurrency();
        int i14 = hashCode5 * 59;
        int hashCode6 = feeDeductCurrency2 == null ? 43 : feeDeductCurrency2.hashCode();
        long id2 = getId();
        int periodOrderType2 = ((((i14 + hashCode6) * 59) + getPeriodOrderType()) * 59) + ((int) ((id2 >>> 32) ^ id2));
        String price2 = getPrice();
        int hashCode7 = (periodOrderType2 * 59) + (price2 == null ? 43 : price2.hashCode());
        String source2 = getSource();
        int hashCode8 = (hashCode7 * 59) + (source2 == null ? 43 : source2.hashCode());
        String symbol2 = getSymbol();
        int hashCode9 = (hashCode8 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String type2 = getType();
        int hashCode10 = (hashCode9 * 59) + (type2 == null ? 43 : type2.hashCode());
        String totalCash2 = getTotalCash();
        int hashCode11 = (hashCode10 * 59) + (totalCash2 == null ? 43 : totalCash2.hashCode());
        String stopPrice2 = getStopPrice();
        int hashCode12 = (hashCode11 * 59) + (stopPrice2 == null ? 43 : stopPrice2.hashCode());
        String operator2 = getOperator();
        int i15 = hashCode12 * 59;
        if (operator2 != null) {
            i13 = operator2.hashCode();
        }
        return ((i15 + i13) * 59) + getStyle();
    }

    public boolean isBuy() {
        return TradeOrderType.b(getType());
    }

    public boolean isStopLimitType() {
        return TradeOrderType.f(getType());
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setFeeCurrency(String str) {
        this.feeCurrency = str;
    }

    public void setFeeDeductCurrency(String str) {
        this.feeDeductCurrency = str;
    }

    public void setFilledAmount(String str) {
        this.filledAmount = str;
    }

    public void setFilledFees(String str) {
        this.filledFees = str;
    }

    public void setFilledPoints(String str) {
        this.filledPoints = str;
    }

    public void setId(long j11) {
        this.f78109id = j11;
    }

    public void setMatchId(long j11) {
        this.matchId = j11;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setPeriodOrderType(int i11) {
        this.periodOrderType = i11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setRole(String str) {
        this.role = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStopPrice(String str) {
        this.stopPrice = str;
    }

    public void setStyle(int i11) {
        this.style = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTotalCash(String str) {
        this.totalCash = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "OrderBeanDetails(orderId=" + getOrderId() + ", matchId=" + getMatchId() + ", createdAt=" + getCreatedAt() + ", filledAmount=" + getFilledAmount() + ", role=" + getRole() + ", filledFees=" + getFilledFees() + ", feeCurrency=" + getFeeCurrency() + ", filledPoints=" + getFilledPoints() + ", feeDeductCurrency=" + getFeeDeductCurrency() + ", periodOrderType=" + getPeriodOrderType() + ", id=" + getId() + ", price=" + getPrice() + ", source=" + getSource() + ", symbol=" + getSymbol() + ", type=" + getType() + ", totalCash=" + getTotalCash() + ", stopPrice=" + getStopPrice() + ", operator=" + getOperator() + ", style=" + getStyle() + ")";
    }

    public static String buildFeeCurrency(boolean z11, String str, String str2) {
        boolean z12 = true;
        if ((m.a(str2).compareTo(BigDecimal.ZERO) < 0) == z11) {
            z12 = false;
        }
        return SymbolUtil.c(str, z12);
    }
}
