package com.huobi.finance.bean;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.viewhandler.C2cLendBalanceViewAdapter;
import i6.m;
import java.math.BigDecimal;
import java.util.Map;

public class C2CLendBalanceDetailInfo extends BaseAssetInfo {
    private String earnings;
    private String lending;
    private String totalAmount;
    private String trade;

    public void calculateEstimate(Map<String, BigDecimal> map) {
        BigDecimal add = m.a(this.trade).add(m.a(this.lending));
        this.totalAmount = add.toPlainString();
        BigDecimal bigDecimal = map.get(getCurrency());
        if (bigDecimal == null) {
            bigDecimal = BigDecimal.ZERO;
        }
        BigDecimal multiply = add.multiply(bigDecimal);
        setEstimateAmountToBtc(multiply.toPlainString());
        setEstimateAmount(LegalCurrencyConfigUtil.D(m.u0(multiply.toPlainString(), 12, 8), "btcusdt", TradeType.PRO));
    }

    public boolean canEqual(Object obj) {
        return obj instanceof C2CLendBalanceDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CLendBalanceDetailInfo)) {
            return false;
        }
        C2CLendBalanceDetailInfo c2CLendBalanceDetailInfo = (C2CLendBalanceDetailInfo) obj;
        if (!c2CLendBalanceDetailInfo.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String trade2 = getTrade();
        String trade3 = c2CLendBalanceDetailInfo.getTrade();
        if (trade2 != null ? !trade2.equals(trade3) : trade3 != null) {
            return false;
        }
        String lending2 = getLending();
        String lending3 = c2CLendBalanceDetailInfo.getLending();
        if (lending2 != null ? !lending2.equals(lending3) : lending3 != null) {
            return false;
        }
        String earnings2 = getEarnings();
        String earnings3 = c2CLendBalanceDetailInfo.getEarnings();
        if (earnings2 != null ? !earnings2.equals(earnings3) : earnings3 != null) {
            return false;
        }
        String totalAmount2 = getTotalAmount();
        String totalAmount3 = c2CLendBalanceDetailInfo.getTotalAmount();
        return totalAmount2 != null ? totalAmount2.equals(totalAmount3) : totalAmount3 == null;
    }

    public String getEarnings() {
        return this.earnings;
    }

    public String getLending() {
        return this.lending;
    }

    public String getTitle() {
        return getDisplayName();
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public String getTrade() {
        return this.trade;
    }

    public String getViewHandlerName() {
        return C2cLendBalanceViewAdapter.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String trade2 = getTrade();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (trade2 == null ? 43 : trade2.hashCode());
        String lending2 = getLending();
        int hashCode3 = (hashCode2 * 59) + (lending2 == null ? 43 : lending2.hashCode());
        String earnings2 = getEarnings();
        int hashCode4 = (hashCode3 * 59) + (earnings2 == null ? 43 : earnings2.hashCode());
        String totalAmount2 = getTotalAmount();
        int i12 = hashCode4 * 59;
        if (totalAmount2 != null) {
            i11 = totalAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setEarnings(String str) {
        this.earnings = str;
    }

    public void setLending(String str) {
        this.lending = str;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public void setTrade(String str) {
        this.trade = str;
    }

    public String toString() {
        return "C2CLendBalanceDetailInfo(trade=" + getTrade() + ", lending=" + getLending() + ", earnings=" + getEarnings() + ", totalAmount=" + getTotalAmount() + ")";
    }
}
