package com.huobi.trade.prime.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class PrimeUserLimit implements Parcelable {
    public static final Parcelable.Creator<PrimeUserLimit> CREATOR = new a();
    private String amount;

    public class a implements Parcelable.Creator<PrimeUserLimit> {
        /* renamed from: a */
        public PrimeUserLimit createFromParcel(Parcel parcel) {
            return new PrimeUserLimit(parcel);
        }

        /* renamed from: b */
        public PrimeUserLimit[] newArray(int i11) {
            return new PrimeUserLimit[i11];
        }
    }

    public PrimeUserLimit() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PrimeUserLimit;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrimeUserLimit)) {
            return false;
        }
        PrimeUserLimit primeUserLimit = (PrimeUserLimit) obj;
        if (!primeUserLimit.canEqual(this)) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = primeUserLimit.getAmount();
        return amount2 != null ? amount2.equals(amount3) : amount3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public int hashCode() {
        String amount2 = getAmount();
        return 59 + (amount2 == null ? 43 : amount2.hashCode());
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String toString() {
        return "PrimeUserLimit(amount=" + getAmount() + ")";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.amount);
    }

    public PrimeUserLimit(Parcel parcel) {
        this.amount = parcel.readString();
    }
}
