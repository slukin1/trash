package com.huobi.otc.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hbg.bean.OtcTradeType;
import com.huobi.otc.enums.OtcReceiveOrderAdsType;
import com.huobi.otc.handler.AdsPublishViewHandler;
import com.huobi.otc.handler.AdsViewHandler;
import com.huobi.otc.handler.EasyTradeOtc;
import com.huobi.otc.handler.MerchantOnlineViewHandler;
import com.huobi.otc.handler.entity.SeaViewRoomHandler;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mp.b;
import s9.a;

public class Ads implements Serializable, a {
    public static final int HANDLE_TPYE_ONE_KEY_TO_BUY = 2;
    public static final int HANDLE_TPYE_SEA_VIEW_ROOM = 3;
    public static final int HANDLE_TPYE_USER_ADS_VIEW = 5;
    public static final int HANDLE_TYPE_AD_PUBLISH = 4;
    private kp.a adsClickListener;
    private int appealMonthTimes;
    private int appealMonthWinTimes;
    private String autoReplyContent;
    private int blockType;
    private double calcRate;
    private cp.a callback;
    private boolean chargeType;
    private int coinId;
    private int currency;
    private List<Ads> extraData;
    private String gmtCreate;
    private long gmtSort;

    /* renamed from: id  reason: collision with root package name */
    private String f78260id;
    private boolean isExpand;
    private boolean isFollowed;
    private boolean isOnline;
    private boolean isShield;
    private boolean isShieldChange;
    private boolean isShowShare = true;
    private boolean isTrade;
    private String labelName;
    private mp.a listener;
    private String maxTradeLimit;
    private int merchantLevel;
    private List<Integer> merchantTags;
    private String minTradeLimit;
    private boolean notClearTheOneKeyItem;
    private b onClickOneKeyToBuyListener;
    private String orderCompleteRate;
    private OtcOneKeyBuyConfig otcOneKeyBuyConfig;
    private String payAccount;
    private String payMethod;
    private List<PaymentInfo> payMethods;
    private String payName;
    private int payTerm;
    private double premium;
    private String price;
    private boolean seaViewFlag;
    private int seaViewRoom;
    private int seaViewRoomPosition;
    private int status;
    private String takerAcceptAmount;
    private String takerAcceptOrder;
    private boolean takerIsPhoneBind;
    private int takerLimit;
    private int takerRealLevel;
    private int takerTradeTimes;
    private int thumbUp;
    private int totalTradeOrderCount;
    private String tradeCount;
    private int tradeMonthTimes;
    private String tradeNo;
    private OtcTradeType tradeType;
    private int typeHandler;
    private long uid;
    private String userName;
    private boolean verifyCapitalEnabled = false;
    private int verifyCapitalStatus;

    public static class PaymentInfo implements Serializable, Parcelable {
        public static final Parcelable.Creator<PaymentInfo> CREATOR = new Parcelable.Creator<PaymentInfo>() {
            public PaymentInfo createFromParcel(Parcel parcel) {
                return new PaymentInfo(parcel);
            }

            public PaymentInfo[] newArray(int i11) {
                return new PaymentInfo[i11];
            }
        };
        private String color;
        private String name;
        private String payMethodId;

        public PaymentInfo(Parcel parcel) {
            this.payMethodId = parcel.readString();
            this.name = parcel.readString();
            this.color = parcel.readString();
        }

