package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;
import java.util.List;

public class SearchCoinListInfo implements Serializable {
    private List<SearchCoinContractItem> contract;
    private List<String> margin;

    public class SearchCoinContractItem {
        private List<String> symbol;
        private int type;

        public SearchCoinContractItem() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof SearchCoinContractItem;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SearchCoinContractItem)) {
                return false;
            }
            SearchCoinContractItem searchCoinContractItem = (SearchCoinContractItem) obj;
            if (!searchCoinContractItem.canEqual(this)) {
                return false;
            }
            List<String> symbol2 = getSymbol();
            List<String> symbol3 = searchCoinContractItem.getSymbol();
            if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
                return getType() == searchCoinContractItem.getType();
            }
            return false;
        }

        public List<String> getSymbol() {
            return this.symbol;
        }

        public int getType() {
            return this.type;
        }

        public int hashCode() {
            List<String> symbol2 = getSymbol();
            return (((symbol2 == null ? 43 : symbol2.hashCode()) + 59) * 59) + getType();
        }

        public void setSymbol(List<String> list) {
            this.symbol = list;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public String toString() {
            return "SearchCoinListInfo.SearchCoinContractItem(symbol=" + getSymbol() + ", type=" + getType() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof SearchCoinListInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchCoinListInfo)) {
            return false;
        }
        SearchCoinListInfo searchCoinListInfo = (SearchCoinListInfo) obj;
        if (!searchCoinListInfo.canEqual(this)) {
            return false;
        }
        List<String> margin2 = getMargin();
        List<String> margin3 = searchCoinListInfo.getMargin();
        if (margin2 != null ? !margin2.equals(margin3) : margin3 != null) {
            return false;
        }
        List<SearchCoinContractItem> contract2 = getContract();
        List<SearchCoinContractItem> contract3 = searchCoinListInfo.getContract();
        return contract2 != null ? contract2.equals(contract3) : contract3 == null;
    }

    public List<SearchCoinContractItem> getContract() {
        return this.contract;
    }

    public List<String> getMargin() {
        return this.margin;
    }

    public int hashCode() {
        List<String> margin2 = getMargin();
        int i11 = 43;
        int hashCode = margin2 == null ? 43 : margin2.hashCode();
        List<SearchCoinContractItem> contract2 = getContract();
        int i12 = (hashCode + 59) * 59;
        if (contract2 != null) {
            i11 = contract2.hashCode();
        }
        return i12 + i11;
    }

    public void setContract(List<SearchCoinContractItem> list) {
        this.contract = list;
    }

    public void setMargin(List<String> list) {
        this.margin = list;
    }

    public String toString() {
        return "SearchCoinListInfo(margin=" + getMargin() + ", contract=" + getContract() + ")";
    }
}
