package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class OverlayImageView extends ImageView {
    public Overlay overlay = new Overlay((Drawable) null);

    public static class Overlay {
        public final Drawable drawable;

        public Overlay(Drawable drawable2) {
            this.drawable = drawable2;
        }

        public void cleanupDrawable(ImageView imageView) {
            Drawable drawable2 = this.drawable;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                imageView.unscheduleDrawable(this.drawable);
            }
        }

        public void draw(Canvas canvas) {
            Drawable drawable2 = this.drawable;
            if (drawable2 != null) {
                drawable2.draw(canvas);
            }
        }

        public void setDrawableBounds(int i11, int i12) {
            Drawable drawable2 = this.drawable;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, i11, i12);
            }
        }

        public void setDrawableState(int[] iArr) {
            Drawable drawable2 = this.drawable;
            if (drawable2 != null && drawable2.isStateful()) {
                this.drawable.setState(iArr);
            }
        }
    }

    public OverlayImageView(Context context) {
        super(context);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.overlay.setDrawableState(getDrawableState());
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.overlay.drawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.overlay.draw(canvas);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.overlay.setDrawableBounds(getMeasuredWidth(), getMeasuredHeight());
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.overlay.setDrawableBounds(i11, i12);
    }

    public void setOverlayDrawable(Drawable drawable) {
        Overlay overlay2 = this.overlay;
        if (drawable != overlay2.drawable) {
            overlay2.cleanupDrawable(this);
            if (drawable != null) {
                drawable.setCallback(this);
            }
            Overlay overlay3 = new Overlay(drawable);
            this.overlay = overlay3;
            overlay3.setDrawableState(getDrawableState());
            requestLayout();
        }
    }

    public OverlayImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
