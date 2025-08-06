package com.huobi.coupon.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.otc.handler.CouponReturnHandler;
import com.huobi.otc.handler.ExperienceHandler;
import com.huobi.otc.widget.CouponReturnItem;
import com.huobi.otc.widget.ExperienceItem;
import java.io.Serializable;
import s9.a;

public class CouponReturn implements Serializable, a {
    public static final int STATE_NOT_USED = 0;
    public static final String TYPE_EXPERIENCE = "10";
    public static final String TYPE_FEE_BACK = "9";
    public static final int TYPE_GRID_EXPERIENCE = 15;
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
    private transient CouponReturnItem.b callback;
    private String channel;
    @SerializedName("couponId")
    private long couponId;
    @SerializedName("endTime")
    private long endTime;
    private transient ExperienceItem.e exCallback;
    public boolean expanded = false;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    private long f43744id;
    @SerializedName("isSelected")
    private boolean isSelected;
    @SerializedName("meetCondition")
    private String meetCondition;
    @SerializedName("quoteCurrency")
    private String quoteCurrency;
    private String quoteSign;
    @SerializedName("rules")
    private String rules = "";
    @SerializedName("savingsEffectDays")
    private Integer savingsEffectDays;
    public boolean showNoThreshold = false;
    @SerializedName("state")
    private int state = -1;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private int type;
    @SerializedName("validAt")
    private long validAt;

