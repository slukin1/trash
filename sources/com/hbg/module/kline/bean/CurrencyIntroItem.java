package com.hbg.module.kline.bean;

import com.hbg.module.kline.handler.CurrencyIntroHandler;
import java.io.Serializable;
import s9.a;

public class CurrencyIntroItem implements a, Serializable {
    private int imageResId;
    private CharSequence name;
    private String url;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencyIntroItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyIntroItem)) {
            return false;
        }
        CurrencyIntroItem currencyIntroItem = (CurrencyIntroItem) obj;
        if (!currencyIntroItem.canEqual(this) || getImageResId() != currencyIntroItem.getImageResId()) {
            return false;
        }
        CharSequence name2 = getName();
        CharSequence name3 = currencyIntroItem.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String url2 = getUrl();
        String url3 = currencyIntroItem.getUrl();
        return url2 != null ? url2.equals(url3) : url3 == null;
    }

    public int getImageResId() {
        return this.imageResId;
    }

    public CharSequence getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getViewHandlerName() {
        return CurrencyIntroHandler.class.getName();
    }

    public int hashCode() {
        CharSequence name2 = getName();
        int i11 = 43;
        int imageResId2 = ((getImageResId() + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
        String url2 = getUrl();
        int i12 = imageResId2 * 59;
        if (url2 != null) {
            i11 = url2.hashCode();
        }
        return i12 + i11;
    }

    public void setImageResId(int i11) {
        this.imageResId = i11;
    }

    public void setName(CharSequence charSequence) {
        this.name = charSequence;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "CurrencyIntroItem(imageResId=" + getImageResId() + ", name=" + getName() + ", url=" + getUrl() + ")";
    }
}
