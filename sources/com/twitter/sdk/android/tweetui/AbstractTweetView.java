package com.twitter.sdk.android.tweetui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.IntentUtils;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.internal.UserUtils;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.ImageValue;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetui.internal.AspectRatioFrameLayout;
import com.twitter.sdk.android.tweetui.internal.MediaBadgeView;
import com.twitter.sdk.android.tweetui.internal.SpanClickHandler;
import com.twitter.sdk.android.tweetui.internal.TweetMediaUtils;
import com.twitter.sdk.android.tweetui.internal.TweetMediaView;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

abstract class AbstractTweetView extends RelativeLayout {
    public static final double DEFAULT_ASPECT_RATIO = 1.7777777777777777d;
    public static final int DEFAULT_STYLE = R.style.tw__TweetLightStyle;
    public static final String EMPTY_STRING = "";
    public static final long INVALID_ID = -1;
    public static final double MEDIA_BG_DARK_OPACITY = 0.12d;
    public static final double MEDIA_BG_LIGHT_OPACITY = 0.08d;
    public static final double SECONDARY_TEXT_COLOR_DARK_OPACITY = 0.35d;
    public static final double SECONDARY_TEXT_COLOR_LIGHT_OPACITY = 0.4d;
    public static final String TAG = "TweetUi";
    public int actionColor;
    public int actionHighlightColor;
    public TextView contentView;
    public final DependencyProvider dependencyProvider;
    public TextView fullNameView;
    private LinkClickListener linkClickListener;
    public MediaBadgeView mediaBadgeView;
    public int mediaBgColor;
    public AspectRatioFrameLayout mediaContainer;
    private Uri permalinkUri;
    public int photoErrorResId;
    public int primaryTextColor;
    public TextView screenNameView;
    public int secondaryTextColor;
    public int styleResId;
    public Tweet tweet;
    public boolean tweetActionsEnabled;
    public TweetLinkClickListener tweetLinkClickListener;
    public TweetMediaClickListener tweetMediaClickListener;
    public TweetMediaView tweetMediaView;

    public static class DependencyProvider {
        public Picasso getImageLoader() {
            return TweetUi.getInstance().getImageLoader();
        }

        public TweetUi getTweetUi() {
            return TweetUi.getInstance();
        }
    }

    public class PermalinkClickListener implements View.OnClickListener {
        public PermalinkClickListener() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (AbstractTweetView.this.getPermalinkUri() == null) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            AbstractTweetView.this.launchPermalink();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public AbstractTweetView(Context context, AttributeSet attributeSet, int i11, DependencyProvider dependencyProvider2) {
        super(context, attributeSet, i11);
        this.dependencyProvider = dependencyProvider2;
        inflateView(context);
        findSubviews();
    }

    private void inflateView(Context context) {
        LayoutInflater.from(context).inflate(getLayout(), this, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getLinkClickListener$0(String str) {
        if (!TextUtils.isEmpty(str)) {
            TweetLinkClickListener tweetLinkClickListener2 = this.tweetLinkClickListener;
            if (tweetLinkClickListener2 != null) {
                tweetLinkClickListener2.onLinkClick(this.tweet, str);
                return;
            }
            if (!IntentUtils.safeStartActivity(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str)))) {
                Twitter.getLogger().e("TweetUi", "Activity cannot be found to open URL");
            }
        }
    }

    private void setName(Tweet tweet2) {
        User user;
        if (tweet2 == null || (user = tweet2.user) == null) {
            this.fullNameView.setText("");
        } else {
            this.fullNameView.setText(Utils.stringOrEmpty(user.name));
        }
    }

    private void setPermalinkLauncher() {
        setOnClickListener(new PermalinkClickListener());
    }

    private void setScreenName(Tweet tweet2) {
        User user;
        if (tweet2 == null || (user = tweet2.user) == null) {
            this.screenNameView.setText("");
        } else {
            this.screenNameView.setText(UserUtils.formatScreenName(Utils.stringOrEmpty(user.screenName)));
        }
    }

