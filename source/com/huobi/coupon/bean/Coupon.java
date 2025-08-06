package com.huobi.coupon.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.otc.core.bean.LiteCoupon;
import com.huobi.otc.handler.CouponHandler;
import com.huobi.otc.widget.CouponItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import s9.a;

public class Coupon implements Serializable, a {
    public static final String CANDY_DROP = "CANDY_DROP";
    public static final String OTC = "OTC";
    public static final String PRIME_LIST = "PRIME_LIST";
    public static final String SAVINGS = "SAVINGS";
    public static final String SPOT = "SPOT";
    private static final long serialVersionUID = -7456254626391293122L;
    @SerializedName("activityId")
    private long activityId;
    @SerializedName("amount")
    private String amount;
    @SerializedName("baseCurrency")
    private String baseCurrency;
    @SerializedName("beginTime")
    private long beginTime;
    @SerializedName("businessType")
    private String businessType;
    private transient CouponItem.c callback;
    @SerializedName("ceiling")
    private String ceiling;
    @SerializedName("couponId")
    private long couponId;
    @SerializedName("endTime")
    private long endTime;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    private long f43743id;
    @SerializedName("isEnable")
    private boolean isEnable;
    @SerializedName("isSelected")
    private boolean isSelected;
    @SerializedName("isShowSelected")
    private boolean isShowSelected;
    @SerializedName("meetCondition")
    private String meetCondition;
    @SerializedName("quoteCurrency")
    private String quoteCurrency;
    private String quoteSign;
    @SerializedName("rules")
    private String rules = "";
    @SerializedName("savingsEffectDays")
    private int savingsEffectDays;
    @SerializedName("state")
    private int state = -1;
    @SerializedName("sysTime")
    private long sysTime = -1;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private int type;
    @SerializedName("url")
    private String url;
    @SerializedName("useConditions")
    private int useConditions;
    @SerializedName("usedHP")
    private double usedHP;

