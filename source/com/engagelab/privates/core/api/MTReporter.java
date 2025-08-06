package com.engagelab.privates.core.api;

import android.os.Parcel;
import android.os.Parcelable;

public class MTReporter implements Parcelable {
    public static final Parcelable.Creator<MTReporter> CREATOR = new a();
    private String content;
    private String type;

    public static class a implements Parcelable.Creator<MTReporter> {
        /* renamed from: a */
        public MTReporter createFromParcel(Parcel parcel) {
            return new MTReporter(parcel);
        }

        /* renamed from: a */
        public MTReporter[] newArray(int i11) {
            return new MTReporter[i11];
        }
    }

    public MTReporter() {
    }

    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public String getType() {
        return this.type;
    }

    public MTReporter setContent(String str) {
        this.content = str;
        return this;
    }

    public MTReporter setType(String str) {
        this.type = str;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.type);
        parcel.writeString(this.content);
    }

    public MTReporter(Parcel parcel) {
        this.type = parcel.readString();
        this.content = parcel.readString();
    }
}
