package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetui.AbstractTweetView;

public class TweetView extends BaseTweetView {
    private static final double DEFAULT_ASPECT_RATIO_MEDIA_CONTAINER = 1.5d;
    private static final double SQUARE_ASPECT_RATIO = 1.0d;
    private static final String VIEW_TYPE_NAME = "default";

    public TweetView(Context context, Tweet tweet) {
        super(context, tweet);
    }

    private void setVerifiedCheck(Tweet tweet) {
        User user;
        if (tweet == null || (user = tweet.user) == null || !user.verified) {
            this.fullNameView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            this.fullNameView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.tw__ic_tweet_verified, 0);
        }
    }

    public double getAspectRatioForPhotoEntity(int i11) {
        if (i11 == 4) {
            return 1.0d;
        }
        return DEFAULT_ASPECT_RATIO_MEDIA_CONTAINER;
    }

    public int getLayout() {
        return R.layout.tw__tweet;
    }

    public void render() {
        super.render();
        setVerifiedCheck(this.tweet);
    }

    public TweetView(Context context, Tweet tweet, int i11) {
        super(context, tweet, i11);
    }

    public TweetView(Context context, Tweet tweet, int i11, AbstractTweetView.DependencyProvider dependencyProvider) {
        super(context, tweet, i11, dependencyProvider);
    }

    public TweetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TweetView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
