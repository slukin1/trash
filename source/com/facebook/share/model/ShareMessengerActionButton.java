package com.facebook.share.model;

import android.os.Parcel;

@Deprecated
public abstract class ShareMessengerActionButton implements ShareModel {
    private final String title;

    public static abstract class Builder<M extends ShareMessengerActionButton, B extends Builder> implements ShareModelBuilder<M, B> {
        /* access modifiers changed from: private */
        public String title;

        public B setTitle(String str) {
            this.title = str;
            return this;
        }

        public B readFrom(M m11) {
            return m11 == null ? this : setTitle(m11.getTitle());
        }
    }

    public ShareMessengerActionButton(Builder builder) {
        this.title = builder.title;
    }

    public int describeContents() {
        return 0;
    }

    public String getTitle() {
        return this.title;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.title);
    }

    public ShareMessengerActionButton(Parcel parcel) {
        this.title = parcel.readString();
    }
}
