package com.hbg.lib.network.otc.core.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class OtcPaymentRecommendInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<OtcPaymentRecommendInfo> CREATOR = new a();
    private String bankImage;
    private String bankImageActive;
    private String bankImageInactive;
    private String color;
    private boolean isEnd;
    private String name;
    private int payMethodId;

    public class a implements Parcelable.Creator<OtcPaymentRecommendInfo> {
        /* renamed from: a */
        public OtcPaymentRecommendInfo createFromParcel(Parcel parcel) {
            return new OtcPaymentRecommendInfo(parcel);
        }

        /* renamed from: b */
        public OtcPaymentRecommendInfo[] newArray(int i11) {
            return new OtcPaymentRecommendInfo[i11];
        }
    }

    public OtcPaymentRecommendInfo() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcPaymentRecommendInfo;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcPaymentRecommendInfo)) {
            return false;
        }
        OtcPaymentRecommendInfo otcPaymentRecommendInfo = (OtcPaymentRecommendInfo) obj;
        if (!otcPaymentRecommendInfo.canEqual(this) || getPayMethodId() != otcPaymentRecommendInfo.getPayMethodId()) {
            return false;
        }
        String name2 = getName();
        String name3 = otcPaymentRecommendInfo.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String bankImage2 = getBankImage();
        String bankImage3 = otcPaymentRecommendInfo.getBankImage();
        if (bankImage2 != null ? !bankImage2.equals(bankImage3) : bankImage3 != null) {
            return false;
        }
        String bankImageActive2 = getBankImageActive();
        String bankImageActive3 = otcPaymentRecommendInfo.getBankImageActive();
        if (bankImageActive2 != null ? !bankImageActive2.equals(bankImageActive3) : bankImageActive3 != null) {
            return false;
        }
        String bankImageInactive2 = getBankImageInactive();
        String bankImageInactive3 = otcPaymentRecommendInfo.getBankImageInactive();
        if (bankImageInactive2 != null ? !bankImageInactive2.equals(bankImageInactive3) : bankImageInactive3 != null) {
            return false;
        }
        String color2 = getColor();
        String color3 = otcPaymentRecommendInfo.getColor();
        if (color2 != null ? color2.equals(color3) : color3 == null) {
            return isEnd() == otcPaymentRecommendInfo.isEnd();
        }
        return false;
    }

    public String getBankImage() {
        return this.bankImage;
    }

    public String getBankImageActive() {
        return this.bankImageActive;
    }

    public String getBankImageInactive() {
        return this.bankImageInactive;
    }

    public String getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public int getPayMethodId() {
        return this.payMethodId;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int payMethodId2 = ((getPayMethodId() + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
        String bankImage2 = getBankImage();
        int hashCode = (payMethodId2 * 59) + (bankImage2 == null ? 43 : bankImage2.hashCode());
        String bankImageActive2 = getBankImageActive();
        int hashCode2 = (hashCode * 59) + (bankImageActive2 == null ? 43 : bankImageActive2.hashCode());
        String bankImageInactive2 = getBankImageInactive();
        int hashCode3 = (hashCode2 * 59) + (bankImageInactive2 == null ? 43 : bankImageInactive2.hashCode());
        String color2 = getColor();
        int i12 = hashCode3 * 59;
        if (color2 != null) {
            i11 = color2.hashCode();
        }
        return ((i12 + i11) * 59) + (isEnd() ? 79 : 97);
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void setBankImage(String str) {
        this.bankImage = str;
    }

    public void setBankImageActive(String str) {
        this.bankImageActive = str;
    }

    public void setBankImageInactive(String str) {
        this.bankImageInactive = str;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setEnd(boolean z11) {
        this.isEnd = z11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPayMethodId(int i11) {
        this.payMethodId = i11;
    }

    public String toString() {
        return "OtcPaymentRecommendInfo(payMethodId=" + getPayMethodId() + ", name=" + getName() + ", bankImage=" + getBankImage() + ", bankImageActive=" + getBankImageActive() + ", bankImageInactive=" + getBankImageInactive() + ", color=" + getColor() + ", isEnd=" + isEnd() + ")";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.payMethodId);
        parcel.writeString(this.name);
        parcel.writeString(this.bankImage);
        parcel.writeString(this.bankImageActive);
        parcel.writeString(this.bankImageInactive);
        parcel.writeString(this.color);
    }

    public OtcPaymentRecommendInfo(Parcel parcel) {
        this.payMethodId = parcel.readInt();
        this.name = parcel.readString();
        this.bankImage = parcel.readString();
        this.bankImageActive = parcel.readString();
        this.bankImageInactive = parcel.readString();
        this.color = parcel.readString();
    }
}
