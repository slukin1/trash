package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import com.twitter.sdk.android.core.TwitterAuthToken;

public class OAuthResponse implements Parcelable {
    public static final Parcelable.Creator<OAuthResponse> CREATOR = new Parcelable.Creator<OAuthResponse>() {
        public OAuthResponse createFromParcel(Parcel parcel) {
            return new OAuthResponse(parcel);
        }

        public OAuthResponse[] newArray(int i11) {
            return new OAuthResponse[i11];
        }
    };
    public final TwitterAuthToken authToken;
    public final long userId;
    public final String userName;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "authToken=" + this.authToken + ",userName=" + this.userName + ",userId=" + this.userId;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.authToken, i11);
        parcel.writeString(this.userName);
        parcel.writeLong(this.userId);
    }

    public OAuthResponse(TwitterAuthToken twitterAuthToken, String str, long j11) {
        this.authToken = twitterAuthToken;
        this.userName = str;
        this.userId = j11;
    }

    private OAuthResponse(Parcel parcel) {
        this.authToken = (TwitterAuthToken) parcel.readParcelable(TwitterAuthToken.class.getClassLoader());
        this.userName = parcel.readString();
        this.userId = parcel.readLong();
    }
}
