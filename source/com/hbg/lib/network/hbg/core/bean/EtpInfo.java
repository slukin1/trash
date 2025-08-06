package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class EtpInfo implements Serializable {
    private List<Basket> basket;
    private double chargeAmount;
    private String chargeFee;
    private String chargeFeeTime;
    private double creationAmount;
    private String currency;
    private String currencyIntroduce;
    private String currencyName;
    private String initNav;
    private String initUnit;
    private String lastChargeFee;
    private int leverageRatio;
    private String rebalTimeRule;
    private String rebalUnTimeRule;
    private String spotSymbol;

    public static class Basket implements Serializable {
        private double amount;
        private String currency;

        public boolean canEqual(Object obj) {
            return obj instanceof Basket;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Basket)) {
                return false;
            }
            Basket basket = (Basket) obj;
            if (!basket.canEqual(this)) {
                return false;
            }
            String currency2 = getCurrency();
            String currency3 = basket.getCurrency();
            if (currency2 != null ? currency2.equals(currency3) : currency3 == null) {
                return Double.compare(getAmount(), basket.getAmount()) == 0;
            }
            return false;
        }

        public double getAmount() {
            return this.amount;
        }

        public String getCurrency() {
            return this.currency;
        }

        public int hashCode() {
            String currency2 = getCurrency();
            int hashCode = currency2 == null ? 43 : currency2.hashCode();
            long doubleToLongBits = Double.doubleToLongBits(getAmount());
            return ((hashCode + 59) * 59) + ((int) ((doubleToLongBits >>> 32) ^ doubleToLongBits));
        }

        public void setAmount(double d11) {
            this.amount = d11;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public String toString() {
            return "EtpInfo.Basket(currency=" + getCurrency() + ", amount=" + getAmount() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof EtpInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtpInfo)) {
            return false;
        }
        EtpInfo etpInfo = (EtpInfo) obj;
        if (!etpInfo.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = etpInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        if (Double.compare(getCreationAmount(), etpInfo.getCreationAmount()) != 0 || Double.compare(getChargeAmount(), etpInfo.getChargeAmount()) != 0) {
            return false;
        }
        List<Basket> basket2 = getBasket();
        List<Basket> basket3 = etpInfo.getBasket();
        if (basket2 != null ? !basket2.equals(basket3) : basket3 != null) {
            return false;
        }
        String initNav2 = getInitNav();
        String initNav3 = etpInfo.getInitNav();
        if (initNav2 != null ? !initNav2.equals(initNav3) : initNav3 != null) {
            return false;
        }
        String initUnit2 = getInitUnit();
        String initUnit3 = etpInfo.getInitUnit();
        if (initUnit2 != null ? !initUnit2.equals(initUnit3) : initUnit3 != null) {
            return false;
        }
        String chargeFee2 = getChargeFee();
        String chargeFee3 = etpInfo.getChargeFee();
        if (chargeFee2 != null ? !chargeFee2.equals(chargeFee3) : chargeFee3 != null) {
            return false;
        }
        String lastChargeFee2 = getLastChargeFee();
        String lastChargeFee3 = etpInfo.getLastChargeFee();
        if (lastChargeFee2 != null ? !lastChargeFee2.equals(lastChargeFee3) : lastChargeFee3 != null) {
            return false;
        }
        String chargeFeeTime2 = getChargeFeeTime();
        String chargeFeeTime3 = etpInfo.getChargeFeeTime();
        if (chargeFeeTime2 != null ? !chargeFeeTime2.equals(chargeFeeTime3) : chargeFeeTime3 != null) {
            return false;
        }
        String currencyIntroduce2 = getCurrencyIntroduce();
        String currencyIntroduce3 = etpInfo.getCurrencyIntroduce();
        if (currencyIntroduce2 != null ? !currencyIntroduce2.equals(currencyIntroduce3) : currencyIntroduce3 != null) {
            return false;
        }
        String rebalTimeRule2 = getRebalTimeRule();
        String rebalTimeRule3 = etpInfo.getRebalTimeRule();
        if (rebalTimeRule2 != null ? !rebalTimeRule2.equals(rebalTimeRule3) : rebalTimeRule3 != null) {
            return false;
        }
        String rebalUnTimeRule2 = getRebalUnTimeRule();
        String rebalUnTimeRule3 = etpInfo.getRebalUnTimeRule();
        if (rebalUnTimeRule2 != null ? !rebalUnTimeRule2.equals(rebalUnTimeRule3) : rebalUnTimeRule3 != null) {
            return false;
        }
        String currencyName2 = getCurrencyName();
        String currencyName3 = etpInfo.getCurrencyName();
        if (currencyName2 != null ? !currencyName2.equals(currencyName3) : currencyName3 != null) {
            return false;
        }
        String spotSymbol2 = getSpotSymbol();
        String spotSymbol3 = etpInfo.getSpotSymbol();
        if (spotSymbol2 != null ? spotSymbol2.equals(spotSymbol3) : spotSymbol3 == null) {
            return getLeverageRatio() == etpInfo.getLeverageRatio();
        }
        return false;
    }

    public List<Basket> getBasket() {
        return this.basket;
    }

    public double getChargeAmount() {
        return this.chargeAmount;
    }

    public String getChargeFee() {
        return this.chargeFee;
    }

    public String getChargeFeeTime() {
        return this.chargeFeeTime;
    }

    public double getCreationAmount() {
        return this.creationAmount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCurrencyIntroduce() {
        return this.currencyIntroduce;
    }

    public String getCurrencyName() {
        return this.currencyName;
    }

    public String getInitNav() {
        return this.initNav;
    }

    public String getInitUnit() {
        return this.initUnit;
    }

    public String getLastChargeFee() {
        return this.lastChargeFee;
    }

    public int getLeverageRatio() {
        return this.leverageRatio;
    }

    public String getRebalTimeRule() {
        return this.rebalTimeRule;
    }

    public String getRebalUnTimeRule() {
        return this.rebalUnTimeRule;
    }

    public String getSpotSymbol() {
        return this.spotSymbol;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(getCreationAmount());
        int i12 = ((hashCode + 59) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(getChargeAmount());
        int i13 = (i12 * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        List<Basket> basket2 = getBasket();
        int hashCode2 = (i13 * 59) + (basket2 == null ? 43 : basket2.hashCode());
        String initNav2 = getInitNav();
        int hashCode3 = (hashCode2 * 59) + (initNav2 == null ? 43 : initNav2.hashCode());
        String initUnit2 = getInitUnit();
        int hashCode4 = (hashCode3 * 59) + (initUnit2 == null ? 43 : initUnit2.hashCode());
        String chargeFee2 = getChargeFee();
        int hashCode5 = (hashCode4 * 59) + (chargeFee2 == null ? 43 : chargeFee2.hashCode());
        String lastChargeFee2 = getLastChargeFee();
        int hashCode6 = (hashCode5 * 59) + (lastChargeFee2 == null ? 43 : lastChargeFee2.hashCode());
        String chargeFeeTime2 = getChargeFeeTime();
        int hashCode7 = (hashCode6 * 59) + (chargeFeeTime2 == null ? 43 : chargeFeeTime2.hashCode());
        String currencyIntroduce2 = getCurrencyIntroduce();
        int hashCode8 = (hashCode7 * 59) + (currencyIntroduce2 == null ? 43 : currencyIntroduce2.hashCode());
        String rebalTimeRule2 = getRebalTimeRule();
        int hashCode9 = (hashCode8 * 59) + (rebalTimeRule2 == null ? 43 : rebalTimeRule2.hashCode());
        String rebalUnTimeRule2 = getRebalUnTimeRule();
        int hashCode10 = (hashCode9 * 59) + (rebalUnTimeRule2 == null ? 43 : rebalUnTimeRule2.hashCode());
        String currencyName2 = getCurrencyName();
        int hashCode11 = (hashCode10 * 59) + (currencyName2 == null ? 43 : currencyName2.hashCode());
        String spotSymbol2 = getSpotSymbol();
        int i14 = hashCode11 * 59;
        if (spotSymbol2 != null) {
            i11 = spotSymbol2.hashCode();
        }
        return ((i14 + i11) * 59) + getLeverageRatio();
    }

    public void setBasket(List<Basket> list) {
        this.basket = list;
    }

    public void setChargeAmount(double d11) {
        this.chargeAmount = d11;
    }

    public void setChargeFee(String str) {
        this.chargeFee = str;
    }

    public void setChargeFeeTime(String str) {
        this.chargeFeeTime = str;
    }

    public void setCreationAmount(double d11) {
        this.creationAmount = d11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrencyIntroduce(String str) {
        this.currencyIntroduce = str;
    }

    public void setCurrencyName(String str) {
        this.currencyName = str;
    }

    public void setInitNav(String str) {
        this.initNav = str;
    }

    public void setInitUnit(String str) {
        this.initUnit = str;
    }

    public void setLastChargeFee(String str) {
        this.lastChargeFee = str;
    }

    public void setLeverageRatio(int i11) {
        this.leverageRatio = i11;
    }

    public void setRebalTimeRule(String str) {
        this.rebalTimeRule = str;
    }

    public void setRebalUnTimeRule(String str) {
        this.rebalUnTimeRule = str;
    }

    public void setSpotSymbol(String str) {
        this.spotSymbol = str;
    }

    public String toString() {
        return "EtpInfo(currency=" + getCurrency() + ", creationAmount=" + getCreationAmount() + ", chargeAmount=" + getChargeAmount() + ", basket=" + getBasket() + ", initNav=" + getInitNav() + ", initUnit=" + getInitUnit() + ", chargeFee=" + getChargeFee() + ", lastChargeFee=" + getLastChargeFee() + ", chargeFeeTime=" + getChargeFeeTime() + ", currencyIntroduce=" + getCurrencyIntroduce() + ", rebalTimeRule=" + getRebalTimeRule() + ", rebalUnTimeRule=" + getRebalUnTimeRule() + ", currencyName=" + getCurrencyName() + ", spotSymbol=" + getSpotSymbol() + ", leverageRatio=" + getLeverageRatio() + ")";
    }
}
