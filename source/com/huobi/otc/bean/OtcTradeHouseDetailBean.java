package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcTradeHouseDetailBean implements Serializable {
    private String baseCoinAmount;
    private int baseCoinId;
    private long gmtTrade;

    /* renamed from: id  reason: collision with root package name */
    private String f78268id;
    private int matchType;
    private String price;
    private String quoteCoinAmount;
    private int quoteCoinId;
    private int status;
    private String uid;
    private String userId;
    private String userName;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcTradeHouseDetailBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcTradeHouseDetailBean)) {
            return false;
        }
        OtcTradeHouseDetailBean otcTradeHouseDetailBean = (OtcTradeHouseDetailBean) obj;
        if (!otcTradeHouseDetailBean.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = otcTradeHouseDetailBean.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = otcTradeHouseDetailBean.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        String userId2 = getUserId();
        String userId3 = otcTradeHouseDetailBean.getUserId();
        if (userId2 != null ? !userId2.equals(userId3) : userId3 != null) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = otcTradeHouseDetailBean.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (getMatchType() != otcTradeHouseDetailBean.getMatchType()) {
            return false;
        }
        String price2 = getPrice();
        String price3 = otcTradeHouseDetailBean.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        if (getBaseCoinId() != otcTradeHouseDetailBean.getBaseCoinId()) {
            return false;
        }
        String baseCoinAmount2 = getBaseCoinAmount();
        String baseCoinAmount3 = otcTradeHouseDetailBean.getBaseCoinAmount();
        if (baseCoinAmount2 != null ? !baseCoinAmount2.equals(baseCoinAmount3) : baseCoinAmount3 != null) {
            return false;
        }
        if (getQuoteCoinId() != otcTradeHouseDetailBean.getQuoteCoinId()) {
            return false;
        }
        String quoteCoinAmount2 = getQuoteCoinAmount();
        String quoteCoinAmount3 = otcTradeHouseDetailBean.getQuoteCoinAmount();
        if (quoteCoinAmount2 != null ? quoteCoinAmount2.equals(quoteCoinAmount3) : quoteCoinAmount3 == null) {
            return getGmtTrade() == otcTradeHouseDetailBean.getGmtTrade() && getStatus() == otcTradeHouseDetailBean.getStatus();
        }
        return false;
    }

    public String getBaseCoinAmount() {
        return this.baseCoinAmount;
    }

    public int getBaseCoinId() {
        return this.baseCoinId;
    }

    public long getGmtTrade() {
        return this.gmtTrade;
    }

    public String getId() {
        return this.f78268id;
    }

    public int getMatchType() {
        return this.matchType;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuoteCoinAmount() {
        return this.quoteCoinAmount;
    }

    public int getQuoteCoinId() {
        return this.quoteCoinId;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String uid2 = getUid();
        int hashCode2 = ((hashCode + 59) * 59) + (uid2 == null ? 43 : uid2.hashCode());
        String userId2 = getUserId();
        int hashCode3 = (hashCode2 * 59) + (userId2 == null ? 43 : userId2.hashCode());
        String userName2 = getUserName();
        int hashCode4 = (((hashCode3 * 59) + (userName2 == null ? 43 : userName2.hashCode())) * 59) + getMatchType();
        String price2 = getPrice();
        int hashCode5 = (((hashCode4 * 59) + (price2 == null ? 43 : price2.hashCode())) * 59) + getBaseCoinId();
        String baseCoinAmount2 = getBaseCoinAmount();
        int hashCode6 = (((hashCode5 * 59) + (baseCoinAmount2 == null ? 43 : baseCoinAmount2.hashCode())) * 59) + getQuoteCoinId();
        String quoteCoinAmount2 = getQuoteCoinAmount();
        int i12 = hashCode6 * 59;
        if (quoteCoinAmount2 != null) {
            i11 = quoteCoinAmount2.hashCode();
        }
        long gmtTrade2 = getGmtTrade();
        return ((((i12 + i11) * 59) + ((int) (gmtTrade2 ^ (gmtTrade2 >>> 32)))) * 59) + getStatus();
    }

    public void setBaseCoinAmount(String str) {
        this.baseCoinAmount = str;
    }

    public void setBaseCoinId(int i11) {
        this.baseCoinId = i11;
    }

    public void setGmtTrade(long j11) {
        this.gmtTrade = j11;
    }

    public void setId(String str) {
        this.f78268id = str;
    }

    public void setMatchType(int i11) {
        this.matchType = i11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuoteCoinAmount(String str) {
        this.quoteCoinAmount = str;
    }

    public void setQuoteCoinId(int i11) {
        this.quoteCoinId = i11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "OtcTradeHouseDetailBean(id=" + getId() + ", uid=" + getUid() + ", userId=" + getUserId() + ", userName=" + getUserName() + ", matchType=" + getMatchType() + ", price=" + getPrice() + ", baseCoinId=" + getBaseCoinId() + ", baseCoinAmount=" + getBaseCoinAmount() + ", quoteCoinId=" + getQuoteCoinId() + ", quoteCoinAmount=" + getQuoteCoinAmount() + ", gmtTrade=" + getGmtTrade() + ", status=" + getStatus() + ")";
    }
}
