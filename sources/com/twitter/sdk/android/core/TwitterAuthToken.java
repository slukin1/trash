package com.twitter.sdk.android.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class TwitterAuthToken extends AuthToken implements Parcelable {
    public static final Parcelable.Creator<TwitterAuthToken> CREATOR = new Parcelable.Creator<TwitterAuthToken>() {
        public TwitterAuthToken createFromParcel(Parcel parcel) {
            return new TwitterAuthToken(parcel);
        }

        public TwitterAuthToken[] newArray(int i11) {
            return new TwitterAuthToken[i11];
        }
    };
    @SerializedName("secret")
    public final String secret;
    @SerializedName("token")
    public final String token;

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterAuthToken)) {
            return false;
        }
        TwitterAuthToken twitterAuthToken = (TwitterAuthToken) obj;
        String str = this.secret;
        if (str == null ? twitterAuthToken.secret != null : !str.equals(twitterAuthToken.secret)) {
            return false;
        }
        String str2 = this.token;
        String str3 = twitterAuthToken.token;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        String str = this.token;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.secret;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public boolean isExpired() {
        return false;
    }

    public String toString() {
        return "token=" + this.token + ",secret=" + this.secret;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.token);
        parcel.writeString(this.secret);
    }

    public TwitterAuthToken(String str, String str2) {
        this.token = str;
        this.secret = str2;
    }

    public TwitterAuthToken(String str, String str2, long j11) {
        super(j11);
        this.token = str;
        this.secret = str2;
    }

    private TwitterAuthToken(Parcel parcel) {
        this.token = parcel.readString();
        this.secret = parcel.readString();
    }
}
