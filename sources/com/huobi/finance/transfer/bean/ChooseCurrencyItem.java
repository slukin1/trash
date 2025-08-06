package com.huobi.finance.transfer.bean;

import com.huobi.finance.transfer.viewhandler.ChooseCurrencyItemHandler;
import java.io.Serializable;

public class ChooseCurrencyItem implements s9.a, Serializable {
    private a callback;
    private String name;

    public interface a {
        void a(ChooseCurrencyItem chooseCurrencyItem);
    }

    public ChooseCurrencyItem(String str, a aVar) {
        this.name = str;
        this.callback = aVar;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ChooseCurrencyItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChooseCurrencyItem)) {
            return false;
        }
        ChooseCurrencyItem chooseCurrencyItem = (ChooseCurrencyItem) obj;
        if (!chooseCurrencyItem.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = chooseCurrencyItem.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = chooseCurrencyItem.getCallback();
        return callback2 != null ? callback2.equals(callback3) : callback3 == null;
    }

    public a getCallback() {
        return this.callback;
    }

    public String getName() {
        return this.name;
    }

    public String getViewHandlerName() {
        return ChooseCurrencyItemHandler.class.getName();
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int hashCode = name2 == null ? 43 : name2.hashCode();
        a callback2 = getCallback();
        int i12 = (hashCode + 59) * 59;
        if (callback2 != null) {
            i11 = callback2.hashCode();
        }
        return i12 + i11;
    }

    public void notifyCallback() {
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "ChooseCurrencyItem(name=" + getName() + ", callback=" + getCallback() + ")";
    }
}
