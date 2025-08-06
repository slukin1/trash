package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.Expose;
import com.huobi.index.viewhandler.NewSymbolItemHandler;
import s9.a;

@Keep
public class NewSymbol implements a {
    private String coin;
    private String displayName;
    private String labels;
    @Expose(serialize = false)
    private String percent;
    @Expose(serialize = false)
    private String price;
    private transient String symbolName;

    public boolean canEqual(Object obj) {
        return obj instanceof NewSymbol;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NewSymbol)) {
            return false;
        }
        NewSymbol newSymbol = (NewSymbol) obj;
        if (!newSymbol.canEqual(this)) {
            return false;
        }
        String coin2 = getCoin();
        String coin3 = newSymbol.getCoin();
        if (coin2 != null ? !coin2.equals(coin3) : coin3 != null) {
            return false;
        }
        String displayName2 = getDisplayName();
        String displayName3 = newSymbol.getDisplayName();
        if (displayName2 != null ? !displayName2.equals(displayName3) : displayName3 != null) {
            return false;
        }
        String labels2 = getLabels();
        String labels3 = newSymbol.getLabels();
        if (labels2 != null ? !labels2.equals(labels3) : labels3 != null) {
            return false;
        }
        String percent2 = getPercent();
        String percent3 = newSymbol.getPercent();
        if (percent2 != null ? !percent2.equals(percent3) : percent3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = newSymbol.getPrice();
        return price2 != null ? price2.equals(price3) : price3 == null;
    }

    public String getCoin() {
        return this.coin;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getLabels() {
        return this.labels;
    }

    public String getPercent() {
        return this.percent;
    }

    public String getPrice() {
        return this.price;
    }

    public String getSymbolName() {
        return this.symbolName;
    }

    public String getViewHandlerName() {
        return NewSymbolItemHandler.class.getName();
    }

    public int hashCode() {
        String coin2 = getCoin();
        int i11 = 43;
        int hashCode = coin2 == null ? 43 : coin2.hashCode();
        String displayName2 = getDisplayName();
        int hashCode2 = ((hashCode + 59) * 59) + (displayName2 == null ? 43 : displayName2.hashCode());
        String labels2 = getLabels();
        int hashCode3 = (hashCode2 * 59) + (labels2 == null ? 43 : labels2.hashCode());
        String percent2 = getPercent();
        int hashCode4 = (hashCode3 * 59) + (percent2 == null ? 43 : percent2.hashCode());
        String price2 = getPrice();
        int i12 = hashCode4 * 59;
        if (price2 != null) {
            i11 = price2.hashCode();
        }
        return i12 + i11;
    }

    public void setCoin(String str) {
        this.coin = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setLabels(String str) {
        this.labels = str;
    }

    public void setPercent(String str) {
        this.percent = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSymbolName(String str) {
        this.symbolName = str;
    }

    public String toString() {
        return "NewSymbol(coin=" + getCoin() + ", displayName=" + getDisplayName() + ", labels=" + getLabels() + ", percent=" + getPercent() + ", price=" + getPrice() + ", symbolName=" + getSymbolName() + ")";
    }
}
