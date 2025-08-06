package com.luck.picture.lib.magical;

import android.os.Parcel;
import android.os.Parcelable;

public class ViewParams implements Parcelable {
    public static final Parcelable.Creator<ViewParams> CREATOR = new Parcelable.Creator<ViewParams>() {
        public ViewParams createFromParcel(Parcel parcel) {
            return new ViewParams(parcel);
        }

        public ViewParams[] newArray(int i11) {
            return new ViewParams[i11];
        }
    };
    public int height;
    public int left;
    public int top;
    public int width;

    public ViewParams() {
    }

    public int describeContents() {
        return 0;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLeft() {
        return this.left;
    }

    public int getTop() {
        return this.top;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setLeft(int i11) {
        this.left = i11;
    }

    public void setTop(int i11) {
        this.top = i11;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.left);
        parcel.writeInt(this.top);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public ViewParams(Parcel parcel) {
        this.left = parcel.readInt();
        this.top = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
