package com.huobi.trade.bean;

import com.huobi.finance.bean.BalanceDetailInfo;
import com.huobi.trade.handler.TradeHoldViewHandler;
import java.io.Serializable;
import s9.a;

public class TradeHoldBean implements Serializable, a {
    private static final long serialVersionUID = -7154624240489267606L;
    public String available;
    public String currency;
    public BalanceDetailInfo currencyInfo;
    public String displayName;
    public String estimateTotal;
    public String fullDisplayName;
    public String head;
    public String netAsset;
    public String percent;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeHoldBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeHoldBean)) {
            return false;
        }
        TradeHoldBean tradeHoldBean = (TradeHoldBean) obj;
        if (!tradeHoldBean.canEqual(this)) {
            return false;
        }
        String head2 = getHead();
        String head3 = tradeHoldBean.getHead();
        if (head2 != null ? !head2.equals(head3) : head3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = tradeHoldBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String displayName2 = getDisplayName();
        String displayName3 = tradeHoldBean.getDisplayName();
        if (displayName2 != null ? !displayName2.equals(displayName3) : displayName3 != null) {
            return false;
        }
        String fullDisplayName2 = getFullDisplayName();
        String fullDisplayName3 = tradeHoldBean.getFullDisplayName();
        if (fullDisplayName2 != null ? !fullDisplayName2.equals(fullDisplayName3) : fullDisplayName3 != null) {
            return false;
        }
        String netAsset2 = getNetAsset();
        String netAsset3 = tradeHoldBean.getNetAsset();
        if (netAsset2 != null ? !netAsset2.equals(netAsset3) : netAsset3 != null) {
            return false;
        }
        String available2 = getAvailable();
        String available3 = tradeHoldBean.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        String estimateTotal2 = getEstimateTotal();
        String estimateTotal3 = tradeHoldBean.getEstimateTotal();
        if (estimateTotal2 != null ? !estimateTotal2.equals(estimateTotal3) : estimateTotal3 != null) {
            return false;
        }
        String percent2 = getPercent();
        String percent3 = tradeHoldBean.getPercent();
        if (percent2 != null ? !percent2.equals(percent3) : percent3 != null) {
            return false;
        }
        BalanceDetailInfo currencyInfo2 = getCurrencyInfo();
        BalanceDetailInfo currencyInfo3 = tradeHoldBean.getCurrencyInfo();
        return currencyInfo2 != null ? currencyInfo2.equals(currencyInfo3) : currencyInfo3 == null;
    }

    public String getAvailable() {
        return this.available;
    }

    public String getCurrency() {
        return this.currency;
    }

    public BalanceDetailInfo getCurrencyInfo() {
        return this.currencyInfo;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEstimateTotal() {
        return this.estimateTotal;
    }

    public String getFullDisplayName() {
        return this.fullDisplayName;
    }

    public String getHead() {
        return this.head;
    }

    public String getNetAsset() {
        return this.netAsset;
    }

    public String getPercent() {
        return this.percent;
    }

    public String getViewHandlerName() {
        return TradeHoldViewHandler.class.getName();
    }

    public int hashCode() {
        String head2 = getHead();
        int i11 = 43;
        int hashCode = head2 == null ? 43 : head2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String displayName2 = getDisplayName();
        int hashCode3 = (hashCode2 * 59) + (displayName2 == null ? 43 : displayName2.hashCode());
        String fullDisplayName2 = getFullDisplayName();
        int hashCode4 = (hashCode3 * 59) + (fullDisplayName2 == null ? 43 : fullDisplayName2.hashCode());
        String netAsset2 = getNetAsset();
        int hashCode5 = (hashCode4 * 59) + (netAsset2 == null ? 43 : netAsset2.hashCode());
        String available2 = getAvailable();
        int hashCode6 = (hashCode5 * 59) + (available2 == null ? 43 : available2.hashCode());
        String estimateTotal2 = getEstimateTotal();
        int hashCode7 = (hashCode6 * 59) + (estimateTotal2 == null ? 43 : estimateTotal2.hashCode());
        String percent2 = getPercent();
        int hashCode8 = (hashCode7 * 59) + (percent2 == null ? 43 : percent2.hashCode());
        BalanceDetailInfo currencyInfo2 = getCurrencyInfo();
        int i12 = hashCode8 * 59;
        if (currencyInfo2 != null) {
            i11 = currencyInfo2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrencyInfo(BalanceDetailInfo balanceDetailInfo) {
        this.currencyInfo = balanceDetailInfo;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setEstimateTotal(String str) {
        this.estimateTotal = str;
    }

    public void setFullDisplayName(String str) {
        this.fullDisplayName = str;
    }

    public void setHead(String str) {
        this.head = str;
    }

    public void setNetAsset(String str) {
        this.netAsset = str;
    }

    public void setPercent(String str) {
        this.percent = str;
    }

    public String toString() {
        return "TradeHoldBean(head=" + getHead() + ", currency=" + getCurrency() + ", displayName=" + getDisplayName() + ", fullDisplayName=" + getFullDisplayName() + ", netAsset=" + getNetAsset() + ", available=" + getAvailable() + ", estimateTotal=" + getEstimateTotal() + ", percent=" + getPercent() + ", currencyInfo=" + getCurrencyInfo() + ")";
    }
}
