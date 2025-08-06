package com.huobi.order.bean;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.ExchangeOpenOrder;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.trade.bean.TradeOrderType;
import com.huobi.trade.handler.OrderBeanViewHandler;
import java.io.Serializable;
import java.math.BigDecimal;

public class OrderBean implements Serializable, s9.a {
    private static final long serialVersionUID = -5427949119665778303L;
    @SerializedName("account-id")
    private long accountId;
    private String amount;
    private String batch;
    private a callback;
    @SerializedName("canceled-at")
    private long canceledAt;
    @SerializedName("canceled-source-desc")
    private String canceledSourceDesc;
    @SerializedName("client-order-id")
    private String clientOrderId;
    @SerializedName("created-at")
    private long createdAt;
    private String exchange;
    @SerializedName("field-amount")
    private String fieldAmount;
    @SerializedName("field-cash-amount")
    private String fieldCashAmount;
    @SerializedName("field-fees")
    private String fieldFees;
    private int finishedAt;
    @SerializedName("ice-amount")
    private String iceAmount;

    /* renamed from: id  reason: collision with root package name */
    private long f78108id;
    private boolean isCallAuctionTwo;
    private boolean isTrade;
    @SerializedName("market-amount")
    private String marketAmount;
    private String operator;
    private String price;
    private boolean showSymbol;
    private String source;
    private String state;
    @SerializedName("stop-price")
    private String stopPrice;
    private String symbol;
    private TradeType tradeType;
    private String type;
    @SerializedName("updated-at")
    private long updatedAt;

    public interface a {
        void a(OrderBean orderBean, Context context);
    }

