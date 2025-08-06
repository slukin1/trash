package com.huobi.otc.event;

import java.io.Serializable;

public class OnSelectCoinEvent implements Serializable {
    private String coinName;

    public boolean canEqual(Object obj) {
        return obj instanceof OnSelectCoinEvent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OnSelectCoinEvent)) {
            return false;
        }
        OnSelectCoinEvent onSelectCoinEvent = (OnSelectCoinEvent) obj;
        if (!onSelectCoinEvent.canEqual(this)) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = onSelectCoinEvent.getCoinName();
        return coinName2 != null ? coinName2.equals(coinName3) : coinName3 == null;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public int hashCode() {
        String coinName2 = getCoinName();
        return 59 + (coinName2 == null ? 43 : coinName2.hashCode());
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public String toString() {
        return "OnSelectCoinEvent(coinName=" + getCoinName() + ")";
    }
}
