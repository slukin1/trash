package com.hbg.lib.widgets.photoviewer.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageData implements Parcelable {
    public static final Parcelable.Creator<ImageData> CREATOR = new a();
    private String image;
    private String thumbImage;

    public class a implements Parcelable.Creator<ImageData> {
        /* renamed from: a */
        public ImageData createFromParcel(Parcel parcel) {
            return new ImageData(parcel);
        }

        /* renamed from: b */
        public ImageData[] newArray(int i11) {
            return new ImageData[i11];
        }
    }

    public ImageData() {
    }

    public int describeContents() {
        return 0;
    }

    public String getImage() {
        return this.image;
    }

    public String getThumbImage() {
        return this.thumbImage;
    }

    public void readFromParcel(Parcel parcel) {
        this.image = parcel.readString();
        this.thumbImage = parcel.readString();
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setThumbImage(String str) {
        this.thumbImage = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.image);
        parcel.writeString(this.thumbImage);
    }

    public ImageData(String str, String str2) {
        this.image = str;
        this.thumbImage = str2;
    }

    public ImageData(Parcel parcel) {
        this.image = parcel.readString();
        this.thumbImage = parcel.readString();
    }
}
