package com.huobi.trade.prime.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class PrimeAveragePositionInfo implements Parcelable {
    public static final Parcelable.Creator<PrimeAveragePositionInfo> CREATOR = new a();
    private int amount;
    private String date;

    public class a implements Parcelable.Creator<PrimeAveragePositionInfo> {
        /* renamed from: a */
        public PrimeAveragePositionInfo createFromParcel(Parcel parcel) {
            return new PrimeAveragePositionInfo(parcel);
        }

        /* renamed from: b */
        public PrimeAveragePositionInfo[] newArray(int i11) {
            return new PrimeAveragePositionInfo[i11];
        }
    }

    public PrimeAveragePositionInfo() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeAveragePositionInfo;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeAveragePositionInfo)) {
            return false;
        }
        PrimeAveragePositionInfo primeAveragePositionInfo = (PrimeAveragePositionInfo) obj;
        if (!primeAveragePositionInfo.canEqual(this)) {
            return false;
        }
        String date2 = getDate();
        String date3 = primeAveragePositionInfo.getDate();
        if (date2 != null ? date2.equals(date3) : date3 == null) {
            return getAmount() == primeAveragePositionInfo.getAmount();
        }
        return false;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getDate() {
        return this.date;
    }

    public int hashCode() {
        String date2 = getDate();
        return (((date2 == null ? 43 : date2.hashCode()) + 59) * 59) + getAmount();
    }

    public void setAmount(int i11) {
        this.amount = i11;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String toString() {
        return "PrimeAveragePositionInfo(date=" + getDate() + ", amount=" + getAmount() + ")";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.date);
        parcel.writeInt(this.amount);
    }

    public PrimeAveragePositionInfo(Parcel parcel) {
        this.date = parcel.readString();
        this.amount = parcel.readInt();
    }
}
