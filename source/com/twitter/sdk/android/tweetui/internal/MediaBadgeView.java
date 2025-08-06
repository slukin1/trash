package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.VideoInfo;
import com.twitter.sdk.android.tweetui.R;

public class MediaBadgeView extends FrameLayout {
    public ImageView badge;
    public TextView videoDuration;

    public MediaBadgeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void initSubViews(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.tw__media_badge, this, true);
        this.videoDuration = (TextView) inflate.findViewById(R.id.tw__video_duration);
        this.badge = (ImageView) inflate.findViewById(R.id.tw__gif_badge);
    }

    public void setBadge(Drawable drawable) {
        this.badge.setVisibility(0);
        this.videoDuration.setVisibility(8);
        this.badge.setImageDrawable(drawable);
    }

    public void setCard(Card card) {
        if (VineCardUtils.isVine(card)) {
            setBadge(getResources().getDrawable(R.drawable.tw__vine_badge));
        } else {
            setEmpty();
        }
    }

    public void setEmpty() {
        this.videoDuration.setVisibility(8);
        this.badge.setVisibility(8);
    }

    public void setMediaEntity(MediaEntity mediaEntity) {
        if (TweetMediaUtils.GIF_TYPE.equals(mediaEntity.type)) {
            setBadge(getResources().getDrawable(R.drawable.tw__gif_badge));
        } else if ("video".equals(mediaEntity.type)) {
            VideoInfo videoInfo = mediaEntity.videoInfo;
            setText(videoInfo == null ? 0 : videoInfo.durationMillis);
        } else {
            setEmpty();
        }
    }

    public void setText(long j11) {
        this.videoDuration.setVisibility(0);
        this.badge.setVisibility(8);
        this.videoDuration.setText(MediaTimeUtils.getPlaybackTime(j11));
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaBadgeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initSubViews(context);
    }
}
