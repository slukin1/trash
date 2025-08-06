package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class EtpRebalInfo implements Serializable {
    public static int OPTION_STATE_NORMAL = 0;
    public static int OPTION_STATE_NOT_NORMAL = 1;
    private static final long serialVersionUID = -3442504165262578225L;
    private String actualLeverage;
    private String chargeFee;
    private long chargeFeeTime;
    private String currency;
    private String currencyName;
    private String equityDeviationRate;
    private String leverageCoefficient;
    private int leverageRatio;
    private int optionState;
    private String rebalNav;
    private int rebalThreshold;
    private Long rebalTime;
    private String spotSymbol;
    private Long todayUnTimeRebalTime;

    public boolean canEqual(Object obj) {
        return obj instanceof EtpRebalInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtpRebalInfo)) {
            return false;
        }
        EtpRebalInfo etpRebalInfo = (EtpRebalInfo) obj;
        if (!etpRebalInfo.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = etpRebalInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String currencyName2 = getCurrencyName();
        String currencyName3 = etpRebalInfo.getCurrencyName();
        if (currencyName2 != null ? !currencyName2.equals(currencyName3) : currencyName3 != null) {
            return false;
        }
        String spotSymbol2 = getSpotSymbol();
        String spotSymbol3 = etpRebalInfo.getSpotSymbol();
        if (spotSymbol2 != null ? !spotSymbol2.equals(spotSymbol3) : spotSymbol3 != null) {
            return false;
        }
        Long todayUnTimeRebalTime2 = getTodayUnTimeRebalTime();
        Long todayUnTimeRebalTime3 = etpRebalInfo.getTodayUnTimeRebalTime();
        if (todayUnTimeRebalTime2 != null ? !todayUnTimeRebalTime2.equals(todayUnTimeRebalTime3) : todayUnTimeRebalTime3 != null) {
            return false;
        }
        Long rebalTime2 = getRebalTime();
        Long rebalTime3 = etpRebalInfo.getRebalTime();
        if (rebalTime2 != null ? !rebalTime2.equals(rebalTime3) : rebalTime3 != null) {
            return false;
        }
        String rebalNav2 = getRebalNav();
        String rebalNav3 = etpRebalInfo.getRebalNav();
        if (rebalNav2 != null ? !rebalNav2.equals(rebalNav3) : rebalNav3 != null) {
            return false;
        }
        if (getOptionState() != etpRebalInfo.getOptionState() || getLeverageRatio() != etpRebalInfo.getLeverageRatio() || getRebalThreshold() != etpRebalInfo.getRebalThreshold()) {
            return false;
        }
        String actualLeverage2 = getActualLeverage();
        String actualLeverage3 = etpRebalInfo.getActualLeverage();
        if (actualLeverage2 != null ? !actualLeverage2.equals(actualLeverage3) : actualLeverage3 != null) {
            return false;
        }
        String equityDeviationRate2 = getEquityDeviationRate();
        String equityDeviationRate3 = etpRebalInfo.getEquityDeviationRate();
        if (equityDeviationRate2 != null ? !equityDeviationRate2.equals(equityDeviationRate3) : equityDeviationRate3 != null) {
            return false;
        }
        String leverageCoefficient2 = getLeverageCoefficient();
        String leverageCoefficient3 = etpRebalInfo.getLeverageCoefficient();
        if (leverageCoefficient2 != null ? !leverageCoefficient2.equals(leverageCoefficient3) : leverageCoefficient3 != null) {
            return false;
        }
        if (getChargeFeeTime() != etpRebalInfo.getChargeFeeTime()) {
            return false;
        }
        String chargeFee2 = getChargeFee();
        String chargeFee3 = etpRebalInfo.getChargeFee();
        return chargeFee2 != null ? chargeFee2.equals(chargeFee3) : chargeFee3 == null;
    }

    public String getActualLeverage() {
        return this.actualLeverage;
    }

    public String getChargeFee() {
        return this.chargeFee;
    }

    public long getChargeFeeTime() {
        return this.chargeFeeTime;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public String getEquityDeviationRate() {
        return this.equityDeviationRate;
    }

    public String getLeverageCoefficient() {
        return this.leverageCoefficient;
    }

    public int getLeverageRatio() {
        return this.leverageRatio;
    }

    public int getOptionState() {
        return this.optionState;
    }

    public String getRebalNav() {
        return this.rebalNav;
    }

    public int getRebalThreshold() {
        return this.rebalThreshold;
    }

    public Long getRebalTime() {
        return this.rebalTime;
    }

    public String getSpotSymbol() {
        return this.spotSymbol;
    }

    public Long getTodayUnTimeRebalTime() {
        return this.todayUnTimeRebalTime;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String currencyName2 = getCurrencyName();
        int hashCode2 = ((hashCode + 59) * 59) + (currencyName2 == null ? 43 : currencyName2.hashCode());
        String spotSymbol2 = getSpotSymbol();
        int hashCode3 = (hashCode2 * 59) + (spotSymbol2 == null ? 43 : spotSymbol2.hashCode());
        Long todayUnTimeRebalTime2 = getTodayUnTimeRebalTime();
        int hashCode4 = (hashCode3 * 59) + (todayUnTimeRebalTime2 == null ? 43 : todayUnTimeRebalTime2.hashCode());
        Long rebalTime2 = getRebalTime();
        int hashCode5 = (hashCode4 * 59) + (rebalTime2 == null ? 43 : rebalTime2.hashCode());
        String rebalNav2 = getRebalNav();
        int hashCode6 = (((((((hashCode5 * 59) + (rebalNav2 == null ? 43 : rebalNav2.hashCode())) * 59) + getOptionState()) * 59) + getLeverageRatio()) * 59) + getRebalThreshold();
        String actualLeverage2 = getActualLeverage();
        int hashCode7 = (hashCode6 * 59) + (actualLeverage2 == null ? 43 : actualLeverage2.hashCode());
        String equityDeviationRate2 = getEquityDeviationRate();
        int hashCode8 = (hashCode7 * 59) + (equityDeviationRate2 == null ? 43 : equityDeviationRate2.hashCode());
        String leverageCoefficient2 = getLeverageCoefficient();
        int hashCode9 = (hashCode8 * 59) + (leverageCoefficient2 == null ? 43 : leverageCoefficient2.hashCode());
        long chargeFeeTime2 = getChargeFeeTime();
        int i12 = (hashCode9 * 59) + ((int) (chargeFeeTime2 ^ (chargeFeeTime2 >>> 32)));
        String chargeFee2 = getChargeFee();
        int i13 = i12 * 59;
        if (chargeFee2 != null) {
            i11 = chargeFee2.hashCode();
        }
        return i13 + i11;
    }

    public void setActualLeverage(String str) {
        this.actualLeverage = str;
    }

    public void setChargeFee(String str) {
        this.chargeFee = str;
    }

    public void setChargeFeeTime(long j11) {
        this.chargeFeeTime = j11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrencyName(String str) {
        this.currencyName = str;
    }

    public void setEquityDeviationRate(String str) {
        this.equityDeviationRate = str;
    }

    public void setLeverageCoefficient(String str) {
        this.leverageCoefficient = str;
    }

    public void setLeverageRatio(int i11) {
        this.leverageRatio = i11;
    }

    public void setOptionState(int i11) {
        this.optionState = i11;
    }

    public void setRebalNav(String str) {
        this.rebalNav = str;
    }

    public void setRebalThreshold(int i11) {
        this.rebalThreshold = i11;
    }

    public void setRebalTime(Long l11) {
        this.rebalTime = l11;
    }

    public void setSpotSymbol(String str) {
        this.spotSymbol = str;
    }

    public void setTodayUnTimeRebalTime(Long l11) {
        this.todayUnTimeRebalTime = l11;
    }

    public String toString() {
        return "EtpRebalInfo(currency=" + getCurrency() + ", currencyName=" + getCurrencyName() + ", spotSymbol=" + getSpotSymbol() + ", todayUnTimeRebalTime=" + getTodayUnTimeRebalTime() + ", rebalTime=" + getRebalTime() + ", rebalNav=" + getRebalNav() + ", optionState=" + getOptionState() + ", leverageRatio=" + getLeverageRatio() + ", rebalThreshold=" + getRebalThreshold() + ", actualLeverage=" + getActualLeverage() + ", equityDeviationRate=" + getEquityDeviationRate() + ", leverageCoefficient=" + getLeverageCoefficient() + ", chargeFeeTime=" + getChargeFeeTime() + ", chargeFee=" + getChargeFee() + ")";
    }
}
