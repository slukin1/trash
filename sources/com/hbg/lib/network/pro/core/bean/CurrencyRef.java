package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;
import java.util.List;

public class CurrencyRef implements Serializable {
    private List<ChainsItem> chains;
    private String currency;

    public static class ChainsItem implements Serializable {
        private String chain;
        private String maxTransactFeeWithdraw;
        private String minWithdrawAmt;
        private String transactFeeRateWithdraw;
        private String transactFeeWithdraw;
        private String withdrawFeeType;

        public boolean canEqual(Object obj) {
            return obj instanceof ChainsItem;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChainsItem)) {
                return false;
            }
            ChainsItem chainsItem = (ChainsItem) obj;
            if (!chainsItem.canEqual(this)) {
                return false;
            }
            String chain2 = getChain();
            String chain3 = chainsItem.getChain();
            if (chain2 != null ? !chain2.equals(chain3) : chain3 != null) {
                return false;
            }
            String withdrawFeeType2 = getWithdrawFeeType();
            String withdrawFeeType3 = chainsItem.getWithdrawFeeType();
            if (withdrawFeeType2 != null ? !withdrawFeeType2.equals(withdrawFeeType3) : withdrawFeeType3 != null) {
                return false;
            }
            String minWithdrawAmt2 = getMinWithdrawAmt();
            String minWithdrawAmt3 = chainsItem.getMinWithdrawAmt();
            if (minWithdrawAmt2 != null ? !minWithdrawAmt2.equals(minWithdrawAmt3) : minWithdrawAmt3 != null) {
                return false;
            }
            String transactFeeWithdraw2 = getTransactFeeWithdraw();
            String transactFeeWithdraw3 = chainsItem.getTransactFeeWithdraw();
            if (transactFeeWithdraw2 != null ? !transactFeeWithdraw2.equals(transactFeeWithdraw3) : transactFeeWithdraw3 != null) {
                return false;
            }
            String maxTransactFeeWithdraw2 = getMaxTransactFeeWithdraw();
            String maxTransactFeeWithdraw3 = chainsItem.getMaxTransactFeeWithdraw();
            if (maxTransactFeeWithdraw2 != null ? !maxTransactFeeWithdraw2.equals(maxTransactFeeWithdraw3) : maxTransactFeeWithdraw3 != null) {
                return false;
            }
            String transactFeeRateWithdraw2 = getTransactFeeRateWithdraw();
            String transactFeeRateWithdraw3 = chainsItem.getTransactFeeRateWithdraw();
            return transactFeeRateWithdraw2 != null ? transactFeeRateWithdraw2.equals(transactFeeRateWithdraw3) : transactFeeRateWithdraw3 == null;
        }

        public String getChain() {
            return this.chain;
        }

        public String getMaxTransactFeeWithdraw() {
            return this.maxTransactFeeWithdraw;
        }

        public String getMinWithdrawAmt() {
            return this.minWithdrawAmt;
        }

        public String getTransactFeeRateWithdraw() {
            return this.transactFeeRateWithdraw;
        }

        public String getTransactFeeWithdraw() {
            return this.transactFeeWithdraw;
        }

        public String getWithdrawFeeType() {
            return this.withdrawFeeType;
        }

        public int hashCode() {
            String chain2 = getChain();
            int i11 = 43;
            int hashCode = chain2 == null ? 43 : chain2.hashCode();
            String withdrawFeeType2 = getWithdrawFeeType();
            int hashCode2 = ((hashCode + 59) * 59) + (withdrawFeeType2 == null ? 43 : withdrawFeeType2.hashCode());
            String minWithdrawAmt2 = getMinWithdrawAmt();
            int hashCode3 = (hashCode2 * 59) + (minWithdrawAmt2 == null ? 43 : minWithdrawAmt2.hashCode());
            String transactFeeWithdraw2 = getTransactFeeWithdraw();
            int hashCode4 = (hashCode3 * 59) + (transactFeeWithdraw2 == null ? 43 : transactFeeWithdraw2.hashCode());
            String maxTransactFeeWithdraw2 = getMaxTransactFeeWithdraw();
            int hashCode5 = (hashCode4 * 59) + (maxTransactFeeWithdraw2 == null ? 43 : maxTransactFeeWithdraw2.hashCode());
            String transactFeeRateWithdraw2 = getTransactFeeRateWithdraw();
            int i12 = hashCode5 * 59;
            if (transactFeeRateWithdraw2 != null) {
                i11 = transactFeeRateWithdraw2.hashCode();
            }
            return i12 + i11;
        }

        public void setChain(String str) {
            this.chain = str;
        }

        public void setMaxTransactFeeWithdraw(String str) {
            this.maxTransactFeeWithdraw = str;
        }

        public void setMinWithdrawAmt(String str) {
            this.minWithdrawAmt = str;
        }

        public void setTransactFeeRateWithdraw(String str) {
            this.transactFeeRateWithdraw = str;
        }

        public void setTransactFeeWithdraw(String str) {
            this.transactFeeWithdraw = str;
        }

        public void setWithdrawFeeType(String str) {
            this.withdrawFeeType = str;
        }

        public String toString() {
            return "CurrencyRef.ChainsItem(chain=" + getChain() + ", withdrawFeeType=" + getWithdrawFeeType() + ", minWithdrawAmt=" + getMinWithdrawAmt() + ", transactFeeWithdraw=" + getTransactFeeWithdraw() + ", maxTransactFeeWithdraw=" + getMaxTransactFeeWithdraw() + ", transactFeeRateWithdraw=" + getTransactFeeRateWithdraw() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyRef;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyRef)) {
            return false;
        }
        CurrencyRef currencyRef = (CurrencyRef) obj;
        if (!currencyRef.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = currencyRef.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        List<ChainsItem> chains2 = getChains();
        List<ChainsItem> chains3 = currencyRef.getChains();
        return chains2 != null ? chains2.equals(chains3) : chains3 == null;
    }

    public List<ChainsItem> getChains() {
        return this.chains;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        List<ChainsItem> chains2 = getChains();
        int i12 = (hashCode + 59) * 59;
        if (chains2 != null) {
            i11 = chains2.hashCode();
        }
        return i12 + i11;
    }

    public void setChains(List<ChainsItem> list) {
        this.chains = list;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String toString() {
        return "CurrencyRef(currency=" + getCurrency() + ", chains=" + getChains() + ")";
    }
}
