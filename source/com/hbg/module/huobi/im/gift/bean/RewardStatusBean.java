package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class RewardStatusBean implements Parcelable {
    public static final Parcelable.Creator<RewardStatusBean> CREATOR = new Creator();
    private String groupId;
    private int status;

    public static final class Creator implements Parcelable.Creator<RewardStatusBean> {
        /* renamed from: a */
        public final RewardStatusBean createFromParcel(Parcel parcel) {
            return new RewardStatusBean(parcel.readString(), parcel.readInt());
        }

        /* renamed from: b */
        public final RewardStatusBean[] newArray(int i11) {
            return new RewardStatusBean[i11];
        }
    }

    public RewardStatusBean(String str, int i11) {
        this.groupId = str;
        this.status = i11;
    }

    public static /* synthetic */ RewardStatusBean copy$default(RewardStatusBean rewardStatusBean, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = rewardStatusBean.groupId;
        }
        if ((i12 & 2) != 0) {
            i11 = rewardStatusBean.status;
        }
        return rewardStatusBean.copy(str, i11);
    }

    public final String component1() {
        return this.groupId;
    }

    public final int component2() {
        return this.status;
    }

    public final RewardStatusBean copy(String str, int i11) {
        return new RewardStatusBean(str, i11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardStatusBean)) {
            return false;
        }
        RewardStatusBean rewardStatusBean = (RewardStatusBean) obj;
        return x.b(this.groupId, rewardStatusBean.groupId) && this.status == rewardStatusBean.status;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.groupId;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.status;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setStatus(int i11) {
        this.status = i11;
    }

    public String toString() {
        return "RewardStatusBean(groupId=" + this.groupId + ", status=" + this.status + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.groupId);
        parcel.writeInt(this.status);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewardStatusBean(String str, int i11, int i12, r rVar) {
        this(str, (i12 & 2) != 0 ? 2 : i11);
    }
}