        public boolean canEqual(Object obj) {
            return obj instanceof PaymentInfo;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PaymentInfo)) {
                return false;
            }
            PaymentInfo paymentInfo = (PaymentInfo) obj;
            if (!paymentInfo.canEqual(this)) {
                return false;
            }
            String payMethodId2 = getPayMethodId();
            String payMethodId3 = paymentInfo.getPayMethodId();
            if (payMethodId2 != null ? !payMethodId2.equals(payMethodId3) : payMethodId3 != null) {
                return false;
            }
            String name2 = getName();
            String name3 = paymentInfo.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            String color2 = getColor();
            String color3 = paymentInfo.getColor();
            return color2 != null ? color2.equals(color3) : color3 == null;
        }

        public String getColor() {
            return this.color;
        }

        public String getName() {
            return this.name;
        }

        public String getPayMethodId() {
            return this.payMethodId;
        }

        public int hashCode() {
            String payMethodId2 = getPayMethodId();
            int i11 = 43;
            int hashCode = payMethodId2 == null ? 43 : payMethodId2.hashCode();
            String name2 = getName();
            int hashCode2 = ((hashCode + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
            String color2 = getColor();
            int i12 = hashCode2 * 59;
            if (color2 != null) {
                i11 = color2.hashCode();
            }
            return i12 + i11;
        }

        public void setColor(String str) {
            this.color = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPayMethodId(String str) {
            this.payMethodId = str;
        }

        public String toString() {
            return "Ads.PaymentInfo(payMethodId=" + getPayMethodId() + ", name=" + getName() + ", color=" + getColor() + ")";
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.payMethodId);
            parcel.writeString(this.name);
            parcel.writeString(this.color);
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof Ads;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ads)) {
            return false;
        }
        Ads ads = (Ads) obj;
        if (!ads.canEqual(this)) {
            return false;
        }
        String id2 = getId();
        String id3 = ads.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        String tradeNo2 = getTradeNo();
        String tradeNo3 = ads.getTradeNo();
        if (tradeNo2 != null ? !tradeNo2.equals(tradeNo3) : tradeNo3 != null) {
            return false;
        }
        if (getCoinId() != ads.getCoinId()) {
            return false;
        }
        OtcTradeType tradeType2 = getTradeType();
        OtcTradeType tradeType3 = ads.getTradeType();
        if (tradeType2 != null ? !tradeType2.equals(tradeType3) : tradeType3 != null) {
            return false;
        }
        if (getBlockType() != ads.getBlockType() || getMerchantLevel() != ads.getMerchantLevel() || getThumbUp() != ads.getThumbUp() || getCurrency() != ads.getCurrency()) {
            return false;
        }
        List<String> payMethod2 = getPayMethod();
        List<String> payMethod3 = ads.getPayMethod();
        if (payMethod2 != null ? !payMethod2.equals(payMethod3) : payMethod3 != null) {
            return false;
        }
        List<PaymentInfo> payMethods2 = getPayMethods();
        List<PaymentInfo> payMethods3 = ads.getPayMethods();
        if (payMethods2 != null ? !payMethods2.equals(payMethods3) : payMethods3 != null) {
            return false;
        }
        String payName2 = getPayName();
        String payName3 = ads.getPayName();
        if (payName2 != null ? !payName2.equals(payName3) : payName3 != null) {
            return false;
        }
        if (getUid() != ads.getUid()) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = ads.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        String minTradeLimit2 = getMinTradeLimit();
        String minTradeLimit3 = ads.getMinTradeLimit();
        if (minTradeLimit2 != null ? !minTradeLimit2.equals(minTradeLimit3) : minTradeLimit3 != null) {
            return false;
        }
        String maxTradeLimit2 = getMaxTradeLimit();
        String maxTradeLimit3 = ads.getMaxTradeLimit();
        if (maxTradeLimit2 != null ? !maxTradeLimit2.equals(maxTradeLimit3) : maxTradeLimit3 != null) {
            return false;
        }
        if (Double.compare(getCalcRate(), ads.getCalcRate()) != 0) {
            return false;
        }
        String price2 = getPrice();
        String price3 = ads.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        if (getGmtSort() != ads.getGmtSort()) {
            return false;
        }
        String tradeCount2 = getTradeCount();
        String tradeCount3 = ads.getTradeCount();
        if (tradeCount2 != null ? !tradeCount2.equals(tradeCount3) : tradeCount3 != null) {
            return false;
        }
        if (isOnline() != ads.isOnline() || getTradeMonthTimes() != ads.getTradeMonthTimes() || getTotalTradeOrderCount() != ads.getTotalTradeOrderCount() || getAppealMonthTimes() != ads.getAppealMonthTimes() || getAppealMonthWinTimes() != ads.getAppealMonthWinTimes() || getTakerRealLevel() != ads.getTakerRealLevel() || isTakerIsPhoneBind() != ads.isTakerIsPhoneBind() || getTakerTradeTimes() != ads.getTakerTradeTimes() || getTakerLimit() != ads.getTakerLimit()) {
            return false;
        }
        String orderCompleteRate2 = getOrderCompleteRate();
        String orderCompleteRate3 = ads.getOrderCompleteRate();
        if (orderCompleteRate2 != null ? !orderCompleteRate2.equals(orderCompleteRate3) : orderCompleteRate3 != null) {
            return false;
        }
        if (Double.compare(getPremium(), ads.getPremium()) != 0) {
            return false;
        }
        String payAccount2 = getPayAccount();
        String payAccount3 = ads.getPayAccount();
        if (payAccount2 != null ? !payAccount2.equals(payAccount3) : payAccount3 != null) {
            return false;
        }
        if (getPayTerm() != ads.getPayTerm() || getStatus() != ads.getStatus()) {
            return false;
        }
        String gmtCreate2 = getGmtCreate();
        String gmtCreate3 = ads.getGmtCreate();
        if (gmtCreate2 != null ? !gmtCreate2.equals(gmtCreate3) : gmtCreate3 != null) {
            return false;
        }
        if (isFollowed() != ads.isFollowed() || isShield() != ads.isShield() || isShieldChange() != ads.isShieldChange() || isTrade() != ads.isTrade() || isShowShare() != ads.isShowShare()) {
            return false;
        }
        String autoReplyContent2 = getAutoReplyContent();
        String autoReplyContent3 = ads.getAutoReplyContent();
        if (autoReplyContent2 != null ? !autoReplyContent2.equals(autoReplyContent3) : autoReplyContent3 != null) {
            return false;
        }
        kp.a adsClickListener2 = getAdsClickListener();
        kp.a adsClickListener3 = ads.getAdsClickListener();
        if (adsClickListener2 != null ? !adsClickListener2.equals(adsClickListener3) : adsClickListener3 != null) {
            return false;
        }
        OtcOneKeyBuyConfig otcOneKeyBuyConfig2 = getOtcOneKeyBuyConfig();
        OtcOneKeyBuyConfig otcOneKeyBuyConfig3 = ads.getOtcOneKeyBuyConfig();
        if (otcOneKeyBuyConfig2 != null ? !otcOneKeyBuyConfig2.equals(otcOneKeyBuyConfig3) : otcOneKeyBuyConfig3 != null) {
            return false;
        }
        mp.a listener2 = getListener();
        mp.a listener3 = ads.getListener();
        if (listener2 != null ? !listener2.equals(listener3) : listener3 != null) {
            return false;
        }
        b onClickOneKeyToBuyListener2 = getOnClickOneKeyToBuyListener();
        b onClickOneKeyToBuyListener3 = ads.getOnClickOneKeyToBuyListener();
        if (onClickOneKeyToBuyListener2 != null ? !onClickOneKeyToBuyListener2.equals(onClickOneKeyToBuyListener3) : onClickOneKeyToBuyListener3 != null) {
            return false;
        }
        if (getTypeHandler() != ads.getTypeHandler() || isNotClearTheOneKeyItem() != ads.isNotClearTheOneKeyItem()) {
            return false;
        }
        List<Integer> merchantTags2 = getMerchantTags();
        List<Integer> merchantTags3 = ads.getMerchantTags();
        if (merchantTags2 != null ? !merchantTags2.equals(merchantTags3) : merchantTags3 != null) {
            return false;
        }
        String takerAcceptOrder2 = getTakerAcceptOrder();
        String takerAcceptOrder3 = ads.getTakerAcceptOrder();
        if (takerAcceptOrder2 != null ? !takerAcceptOrder2.equals(takerAcceptOrder3) : takerAcceptOrder3 != null) {
            return false;
        }
        String takerAcceptAmount2 = getTakerAcceptAmount();
        String takerAcceptAmount3 = ads.getTakerAcceptAmount();
        if (takerAcceptAmount2 != null ? !takerAcceptAmount2.equals(takerAcceptAmount3) : takerAcceptAmount3 != null) {
            return false;
        }
        List<Ads> extraData2 = getExtraData();
        List<Ads> extraData3 = ads.getExtraData();
        if (extraData2 != null ? !extraData2.equals(extraData3) : extraData3 != null) {
            return false;
        }
        cp.a callback2 = getCallback();
        cp.a callback3 = ads.getCallback();
        if (callback2 != null ? !callback2.equals(callback3) : callback3 != null) {
            return false;
        }
        if (getSeaViewRoom() != ads.getSeaViewRoom() || isSeaViewFlag() != ads.isSeaViewFlag() || isExpand() != ads.isExpand() || getVerifyCapitalStatus() != ads.getVerifyCapitalStatus() || isVerifyCapitalEnabled() != ads.isVerifyCapitalEnabled()) {
            return false;
        }
        String labelName2 = getLabelName();
        String labelName3 = ads.getLabelName();
        if (labelName2 != null ? labelName2.equals(labelName3) : labelName3 == null) {
            return isChargeType() == ads.isChargeType() && getSeaViewRoomPosition() == ads.getSeaViewRoomPosition();
        }
        return false;
    }

    public kp.a getAdsClickListener() {
        return this.adsClickListener;
    }

    public int getAppealMonthTimes() {
        return this.appealMonthTimes;
    }

    public int getAppealMonthWinTimes() {
        return this.appealMonthWinTimes;
    }

    public String getAutoReplyContent() {
        return this.autoReplyContent;
    }

    public int getBlockType() {
        return this.blockType;
    }

    public double getCalcRate() {
        return this.calcRate;
    }

    public cp.a getCallback() {
        return this.callback;
    }

    public int getCoinId() {
        return this.coinId;
    }

    public int getCurrency() {
        return this.currency;
    }

    public List<Ads> getExtraData() {
        return this.extraData;
    }

    public String getGmtCreate() {
        return this.gmtCreate;
    }

    public long getGmtSort() {
        return this.gmtSort;
    }

    public String getId() {
        return this.f78260id;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public mp.a getListener() {
        return this.listener;
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

    public b getOnClickOneKeyToBuyListener() {
        return this.onClickOneKeyToBuyListener;
    }

    public String getOrderCompleteRate() {
        return this.orderCompleteRate;
    }

    public OtcOneKeyBuyConfig getOtcOneKeyBuyConfig() {
        return this.otcOneKeyBuyConfig;
    }

    public String getPayAccount() {
        return this.payAccount;
    }

    public List<String> getPayMethod() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.payMethod)) {
            if (this.payMethod.contains(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                arrayList.addAll(Arrays.asList(this.payMethod.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
            } else {
                arrayList.add(this.payMethod);
            }
        }
        return arrayList;
    }

    public String getPayMethodStr() {
        return this.payMethod;
    }

    public List<PaymentInfo> getPayMethods() {
        return this.payMethods;
    }

    public String getPayName() {
        return this.payName;
    }

    public int getPayTerm() {
        return this.payTerm;
    }

    public double getPremium() {
        return this.premium;
    }

    public String getPrice() {
        return this.price;
    }

    public int getSeaViewRoom() {
        return this.seaViewRoom;
    }

    public int getSeaViewRoomPosition() {
        return this.seaViewRoomPosition;
    }

    public int getStatus() {
        return this.status;
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

    public int getTakerRealLevel() {
        return this.takerRealLevel;
    }

    public int getTakerTradeTimes() {
        return this.takerTradeTimes;
    }

    public int getThumbUp() {
        return this.thumbUp;
    }

    public int getTotalTradeOrderCount() {
        return this.totalTradeOrderCount;
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

    public OtcTradeType getTradeType() {
        return this.tradeType;
    }

    public int getTypeHandler() {
        return this.typeHandler;
    }

    public long getUid() {
        return this.uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getVerifyCapitalStatus() {
        return this.verifyCapitalStatus;
    }

    public String getViewHandlerName() {
        int i11 = this.typeHandler;
        if (i11 == 0) {
            return AdsViewHandler.class.getName();
        }
        if (i11 == 2) {
            return EasyTradeOtc.class.getName();
        }
        if (i11 == 3) {
            return SeaViewRoomHandler.class.getName();
        }
        if (i11 == 4) {
            return AdsPublishViewHandler.class.getName();
        }
        return MerchantOnlineViewHandler.class.getName();
    }

    public boolean hasEnablePay() {
        return !getPayMethod().isEmpty();
    }

    public int hashCode() {
        String id2 = getId();
        int i11 = 43;
        int hashCode = id2 == null ? 43 : id2.hashCode();
        String tradeNo2 = getTradeNo();
        int hashCode2 = ((((hashCode + 59) * 59) + (tradeNo2 == null ? 43 : tradeNo2.hashCode())) * 59) + getCoinId();
        OtcTradeType tradeType2 = getTradeType();
        int hashCode3 = (((((((((hashCode2 * 59) + (tradeType2 == null ? 43 : tradeType2.hashCode())) * 59) + getBlockType()) * 59) + getMerchantLevel()) * 59) + getThumbUp()) * 59) + getCurrency();
        List<String> payMethod2 = getPayMethod();
        int hashCode4 = (hashCode3 * 59) + (payMethod2 == null ? 43 : payMethod2.hashCode());
        List<PaymentInfo> payMethods2 = getPayMethods();
        int hashCode5 = (hashCode4 * 59) + (payMethods2 == null ? 43 : payMethods2.hashCode());
        String payName2 = getPayName();
        int hashCode6 = (hashCode5 * 59) + (payName2 == null ? 43 : payName2.hashCode());
        long uid2 = getUid();
        int i12 = (hashCode6 * 59) + ((int) (uid2 ^ (uid2 >>> 32)));
        String userName2 = getUserName();
        int hashCode7 = (i12 * 59) + (userName2 == null ? 43 : userName2.hashCode());
        String minTradeLimit2 = getMinTradeLimit();
        int hashCode8 = (hashCode7 * 59) + (minTradeLimit2 == null ? 43 : minTradeLimit2.hashCode());
        String maxTradeLimit2 = getMaxTradeLimit();
        int hashCode9 = (hashCode8 * 59) + (maxTradeLimit2 == null ? 43 : maxTradeLimit2.hashCode());
        long doubleToLongBits = Double.doubleToLongBits(getCalcRate());
        int i13 = (hashCode9 * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        String price2 = getPrice();
        int hashCode10 = (i13 * 59) + (price2 == null ? 43 : price2.hashCode());
        long gmtSort2 = getGmtSort();
        int i14 = (hashCode10 * 59) + ((int) (gmtSort2 ^ (gmtSort2 >>> 32)));
        String tradeCount2 = getTradeCount();
        int i15 = 79;
        int hashCode11 = (((((((((((((((((((i14 * 59) + (tradeCount2 == null ? 43 : tradeCount2.hashCode())) * 59) + (isOnline() ? 79 : 97)) * 59) + getTradeMonthTimes()) * 59) + getTotalTradeOrderCount()) * 59) + getAppealMonthTimes()) * 59) + getAppealMonthWinTimes()) * 59) + getTakerRealLevel()) * 59) + (isTakerIsPhoneBind() ? 79 : 97)) * 59) + getTakerTradeTimes()) * 59) + getTakerLimit();
        String orderCompleteRate2 = getOrderCompleteRate();
        int i16 = hashCode11 * 59;
        int hashCode12 = orderCompleteRate2 == null ? 43 : orderCompleteRate2.hashCode();
        long doubleToLongBits2 = Double.doubleToLongBits(getPremium());
        int i17 = ((i16 + hashCode12) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        String payAccount2 = getPayAccount();
        int hashCode13 = (((((i17 * 59) + (payAccount2 == null ? 43 : payAccount2.hashCode())) * 59) + getPayTerm()) * 59) + getStatus();
        String gmtCreate2 = getGmtCreate();
        int hashCode14 = (((((((((((hashCode13 * 59) + (gmtCreate2 == null ? 43 : gmtCreate2.hashCode())) * 59) + (isFollowed() ? 79 : 97)) * 59) + (isShield() ? 79 : 97)) * 59) + (isShieldChange() ? 79 : 97)) * 59) + (isTrade() ? 79 : 97)) * 59) + (isShowShare() ? 79 : 97);
        String autoReplyContent2 = getAutoReplyContent();
        int hashCode15 = (hashCode14 * 59) + (autoReplyContent2 == null ? 43 : autoReplyContent2.hashCode());
        kp.a adsClickListener2 = getAdsClickListener();
        int hashCode16 = (hashCode15 * 59) + (adsClickListener2 == null ? 43 : adsClickListener2.hashCode());
        OtcOneKeyBuyConfig otcOneKeyBuyConfig2 = getOtcOneKeyBuyConfig();
        int hashCode17 = (hashCode16 * 59) + (otcOneKeyBuyConfig2 == null ? 43 : otcOneKeyBuyConfig2.hashCode());
        mp.a listener2 = getListener();
        int hashCode18 = (hashCode17 * 59) + (listener2 == null ? 43 : listener2.hashCode());
        b onClickOneKeyToBuyListener2 = getOnClickOneKeyToBuyListener();
        int hashCode19 = (((((hashCode18 * 59) + (onClickOneKeyToBuyListener2 == null ? 43 : onClickOneKeyToBuyListener2.hashCode())) * 59) + getTypeHandler()) * 59) + (isNotClearTheOneKeyItem() ? 79 : 97);
        List<Integer> merchantTags2 = getMerchantTags();
        int hashCode20 = (hashCode19 * 59) + (merchantTags2 == null ? 43 : merchantTags2.hashCode());
        String takerAcceptOrder2 = getTakerAcceptOrder();
        int hashCode21 = (hashCode20 * 59) + (takerAcceptOrder2 == null ? 43 : takerAcceptOrder2.hashCode());
        String takerAcceptAmount2 = getTakerAcceptAmount();
        int hashCode22 = (hashCode21 * 59) + (takerAcceptAmount2 == null ? 43 : takerAcceptAmount2.hashCode());
        List<Ads> extraData2 = getExtraData();
        int hashCode23 = (hashCode22 * 59) + (extraData2 == null ? 43 : extraData2.hashCode());
        cp.a callback2 = getCallback();
        int hashCode24 = (((((((((((hashCode23 * 59) + (callback2 == null ? 43 : callback2.hashCode())) * 59) + getSeaViewRoom()) * 59) + (isSeaViewFlag() ? 79 : 97)) * 59) + (isExpand() ? 79 : 97)) * 59) + getVerifyCapitalStatus()) * 59) + (isVerifyCapitalEnabled() ? 79 : 97);
        String labelName2 = getLabelName();
        int i18 = hashCode24 * 59;
        if (labelName2 != null) {
            i11 = labelName2.hashCode();
        }
        int i19 = (i18 + i11) * 59;
        if (!isChargeType()) {
            i15 = 97;
        }
        return ((i19 + i15) * 59) + getSeaViewRoomPosition();
    }

    public boolean isAcceptOrder() {
        return TextUtils.equals(this.takerAcceptOrder, OtcReceiveOrderAdsType.RECEIVE_ORDER.getValue());
    }

    public boolean isBlueShieldMerchant() {
        List<Integer> list = this.merchantTags;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (Integer next : this.merchantTags) {
            if (next != null && next.intValue() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean isChargeType() {
        return this.chargeType;
    }

    public boolean isExpand() {
        return this.isExpand;
    }

    public boolean isFollowed() {
        return this.isFollowed;
    }

    public boolean isNeedAdvancedKyc() {
        return (this.takerLimit & 2) > 0;
    }

    public boolean isNeedBindPhoneNum() {
        return (this.takerLimit & 1) > 0;
    }

    public boolean isNeedKyc() {
        return (this.takerLimit & 4) > 0;
    }

    public boolean isNotClearTheOneKeyItem() {
        return this.notClearTheOneKeyItem;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public boolean isSeaViewFlag() {
        return this.seaViewFlag;
    }

    public boolean isShield() {
        return this.isShield;
    }

    public boolean isShieldChange() {
        return this.isShieldChange;
    }

    public boolean isShowShare() {
        return this.isShowShare;
    }

    public boolean isTakerIsPhoneBind() {
        return this.takerIsPhoneBind;
    }

    public boolean isTrade() {
        return this.isTrade;
    }

    public boolean isTradeLimit() {
        return (this.takerLimit & 8) > 0;
    }

    public boolean isVerifyCapitalEnabled() {
        return this.verifyCapitalEnabled;
    }

    public void setAdsClickListener(kp.a aVar) {
        this.adsClickListener = aVar;
    }

    public void setAppealMonthTimes(int i11) {
        this.appealMonthTimes = i11;
    }

    public void setAppealMonthWinTimes(int i11) {
        this.appealMonthWinTimes = i11;
    }

    public void setAutoReplyContent(String str) {
        this.autoReplyContent = str;
    }

    public void setBlockType(int i11) {
        this.blockType = i11;
    }

    public void setCalcRate(double d11) {
        this.calcRate = d11;
    }

    public void setCallback(cp.a aVar) {
        this.callback = aVar;
    }

    public void setChargeType(boolean z11) {
        this.chargeType = z11;
    }

    public void setCoinId(int i11) {
        this.coinId = i11;
    }

    public void setCurrency(int i11) {
        this.currency = i11;
    }

    public void setExpand(boolean z11) {
        this.isExpand = z11;
    }

    public void setExtraData(List<Ads> list) {
        this.extraData = list;
    }

    public void setFollowed(boolean z11) {
        this.isFollowed = z11;
    }

    public void setGmtCreate(String str) {
        this.gmtCreate = str;
    }

    public void setGmtSort(long j11) {
        this.gmtSort = j11;
    }

    public void setId(String str) {
        this.f78260id = str;
    }

    public void setLabelName(String str) {
        this.labelName = str;
    }

    public void setListener(mp.a aVar) {
        this.listener = aVar;
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

    public void setNotClearTheOneKeyItem(boolean z11) {
        this.notClearTheOneKeyItem = z11;
    }

    public void setOnClickOneKeyToBuyListener(b bVar) {
        this.onClickOneKeyToBuyListener = bVar;
    }

    public void setOnline(boolean z11) {
        this.isOnline = z11;
    }

    public void setOrderCompleteRate(String str) {
        this.orderCompleteRate = str;
    }

    public void setOtcOneKeyBuyConfig(OtcOneKeyBuyConfig otcOneKeyBuyConfig2) {
        this.otcOneKeyBuyConfig = otcOneKeyBuyConfig2;
    }

    public void setPayAccount(String str) {
        this.payAccount = str;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public void setPayMethods(List<PaymentInfo> list) {
        this.payMethods = list;
    }

    public void setPayName(String str) {
        this.payName = str;
    }

    public void setPayTerm(int i11) {
        this.payTerm = i11;
    }

    public void setPremium(double d11) {
        this.premium = d11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setSeaViewFlag(boolean z11) {
        this.seaViewFlag = z11;
    }

    public void setSeaViewRoom(int i11) {
        this.seaViewRoom = i11;
    }

    public void setSeaViewRoomPosition(int i11) {
        this.seaViewRoomPosition = i11;
    }

    public void setShield(boolean z11) {
        this.isShield = z11;
    }

    public void setShieldChange(boolean z11) {
        this.isShieldChange = z11;
    }

    public void setShowShare(boolean z11) {
        this.isShowShare = z11;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setTakerAcceptAmount(String str) {
        this.takerAcceptAmount = str;
    }

    public void setTakerAcceptOrder(String str) {
        this.takerAcceptOrder = str;
    }

    public void setTakerIsPhoneBind(boolean z11) {
        this.takerIsPhoneBind = z11;
    }

    public void setTakerLimit(int i11) {
        this.takerLimit = i11;
    }

    public void setTakerRealLevel(int i11) {
        this.takerRealLevel = i11;
    }

    public void setTakerTradeTimes(int i11) {
        this.takerTradeTimes = i11;
    }

    public void setThumbUp(int i11) {
        this.thumbUp = i11;
    }

    public void setTotalTradeOrderCount(int i11) {
        this.totalTradeOrderCount = i11;
    }

    public void setTrade(boolean z11) {
        this.isTrade = z11;
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

    public void setTradeType(OtcTradeType otcTradeType) {
        this.tradeType = otcTradeType;
    }

    public void setTypeHandler(int i11) {
        this.typeHandler = i11;
    }

    public void setUid(long j11) {
        this.uid = j11;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setVerifyCapitalEnabled(boolean z11) {
        this.verifyCapitalEnabled = z11;
    }

    public void setVerifyCapitalStatus(int i11) {
        this.verifyCapitalStatus = i11;
    }

    public String toString() {
        return "Ads(id=" + getId() + ", tradeNo=" + getTradeNo() + ", coinId=" + getCoinId() + ", tradeType=" + getTradeType() + ", blockType=" + getBlockType() + ", merchantLevel=" + getMerchantLevel() + ", thumbUp=" + getThumbUp() + ", currency=" + getCurrency() + ", payMethod=" + getPayMethod() + ", payMethods=" + getPayMethods() + ", payName=" + getPayName() + ", uid=" + getUid() + ", userName=" + getUserName() + ", minTradeLimit=" + getMinTradeLimit() + ", maxTradeLimit=" + getMaxTradeLimit() + ", calcRate=" + getCalcRate() + ", price=" + getPrice() + ", gmtSort=" + getGmtSort() + ", tradeCount=" + getTradeCount() + ", isOnline=" + isOnline() + ", tradeMonthTimes=" + getTradeMonthTimes() + ", totalTradeOrderCount=" + getTotalTradeOrderCount() + ", appealMonthTimes=" + getAppealMonthTimes() + ", appealMonthWinTimes=" + getAppealMonthWinTimes() + ", takerRealLevel=" + getTakerRealLevel() + ", takerIsPhoneBind=" + isTakerIsPhoneBind() + ", takerTradeTimes=" + getTakerTradeTimes() + ", takerLimit=" + getTakerLimit() + ", orderCompleteRate=" + getOrderCompleteRate() + ", premium=" + getPremium() + ", payAccount=" + getPayAccount() + ", payTerm=" + getPayTerm() + ", status=" + getStatus() + ", gmtCreate=" + getGmtCreate() + ", isFollowed=" + isFollowed() + ", isShield=" + isShield() + ", isShieldChange=" + isShieldChange() + ", isTrade=" + isTrade() + ", isShowShare=" + isShowShare() + ", autoReplyContent=" + getAutoReplyContent() + ", adsClickListener=" + getAdsClickListener() + ", otcOneKeyBuyConfig=" + getOtcOneKeyBuyConfig() + ", listener=" + getListener() + ", onClickOneKeyToBuyListener=" + getOnClickOneKeyToBuyListener() + ", typeHandler=" + getTypeHandler() + ", notClearTheOneKeyItem=" + isNotClearTheOneKeyItem() + ", merchantTags=" + getMerchantTags() + ", takerAcceptOrder=" + getTakerAcceptOrder() + ", takerAcceptAmount=" + getTakerAcceptAmount() + ", extraData=" + getExtraData() + ", callback=" + getCallback() + ", seaViewRoom=" + getSeaViewRoom() + ", seaViewFlag=" + isSeaViewFlag() + ", isExpand=" + isExpand() + ", verifyCapitalStatus=" + getVerifyCapitalStatus() + ", verifyCapitalEnabled=" + isVerifyCapitalEnabled() + ", labelName=" + getLabelName() + ", chargeType=" + isChargeType() + ", seaViewRoomPosition=" + getSeaViewRoomPosition() + ")";
    }
}
