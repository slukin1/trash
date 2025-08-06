package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class TradeGuideItemBean implements Serializable {
    private String desStr;
    private int imageRes;
    private boolean isLast;
    private String subDesStr;
    private String titleStr;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeGuideItemBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeGuideItemBean)) {
            return false;
        }
        TradeGuideItemBean tradeGuideItemBean = (TradeGuideItemBean) obj;
        if (!tradeGuideItemBean.canEqual(this) || getImageRes() != tradeGuideItemBean.getImageRes()) {
            return false;
        }
        String titleStr2 = getTitleStr();
        String titleStr3 = tradeGuideItemBean.getTitleStr();
        if (titleStr2 != null ? !titleStr2.equals(titleStr3) : titleStr3 != null) {
            return false;
        }
        String desStr2 = getDesStr();
        String desStr3 = tradeGuideItemBean.getDesStr();
        if (desStr2 != null ? !desStr2.equals(desStr3) : desStr3 != null) {
            return false;
        }
        String subDesStr2 = getSubDesStr();
        String subDesStr3 = tradeGuideItemBean.getSubDesStr();
        if (subDesStr2 != null ? subDesStr2.equals(subDesStr3) : subDesStr3 == null) {
            return isLast() == tradeGuideItemBean.isLast();
        }
        return false;
    }

    public String getDesStr() {
        return this.desStr;
    }

    public int getImageRes() {
        return this.imageRes;
    }

    public String getSubDesStr() {
        return this.subDesStr;
    }

    public String getTitleStr() {
        return this.titleStr;
    }

    public int hashCode() {
        String titleStr2 = getTitleStr();
        int i11 = 43;
        int imageRes2 = ((getImageRes() + 59) * 59) + (titleStr2 == null ? 43 : titleStr2.hashCode());
        String desStr2 = getDesStr();
        int hashCode = (imageRes2 * 59) + (desStr2 == null ? 43 : desStr2.hashCode());
        String subDesStr2 = getSubDesStr();
        int i12 = hashCode * 59;
        if (subDesStr2 != null) {
            i11 = subDesStr2.hashCode();
        }
        return ((i12 + i11) * 59) + (isLast() ? 79 : 97);
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void setDesStr(String str) {
        this.desStr = str;
    }

    public void setImageRes(int i11) {
        this.imageRes = i11;
    }

    public void setLast(boolean z11) {
        this.isLast = z11;
    }

    public void setSubDesStr(String str) {
        this.subDesStr = str;
    }

    public void setTitleStr(String str) {
        this.titleStr = str;
    }

    public String toString() {
        return "TradeGuideItemBean(imageRes=" + getImageRes() + ", titleStr=" + getTitleStr() + ", desStr=" + getDesStr() + ", subDesStr=" + getSubDesStr() + ", isLast=" + isLast() + ")";
    }
}
