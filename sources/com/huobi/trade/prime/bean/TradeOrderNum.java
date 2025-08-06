package com.huobi.trade.prime.bean;

import java.io.Serializable;

public class TradeOrderNum implements Serializable {
    private String algoCount;
    private String count;
    private String normalCount;
    private String periodCount;
    private boolean showTransfer;
    private String stopLossCount;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeOrderNum;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeOrderNum)) {
            return false;
        }
        TradeOrderNum tradeOrderNum = (TradeOrderNum) obj;
        if (!tradeOrderNum.canEqual(this)) {
            return false;
        }
        String count2 = getCount();
        String count3 = tradeOrderNum.getCount();
        if (count2 != null ? !count2.equals(count3) : count3 != null) {
            return false;
        }
        String normalCount2 = getNormalCount();
        String normalCount3 = tradeOrderNum.getNormalCount();
        if (normalCount2 != null ? !normalCount2.equals(normalCount3) : normalCount3 != null) {
            return false;
        }
        String stopLossCount2 = getStopLossCount();
        String stopLossCount3 = tradeOrderNum.getStopLossCount();
        if (stopLossCount2 != null ? !stopLossCount2.equals(stopLossCount3) : stopLossCount3 != null) {
            return false;
        }
        String algoCount2 = getAlgoCount();
        String algoCount3 = tradeOrderNum.getAlgoCount();
        if (algoCount2 != null ? !algoCount2.equals(algoCount3) : algoCount3 != null) {
            return false;
        }
        String periodCount2 = getPeriodCount();
        String periodCount3 = tradeOrderNum.getPeriodCount();
        if (periodCount2 != null ? periodCount2.equals(periodCount3) : periodCount3 == null) {
            return isShowTransfer() == tradeOrderNum.isShowTransfer();
        }
        return false;
    }

    public String getAlgoCount() {
        return this.algoCount;
    }

    public String getCount() {
        return this.count;
    }

    public String getNormalCount() {
        return this.normalCount;
    }

    public String getPeriodCount() {
        return this.periodCount;
    }

    public String getStopLossCount() {
        return this.stopLossCount;
    }

    public int hashCode() {
        String count2 = getCount();
        int i11 = 43;
        int hashCode = count2 == null ? 43 : count2.hashCode();
        String normalCount2 = getNormalCount();
        int hashCode2 = ((hashCode + 59) * 59) + (normalCount2 == null ? 43 : normalCount2.hashCode());
        String stopLossCount2 = getStopLossCount();
        int hashCode3 = (hashCode2 * 59) + (stopLossCount2 == null ? 43 : stopLossCount2.hashCode());
        String algoCount2 = getAlgoCount();
        int hashCode4 = (hashCode3 * 59) + (algoCount2 == null ? 43 : algoCount2.hashCode());
        String periodCount2 = getPeriodCount();
        int i12 = hashCode4 * 59;
        if (periodCount2 != null) {
            i11 = periodCount2.hashCode();
        }
        return ((i12 + i11) * 59) + (isShowTransfer() ? 79 : 97);
    }

    public boolean isShowTransfer() {
        return this.showTransfer;
    }

    public void setAlgoCount(String str) {
        this.algoCount = str;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setNormalCount(String str) {
        this.normalCount = str;
    }

    public void setPeriodCount(String str) {
        this.periodCount = str;
    }

    public void setShowTransfer(boolean z11) {
        this.showTransfer = z11;
    }

    public void setStopLossCount(String str) {
        this.stopLossCount = str;
    }

    public String toString() {
        return "TradeOrderNum(count=" + getCount() + ", normalCount=" + getNormalCount() + ", stopLossCount=" + getStopLossCount() + ", algoCount=" + getAlgoCount() + ", periodCount=" + getPeriodCount() + ", showTransfer=" + isShowTransfer() + ")";
    }
}
