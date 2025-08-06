package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.x;

public final class Property implements Parcelable {
    public static final Parcelable.Creator<Property> CREATOR = new Creator();
    private String albumId;
    private String amount;
    private String currency;
    private String expiryDate;
    private String gid;
    private Integer gradeUpper;

    /* renamed from: id  reason: collision with root package name */
    private String f19722id;
    private String meetCondition;
    private String memberExperienceTime;
    private String membershipGrade;
    private String name;
    private String rarity;
    private String rate;
    private String rateCycle;
    private String savingsUpper;
    private String title;
    private Integer type;
    private String url;
    private String use;
    private String validAt;
    private String value;
    private String voucherBatchId;

    public static final class Creator implements Parcelable.Creator<Property> {
        /* renamed from: a */
        public final Property createFromParcel(Parcel parcel) {
            return new Property(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* renamed from: b */
        public final Property[] newArray(int i11) {
            return new Property[i11];
        }
    }

    public Property(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Integer num2) {
        this.currency = str;
        this.voucherBatchId = str2;
        this.value = str3;
        this.f19722id = str4;
        this.type = num;
        this.rate = str5;
        this.rateCycle = str6;
        this.expiryDate = str7;
        this.use = str8;
        this.title = str9;
        this.albumId = str10;
        this.name = str11;
        this.url = str12;
        this.rarity = str13;
        this.gid = str14;
        this.amount = str15;
        this.validAt = str16;
        this.savingsUpper = str17;
        this.meetCondition = str18;
        this.memberExperienceTime = str19;
        this.membershipGrade = str20;
        this.gradeUpper = num2;
    }

    public static /* synthetic */ Property copy$default(Property property, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Integer num2, int i11, Object obj) {
        Property property2 = property;
        int i12 = i11;
        return property.copy((i12 & 1) != 0 ? property2.currency : str, (i12 & 2) != 0 ? property2.voucherBatchId : str2, (i12 & 4) != 0 ? property2.value : str3, (i12 & 8) != 0 ? property2.f19722id : str4, (i12 & 16) != 0 ? property2.type : num, (i12 & 32) != 0 ? property2.rate : str5, (i12 & 64) != 0 ? property2.rateCycle : str6, (i12 & 128) != 0 ? property2.expiryDate : str7, (i12 & 256) != 0 ? property2.use : str8, (i12 & 512) != 0 ? property2.title : str9, (i12 & 1024) != 0 ? property2.albumId : str10, (i12 & 2048) != 0 ? property2.name : str11, (i12 & 4096) != 0 ? property2.url : str12, (i12 & 8192) != 0 ? property2.rarity : str13, (i12 & 16384) != 0 ? property2.gid : str14, (i12 & 32768) != 0 ? property2.amount : str15, (i12 & 65536) != 0 ? property2.validAt : str16, (i12 & 131072) != 0 ? property2.savingsUpper : str17, (i12 & 262144) != 0 ? property2.meetCondition : str18, (i12 & 524288) != 0 ? property2.memberExperienceTime : str19, (i12 & 1048576) != 0 ? property2.membershipGrade : str20, (i12 & 2097152) != 0 ? property2.gradeUpper : num2);
    }

    public final String component1() {
        return this.currency;
    }

    public final String component10() {
        return this.title;
    }

    public final String component11() {
        return this.albumId;
    }

    public final String component12() {
        return this.name;
    }

    public final String component13() {
        return this.url;
    }

    public final String component14() {
        return this.rarity;
    }

    public final String component15() {
        return this.gid;
    }

    public final String component16() {
        return this.amount;
    }

    public final String component17() {
        return this.validAt;
    }

    public final String component18() {
        return this.savingsUpper;
    }

    public final String component19() {
        return this.meetCondition;
    }

    public final String component2() {
        return this.voucherBatchId;
    }

    public final String component20() {
        return this.memberExperienceTime;
    }

    public final String component21() {
        return this.membershipGrade;
    }

    public final Integer component22() {
        return this.gradeUpper;
    }

    public final String component3() {
        return this.value;
    }

    public final String component4() {
        return this.f19722id;
    }

    public final Integer component5() {
        return this.type;
    }

    public final String component6() {
        return this.rate;
    }

    public final String component7() {
        return this.rateCycle;
    }

    public final String component8() {
        return this.expiryDate;
    }

    public final String component9() {
        return this.use;
    }

    public final Property copy(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Integer num2) {
        return new Property(str, str2, str3, str4, num, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, num2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Property)) {
            return false;
        }
        Property property = (Property) obj;
        return x.b(this.currency, property.currency) && x.b(this.voucherBatchId, property.voucherBatchId) && x.b(this.value, property.value) && x.b(this.f19722id, property.f19722id) && x.b(this.type, property.type) && x.b(this.rate, property.rate) && x.b(this.rateCycle, property.rateCycle) && x.b(this.expiryDate, property.expiryDate) && x.b(this.use, property.use) && x.b(this.title, property.title) && x.b(this.albumId, property.albumId) && x.b(this.name, property.name) && x.b(this.url, property.url) && x.b(this.rarity, property.rarity) && x.b(this.gid, property.gid) && x.b(this.amount, property.amount) && x.b(this.validAt, property.validAt) && x.b(this.savingsUpper, property.savingsUpper) && x.b(this.meetCondition, property.meetCondition) && x.b(this.memberExperienceTime, property.memberExperienceTime) && x.b(this.membershipGrade, property.membershipGrade) && x.b(this.gradeUpper, property.gradeUpper);
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getExpiryDate() {
        return this.expiryDate;
    }

    public final String getGid() {
        return this.gid;
    }

    public final Integer getGradeUpper() {
        return this.gradeUpper;
    }

    public final String getId() {
        return this.f19722id;
    }

    public final String getMeetCondition() {
        return this.meetCondition;
    }

    public final String getMemberExperienceTime() {
        return this.memberExperienceTime;
    }

    public final String getMembershipGrade() {
        return this.membershipGrade;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRarity() {
        return this.rarity;
    }

    public final String getRate() {
        return this.rate;
    }

    public final String getRateCycle() {
        return this.rateCycle;
    }

    public final String getSavingsUpper() {
        return this.savingsUpper;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUse() {
        return this.use;
    }

    public final String getValidAt() {
        return this.validAt;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getVoucherBatchId() {
        return this.voucherBatchId;
    }

    public int hashCode() {
        String str = this.currency;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.voucherBatchId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.value;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f19722id;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.type;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.rate;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.rateCycle;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.expiryDate;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.use;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.title;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.albumId;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.name;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.url;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.rarity;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.gid;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.amount;
        int hashCode16 = (hashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.validAt;
        int hashCode17 = (hashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.savingsUpper;
        int hashCode18 = (hashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.meetCondition;
        int hashCode19 = (hashCode18 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.memberExperienceTime;
        int hashCode20 = (hashCode19 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.membershipGrade;
        int hashCode21 = (hashCode20 + (str20 == null ? 0 : str20.hashCode())) * 31;
        Integer num2 = this.gradeUpper;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode21 + i11;
    }

    public final void setAlbumId(String str) {
        this.albumId = str;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setExpiryDate(String str) {
        this.expiryDate = str;
    }

    public final void setGid(String str) {
        this.gid = str;
    }

    public final void setGradeUpper(Integer num) {
        this.gradeUpper = num;
    }

    public final void setId(String str) {
        this.f19722id = str;
    }

    public final void setMeetCondition(String str) {
        this.meetCondition = str;
    }

    public final void setMemberExperienceTime(String str) {
        this.memberExperienceTime = str;
    }

    public final void setMembershipGrade(String str) {
        this.membershipGrade = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setRarity(String str) {
        this.rarity = str;
    }

    public final void setRate(String str) {
        this.rate = str;
    }

    public final void setRateCycle(String str) {
        this.rateCycle = str;
    }

    public final void setSavingsUpper(String str) {
        this.savingsUpper = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void setUse(String str) {
        this.use = str;
    }

    public final void setValidAt(String str) {
        this.validAt = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final void setVoucherBatchId(String str) {
        this.voucherBatchId = str;
    }

    public String toString() {
        return "Property(currency=" + this.currency + ", voucherBatchId=" + this.voucherBatchId + ", value=" + this.value + ", id=" + this.f19722id + ", type=" + this.type + ", rate=" + this.rate + ", rateCycle=" + this.rateCycle + ", expiryDate=" + this.expiryDate + ", use=" + this.use + ", title=" + this.title + ", albumId=" + this.albumId + ", name=" + this.name + ", url=" + this.url + ", rarity=" + this.rarity + ", gid=" + this.gid + ", amount=" + this.amount + ", validAt=" + this.validAt + ", savingsUpper=" + this.savingsUpper + ", meetCondition=" + this.meetCondition + ", memberExperienceTime=" + this.memberExperienceTime + ", membershipGrade=" + this.membershipGrade + ", gradeUpper=" + this.gradeUpper + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.currency);
        parcel.writeString(this.voucherBatchId);
        parcel.writeString(this.value);
        parcel.writeString(this.f19722id);
        Integer num = this.type;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.rate);
        parcel.writeString(this.rateCycle);
        parcel.writeString(this.expiryDate);
        parcel.writeString(this.use);
        parcel.writeString(this.title);
        parcel.writeString(this.albumId);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.rarity);
        parcel.writeString(this.gid);
        parcel.writeString(this.amount);
        parcel.writeString(this.validAt);
        parcel.writeString(this.savingsUpper);
        parcel.writeString(this.meetCondition);
        parcel.writeString(this.memberExperienceTime);
        parcel.writeString(this.membershipGrade);
        Integer num2 = this.gradeUpper;
        if (num2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num2.intValue());
    }
}
