package com.hbg.lib.network.hbg.grid.bean;

import java.io.Serializable;
import java.util.List;

public class GridAccountConvertInfo implements Serializable {
    private static final long serialVersionUID = -6860166581145515242L;
    private String baseAmount;
    private String baseCurrency;
    private String quoteAmount;
    private String quoteCurrency;
    private List<GridAccountRunningStrategyInfo> runningstrategys;
    private String symbol;
    private String symbolShow;
    private String totalEstimateBtc;

    public boolean canEqual(Object obj) {
        return obj instanceof GridAccountConvertInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridAccountConvertInfo)) {
            return false;
        }
        GridAccountConvertInfo gridAccountConvertInfo = (GridAccountConvertInfo) obj;
        if (!gridAccountConvertInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = gridAccountConvertInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String symbolShow2 = getSymbolShow();
        String symbolShow3 = gridAccountConvertInfo.getSymbolShow();
        if (symbolShow2 != null ? !symbolShow2.equals(symbolShow3) : symbolShow3 != null) {
            return false;
        }
        String totalEstimateBtc2 = getTotalEstimateBtc();
        String totalEstimateBtc3 = gridAccountConvertInfo.getTotalEstimateBtc();
        if (totalEstimateBtc2 != null ? !totalEstimateBtc2.equals(totalEstimateBtc3) : totalEstimateBtc3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = gridAccountConvertInfo.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = gridAccountConvertInfo.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String baseAmount2 = getBaseAmount();
        String baseAmount3 = gridAccountConvertInfo.getBaseAmount();
        if (baseAmount2 != null ? !baseAmount2.equals(baseAmount3) : baseAmount3 != null) {
            return false;
        }
        String quoteAmount2 = getQuoteAmount();
        String quoteAmount3 = gridAccountConvertInfo.getQuoteAmount();
        if (quoteAmount2 != null ? !quoteAmount2.equals(quoteAmount3) : quoteAmount3 != null) {
            return false;
        }
        List<GridAccountRunningStrategyInfo> runningstrategys2 = getRunningstrategys();
        List<GridAccountRunningStrategyInfo> runningstrategys3 = gridAccountConvertInfo.getRunningstrategys();
        return runningstrategys2 != null ? runningstrategys2.equals(runningstrategys3) : runningstrategys3 == null;
    }

    public String getBaseAmount() {
        return this.baseAmount;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getQuoteAmount() {
        return this.quoteAmount;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public List<GridAccountRunningStrategyInfo> getRunningstrategys() {
        return this.runningstrategys;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getSymbolShow() {
        return this.symbolShow;
    }

    public String getTotalEstimateBtc() {
        return this.totalEstimateBtc;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String symbolShow2 = getSymbolShow();
        int hashCode2 = ((hashCode + 59) * 59) + (symbolShow2 == null ? 43 : symbolShow2.hashCode());
        String totalEstimateBtc2 = getTotalEstimateBtc();
        int hashCode3 = (hashCode2 * 59) + (totalEstimateBtc2 == null ? 43 : totalEstimateBtc2.hashCode());
        String baseCurrency2 = getBaseCurrency();
        int hashCode4 = (hashCode3 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode5 = (hashCode4 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String baseAmount2 = getBaseAmount();
        int hashCode6 = (hashCode5 * 59) + (baseAmount2 == null ? 43 : baseAmount2.hashCode());
        String quoteAmount2 = getQuoteAmount();
        int hashCode7 = (hashCode6 * 59) + (quoteAmount2 == null ? 43 : quoteAmount2.hashCode());
        List<GridAccountRunningStrategyInfo> runningstrategys2 = getRunningstrategys();
        int i12 = hashCode7 * 59;
        if (runningstrategys2 != null) {
            i11 = runningstrategys2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseAmount(String str) {
        this.baseAmount = str;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setQuoteAmount(String str) {
        this.quoteAmount = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setRunningstrategys(List<GridAccountRunningStrategyInfo> list) {
        this.runningstrategys = list;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setSymbolShow(String str) {
        this.symbolShow = str;
    }

    public void setTotalEstimateBtc(String str) {
        this.totalEstimateBtc = str;
    }

    public String toString() {
        return "GridAccountConvertInfo(symbol=" + getSymbol() + ", symbolShow=" + getSymbolShow() + ", totalEstimateBtc=" + getTotalEstimateBtc() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", baseAmount=" + getBaseAmount() + ", quoteAmount=" + getQuoteAmount() + ", runningstrategys=" + getRunningstrategys() + ")";
    }
}