    public boolean canEqual(Object obj) {
        return obj instanceof CouponReturn;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CouponReturn)) {
            return false;
        }
        CouponReturn couponReturn = (CouponReturn) obj;
        if (!couponReturn.canEqual(this) || getId() != couponReturn.getId() || getActivityId() != couponReturn.getActivityId()) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = couponReturn.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = couponReturn.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String quoteSign2 = getQuoteSign();
        String quoteSign3 = couponReturn.getQuoteSign();
        if (quoteSign2 != null ? !quoteSign2.equals(quoteSign3) : quoteSign3 != null) {
            return false;
        }
        if (getType() != couponReturn.getType() || getState() != couponReturn.getState()) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = couponReturn.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        if (getBeginTime() != couponReturn.getBeginTime() || getEndTime() != couponReturn.getEndTime()) {
            return false;
        }
        String businessType2 = getBusinessType();
        String businessType3 = couponReturn.getBusinessType();
        if (businessType2 != null ? !businessType2.equals(businessType3) : businessType3 != null) {
            return false;
        }
        if (getCouponId() != couponReturn.getCouponId()) {
            return false;
        }
        String rules2 = getRules();
        String rules3 = couponReturn.getRules();
        if (rules2 != null ? !rules2.equals(rules3) : rules3 != null) {
            return false;
        }
        if (getValidAt() != couponReturn.getValidAt()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = couponReturn.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String channel2 = getChannel();
        String channel3 = couponReturn.getChannel();
        if (channel2 != null ? !channel2.equals(channel3) : channel3 != null) {
            return false;
        }
        String meetCondition2 = getMeetCondition();
        String meetCondition3 = couponReturn.getMeetCondition();
        if (meetCondition2 != null ? !meetCondition2.equals(meetCondition3) : meetCondition3 != null) {
            return false;
        }
        Integer savingsEffectDays2 = getSavingsEffectDays();
        Integer savingsEffectDays3 = couponReturn.getSavingsEffectDays();
        if (savingsEffectDays2 != null ? savingsEffectDays2.equals(savingsEffectDays3) : savingsEffectDays3 == null) {
            return isSelected() == couponReturn.isSelected() && isShowNoThreshold() == couponReturn.isShowNoThreshold() && isExpanded() == couponReturn.isExpanded();
        }
        return false;
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

    public CouponReturnItem.b getCallback() {
        return this.callback;
    }

    public String getChannel() {
        return this.channel;
    }

    public long getCouponId() {
        return this.couponId;
    }

    public String getCouponSource() {
        String str = this.channel;
        return (str == null || "".equals(str)) ? "--" : this.channel;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public ExperienceItem.e getExCallback() {
        return this.exCallback;
    }

    public long getId() {
        return this.f43744id;
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

    public Integer getSavingsEffectDays() {
        return this.savingsEffectDays;
    }

    public int getState() {
        return this.state;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public long getValidAt() {
        return this.validAt;
    }

    public String getViewHandlerName() {
        if (this.type == 10) {
            return ExperienceHandler.class.getName();
        }
        return CouponReturnHandler.class.getName();
    }

    public int hashCode() {
        long id2 = getId();
        long activityId2 = getActivityId();
        int i11 = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) (activityId2 ^ (activityId2 >>> 32)));
        String baseCurrency2 = getBaseCurrency();
        int i12 = 43;
        int hashCode = (i11 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode2 = (hashCode * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String quoteSign2 = getQuoteSign();
        int hashCode3 = (((((hashCode2 * 59) + (quoteSign2 == null ? 43 : quoteSign2.hashCode())) * 59) + getType()) * 59) + getState();
        String amount2 = getAmount();
        int i13 = hashCode3 * 59;
        int hashCode4 = amount2 == null ? 43 : amount2.hashCode();
        long beginTime2 = getBeginTime();
        long endTime2 = getEndTime();
        int i14 = ((((i13 + hashCode4) * 59) + ((int) (beginTime2 ^ (beginTime2 >>> 32)))) * 59) + ((int) (endTime2 ^ (endTime2 >>> 32)));
        String businessType2 = getBusinessType();
        int i15 = i14 * 59;
        int hashCode5 = businessType2 == null ? 43 : businessType2.hashCode();
        long couponId2 = getCouponId();
        int i16 = ((i15 + hashCode5) * 59) + ((int) (couponId2 ^ (couponId2 >>> 32)));
        String rules2 = getRules();
        int i17 = i16 * 59;
        int hashCode6 = rules2 == null ? 43 : rules2.hashCode();
        long validAt2 = getValidAt();
        String title2 = getTitle();
        int hashCode7 = ((((i17 + hashCode6) * 59) + ((int) ((validAt2 >>> 32) ^ validAt2))) * 59) + (title2 == null ? 43 : title2.hashCode());
        String channel2 = getChannel();
        int hashCode8 = (hashCode7 * 59) + (channel2 == null ? 43 : channel2.hashCode());
        String meetCondition2 = getMeetCondition();
        int hashCode9 = (hashCode8 * 59) + (meetCondition2 == null ? 43 : meetCondition2.hashCode());
        Integer savingsEffectDays2 = getSavingsEffectDays();
        int i18 = hashCode9 * 59;
        if (savingsEffectDays2 != null) {
            i12 = savingsEffectDays2.hashCode();
        }
        int i19 = 79;
        int i21 = (((((i18 + i12) * 59) + (isSelected() ? 79 : 97)) * 59) + (isShowNoThreshold() ? 79 : 97)) * 59;
        if (!isExpanded()) {
            i19 = 97;
        }
        return i21 + i19;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public boolean isShowNoThreshold() {
        return this.showNoThreshold;
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

    public void setCallback(CouponReturnItem.b bVar) {
        this.callback = bVar;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setCouponId(long j11) {
        this.couponId = j11;
    }

    public void setEndTime(long j11) {
        this.endTime = j11;
    }

    public void setExCallback(ExperienceItem.e eVar) {
        this.exCallback = eVar;
    }

    public void setExpanded(boolean z11) {
        this.expanded = z11;
    }

    public void setId(long j11) {
        this.f43744id = j11;
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

    public void setSavingsEffectDays(Integer num) {
        this.savingsEffectDays = num;
    }

    public void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public void setShowNoThreshold(boolean z11) {
        this.showNoThreshold = z11;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setValidAt(long j11) {
        this.validAt = j11;
    }

    public String toString() {
        return "CouponReturn(id=" + getId() + ", activityId=" + getActivityId() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", quoteSign=" + getQuoteSign() + ", type=" + getType() + ", state=" + getState() + ", amount=" + getAmount() + ", beginTime=" + getBeginTime() + ", endTime=" + getEndTime() + ", businessType=" + getBusinessType() + ", couponId=" + getCouponId() + ", rules=" + getRules() + ", validAt=" + getValidAt() + ", title=" + getTitle() + ", channel=" + getChannel() + ", meetCondition=" + getMeetCondition() + ", savingsEffectDays=" + getSavingsEffectDays() + ", callback=" + getCallback() + ", exCallback=" + getExCallback() + ", isSelected=" + isSelected() + ", showNoThreshold=" + isShowNoThreshold() + ", expanded=" + isExpanded() + ")";
    }
}
