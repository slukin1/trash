package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class RankScreenBean implements Serializable {
    public static final String SCREEN_VALUE_FUTURE = "future";
    public static final String SCREEN_VALUE_SPOT = "spot";
    public static final String SCREEN_VALUE_SYMBOL_SWAP = "symbolSwap";
    public static final String SCREEN_VALUE_USDT_SWAP = "usdtSwap";
    private static final long serialVersionUID = 5055037037204266746L;
    private String screenTitle;
    private String screenValue;

    public boolean canEqual(Object obj) {
        return obj instanceof RankScreenBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RankScreenBean)) {
            return false;
        }
        RankScreenBean rankScreenBean = (RankScreenBean) obj;
        if (!rankScreenBean.canEqual(this)) {
            return false;
        }
        String screenTitle2 = getScreenTitle();
        String screenTitle3 = rankScreenBean.getScreenTitle();
        if (screenTitle2 != null ? !screenTitle2.equals(screenTitle3) : screenTitle3 != null) {
            return false;
        }
        String screenValue2 = getScreenValue();
        String screenValue3 = rankScreenBean.getScreenValue();
        return screenValue2 != null ? screenValue2.equals(screenValue3) : screenValue3 == null;
    }

    public String getScreenTitle() {
        return this.screenTitle;
    }

    public String getScreenValue() {
        return this.screenValue;
    }

    public int hashCode() {
        String screenTitle2 = getScreenTitle();
        int i11 = 43;
        int hashCode = screenTitle2 == null ? 43 : screenTitle2.hashCode();
        String screenValue2 = getScreenValue();
        int i12 = (hashCode + 59) * 59;
        if (screenValue2 != null) {
            i11 = screenValue2.hashCode();
        }
        return i12 + i11;
    }

    public void setScreenTitle(String str) {
        this.screenTitle = str;
    }

    public void setScreenValue(String str) {
        this.screenValue = str;
    }

    public String toString() {
        return "RankScreenBean(screenTitle=" + getScreenTitle() + ", screenValue=" + getScreenValue() + ")";
    }
}
