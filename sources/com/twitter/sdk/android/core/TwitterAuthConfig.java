package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;

public class TwitterAuthConfig implements Parcelable {
    public static final Parcelable.Creator<TwitterAuthConfig> CREATOR = new Parcelable.Creator<TwitterAuthConfig>() {
        public TwitterAuthConfig createFromParcel(Parcel parcel) {
            return new TwitterAuthConfig(parcel);
        }

        public TwitterAuthConfig[] newArray(int i11) {
            return new TwitterAuthConfig[i11];
        }
    };
    public static final int DEFAULT_AUTH_REQUEST_CODE = 140;
    private final String consumerKey;
    private final String consumerSecret;

    public static String sanitizeAttribute(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public String getConsumerKey() {
        return this.consumerKey;
    }

    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    public int getRequestCode() {
        return 140;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.consumerKey);
        parcel.writeString(this.consumerSecret);
    }

    public TwitterAuthConfig(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("TwitterAuthConfig must not be created with null consumer key or secret.");
        }
        this.consumerKey = sanitizeAttribute(str);
        this.consumerSecret = sanitizeAttribute(str2);
    }

    private TwitterAuthConfig(Parcel parcel) {
        this.consumerKey = parcel.readString();
        this.consumerSecret = parcel.readString();
    }
}
