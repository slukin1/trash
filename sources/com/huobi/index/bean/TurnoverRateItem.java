package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.Expose;
import com.huobi.index.viewhandler.TurnoverRateItemHandler;
import s9.a;

@Keep
public class TurnoverRateItem implements a {
    private String coin;
    @Expose(serialize = false)
    private String price;
    private String turnVolume;
    private String turnoverRate;

    public boolean canEqual(Object obj) {
        return obj instanceof TurnoverRateItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TurnoverRateItem)) {
            return false;
        }
        TurnoverRateItem turnoverRateItem = (TurnoverRateItem) obj;
        if (!turnoverRateItem.canEqual(this)) {
            return false;
        }
        String coin2 = getCoin();
        String coin3 = turnoverRateItem.getCoin();
        if (coin2 != null ? !coin2.equals(coin3) : coin3 != null) {
            return false;
        }
        String turnoverRate2 = getTurnoverRate();
        String turnoverRate3 = turnoverRateItem.getTurnoverRate();
        if (turnoverRate2 != null ? !turnoverRate2.equals(turnoverRate3) : turnoverRate3 != null) {
            return false;
        }
        String turnVolume2 = getTurnVolume();
        String turnVolume3 = turnoverRateItem.getTurnVolume();
        if (turnVolume2 != null ? !turnVolume2.equals(turnVolume3) : turnVolume3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = turnoverRateItem.getPrice();
        return price2 != null ? price2.equals(price3) : price3 == null;
    }

    public String getCoin() {
        return this.coin;
    }

    public String getPrice() {
        return this.price;
    }

    public String getTurnVolume() {
        return this.turnVolume;
    }

    public String getTurnoverRate() {
        return this.turnoverRate;
    }

    public String getViewHandlerName() {
        return TurnoverRateItemHandler.class.getName();
    }

    public int hashCode() {
        String coin2 = getCoin();
        int i11 = 43;
        int hashCode = coin2 == null ? 43 : coin2.hashCode();
        String turnoverRate2 = getTurnoverRate();
        int hashCode2 = ((hashCode + 59) * 59) + (turnoverRate2 == null ? 43 : turnoverRate2.hashCode());
        String turnVolume2 = getTurnVolume();
        int hashCode3 = (hashCode2 * 59) + (turnVolume2 == null ? 43 : turnVolume2.hashCode());
        String price2 = getPrice();
        int i12 = hashCode3 * 59;
        if (price2 != null) {
            i11 = price2.hashCode();
        }
        return i12 + i11;
    }

    public void setCoin(String str) {
        this.coin = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setTurnVolume(String str) {
        this.turnVolume = str;
    }

    public void setTurnoverRate(String str) {
        this.turnoverRate = str;
    }

    public String toString() {
        return "TurnoverRateItem(coin=" + getCoin() + ", turnoverRate=" + getTurnoverRate() + ", turnVolume=" + getTurnVolume() + ", price=" + getPrice() + ")";
    }
}
