package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.util.AttributeSet;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.AbstractTweetView;

public class CompactTweetView extends BaseTweetView {
    private static final double DEFAULT_ASPECT_RATIO_MEDIA_CONTAINER = 1.6d;
    private static final double MAX_LANDSCAPE_ASPECT_RATIO = 3.0d;
    private static final double MIN_LANDSCAPE_ASPECT_RATIO = 1.3333333333333333d;
    private static final double SQUARE_ASPECT_RATIO = 1.0d;

    public CompactTweetView(Context context, Tweet tweet) {
        super(context, tweet);
    }

    public void applyStyles() {
        super.applyStyles();
        setPadding(0, getResources().getDimensionPixelSize(R.dimen.tw__compact_tweet_container_padding_top), 0, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tw__media_view_radius);
        this.tweetMediaView.setRoundedCornersRadii(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    public double getAspectRatio(MediaEntity mediaEntity) {
        double aspectRatio = super.getAspectRatio(mediaEntity);
        if (aspectRatio <= 1.0d) {
            return 1.0d;
        }
        if (aspectRatio > MAX_LANDSCAPE_ASPECT_RATIO) {
            return MAX_LANDSCAPE_ASPECT_RATIO;
        }
        return aspectRatio < MIN_LANDSCAPE_ASPECT_RATIO ? MIN_LANDSCAPE_ASPECT_RATIO : aspectRatio;
    }

    public double getAspectRatioForPhotoEntity(int i11) {
        return DEFAULT_ASPECT_RATIO_MEDIA_CONTAINER;
    }

    public int getLayout() {
        return R.layout.tw__tweet_compact;
    }

    public void render() {
        super.render();
        this.screenNameView.requestLayout();
    }

    public CompactTweetView(Context context, Tweet tweet, int i11) {
        super(context, tweet, i11);
    }

    public CompactTweetView(Context context, Tweet tweet, int i11, AbstractTweetView.DependencyProvider dependencyProvider) {
        super(context, tweet, i11, dependencyProvider);
    }

    public CompactTweetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CompactTweetView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
