package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CusMsgGiftVerify implements Parcelable {
    public static final Parcelable.Creator<CusMsgGiftVerify> CREATOR = new Creator();

    /* renamed from: id  reason: collision with root package name */
    private String f19721id;
    private String verifyCode;

    public static final class Creator implements Parcelable.Creator<CusMsgGiftVerify> {
        /* renamed from: a */
        public final CusMsgGiftVerify createFromParcel(Parcel parcel) {
            return new CusMsgGiftVerify(parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final CusMsgGiftVerify[] newArray(int i11) {
            return new CusMsgGiftVerify[i11];
        }
    }

    public CusMsgGiftVerify() {
        this((String) null, (String) null, 3, (r) null);
    }

    public CusMsgGiftVerify(String str, String str2) {
        this.f19721id = str;
        this.verifyCode = str2;
    }

    public static /* synthetic */ CusMsgGiftVerify copy$default(CusMsgGiftVerify cusMsgGiftVerify, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cusMsgGiftVerify.f19721id;
        }
        if ((i11 & 2) != 0) {
            str2 = cusMsgGiftVerify.verifyCode;
        }
        return cusMsgGiftVerify.copy(str, str2);
    }

    public final String component1() {
        return this.f19721id;
    }

    public final String component2() {
        return this.verifyCode;
    }

    public final CusMsgGiftVerify copy(String str, String str2) {
        return new CusMsgGiftVerify(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CusMsgGiftVerify)) {
            return false;
        }
        CusMsgGiftVerify cusMsgGiftVerify = (CusMsgGiftVerify) obj;
        return x.b(this.f19721id, cusMsgGiftVerify.f19721id) && x.b(this.verifyCode, cusMsgGiftVerify.verifyCode);
    }

    public final String getId() {
        return this.f19721id;
    }

    public final String getVerifyCode() {
        return this.verifyCode;
    }

    public int hashCode() {
        String str = this.f19721id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.verifyCode;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setId(String str) {
        this.f19721id = str;
    }

    public final void setVerifyCode(String str) {
        this.verifyCode = str;
    }

    public String toString() {
        return "CusMsgGiftVerify(id=" + this.f19721id + ", verifyCode=" + this.verifyCode + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f19721id);
        parcel.writeString(this.verifyCode);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CusMsgGiftVerify(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
