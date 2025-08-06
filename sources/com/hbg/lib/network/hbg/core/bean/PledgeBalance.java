package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class PledgeBalance implements Serializable {
    private List<CurrencyBalance> loaning;
    private List<CurrencyBalance> pledging;

    public static class CurrencyBalance implements Serializable {
        private String amount;
        private String currency;
        private String currencyIcon;
        private String usdtAmount;

        public boolean canEqual(Object obj) {
            return obj instanceof CurrencyBalance;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CurrencyBalance)) {
                return false;
            }
            CurrencyBalance currencyBalance = (CurrencyBalance) obj;
            if (!currencyBalance.canEqual(this)) {
                return false;
            }
            String amount2 = getAmount();
            String amount3 = currencyBalance.getAmount();
            if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
                return false;
            }
            String currency2 = getCurrency();
            String currency3 = currencyBalance.getCurrency();
            if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
                return false;
            }
            String currencyIcon2 = getCurrencyIcon();
            String currencyIcon3 = currencyBalance.getCurrencyIcon();
            if (currencyIcon2 != null ? !currencyIcon2.equals(currencyIcon3) : currencyIcon3 != null) {
                return false;
            }
            String usdtAmount2 = getUsdtAmount();
            String usdtAmount3 = currencyBalance.getUsdtAmount();
            return usdtAmount2 != null ? usdtAmount2.equals(usdtAmount3) : usdtAmount3 == null;
        }

        public String getAmount() {
            return this.amount;
        }

        public String getCurrency() {
            return this.currency;
        }

        public String getCurrencyIcon() {
            return this.currencyIcon;
        }

        public String getUsdtAmount() {
            return this.usdtAmount;
        }

        public int hashCode() {
            String amount2 = getAmount();
            int i11 = 43;
            int hashCode = amount2 == null ? 43 : amount2.hashCode();
            String currency2 = getCurrency();
            int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
            String currencyIcon2 = getCurrencyIcon();
            int hashCode3 = (hashCode2 * 59) + (currencyIcon2 == null ? 43 : currencyIcon2.hashCode());
            String usdtAmount2 = getUsdtAmount();
            int i12 = hashCode3 * 59;
            if (usdtAmount2 != null) {
                i11 = usdtAmount2.hashCode();
            }
            return i12 + i11;
        }

        public void setAmount(String str) {
            this.amount = str;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public void setCurrencyIcon(String str) {
            this.currencyIcon = str;
        }

        public void setUsdtAmount(String str) {
            this.usdtAmount = str;
        }

        public String toString() {
            return "PledgeBalance.CurrencyBalance(amount=" + getAmount() + ", currency=" + getCurrency() + ", currencyIcon=" + getCurrencyIcon() + ", usdtAmount=" + getUsdtAmount() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PledgeBalance;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PledgeBalance)) {
            return false;
        }
        PledgeBalance pledgeBalance = (PledgeBalance) obj;
        if (!pledgeBalance.canEqual(this)) {
            return false;
        }
        List<CurrencyBalance> loaning2 = getLoaning();
        List<CurrencyBalance> loaning3 = pledgeBalance.getLoaning();
        if (loaning2 != null ? !loaning2.equals(loaning3) : loaning3 != null) {
            return false;
        }
        List<CurrencyBalance> pledging2 = getPledging();
        List<CurrencyBalance> pledging3 = pledgeBalance.getPledging();
        return pledging2 != null ? pledging2.equals(pledging3) : pledging3 == null;
    }

    public List<CurrencyBalance> getLoaning() {
        return this.loaning;
    }

    public List<CurrencyBalance> getPledging() {
        return this.pledging;
    }

    public int hashCode() {
        List<CurrencyBalance> loaning2 = getLoaning();
        int i11 = 43;
        int hashCode = loaning2 == null ? 43 : loaning2.hashCode();
        List<CurrencyBalance> pledging2 = getPledging();
        int i12 = (hashCode + 59) * 59;
        if (pledging2 != null) {
            i11 = pledging2.hashCode();
        }
        return i12 + i11;
    }

    public void setLoaning(List<CurrencyBalance> list) {
        this.loaning = list;
    }

    public void setPledging(List<CurrencyBalance> list) {
        this.pledging = list;
    }

    public String toString() {
        return "PledgeBalance(loaning=" + getLoaning() + ", pledging=" + getPledging() + ")";
    }
}
