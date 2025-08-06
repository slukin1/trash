package com.hbg.module.libkt.utils.event.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class Financial implements Parcelable {
    public static final Parcelable.Creator<Financial> CREATOR = new Creator();
    private double balance;
    private String currency;
    private String type;

    public static final class Creator implements Parcelable.Creator<Financial> {
        /* renamed from: a */
        public final Financial createFromParcel(Parcel parcel) {
            return new Financial(parcel.readString(), parcel.readString(), parcel.readDouble());
        }

        /* renamed from: b */
        public final Financial[] newArray(int i11) {
            return new Financial[i11];
        }
    }

    public Financial(String str, String str2, double d11) {
        this.currency = str;
        this.type = str2;
        this.balance = d11;
    }

    public static /* synthetic */ Financial copy$default(Financial financial, String str, String str2, double d11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = financial.currency;
        }
        if ((i11 & 2) != 0) {
            str2 = financial.type;
        }
        if ((i11 & 4) != 0) {
            d11 = financial.balance;
        }
        return financial.copy(str, str2, d11);
    }

    public final String component1() {
        return this.currency;
    }

    public final String component2() {
        return this.type;
    }

    public final double component3() {
        return this.balance;
    }

    public final Financial copy(String str, String str2, double d11) {
        return new Financial(str, str2, d11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Financial)) {
            return false;
        }
        Financial financial = (Financial) obj;
        return x.b(this.currency, financial.currency) && x.b(this.type, financial.type) && Double.compare(this.balance, financial.balance) == 0;
    }

    public final double getBalance() {
        return this.balance;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.currency.hashCode() * 31;
        String str = this.type;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.doubleToLongBits(this.balance);
    }

    public final void setBalance(double d11) {
        this.balance = d11;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "Financial(currency=" + this.currency + ", type=" + this.type + ", balance=" + this.balance + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.currency);
        parcel.writeString(this.type);
        parcel.writeDouble(this.balance);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Financial(String str, String str2, double d11, int i11, r rVar) {
        this(str, str2, (i11 & 4) != 0 ? 0.0d : d11);
    }
}
