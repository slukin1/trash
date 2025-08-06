package com.hbg.module.libkt.utils.event.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class GiftPanelInfo implements Parcelable {
    public static final Parcelable.Creator<GiftPanelInfo> CREATOR = new Creator();
    private int code;
    private GiftDataInfo data;
    private String message;

    public static final class Creator implements Parcelable.Creator<GiftPanelInfo> {
        /* renamed from: a */
        public final GiftPanelInfo createFromParcel(Parcel parcel) {
            return new GiftPanelInfo(parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : GiftDataInfo.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final GiftPanelInfo[] newArray(int i11) {
            return new GiftPanelInfo[i11];
        }
    }

    public GiftPanelInfo(int i11, String str, GiftDataInfo giftDataInfo) {
        this.code = i11;
        this.message = str;
        this.data = giftDataInfo;
    }

    public static /* synthetic */ GiftPanelInfo copy$default(GiftPanelInfo giftPanelInfo, int i11, String str, GiftDataInfo giftDataInfo, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = giftPanelInfo.code;
        }
        if ((i12 & 2) != 0) {
            str = giftPanelInfo.message;
        }
        if ((i12 & 4) != 0) {
            giftDataInfo = giftPanelInfo.data;
        }
        return giftPanelInfo.copy(i11, str, giftDataInfo);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final GiftDataInfo component3() {
        return this.data;
    }

    public final GiftPanelInfo copy(int i11, String str, GiftDataInfo giftDataInfo) {
        return new GiftPanelInfo(i11, str, giftDataInfo);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftPanelInfo)) {
            return false;
        }
        GiftPanelInfo giftPanelInfo = (GiftPanelInfo) obj;
        return this.code == giftPanelInfo.code && x.b(this.message, giftPanelInfo.message) && x.b(this.data, giftPanelInfo.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final GiftDataInfo getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int hashCode = ((this.code * 31) + this.message.hashCode()) * 31;
        GiftDataInfo giftDataInfo = this.data;
        return hashCode + (giftDataInfo == null ? 0 : giftDataInfo.hashCode());
    }

    public final void setCode(int i11) {
        this.code = i11;
    }

    public final void setData(GiftDataInfo giftDataInfo) {
        this.data = giftDataInfo;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "GiftPanelInfo(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        GiftDataInfo giftDataInfo = this.data;
        if (giftDataInfo == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        giftDataInfo.writeToParcel(parcel, i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GiftPanelInfo(int i11, String str, GiftDataInfo giftDataInfo, int i12, r rVar) {
        this((i12 & 1) != 0 ? 0 : i11, str, giftDataInfo);
    }
}
