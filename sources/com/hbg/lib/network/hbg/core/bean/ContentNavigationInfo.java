package com.hbg.lib.network.hbg.core.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ContentNavigationInfo implements Parcelable {
    public static final Parcelable.Creator<ContentNavigationInfo> CREATOR = new Parcelable.Creator<ContentNavigationInfo>() {
        public ContentNavigationInfo createFromParcel(Parcel parcel) {
            return new ContentNavigationInfo(parcel);
        }

        public ContentNavigationInfo[] newArray(int i11) {
            return new ContentNavigationInfo[i11];
        }
    };
    private String title;
    private int type;
    private String url;

    public ContentNavigationInfo() {
    }

    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public void readFromParcel(Parcel parcel) {
        this.title = parcel.readString();
        this.type = parcel.readInt();
        this.url = parcel.readString();
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.title);
        parcel.writeInt(this.type);
        parcel.writeString(this.url);
    }

    public ContentNavigationInfo(Parcel parcel) {
        this.title = parcel.readString();
        this.type = parcel.readInt();
        this.url = parcel.readString();
    }
}
