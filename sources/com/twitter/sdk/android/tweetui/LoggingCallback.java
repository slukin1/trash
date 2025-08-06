package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Logger;
import com.twitter.sdk.android.core.TwitterException;

abstract class LoggingCallback<T> extends Callback<T> {

    /* renamed from: cb  reason: collision with root package name */
    private final Callback f51210cb;
    private final Logger logger;

    public LoggingCallback(Callback callback, Logger logger2) {
        this.f51210cb = callback;
        this.logger = logger2;
    }

    public void failure(TwitterException twitterException) {
        this.logger.e("TweetUi", twitterException.getMessage(), twitterException);
        Callback callback = this.f51210cb;
        if (callback != null) {
            callback.failure(twitterException);
        }
    }
}
