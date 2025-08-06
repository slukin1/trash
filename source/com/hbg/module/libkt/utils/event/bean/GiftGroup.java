package com.hbg.module.libkt.utils.event.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.x;

public final class GiftGroup implements Parcelable {
    public static final Parcelable.Creator<GiftGroup> CREATOR = new Creator();
    private Financial financial;
    private ArrayList<GiftBean> gifts;
    private int groupId;
    private String groupName;

    public static final class Creator implements Parcelable.Creator<GiftGroup> {
        /* renamed from: a */
        public final GiftGroup createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            Financial financial = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                for (int i11 = 0; i11 != readInt2; i11++) {
                    arrayList.add(GiftBean.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() != 0) {
                financial = Financial.CREATOR.createFromParcel(parcel);
            }
            return new GiftGroup(readInt, readString, arrayList, financial);
        }

        /* renamed from: b */
        public final GiftGroup[] newArray(int i11) {
            return new GiftGroup[i11];
        }
    }

    public GiftGroup(int i11, String str, ArrayList<GiftBean> arrayList, Financial financial2) {
        this.groupId = i11;
        this.groupName = str;
        this.gifts = arrayList;
        this.financial = financial2;
    }

    public static /* synthetic */ GiftGroup copy$default(GiftGroup giftGroup, int i11, String str, ArrayList<GiftBean> arrayList, Financial financial2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = giftGroup.groupId;
        }
        if ((i12 & 2) != 0) {
            str = giftGroup.groupName;
        }
        if ((i12 & 4) != 0) {
            arrayList = giftGroup.gifts;
        }
        if ((i12 & 8) != 0) {
            financial2 = giftGroup.financial;
        }
        return giftGroup.copy(i11, str, arrayList, financial2);
    }

    public final int component1() {
        return this.groupId;
    }

    public final String component2() {
        return this.groupName;
    }

    public final ArrayList<GiftBean> component3() {
        return this.gifts;
    }

    public final Financial component4() {
        return this.financial;
    }

    public final GiftGroup copy(int i11, String str, ArrayList<GiftBean> arrayList, Financial financial2) {
        return new GiftGroup(i11, str, arrayList, financial2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftGroup)) {
            return false;
        }
        GiftGroup giftGroup = (GiftGroup) obj;
        return this.groupId == giftGroup.groupId && x.b(this.groupName, giftGroup.groupName) && x.b(this.gifts, giftGroup.gifts) && x.b(this.financial, giftGroup.financial);
    }

    public final Financial getFinancial() {
        return this.financial;
    }

    public final ArrayList<GiftBean> getGifts() {
        return this.gifts;
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public int hashCode() {
        int hashCode = ((this.groupId * 31) + this.groupName.hashCode()) * 31;
        ArrayList<GiftBean> arrayList = this.gifts;
        int i11 = 0;
        int hashCode2 = (hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Financial financial2 = this.financial;
        if (financial2 != null) {
            i11 = financial2.hashCode();
        }
        return hashCode2 + i11;
    }

    public final void setFinancial(Financial financial2) {
        this.financial = financial2;
    }

    public final void setGifts(ArrayList<GiftBean> arrayList) {
        this.gifts = arrayList;
    }

    public final void setGroupId(int i11) {
        this.groupId = i11;
    }

    public final void setGroupName(String str) {
        this.groupName = str;
    }

    public String toString() {
        return "GiftGroup(groupId=" + this.groupId + ", groupName=" + this.groupName + ", gifts=" + this.gifts + ", financial=" + this.financial + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.groupId);
        parcel.writeString(this.groupName);
        ArrayList<GiftBean> arrayList = this.gifts;
        if (arrayList == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            Iterator<GiftBean> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(parcel, i11);
            }
        }
        Financial financial2 = this.financial;
        if (financial2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        financial2.writeToParcel(parcel, i11);
    }
}