    public static OrderBean from(ExchangeOpenOrderItem exchangeOpenOrderItem) {
        ExchangeOpenOrder d11 = exchangeOpenOrderItem.d();
        OrderBean orderBean = new OrderBean();
        orderBean.setId(d11.getId());
        orderBean.setSymbol(d11.getSymbol());
        orderBean.setAccountId(d11.getAccountId());
        orderBean.setSource(d11.getSource());
        orderBean.setCreatedAt(d11.getCreatedAt());
        orderBean.setPrice(d11.getPrice());
        orderBean.setAmount(d11.getAmount());
        orderBean.setType(d11.getType());
        orderBean.setState(d11.getState());
        orderBean.setFieldFees(d11.getFilledFees());
        orderBean.setFieldCashAmount(d11.getFilledCashAmount());
        orderBean.setFieldAmount(d11.getFilledAmount());
        orderBean.setStopPrice(d11.getStopPrice());
        orderBean.setOperator(d11.getOperator());
        orderBean.setIceAmount(d11.getIceAmount());
        return orderBean;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OrderBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderBean)) {
            return false;
        }
        OrderBean orderBean = (OrderBean) obj;
        if (!orderBean.canEqual(this)) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = orderBean.getCallback();
        if (callback2 != null ? !callback2.equals(callback3) : callback3 != null) {
            return false;
        }
        TradeType tradeType2 = getTradeType();
        TradeType tradeType3 = orderBean.getTradeType();
        if (tradeType2 != null ? !tradeType2.equals(tradeType3) : tradeType3 != null) {
            return false;
        }
        if (isTrade() != orderBean.isTrade() || isCallAuctionTwo() != orderBean.isCallAuctionTwo() || isShowSymbol() != orderBean.isShowSymbol() || getAccountId() != orderBean.getAccountId()) {
            return false;
        }
        String marketAmount2 = getMarketAmount();
        String marketAmount3 = orderBean.getMarketAmount();
        if (marketAmount2 != null ? !marketAmount2.equals(marketAmount3) : marketAmount3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = orderBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String batch2 = getBatch();
        String batch3 = orderBean.getBatch();
        if (batch2 != null ? !batch2.equals(batch3) : batch3 != null) {
            return false;
        }
        if (getCanceledAt() != orderBean.getCanceledAt() || getCreatedAt() != orderBean.getCreatedAt() || getUpdatedAt() != orderBean.getUpdatedAt()) {
            return false;
        }
        String exchange2 = getExchange();
        String exchange3 = orderBean.getExchange();
        if (exchange2 != null ? !exchange2.equals(exchange3) : exchange3 != null) {
            return false;
        }
        String fieldAmount2 = getFieldAmount();
        String fieldAmount3 = orderBean.getFieldAmount();
        if (fieldAmount2 != null ? !fieldAmount2.equals(fieldAmount3) : fieldAmount3 != null) {
            return false;
        }
        String iceAmount2 = getIceAmount();
        String iceAmount3 = orderBean.getIceAmount();
        if (iceAmount2 != null ? !iceAmount2.equals(iceAmount3) : iceAmount3 != null) {
            return false;
        }
        String fieldCashAmount2 = getFieldCashAmount();
        String fieldCashAmount3 = orderBean.getFieldCashAmount();
        if (fieldCashAmount2 != null ? !fieldCashAmount2.equals(fieldCashAmount3) : fieldCashAmount3 != null) {
            return false;
        }
        String fieldFees2 = getFieldFees();
        String fieldFees3 = orderBean.getFieldFees();
        if (fieldFees2 != null ? !fieldFees2.equals(fieldFees3) : fieldFees3 != null) {
            return false;
        }
        if (getFinishedAt() != orderBean.getFinishedAt() || getId() != orderBean.getId()) {
            return false;
        }
        String price2 = getPrice();
        String price3 = orderBean.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String source2 = getSource();
        String source3 = orderBean.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = orderBean.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = orderBean.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = orderBean.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String stopPrice2 = getStopPrice();
        String stopPrice3 = orderBean.getStopPrice();
        if (stopPrice2 != null ? !stopPrice2.equals(stopPrice3) : stopPrice3 != null) {
            return false;
        }
        String operator2 = getOperator();
        String operator3 = orderBean.getOperator();
        if (operator2 != null ? !operator2.equals(operator3) : operator3 != null) {
            return false;
        }
        String clientOrderId2 = getClientOrderId();
        String clientOrderId3 = orderBean.getClientOrderId();
        if (clientOrderId2 != null ? !clientOrderId2.equals(clientOrderId3) : clientOrderId3 != null) {
            return false;
        }
        String canceledSourceDesc2 = getCanceledSourceDesc();
        String canceledSourceDesc3 = orderBean.getCanceledSourceDesc();
        return canceledSourceDesc2 != null ? canceledSourceDesc2.equals(canceledSourceDesc3) : canceledSourceDesc3 == null;
    }

    public long getAccountId() {
        return this.accountId;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getBatch() {
        return this.batch;
    }

    public a getCallback() {
        return this.callback;
    }

    public long getCanceledAt() {
        return this.canceledAt;
    }

    public String getCanceledSourceDesc() {
        return this.canceledSourceDesc;
    }

    public String getClientOrderId() {
        return this.clientOrderId;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public String getExchange() {
        return this.exchange;
    }

    public String getFieldAmount() {
        return this.fieldAmount;
    }

    public String getFieldCashAmount() {
        return this.fieldCashAmount;
    }

    public String getFieldFees() {
        return this.fieldFees;
    }

    public int getFinishedAt() {
        return this.finishedAt;
    }

    public String getIceAmount() {
        return this.iceAmount;
    }

    public long getId() {
        return this.f78108id;
    }

    public String getMarketAmount() {
        return this.marketAmount;
    }

    public String getOperator() {
        return this.operator;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSource() {
        return this.source;
    }

    public String getState() {
        return this.state;
    }

    public String getStopPrice() {
        return this.stopPrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public String getType() {
        return this.type;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public String getViewHandlerName() {
        return OrderBeanViewHandler.class.getName();
    }

    public int hashCode() {
        a callback2 = getCallback();
        int i11 = 43;
        int hashCode = callback2 == null ? 43 : callback2.hashCode();
        TradeType tradeType2 = getTradeType();
        int i12 = 79;
        int hashCode2 = (((((((hashCode + 59) * 59) + (tradeType2 == null ? 43 : tradeType2.hashCode())) * 59) + (isTrade() ? 79 : 97)) * 59) + (isCallAuctionTwo() ? 79 : 97)) * 59;
        if (!isShowSymbol()) {
            i12 = 97;
        }
        long accountId2 = getAccountId();
        int i13 = ((hashCode2 + i12) * 59) + ((int) (accountId2 ^ (accountId2 >>> 32)));
        String marketAmount2 = getMarketAmount();
        int hashCode3 = (i13 * 59) + (marketAmount2 == null ? 43 : marketAmount2.hashCode());
        String amount2 = getAmount();
        int hashCode4 = (hashCode3 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String batch2 = getBatch();
        int hashCode5 = (hashCode4 * 59) + (batch2 == null ? 43 : batch2.hashCode());
        long canceledAt2 = getCanceledAt();
        int i14 = (hashCode5 * 59) + ((int) (canceledAt2 ^ (canceledAt2 >>> 32)));
        long createdAt2 = getCreatedAt();
        int i15 = (i14 * 59) + ((int) (createdAt2 ^ (createdAt2 >>> 32)));
        long updatedAt2 = getUpdatedAt();
        int i16 = (i15 * 59) + ((int) (updatedAt2 ^ (updatedAt2 >>> 32)));
        String exchange2 = getExchange();
        int hashCode6 = (i16 * 59) + (exchange2 == null ? 43 : exchange2.hashCode());
        String fieldAmount2 = getFieldAmount();
        int hashCode7 = (hashCode6 * 59) + (fieldAmount2 == null ? 43 : fieldAmount2.hashCode());
        String iceAmount2 = getIceAmount();
        int hashCode8 = (hashCode7 * 59) + (iceAmount2 == null ? 43 : iceAmount2.hashCode());
        String fieldCashAmount2 = getFieldCashAmount();
        int hashCode9 = (hashCode8 * 59) + (fieldCashAmount2 == null ? 43 : fieldCashAmount2.hashCode());
        String fieldFees2 = getFieldFees();
        int hashCode10 = (((hashCode9 * 59) + (fieldFees2 == null ? 43 : fieldFees2.hashCode())) * 59) + getFinishedAt();
        long id2 = getId();
        int i17 = (hashCode10 * 59) + ((int) (id2 ^ (id2 >>> 32)));
        String price2 = getPrice();
        int hashCode11 = (i17 * 59) + (price2 == null ? 43 : price2.hashCode());
        String source2 = getSource();
        int hashCode12 = (hashCode11 * 59) + (source2 == null ? 43 : source2.hashCode());
        String state2 = getState();
        int hashCode13 = (hashCode12 * 59) + (state2 == null ? 43 : state2.hashCode());
        String symbol2 = getSymbol();
        int hashCode14 = (hashCode13 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String type2 = getType();
        int hashCode15 = (hashCode14 * 59) + (type2 == null ? 43 : type2.hashCode());
        String stopPrice2 = getStopPrice();
        int hashCode16 = (hashCode15 * 59) + (stopPrice2 == null ? 43 : stopPrice2.hashCode());
        String operator2 = getOperator();
        int hashCode17 = (hashCode16 * 59) + (operator2 == null ? 43 : operator2.hashCode());
        String clientOrderId2 = getClientOrderId();
        int hashCode18 = (hashCode17 * 59) + (clientOrderId2 == null ? 43 : clientOrderId2.hashCode());
        String canceledSourceDesc2 = getCanceledSourceDesc();
        int i18 = hashCode18 * 59;
        if (canceledSourceDesc2 != null) {
            i11 = canceledSourceDesc2.hashCode();
        }
        return i18 + i11;
    }

    public boolean isBuy() {
        return TradeOrderType.b(getType());
    }

    public boolean isCallAuctionTwo() {
        return this.isCallAuctionTwo;
    }

    public boolean isShowSymbol() {
        return this.showSymbol;
    }

    public boolean isStopLimitType() {
        return TradeOrderType.f(getType());
    }

    public boolean isTrade() {
        return this.isTrade;
    }

    public void setAccountId(long j11) {
        this.accountId = j11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setBatch(String str) {
        this.batch = str;
    }

    public void setCallAuctionTwo(boolean z11) {
        this.isCallAuctionTwo = z11;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setCanceledAt(long j11) {
        this.canceledAt = j11;
    }

    public void setCanceledSourceDesc(String str) {
        this.canceledSourceDesc = str;
    }

    public void setClientOrderId(String str) {
        this.clientOrderId = str;
    }

    public void setCreatedAt(long j11) {
        this.createdAt = j11;
    }

    public void setExchange(String str) {
        this.exchange = str;
    }

    public void setFieldAmount(String str) {
        this.fieldAmount = str;
    }

    public void setFieldCashAmount(String str) {
        this.fieldCashAmount = str;
    }

    public void setFieldFees(String str) {
        this.fieldFees = str;
    }

    public void setFinishedAt(int i11) {
        this.finishedAt = i11;
    }

    public void setIceAmount(String str) {
        this.iceAmount = str;
    }

    public void setId(long j11) {
        this.f78108id = j11;
    }

    public void setMarketAmount(String str) {
        this.marketAmount = str;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setShowSymbol(boolean z11) {
        this.showSymbol = z11;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStopPrice(String str) {
        this.stopPrice = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTrade(boolean z11) {
        this.isTrade = z11;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpdatedAt(long j11) {
        this.updatedAt = j11;
    }

    public String toString() {
        return "OrderBean(callback=" + getCallback() + ", tradeType=" + getTradeType() + ", isTrade=" + isTrade() + ", isCallAuctionTwo=" + isCallAuctionTwo() + ", showSymbol=" + isShowSymbol() + ", accountId=" + getAccountId() + ", marketAmount=" + getMarketAmount() + ", amount=" + getAmount() + ", batch=" + getBatch() + ", canceledAt=" + getCanceledAt() + ", createdAt=" + getCreatedAt() + ", updatedAt=" + getUpdatedAt() + ", exchange=" + getExchange() + ", fieldAmount=" + getFieldAmount() + ", iceAmount=" + getIceAmount() + ", fieldCashAmount=" + getFieldCashAmount() + ", fieldFees=" + getFieldFees() + ", finishedAt=" + getFinishedAt() + ", id=" + getId() + ", price=" + getPrice() + ", source=" + getSource() + ", state=" + getState() + ", symbol=" + getSymbol() + ", type=" + getType() + ", stopPrice=" + getStopPrice() + ", operator=" + getOperator() + ", clientOrderId=" + getClientOrderId() + ", canceledSourceDesc=" + getCanceledSourceDesc() + ")";
    }

    public TradeOrderHistory transToTradeOrderHistory() {
        TradeOrderHistory tradeOrderHistory = new TradeOrderHistory();
        tradeOrderHistory.setId(Long.valueOf(this.f78108id));
        tradeOrderHistory.setSymbolId(this.symbol);
        tradeOrderHistory.setSource(this.source);
        tradeOrderHistory.setOrder_time(this.createdAt / 1000);
        tradeOrderHistory.setUpdateAt(this.updatedAt / 1000);
        tradeOrderHistory.setFees(this.fieldFees);
        tradeOrderHistory.setType(this.type);
        if ("partial-canceled".equals(this.state)) {
            tradeOrderHistory.setStatus("3");
        } else if ("canceled".equals(this.state)) {
            tradeOrderHistory.setStatus("3");
        } else if (TtmlNode.TEXT_EMPHASIS_MARK_FILLED.equals(this.state)) {
            tradeOrderHistory.setStatus("2");
        }
        tradeOrderHistory.setOrder_tprice(this.amount);
        tradeOrderHistory.setTamount(this.fieldAmount);
        tradeOrderHistory.setTprice(this.fieldCashAmount);
        BigDecimal bigDecimal = new BigDecimal(this.fieldAmount);
        if (bigDecimal.compareTo(BigDecimal.ZERO) != 0) {
            tradeOrderHistory.setAprice(new BigDecimal(this.fieldCashAmount).divide(bigDecimal, 32, 1).toString());
        }
        tradeOrderHistory.setOrder_price(this.price);
        tradeOrderHistory.setOrder_amount(this.amount);
        tradeOrderHistory.setMarketAmount(this.marketAmount);
        tradeOrderHistory.setIceAmount(this.iceAmount);
        tradeOrderHistory.setCanceledSourceDesc(this.canceledSourceDesc);
        return tradeOrderHistory;
    }
}
