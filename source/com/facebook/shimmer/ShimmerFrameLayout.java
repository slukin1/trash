package com.facebook.shimmer;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.shimmer.Shimmer;
import com.huobi.R$styleable;

public class ShimmerFrameLayout extends FrameLayout {
    private final Paint mContentPaint = new Paint();
    private final RectF mDrawRect = new RectF();
    private Shimmer mShimmer;
    private final Paint mShimmerPaint = new Paint();
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerFrameLayout.this.postInvalidate();
        }
    };
    private ValueAnimator mValueAnimator;

    public ShimmerFrameLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void drawShimmer(Canvas canvas) {
        float f11;
        float offset;
        float width = (float) getWidth();
        float height = (float) getHeight();
        ValueAnimator valueAnimator = this.mValueAnimator;
        float f12 = 0.0f;
        float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
        int i11 = this.mShimmer.direction;
        if (i11 != 1) {
            if (i11 == 2) {
                offset = offset(width, -width, animatedFraction);
            } else if (i11 != 3) {
                offset = offset(-width, width, animatedFraction);
            } else {
                f11 = offset(height, -height, animatedFraction);
            }
            f12 = offset;
            f11 = 0.0f;
        } else {
            f11 = offset(-height, height, animatedFraction);
        }
        int save = canvas.save();
        canvas.translate(f12, f11);
        canvas.rotate(this.mShimmer.tilt, width / 2.0f, height / 2.0f);
        canvas.drawRect(this.mDrawRect, this.mShimmerPaint);
        canvas.restoreToCount(save);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Shimmer.Builder builder;
        setWillNotDraw(false);
        this.mShimmerPaint.setAntiAlias(true);
        if (attributeSet == null) {
            setShimmer(new Shimmer.AlphaHighlightBuilder().build());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShimmerFrameLayout, 0, 0);
        try {
            if (!obtainStyledAttributes.hasValue(4) || !obtainStyledAttributes.getBoolean(4, false)) {
                builder = new Shimmer.AlphaHighlightBuilder();
            } else {
                builder = new Shimmer.ColorHighlightBuilder();
            }
            setShimmer(builder.consumeAttributes(obtainStyledAttributes).build());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void maybeStartShimmer() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && !valueAnimator.isStarted() && this.mShimmer.autoStart) {
            this.mValueAnimator.start();
        }
    }

    private float offset(float f11, float f12, float f13) {
        return f11 + ((f12 - f11) * f13);
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r12v1, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r3v8, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateShader() {
        /*
            r19 = this;
            r0 = r19
            int r1 = r19.getWidth()
            int r2 = r19.getHeight()
            if (r1 == 0) goto L_0x007b
            if (r2 != 0) goto L_0x0010
            goto L_0x007b
        L_0x0010:
            com.facebook.shimmer.Shimmer r1 = r0.mShimmer
            int r2 = r19.getWidth()
            int r1 = r1.width(r2)
            com.facebook.shimmer.Shimmer r2 = r0.mShimmer
            int r3 = r19.getHeight()
            int r2 = r2.height(r3)
            com.facebook.shimmer.Shimmer r3 = r0.mShimmer
            int r4 = r3.shape
            r5 = 1
            if (r4 == r5) goto L_0x004f
            int r3 = r3.direction
            r4 = 0
            if (r3 == r5) goto L_0x0035
            r6 = 3
            if (r3 != r6) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r5 = r4
        L_0x0035:
            if (r5 == 0) goto L_0x0038
            r1 = r4
        L_0x0038:
            if (r5 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r2 = r4
        L_0x003c:
            android.graphics.LinearGradient r11 = new android.graphics.LinearGradient
            r4 = 0
            r5 = 0
            float r6 = (float) r1
            float r7 = (float) r2
            com.facebook.shimmer.Shimmer r1 = r0.mShimmer
            int[] r8 = r1.colors
            float[] r9 = r1.positions
            android.graphics.Shader$TileMode r10 = android.graphics.Shader.TileMode.CLAMP
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0076
        L_0x004f:
            android.graphics.RadialGradient r11 = new android.graphics.RadialGradient
            float r3 = (float) r1
            r4 = 1073741824(0x40000000, float:2.0)
            float r13 = r3 / r4
            float r3 = (float) r2
            float r14 = r3 / r4
            int r1 = java.lang.Math.max(r1, r2)
            double r1 = (double) r1
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r3 = java.lang.Math.sqrt(r3)
            double r1 = r1 / r3
            float r15 = (float) r1
            com.facebook.shimmer.Shimmer r1 = r0.mShimmer
            int[] r2 = r1.colors
            float[] r1 = r1.positions
            android.graphics.Shader$TileMode r18 = android.graphics.Shader.TileMode.CLAMP
            r12 = r11
            r16 = r2
            r17 = r1
            r12.<init>(r13, r14, r15, r16, r17, r18)
        L_0x0076:
            android.graphics.Paint r1 = r0.mShimmerPaint
            r1.setShader(r11)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.shimmer.ShimmerFrameLayout.updateShader():void");
    }

    private void updateValueAnimator() {
        boolean z11;
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            z11 = valueAnimator.isStarted();
            this.mValueAnimator.cancel();
            this.mValueAnimator.removeAllUpdateListeners();
        } else {
            z11 = false;
        }
        Shimmer shimmer = this.mShimmer;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, ((float) (shimmer.repeatDelay / shimmer.animationDuration)) + 1.0f});
        this.mValueAnimator = ofFloat;
        ofFloat.setRepeatMode(this.mShimmer.repeatMode);
        this.mValueAnimator.setRepeatCount(this.mShimmer.repeatCount);
        ValueAnimator valueAnimator2 = this.mValueAnimator;
        Shimmer shimmer2 = this.mShimmer;
        valueAnimator2.setDuration(shimmer2.animationDuration + shimmer2.repeatDelay);
        this.mValueAnimator.addUpdateListener(this.mUpdateListener);
        if (z11) {
            this.mValueAnimator.start();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawShimmer(canvas);
    }

    public boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeStartShimmer();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        int width = getWidth();
        int height = getHeight();
        this.mShimmer.updateBounds(width, height);
        this.mDrawRect.set((float) ((-width) * 2), (float) ((-height) * 2), (float) (width * 4), (float) (height * 4));
        updateShader();
        maybeStartShimmer();
    }

    public ShimmerFrameLayout setShimmer(Shimmer shimmer) {
        if (shimmer != null) {
            this.mShimmer = shimmer;
            if (shimmer.clipToChildren) {
                setLayerType(2, this.mContentPaint);
            } else {
                setLayerType(0, (Paint) null);
            }
            this.mShimmerPaint.setXfermode(new PorterDuffXfermode(this.mShimmer.alphaShimmer ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
            updateShader();
            updateValueAnimator();
            postInvalidate();
            return this;
        }
        throw new IllegalArgumentException("Given null shimmer");
    }

    public void startShimmer() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && !valueAnimator.isStarted()) {
            this.mValueAnimator.start();
        }
    }

    public void stopShimmer() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            this.mValueAnimator.cancel();
        }
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        init(context, attributeSet);
    }
}
