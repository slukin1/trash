package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class RequestOrderListBean implements Serializable {
    private String beginDate;
    private String cryptoAsset;
    private int currPage;
    private String endDate;
    private boolean isUnread;
    private String orderNo;
    private String orderStatus;
    private String orderType;
    private String quoteAsset;
    private String runModes;
    private String secondaryType;
    private String side;

    public boolean canEqual(Object obj) {
        return obj instanceof RequestOrderListBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestOrderListBean)) {
            return false;
        }
        RequestOrderListBean requestOrderListBean = (RequestOrderListBean) obj;
        if (!requestOrderListBean.canEqual(this)) {
            return false;
        }
        String orderStatus2 = getOrderStatus();
        String orderStatus3 = requestOrderListBean.getOrderStatus();
        if (orderStatus2 != null ? !orderStatus2.equals(orderStatus3) : orderStatus3 != null) {
            return false;
        }
        String orderType2 = getOrderType();
        String orderType3 = requestOrderListBean.getOrderType();
        if (orderType2 != null ? !orderType2.equals(orderType3) : orderType3 != null) {
            return false;
        }
        String secondaryType2 = getSecondaryType();
        String secondaryType3 = requestOrderListBean.getSecondaryType();
        if (secondaryType2 != null ? !secondaryType2.equals(secondaryType3) : secondaryType3 != null) {
            return false;
        }
        String orderNo2 = getOrderNo();
        String orderNo3 = requestOrderListBean.getOrderNo();
        if (orderNo2 != null ? !orderNo2.equals(orderNo3) : orderNo3 != null) {
            return false;
        }
        String quoteAsset2 = getQuoteAsset();
        String quoteAsset3 = requestOrderListBean.getQuoteAsset();
        if (quoteAsset2 != null ? !quoteAsset2.equals(quoteAsset3) : quoteAsset3 != null) {
            return false;
        }
        String cryptoAsset2 = getCryptoAsset();
        String cryptoAsset3 = requestOrderListBean.getCryptoAsset();
        if (cryptoAsset2 != null ? !cryptoAsset2.equals(cryptoAsset3) : cryptoAsset3 != null) {
            return false;
        }
        String beginDate2 = getBeginDate();
        String beginDate3 = requestOrderListBean.getBeginDate();
        if (beginDate2 != null ? !beginDate2.equals(beginDate3) : beginDate3 != null) {
            return false;
        }
        String endDate2 = getEndDate();
        String endDate3 = requestOrderListBean.getEndDate();
        if (endDate2 != null ? !endDate2.equals(endDate3) : endDate3 != null) {
            return false;
        }
        if (getCurrPage() != requestOrderListBean.getCurrPage()) {
            return false;
        }
        String side2 = getSide();
        String side3 = requestOrderListBean.getSide();
        if (side2 != null ? !side2.equals(side3) : side3 != null) {
            return false;
        }
        String runModes2 = getRunModes();
        String runModes3 = requestOrderListBean.getRunModes();
        if (runModes2 != null ? runModes2.equals(runModes3) : runModes3 == null) {
            return isUnread() == requestOrderListBean.isUnread();
        }
        return false;
    }

    public String getBeginDate() {
        return this.beginDate;
    }

    public String getCryptoAsset() {
        return this.cryptoAsset;
    }

    public int getCurrPage() {
        return this.currPage;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public String getQuoteAsset() {
        return this.quoteAsset;
    }

    public String getRunModes() {
        return this.runModes;
    }

    public String getSecondaryType() {
        return this.secondaryType;
    }

    public String getSide() {
        return this.side;
    }

    public int hashCode() {
        String orderStatus2 = getOrderStatus();
        int i11 = 43;
        int hashCode = orderStatus2 == null ? 43 : orderStatus2.hashCode();
        String orderType2 = getOrderType();
        int hashCode2 = ((hashCode + 59) * 59) + (orderType2 == null ? 43 : orderType2.hashCode());
        String secondaryType2 = getSecondaryType();
        int hashCode3 = (hashCode2 * 59) + (secondaryType2 == null ? 43 : secondaryType2.hashCode());
        String orderNo2 = getOrderNo();
        int hashCode4 = (hashCode3 * 59) + (orderNo2 == null ? 43 : orderNo2.hashCode());
        String quoteAsset2 = getQuoteAsset();
        int hashCode5 = (hashCode4 * 59) + (quoteAsset2 == null ? 43 : quoteAsset2.hashCode());
        String cryptoAsset2 = getCryptoAsset();
        int hashCode6 = (hashCode5 * 59) + (cryptoAsset2 == null ? 43 : cryptoAsset2.hashCode());
        String beginDate2 = getBeginDate();
        int hashCode7 = (hashCode6 * 59) + (beginDate2 == null ? 43 : beginDate2.hashCode());
        String endDate2 = getEndDate();
        int hashCode8 = (((hashCode7 * 59) + (endDate2 == null ? 43 : endDate2.hashCode())) * 59) + getCurrPage();
        String side2 = getSide();
        int hashCode9 = (hashCode8 * 59) + (side2 == null ? 43 : side2.hashCode());
        String runModes2 = getRunModes();
        int i12 = hashCode9 * 59;
        if (runModes2 != null) {
            i11 = runModes2.hashCode();
        }
        return ((i12 + i11) * 59) + (isUnread() ? 79 : 97);
    }

    public boolean isUnread() {
        return this.isUnread;
    }

    public void setBeginDate(String str) {
        this.beginDate = str;
    }

    public void setCryptoAsset(String str) {
        this.cryptoAsset = str;
    }

    public void setCurrPage(int i11) {
        this.currPage = i11;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setOrderNo(String str) {
        this.orderNo = str;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public void setOrderType(String str) {
        this.orderType = str;
    }

    public void setQuoteAsset(String str) {
        this.quoteAsset = str;
    }

    public void setRunModes(String str) {
        this.runModes = str;
    }

    public void setSecondaryType(String str) {
        this.secondaryType = str;
    }

    public void setSide(String str) {
        this.side = str;
    }

    public void setUnread(boolean z11) {
        this.isUnread = z11;
    }

    public String toString() {
        return "RequestOrderListBean(orderStatus=" + getOrderStatus() + ", orderType=" + getOrderType() + ", secondaryType=" + getSecondaryType() + ", orderNo=" + getOrderNo() + ", quoteAsset=" + getQuoteAsset() + ", cryptoAsset=" + getCryptoAsset() + ", beginDate=" + getBeginDate() + ", endDate=" + getEndDate() + ", currPage=" + getCurrPage() + ", side=" + getSide() + ", runModes=" + getRunModes() + ", isUnread=" + isUnread() + ")";
    }
}
