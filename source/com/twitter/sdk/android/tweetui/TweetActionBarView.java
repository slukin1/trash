package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.models.Tweet;

public class TweetActionBarView extends LinearLayout {
    public Callback<Tweet> actionCallback;
    public final DependencyProvider dependencyProvider;
    public ToggleImageButton likeButton;
    public ImageButton shareButton;

    public static class DependencyProvider {
        public TweetUi getTweetUi() {
            return TweetUi.getInstance();
        }
    }

    public TweetActionBarView(Context context) {
        this(context, (AttributeSet) null, new DependencyProvider());
    }

    public void findSubviews() {
        this.likeButton = (ToggleImageButton) findViewById(R.id.tw__tweet_like_button);
        this.shareButton = (ImageButton) findViewById(R.id.tw__tweet_share_button);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        findSubviews();
    }

    public void setLike(Tweet tweet) {
        TweetUi tweetUi = this.dependencyProvider.getTweetUi();
        if (tweet != null) {
            this.likeButton.setToggledOn(tweet.favorited);
            this.likeButton.setOnClickListener(new LikeTweetAction(tweet, tweetUi, this.actionCallback));
        }
    }

    public void setOnActionCallback(Callback<Tweet> callback) {
        this.actionCallback = callback;
    }

    public void setShare(Tweet tweet) {
        TweetUi tweetUi = this.dependencyProvider.getTweetUi();
        if (tweet != null) {
            this.shareButton.setOnClickListener(new ShareTweetAction(tweet, tweetUi));
        }
    }

    public void setTweet(Tweet tweet) {
        setLike(tweet);
        setShare(tweet);
    }

    public TweetActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new DependencyProvider());
    }

    public TweetActionBarView(Context context, AttributeSet attributeSet, DependencyProvider dependencyProvider2) {
        super(context, attributeSet);
        this.dependencyProvider = dependencyProvider2;
    }
}
