package com.huobi.otc.bean;

import com.huobi.otc.bean.Ads;
import java.io.Serializable;
import java.util.List;

public class AdsData implements Serializable {
    private int blockType;
    private int coinId;
    private String coinName;
    private int currency;
    private boolean fromWatchword;
    private long gmtSort;

    /* renamed from: id  reason: collision with root package name */
    private String f78261id;
    private boolean isFollowed;
    private boolean isOnline;
    private String maxTradeLimit;
    private int merchantLevel;
    private List<Integer> merchantTags;
    private String minTradeLimit;
    private String orderCompleteRate;
    private String payMethod;
    private List<Ads.PaymentInfo> payMethods;
    private String payName;
    private int payTerm;
    private String price;
    private int seaViewRoom;
    private String shareCode;
    private String takerAcceptAmount;
    private String takerAcceptOrder;
    private int takerLimit;
    private int thumbUp;
    private String tradeCount;
    private int tradeMonthTimes;
    private String tradeNo;
    private int tradeType;
    private long uid;
    private String userName;
    private String watchword;

    public boolean canEqual(Object obj) {
        return obj instanceof AdsData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsData)) {
            return false;
        }
        AdsData adsData = (AdsData) obj;
        if (!adsData.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = adsData.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        if (getUid() != adsData.getUid()) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = adsData.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (getMerchantLevel() != adsData.getMerchantLevel()) {
            return false;
        }
        List<Integer> merchantTags2 = getMerchantTags();
        List<Integer> merchantTags3 = adsData.getMerchantTags();
        if (merchantTags2 != null ? !merchantTags2.equals(merchantTags3) : merchantTags3 != null) {
            return false;
        }
        if (getCoinId() != adsData.getCoinId() || getCurrency() != adsData.getCurrency() || getTradeType() != adsData.getTradeType() || getBlockType() != adsData.getBlockType()) {
            return false;
        }
        String payMethod2 = getPayMethod();
        String payMethod3 = adsData.getPayMethod();
        if (payMethod2 != null ? !payMethod2.equals(payMethod3) : payMethod3 != null) {
            return false;
        }
        List<Ads.PaymentInfo> payMethods2 = getPayMethods();
        List<Ads.PaymentInfo> payMethods3 = adsData.getPayMethods();
        if (payMethods2 != null ? !payMethods2.equals(payMethods3) : payMethods3 != null) {
            return false;
        }
        if (getPayTerm() != adsData.getPayTerm()) {
            return false;
        }
        String payName2 = getPayName();
        String payName3 = adsData.getPayName();
        if (payName2 != null ? !payName2.equals(payName3) : payName3 != null) {
            return false;
        }
        String minTradeLimit2 = getMinTradeLimit();
        String minTradeLimit3 = adsData.getMinTradeLimit();
        if (minTradeLimit2 != null ? !minTradeLimit2.equals(minTradeLimit3) : minTradeLimit3 != null) {
            return false;
        }
        String maxTradeLimit2 = getMaxTradeLimit();
        String maxTradeLimit3 = adsData.getMaxTradeLimit();
        if (maxTradeLimit2 != null ? !maxTradeLimit2.equals(maxTradeLimit3) : maxTradeLimit3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = adsData.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String tradeCount2 = getTradeCount();
        String tradeCount3 = adsData.getTradeCount();
        if (tradeCount2 != null ? !tradeCount2.equals(tradeCount3) : tradeCount3 != null) {
            return false;
        }
        String tradeNo2 = getTradeNo();
        String tradeNo3 = adsData.getTradeNo();
        if (tradeNo2 != null ? !tradeNo2.equals(tradeNo3) : tradeNo3 != null) {
            return false;
        }
        if (isOnline() != adsData.isOnline() || isFollowed() != adsData.isFollowed() || getTradeMonthTimes() != adsData.getTradeMonthTimes()) {
            return false;
        }
        String orderCompleteRate2 = getOrderCompleteRate();
        String orderCompleteRate3 = adsData.getOrderCompleteRate();
        if (orderCompleteRate2 != null ? !orderCompleteRate2.equals(orderCompleteRate3) : orderCompleteRate3 != null) {
            return false;
        }
        String takerAcceptOrder2 = getTakerAcceptOrder();
        String takerAcceptOrder3 = adsData.getTakerAcceptOrder();
        if (takerAcceptOrder2 != null ? !takerAcceptOrder2.equals(takerAcceptOrder3) : takerAcceptOrder3 != null) {
            return false;
        }
        String takerAcceptAmount2 = getTakerAcceptAmount();
        String takerAcceptAmount3 = adsData.getTakerAcceptAmount();
        if (takerAcceptAmount2 != null ? !takerAcceptAmount2.equals(takerAcceptAmount3) : takerAcceptAmount3 != null) {
            return false;
        }
        if (getTakerLimit() != adsData.getTakerLimit() || getGmtSort() != adsData.getGmtSort() || getThumbUp() != adsData.getThumbUp() || getSeaViewRoom() != adsData.getSeaViewRoom()) {
            return false;
        }
        String coinName2 = getCoinName();
        String coinName3 = adsData.getCoinName();
        if (coinName2 != null ? !coinName2.equals(coinName3) : coinName3 != null) {
            return false;
        }
        if (isFromWatchword() != adsData.isFromWatchword()) {
            return false;
        }
        String shareCode2 = getShareCode();
        String shareCode3 = adsData.getShareCode();
        if (shareCode2 != null ? !shareCode2.equals(shareCode3) : shareCode3 != null) {
            return false;
        }
        String watchword2 = getWatchword();
        String watchword3 = adsData.getWatchword();
        return watchword2 != null ? watchword2.equals(watchword3) : watchword3 == null;
    }

    public int getBlockType() {
        return this.blockType;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public String getCoinName() {
        return this.coinName;
    }

    public int getCurrency() {
        return this.currency;
    }

    public long getGmtSort() {
        return this.gmtSort;
    }

    public String getId() {
        return this.f78261id;
    }

    public String getMaxTradeLimit() {
        return this.maxTradeLimit;
    }

    public int getMerchantLevel() {
        return this.merchantLevel;
    }

    public List<Integer> getMerchantTags() {
        return this.merchantTags;
    }

    public String getMinTradeLimit() {
        return this.minTradeLimit;
    }

    public String getOrderCompleteRate() {
        return this.orderCompleteRate;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public List<Ads.PaymentInfo> getPayMethods() {
        return this.payMethods;
    }

    public String getPayName() {
        return this.payName;
    }

    public int getPayTerm() {
        return this.payTerm;
    }

    public String getPrice() {
        return this.price;
    }

    public int getSeaViewRoom() {
        return this.seaViewRoom;
    }

    public String getShareCode() {
        return this.shareCode;
    }

    public String getTakerAcceptAmount() {
        return this.takerAcceptAmount;
    }

    public String getTakerAcceptOrder() {
        return this.takerAcceptOrder;
    }

    public int getTakerLimit() {
        return this.takerLimit;
    }

    public int getThumbUp() {
        return this.thumbUp;
    }

    public String getTradeCount() {
        return this.tradeCount;
    }

    public int getTradeMonthTimes() {
        return this.tradeMonthTimes;
    }

    public String getTradeNo() {
        return this.tradeNo;
    }

    public int getTradeType() {
        return this.tradeType;
    }

    public long getUid() {
        return this.uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getWatchword() {
        return this.watchword;
    }

    public int hashCode() {
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        long uid2 = getUid();
        int i12 = ((hashCode + 59) * 59) + ((int) (uid2 ^ (uid2 >>> 32)));
        String userName2 = getUserName();
        int hashCode2 = (((i12 * 59) + (userName2 == null ? 43 : userName2.hashCode())) * 59) + getMerchantLevel();
        List<Integer> merchantTags2 = getMerchantTags();
        int hashCode3 = (((((((((hashCode2 * 59) + (merchantTags2 == null ? 43 : merchantTags2.hashCode())) * 59) + getCoinId()) * 59) + getCurrency()) * 59) + getTradeType()) * 59) + getBlockType();
        String payMethod2 = getPayMethod();
        int hashCode4 = (hashCode3 * 59) + (payMethod2 == null ? 43 : payMethod2.hashCode());
        List<Ads.PaymentInfo> payMethods2 = getPayMethods();
        int hashCode5 = (((hashCode4 * 59) + (payMethods2 == null ? 43 : payMethods2.hashCode())) * 59) + getPayTerm();
        String payName2 = getPayName();
        int hashCode6 = (hashCode5 * 59) + (payName2 == null ? 43 : payName2.hashCode());
        String minTradeLimit2 = getMinTradeLimit();
        int hashCode7 = (hashCode6 * 59) + (minTradeLimit2 == null ? 43 : minTradeLimit2.hashCode());
        String maxTradeLimit2 = getMaxTradeLimit();
        int hashCode8 = (hashCode7 * 59) + (maxTradeLimit2 == null ? 43 : maxTradeLimit2.hashCode());
        String price2 = getPrice();
        int hashCode9 = (hashCode8 * 59) + (price2 == null ? 43 : price2.hashCode());
        String tradeCount2 = getTradeCount();
        int hashCode10 = (hashCode9 * 59) + (tradeCount2 == null ? 43 : tradeCount2.hashCode());
        String tradeNo2 = getTradeNo();
        int i13 = 79;
        int hashCode11 = (((((((hashCode10 * 59) + (tradeNo2 == null ? 43 : tradeNo2.hashCode())) * 59) + (isOnline() ? 79 : 97)) * 59) + (isFollowed() ? 79 : 97)) * 59) + getTradeMonthTimes();
        String orderCompleteRate2 = getOrderCompleteRate();
        int hashCode12 = (hashCode11 * 59) + (orderCompleteRate2 == null ? 43 : orderCompleteRate2.hashCode());
        String takerAcceptOrder2 = getTakerAcceptOrder();
        int hashCode13 = (hashCode12 * 59) + (takerAcceptOrder2 == null ? 43 : takerAcceptOrder2.hashCode());
        String takerAcceptAmount2 = getTakerAcceptAmount();
        int i14 = hashCode13 * 59;
        int hashCode14 = takerAcceptAmount2 == null ? 43 : takerAcceptAmount2.hashCode();
        long gmtSort2 = getGmtSort();
        int takerLimit2 = ((((((((i14 + hashCode14) * 59) + getTakerLimit()) * 59) + ((int) (gmtSort2 ^ (gmtSort2 >>> 32)))) * 59) + getThumbUp()) * 59) + getSeaViewRoom();
        String coinName2 = getCoinName();
        int hashCode15 = ((takerLimit2 * 59) + (coinName2 == null ? 43 : coinName2.hashCode())) * 59;
        if (!isFromWatchword()) {
            i13 = 97;
        }
        String shareCode2 = getShareCode();
        int hashCode16 = ((hashCode15 + i13) * 59) + (shareCode2 == null ? 43 : shareCode2.hashCode());
        String watchword2 = getWatchword();
        int i15 = hashCode16 * 59;
        if (watchword2 != null) {
            i11 = watchword2.hashCode();
        }
        return i15 + i11;
    }

    public boolean isFollowed() {
        return this.isFollowed;
    }

    public boolean isFromWatchword() {
        return this.fromWatchword;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public void setBlockType(int i11) {
        this.blockType = i11;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCoinName(String str) {
        this.coinName = str;
    }

    public void setCurrency(int i11) {
        this.currency = i11;
    }

    public void setFollowed(boolean z11) {
        this.isFollowed = z11;
    }

    public void setFromWatchword(boolean z11) {
        this.fromWatchword = z11;
    }

    public void setGmtSort(long j11) {
        this.gmtSort = j11;
    }

    public void setId(String str) {
        this.f78261id = str;
    }

    public void setMaxTradeLimit(String str) {
        this.maxTradeLimit = str;
    }

    public void setMerchantLevel(int i11) {
        this.merchantLevel = i11;
    }

    public void setMerchantTags(List<Integer> list) {
        this.merchantTags = list;
    }

    public void setMinTradeLimit(String str) {
        this.minTradeLimit = str;
    }

    public void setOnline(boolean z11) {
        this.isOnline = z11;
    }

    public void setOrderCompleteRate(String str) {
        this.orderCompleteRate = str;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public void setPayMethods(List<Ads.PaymentInfo> list) {
        this.payMethods = list;
    }

    public void setPayName(String str) {
        this.payName = str;
    }

    public void setPayTerm(int i11) {
        this.payTerm = i11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSeaViewRoom(int i11) {
        this.seaViewRoom = i11;
    }

    public void setShareCode(String str) {
        this.shareCode = str;
    }

    public void setTakerAcceptAmount(String str) {
        this.takerAcceptAmount = str;
    }

    public void setTakerAcceptOrder(String str) {
        this.takerAcceptOrder = str;
    }

    public void setTakerLimit(int i11) {
        this.takerLimit = i11;
    }

    public void setThumbUp(int i11) {
        this.thumbUp = i11;
    }

    public void setTradeCount(String str) {
        this.tradeCount = str;
    }

    public void setTradeMonthTimes(int i11) {
        this.tradeMonthTimes = i11;
    }

    public void setTradeNo(String str) {
        this.tradeNo = str;
    }

    public void setTradeType(int i11) {
        this.tradeType = i11;
    }

    public void setUid(long j11) {
        this.uid = j11;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setWatchword(String str) {
        this.watchword = str;
    }

    public String toString() {
        return "AdsData(id=" + getId() + ", uid=" + getUid() + ", userName=" + getUserName() + ", merchantLevel=" + getMerchantLevel() + ", merchantTags=" + getMerchantTags() + ", coinId=" + getCoinId() + ", currency=" + getCurrency() + ", tradeType=" + getTradeType() + ", blockType=" + getBlockType() + ", payMethod=" + getPayMethod() + ", payMethods=" + getPayMethods() + ", payTerm=" + getPayTerm() + ", payName=" + getPayName() + ", minTradeLimit=" + getMinTradeLimit() + ", maxTradeLimit=" + getMaxTradeLimit() + ", price=" + getPrice() + ", tradeCount=" + getTradeCount() + ", tradeNo=" + getTradeNo() + ", isOnline=" + isOnline() + ", isFollowed=" + isFollowed() + ", tradeMonthTimes=" + getTradeMonthTimes() + ", orderCompleteRate=" + getOrderCompleteRate() + ", takerAcceptOrder=" + getTakerAcceptOrder() + ", takerAcceptAmount=" + getTakerAcceptAmount() + ", takerLimit=" + getTakerLimit() + ", gmtSort=" + getGmtSort() + ", thumbUp=" + getThumbUp() + ", seaViewRoom=" + getSeaViewRoom() + ", coinName=" + getCoinName() + ", fromWatchword=" + isFromWatchword() + ", shareCode=" + getShareCode() + ", watchword=" + getWatchword() + ")";
    }
}
