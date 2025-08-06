package com.hbg.lib.network.otc.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class MarketPrice implements Serializable {
    @SerializedName("price")
    private List<Price> priceList;

    public class Price implements Serializable {
        private int coinId;
        private String currencyId;
        private String price;

        public Price() {
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Price;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Price)) {
                return false;
            }
            Price price2 = (Price) obj;
            if (!price2.canEqual(this) || getCoinId() != price2.getCoinId()) {
                return false;
            }
            String price3 = getPrice();
            String price4 = price2.getPrice();
            if (price3 != null ? !price3.equals(price4) : price4 != null) {
                return false;
            }
            String currencyId2 = getCurrencyId();
            String currencyId3 = price2.getCurrencyId();
            return currencyId2 != null ? currencyId2.equals(currencyId3) : currencyId3 == null;
        }

        public int getCoinId() {
            return this.coinId;
        }

        public String getCurrencyId() {
            return this.currencyId;
        }

        public String getPrice() {
            return this.price;
        }

        public int hashCode() {
            String price2 = getPrice();
            int i11 = 43;
            int coinId2 = ((getCoinId() + 59) * 59) + (price2 == null ? 43 : price2.hashCode());
            String currencyId2 = getCurrencyId();
            int i12 = coinId2 * 59;
            if (currencyId2 != null) {
                i11 = currencyId2.hashCode();
            }
            return i12 + i11;
        }

        public void setCoinId(int i11) {
            this.coinId = i11;
        }

        public void setCurrencyId(String str) {
            this.currencyId = str;
        }

        public void setPrice(String str) {
            this.price = str;
        }

        public String toString() {
            return "MarketPrice.Price(coinId=" + getCoinId() + ", price=" + getPrice() + ", currencyId=" + getCurrencyId() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketPrice;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketPrice)) {
            return false;
        }
        MarketPrice marketPrice = (MarketPrice) obj;
        if (!marketPrice.canEqual(this)) {
            return false;
        }
        List<Price> priceList2 = getPriceList();
        List<Price> priceList3 = marketPrice.getPriceList();
        return priceList2 != null ? priceList2.equals(priceList3) : priceList3 == null;
    }

    public List<Price> getPriceList() {
        return this.priceList;
    }

    public int hashCode() {
        List<Price> priceList2 = getPriceList();
        return 59 + (priceList2 == null ? 43 : priceList2.hashCode());
    }

    public void setPriceList(List<Price> list) {
        this.priceList = list;
    }

    public String toString() {
        return "MarketPrice(priceList=" + getPriceList() + ")";
    }
}
