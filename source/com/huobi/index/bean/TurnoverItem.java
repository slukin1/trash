package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.Expose;
import com.huobi.index.viewhandler.TurnoverItemHandler;
import s9.a;

@Keep
public class TurnoverItem implements a {
    private String coin;
    @Expose(serialize = false)
    private String legalCurrencyVolume;
    @Expose(serialize = false)
    private String price;
    private transient String symbolName;
    private String turnVolume;
    private String turnoverRate;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.coin;
        String str2 = ((TurnoverItem) obj).coin;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getCoin() {
        return this.coin;
    }

    public String getLegalCurrencyVolume() {
        return this.legalCurrencyVolume;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSymbolName() {
        return this.symbolName;
    }

    public String getTurnVolume() {
        return this.turnVolume;
    }

    public String getTurnoverRate() {
        return this.turnoverRate;
    }

    public String getViewHandlerName() {
        return TurnoverItemHandler.class.getName();
    }

    public int hashCode() {
        String str = this.coin;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void setCoin(String str) {
        this.coin = str;
    }

    public void setLegalCurrencyVolume(String str) {
        this.legalCurrencyVolume = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSymbolName(String str) {
        this.symbolName = str;
    }

    public void setTurnVolume(String str) {
        this.turnVolume = str;
    }

    public void setTurnoverRate(String str) {
        this.turnoverRate = str;
    }

    public String toString() {
        return "TurnoverItem(coin=" + getCoin() + ", turnVolume=" + getTurnVolume() + ", legalCurrencyVolume=" + getLegalCurrencyVolume() + ", price=" + getPrice() + ", turnoverRate=" + getTurnoverRate() + ", symbolName=" + getSymbolName() + ")";
    }
}
