package com.huobi.trade.bean;

import android.content.Context;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.trade.prime.bean.AliToken;
import d7.a1;
import i6.m;
import java.io.Serializable;
import java.util.Map;
import pro.huobi.R;

public class OrderPlaceBean implements Serializable {
    private static final String DEFAULT_STR = "--";
    private AliToken aliToken;
    private String amount;
    private int autoType;
    private long couponId;
    private String iceAmount;

    /* renamed from: id  reason: collision with root package name */
    private int f81961id;
    private String interestRate;
    private boolean isBuy;
    private boolean isSelectedMarketAmount;
    private String loanAmount;
    private String loanAmountAndInterest;
    private String marginAmount;
    private String marketAmountText;
    private String newPrice;
    private String operator;
    private int orderLimitType;
    private String orderMarginSize;
    private String orderMarginValue;
    private int planTradeMarketMode = 0;
    private String predictAmount;
    private String price;
    private String repayAmount;
    private String stopPrice;
    private String symbol;
    private int tradeViewType;
    private Map<String, Object> verify;
    private boolean verifyAliToken;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof OrderPlaceBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderPlaceBean)) {
            return false;
        }
        OrderPlaceBean orderPlaceBean = (OrderPlaceBean) obj;
        if (!orderPlaceBean.canEqual(this) || getId() != orderPlaceBean.getId()) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = orderPlaceBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String marginAmount2 = getMarginAmount();
        String marginAmount3 = orderPlaceBean.getMarginAmount();
        if (marginAmount2 != null ? !marginAmount2.equals(marginAmount3) : marginAmount3 != null) {
            return false;
        }
        String orderMarginSize2 = getOrderMarginSize();
        String orderMarginSize3 = orderPlaceBean.getOrderMarginSize();
        if (orderMarginSize2 != null ? !orderMarginSize2.equals(orderMarginSize3) : orderMarginSize3 != null) {
            return false;
        }
        String orderMarginValue2 = getOrderMarginValue();
        String orderMarginValue3 = orderPlaceBean.getOrderMarginValue();
        if (orderMarginValue2 != null ? !orderMarginValue2.equals(orderMarginValue3) : orderMarginValue3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = orderPlaceBean.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        if (getTradeViewType() != orderPlaceBean.getTradeViewType() || getOrderLimitType() != orderPlaceBean.getOrderLimitType()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = orderPlaceBean.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String stopPrice2 = getStopPrice();
        String stopPrice3 = orderPlaceBean.getStopPrice();
        if (stopPrice2 != null ? !stopPrice2.equals(stopPrice3) : stopPrice3 != null) {
            return false;
        }
        String operator2 = getOperator();
        String operator3 = orderPlaceBean.getOperator();
        if (operator2 != null ? !operator2.equals(operator3) : operator3 != null) {
            return false;
        }
        if (isBuy() != orderPlaceBean.isBuy()) {
            return false;
        }
        Map<String, Object> verify2 = getVerify();
        Map<String, Object> verify3 = orderPlaceBean.getVerify();
        if (verify2 != null ? !verify2.equals(verify3) : verify3 != null) {
            return false;
        }
        AliToken aliToken2 = getAliToken();
        AliToken aliToken3 = orderPlaceBean.getAliToken();
        if (aliToken2 != null ? !aliToken2.equals(aliToken3) : aliToken3 != null) {
            return false;
        }
        if (isVerifyAliToken() != orderPlaceBean.isVerifyAliToken() || getAutoType() != orderPlaceBean.getAutoType()) {
            return false;
        }
        String loanAmount2 = getLoanAmount();
        String loanAmount3 = orderPlaceBean.getLoanAmount();
        if (loanAmount2 != null ? !loanAmount2.equals(loanAmount3) : loanAmount3 != null) {
            return false;
        }
        String repayAmount2 = getRepayAmount();
        String repayAmount3 = orderPlaceBean.getRepayAmount();
        if (repayAmount2 != null ? !repayAmount2.equals(repayAmount3) : repayAmount3 != null) {
            return false;
        }
        String predictAmount2 = getPredictAmount();
        String predictAmount3 = orderPlaceBean.getPredictAmount();
        if (predictAmount2 != null ? !predictAmount2.equals(predictAmount3) : predictAmount3 != null) {
            return false;
        }
        String interestRate2 = getInterestRate();
        String interestRate3 = orderPlaceBean.getInterestRate();
        if (interestRate2 != null ? !interestRate2.equals(interestRate3) : interestRate3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = orderPlaceBean.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String newPrice2 = getNewPrice();
        String newPrice3 = orderPlaceBean.getNewPrice();
        if (newPrice2 != null ? !newPrice2.equals(newPrice3) : newPrice3 != null) {
            return false;
        }
        if (getPlanTradeMarketMode() != orderPlaceBean.getPlanTradeMarketMode()) {
            return false;
        }
        String loanAmountAndInterest2 = getLoanAmountAndInterest();
        String loanAmountAndInterest3 = orderPlaceBean.getLoanAmountAndInterest();
        if (loanAmountAndInterest2 != null ? !loanAmountAndInterest2.equals(loanAmountAndInterest3) : loanAmountAndInterest3 != null) {
            return false;
        }
        if (getCouponId() != orderPlaceBean.getCouponId() || isSelectedMarketAmount() != orderPlaceBean.isSelectedMarketAmount()) {
            return false;
        }
        String marketAmountText2 = getMarketAmountText();
        String marketAmountText3 = orderPlaceBean.getMarketAmountText();
        if (marketAmountText2 != null ? !marketAmountText2.equals(marketAmountText3) : marketAmountText3 != null) {
            return false;
        }
        String iceAmount2 = getIceAmount();
        String iceAmount3 = orderPlaceBean.getIceAmount();
        return iceAmount2 != null ? iceAmount2.equals(iceAmount3) : iceAmount3 == null;
    }

    public AliToken getAliToken() {
        return this.aliToken;
    }

    public String getAmount() {
        return this.amount;
    }

    public int getAutoType() {
        return this.autoType;
    }

    public long getCouponId() {
        return this.couponId;
    }

    public String getDisplayAmount() {
        if ("--".equals(this.amount)) {
            return this.amount;
        }
        int i11 = this.tradeViewType;
        if (i11 == 1) {
            if (this.isBuy) {
                return m.m(this.amount, PrecisionUtil.y(this.symbol));
            }
            return m.m(this.amount, PrecisionUtil.z(this.symbol));
        } else if (i11 != 3) {
            return m.m(this.amount, PrecisionUtil.z(this.symbol));
        } else {
            if (!this.isBuy) {
                return m.m(this.amount, PrecisionUtil.z(this.symbol));
            }
            if (this.planTradeMarketMode == 2) {
                return m.m(this.amount, PrecisionUtil.y(this.symbol));
            }
            return m.m(this.amount, PrecisionUtil.z(this.symbol));
        }
    }

    public String getDisplayOrderType(Context context) {
        int i11 = this.tradeViewType;
        if (i11 == 0) {
            return context.getString(R.string.n_contract_trade_order_type_limit);
        }
        if (i11 == 1) {
            return context.getString(R.string.trade_price_market_deal);
        }
        if (i11 != 2) {
            return context.getString(R.string.n_contract_trade_order_type_plan);
        }
        return context.getString(R.string.trade_trend_stop);
    }

    public String getDisplayPredictAmount() {
        if ("--".equals(this.predictAmount)) {
            return this.predictAmount;
        }
        return m.m(this.predictAmount, PrecisionUtil.z(this.symbol));
    }

    public String getDisplayPrice() {
        if ("--".equals(this.price)) {
            return this.price;
        }
        return m.m(this.price, PrecisionUtil.e(this.symbol));
    }

    public String getDisplayStopPrice() {
        if ("--".equals(this.stopPrice)) {
            return this.stopPrice;
        }
        return m.m(this.stopPrice, PrecisionUtil.e(this.symbol));
    }

    public String getDisplayVolume() {
        if ("--".equals(this.volume)) {
            return this.volume;
        }
        return m.m(this.volume, PrecisionUtil.y(this.symbol));
    }

    public String getIceAmount() {
        return this.iceAmount;
    }

    public int getId() {
        return this.f81961id;
    }

    public String getInterestRate() {
        return this.interestRate;
    }

    public String getLoanAmount() {
        return this.loanAmount;
    }

    public String getLoanAmountAndInterest() {
        return this.loanAmountAndInterest;
    }

    public String getMarginAmount() {
        return this.marginAmount;
    }

    public String getMarketAmountText() {
        return this.marketAmountText;
    }

    public String getNewPrice() {
        return this.newPrice;
    }

    public String getOperator() {
        return this.operator;
    }

    public int getOrderLimitType() {
        return this.orderLimitType;
    }

    public String getOrderMarginSize() {
        return this.orderMarginSize;
    }

    public String getOrderMarginValue() {
        return this.orderMarginValue;
    }

    public String getOrderType() {
        int tradeViewType2 = getTradeViewType();
        if (tradeViewType2 != 0) {
            return tradeViewType2 != 2 ? tradeViewType2 != 7 ? this.isBuy ? "buy-market" : "sell-market" : this.isBuy ? "buy-limit-maker" : "sell-limit-maker" : this.isBuy ? "buy-stop-limit" : "sell-stop-limit";
        }
        if (this.isBuy) {
            if (a1.v().Q(getSymbol())) {
                return "buy-prime";
            }
            if (getOrderLimitType() == 0) {
                return "buy-limit";
            }
            return getOrderLimitType() == 1 ? "buy-ioc" : "buy-limit-fok";
        } else if (getOrderLimitType() == 0) {
            return "sell-limit";
        } else {
            return getOrderLimitType() == 1 ? "sell-ioc" : "sell-limit-fok";
        }
    }

    public int getPlanTradeMarketMode() {
        return this.planTradeMarketMode;
    }

    public String getPredictAmount() {
        return this.predictAmount;
    }

    public String getPrice() {
        return this.price;
    }

    public String getRepayAmount() {
        return this.repayAmount;
    }

    public String getStopPrice() {
        return this.stopPrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getTradeViewType() {
        return this.tradeViewType;
    }

    public Map<String, Object> getVerify() {
        return this.verify;
    }

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String amount2 = getAmount();
        int i11 = 43;
        int id2 = ((getId() + 59) * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String marginAmount2 = getMarginAmount();
        int hashCode = (id2 * 59) + (marginAmount2 == null ? 43 : marginAmount2.hashCode());
        String orderMarginSize2 = getOrderMarginSize();
        int hashCode2 = (hashCode * 59) + (orderMarginSize2 == null ? 43 : orderMarginSize2.hashCode());
        String orderMarginValue2 = getOrderMarginValue();
        int hashCode3 = (hashCode2 * 59) + (orderMarginValue2 == null ? 43 : orderMarginValue2.hashCode());
        String price2 = getPrice();
        int hashCode4 = (((((hashCode3 * 59) + (price2 == null ? 43 : price2.hashCode())) * 59) + getTradeViewType()) * 59) + getOrderLimitType();
        String symbol2 = getSymbol();
        int hashCode5 = (hashCode4 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String stopPrice2 = getStopPrice();
        int hashCode6 = (hashCode5 * 59) + (stopPrice2 == null ? 43 : stopPrice2.hashCode());
        String operator2 = getOperator();
        int i12 = 79;
        int hashCode7 = (((hashCode6 * 59) + (operator2 == null ? 43 : operator2.hashCode())) * 59) + (isBuy() ? 79 : 97);
        Map<String, Object> verify2 = getVerify();
        int hashCode8 = (hashCode7 * 59) + (verify2 == null ? 43 : verify2.hashCode());
        AliToken aliToken2 = getAliToken();
        int hashCode9 = (((((hashCode8 * 59) + (aliToken2 == null ? 43 : aliToken2.hashCode())) * 59) + (isVerifyAliToken() ? 79 : 97)) * 59) + getAutoType();
        String loanAmount2 = getLoanAmount();
        int hashCode10 = (hashCode9 * 59) + (loanAmount2 == null ? 43 : loanAmount2.hashCode());
        String repayAmount2 = getRepayAmount();
        int hashCode11 = (hashCode10 * 59) + (repayAmount2 == null ? 43 : repayAmount2.hashCode());
        String predictAmount2 = getPredictAmount();
        int hashCode12 = (hashCode11 * 59) + (predictAmount2 == null ? 43 : predictAmount2.hashCode());
        String interestRate2 = getInterestRate();
        int hashCode13 = (hashCode12 * 59) + (interestRate2 == null ? 43 : interestRate2.hashCode());
        String volume2 = getVolume();
        int hashCode14 = (hashCode13 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String newPrice2 = getNewPrice();
        int hashCode15 = (((hashCode14 * 59) + (newPrice2 == null ? 43 : newPrice2.hashCode())) * 59) + getPlanTradeMarketMode();
        String loanAmountAndInterest2 = getLoanAmountAndInterest();
        int i13 = hashCode15 * 59;
        int hashCode16 = loanAmountAndInterest2 == null ? 43 : loanAmountAndInterest2.hashCode();
        long couponId2 = getCouponId();
        int i14 = (((i13 + hashCode16) * 59) + ((int) (couponId2 ^ (couponId2 >>> 32)))) * 59;
        if (!isSelectedMarketAmount()) {
            i12 = 97;
        }
        String marketAmountText2 = getMarketAmountText();
        int hashCode17 = ((i14 + i12) * 59) + (marketAmountText2 == null ? 43 : marketAmountText2.hashCode());
        String iceAmount2 = getIceAmount();
        int i15 = hashCode17 * 59;
        if (iceAmount2 != null) {
            i11 = iceAmount2.hashCode();
        }
        return i15 + i11;
    }

    public boolean isBuy() {
        return this.isBuy;
    }

    public boolean isSelectedMarketAmount() {
        return this.isSelectedMarketAmount;
    }

    public boolean isVerifyAliToken() {
        return this.verifyAliToken;
    }

    public void setAliToken(AliToken aliToken2) {
        this.aliToken = aliToken2;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setAutoType(int i11) {
        this.autoType = i11;
    }

    public void setBuy(boolean z11) {
        this.isBuy = z11;
    }

    public void setCouponId(long j11) {
        this.couponId = j11;
    }

    public OrderPlaceBean setIceAmount(String str) {
        this.iceAmount = str;
        return this;
    }

    public void setId(int i11) {
        this.f81961id = i11;
    }

    public void setInterestRate(String str) {
        this.interestRate = str;
    }

    public void setLoanAmount(String str) {
        this.loanAmount = str;
    }

    public void setLoanAmountAndInterest(String str) {
        this.loanAmountAndInterest = str;
    }

    public void setMarginAmount(String str) {
        this.marginAmount = str;
    }

    public OrderPlaceBean setMarketAmountText(String str) {
        this.marketAmountText = str;
        return this;
    }

    public void setNewPrice(String str) {
        this.newPrice = str;
    }

    public void setOperator(String str) {
        this.operator = str;
    }

    public void setOrderLimitType(int i11) {
        this.orderLimitType = i11;
    }

    public void setOrderMarginSize(String str) {
        this.orderMarginSize = str;
    }

    public void setOrderMarginValue(String str) {
        this.orderMarginValue = str;
    }

    public void setPlanTradeMarketMode(int i11) {
        this.planTradeMarketMode = i11;
    }

    public void setPredictAmount(String str) {
        this.predictAmount = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setRepayAmount(String str) {
        this.repayAmount = str;
    }

    public OrderPlaceBean setSelectedMarketAmount(boolean z11) {
        this.isSelectedMarketAmount = z11;
        return this;
    }

    public void setStopPrice(String str) {
        this.stopPrice = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeViewType(int i11) {
        this.tradeViewType = i11;
    }

    public void setVerify(Map<String, Object> map) {
        this.verify = map;
    }

    public void setVerifyAliToken(boolean z11) {
        this.verifyAliToken = z11;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "OrderPlaceBean(id=" + getId() + ", amount=" + getAmount() + ", marginAmount=" + getMarginAmount() + ", orderMarginSize=" + getOrderMarginSize() + ", orderMarginValue=" + getOrderMarginValue() + ", price=" + getPrice() + ", tradeViewType=" + getTradeViewType() + ", orderLimitType=" + getOrderLimitType() + ", symbol=" + getSymbol() + ", stopPrice=" + getStopPrice() + ", operator=" + getOperator() + ", isBuy=" + isBuy() + ", verify=" + getVerify() + ", aliToken=" + getAliToken() + ", verifyAliToken=" + isVerifyAliToken() + ", autoType=" + getAutoType() + ", loanAmount=" + getLoanAmount() + ", repayAmount=" + getRepayAmount() + ", predictAmount=" + getPredictAmount() + ", interestRate=" + getInterestRate() + ", volume=" + getVolume() + ", newPrice=" + getNewPrice() + ", planTradeMarketMode=" + getPlanTradeMarketMode() + ", loanAmountAndInterest=" + getLoanAmountAndInterest() + ", couponId=" + getCouponId() + ", isSelectedMarketAmount=" + isSelectedMarketAmount() + ", marketAmountText=" + getMarketAmountText() + ", iceAmount=" + getIceAmount() + ")";
    }
}
