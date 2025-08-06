package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class Prize implements Parcelable {
    public static final Parcelable.Creator<Prize> CREATOR = new Creator();
    private String detail;
    private String prizeUrl;

    public static final class Creator implements Parcelable.Creator<Prize> {
        /* renamed from: a */
        public final Prize createFromParcel(Parcel parcel) {
            return new Prize(parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final Prize[] newArray(int i11) {
            return new Prize[i11];
        }
    }

    public Prize() {
        this((String) null, (String) null, 3, (r) null);
    }

    public Prize(String str, String str2) {
        this.detail = str;
        this.prizeUrl = str2;
    }

    public static /* synthetic */ Prize copy$default(Prize prize, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = prize.detail;
        }
        if ((i11 & 2) != 0) {
            str2 = prize.prizeUrl;
        }
        return prize.copy(str, str2);
    }

    public final String component1() {
        return this.detail;
    }

    public final String component2() {
        return this.prizeUrl;
    }

    public final Prize copy(String str, String str2) {
        return new Prize(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Prize)) {
            return false;
        }
        Prize prize = (Prize) obj;
        return x.b(this.detail, prize.detail) && x.b(this.prizeUrl, prize.prizeUrl);
    }

    public final String getDetail() {
        return this.detail;
    }

    public final String getPrizeUrl() {
        return this.prizeUrl;
    }

    public int hashCode() {
        String str = this.detail;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.prizeUrl;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setDetail(String str) {
        this.detail = str;
    }

    public final void setPrizeUrl(String str) {
        this.prizeUrl = str;
    }

    public String toString() {
        return "Prize(detail=" + this.detail + ", prizeUrl=" + this.prizeUrl + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.detail);
        parcel.writeString(this.prizeUrl);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Prize(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
