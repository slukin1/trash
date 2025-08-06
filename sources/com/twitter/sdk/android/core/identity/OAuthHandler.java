package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterSession;

class OAuthHandler extends AuthHandler {
    public OAuthHandler(TwitterAuthConfig twitterAuthConfig, Callback<TwitterSession> callback, int i11) {
        super(twitterAuthConfig, callback, i11);
    }

    public boolean authorize(Activity activity) {
        activity.startActivityForResult(newIntent(activity), this.requestCode);
        return true;
    }

    public Intent newIntent(Activity activity) {
        Intent intent = new Intent(activity, OAuthActivity.class);
        intent.putExtra(OAuthActivity.EXTRA_AUTH_CONFIG, getAuthConfig());
        return intent;
    }
}
