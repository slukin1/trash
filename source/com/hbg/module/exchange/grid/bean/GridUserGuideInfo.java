package com.hbg.module.exchange.grid.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class GridUserGuideInfo implements Parcelable {
    public static final Parcelable.Creator<GridUserGuideInfo> CREATOR = new a();
    private String detail1;
    private String detail2;
    private int imageId;
    private int index;
    private String link;
    private String name;

    public class a implements Parcelable.Creator<GridUserGuideInfo> {
        /* renamed from: a */
        public GridUserGuideInfo createFromParcel(Parcel parcel) {
            return new GridUserGuideInfo(parcel);
        }

        /* renamed from: b */
        public GridUserGuideInfo[] newArray(int i11) {
            return new GridUserGuideInfo[i11];
        }
    }

    public GridUserGuideInfo(int i11, int i12, String str, String str2, String str3, String str4) {
        this.index = i11;
        this.imageId = i12;
        this.name = str;
        this.detail1 = str2;
        this.detail2 = str3;
        this.link = str4;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof GridUserGuideInfo;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridUserGuideInfo)) {
            return false;
        }
        GridUserGuideInfo gridUserGuideInfo = (GridUserGuideInfo) obj;
        if (!gridUserGuideInfo.canEqual(this) || getIndex() != gridUserGuideInfo.getIndex() || getImageId() != gridUserGuideInfo.getImageId()) {
            return false;
        }
        String name2 = getName();
        String name3 = gridUserGuideInfo.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String detail12 = getDetail1();
        String detail13 = gridUserGuideInfo.getDetail1();
        if (detail12 != null ? !detail12.equals(detail13) : detail13 != null) {
            return false;
        }
        String detail22 = getDetail2();
        String detail23 = gridUserGuideInfo.getDetail2();
        if (detail22 != null ? !detail22.equals(detail23) : detail23 != null) {
            return false;
        }
        String link2 = getLink();
        String link3 = gridUserGuideInfo.getLink();
        return link2 != null ? link2.equals(link3) : link3 == null;
    }

    public String getDetail1() {
        return this.detail1;
    }

    public String getDetail2() {
        return this.detail2;
    }

    public int getImageId() {
        return this.imageId;
    }

    public int getIndex() {
        return this.index;
    }

    public String getLink() {
        return this.link;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int index2 = ((getIndex() + 59) * 59) + getImageId();
        String name2 = getName();
        int i11 = 43;
        int hashCode = (index2 * 59) + (name2 == null ? 43 : name2.hashCode());
        String detail12 = getDetail1();
        int hashCode2 = (hashCode * 59) + (detail12 == null ? 43 : detail12.hashCode());
        String detail22 = getDetail2();
        int hashCode3 = (hashCode2 * 59) + (detail22 == null ? 43 : detail22.hashCode());
        String link2 = getLink();
        int i12 = hashCode3 * 59;
        if (link2 != null) {
            i11 = link2.hashCode();
        }
        return i12 + i11;
    }

    public void setDetail1(String str) {
        this.detail1 = str;
    }

    public void setDetail2(String str) {
        this.detail2 = str;
    }

    public void setImageId(int i11) {
        this.imageId = i11;
    }

    public void setIndex(int i11) {
        this.index = i11;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "GridUserGuideInfo(index=" + getIndex() + ", imageId=" + getImageId() + ", name=" + getName() + ", detail1=" + getDetail1() + ", detail2=" + getDetail2() + ", link=" + getLink() + ")";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.index);
        parcel.writeInt(this.imageId);
        parcel.writeString(this.name);
        parcel.writeString(this.detail1);
        parcel.writeString(this.detail2);
        parcel.writeString(this.link);
    }

    public GridUserGuideInfo(Parcel parcel) {
        this.index = parcel.readInt();
        this.imageId = parcel.readInt();
        this.name = parcel.readString();
        this.detail1 = parcel.readString();
        this.detail2 = parcel.readString();
        this.link = parcel.readString();
    }
}
