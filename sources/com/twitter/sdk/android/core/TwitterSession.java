package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.internal.persistence.SerializationStrategy;

public class TwitterSession extends Session<TwitterAuthToken> {
    public static final long UNKNOWN_USER_ID = -1;
    public static final String UNKNOWN_USER_NAME = "";
    @SerializedName("user_name")
    private final String userName;

    public static class Serializer implements SerializationStrategy<TwitterSession> {
        private final Gson gson = new Gson();

        public TwitterSession deserialize(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (TwitterSession) this.gson.fromJson(str, TwitterSession.class);
            } catch (Exception e11) {
                Twitter.getLogger().d("Twitter", e11.getMessage());
                return null;
            }
        }

        public String serialize(TwitterSession twitterSession) {
            if (twitterSession == null || twitterSession.getAuthToken() == null) {
                return "";
            }
            try {
                return this.gson.toJson((Object) twitterSession);
            } catch (Exception e11) {
                Twitter.getLogger().d("Twitter", e11.getMessage());
                return "";
            }
        }
    }

    public TwitterSession(TwitterAuthToken twitterAuthToken, long j11, String str) {
        super(twitterAuthToken, j11);
        this.userName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        String str = this.userName;
        String str2 = ((TwitterSession) obj).userName;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public long getUserId() {
        return getId();
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.userName;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
