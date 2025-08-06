package com.hbg.module.libkt.utils.event.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.x;

public final class GiftDataInfo implements Parcelable {
    public static final Parcelable.Creator<GiftDataInfo> CREATOR = new Creator();
    private ArrayList<Financial> financial;
    private ArrayList<GiftGroup> giftGroups;
    private int integral;
    private int tip;

    public static final class Creator implements Parcelable.Creator<GiftDataInfo> {
        /* renamed from: a */
        public final GiftDataInfo createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt3 = parcel.readInt();
                arrayList = new ArrayList(readInt3);
                for (int i11 = 0; i11 != readInt3; i11++) {
                    arrayList.add(Financial.CREATOR.createFromParcel(parcel));
                }
            }
            if (parcel.readInt() != 0) {
                int readInt4 = parcel.readInt();
                arrayList2 = new ArrayList(readInt4);
                for (int i12 = 0; i12 != readInt4; i12++) {
                    arrayList2.add(GiftGroup.CREATOR.createFromParcel(parcel));
                }
            }
            return new GiftDataInfo(readInt, readInt2, arrayList, arrayList2);
        }

        /* renamed from: b */
        public final GiftDataInfo[] newArray(int i11) {
            return new GiftDataInfo[i11];
        }
    }

    public GiftDataInfo(int i11, int i12, ArrayList<Financial> arrayList, ArrayList<GiftGroup> arrayList2) {
        this.integral = i11;
        this.tip = i12;
        this.financial = arrayList;
        this.giftGroups = arrayList2;
    }

    public static /* synthetic */ GiftDataInfo copy$default(GiftDataInfo giftDataInfo, int i11, int i12, ArrayList<Financial> arrayList, ArrayList<GiftGroup> arrayList2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = giftDataInfo.integral;
        }
        if ((i13 & 2) != 0) {
            i12 = giftDataInfo.tip;
        }
        if ((i13 & 4) != 0) {
            arrayList = giftDataInfo.financial;
        }
        if ((i13 & 8) != 0) {
            arrayList2 = giftDataInfo.giftGroups;
        }
        return giftDataInfo.copy(i11, i12, arrayList, arrayList2);
    }

    public final int component1() {
        return this.integral;
    }

    public final int component2() {
        return this.tip;
    }

    public final ArrayList<Financial> component3() {
        return this.financial;
    }

    public final ArrayList<GiftGroup> component4() {
        return this.giftGroups;
    }

    public final GiftDataInfo copy(int i11, int i12, ArrayList<Financial> arrayList, ArrayList<GiftGroup> arrayList2) {
        return new GiftDataInfo(i11, i12, arrayList, arrayList2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftDataInfo)) {
            return false;
        }
        GiftDataInfo giftDataInfo = (GiftDataInfo) obj;
        return this.integral == giftDataInfo.integral && this.tip == giftDataInfo.tip && x.b(this.financial, giftDataInfo.financial) && x.b(this.giftGroups, giftDataInfo.giftGroups);
    }

    public final ArrayList<Financial> getFinancial() {
        return this.financial;
    }

    public final ArrayList<GiftGroup> getGiftGroups() {
        return this.giftGroups;
    }

    public final int getIntegral() {
        return this.integral;
    }

    public final int getTip() {
        return this.tip;
    }

    public int hashCode() {
        int i11 = ((this.integral * 31) + this.tip) * 31;
        ArrayList<Financial> arrayList = this.financial;
        int i12 = 0;
        int hashCode = (i11 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<GiftGroup> arrayList2 = this.giftGroups;
        if (arrayList2 != null) {
            i12 = arrayList2.hashCode();
        }
        return hashCode + i12;
    }

    public final void setFinancial(ArrayList<Financial> arrayList) {
        this.financial = arrayList;
    }

    public final void setGiftGroups(ArrayList<GiftGroup> arrayList) {
        this.giftGroups = arrayList;
    }

    public final void setIntegral(int i11) {
        this.integral = i11;
    }

    public final void setTip(int i11) {
        this.tip = i11;
    }

    public String toString() {
        return "GiftDataInfo(integral=" + this.integral + ", tip=" + this.tip + ", financial=" + this.financial + ", giftGroups=" + this.giftGroups + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.integral);
        parcel.writeInt(this.tip);
        ArrayList<Financial> arrayList = this.financial;
        if (arrayList == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(arrayList.size());
            Iterator<Financial> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(parcel, i11);
            }
        }
        ArrayList<GiftGroup> arrayList2 = this.giftGroups;
        if (arrayList2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(arrayList2.size());
        Iterator<GiftGroup> it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(parcel, i11);
        }
    }
}
