package com.huobi.staring.bean;

import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.staring.viewhandler.ProRemindListItemHandler;
import java.io.Serializable;
import pro.huobi.R;

public class ProRemindListItem implements ka.a, Serializable {
    public String baseCurrency;
    public a callback;
    public String quoteCurrency;
    public int status;
    public String symbol;

    public interface a {
        boolean a();

        void b(ProRemindListItem proRemindListItem, int i11, CommonSwitchButton commonSwitchButton);

        void c(boolean z11, ProRemindListItem proRemindListItem);

        void d(ProRemindListItem proRemindListItem);

        boolean e(ProRemindListItem proRemindListItem);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ProRemindListItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProRemindListItem)) {
            return false;
        }
        ProRemindListItem proRemindListItem = (ProRemindListItem) obj;
        if (!proRemindListItem.canEqual(this)) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = proRemindListItem.getCallback();
        if (callback2 != null ? !callback2.equals(callback3) : callback3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = proRemindListItem.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = proRemindListItem.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = proRemindListItem.getQuoteCurrency();
        if (quoteCurrency2 != null ? quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 == null) {
            return getStatus() == proRemindListItem.getStatus();
        }
        return false;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public a getCallback() {
        return this.callback;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public int getResId() {
        return R.layout.staring_layout_pro_remind_item;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return ProRemindListItemHandler.class.getName();
    }

    public int hashCode() {
        a callback2 = getCallback();
        int i11 = 43;
        int hashCode = callback2 == null ? 43 : callback2.hashCode();
        String symbol2 = getSymbol();
        int hashCode2 = ((hashCode + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String baseCurrency2 = getBaseCurrency();
        int hashCode3 = (hashCode2 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int i12 = hashCode3 * 59;
        if (quoteCurrency2 != null) {
            i11 = quoteCurrency2.hashCode();
        }
        return ((i12 + i11) * 59) + getStatus();
    }

    public boolean isSticky() {
        return false;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "ProRemindListItem(callback=" + getCallback() + ", symbol=" + getSymbol() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", status=" + getStatus() + ")";
    }
}
