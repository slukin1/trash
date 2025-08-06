package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.huobi.view.roundimg.RoundedDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.IntentUtils;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.ImageValue;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.GalleryActivity;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.R;
import com.twitter.sdk.android.tweetui.TweetMediaClickListener;
import com.twitter.sdk.android.tweetui.TweetUi;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class TweetMediaView extends ViewGroup implements View.OnClickListener {
    public static final int MAX_IMAGE_VIEW_COUNT = 4;
    public static final String SIZED_IMAGE_SMALL = ":small";
    public final DependencyProvider dependencyProvider;
    private int imageCount;
    private final OverlayImageView[] imageViews;
    public boolean internalRoundedCornersEnabled;
    public int mediaBgColor;
    private final int mediaDividerSize;
    private List<MediaEntity> mediaEntities;
    private final Path path;
    public int photoErrorResId;
    public final float[] radii;
    private final RectF rect;
    public Tweet tweet;
    public TweetMediaClickListener tweetMediaClickListener;

    public static class DependencyProvider {
        public Picasso getImageLoader() {
            return TweetUi.getInstance().getImageLoader();
        }
    }

    public static class PicassoCallback implements Callback {
        public final WeakReference<ImageView> imageViewWeakReference;

        public PicassoCallback(ImageView imageView) {
            this.imageViewWeakReference = new WeakReference<>(imageView);
        }

        public void onError() {
        }

        public abstract /* synthetic */ void onError(Exception exc);

        public void onSuccess() {
            ImageView imageView = (ImageView) this.imageViewWeakReference.get();
            if (imageView != null) {
                imageView.setBackgroundResource(17170445);
            }
        }
    }

    public static class Size {
        public static final Size EMPTY = new Size();
        public final int height;
        public final int width;

        private Size() {
            this(0, 0);
        }

        public static Size fromSize(int i11, int i12) {
            int max = Math.max(i11, 0);
            int max2 = Math.max(i12, 0);
            return (max == 0 && max2 == 0) ? EMPTY : new Size(max, max2);
        }

        private Size(int i11, int i12) {
            this.width = i11;
            this.height = i12;
        }
    }

    public TweetMediaView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void clearImageViews() {
        for (int i11 = 0; i11 < this.imageCount; i11++) {
            OverlayImageView overlayImageView = this.imageViews[i11];
            if (overlayImageView != null) {
                overlayImageView.setVisibility(8);
            }
        }
        this.imageCount = 0;
    }

    public void dispatchDraw(Canvas canvas) {
        if (!this.internalRoundedCornersEnabled || Build.VERSION.SDK_INT < 18) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    public OverlayImageView getOrCreateImageView(int i11) {
        OverlayImageView overlayImageView = this.imageViews[i11];
        if (overlayImageView == null) {
            overlayImageView = new OverlayImageView(getContext());
            overlayImageView.setLayoutParams(generateDefaultLayoutParams());
            overlayImageView.setOnClickListener(this);
            this.imageViews[i11] = overlayImageView;
            addView(overlayImageView, i11);
        } else {
            measureImageView(i11, 0, 0);
            layoutImage(i11, 0, 0, 0, 0);
        }
        overlayImageView.setVisibility(0);
        overlayImageView.setBackgroundColor(this.mediaBgColor);
        overlayImageView.setTag(R.id.tw__entity_index, Integer.valueOf(i11));
        return overlayImageView;
    }

    public String getSizedImagePath(MediaEntity mediaEntity) {
        if (this.imageCount <= 1) {
            return mediaEntity.mediaUrlHttps;
        }
        return mediaEntity.mediaUrlHttps + SIZED_IMAGE_SMALL;
    }

    public void initializeImageViews(List<MediaEntity> list) {
        this.imageCount = Math.min(4, list.size());
        for (int i11 = 0; i11 < this.imageCount; i11++) {
            OverlayImageView orCreateImageView = getOrCreateImageView(i11);
            MediaEntity mediaEntity = list.get(i11);
            setAltText(orCreateImageView, mediaEntity.altText);
            setMediaImage(orCreateImageView, getSizedImagePath(mediaEntity));
            setOverlayImage(orCreateImageView, TweetMediaUtils.isVideoType(mediaEntity));
        }
    }

    public void launchPhotoGallery(int i11) {
        Intent intent = new Intent(getContext(), GalleryActivity.class);
        intent.putExtra(GalleryActivity.GALLERY_ITEM, new GalleryActivity.GalleryItem(this.tweet.f51198id, i11, this.mediaEntities));
        IntentUtils.safeStartActivity(getContext(), intent);
    }

    public void launchVideoPlayer(MediaEntity mediaEntity) {
        if (TweetMediaUtils.getSupportedVariant(mediaEntity) != null) {
            Intent intent = new Intent(getContext(), PlayerActivity.class);
            intent.putExtra(PlayerActivity.PLAYER_ITEM, new PlayerActivity.PlayerItem(TweetMediaUtils.getSupportedVariant(mediaEntity).url, TweetMediaUtils.isLooping(mediaEntity), TweetMediaUtils.showVideoControls(mediaEntity), (String) null, (String) null));
            IntentUtils.safeStartActivity(getContext(), intent);
        }
    }

    public void layoutImage(int i11, int i12, int i13, int i14, int i15) {
        OverlayImageView overlayImageView = this.imageViews[i11];
        if (overlayImageView.getLeft() != i12 || overlayImageView.getTop() != i13 || overlayImageView.getRight() != i14 || overlayImageView.getBottom() != i15) {
            overlayImageView.layout(i12, i13, i14, i15);
        }
    }

    public void layoutImages() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i11 = this.mediaDividerSize;
        int i12 = (measuredWidth - i11) / 2;
        int i13 = (measuredHeight - i11) / 2;
        int i14 = i12 + i11;
        int i15 = this.imageCount;
        if (i15 == 1) {
            layoutImage(0, 0, 0, measuredWidth, measuredHeight);
        } else if (i15 == 2) {
            int i16 = measuredHeight;
            layoutImage(0, 0, 0, i12, i16);
            layoutImage(1, i12 + this.mediaDividerSize, 0, measuredWidth, i16);
        } else if (i15 == 3) {
            layoutImage(0, 0, 0, i12, measuredHeight);
            int i17 = i14;
            int i18 = measuredWidth;
            layoutImage(1, i17, 0, i18, i13);
            layoutImage(2, i17, i13 + this.mediaDividerSize, i18, measuredHeight);
        } else if (i15 == 4) {
            int i19 = i12;
            layoutImage(0, 0, 0, i19, i13);
            layoutImage(2, 0, i13 + this.mediaDividerSize, i19, measuredHeight);
            int i21 = i14;
            int i22 = measuredWidth;
            layoutImage(1, i21, 0, i22, i13);
            layoutImage(3, i21, i13 + this.mediaDividerSize, i22, measuredHeight);
        }
    }

    public void measureImageView(int i11, int i12, int i13) {
        this.imageViews[i11].measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
    }

    public Size measureImages(int i11, int i12) {
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int i13 = this.mediaDividerSize;
        int i14 = (size - i13) / 2;
        int i15 = (size2 - i13) / 2;
        int i16 = this.imageCount;
        if (i16 == 1) {
            measureImageView(0, size, size2);
        } else if (i16 == 2) {
            measureImageView(0, i14, size2);
            measureImageView(1, i14, size2);
        } else if (i16 == 3) {
            measureImageView(0, i14, size2);
            measureImageView(1, i14, i15);
            measureImageView(2, i14, i15);
        } else if (i16 == 4) {
            measureImageView(0, i14, i15);
            measureImageView(1, i14, i15);
            measureImageView(2, i14, i15);
            measureImageView(3, i14, i15);
        }
        return Size.fromSize(size, size2);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Integer num = (Integer) view.getTag(R.id.tw__entity_index);
        if (this.tweetMediaClickListener != null) {
            this.tweetMediaClickListener.onMediaEntityClick(this.tweet, !this.mediaEntities.isEmpty() ? this.mediaEntities.get(num.intValue()) : null);
        } else if (!this.mediaEntities.isEmpty()) {
            MediaEntity mediaEntity = this.mediaEntities.get(num.intValue());
            if (TweetMediaUtils.isVideoType(mediaEntity)) {
                launchVideoPlayer(mediaEntity);
            } else if (TweetMediaUtils.isPhotoType(mediaEntity)) {
                launchPhotoGallery(num.intValue());
            }
        } else {
            launchVideoPlayer(this.tweet);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        if (this.imageCount > 0) {
            layoutImages();
        }
    }

    public void onMeasure(int i11, int i12) {
        Size size;
        if (this.imageCount > 0) {
            size = measureImages(i11, i12);
        } else {
            size = Size.EMPTY;
        }
        setMeasuredDimension(size.width, size.height);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.path.reset();
        this.rect.set(0.0f, 0.0f, (float) i11, (float) i12);
        this.path.addRoundRect(this.rect, this.radii, Path.Direction.CW);
        this.path.close();
    }

    public void setAltText(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            imageView.setContentDescription(str);
        } else {
            imageView.setContentDescription(getResources().getString(R.string.tw__tweet_media));
        }
    }

    public void setMediaBgColor(int i11) {
        this.mediaBgColor = i11;
    }

    public void setMediaImage(ImageView imageView, String str) {
        Picasso imageLoader = this.dependencyProvider.getImageLoader();
        if (imageLoader != null) {
            imageLoader.l(str).e().a().d(this.photoErrorResId).h(imageView, new PicassoCallback(imageView));
        }
    }

    public void setOverlayImage(OverlayImageView overlayImageView, boolean z11) {
        if (z11) {
            overlayImageView.setOverlayDrawable(getContext().getResources().getDrawable(R.drawable.tw__player_overlay));
        } else {
            overlayImageView.setOverlayDrawable((Drawable) null);
        }
    }

    public void setPhotoErrorResId(int i11) {
        this.photoErrorResId = i11;
    }

    public void setRoundedCornersRadii(int i11, int i12, int i13, int i14) {
        float[] fArr = this.radii;
        float f11 = (float) i11;
        fArr[0] = f11;
        fArr[1] = f11;
        float f12 = (float) i12;
        fArr[2] = f12;
        fArr[3] = f12;
        float f13 = (float) i13;
        fArr[4] = f13;
        fArr[5] = f13;
        float f14 = (float) i14;
        fArr[6] = f14;
        fArr[7] = f14;
        requestLayout();
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener2) {
        this.tweetMediaClickListener = tweetMediaClickListener2;
    }

    public void setTweetMediaEntities(Tweet tweet2, List<MediaEntity> list) {
        if (tweet2 != null && list != null && !list.isEmpty() && !list.equals(this.mediaEntities)) {
            this.tweet = tweet2;
            this.mediaEntities = list;
            clearImageViews();
            initializeImageViews(list);
            this.internalRoundedCornersEnabled = TweetMediaUtils.isPhotoType(list.get(0));
            requestLayout();
        }
    }

    public void setVineCard(Tweet tweet2) {
        Card card;
        if (tweet2 != null && (card = tweet2.card) != null && VineCardUtils.isVine(card)) {
            this.tweet = tweet2;
            this.mediaEntities = Collections.emptyList();
            clearImageViews();
            initializeImageViews(tweet2.card);
            this.internalRoundedCornersEnabled = false;
            requestLayout();
        }
    }

    public TweetMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new DependencyProvider());
    }

    public TweetMediaView(Context context, AttributeSet attributeSet, DependencyProvider dependencyProvider2) {
        super(context, attributeSet);
        this.imageViews = new OverlayImageView[4];
        this.mediaEntities = Collections.emptyList();
        this.path = new Path();
        this.rect = new RectF();
        this.radii = new float[8];
        this.mediaBgColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.dependencyProvider = dependencyProvider2;
        this.mediaDividerSize = getResources().getDimensionPixelSize(R.dimen.tw__media_view_divider_size);
        this.photoErrorResId = R.drawable.tw__ic_tweet_photo_error_dark;
    }

    public void initializeImageViews(Card card) {
        this.imageCount = 1;
        OverlayImageView orCreateImageView = getOrCreateImageView(0);
        ImageValue imageValue = VineCardUtils.getImageValue(card);
        setAltText(orCreateImageView, imageValue.alt);
        setMediaImage(orCreateImageView, imageValue.url);
        setOverlayImage(orCreateImageView, true);
    }

    public void launchVideoPlayer(Tweet tweet2) {
        Card card = tweet2.card;
        Intent intent = new Intent(getContext(), PlayerActivity.class);
        intent.putExtra(PlayerActivity.PLAYER_ITEM, new PlayerActivity.PlayerItem(VineCardUtils.getStreamUrl(card), true, false, (String) null, (String) null));
        IntentUtils.safeStartActivity(getContext(), intent);
    }
}
