package com.sumsub.sns.core.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import com.sumsub.sns.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J(\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSFrameDrawable;", "Landroid/graphics/drawable/Drawable;", "frame", "fillColor", "", "paddingLeft", "", "paddingRight", "paddingTop", "paddingBottom", "(Landroid/graphics/drawable/Drawable;IFFFF)V", "border", "buffer", "Landroid/graphics/Bitmap;", "mask", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "redrawBuffer", "setAlpha", "alpha", "setBounds", "left", "top", "right", "bottom", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setFillColor", "color", "setStroke", "width", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSFrameDrawable extends Drawable {
    private final Drawable border;
    private Bitmap buffer;
    private int fillColor;
    private final Drawable mask;
    private final float paddingBottom;
    private final float paddingLeft;
    private final float paddingRight;
    private final float paddingTop;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSFrameDrawable(Drawable drawable, int i11, float f11, float f12, float f13, float f14, int i12, r rVar) {
        this(drawable, i11, (i12 & 4) != 0 ? 0.0f : f11, (i12 & 8) != 0 ? 0.0f : f12, (i12 & 16) != 0 ? 0.0f : f13, (i12 & 32) != 0 ? 0.0f : f14);
    }

    private final void redrawBuffer() {
        int i11;
        Bitmap bitmap;
        Pair pair;
        int i12 = getBounds().left;
        int i13 = getBounds().right;
        int i14 = getBounds().top;
        int i15 = getBounds().bottom;
        Drawable drawable = this.mask;
        boolean z11 = true;
        if (drawable != null) {
            float c11 = RangesKt___RangesKt.c((((float) (i13 - i12)) - this.paddingLeft) - this.paddingRight, 0.0f);
            float c12 = RangesKt___RangesKt.c((((float) (i15 - i14)) - this.paddingTop) - this.paddingBottom, 0.0f);
            if (c12 / ((float) RangesKt___RangesKt.d(drawable.getIntrinsicHeight(), 1)) > c11 / ((float) RangesKt___RangesKt.d(drawable.getIntrinsicWidth(), 1))) {
                pair = l.a(Float.valueOf(c11), Float.valueOf((((float) drawable.getIntrinsicHeight()) * c11) / ((float) RangesKt___RangesKt.d(drawable.getIntrinsicWidth(), 1))));
            } else {
                pair = l.a(Float.valueOf((((float) drawable.getIntrinsicWidth()) * c12) / ((float) RangesKt___RangesKt.d(drawable.getIntrinsicHeight(), 1))), Float.valueOf(c12));
            }
            float floatValue = ((Number) pair.component1()).floatValue();
            float floatValue2 = ((Number) pair.component2()).floatValue();
            float f11 = (float) 2;
            float f12 = ((float) i12) + ((c11 - floatValue) / f11) + this.paddingLeft;
            float f13 = ((float) i14) + ((c12 - floatValue2) / f11) + this.paddingTop;
            drawable.setBounds((int) f12, (int) f13, (int) (f12 + floatValue), (int) (f13 + floatValue2));
            Drawable drawable2 = this.border;
            if (drawable2 != null) {
                drawable2.setBounds(drawable.getBounds());
            }
        }
        int i16 = i13 - i12;
        if (i16 > 0 && (i11 = i15 - i14) > 0) {
            Bitmap bitmap2 = this.buffer;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                z11 = false;
            }
            if (z11 && (bitmap = this.buffer) != null) {
                bitmap.recycle();
            }
            Bitmap createBitmap = Bitmap.createBitmap(i16, i11, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Drawable drawable3 = this.mask;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
            canvas.drawColor(this.fillColor, PorterDuff.Mode.SRC_OUT);
            Drawable drawable4 = this.border;
            if (drawable4 != null) {
                drawable4.draw(canvas);
            }
            this.buffer = createBitmap;
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.buffer;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (float) getBounds().left, (float) getBounds().top, (Paint) null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i11) {
        invalidateSelf();
    }

    public void setBounds(int i11, int i12, int i13, int i14) {
        super.setBounds(i11, i12, i13, i14);
        redrawBuffer();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        invalidateSelf();
    }

    public final void setFillColor(int i11) {
        this.fillColor = i11;
        redrawBuffer();
        invalidateSelf();
    }

    public final void setStroke(int i11, int i12) {
        Drawable drawable = this.border;
        GradientDrawable gradientDrawable = drawable instanceof GradientDrawable ? (GradientDrawable) drawable : null;
        if (gradientDrawable != null) {
            gradientDrawable.setStroke(i11, i12);
        }
        redrawBuffer();
        invalidateSelf();
    }

    public SNSFrameDrawable(Drawable drawable, int i11, float f11, float f12, float f13, float f14) {
        Drawable findDrawableByLayerId;
        this.fillColor = i11;
        this.paddingLeft = f11;
        this.paddingRight = f12;
        this.paddingTop = f13;
        this.paddingBottom = f14;
        boolean z11 = drawable instanceof LayerDrawable;
        LayerDrawable layerDrawable = null;
        LayerDrawable layerDrawable2 = z11 ? (LayerDrawable) drawable : null;
        this.border = layerDrawable2 != null ? layerDrawable2.findDrawableByLayerId(R.id.sns_frame_border) : null;
        layerDrawable = z11 ? (LayerDrawable) drawable : layerDrawable;
        if (!(layerDrawable == null || (findDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.sns_frame_mask)) == null)) {
            drawable = findDrawableByLayerId;
        }
        this.mask = drawable;
    }
}
