package com.huobi.trade.bean;

import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.trade.handler.TradeOrderHistoryHandler;
import com.huobi.utils.SymbolUtil;
import java.io.Serializable;
import s9.a;

public class TradeOrderHistory implements Serializable, a {
    private static final long serialVersionUID = -8900585902529358646L;
    private String aprice;
    private String cancel_amount;
    private String canceledSourceDesc;
    private int fastSymbolType;
    private boolean feeAvailable = true;
    private String feeCurrency;
    private String feeDeductCurrency;
    private String fees;
    private String iceAmount;

    /* renamed from: id  reason: collision with root package name */
    private Long f81962id;
    private String marketAmount;
    private String order_amount;
    private String order_price;
    private long order_time;
    private String order_tprice;
    private String source;
    private String status;
    private String symbolId;
    private String tamount;
    private String totalDeductFees;
    private String totalPoints;
    private String tprice;
    private String type;
    private long updateAt;

    public void buildFeeCurrency() {
        if (isFeeAvailable()) {
            this.feeCurrency = OrderBeanDetails.buildFeeCurrency(isBuy(), this.symbolId, this.fees);
        } else {
            this.feeCurrency = SymbolUtil.c(this.symbolId, isBuy());
        }
    }

    public String getAprice() {
        return this.aprice;
    }

    public String getCancel_amount() {
        return this.cancel_amount;
    }

    public String getCanceledSourceDesc() {
        return this.canceledSourceDesc;
    }

    public int getFastSymbolType() {
        return this.fastSymbolType;
    }

    public String getFeeCurrency() {
        return this.feeCurrency;
    }

    public String getFeeDeductCurrency() {
        return this.feeDeductCurrency;
    }

    public String getFees() {
        return this.fees;
    }

    public String getIceAmount() {
        return this.iceAmount;
    }

    public Long getId() {
        return this.f81962id;
    }

    public String getMarketAmount() {
        return this.marketAmount;
    }

    public String getOrder_amount() {
        return this.order_amount;
    }

    public String getOrder_price() {
        return this.order_price;
    }

    public long getOrder_time() {
        return this.order_time;
    }

    public String getOrder_tprice() {
        return this.order_tprice;
    }

    public String getSource() {
        return this.source;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSymbolId() {
        return this.symbolId;
    }

    public String getTamount() {
        return this.tamount;
    }

    public String getTotalDeductFees() {
        return this.totalDeductFees;
    }

    public String getTotalPoints() {
        return this.totalPoints;
    }

    public String getTprice() {
        return this.tprice;
    }

    public String getType() {
        return this.type;
    }

    public long getUpdateAt() {
        return this.updateAt;
    }

    public String getViewHandlerName() {
        return TradeOrderHistoryHandler.class.getName();
    }

    public boolean isBuy() {
        return TradeOrderType.b(getType());
    }

    public boolean isFeeAvailable() {
        return this.feeAvailable;
    }

    public void setAprice(String str) {
        this.aprice = str;
    }

    public void setCancel_amount(String str) {
        this.cancel_amount = str;
    }

    public void setCanceledSourceDesc(String str) {
        this.canceledSourceDesc = str;
    }

    public void setFastSymbolType(int i11) {
        this.fastSymbolType = i11;
    }

    public void setFeeAvailable(boolean z11) {
        this.feeAvailable = z11;
    }

    public void setFeeCurrency(String str) {
        this.feeCurrency = str;
    }

    public void setFeeDeductCurrency(String str) {
        this.feeDeductCurrency = str;
    }

    public void setFees(String str) {
        this.fees = str;
    }

    public void setIceAmount(String str) {
        this.iceAmount = str;
    }

    public void setId(Long l11) {
        this.f81962id = l11;
    }

    public void setMarketAmount(String str) {
        this.marketAmount = str;
    }

    public void setOrder_amount(String str) {
        this.order_amount = str;
    }

    public void setOrder_price(String str) {
        this.order_price = str;
    }

    public void setOrder_time(long j11) {
        this.order_time = j11;
    }

    public void setOrder_tprice(String str) {
        this.order_tprice = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSymbolId(String str) {
        this.symbolId = str;
    }

    public void setTamount(String str) {
        this.tamount = str;
    }

    public void setTotalDeductFees(String str) {
        this.totalDeductFees = str;
    }

    public void setTotalPoints(String str) {
        this.totalPoints = str;
    }

    public void setTprice(String str) {
        this.tprice = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUpdateAt(long j11) {
        this.updateAt = j11;
    }
}
