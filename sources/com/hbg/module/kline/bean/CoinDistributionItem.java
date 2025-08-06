package com.hbg.module.kline.bean;

import com.hbg.module.kline.handler.CoinDistributionHandler;
import java.io.Serializable;
import s9.a;

public class CoinDistributionItem implements a, Serializable {
    private int background;
    private String name = "";
    private String percent = "";
    private String time = "";

    public boolean canEqual(Object obj) {
        return obj instanceof CoinDistributionItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CoinDistributionItem)) {
            return false;
        }
        CoinDistributionItem coinDistributionItem = (CoinDistributionItem) obj;
        if (!coinDistributionItem.canEqual(this) || getBackground() != coinDistributionItem.getBackground()) {
            return false;
        }
        String name2 = getName();
        String name3 = coinDistributionItem.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String percent2 = getPercent();
        String percent3 = coinDistributionItem.getPercent();
        if (percent2 != null ? !percent2.equals(percent3) : percent3 != null) {
            return false;
        }
        String time2 = getTime();
        String time3 = coinDistributionItem.getTime();
        return time2 != null ? time2.equals(time3) : time3 == null;
    }

    public int getBackground() {
        return this.background;
    }

    public String getName() {
        return this.name;
    }

    public String getPercent() {
        return this.percent;
    }

    public String getTime() {
        return this.time;
    }

    public String getViewHandlerName() {
        return CoinDistributionHandler.class.getName();
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int background2 = ((getBackground() + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
        String percent2 = getPercent();
        int hashCode = (background2 * 59) + (percent2 == null ? 43 : percent2.hashCode());
        String time2 = getTime();
        int i12 = hashCode * 59;
        if (time2 != null) {
            i11 = time2.hashCode();
        }
        return i12 + i11;
    }

    public void setBackground(int i11) {
        this.background = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPercent(String str) {
        this.percent = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        return "CoinDistributionItem(background=" + getBackground() + ", name=" + getName() + ", percent=" + getPercent() + ", time=" + getTime() + ")";
    }
}
