package com.huobi.guide.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ContractGuideInfo implements Parcelable {
    public static final Parcelable.Creator<ContractGuideInfo> CREATOR = new a();
    public static final int TYPE_LINK_INNER = 1;
    public static final int TYPE_LINK_WEB = 2;
    private String detail1;
    private int imageId;
    private int index;
    private String link;
    private String linkDisplayName;
    private int linkType;
    private String name;

    public class a implements Parcelable.Creator<ContractGuideInfo> {
        /* renamed from: a */
        public ContractGuideInfo createFromParcel(Parcel parcel) {
            return new ContractGuideInfo(parcel);
        }

        /* renamed from: b */
        public ContractGuideInfo[] newArray(int i11) {
            return new ContractGuideInfo[i11];
        }
    }

    public ContractGuideInfo(int i11, int i12, String str, String str2, String str3, int i13, String str4) {
        this.index = i11;
        this.imageId = i12;
        this.name = str;
        this.detail1 = str2;
        this.linkDisplayName = str3;
        this.linkType = i13;
        this.link = str4;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ContractGuideInfo;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractGuideInfo)) {
            return false;
        }
        ContractGuideInfo contractGuideInfo = (ContractGuideInfo) obj;
        if (!contractGuideInfo.canEqual(this) || getIndex() != contractGuideInfo.getIndex() || getImageId() != contractGuideInfo.getImageId()) {
            return false;
        }
        String name2 = getName();
        String name3 = contractGuideInfo.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String detail12 = getDetail1();
        String detail13 = contractGuideInfo.getDetail1();
        if (detail12 != null ? !detail12.equals(detail13) : detail13 != null) {
            return false;
        }
        String linkDisplayName2 = getLinkDisplayName();
        String linkDisplayName3 = contractGuideInfo.getLinkDisplayName();
        if (linkDisplayName2 != null ? !linkDisplayName2.equals(linkDisplayName3) : linkDisplayName3 != null) {
            return false;
        }
        String link2 = getLink();
        String link3 = contractGuideInfo.getLink();
        if (link2 != null ? link2.equals(link3) : link3 == null) {
            return getLinkType() == contractGuideInfo.getLinkType();
        }
        return false;
    }

    public String getDetail1() {
        return this.detail1;
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

    public String getLinkDisplayName() {
        return this.linkDisplayName;
    }

    public int getLinkType() {
        return this.linkType;
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
        String linkDisplayName2 = getLinkDisplayName();
        int hashCode3 = (hashCode2 * 59) + (linkDisplayName2 == null ? 43 : linkDisplayName2.hashCode());
        String link2 = getLink();
        int i12 = hashCode3 * 59;
        if (link2 != null) {
            i11 = link2.hashCode();
        }
        return ((i12 + i11) * 59) + getLinkType();
    }

    public void setDetail1(String str) {
        this.detail1 = str;
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

    public void setLinkDisplayName(String str) {
        this.linkDisplayName = str;
    }

    public void setLinkType(int i11) {
        this.linkType = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "ContractGuideInfo(index=" + getIndex() + ", imageId=" + getImageId() + ", name=" + getName() + ", detail1=" + getDetail1() + ", linkDisplayName=" + getLinkDisplayName() + ", link=" + getLink() + ", linkType=" + getLinkType() + ")";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.index);
        parcel.writeInt(this.imageId);
        parcel.writeString(this.name);
        parcel.writeString(this.detail1);
        parcel.writeString(this.linkDisplayName);
        parcel.writeString(this.link);
    }

    public ContractGuideInfo(int i11, int i12, String str, String str2, String str3) {
        this.index = i11;
        this.imageId = i12;
        this.name = str;
        this.detail1 = str2;
        this.link = str3;
    }

    public ContractGuideInfo(int i11, int i12, String str, String str2) {
        this.index = i11;
        this.imageId = i12;
        this.name = str;
        this.detail1 = str2;
    }

    public ContractGuideInfo(Parcel parcel) {
        this.index = parcel.readInt();
        this.imageId = parcel.readInt();
        this.name = parcel.readString();
        this.detail1 = parcel.readString();
        this.linkDisplayName = parcel.readString();
        this.link = parcel.readString();
    }
}
