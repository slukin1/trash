package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CusMsgGiftEnd implements Parcelable {
    public static final Parcelable.Creator<CusMsgGiftEnd> CREATOR = new Creator();

    /* renamed from: id  reason: collision with root package name */
    private String f19718id;

    public static final class Creator implements Parcelable.Creator<CusMsgGiftEnd> {
        /* renamed from: a */
        public final CusMsgGiftEnd createFromParcel(Parcel parcel) {
            return new CusMsgGiftEnd(parcel.readString());
        }

        /* renamed from: b */
        public final CusMsgGiftEnd[] newArray(int i11) {
            return new CusMsgGiftEnd[i11];
        }
    }

    public CusMsgGiftEnd() {
        this((String) null, 1, (r) null);
    }

    public CusMsgGiftEnd(String str) {
        this.f19718id = str;
    }

    public static /* synthetic */ CusMsgGiftEnd copy$default(CusMsgGiftEnd cusMsgGiftEnd, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cusMsgGiftEnd.f19718id;
        }
        return cusMsgGiftEnd.copy(str);
    }

    public final String component1() {
        return this.f19718id;
    }

    public final CusMsgGiftEnd copy(String str) {
        return new CusMsgGiftEnd(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CusMsgGiftEnd) && x.b(this.f19718id, ((CusMsgGiftEnd) obj).f19718id);
    }

    public final String getId() {
        return this.f19718id;
    }

    public int hashCode() {
        String str = this.f19718id;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setId(String str) {
        this.f19718id = str;
    }

    public String toString() {
        return "CusMsgGiftEnd(id=" + this.f19718id + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f19718id);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CusMsgGiftEnd(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str);
    }
}
