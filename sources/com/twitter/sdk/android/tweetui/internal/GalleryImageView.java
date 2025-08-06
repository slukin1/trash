package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.v;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;

public class GalleryImageView extends FrameLayout implements v {
    public final MultiTouchImageView imageView;
    public final ProgressBar progressBar;

    public GalleryImageView(Context context) {
        this(context, new MultiTouchImageView(context), new ProgressBar(context));
    }

    public void onBitmapFailed(Drawable drawable) {
    }

    public abstract /* synthetic */ void onBitmapFailed(Exception exc, Drawable drawable);

    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        this.imageView.setImageBitmap(bitmap);
        this.progressBar.setVisibility(8);
    }

    public void onPrepareLoad(Drawable drawable) {
        this.imageView.setImageResource(17170445);
        this.progressBar.setVisibility(0);
    }

    public void setSwipeToDismissCallback(SwipeToDismissTouchListener.Callback callback) {
        this.imageView.setOnTouchListener(SwipeToDismissTouchListener.createFromView(this.imageView, callback));
    }

    public GalleryImageView(Context context, MultiTouchImageView multiTouchImageView, ProgressBar progressBar2) {
        super(context);
        this.imageView = multiTouchImageView;
        this.progressBar = progressBar2;
        progressBar2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(progressBar2);
        multiTouchImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        addView(multiTouchImageView);
    }
}
