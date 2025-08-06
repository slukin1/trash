package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterSession;
import retrofit2.Response;

public abstract class AuthHandler {
    public static final String EXTRA_AUTH_ERROR = "auth_error";
    public static final String EXTRA_SCREEN_NAME = "screen_name";
    public static final String EXTRA_TOKEN = "tk";
    public static final String EXTRA_TOKEN_SECRET = "ts";
    public static final String EXTRA_USER_ID = "user_id";
    public static final int RESULT_CODE_ERROR = 1;
    private final Callback<TwitterSession> callback;
    private final TwitterAuthConfig config;
    public final int requestCode;

    public AuthHandler(TwitterAuthConfig twitterAuthConfig, Callback<TwitterSession> callback2, int i11) {
        this.config = twitterAuthConfig;
        this.callback = callback2;
        this.requestCode = i11;
    }

    public abstract boolean authorize(Activity activity);

    public TwitterAuthConfig getAuthConfig() {
        return this.config;
    }

    public Callback<TwitterSession> getCallback() {
        return this.callback;
    }

    public boolean handleOnActivityResult(int i11, int i12, Intent intent) {
        if (this.requestCode != i11) {
            return false;
        }
        Callback<TwitterSession> callback2 = getCallback();
        if (callback2 == null) {
            return true;
        }
        if (i12 == -1) {
            String stringExtra = intent.getStringExtra(EXTRA_TOKEN);
            String stringExtra2 = intent.getStringExtra(EXTRA_TOKEN_SECRET);
            String stringExtra3 = intent.getStringExtra("screen_name");
            callback2.success(new Result(new TwitterSession(new TwitterAuthToken(stringExtra, stringExtra2), intent.getLongExtra("user_id", 0), stringExtra3), (Response) null));
            return true;
        } else if (intent == null || !intent.hasExtra(EXTRA_AUTH_ERROR)) {
            callback2.failure(new TwitterAuthException("Authorize failed."));
            return true;
        } else {
            callback2.failure((TwitterAuthException) intent.getSerializableExtra(EXTRA_AUTH_ERROR));
            return true;
        }
    }
}
