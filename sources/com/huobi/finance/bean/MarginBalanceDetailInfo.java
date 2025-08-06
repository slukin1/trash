package com.huobi.finance.bean;

import android.text.TextUtils;
import com.huobi.finance.viewhandler.MarginBalanceViewAdapter;
import com.huobi.margin.entity.MarginBalanceQueryData;
import i6.m;
import java.math.BigDecimal;
import wi.a;

public class MarginBalanceDetailInfo extends BaseAssetInfo {
    private String baseCurrency;
    private String baseCurrencyAvaiable;
    private String baseCurrencyCredit;
    private String baseCurrencyDisplayName;
    private String baseCurrencyInterest;
    private String baseCurrencyLoaned;
    private String baseCurrencyOnorders;
    private String estimateAmount;
    private String estimateToBtc;
    private String flPrice;
    private boolean isShow = true;
    private MarginBalanceQueryData marginBalanceQueryData;
    private String quoteCurrency;
    private String quoteCurrencyAvaiable;
    private String quoteCurrencyCredit;
    private String quoteCurrencyDisplayName;
    private String quoteCurrencyInterest;
    private String quoteCurrencyLoaned;
    private String quoteCurrencyOnorders;
    private String riskRate;
    private String state;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginBalanceDetailInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginBalanceDetailInfo)) {
            return false;
        }
        MarginBalanceDetailInfo marginBalanceDetailInfo = (MarginBalanceDetailInfo) obj;
        if (!marginBalanceDetailInfo.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String baseCurrencyAvaiable2 = getBaseCurrencyAvaiable();
        String baseCurrencyAvaiable3 = marginBalanceDetailInfo.getBaseCurrencyAvaiable();
        if (baseCurrencyAvaiable2 != null ? !baseCurrencyAvaiable2.equals(baseCurrencyAvaiable3) : baseCurrencyAvaiable3 != null) {
            return false;
        }
        String quoteCurrencyAvaiable2 = getQuoteCurrencyAvaiable();
        String quoteCurrencyAvaiable3 = marginBalanceDetailInfo.getQuoteCurrencyAvaiable();
        if (quoteCurrencyAvaiable2 != null ? !quoteCurrencyAvaiable2.equals(quoteCurrencyAvaiable3) : quoteCurrencyAvaiable3 != null) {
            return false;
        }
        String baseCurrencyOnorders2 = getBaseCurrencyOnorders();
        String baseCurrencyOnorders3 = marginBalanceDetailInfo.getBaseCurrencyOnorders();
        if (baseCurrencyOnorders2 != null ? !baseCurrencyOnorders2.equals(baseCurrencyOnorders3) : baseCurrencyOnorders3 != null) {
            return false;
        }
        String quoteCurrencyOnorders2 = getQuoteCurrencyOnorders();
        String quoteCurrencyOnorders3 = marginBalanceDetailInfo.getQuoteCurrencyOnorders();
        if (quoteCurrencyOnorders2 != null ? !quoteCurrencyOnorders2.equals(quoteCurrencyOnorders3) : quoteCurrencyOnorders3 != null) {
            return false;
        }
        String baseCurrencyLoaned2 = getBaseCurrencyLoaned();
        String baseCurrencyLoaned3 = marginBalanceDetailInfo.getBaseCurrencyLoaned();
        if (baseCurrencyLoaned2 != null ? !baseCurrencyLoaned2.equals(baseCurrencyLoaned3) : baseCurrencyLoaned3 != null) {
            return false;
        }
        String quoteCurrencyLoaned2 = getQuoteCurrencyLoaned();
        String quoteCurrencyLoaned3 = marginBalanceDetailInfo.getQuoteCurrencyLoaned();
        if (quoteCurrencyLoaned2 != null ? !quoteCurrencyLoaned2.equals(quoteCurrencyLoaned3) : quoteCurrencyLoaned3 != null) {
            return false;
        }
        String baseCurrencyInterest2 = getBaseCurrencyInterest();
        String baseCurrencyInterest3 = marginBalanceDetailInfo.getBaseCurrencyInterest();
        if (baseCurrencyInterest2 != null ? !baseCurrencyInterest2.equals(baseCurrencyInterest3) : baseCurrencyInterest3 != null) {
            return false;
        }
        String quoteCurrencyInterest2 = getQuoteCurrencyInterest();
        String quoteCurrencyInterest3 = marginBalanceDetailInfo.getQuoteCurrencyInterest();
        if (quoteCurrencyInterest2 != null ? !quoteCurrencyInterest2.equals(quoteCurrencyInterest3) : quoteCurrencyInterest3 != null) {
            return false;
        }
        String baseCurrencyCredit2 = getBaseCurrencyCredit();
        String baseCurrencyCredit3 = marginBalanceDetailInfo.getBaseCurrencyCredit();
        if (baseCurrencyCredit2 != null ? !baseCurrencyCredit2.equals(baseCurrencyCredit3) : baseCurrencyCredit3 != null) {
            return false;
        }
        String quoteCurrencyCredit2 = getQuoteCurrencyCredit();
        String quoteCurrencyCredit3 = marginBalanceDetailInfo.getQuoteCurrencyCredit();
        if (quoteCurrencyCredit2 != null ? !quoteCurrencyCredit2.equals(quoteCurrencyCredit3) : quoteCurrencyCredit3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = marginBalanceDetailInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = marginBalanceDetailInfo.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String baseCurrencyDisplayName2 = getBaseCurrencyDisplayName();
        String baseCurrencyDisplayName3 = marginBalanceDetailInfo.getBaseCurrencyDisplayName();
        if (baseCurrencyDisplayName2 != null ? !baseCurrencyDisplayName2.equals(baseCurrencyDisplayName3) : baseCurrencyDisplayName3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = marginBalanceDetailInfo.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String quoteCurrencyDisplayName2 = getQuoteCurrencyDisplayName();
        String quoteCurrencyDisplayName3 = marginBalanceDetailInfo.getQuoteCurrencyDisplayName();
        if (quoteCurrencyDisplayName2 != null ? !quoteCurrencyDisplayName2.equals(quoteCurrencyDisplayName3) : quoteCurrencyDisplayName3 != null) {
            return false;
        }
        String flPrice2 = getFlPrice();
        String flPrice3 = marginBalanceDetailInfo.getFlPrice();
        if (flPrice2 != null ? !flPrice2.equals(flPrice3) : flPrice3 != null) {
            return false;
        }
        String riskRate2 = getRiskRate();
        String riskRate3 = marginBalanceDetailInfo.getRiskRate();
        if (riskRate2 != null ? !riskRate2.equals(riskRate3) : riskRate3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = marginBalanceDetailInfo.getState();
        if (state2 != null ? !state2.equals(state3) : state3 != null) {
            return false;
        }
        if (isShow() != marginBalanceDetailInfo.isShow()) {
            return false;
        }
        String estimateAmount2 = getEstimateAmount();
        String estimateAmount3 = marginBalanceDetailInfo.getEstimateAmount();
        if (estimateAmount2 != null ? !estimateAmount2.equals(estimateAmount3) : estimateAmount3 != null) {
            return false;
        }
        String estimateToBtc2 = getEstimateToBtc();
        String estimateToBtc3 = marginBalanceDetailInfo.getEstimateToBtc();
        if (estimateToBtc2 != null ? !estimateToBtc2.equals(estimateToBtc3) : estimateToBtc3 != null) {
            return false;
        }
        MarginBalanceQueryData marginBalanceQueryData2 = getMarginBalanceQueryData();
        MarginBalanceQueryData marginBalanceQueryData3 = marginBalanceDetailInfo.getMarginBalanceQueryData();
        return marginBalanceQueryData2 != null ? marginBalanceQueryData2.equals(marginBalanceQueryData3) : marginBalanceQueryData3 == null;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getBaseCurrencyAvaiable() {
        return this.baseCurrencyAvaiable;
    }

    public String getBaseCurrencyCredit() {
        return this.baseCurrencyCredit;
    }

    public String getBaseCurrencyDisplayName() {
        return this.baseCurrencyDisplayName;
    }

    public String getBaseCurrencyInterest() {
        return this.baseCurrencyInterest;
    }

    public String getBaseCurrencyLoaned() {
        return this.baseCurrencyLoaned;
    }

    public String getBaseCurrencyOnorders() {
        return this.baseCurrencyOnorders;
    }

    public String getDelegateKey() {
        return this.symbol;
    }

    public String getEstimateAmount() {
        return this.estimateAmount;
    }

    public String getEstimateToBtc() {
        return this.estimateToBtc;
    }

    public String getFlPrice() {
        return this.flPrice;
    }

    public MarginBalanceQueryData getMarginBalanceQueryData() {
        return this.marginBalanceQueryData;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteCurrencyAvaiable() {
        return this.quoteCurrencyAvaiable;
    }

    public String getQuoteCurrencyCredit() {
        return this.quoteCurrencyCredit;
    }

    public String getQuoteCurrencyDisplayName() {
        return this.quoteCurrencyDisplayName;
    }

    public String getQuoteCurrencyInterest() {
        return this.quoteCurrencyInterest;
    }

    public String getQuoteCurrencyLoaned() {
        return this.quoteCurrencyLoaned;
    }

    public String getQuoteCurrencyOnorders() {
        return this.quoteCurrencyOnorders;
    }

    public String getRiskRate() {
        return this.riskRate;
    }

    public String getState() {
        return this.state;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTitle() {
        return getBaseCurrencyDisplayName() + "/" + getQuoteCurrencyDisplayName();
    }

    public String getViewHandlerName() {
        return MarginBalanceViewAdapter.class.getName();
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        String baseCurrencyAvaiable2 = getBaseCurrencyAvaiable();
        int i11 = 43;
        int hashCode2 = (hashCode * 59) + (baseCurrencyAvaiable2 == null ? 43 : baseCurrencyAvaiable2.hashCode());
        String quoteCurrencyAvaiable2 = getQuoteCurrencyAvaiable();
        int hashCode3 = (hashCode2 * 59) + (quoteCurrencyAvaiable2 == null ? 43 : quoteCurrencyAvaiable2.hashCode());
        String baseCurrencyOnorders2 = getBaseCurrencyOnorders();
        int hashCode4 = (hashCode3 * 59) + (baseCurrencyOnorders2 == null ? 43 : baseCurrencyOnorders2.hashCode());
        String quoteCurrencyOnorders2 = getQuoteCurrencyOnorders();
        int hashCode5 = (hashCode4 * 59) + (quoteCurrencyOnorders2 == null ? 43 : quoteCurrencyOnorders2.hashCode());
        String baseCurrencyLoaned2 = getBaseCurrencyLoaned();
        int hashCode6 = (hashCode5 * 59) + (baseCurrencyLoaned2 == null ? 43 : baseCurrencyLoaned2.hashCode());
        String quoteCurrencyLoaned2 = getQuoteCurrencyLoaned();
        int hashCode7 = (hashCode6 * 59) + (quoteCurrencyLoaned2 == null ? 43 : quoteCurrencyLoaned2.hashCode());
        String baseCurrencyInterest2 = getBaseCurrencyInterest();
        int hashCode8 = (hashCode7 * 59) + (baseCurrencyInterest2 == null ? 43 : baseCurrencyInterest2.hashCode());
        String quoteCurrencyInterest2 = getQuoteCurrencyInterest();
        int hashCode9 = (hashCode8 * 59) + (quoteCurrencyInterest2 == null ? 43 : quoteCurrencyInterest2.hashCode());
        String baseCurrencyCredit2 = getBaseCurrencyCredit();
        int hashCode10 = (hashCode9 * 59) + (baseCurrencyCredit2 == null ? 43 : baseCurrencyCredit2.hashCode());
        String quoteCurrencyCredit2 = getQuoteCurrencyCredit();
        int hashCode11 = (hashCode10 * 59) + (quoteCurrencyCredit2 == null ? 43 : quoteCurrencyCredit2.hashCode());
        String symbol2 = getSymbol();
        int hashCode12 = (hashCode11 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String baseCurrency2 = getBaseCurrency();
        int hashCode13 = (hashCode12 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String baseCurrencyDisplayName2 = getBaseCurrencyDisplayName();
        int hashCode14 = (hashCode13 * 59) + (baseCurrencyDisplayName2 == null ? 43 : baseCurrencyDisplayName2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode15 = (hashCode14 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String quoteCurrencyDisplayName2 = getQuoteCurrencyDisplayName();
        int hashCode16 = (hashCode15 * 59) + (quoteCurrencyDisplayName2 == null ? 43 : quoteCurrencyDisplayName2.hashCode());
        String flPrice2 = getFlPrice();
        int hashCode17 = (hashCode16 * 59) + (flPrice2 == null ? 43 : flPrice2.hashCode());
        String riskRate2 = getRiskRate();
        int hashCode18 = (hashCode17 * 59) + (riskRate2 == null ? 43 : riskRate2.hashCode());
        String state2 = getState();
        int hashCode19 = (((hashCode18 * 59) + (state2 == null ? 43 : state2.hashCode())) * 59) + (isShow() ? 79 : 97);
        String estimateAmount2 = getEstimateAmount();
        int hashCode20 = (hashCode19 * 59) + (estimateAmount2 == null ? 43 : estimateAmount2.hashCode());
        String estimateToBtc2 = getEstimateToBtc();
        int hashCode21 = (hashCode20 * 59) + (estimateToBtc2 == null ? 43 : estimateToBtc2.hashCode());
        MarginBalanceQueryData marginBalanceQueryData2 = getMarginBalanceQueryData();
        int i12 = hashCode21 * 59;
        if (marginBalanceQueryData2 != null) {
            i11 = marginBalanceQueryData2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isLoan() {
        if (!TextUtils.isEmpty(this.baseCurrencyLoaned) && m.a(this.baseCurrencyLoaned).compareTo(BigDecimal.ZERO) != 0) {
            return true;
        }
        if (TextUtils.isEmpty(this.quoteCurrencyLoaned) || m.a(this.quoteCurrencyLoaned).compareTo(BigDecimal.ZERO) == 0) {
            return false;
        }
        return true;
    }

    public boolean isMinAmountAsset() {
        try {
            BigDecimal bigDecimal = new BigDecimal(this.estimateToBtc);
            if (bigDecimal.compareTo(a.f48036a) >= 0 || bigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                return false;
            }
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return true;
        }
    }

    public boolean isShow() {
        return this.isShow;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBaseCurrencyAvaiable(String str) {
        this.baseCurrencyAvaiable = str;
    }

    public void setBaseCurrencyCredit(String str) {
        this.baseCurrencyCredit = str;
    }

    public void setBaseCurrencyDisplayName(String str) {
        this.baseCurrencyDisplayName = str;
    }

    public void setBaseCurrencyInterest(String str) {
        this.baseCurrencyInterest = str;
    }

    public void setBaseCurrencyLoaned(String str) {
        this.baseCurrencyLoaned = str;
    }

    public void setBaseCurrencyOnorders(String str) {
        this.baseCurrencyOnorders = str;
    }

    public void setEstimateAmount(String str) {
        this.estimateAmount = str;
    }

    public void setEstimateToBtc(String str) {
        this.estimateToBtc = str;
    }

    public void setFlPrice(String str) {
        this.flPrice = str;
    }

    public void setMarginBalanceQueryData(MarginBalanceQueryData marginBalanceQueryData2) {
        this.marginBalanceQueryData = marginBalanceQueryData2;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuoteCurrencyAvaiable(String str) {
        this.quoteCurrencyAvaiable = str;
    }

    public void setQuoteCurrencyCredit(String str) {
        this.quoteCurrencyCredit = str;
    }

    public void setQuoteCurrencyDisplayName(String str) {
        this.quoteCurrencyDisplayName = str;
    }

    public void setQuoteCurrencyInterest(String str) {
        this.quoteCurrencyInterest = str;
    }

    public void setQuoteCurrencyLoaned(String str) {
        this.quoteCurrencyLoaned = str;
    }

    public void setQuoteCurrencyOnorders(String str) {
        this.quoteCurrencyOnorders = str;
    }

    public void setRiskRate(String str) {
        this.riskRate = str;
    }

    public void setShow(boolean z11) {
        this.isShow = z11;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "MarginBalanceDetailInfo(baseCurrencyAvaiable=" + getBaseCurrencyAvaiable() + ", quoteCurrencyAvaiable=" + getQuoteCurrencyAvaiable() + ", baseCurrencyOnorders=" + getBaseCurrencyOnorders() + ", quoteCurrencyOnorders=" + getQuoteCurrencyOnorders() + ", baseCurrencyLoaned=" + getBaseCurrencyLoaned() + ", quoteCurrencyLoaned=" + getQuoteCurrencyLoaned() + ", baseCurrencyInterest=" + getBaseCurrencyInterest() + ", quoteCurrencyInterest=" + getQuoteCurrencyInterest() + ", baseCurrencyCredit=" + getBaseCurrencyCredit() + ", quoteCurrencyCredit=" + getQuoteCurrencyCredit() + ", symbol=" + getSymbol() + ", baseCurrency=" + getBaseCurrency() + ", baseCurrencyDisplayName=" + getBaseCurrencyDisplayName() + ", quoteCurrency=" + getQuoteCurrency() + ", quoteCurrencyDisplayName=" + getQuoteCurrencyDisplayName() + ", flPrice=" + getFlPrice() + ", riskRate=" + getRiskRate() + ", state=" + getState() + ", isShow=" + isShow() + ", estimateAmount=" + getEstimateAmount() + ", estimateToBtc=" + getEstimateToBtc() + ", marginBalanceQueryData=" + getMarginBalanceQueryData() + ")";
    }
}
