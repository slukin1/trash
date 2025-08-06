package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BotRank implements Serializable {
    @SerializedName("copyNum")
    private int copyNum;
    @SerializedName("floatProfitAmount")
    private String floatProfitAmount;
    @SerializedName("gridNum")
    private int gridNum;
    @SerializedName("gridProfitAmount")
    private String gridProfitAmount;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    private long f70226id;
    @SerializedName("matchRate")
    private String matchRate;
    @SerializedName("maxPrice")
    private String maxPrice;
    @SerializedName("minPrice")
    private String minPrice;
    @SerializedName("no")

    /* renamed from: no  reason: collision with root package name */
    private String f70227no;
    @SerializedName("perMaxProfitRate")
    private String perMaxProfitRate;
    @SerializedName("perMinProfitRate")
    private String perMinProfitRate;
    @SerializedName("profitNum")
    private int profitNum;
    @SerializedName("runTime")
    private Long runTime;
    @SerializedName("runType")
    private int runType;
    @SerializedName("startPrice")
    private String startPrice;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("symbolShow")
    private String symbolShow;
    @SerializedName("totalInvestAmount")
    private String totalInvestAmount;
    @SerializedName("totalProfitAmount")
    private String totalProfitAmount;
    @SerializedName("totalProfitRate")
    private String totalProfitRate;
    @SerializedName("userId")
    private long userId;
    @SerializedName("yieldRate")
    private String yieldRate;

    public boolean canEqual(Object obj) {
        return obj instanceof BotRank;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BotRank)) {
            return false;
        }
        BotRank botRank = (BotRank) obj;
        if (!botRank.canEqual(this)) {
            return false;
        }
        String no2 = getNo();
        String no3 = botRank.getNo();
        if (no2 != null ? !no2.equals(no3) : no3 != null) {
            return false;
        }
        if (getId() != botRank.getId() || getCopyNum() != botRank.getCopyNum() || getUserId() != botRank.getUserId()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = botRank.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String symbolShow2 = getSymbolShow();
        String symbolShow3 = botRank.getSymbolShow();
        if (symbolShow2 != null ? !symbolShow2.equals(symbolShow3) : symbolShow3 != null) {
            return false;
        }
        String startPrice2 = getStartPrice();
        String startPrice3 = botRank.getStartPrice();
        if (startPrice2 != null ? !startPrice2.equals(startPrice3) : startPrice3 != null) {
            return false;
        }
        if (getRunType() != botRank.getRunType()) {
            return false;
        }
        String minPrice2 = getMinPrice();
        String minPrice3 = botRank.getMinPrice();
        if (minPrice2 != null ? !minPrice2.equals(minPrice3) : minPrice3 != null) {
            return false;
        }
        String maxPrice2 = getMaxPrice();
        String maxPrice3 = botRank.getMaxPrice();
        if (maxPrice2 != null ? !maxPrice2.equals(maxPrice3) : maxPrice3 != null) {
            return false;
        }
        if (getGridNum() != botRank.getGridNum()) {
            return false;
        }
        String perMinProfitRate2 = getPerMinProfitRate();
        String perMinProfitRate3 = botRank.getPerMinProfitRate();
        if (perMinProfitRate2 != null ? !perMinProfitRate2.equals(perMinProfitRate3) : perMinProfitRate3 != null) {
            return false;
        }
        String perMaxProfitRate2 = getPerMaxProfitRate();
        String perMaxProfitRate3 = botRank.getPerMaxProfitRate();
        if (perMaxProfitRate2 != null ? !perMaxProfitRate2.equals(perMaxProfitRate3) : perMaxProfitRate3 != null) {
            return false;
        }
        String yieldRate2 = getYieldRate();
        String yieldRate3 = botRank.getYieldRate();
        if (yieldRate2 != null ? !yieldRate2.equals(yieldRate3) : yieldRate3 != null) {
            return false;
        }
        String totalInvestAmount2 = getTotalInvestAmount();
        String totalInvestAmount3 = botRank.getTotalInvestAmount();
        if (totalInvestAmount2 != null ? !totalInvestAmount2.equals(totalInvestAmount3) : totalInvestAmount3 != null) {
            return false;
        }
        String totalProfitAmount2 = getTotalProfitAmount();
        String totalProfitAmount3 = botRank.getTotalProfitAmount();
        if (totalProfitAmount2 != null ? !totalProfitAmount2.equals(totalProfitAmount3) : totalProfitAmount3 != null) {
            return false;
        }
        String floatProfitAmount2 = getFloatProfitAmount();
        String floatProfitAmount3 = botRank.getFloatProfitAmount();
        if (floatProfitAmount2 != null ? !floatProfitAmount2.equals(floatProfitAmount3) : floatProfitAmount3 != null) {
            return false;
        }
        String gridProfitAmount2 = getGridProfitAmount();
        String gridProfitAmount3 = botRank.getGridProfitAmount();
        if (gridProfitAmount2 != null ? !gridProfitAmount2.equals(gridProfitAmount3) : gridProfitAmount3 != null) {
            return false;
        }
        String totalProfitRate2 = getTotalProfitRate();
        String totalProfitRate3 = botRank.getTotalProfitRate();
        if (totalProfitRate2 != null ? !totalProfitRate2.equals(totalProfitRate3) : totalProfitRate3 != null) {
            return false;
        }
        if (getProfitNum() != botRank.getProfitNum()) {
            return false;
        }
        String matchRate2 = getMatchRate();
        String matchRate3 = botRank.getMatchRate();
        if (matchRate2 != null ? !matchRate2.equals(matchRate3) : matchRate3 != null) {
            return false;
        }
        Long runTime2 = getRunTime();
        Long runTime3 = botRank.getRunTime();
        return runTime2 != null ? runTime2.equals(runTime3) : runTime3 == null;
    }

    public int getCopyNum() {
        return this.copyNum;
    }

    public String getFloatProfitAmount() {
        return this.floatProfitAmount;
    }

    public int getGridNum() {
        return this.gridNum;
    }

    public String getGridProfitAmount() {
        return this.gridProfitAmount;
    }

    public long getId() {
        return this.f70226id;
    }

    public String getMatchRate() {
        return this.matchRate;
    }

    public String getMaxPrice() {
        return this.maxPrice;
    }

    public String getMinPrice() {
        return this.minPrice;
    }

    public String getNo() {
        return this.f70227no;
    }

    public String getPerMaxProfitRate() {
        return this.perMaxProfitRate;
    }

    public String getPerMinProfitRate() {
        return this.perMinProfitRate;
    }

    public int getProfitNum() {
        return this.profitNum;
    }

    public Long getRunTime() {
        return this.runTime;
    }

    public int getRunType() {
        return this.runType;
    }

    public String getStartPrice() {
        return this.startPrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getSymbolShow() {
        return this.symbolShow;
    }

    public String getTotalInvestAmount() {
        return this.totalInvestAmount;
    }

    public String getTotalProfitAmount() {
        return this.totalProfitAmount;
    }

    public String getTotalProfitRate() {
        return this.totalProfitRate;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getYieldRate() {
        return this.yieldRate;
    }

    public int hashCode() {
        String no2 = getNo();
        int i11 = 43;
        int hashCode = no2 == null ? 43 : no2.hashCode();
        long id2 = getId();
        int copyNum2 = ((((hashCode + 59) * 59) + ((int) (id2 ^ (id2 >>> 32)))) * 59) + getCopyNum();
        long userId2 = getUserId();
        int i12 = (copyNum2 * 59) + ((int) (userId2 ^ (userId2 >>> 32)));
        String symbol2 = getSymbol();
        int hashCode2 = (i12 * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String symbolShow2 = getSymbolShow();
        int hashCode3 = (hashCode2 * 59) + (symbolShow2 == null ? 43 : symbolShow2.hashCode());
        String startPrice2 = getStartPrice();
        int hashCode4 = (((hashCode3 * 59) + (startPrice2 == null ? 43 : startPrice2.hashCode())) * 59) + getRunType();
        String minPrice2 = getMinPrice();
        int hashCode5 = (hashCode4 * 59) + (minPrice2 == null ? 43 : minPrice2.hashCode());
        String maxPrice2 = getMaxPrice();
        int hashCode6 = (((hashCode5 * 59) + (maxPrice2 == null ? 43 : maxPrice2.hashCode())) * 59) + getGridNum();
        String perMinProfitRate2 = getPerMinProfitRate();
        int hashCode7 = (hashCode6 * 59) + (perMinProfitRate2 == null ? 43 : perMinProfitRate2.hashCode());
        String perMaxProfitRate2 = getPerMaxProfitRate();
        int hashCode8 = (hashCode7 * 59) + (perMaxProfitRate2 == null ? 43 : perMaxProfitRate2.hashCode());
        String yieldRate2 = getYieldRate();
        int hashCode9 = (hashCode8 * 59) + (yieldRate2 == null ? 43 : yieldRate2.hashCode());
        String totalInvestAmount2 = getTotalInvestAmount();
        int hashCode10 = (hashCode9 * 59) + (totalInvestAmount2 == null ? 43 : totalInvestAmount2.hashCode());
        String totalProfitAmount2 = getTotalProfitAmount();
        int hashCode11 = (hashCode10 * 59) + (totalProfitAmount2 == null ? 43 : totalProfitAmount2.hashCode());
        String floatProfitAmount2 = getFloatProfitAmount();
        int hashCode12 = (hashCode11 * 59) + (floatProfitAmount2 == null ? 43 : floatProfitAmount2.hashCode());
        String gridProfitAmount2 = getGridProfitAmount();
        int hashCode13 = (hashCode12 * 59) + (gridProfitAmount2 == null ? 43 : gridProfitAmount2.hashCode());
        String totalProfitRate2 = getTotalProfitRate();
        int hashCode14 = (((hashCode13 * 59) + (totalProfitRate2 == null ? 43 : totalProfitRate2.hashCode())) * 59) + getProfitNum();
        String matchRate2 = getMatchRate();
        int hashCode15 = (hashCode14 * 59) + (matchRate2 == null ? 43 : matchRate2.hashCode());
        Long runTime2 = getRunTime();
        int i13 = hashCode15 * 59;
        if (runTime2 != null) {
            i11 = runTime2.hashCode();
        }
        return i13 + i11;
    }

    public void setCopyNum(int i11) {
        this.copyNum = i11;
    }

    public void setFloatProfitAmount(String str) {
        this.floatProfitAmount = str;
    }

    public void setGridNum(int i11) {
        this.gridNum = i11;
    }

    public void setGridProfitAmount(String str) {
        this.gridProfitAmount = str;
    }

    public void setId(long j11) {
        this.f70226id = j11;
    }

    public void setMatchRate(String str) {
        this.matchRate = str;
    }

    public void setMaxPrice(String str) {
        this.maxPrice = str;
    }

    public void setMinPrice(String str) {
        this.minPrice = str;
    }

    public void setNo(String str) {
        this.f70227no = str;
    }

    public void setPerMaxProfitRate(String str) {
        this.perMaxProfitRate = str;
    }

    public void setPerMinProfitRate(String str) {
        this.perMinProfitRate = str;
    }

    public void setProfitNum(int i11) {
        this.profitNum = i11;
    }

    public void setRunTime(Long l11) {
        this.runTime = l11;
    }

    public void setRunType(int i11) {
        this.runType = i11;
    }

    public void setStartPrice(String str) {
        this.startPrice = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setSymbolShow(String str) {
        this.symbolShow = str;
    }

    public void setTotalInvestAmount(String str) {
        this.totalInvestAmount = str;
    }

    public void setTotalProfitAmount(String str) {
        this.totalProfitAmount = str;
    }

    public void setTotalProfitRate(String str) {
        this.totalProfitRate = str;
    }

    public void setUserId(long j11) {
        this.userId = j11;
    }

    public void setYieldRate(String str) {
        this.yieldRate = str;
    }

    public String toString() {
        return "BotRank(no=" + getNo() + ", id=" + getId() + ", copyNum=" + getCopyNum() + ", userId=" + getUserId() + ", symbol=" + getSymbol() + ", symbolShow=" + getSymbolShow() + ", startPrice=" + getStartPrice() + ", runType=" + getRunType() + ", minPrice=" + getMinPrice() + ", maxPrice=" + getMaxPrice() + ", gridNum=" + getGridNum() + ", perMinProfitRate=" + getPerMinProfitRate() + ", perMaxProfitRate=" + getPerMaxProfitRate() + ", yieldRate=" + getYieldRate() + ", totalInvestAmount=" + getTotalInvestAmount() + ", totalProfitAmount=" + getTotalProfitAmount() + ", floatProfitAmount=" + getFloatProfitAmount() + ", gridProfitAmount=" + getGridProfitAmount() + ", totalProfitRate=" + getTotalProfitRate() + ", profitNum=" + getProfitNum() + ", matchRate=" + getMatchRate() + ", runTime=" + getRunTime() + ")";
    }
}
