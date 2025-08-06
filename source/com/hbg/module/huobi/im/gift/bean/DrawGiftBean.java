package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.x;

public final class DrawGiftBean implements Parcelable {
    public static final Parcelable.Creator<DrawGiftBean> CREATOR = new Creator();
    private ArrayList<JackpotBean> drawDetailList;
    private Boolean result;

    public static final class Creator implements Parcelable.Creator<DrawGiftBean> {
        /* renamed from: a */
        public final DrawGiftBean createFromParcel(Parcel parcel) {
            Boolean bool;
            ArrayList arrayList = null;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList2.add(JackpotBean.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new DrawGiftBean(bool, arrayList);
        }

        /* renamed from: b */
        public final DrawGiftBean[] newArray(int i11) {
            return new DrawGiftBean[i11];
        }
    }

    public DrawGiftBean(Boolean bool, ArrayList<JackpotBean> arrayList) {
        this.result = bool;
        this.drawDetailList = arrayList;
    }

    public static /* synthetic */ DrawGiftBean copy$default(DrawGiftBean drawGiftBean, Boolean bool, ArrayList<JackpotBean> arrayList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = drawGiftBean.result;
        }
        if ((i11 & 2) != 0) {
            arrayList = drawGiftBean.drawDetailList;
        }
        return drawGiftBean.copy(bool, arrayList);
    }

    public final Boolean component1() {
        return this.result;
    }

    public final ArrayList<JackpotBean> component2() {
        return this.drawDetailList;
    }

    public final DrawGiftBean copy(Boolean bool, ArrayList<JackpotBean> arrayList) {
        return new DrawGiftBean(bool, arrayList);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawGiftBean)) {
            return false;
        }
        DrawGiftBean drawGiftBean = (DrawGiftBean) obj;
        return x.b(this.result, drawGiftBean.result) && x.b(this.drawDetailList, drawGiftBean.drawDetailList);
    }

    public final ArrayList<JackpotBean> getDrawDetailList() {
        return this.drawDetailList;
    }

    public final Boolean getResult() {
        return this.result;
    }

    public int hashCode() {
        Boolean bool = this.result;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        ArrayList<JackpotBean> arrayList = this.drawDetailList;
        if (arrayList != null) {
            i11 = arrayList.hashCode();
        }
        return hashCode + i11;
    }

    public final void setDrawDetailList(ArrayList<JackpotBean> arrayList) {
        this.drawDetailList = arrayList;
    }

    public final void setResult(Boolean bool) {
        this.result = bool;
    }

    public String toString() {
        return "DrawGiftBean(result=" + this.result + ", drawDetailList=" + this.drawDetailList + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        Boolean bool = this.result;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        ArrayList<JackpotBean> arrayList = this.drawDetailList;
        if (arrayList == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(arrayList.size());
        Iterator<JackpotBean> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, i11);
        }
    }
}
