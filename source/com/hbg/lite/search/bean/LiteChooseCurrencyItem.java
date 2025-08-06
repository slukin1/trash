package com.hbg.lite.search.bean;

import com.hbg.lib.network.otc.core.bean.OtcMarketCoinInfo;
import com.huobi.view.indexlist.IndexPartEntity;
import java.io.Serializable;

public class LiteChooseCurrencyItem implements IndexPartEntity, Serializable {
    private OtcMarketCoinInfo.CoinInfo coinInfo;
    private String name;
    private String symbol;

    public LiteChooseCurrencyItem() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof LiteChooseCurrencyItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LiteChooseCurrencyItem)) {
            return false;
        }
        LiteChooseCurrencyItem liteChooseCurrencyItem = (LiteChooseCurrencyItem) obj;
        if (!liteChooseCurrencyItem.canEqual(this)) {
            return false;
        }
        OtcMarketCoinInfo.CoinInfo coinInfo2 = getCoinInfo();
        OtcMarketCoinInfo.CoinInfo coinInfo3 = liteChooseCurrencyItem.getCoinInfo();
        if (coinInfo2 != null ? !coinInfo2.equals(coinInfo3) : coinInfo3 != null) {
            return false;
        }
        String name2 = getName();
        String name3 = liteChooseCurrencyItem.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = liteChooseCurrencyItem.getSymbol();
        return symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null;
    }

    public OtcMarketCoinInfo.CoinInfo getCoinInfo() {
        return this.coinInfo;
    }

    public String getFieldIndexBy() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public String getSearchKey() {
        return this.name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        OtcMarketCoinInfo.CoinInfo coinInfo2 = getCoinInfo();
        int i11 = 43;
        int hashCode = coinInfo2 == null ? 43 : coinInfo2.hashCode();
        String name2 = getName();
        int hashCode2 = ((hashCode + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
        String symbol2 = getSymbol();
        int i12 = hashCode2 * 59;
        if (symbol2 != null) {
            i11 = symbol2.hashCode();
        }
        return i12 + i11;
    }

    public void setCoinInfo(OtcMarketCoinInfo.CoinInfo coinInfo2) {
        this.coinInfo = coinInfo2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "LiteChooseCurrencyItem(coinInfo=" + getCoinInfo() + ", name=" + getName() + ", symbol=" + getSymbol() + ")";
    }

    public LiteChooseCurrencyItem(String str) {
        this.name = str;
    }
}
