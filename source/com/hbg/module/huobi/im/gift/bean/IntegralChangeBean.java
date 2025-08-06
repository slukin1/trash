package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.x;

public final class IntegralChangeBean implements Parcelable {
    public static final Parcelable.Creator<IntegralChangeBean> CREATOR = new Creator();
    private ArrayList<String> accounts;
    private Integer allIntegral;
    private Integer integral;
    private String integralUrl;
    private Integer type;
    private Integer unlockIntegral;

    public static final class Creator implements Parcelable.Creator<IntegralChangeBean> {
        /* renamed from: a */
        public final IntegralChangeBean createFromParcel(Parcel parcel) {
            return new IntegralChangeBean(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.createStringArrayList(), parcel.readString());
        }

        /* renamed from: b */
        public final IntegralChangeBean[] newArray(int i11) {
            return new IntegralChangeBean[i11];
        }
    }

    public IntegralChangeBean(Integer num, Integer num2, Integer num3, Integer num4, ArrayList<String> arrayList, String str) {
        this.type = num;
        this.integral = num2;
        this.allIntegral = num3;
        this.unlockIntegral = num4;
        this.accounts = arrayList;
        this.integralUrl = str;
    }

    public static /* synthetic */ IntegralChangeBean copy$default(IntegralChangeBean integralChangeBean, Integer num, Integer num2, Integer num3, Integer num4, ArrayList<String> arrayList, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = integralChangeBean.type;
        }
        if ((i11 & 2) != 0) {
            num2 = integralChangeBean.integral;
        }
        Integer num5 = num2;
        if ((i11 & 4) != 0) {
            num3 = integralChangeBean.allIntegral;
        }
        Integer num6 = num3;
        if ((i11 & 8) != 0) {
            num4 = integralChangeBean.unlockIntegral;
        }
        Integer num7 = num4;
        if ((i11 & 16) != 0) {
            arrayList = integralChangeBean.accounts;
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((i11 & 32) != 0) {
            str = integralChangeBean.integralUrl;
        }
        return integralChangeBean.copy(num, num5, num6, num7, arrayList2, str);
    }

    public final Integer component1() {
        return this.type;
    }

    public final Integer component2() {
        return this.integral;
    }

    public final Integer component3() {
        return this.allIntegral;
    }

    public final Integer component4() {
        return this.unlockIntegral;
    }

    public final ArrayList<String> component5() {
        return this.accounts;
    }

    public final String component6() {
        return this.integralUrl;
    }

    public final IntegralChangeBean copy(Integer num, Integer num2, Integer num3, Integer num4, ArrayList<String> arrayList, String str) {
        return new IntegralChangeBean(num, num2, num3, num4, arrayList, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntegralChangeBean)) {
            return false;
        }
        IntegralChangeBean integralChangeBean = (IntegralChangeBean) obj;
        return x.b(this.type, integralChangeBean.type) && x.b(this.integral, integralChangeBean.integral) && x.b(this.allIntegral, integralChangeBean.allIntegral) && x.b(this.unlockIntegral, integralChangeBean.unlockIntegral) && x.b(this.accounts, integralChangeBean.accounts) && x.b(this.integralUrl, integralChangeBean.integralUrl);
    }

    public final ArrayList<String> getAccounts() {
        return this.accounts;
    }

    public final Integer getAllIntegral() {
        return this.allIntegral;
    }

    public final Integer getIntegral() {
        return this.integral;
    }

    public final String getIntegralUrl() {
        return this.integralUrl;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Integer getUnlockIntegral() {
        return this.unlockIntegral;
    }

    public int hashCode() {
        Integer num = this.type;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.integral;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.allIntegral;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.unlockIntegral;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        ArrayList<String> arrayList = this.accounts;
        int hashCode5 = (hashCode4 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str = this.integralUrl;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode5 + i11;
    }

    public final void setAccounts(ArrayList<String> arrayList) {
        this.accounts = arrayList;
    }

    public final void setAllIntegral(Integer num) {
        this.allIntegral = num;
    }

    public final void setIntegral(Integer num) {
        this.integral = num;
    }

    public final void setIntegralUrl(String str) {
        this.integralUrl = str;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final void setUnlockIntegral(Integer num) {
        this.unlockIntegral = num;
    }

    public String toString() {
        return "IntegralChangeBean(type=" + this.type + ", integral=" + this.integral + ", allIntegral=" + this.allIntegral + ", unlockIntegral=" + this.unlockIntegral + ", accounts=" + this.accounts + ", integralUrl=" + this.integralUrl + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        Integer num = this.type;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.integral;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.allIntegral;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.unlockIntegral;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        parcel.writeStringList(this.accounts);
        parcel.writeString(this.integralUrl);
    }
}