    public static List<LiteCoupon> couponListToLiteCouponList(List<Coupon> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(couponToLiteCoupon(list.get(i11)));
        }
        return arrayList;
    }

    public static LiteCoupon couponToLiteCoupon(Coupon coupon) {
        if (coupon == null) {
            return null;
        }
        LiteCoupon liteCoupon = new LiteCoupon();
        liteCoupon.setId(coupon.getId());
        liteCoupon.setActivityId(coupon.getActivityId());
        liteCoupon.setBaseCurrency(coupon.getBaseCurrency());
        liteCoupon.setQuoteCurrency(coupon.getQuoteCurrency());
        liteCoupon.setType(coupon.getType());
        liteCoupon.setMeetCondition(coupon.getMeetCondition());
        liteCoupon.setAmount(coupon.getAmount());
        liteCoupon.setBeginTime(coupon.getBeginTime());
        liteCoupon.setEndTime(coupon.getEndTime());
        liteCoupon.setCeiling(coupon.getCeiling());
        liteCoupon.setQuoteSign(coupon.getQuoteSign());
        liteCoupon.setRules(coupon.getRules());
        liteCoupon.setSysTime(coupon.getSysTime());
        liteCoupon.setBusinessType(coupon.getBusinessType());
        liteCoupon.setTitle(coupon.getTitle());
        liteCoupon.setUsedHP(coupon.getUsedHP());
        liteCoupon.setSelected(coupon.isSelected());
        liteCoupon.setShowSelected(coupon.isShowSelected());
        liteCoupon.setEnable(coupon.isEnable());
        liteCoupon.setState(coupon.getState());
        liteCoupon.setUseConditions(coupon.getUseConditions());
        liteCoupon.setSavingsEffectDays(coupon.getSavingsEffectDays());
        liteCoupon.setUrl(coupon.getUrl());
        return liteCoupon;
    }

    public static List<Coupon> liteListToCouponList(List<LiteCoupon> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(liteToCoupon(list.get(i11)));
        }
        return arrayList;
    }

    public static Coupon liteToCoupon(LiteCoupon liteCoupon) {
        if (liteCoupon == null) {
            return null;
        }
        Coupon coupon = new Coupon();
        coupon.setId(liteCoupon.getId());
        coupon.setActivityId(liteCoupon.getActivityId());
        coupon.setBaseCurrency(liteCoupon.getBaseCurrency());
        coupon.setQuoteCurrency(liteCoupon.getQuoteCurrency());
        coupon.setType(liteCoupon.getType());
        coupon.setMeetCondition(liteCoupon.getMeetCondition());
        coupon.setAmount(liteCoupon.getAmount());
        coupon.setBeginTime(liteCoupon.getBeginTime());
        coupon.setEndTime(liteCoupon.getEndTime());
        coupon.setCeiling(liteCoupon.getCeiling());
        coupon.setQuoteSign(liteCoupon.getQuoteSign());
        coupon.setRules(liteCoupon.getRules());
        coupon.setSysTime(liteCoupon.getSysTime());
        coupon.setBusinessType(liteCoupon.getBusinessType());
        coupon.setTitle(liteCoupon.getTitle());
        coupon.setUsedHP(liteCoupon.getUsedHP());
        coupon.setSelected(liteCoupon.isSelected());
        coupon.setShowSelected(liteCoupon.isShowSelected());
        coupon.setEnable(liteCoupon.isEnable());
        coupon.setState(liteCoupon.getState());
        coupon.setUseConditions(liteCoupon.getUseConditions());
        coupon.setSavingsEffectDays(liteCoupon.getSavingsEffectDays());
        coupon.setUrl(liteCoupon.getUrl());
        return coupon;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof Coupon;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Coupon)) {
            return false;
        }
        Coupon coupon = (Coupon) obj;
        if (!coupon.canEqual(this) || getId() != coupon.getId() || getCouponId() != coupon.getCouponId() || getActivityId() != coupon.getActivityId()) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = coupon.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = coupon.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        if (getType() != coupon.getType() || getState() != coupon.getState()) {
            return false;
        }
        String meetCondition2 = getMeetCondition();
        String meetCondition3 = coupon.getMeetCondition();
        if (meetCondition2 != null ? !meetCondition2.equals(meetCondition3) : meetCondition3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = coupon.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        if (getBeginTime() != coupon.getBeginTime() || getEndTime() != coupon.getEndTime()) {
            return false;
        }
        String ceiling2 = getCeiling();
        String ceiling3 = coupon.getCeiling();
        if (ceiling2 != null ? !ceiling2.equals(ceiling3) : ceiling3 != null) {
            return false;
        }
        String quoteSign2 = getQuoteSign();
        String quoteSign3 = coupon.getQuoteSign();
        if (quoteSign2 != null ? !quoteSign2.equals(quoteSign3) : quoteSign3 != null) {
            return false;
        }
        String rules2 = getRules();
        String rules3 = coupon.getRules();
        if (rules2 != null ? !rules2.equals(rules3) : rules3 != null) {
            return false;
        }
        if (getSysTime() != coupon.getSysTime()) {
            return false;
        }
        String businessType2 = getBusinessType();
        String businessType3 = coupon.getBusinessType();
        if (businessType2 != null ? !businessType2.equals(businessType3) : businessType3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = coupon.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        if (Double.compare(getUsedHP(), coupon.getUsedHP()) != 0 || isSelected() != coupon.isSelected() || isEnable() != coupon.isEnable() || isShowSelected() != coupon.isShowSelected() || getUseConditions() != coupon.getUseConditions() || getSavingsEffectDays() != coupon.getSavingsEffectDays()) {
            return false;
        }
        String url2 = getUrl();
        String url3 = coupon.getUrl();
        return url2 != null ? url2.equals(url3) : url3 == null;
    }

    public long getActivityId() {
        return this.activityId;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public CouponItem.c getCallback() {
        return this.callback;
    }

    public String getCeiling() {
        return this.ceiling;
    }

    public long getCouponId() {
        return this.couponId;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getId() {
        return this.f43743id;
    }

    public String getMeetCondition() {
        return this.meetCondition;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteSign() {
        return this.quoteSign;
    }

    public String getRules() {
        return this.rules;
    }

    public int getSavingsEffectDays() {
        return this.savingsEffectDays;
    }

    public int getState() {
        return this.state;
    }

    public long getSysTime() {
        return this.sysTime;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public int getUseConditions() {
        return this.useConditions;
    }

    public double getUsedHP() {
        return this.usedHP;
    }

    public String getViewHandlerName() {
        return CouponHandler.class.getName();
    }

    public int hashCode() {
        long id2 = getId();
        long couponId2 = getCouponId();
        int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) (couponId2 ^ (couponId2 >>> 32)));
        long activityId2 = getActivityId();
        int i12 = (i11 * 59) + ((int) (activityId2 ^ (activityId2 >>> 32)));
        String baseCurrency2 = getBaseCurrency();
        int i13 = 43;
        int hashCode = (i12 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode2 = (((((hashCode * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode())) * 59) + getType()) * 59) + getState();
        String meetCondition2 = getMeetCondition();
        int hashCode3 = (hashCode2 * 59) + (meetCondition2 == null ? 43 : meetCondition2.hashCode());
        String amount2 = getAmount();
        int i14 = hashCode3 * 59;
        int hashCode4 = amount2 == null ? 43 : amount2.hashCode();
        long beginTime2 = getBeginTime();
        long endTime2 = getEndTime();
        int i15 = ((((i14 + hashCode4) * 59) + ((int) (beginTime2 ^ (beginTime2 >>> 32)))) * 59) + ((int) (endTime2 ^ (endTime2 >>> 32)));
        String ceiling2 = getCeiling();
        int hashCode5 = (i15 * 59) + (ceiling2 == null ? 43 : ceiling2.hashCode());
        String quoteSign2 = getQuoteSign();
        int hashCode6 = (hashCode5 * 59) + (quoteSign2 == null ? 43 : quoteSign2.hashCode());
        String rules2 = getRules();
        int i16 = hashCode6 * 59;
        int hashCode7 = rules2 == null ? 43 : rules2.hashCode();
        long sysTime2 = getSysTime();
        int i17 = ((i16 + hashCode7) * 59) + ((int) (sysTime2 ^ (sysTime2 >>> 32)));
        String businessType2 = getBusinessType();
        int hashCode8 = (i17 * 59) + (businessType2 == null ? 43 : businessType2.hashCode());
        String title2 = getTitle();
        int i18 = hashCode8 * 59;
        int hashCode9 = title2 == null ? 43 : title2.hashCode();
        long doubleToLongBits = Double.doubleToLongBits(getUsedHP());
        int i19 = (((i18 + hashCode9) * 59) + ((int) ((doubleToLongBits >>> 32) ^ doubleToLongBits))) * 59;
        int i21 = 79;
        int i22 = (((i19 + (isSelected() ? 79 : 97)) * 59) + (isEnable() ? 79 : 97)) * 59;
        if (!isShowSelected()) {
            i21 = 97;
        }
        int useConditions2 = ((((i22 + i21) * 59) + getUseConditions()) * 59) + getSavingsEffectDays();
        String url2 = getUrl();
        int i23 = useConditions2 * 59;
        if (url2 != null) {
            i13 = url2.hashCode();
        }
        return i23 + i13;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isShowSelected() {
        return this.isShowSelected;
    }

    public void setActivityId(long j11) {
        this.activityId = j11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBeginTime(long j11) {
        this.beginTime = j11;
    }

    public void setBusinessType(String str) {
        this.businessType = str;
    }

    public void setCallback(CouponItem.c cVar) {
        this.callback = cVar;
    }

    public void setCeiling(String str) {
        this.ceiling = str;
    }

    public void setCouponId(long j11) {
        this.couponId = j11;
    }

    public void setEnable(boolean z11) {
        this.isEnable = z11;
    }

    public void setEndTime(long j11) {
        this.endTime = j11;
    }

    public void setId(long j11) {
        this.f43743id = j11;
    }

    public void setMeetCondition(String str) {
        this.meetCondition = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuoteSign(String str) {
        this.quoteSign = str;
    }

    public void setRules(String str) {
        this.rules = str;
    }

    public void setSavingsEffectDays(int i11) {
        this.savingsEffectDays = i11;
    }

    public void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public void setShowSelected(boolean z11) {
        this.isShowSelected = z11;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public void setSysTime(long j11) {
        this.sysTime = j11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUseConditions(int i11) {
        this.useConditions = i11;
    }

    public void setUsedHP(double d11) {
        this.usedHP = d11;
    }

    public String toString() {
        return "Coupon(id=" + getId() + ", couponId=" + getCouponId() + ", activityId=" + getActivityId() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", type=" + getType() + ", state=" + getState() + ", meetCondition=" + getMeetCondition() + ", amount=" + getAmount() + ", beginTime=" + getBeginTime() + ", endTime=" + getEndTime() + ", ceiling=" + getCeiling() + ", quoteSign=" + getQuoteSign() + ", rules=" + getRules() + ", sysTime=" + getSysTime() + ", businessType=" + getBusinessType() + ", title=" + getTitle() + ", usedHP=" + getUsedHP() + ", isSelected=" + isSelected() + ", isEnable=" + isEnable() + ", isShowSelected=" + isShowSelected() + ", useConditions=" + getUseConditions() + ", savingsEffectDays=" + getSavingsEffectDays() + ", url=" + getUrl() + ", callback=" + getCallback() + ")";
    }
}
