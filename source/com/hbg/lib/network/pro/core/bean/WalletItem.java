package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class WalletItem implements Serializable {
    private String amount;
    private String icon;
    private String name;
    private String price;
    private String value;

    public boolean canEqual(Object obj) {
        return obj instanceof WalletItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WalletItem)) {
            return false;
        }
        WalletItem walletItem = (WalletItem) obj;
        if (!walletItem.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = walletItem.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = walletItem.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = walletItem.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String value2 = getValue();
        String value3 = walletItem.getValue();
        if (value2 != null ? !value2.equals(value3) : value3 != null) {
            return false;
        }
        String icon2 = getIcon();
        String icon3 = walletItem.getIcon();
        return icon2 != null ? icon2.equals(icon3) : icon3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int hashCode = name2 == null ? 43 : name2.hashCode();
        String amount2 = getAmount();
        int hashCode2 = ((hashCode + 59) * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String price2 = getPrice();
        int hashCode3 = (hashCode2 * 59) + (price2 == null ? 43 : price2.hashCode());
        String value2 = getValue();
        int hashCode4 = (hashCode3 * 59) + (value2 == null ? 43 : value2.hashCode());
        String icon2 = getIcon();
        int i12 = hashCode4 * 59;
        if (icon2 != null) {
            i11 = icon2.hashCode();
        }
        return i12 + i11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "WalletItem(name=" + getName() + ", amount=" + getAmount() + ", price=" + getPrice() + ", value=" + getValue() + ", icon=" + getIcon() + ")";
    }
}
