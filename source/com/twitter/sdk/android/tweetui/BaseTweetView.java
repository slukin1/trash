package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.IntentUtils;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;
import com.twitter.sdk.android.tweetui.AbstractTweetView;
import java.util.Locale;

public abstract class BaseTweetView extends AbstractTweetView {
    public ColorDrawable avatarMediaBg;
    public ImageView avatarView;
    public int birdLogoResId;
    public View bottomSeparator;
    public int containerBgColor;
    public ViewGroup quoteTweetHolder;
    public QuoteTweetView quoteTweetView;
    public int retweetIconResId;
    public TextView retweetedByView;
    public TextView timestampView;
    public TweetActionBarView tweetActionBarView;
    public ImageView twitterLogoView;

    public BaseTweetView(Context context, Tweet tweet) {
        this(context, tweet, AbstractTweetView.DEFAULT_STYLE);
    }

    private void initAttributes(int i11) {
        this.styleResId = i11;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(i11, R.styleable.tw__TweetView);
        try {
            setStyleAttributes(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void initTweetActions() {
        setTweetActionsEnabled(this.tweetActionsEnabled);
        this.tweetActionBarView.setOnActionCallback(new ResetTweetCallback(this, this.dependencyProvider.getTweetUi().getTweetRepository(), (Callback<Tweet>) null));
    }

    private void initXmlAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.tw__TweetView, 0, 0);
            try {
                setXmlDataAttributes(obtainStyledAttributes);
                setStyleAttributes(obtainStyledAttributes);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$linkifyProfilePhotoView$0(Tweet tweet, View view) {
        TweetLinkClickListener tweetLinkClickListener = this.tweetLinkClickListener;
        if (tweetLinkClickListener != null) {
            tweetLinkClickListener.onLinkClick(tweet, TweetUtils.getProfilePermalink(tweet.user.screenName));
        } else {
            if (!IntentUtils.safeStartActivity(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(TweetUtils.getProfilePermalink(tweet.user.screenName))))) {
                Twitter.getLogger().e("TweetUi", "Activity cannot be found to open URL");
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$linkifyProfilePhotoView$1(View view, MotionEvent motionEvent) {
        ImageView imageView = (ImageView) view;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                view.performClick();
            } else if (action != 3) {
                return false;
            }
            imageView.getDrawable().clearColorFilter();
            imageView.invalidate();
            return false;
        }
        imageView.getDrawable().setColorFilter(getResources().getColor(R.color.tw__black_opacity_10), PorterDuff.Mode.SRC_ATOP);
        imageView.invalidate();
        return false;
    }

    private void loadTweet() {
        final long tweetId = getTweetId();
        this.dependencyProvider.getTweetUi().getTweetRepository().loadTweet(getTweetId(), new Callback<Tweet>() {
            public void failure(TwitterException twitterException) {
                Twitter.getLogger().d("TweetUi", String.format(Locale.ENGLISH, TweetUtils.LOAD_TWEET_DEBUG, new Object[]{Long.valueOf(tweetId)}));
            }

            public void success(Result<Tweet> result) {
                BaseTweetView.this.setTweet((Tweet) result.data);
            }
        });
    }

    private void setStyleAttributes(TypedArray typedArray) {
        this.containerBgColor = typedArray.getColor(R.styleable.tw__TweetView_tw__container_bg_color, getResources().getColor(R.color.tw__tweet_light_container_bg_color));
        this.primaryTextColor = typedArray.getColor(R.styleable.tw__TweetView_tw__primary_text_color, getResources().getColor(R.color.tw__tweet_light_primary_text_color));
        this.actionColor = typedArray.getColor(R.styleable.tw__TweetView_tw__action_color, getResources().getColor(R.color.tw__tweet_action_color));
        this.actionHighlightColor = typedArray.getColor(R.styleable.tw__TweetView_tw__action_highlight_color, getResources().getColor(R.color.tw__tweet_action_light_highlight_color));
        this.tweetActionsEnabled = typedArray.getBoolean(R.styleable.tw__TweetView_tw__tweet_actions_enabled, false);
        boolean isLightColor = ColorUtils.isLightColor(this.containerBgColor);
        if (isLightColor) {
            this.photoErrorResId = R.drawable.tw__ic_tweet_photo_error_light;
            this.birdLogoResId = R.drawable.tw__ic_logo_blue;
            this.retweetIconResId = R.drawable.tw__ic_retweet_light;
        } else {
            this.photoErrorResId = R.drawable.tw__ic_tweet_photo_error_dark;
            this.birdLogoResId = R.drawable.tw__ic_logo_white;
            this.retweetIconResId = R.drawable.tw__ic_retweet_dark;
        }
        int i11 = -1;
        this.secondaryTextColor = ColorUtils.calculateOpacityTransform(isLightColor ? 0.4d : 0.35d, isLightColor ? -1 : -16777216, this.primaryTextColor);
        double d11 = isLightColor ? 0.08d : 0.12d;
        if (isLightColor) {
            i11 = -16777216;
        }
        this.mediaBgColor = ColorUtils.calculateOpacityTransform(d11, i11, this.containerBgColor);
        this.avatarMediaBg = new ColorDrawable(this.mediaBgColor);
    }

    private void setTimestamp(Tweet tweet) {
        String str;
        String str2;
        if (tweet == null || (str2 = tweet.createdAt) == null || !TweetDateUtils.isValidTimestamp(str2)) {
            str = "";
        } else {
            str = TweetDateUtils.dotPrefix(TweetDateUtils.getRelativeTimeString(getResources(), System.currentTimeMillis(), Long.valueOf(TweetDateUtils.apiTimeToLong(tweet.createdAt)).longValue()));
        }
        this.timestampView.setText(str);
    }

    private void setXmlDataAttributes(TypedArray typedArray) {
        long longValue = Utils.numberOrDefault(typedArray.getString(R.styleable.tw__TweetView_tw__tweet_id), -1).longValue();
        if (longValue > 0) {
            setPermalinkUri((String) null, Long.valueOf(longValue));
            this.tweet = new TweetBuilder().setId(longValue).build();
            return;
        }
        throw new IllegalArgumentException("Invalid tw__tweet_id");
    }

    public void applyStyles() {
        setBackgroundColor(this.containerBgColor);
        this.fullNameView.setTextColor(this.primaryTextColor);
        this.screenNameView.setTextColor(this.secondaryTextColor);
        this.contentView.setTextColor(this.primaryTextColor);
        this.tweetMediaView.setMediaBgColor(this.mediaBgColor);
        this.tweetMediaView.setPhotoErrorResId(this.photoErrorResId);
        this.avatarView.setImageDrawable(this.avatarMediaBg);
        this.timestampView.setTextColor(this.secondaryTextColor);
        this.twitterLogoView.setImageResource(this.birdLogoResId);
        this.retweetedByView.setTextColor(this.secondaryTextColor);
    }

    public void findSubviews() {
        super.findSubviews();
        this.avatarView = (ImageView) findViewById(R.id.tw__tweet_author_avatar);
        this.timestampView = (TextView) findViewById(R.id.tw__tweet_timestamp);
        this.twitterLogoView = (ImageView) findViewById(R.id.tw__twitter_logo);
        this.retweetedByView = (TextView) findViewById(R.id.tw__tweet_retweeted_by);
        this.tweetActionBarView = (TweetActionBarView) findViewById(R.id.tw__tweet_action_bar);
        this.quoteTweetHolder = (ViewGroup) findViewById(R.id.quote_tweet_holder);
        this.bottomSeparator = findViewById(R.id.bottom_separator);
    }

    public /* bridge */ /* synthetic */ Tweet getTweet() {
        return super.getTweet();
    }

    public /* bridge */ /* synthetic */ long getTweetId() {
        return super.getTweetId();
    }

    public void linkifyProfilePhotoView(Tweet tweet) {
        if (tweet != null && tweet.user != null) {
            this.avatarView.setOnClickListener(new b(this, tweet));
            this.avatarView.setOnTouchListener(new c(this));
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (isTweetUiEnabled()) {
            initTweetActions();
            loadTweet();
        }
    }

    public void render() {
        super.render();
        Tweet displayTweet = TweetUtils.getDisplayTweet(this.tweet);
        setProfilePhotoView(displayTweet);
        linkifyProfilePhotoView(displayTweet);
        setTimestamp(displayTweet);
        setTweetActions(this.tweet);
        showRetweetedBy(this.tweet);
        setQuoteTweet(this.tweet);
    }

    public void setOnActionCallback(Callback<Tweet> callback) {
        this.tweetActionBarView.setOnActionCallback(new ResetTweetCallback(this, this.dependencyProvider.getTweetUi().getTweetRepository(), callback));
        this.tweetActionBarView.setTweet(this.tweet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r3 = r3.user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProfilePhotoView(com.twitter.sdk.android.core.models.Tweet r3) {
        /*
            r2 = this;
            com.twitter.sdk.android.tweetui.AbstractTweetView$DependencyProvider r0 = r2.dependencyProvider
            com.squareup.picasso.Picasso r0 = r0.getImageLoader()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            if (r3 == 0) goto L_0x0017
            com.twitter.sdk.android.core.models.User r3 = r3.user
            if (r3 != 0) goto L_0x0010
            goto L_0x0017
        L_0x0010:
            com.twitter.sdk.android.core.internal.UserUtils$AvatarSize r1 = com.twitter.sdk.android.core.internal.UserUtils.AvatarSize.REASONABLY_SMALL
            java.lang.String r3 = com.twitter.sdk.android.core.internal.UserUtils.getProfileImageUrlHttps(r3, r1)
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            com.squareup.picasso.r r3 = r0.l(r3)
            android.graphics.drawable.ColorDrawable r0 = r2.avatarMediaBg
            com.squareup.picasso.r r3 = r3.l(r0)
            android.widget.ImageView r0 = r2.avatarView
            r3.g(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.BaseTweetView.setProfilePhotoView(com.twitter.sdk.android.core.models.Tweet):void");
    }

    public void setQuoteTweet(Tweet tweet) {
        this.quoteTweetView = null;
        this.quoteTweetHolder.removeAllViews();
        if (tweet == null || !TweetUtils.showQuoteTweet(tweet)) {
            this.quoteTweetHolder.setVisibility(8);
            return;
        }
        QuoteTweetView quoteTweetView2 = new QuoteTweetView(getContext());
        this.quoteTweetView = quoteTweetView2;
        quoteTweetView2.setStyle(this.primaryTextColor, this.secondaryTextColor, this.actionColor, this.actionHighlightColor, this.mediaBgColor, this.photoErrorResId);
        this.quoteTweetView.setTweet(tweet.quotedStatus);
        this.quoteTweetView.setTweetLinkClickListener(this.tweetLinkClickListener);
        this.quoteTweetView.setTweetMediaClickListener(this.tweetMediaClickListener);
        this.quoteTweetHolder.setVisibility(0);
        this.quoteTweetHolder.addView(this.quoteTweetView);
    }

    public /* bridge */ /* synthetic */ void setTweet(Tweet tweet) {
        super.setTweet(tweet);
    }

    public void setTweetActions(Tweet tweet) {
        this.tweetActionBarView.setTweet(tweet);
    }

    public void setTweetActionsEnabled(boolean z11) {
        this.tweetActionsEnabled = z11;
        if (z11) {
            this.tweetActionBarView.setVisibility(0);
            this.bottomSeparator.setVisibility(8);
            return;
        }
        this.tweetActionBarView.setVisibility(8);
        this.bottomSeparator.setVisibility(0);
    }

    public void setTweetLinkClickListener(TweetLinkClickListener tweetLinkClickListener) {
        super.setTweetLinkClickListener(tweetLinkClickListener);
        QuoteTweetView quoteTweetView2 = this.quoteTweetView;
        if (quoteTweetView2 != null) {
            quoteTweetView2.setTweetLinkClickListener(tweetLinkClickListener);
        }
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener) {
        super.setTweetMediaClickListener(tweetMediaClickListener);
        QuoteTweetView quoteTweetView2 = this.quoteTweetView;
        if (quoteTweetView2 != null) {
            quoteTweetView2.setTweetMediaClickListener(tweetMediaClickListener);
        }
    }

    public void showRetweetedBy(Tweet tweet) {
        if (tweet == null || tweet.retweetedStatus == null) {
            this.retweetedByView.setVisibility(8);
            return;
        }
        this.retweetedByView.setText(getResources().getString(R.string.tw__retweeted_by_format, new Object[]{tweet.user.name}));
        this.retweetedByView.setVisibility(0);
    }

    public BaseTweetView(Context context, Tweet tweet, int i11) {
        this(context, tweet, i11, new AbstractTweetView.DependencyProvider());
    }

    public BaseTweetView(Context context, Tweet tweet, int i11, AbstractTweetView.DependencyProvider dependencyProvider) {
        super(context, (AttributeSet) null, i11, dependencyProvider);
        initAttributes(i11);
        applyStyles();
        if (isTweetUiEnabled()) {
            initTweetActions();
            setTweet(tweet);
        }
    }

    public BaseTweetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseTweetView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11, new AbstractTweetView.DependencyProvider());
        initXmlAttributes(context, attributeSet);
        applyStyles();
    }
}