    @TargetApi(16)
    private void setText(Tweet tweet2) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.contentView.setImportantForAccessibility(2);
        }
        CharSequence charSeqOrEmpty = Utils.charSeqOrEmpty(getLinkifiedText(tweet2));
        SpanClickHandler.enableClicksOnSpans(this.contentView);
        if (!TextUtils.isEmpty(charSeqOrEmpty)) {
            this.contentView.setText(charSeqOrEmpty);
            this.contentView.setVisibility(0);
            return;
        }
        this.contentView.setText("");
        this.contentView.setVisibility(8);
    }

    public void clearTweetMedia() {
        this.mediaContainer.setVisibility(8);
    }

    public void findSubviews() {
        this.fullNameView = (TextView) findViewById(R.id.tw__tweet_author_full_name);
        this.screenNameView = (TextView) findViewById(R.id.tw__tweet_author_screen_name);
        this.mediaContainer = (AspectRatioFrameLayout) findViewById(R.id.tw__aspect_ratio_media_container);
        this.tweetMediaView = (TweetMediaView) findViewById(R.id.tweet_media_view);
        this.contentView = (TextView) findViewById(R.id.tw__tweet_text);
        this.mediaBadgeView = (MediaBadgeView) findViewById(R.id.tw__tweet_media_badge);
    }

    public double getAspectRatio(MediaEntity mediaEntity) {
        MediaEntity.Sizes sizes;
        MediaEntity.Size size;
        int i11;
        int i12;
        if (mediaEntity == null || (sizes = mediaEntity.sizes) == null || (size = sizes.medium) == null || (i11 = size.f51195w) == 0 || (i12 = size.f51194h) == 0) {
            return 1.7777777777777777d;
        }
        return ((double) i11) / ((double) i12);
    }

    public abstract double getAspectRatioForPhotoEntity(int i11);

    public abstract int getLayout();

    public LinkClickListener getLinkClickListener() {
        if (this.linkClickListener == null) {
            this.linkClickListener = new a(this);
        }
        return this.linkClickListener;
    }

    public CharSequence getLinkifiedText(Tweet tweet2) {
        FormattedTweetText formatTweetText = this.dependencyProvider.getTweetUi().getTweetRepository().formatTweetText(tweet2);
        if (formatTweetText == null) {
            return null;
        }
        Card card = tweet2.card;
        boolean z11 = card != null && VineCardUtils.isVine(card);
        return TweetTextLinkifier.linkifyUrls(formatTweetText, getLinkClickListener(), this.actionColor, this.actionHighlightColor, TweetUtils.showQuoteTweet(tweet2), z11);
    }

    public Uri getPermalinkUri() {
        return this.permalinkUri;
    }

    public Tweet getTweet() {
        return this.tweet;
    }

    public long getTweetId() {
        Tweet tweet2 = this.tweet;
        if (tweet2 == null) {
            return -1;
        }
        return tweet2.f51198id;
    }

    public boolean isTweetUiEnabled() {
        if (isInEditMode()) {
            return false;
        }
        try {
            this.dependencyProvider.getTweetUi();
            return true;
        } catch (IllegalStateException e11) {
            Twitter.getLogger().e("TweetUi", e11.getMessage());
            setEnabled(false);
            return false;
        }
    }

    public void launchPermalink() {
        if (!IntentUtils.safeStartActivity(getContext(), new Intent("android.intent.action.VIEW", getPermalinkUri()))) {
            Twitter.getLogger().e("TweetUi", "Activity cannot be found to open permalink URI");
        }
    }

    public void render() {
        Tweet displayTweet = TweetUtils.getDisplayTweet(this.tweet);
        setName(displayTweet);
        setScreenName(displayTweet);
        setTweetMedia(displayTweet);
        setText(displayTweet);
        setContentDescription(displayTweet);
        if (TweetUtils.isTweetResolvable(this.tweet)) {
            setPermalinkUri(this.tweet.user.screenName, Long.valueOf(getTweetId()));
        } else {
            this.permalinkUri = null;
        }
        setPermalinkLauncher();
    }

    public void setContentDescription(Tweet tweet2) {
        if (!TweetUtils.isTweetResolvable(tweet2)) {
            setContentDescription(getResources().getString(R.string.tw__loading_tweet));
            return;
        }
        FormattedTweetText formatTweetText = this.dependencyProvider.getTweetUi().getTweetRepository().formatTweetText(tweet2);
        String str = null;
        String str2 = formatTweetText != null ? formatTweetText.text : null;
        long apiTimeToLong = TweetDateUtils.apiTimeToLong(tweet2.createdAt);
        if (apiTimeToLong != -1) {
            str = DateFormat.getDateInstance().format(new Date(apiTimeToLong));
        }
        setContentDescription(getResources().getString(R.string.tw__tweet_content_description, new Object[]{Utils.stringOrEmpty(tweet2.user.name), Utils.stringOrEmpty(str2), Utils.stringOrEmpty(str)}));
    }

    public void setPermalinkUri(String str, Long l11) {
        if (l11.longValue() > 0) {
            this.permalinkUri = TweetUtils.getPermalink(str, l11.longValue());
        }
    }

    public void setTweet(Tweet tweet2) {
        this.tweet = tweet2;
        render();
    }

    public void setTweetLinkClickListener(TweetLinkClickListener tweetLinkClickListener2) {
        this.tweetLinkClickListener = tweetLinkClickListener2;
    }

    public final void setTweetMedia(Tweet tweet2) {
        clearTweetMedia();
        if (tweet2 != null) {
            Card card = tweet2.card;
            if (card != null && VineCardUtils.isVine(card)) {
                Card card2 = tweet2.card;
                ImageValue imageValue = VineCardUtils.getImageValue(card2);
                String streamUrl = VineCardUtils.getStreamUrl(card2);
                if (imageValue != null && !TextUtils.isEmpty(streamUrl)) {
                    setViewsForMedia(getAspectRatio(imageValue));
                    this.tweetMediaView.setVineCard(tweet2);
                    this.mediaBadgeView.setVisibility(0);
                    this.mediaBadgeView.setCard(card2);
                }
            } else if (TweetMediaUtils.hasSupportedVideo(tweet2)) {
                MediaEntity videoEntity = TweetMediaUtils.getVideoEntity(tweet2);
                setViewsForMedia(getAspectRatio(videoEntity));
                this.tweetMediaView.setTweetMediaEntities(this.tweet, Collections.singletonList(videoEntity));
                this.mediaBadgeView.setVisibility(0);
                this.mediaBadgeView.setMediaEntity(videoEntity);
            } else if (TweetMediaUtils.hasPhoto(tweet2)) {
                List<MediaEntity> photoEntities = TweetMediaUtils.getPhotoEntities(tweet2);
                setViewsForMedia(getAspectRatioForPhotoEntity(photoEntities.size()));
                this.tweetMediaView.setTweetMediaEntities(tweet2, photoEntities);
                this.mediaBadgeView.setVisibility(8);
            }
        }
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener2) {
        this.tweetMediaClickListener = tweetMediaClickListener2;
        this.tweetMediaView.setTweetMediaClickListener(tweetMediaClickListener2);
    }

    public void setViewsForMedia(double d11) {
        this.mediaContainer.setVisibility(0);
        this.mediaContainer.setAspectRatio(d11);
        this.tweetMediaView.setVisibility(0);
    }

    public double getAspectRatio(ImageValue imageValue) {
        int i11;
        int i12;
        if (imageValue == null || (i11 = imageValue.width) == 0 || (i12 = imageValue.height) == 0) {
            return 1.7777777777777777d;
        }
        return ((double) i11) / ((double) i12);
    }
}
