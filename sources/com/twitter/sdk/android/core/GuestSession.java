package com.twitter.sdk.android.core;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.persistence.SerializationStrategy;

public class GuestSession extends Session<GuestAuthToken> {
    public static final long LOGGED_OUT_USER_ID = 0;

    public static class Serializer implements SerializationStrategy<GuestSession> {
        private final Gson gson = new GsonBuilder().registerTypeAdapter(GuestAuthToken.class, new AuthTokenAdapter()).create();

        public GuestSession deserialize(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return (GuestSession) this.gson.fromJson(str, GuestSession.class);
            } catch (Exception e11) {
                Logger logger = Twitter.getLogger();
                logger.d("Twitter", "Failed to deserialize session " + e11.getMessage());
                return null;
            }
        }

        public String serialize(GuestSession guestSession) {
            if (guestSession == null || guestSession.getAuthToken() == null) {
                return "";
            }
            try {
                return this.gson.toJson((Object) guestSession);
            } catch (Exception e11) {
                Logger logger = Twitter.getLogger();
                logger.d("Twitter", "Failed to serialize session " + e11.getMessage());
                return "";
            }
        }
    }

    public GuestSession(GuestAuthToken guestAuthToken) {
        super(guestAuthToken, 0);
    }
}
