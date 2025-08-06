package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.x;

public final class JackpotBean implements Parcelable {
    public static final Parcelable.Creator<JackpotBean> CREATOR = new Creator();
    private String awardId;
    private String count;
    private String desc;
    private String properties;
    private Property property;
    private int type;

    public static final class Creator implements Parcelable.Creator<JackpotBean> {
        /* renamed from: a */
        public final JackpotBean createFromParcel(Parcel parcel) {
            return new JackpotBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), Property.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final JackpotBean[] newArray(int i11) {
            return new JackpotBean[i11];
        }
    }

    public JackpotBean(String str, String str2, String str3, int i11, String str4, Property property2) {
        this.awardId = str;
        this.desc = str2;
        this.count = str3;
        this.type = i11;
        this.properties = str4;
        this.property = property2;
    }

    public static /* synthetic */ JackpotBean copy$default(JackpotBean jackpotBean, String str, String str2, String str3, int i11, String str4, Property property2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = jackpotBean.awardId;
        }
        if ((i12 & 2) != 0) {
            str2 = jackpotBean.desc;
        }
        String str5 = str2;
        if ((i12 & 4) != 0) {
            str3 = jackpotBean.count;
        }
        String str6 = str3;
        if ((i12 & 8) != 0) {
            i11 = jackpotBean.type;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            str4 = jackpotBean.properties;
        }
        String str7 = str4;
        if ((i12 & 32) != 0) {
            property2 = jackpotBean.property;
        }
        return jackpotBean.copy(str, str5, str6, i13, str7, property2);
    }

    public final String component1() {
        return this.awardId;
    }

    public final String component2() {
        return this.desc;
    }

    public final String component3() {
        return this.count;
    }

    public final int component4() {
        return this.type;
    }

    public final String component5() {
        return this.properties;
    }

    public final Property component6() {
        return this.property;
    }

    public final JackpotBean copy(String str, String str2, String str3, int i11, String str4, Property property2) {
        return new JackpotBean(str, str2, str3, i11, str4, property2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JackpotBean)) {
            return false;
        }
        JackpotBean jackpotBean = (JackpotBean) obj;
        return x.b(this.awardId, jackpotBean.awardId) && x.b(this.desc, jackpotBean.desc) && x.b(this.count, jackpotBean.count) && this.type == jackpotBean.type && x.b(this.properties, jackpotBean.properties) && x.b(this.property, jackpotBean.property);
    }

    public final String getAwardId() {
        return this.awardId;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getProperties() {
        return this.properties;
    }

    public final Property getProperty() {
        return this.property;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((this.awardId.hashCode() * 31) + this.desc.hashCode()) * 31) + this.count.hashCode()) * 31) + this.type) * 31) + this.properties.hashCode()) * 31) + this.property.hashCode();
    }

    public final void setAwardId(String str) {
        this.awardId = str;
    }

    public final void setCount(String str) {
        this.count = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setProperties(String str) {
        this.properties = str;
    }

    public final void setProperty(Property property2) {
        this.property = property2;
    }

    public final void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "JackpotBean(awardId=" + this.awardId + ", desc=" + this.desc + ", count=" + this.count + ", type=" + this.type + ", properties=" + this.properties + ", property=" + this.property + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.awardId);
        parcel.writeString(this.desc);
        parcel.writeString(this.count);
        parcel.writeInt(this.type);
        parcel.writeString(this.properties);
        this.property.writeToParcel(parcel, i11);
    }
}
