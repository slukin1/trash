package com.twitter.sdk.android.tweetui;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;
import retrofit2.Response;

class LikeTweetAction extends BaseTweetAction implements View.OnClickListener {
    public final Tweet tweet;
    public final TweetRepository tweetRepository;
    public final TweetUi tweetUi;

    public static class LikeCallback extends Callback<Tweet> {
        public final ToggleImageButton button;

        /* renamed from: cb  reason: collision with root package name */
        public final Callback<Tweet> f51209cb;
        public final Tweet tweet;

        public LikeCallback(ToggleImageButton toggleImageButton, Tweet tweet2, Callback<Tweet> callback) {
            this.button = toggleImageButton;
            this.tweet = tweet2;
            this.f51209cb = callback;
        }

        public void failure(TwitterException twitterException) {
            if (twitterException instanceof TwitterApiException) {
                int errorCode = ((TwitterApiException) twitterException).getErrorCode();
                if (errorCode == 139) {
                    this.f51209cb.success(new Result(new TweetBuilder().copy(this.tweet).setFavorited(true).build(), (Response) null));
                } else if (errorCode != 144) {
                    this.button.setToggledOn(this.tweet.favorited);
                    this.f51209cb.failure(twitterException);
                } else {
                    this.f51209cb.success(new Result(new TweetBuilder().copy(this.tweet).setFavorited(false).build(), (Response) null));
                }
            } else {
                this.button.setToggledOn(this.tweet.favorited);
                this.f51209cb.failure(twitterException);
            }
        }

        public void success(Result<Tweet> result) {
            this.f51209cb.success(result);
        }
    }

    public LikeTweetAction(Tweet tweet2, TweetUi tweetUi2, Callback<Tweet> callback) {
        super(callback);
        this.tweet = tweet2;
        this.tweetUi = tweetUi2;
        this.tweetRepository = tweetUi2.getTweetRepository();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view instanceof ToggleImageButton) {
            ToggleImageButton toggleImageButton = (ToggleImageButton) view;
            Tweet tweet2 = this.tweet;
            if (tweet2.favorited) {
                this.tweetRepository.unfavorite(tweet2.f51198id, new LikeCallback(toggleImageButton, tweet2, getActionCallback()));
            } else {
                this.tweetRepository.favorite(tweet2.f51198id, new LikeCallback(toggleImageButton, tweet2, getActionCallback()));
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
