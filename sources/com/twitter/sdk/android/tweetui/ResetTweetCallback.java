package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;

class ResetTweetCallback extends Callback<Tweet> {
    public final BaseTweetView baseTweetView;

    /* renamed from: cb  reason: collision with root package name */
    public final Callback<Tweet> f51211cb;
    public final TweetRepository tweetRepository;

    public ResetTweetCallback(BaseTweetView baseTweetView2, TweetRepository tweetRepository2, Callback<Tweet> callback) {
        this.baseTweetView = baseTweetView2;
        this.tweetRepository = tweetRepository2;
        this.f51211cb = callback;
    }

    public void failure(TwitterException twitterException) {
        Callback<Tweet> callback = this.f51211cb;
        if (callback != null) {
            callback.failure(twitterException);
        }
    }

    public void success(Result<Tweet> result) {
        this.tweetRepository.updateCache((Tweet) result.data);
        this.baseTweetView.setTweet((Tweet) result.data);
        Callback<Tweet> callback = this.f51211cb;
        if (callback != null) {
            callback.success(result);
        }
    }
}
