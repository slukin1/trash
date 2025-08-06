package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CusMsgGiftRecall implements Parcelable {
    public static final Parcelable.Creator<CusMsgGiftRecall> CREATOR = new Creator();

    /* renamed from: id  reason: collision with root package name */
    private String f19719id;

    public static final class Creator implements Parcelable.Creator<CusMsgGiftRecall> {
        /* renamed from: a */
        public final CusMsgGiftRecall createFromParcel(Parcel parcel) {
            return new CusMsgGiftRecall(parcel.readString());
        }

        /* renamed from: b */
        public final CusMsgGiftRecall[] newArray(int i11) {
            return new CusMsgGiftRecall[i11];
        }
    }

    public CusMsgGiftRecall() {
        this((String) null, 1, (r) null);
    }

    public CusMsgGiftRecall(String str) {
        this.f19719id = str;
    }

    public static /* synthetic */ CusMsgGiftRecall copy$default(CusMsgGiftRecall cusMsgGiftRecall, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cusMsgGiftRecall.f19719id;
        }
        return cusMsgGiftRecall.copy(str);
    }

    public final String component1() {
        return this.f19719id;
    }

    public final CusMsgGiftRecall copy(String str) {
        return new CusMsgGiftRecall(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CusMsgGiftRecall) && x.b(this.f19719id, ((CusMsgGiftRecall) obj).f19719id);
    }

    public final String getId() {
        return this.f19719id;
    }

    public int hashCode() {
        String str = this.f19719id;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setId(String str) {
        this.f19719id = str;
    }

    public String toString() {
        return "CusMsgGiftRecall(id=" + this.f19719id + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f19719id);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CusMsgGiftRecall(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str);
    }
}
