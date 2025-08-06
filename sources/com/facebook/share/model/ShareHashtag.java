package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ShareHashtag implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new Parcelable.Creator<ShareHashtag>() {
        public ShareHashtag createFromParcel(Parcel parcel) {
            return new ShareHashtag(parcel);
        }

        public ShareHashtag[] newArray(int i11) {
            return new ShareHashtag[i11];
        }
    };
    private final String hashtag;

    public static class Builder implements ShareModelBuilder<ShareHashtag, Builder> {
        /* access modifiers changed from: private */
        public String hashtag;

        public String getHashtag() {
            return this.hashtag;
        }

        public Builder setHashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public ShareHashtag build() {
            return new ShareHashtag(this);
        }

        public Builder readFrom(ShareHashtag shareHashtag) {
            return shareHashtag == null ? this : setHashtag(shareHashtag.getHashtag());
        }

        public Builder readFrom(Parcel parcel) {
            return readFrom((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getHashtag() {
        return this.hashtag;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.hashtag);
    }

    private ShareHashtag(Builder builder) {
        this.hashtag = builder.hashtag;
    }

    public ShareHashtag(Parcel parcel) {
        this.hashtag = parcel.readString();
    }
}
